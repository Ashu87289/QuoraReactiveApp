package ChatGptDSALearning;

public class PalindromicNumber {
    public static void main(String[] args) {
        int n = 1221;
        int org = n;
        int rev = 0;
        if(n < 0){
            System.out.println(false);
            return;
        }
        while(n > 0){
            int digit = n %10;
            rev = rev*10 + digit;
            n = n/10;
        }
        if(rev == org) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
