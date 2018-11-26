package rod.demo.j8p.stream;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterTest {

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sumValue = myList.stream().filter(value -> value > 4 && value <=10  ).reduce((value, accur) -> accur += value).get();
        System.out.println(sumValue);
        Assert.isTrue(45 == sumValue,"It's not possible");

        boolean allMatch = myList.parallelStream().allMatch(s -> s > 0);
        System.out.println("all list value are positive number");

        boolean noneMatch = myList.stream().noneMatch(s -> s < 0);
        System.out.println("all list value is not negative number");


        //unless to call terminal operation, the stream won't do anything
        myList.stream().filter(x-> {
            System.out.println("you won't see me"+x);
            return x > 3;
        });

    }
}
