package ChatGPTArrayLearning;

import java.util.HashMap;

public class FindLongestSubarray {
    public static void main(String[] args) {
        int[] arr = {1, -1, 5, -2, 3};
        int K = 3;
        int res = longestSubarray(arr, K);
        System.out.println(res);
    }

    private static int longestSubarray(int[] arr, int k) {
        int prefixSum = 0;
        int n = arr.length;
        int maxArray = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if(prefixSum == k){
                maxArray = Math.max(maxArray,i + 1);
            }
            if(map.containsKey(prefixSum - k)){
                maxArray = Math.max(maxArray,i - map.get(prefixSum - k));
            }
            if(!map.containsKey(prefixSum - k)){
                map.put(prefixSum,i);
            }
        }
        return maxArray;
    }
}
