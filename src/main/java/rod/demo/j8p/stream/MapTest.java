package rod.demo.j8p.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTest {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> myList2 = Arrays.asList(11,12,13);
        List<Id> IdList = myList.stream().map(x -> Id.builder().id(x).name("Name:Test").build()).collect(Collectors.toList());

        Stream.of(myList,myList2).flatMap(s-> s.stream().map(x -> "A"+x +"\t")).forEach(System.out::print);


    }
}
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Id{
    Integer id;
    String name;
}
