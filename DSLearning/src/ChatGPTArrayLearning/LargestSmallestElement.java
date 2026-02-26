package ChatGPTArrayLearning;

public class LargestSmallestElement {
    public static void main(String[] args) {
        int[] arr = {3,7,2,9,4};
        minMaxElement(arr);
    }

    private static void minMaxElement(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int n = arr.length;
        if(n == 1) {
            min = arr[0];
            max = arr[0];
        }
        for(int i = 1;i < n;i++){
            if(arr[i] < min){
                min = arr[i];
            }else if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Min value : " + min + " Max Value : " + max);
    }
}
