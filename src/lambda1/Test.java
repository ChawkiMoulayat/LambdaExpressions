package lambda1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<String> listString = Arrays.asList("Volvo", "Mercedes", "Volkswagen", "Audi");
        List<Integer> listInt = Arrays.asList(1, 2, 3, 4);

        //noneMatch
        boolean noStratWithA = true;
        for (String c : listString) {
            if (c.startsWith("A")){
                noStratWithA = false;
            }
        }

        boolean noStartWithA2 = listString.stream().noneMatch( c-> c.startsWith("A"));

        //allMatch
        boolean allV = true;
        for (String c : listString) {
            if (!c.startsWith("V")){
                allV = false;
            }
        }

        boolean allv2 = listString.stream().allMatch(c -> c.startsWith("V"));

        //anyMatch
        boolean exist = false;
        for (String c : listString) {
            if (c.length() >= 10){
                exist = true;
                break;
            }
        }
        boolean exist2 = listString.stream().anyMatch( c -> c.length() >= 10);

        //reduce
        int total = 1;
        for (Integer number : listInt) {
            total = number * total;
        }
        int total2 = listInt.stream().reduce(0, (a, b) -> a-b); // a is the accumulator at first ( 0 )

        // forEach
        for (String car : listString ){
            System.out.println(car);
        }
        listString.forEach(System.out::println);


        // Filter
        List<String> listV2 = new ArrayList<>();
        for (String car : listString) {
            if ( car.startsWith("V")){
                listV2.add(car);
            }
        }

        List<String> listV = listString.stream().filter(car -> car.startsWith("V")).toList();

        // Map
        List<Integer> lengths = new ArrayList<>();
        for (String car : listString) {
            lengths.add(car.length());
        }

        List<Integer> lengths2 = listString.stream().map(String::length).toList();
    }
}

