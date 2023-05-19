package org.example;

import javax.swing.plaf.InsetsUIResource;
import java.util.*;

import java.util.function.Predicate;

public class Main {
    public static int totalValue(List<Integer> values,Predicate<Integer> selector){
        return values.stream()
                .filter(selector)
                .mapToInt(e -> e)
                .sum();
    }
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(totalValue(numbers, e -> true));
        System.out.println(totalValue(numbers, e -> e%2 == 0));
        System.out.println(totalValue(numbers, e -> e%2 != 0));

    }
}