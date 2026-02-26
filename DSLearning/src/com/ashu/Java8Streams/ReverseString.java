package com.ashu.Java8Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Mogambo khush hua";

        String res = Arrays.stream(str.split(" ")).
                collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            return String.join(" ",list);
                        }
                ));

        System.out.println(res);
    }

}
