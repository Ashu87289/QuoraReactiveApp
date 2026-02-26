package ChatGPTArrayLearning;

import java.util.Arrays;

import static com.ashu.TwoPointer.RemoveDuplicates.swap;

public class MovesAllZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        int n = arr.length;

        int pos = 0;
        for(int i = 0;i<n;i++){
            if(arr[i] != 0){
                swap(arr,i,pos);
                pos++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
