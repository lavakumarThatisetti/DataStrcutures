package Java8Features.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamsDemo {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2,1,6,8);
        List<Integer> evenNumbers = number.stream().filter(integer -> integer%2==0).collect(Collectors.toList());
        List<Integer> cubeRoots = number.stream().map(integer -> integer*integer*integer).collect(Collectors.toList());

        System.out.println(evenNumbers);
        System.out.println(cubeRoots);
        List<String> names = Arrays.asList("Reflection","Collection","Stream");
        List<String> result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
        System.out.println(result);
        List<Integer> sortedArray =  number.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedArray);
        number.stream().map(integer -> integer*integer).forEach(System.out::println);

        int even = number.stream().filter(x->x%2==0).reduce(0, Integer::sum);
        System.out.println(even);

    }

}
