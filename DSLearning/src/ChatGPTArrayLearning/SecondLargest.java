package ChatGPTArrayLearning;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {3,7,2,9,4};
        int res1 = secLargestValue(arr);
        System.out.println(res1);
    }

    private static int secLargestValue(int[] arr) {
        int largest = arr[0];
        int secLargest = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i = 1;i<n;i++){
            if(arr[i] > largest){
                secLargest = largest;
                largest = arr[i];
            } else if(arr[i] < largest && arr[i] > secLargest) {
                secLargest = arr[i];
            }
        }
        return secLargest;
    }
}
