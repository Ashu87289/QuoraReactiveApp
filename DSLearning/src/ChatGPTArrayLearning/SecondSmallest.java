package ChatGPTArrayLearning;

public class SecondSmallest {
    public static void main(String[] args) {
        int[] arr = {3,7,2,9,4};
        int res1 = secSmallestValue(arr);
        System.out.println(res1);
    }

    private static int secSmallestValue(int[] arr) {
        int smallest = arr[0];
        int secSmallest =  Integer.MAX_VALUE;
        int n = arr.length;
        if(n == 1){
            System.out.println("NO Second Samllest found in the array.");
        }
        for(int i = 1;i<n;i++){
            if(smallest > arr[i]){
                secSmallest = smallest;
                smallest = arr[i];
            }else if(arr[i] > smallest && arr[i] < secSmallest){
                secSmallest = arr[i];
            }
        }
        return secSmallest;
    }
}
