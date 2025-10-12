import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        int attempt =0;
        int guess =0;
        System.out.println("Choose a number between 1 - 100");
        while(guess != randomNumber){
            attempt++;
            guess=sc.nextInt();
            if (guess>randomNumber){
                System.out.println("Too high");
            } else if (guess<randomNumber) {
                System.out.println("Too low");
            }else {
                System.out.println("Congratulations you found it and total attempts : " + attempt);
            }
        }
        sc.close();
    }
}
