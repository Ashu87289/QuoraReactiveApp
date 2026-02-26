package com.ashu.Java8Streams;

import java.util.*;

public class TopKFreqWords {
    public static void main(String[] args) {
        String[] str = {"i","love","leetcode","i","love","coding"};
        //int n = str.length;
        int k = 2;

      /*  List<String> topK = Arrays.stream(str).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .sorted((e1,e2)->{
                    int freqCompare = Long.compare(e2.getValue(),e1.getValue());
                    if(freqCompare != 0){
                        return freqCompare;
                    }
                    return e1.getKey().compareTo(e2.getKey());
                })
                .limit(k).map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(topK);*/


        System.out.println(topKElements(str,k));
    }

    private static List<String> topKElements(String[] words, int k) {
        int n = words.length;
        HashMap<String,Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word,0)+ 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(!map.get(a).equals(map.get(b))){
                return map.get(a) - map.get(b);
            }
            return b.compareTo(a);
        });
        for(String word : map.keySet()){
            pq.offer(word);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
