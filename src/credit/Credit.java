package credit;

import java.util.Scanner;

public class Credit {

    public static long getOddSum(long cardNumber){
        long digit = 0;
        int position = 0;
        long oddSum = 0;
        while(cardNumber > 0) {
            //odd position ko number kasari chinne?
            digit = cardNumber % 10;
            if (position % 2 != 0) {
                // if position is odd, digit lai 2 le multiply
                // and find their sum [two digit sum aaye xha vane
                // tyo number ko digit ko sum nikalnu parni hunxa]
                long digitProduct = digit * 2;
                while (digitProduct > 0) {
                    oddSum = oddSum + digitProduct % 10;
                    digitProduct = digitProduct / 10;
                }
            }
            cardNumber = cardNumber/10;
            position++;
        }
        return oddSum;
    }
    public static long getEvenSum(long cardNumber){
            long digit = 0;
            int position = 0;
            long evenSum = 0;
            while(cardNumber > 0) {
                //odd position ko number kasari chinne?
                digit = cardNumber % 10;
                if (position % 2 == 0) {
                    evenSum = evenSum + digit;
                }
                cardNumber = cardNumber/10;
                position++;
            }
            return evenSum;
    }
    public static boolean isValidCard(long evenSum, long oddSum){
                // need to find the sum of evensum and oddsum
        return  (evenSum + oddSum) % 10 == 0;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning){
            System.out.println("Enter card number: ");
            //paxadi bata digit haru kasari lyaune?
            // 4003600000000014
            long cardNumber = input.nextLong();
            long evenSum = getEvenSum(cardNumber);
            long oddSum = getOddSum(cardNumber);

            // Add validation for minimum card number length
            if (String.valueOf(cardNumber).length() > 13) {
                if(isValidCard(evenSum, oddSum)){
                    System.out.println("Valid Card");
                }else{
                    System.out.println("Invalid Card");
                }
            }else{
                System.out.println("Invalid Card");
            }

            
            while(true){
                // only allow given options
                // prevent negative numbers
                // -> give: Invalid option message. Please choose 1 or 0.
                System.out.println("Test another card?? (1 for yes/0 for no)");
                int option = input.nextInt();
                if(option < 0 || option > 1){
                    System.out.println("Invalid option message. Please choose 1 or 0.");
                }else{
                    if(option == 0){
                        isRunning = false;
                        break;
                    }else{
                        break;
                    }
                }
            }
        }
    }
}
