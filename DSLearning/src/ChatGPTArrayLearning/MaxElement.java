package ChatGPTArrayLearning;

public class MaxElement {
    public static void main(String[] args) {
        int[] arr = {3,7,2,9,4};
        int maxValue = arr[0];
        if(arr.length == 1){
            System.out.println(maxValue);
        }
        for(int i =1;i<arr.length;i++){
            if(arr[i] > maxValue){
                maxValue = arr[i];
            }
        }
        System.out.println(maxValue);
    }
}
