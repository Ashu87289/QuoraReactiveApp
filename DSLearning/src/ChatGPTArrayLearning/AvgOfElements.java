package ChatGPTArrayLearning;

public class AvgOfElements {
    public static void main(String[] args) {
        int[] arr = {2, 8, 3, 7, 1};
        int n = arr.length;
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        double avg = (double) sum / n;
        System.out.println(avg);
    }
}
