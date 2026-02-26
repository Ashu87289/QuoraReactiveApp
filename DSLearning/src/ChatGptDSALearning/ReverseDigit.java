package ChatGptDSALearning;

public class ReverseDigit {
    public static void main(String[] args) {
        int n = 482754;
        if(n == 0) {
            System.out.println(0);
            return;
        }
        int rev = 0;
        while( n > 0){
            int digit = n % 10;
            rev = rev*10 + digit;
            n = n /10;
        }
        System.out.println(rev);
    }
}
