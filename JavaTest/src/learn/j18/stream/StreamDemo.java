package learn.j18.stream;

import common.Utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
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
    }
}
