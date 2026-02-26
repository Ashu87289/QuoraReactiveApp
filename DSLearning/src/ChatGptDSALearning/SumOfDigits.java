package ChatGptDSALearning;

public class SumOfDigits {
    public static void main(String[] args) {
        int n = 48273;
        if(n == 0){
            System.out.println(0);
            return;
        }
        int sum = 0;
        while(n > 0){
            int digit = n %10;
            sum = sum + digit;
            n = n /10;
        }
        System.out.println(sum);
    }
}
