package com.ashu.Java8Streams;

import java.util.Arrays;
import java.util.List;

public class SumOfList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(81,2,3,2,4,5,6,7);

        Integer listSum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(listSum);
    }
}
