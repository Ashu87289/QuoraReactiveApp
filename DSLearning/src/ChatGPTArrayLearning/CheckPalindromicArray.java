package ChatGPTArrayLearning;

public class CheckPalindromicArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,1};
        int n = arr.length;
        boolean isPlaindrome = true;
        int left = 0,right= n-1;
        while (left < right){
            if(arr[left] != arr[right]){
                isPlaindrome = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println(isPlaindrome);
    }
}
