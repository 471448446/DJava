package learn.j18.stream;

import common.Utils;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Stream stream = Stream.empty();
        Utils.log("empty Stream count() ", stream.count());
        String[] a = new String[]{"a", "b", "c"};
        Collection<String> list = Arrays.asList(a);
        stream = list.stream();
        stream = Stream.of(a);
        stream = Arrays.stream(a);
        stream = Arrays.stream(a, 1, 2);
        stream = Stream.<String>builder().add("a").add("b").build();
        Utils.log("generate()");
        Stream.generate(() -> "Hello").limit(4).forEach(Utils::log);
        Utils.log("iterate()");
        Stream.iterate(40, integer -> integer + 2).limit(4).forEach(Utils::log);
        Utils.log("Primitive IntStream");
        IntStream.range(1, 4).forEach(Utils::log);
        IntStream.rangeClosed(1, 4).forEach(Utils::log);
        new Random().ints(3).forEach(Utils::log);
        Utils.log("String Stream ", "abc");
        "abc".chars().forEach(Utils::log);
        Utils.log("String Stream ", "a,b,c");
        Pattern.compile(",").splitAsStream("a,b,c").forEach(Utils::log);

        // 其实数据是位置1，2
        int[] originNums = new int[]{1, 3, 4, 0, 10, 2};
        Utils.log("reduce 1", "input", Utils.toString(originNums));
        OptionalInt result = Arrays.stream(originNums).reduce((left, right) -> {
            Utils.log("reduce 1", "left:" + left, "right:" + right);
            return left + right;
        });
        Utils.log("reduce 1", result.getAsInt());
        //起始数据是位置1，默认值是identity
        Utils.log("reduce 2", "input", Utils.toString(originNums));
        int r = Arrays.stream(originNums).reduce(10, (left, right) -> {
            Utils.log("reduce 2", "left:" + left, "right:" + right);
            return left + right;
        });
        Utils.log("reduce 2", r);
    }
}
