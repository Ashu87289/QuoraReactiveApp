package ChatGPTArrayLearning;

import java.util.HashMap;

public class CountOfSubarray {
    public static void main(String[] args) {
        int[] arr = {1, -1, 5, -2, 3};
        int K = 3;
        int res = countSubarray(arr,K);
        System.out.println(res);
    }

    private static int countSubarray(int[] arr, int k) {
        int n = arr.length;
        int prefixSum = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            prefixSum += arr[i];

            if(prefixSum == k){
                count++;
            }
            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0) + 1);
        }
        return count;
    }
}
