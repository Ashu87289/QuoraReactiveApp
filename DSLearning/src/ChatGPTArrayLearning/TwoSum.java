package ChatGPTArrayLearning;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 11};
        int target = 10;
        System.out.println(Arrays.toString(twoSum(arr,target)));
    }

    public static int[] twoSum(int[] arr, int target) {
        // pointer initialization here
        int n = arr.length;
        int left = 0,right = n-1;
        while(left < right){
            int currSum = arr[left] + arr[right];
            if(currSum == target){
                return new int[]{arr[left],arr[right]}; // If index is asked then return only left, right
            } else if (currSum > target) {
                right--;
            }else {
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}
