package ChatGptDSALearning;

public class CountDigit {
    public static void main(String[] args) {
        int n = 0;

        if(n == 0){
            System.out.println(1);
            return;
        }
        int count = 0;
        while (n > 0){
            n = n/10;
            count = count+1;
        }
        System.out.println(count);
    }
}
