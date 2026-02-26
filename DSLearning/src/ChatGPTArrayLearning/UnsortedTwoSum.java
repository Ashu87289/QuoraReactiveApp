package ChatGPTArrayLearning;

import java.util.Arrays;
import java.util.HashMap;

public class UnsortedTwoSum {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 7};
        int target = 6;
        System.out.println(Arrays.toString(unsortedTwosum(arr, target)));
    }


    /*Key Idea of this question
    * Check first the complement which is target - arr[i]( current element ) if not present add otherwise if get return.*/
    private static int[] unsortedTwosum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int complement = target - arr[i];  //
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
}
