package ChatGPTArrayLearning;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {3,1,2,5,6,7,8};
        int n = arr.length;
        int start = 0,end = n-1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
