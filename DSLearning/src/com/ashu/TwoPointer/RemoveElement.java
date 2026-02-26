package com.ashu.TwoPointer;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int[] arr = removeElement(nums,val);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0,right = 0;
        while(right < n){
            if(nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return Arrays.copyOf(nums,left);
    }
}
