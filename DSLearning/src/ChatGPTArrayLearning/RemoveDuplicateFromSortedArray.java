package ChatGPTArrayLearning;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3};
        int n = arr.length;

        int j = 0;
        for(int i = 1;i < n;i++){
            if(arr[i] != arr[j]){
                j++;
                arr[j] = arr[i];
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(arr,j+1)));
    }
}
