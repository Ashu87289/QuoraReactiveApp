package ChatGPTArrayLearning;

public class CountEvenNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6};
        int count = 0;
        int n = arr.length;
        for(int i =0;i<n;i++){
            if(arr[i] % 2 == 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
