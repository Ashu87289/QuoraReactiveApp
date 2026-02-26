package ChatGPTArrayLearning;

public class MinElement {
    public static void main(String[] args) {
        int[] arr = {3,7,2,9,4};
        int minValue = arr[0];
        int n = arr.length;
        if(n == 1){
            System.out.println(minValue);
        }
        for(int i = 1;i<n;i++){
            if(arr[i] < minValue){
                minValue = arr[i];
            }
        }
        System.out.println(minValue);
    }
}
