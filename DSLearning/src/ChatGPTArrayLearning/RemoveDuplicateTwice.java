package ChatGPTArrayLearning;

import java.util.Arrays;

public class RemoveDuplicateTwice {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,4,4,4,};
        int n = arr.length;
        int j = 0;

        for(int i = 0;i<n;i++){
            if(j < 2 || arr[i] != arr[j-2]){
                arr[j] = arr[i];
                j++;
            }
        }
        System.out.println(j);
        System.out.println(Arrays.toString(Arrays.copyOf(arr,j)));
    }
}
