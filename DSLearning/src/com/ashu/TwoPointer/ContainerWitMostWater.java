package com.ashu.TwoPointer;

public class ContainerWitMostWater {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int res = maxArea(nums);
        System.out.println(res);
    }

    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0,right = n-1;
        int minHeight = 0;
        int maxArea = 0;
        int containedWater = 0;
        while(left < right){
            int width = right - left;
            minHeight = Math.min(height[left],height[right]);
            containedWater = width * minHeight;
            maxArea = Math.max(maxArea,containedWater);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
