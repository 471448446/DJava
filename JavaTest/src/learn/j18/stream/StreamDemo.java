package learn.j18.stream;

import common.Utils;
import sun.rmi.runtime.Log;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        create();
        intermediate();
        terminal();
    }

    private static void terminal() {
        Utils.logMethodS("terminal");
        // 统计
        //一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果
        count();
        max();
        min();
        summary();

        // 遍历
        foreach();
        foreachOrder();
        //Reduction of a stream :reduce()、collect()
        reduce();
        collect();

        // short-circuiting
        // match
        allMatch();
        anyMatch();
        noneMatch();
        //find
        findAny();
        findFirst();

        Utils.logMethodE("terminal");
    }


    /**
     * @see #skip()
     * {@link #filter()}
     */
    private static void limit() {
        // 截取前N个值，如果数据源没有N这么长将返回所有的数据源
        // 这个和skip有点相反，skip是跳过前N个，limit是值返回前N个
        Stream.of(1, 2, 3)
                .limit(2)
                .forEach(v -> Utils.log("limit", v));
    }

    private static void findFirst() {
        // 获取第一个元素，如果元素没排序可能返回任意一个元素的Optional
        Optional<Integer> match =
                Stream.of(1, 2, 3)
                        .findFirst();
        Utils.log("findFirst", match.get());
    }

    private static void findAny() {
        // 获取数据源中的任意一个元素
        Optional<Integer> match =
                Stream.of(1, 2, 3)
                        .findAny();
        Utils.log("findAny", match.get());
    }

    private static void noneMatch() {
        // 数据源中是否《都不》满足某个条件
        boolean match =
                Stream.of(1, 2)
                        .noneMatch(integer -> integer % 2 == 0);
        Utils.log("noneMatch", match);
    }

    private static void anyMatch() {
        // 数据源中是否《有任何一个》满足某个条件
        // 可以发现相同的条件anyMatch跟allMatch、noneMatch值是反的，因为他们条接是互斥的。既然有任何一个元素匹配了，那么所有元素匹配和没有元素匹配就是不成功的
        boolean match =
                Stream.of(1, 2)
                        .anyMatch(integer -> integer % 2 == 0);
        Utils.log("anyMatch", match);
    }

    private static void allMatch() {
        // 字面意思任何匹配，
        // 数据源中是否《全部》满足某个条件
        boolean match =
                Stream.of(1, 2)
                        .allMatch(integer -> integer % 2 == 0);
        Utils.log("allMatch", match);
    }

    private static void foreachOrder() {
        // 如果该Stream预先设定了顺序，会按照预先设定的顺序执行（Stream是无序的），默认为元素插入的顺序
        Stream.of(1, 2).forEachOrdered(v -> Utils.log("forEachOrdered", v));
    }

    private static void foreach() {
        //用于遍历Stream中的所元素，避免了使用for循环，让代码更简洁，逻辑更清晰
        Stream.of(1, 2).forEach(v -> Utils.log("foreach", v));
    }

    private static void min() {
        // 求数据源的元素的最小值
        Optional<Integer> o =
                Stream.of(1, 2, 3)
                        .min((o1, o2) -> o1.compareTo(o2));
        Utils.log("min of Stream", o.get());

    }

    private static void summary() {
        // 一次性获取这些统计信息
        IntSummaryStatistics intSummaryStatistics = Stream.of(1, 2).mapToInt(x -> x).summaryStatistics();
        Utils.log("min of Stream", intSummaryStatistics.toString());
    }

    private static void count() {
        // 求数据源的元素个数
        long count =
                Stream.of(1, 2, 3)
                        .count();
        Utils.log("count of Stream", count);
    }

    private static void max() {
        // 求数据源的元素的最大值
        // 这里再max中找最小值
        Optional<Integer> o =
                Stream.of(1, 2, 3)
                        .max(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o2.compareTo(o1);
                            }
                        });
        Utils.log("max of Stream", o.get());
    }

    private static void intermediate() {
        Utils.logMethodS("intermediate");
        // 组合
        contact();
        // 去重
        distinct();
        // 过滤 filter()、skip()
        filter();
        skip();
        limit();
        // 变换
        // map、mapToInt、mapToLong、mapToDouble
        // flatMap,flatMapToInt、flatMapToLong、flatMapToDouble
        map();
        flatMap();
        // 排序
        sort();

        peek();

        Utils.logMethodE("intermediate");
    }

    private static void sort() {
        // 将数据源进行排序
        // 使用默认的equal()进行排序
        Stream.of(2, 1, 3)
                .sorted()
                .forEach(v -> Utils.log("sort 1", v));
        // 自定义排序规则 ,比如反序
        Stream.of(2, 1, 3)
                .sorted((o1, o2) -> o2.compareTo(o1))
                .forEach(v -> Utils.log("sort 2", v));
    }

    /**
     * {@link #limit()}
     * {@link #filter()}
     */
    private static void skip() {
        // 跳过前面两个数据
        // 怎样跳过后面两个？？如果是有序的反序sort，在丢前面的数据
        Stream.of(1, 2, 3)
                .skip(2)
                .forEach(v -> Utils.log("skip", v));
    }

    private static void peek() {
        // peek方法生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），
        // 新Stream每个元素被消费的时候都会执行给定的消费函数，并且消费函数优先执行
        // 让原来的数据再执行一次？？
        Stream.of(1, 2)
                .peek(integer -> Utils.log("peek accept", integer))
                .forEach(v -> Utils.log("peek", v));
    }

    private static void flatMap() {
        // 将数据源转换成Stream
        // 该换转函数的对象是一个Stream，也不会再创建一个新的Stream，而是将原Stream的元素取代为转换的Stream。
        // 暂时没想到有什么用
        Stream.of(1, 2)
                .flatMap(integer -> Stream.of(integer * 10))
                .forEach(v -> Utils.log("flatMap", v));
    }

    private static void map() {
        // 将数据源进行一对一的映射，就是转变成另外一种数据。A->B
        // 为了提高处理效率，官方已封装好了，三种变形：mapToDouble，mapToInt，mapToLong。
        // 如果想将原Stream中的数据类型，转换为double,int或者是long是可以调用相对应的方法。
        Stream.of(1, 2).map((Function<Integer, Object>) integer -> {
            if (1 == integer) {
                return "first";
            } else if (2 == integer) {
                return "second";
            }
            return null;
        }).forEach(v -> Utils.log("map", v));
        Stream.of(1, 2)
                .mapToDouble(value -> Double.parseDouble(String.valueOf(value)))
                .forEach(v -> Utils.log("mapToDouble", v));
    }

    private static void filter() {
        //filter方法对原Stream按照指定条件过滤，在新建的Stream中，只包含满足条件的元素，将不满足条件的元素过滤掉。
        Stream.of(1, 2, 3).filter(integer -> {
            // 只想看到能被2整除的数字
            return integer % 2 == 0;
        }).forEach(v -> Utils.log("filter", v));
    }

    private static void distinct() {
        //distinct方法以达到去除掉原Stream中重复的元素，生成的新Stream中没有没有重复的元素。
        Stream.of(1, 2, 1, 2, 3)
                .distinct()
                .forEach(v -> Utils.log("distinct", v));
    }

    private static void contact() {
        // 将两个数据源结合起来，若两个输入的Stream都是排序的，则新Stream也是排序的；
        // 若输入的Stream中任何一个是并行的，则新的Stream也是并行的；
        // 若关闭新的Stream时，原两个输入的Stream都将执行关闭处理
        Stream.concat(Stream.of(1, 2), Stream.of("a", "b"))
                .forEach(v -> Utils.log("concat", v));
    }

    private static void create() {
        Utils.logMethodS("create");

        String[] a = new String[]{"a", "b", "c"};
        // 从Array、集合中创建
        Collection<String> list = Arrays.asList(a);
        list.stream().forEach(v -> Utils.log("Collection", v));
        Arrays.stream(a).forEach(v -> Utils.log("Arrays.stream", v));
        Arrays.stream(a, 1, 2)
                .forEach(v -> Utils.log("Arrays.stream", v));

        // 利用Stream API创建
        Stream stream = Stream.empty();
        Utils.log("empty Stream count() ", stream.count());
        Stream.of(a).forEach(v -> Utils.log("Stream.of", v));
        Stream.<String>builder().add("a").add("b").build()
                .forEach(v -> Utils.log("Stream.builder", v));
        //使用generate创建无限的流，但是限制了4次，不限制的话就一直发送数据源
        Stream.generate(() -> "Hello").limit(4).forEach(value -> Utils.log("generate", value));
        //使用iterate创建无限的流，但是限制了4次
        Stream.iterate(40, integer -> integer + 2).limit(4).forEach(value -> Utils.log("iterate", value));

        // 创建原始数据,前面的创建都是从一个个对象数据
        Utils.log("Primitive IntStream");
        //[1,4)
        IntStream.range(1, 4).forEach(value -> Utils.log("range: ", value));
        //[1,4]
        IntStream.rangeClosed(1, 4).forEach(value -> Utils.log("rangeClosed: ", value));
        // 从随机数创建
        new Random().ints(3).forEach(value -> Utils.log("Random().ints: ", value));
        // 从字符串创建
        "abc".chars().forEach(value -> Utils.log("String create: ", value));
        Pattern.compile(",").splitAsStream("a,b,c").forEach(value -> Utils.log("String spit create: ", value));

        Utils.logMethodS("create");
    }

    private static void collect() {
        // 自定义结果，将一堆数据安装一定的约束转换成一个最终数据
        // 先准备一组数据源
        List<Phone> phoneList = Arrays.asList(
                new Phone("HW1", 1),
                new Phone("Apple1", 2),
                new Phone("MZ", 3));

        // 1.将数据源转换成集合 Collections、Set、Map
        List<Integer> r =
                Stream.of(1, 2)
                        .collect(Collectors.toList());

        Utils.log("collect toList", r);
        // 2.将数据源组合成字符串
        String s = Stream.of(1, 2, 3).map(String::valueOf).collect(Collectors.joining("_"));
        Utils.log("collect joining", s);
        // 3.求数据源描述值 max、min、sum、avg
        // 平均值 averagingInt averagingDouble averagingLong
        /*
        averagingXX(), summingXX() and summarizingXX()（一起求出max，min，sum，avg）
        可以操作原始数据 int,double,long 也可以操作对象数据Integer Double Long
        值得一提的是这几个方法不需要显示将原始数据像对象数据进行转换，
        summingInt 提示使用mapToInt.sum()来操作，就是先转换到Integer
         */
        double avg = Stream.of(1, 2, 5).collect(Collectors.averagingInt(value -> value));
        Utils.log("collect averagingInt", avg);
        int sum = Stream.of(1, 2, 3).collect(Collectors.summingInt(value -> value));
        Utils.log("collect summingInt", sum);
        IntSummaryStatistics sums = Stream.of(1, 2, 3).collect(Collectors.summarizingInt(value -> value));
        Utils.log("collect summarizingInt", sums);
        // 4. 分组
        // group 数据源分组 partitioningBy 拆分成两组
        // 按照手机价格进行分类
        Map<Double, List<Phone>> phones = phoneList.stream().collect(Collectors.groupingBy(new Function<Phone, Double>() {
            @Override
            public Double apply(Phone phone) {
                // 这里可以进一步区分，比如[1-3]块的一组，[4-8]块的一组，又比如低端机一组，中端机一组，高端机一组
                return phone.price;
            }
        }));
        Utils.log("collect groupingBy", phones);
        // 找出价格大于2的手机列表
        Map<Boolean, List<Phone>> phonePrice2 = phoneList.stream().collect(Collectors.partitioningBy(phone -> phone.price > 2));
        Utils.log("collect partitioningBy", phonePrice2);
        // 不懂
        Set<Phone> set = phoneList.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
        // 自定义
    }

    private static void reduce() {
        // 起始数据是集合的位置1，2
        int[] originNums = new int[]{1, 3, 4, 0, 10, 2};
        Utils.log("reduce 1", "input", Utils.toString(originNums));
        OptionalInt result = Arrays.stream(originNums).reduce((left, right) -> {
            Utils.log("reduce 1", "left:" + left, "right:" + right);
            return left + right;
        });
        Utils.log("reduce 1 result", result.getAsInt());
        //起始数据是集合位置1，默认值是identity
        Utils.log("reduce 2", "input", Utils.toString(originNums));
        int r = Arrays.stream(originNums).reduce(10, (left, right) -> {
            Utils.log("reduce 2", "left:" + left, "right:" + right);
            return left + right;
        });
        Utils.log("reduce 2 result", r);
        ArrayList<Integer> list1 = Stream.of(1, 2, 3, 2).reduce(new ArrayList<>(),
                (integers, integer) -> {
                    integers.add(integer);
                    Utils.log("reduce 3", "BiFunction", integers);
                    return integers;
                },
                (integers, integers2) -> {
                    integers.addAll(integers2);
                    Utils.log("reduce 3", "BinaryOperator", integers);
                    return integers;
                });
        Utils.log("reduce 3 result", list1);
    }

    static class Phone {
        private String name;
        private double price;

        public Phone(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Phone{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
