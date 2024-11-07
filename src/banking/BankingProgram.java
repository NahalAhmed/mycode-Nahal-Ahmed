package banking;

import java.util.Scanner;

public class BankingProgram {

    //TODO: Double check that this one is updated
    public static void main(String[] args) {
        //references are alan, barbara and carl
        CheckingAccount alan    = new CheckingAccount("Alan", 1300);
        CheckingAccount barbara = new CheckingAccount("Barbara", 850);
        CheckingAccount carl    = new CheckingAccount("Carl", 500);

        //FIXME: This is a security issue
        System.out.println();
        System.out.println();

        System.out.println(alan);
        System.out.println(barbara);
        System.out.println(carl);

        //TODO: Collect from keyboard
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name and balance: ");
        String inputString = keyboard.nextLine();
        CheckingAccount checkingAccount = new CheckingAccount(inputString);
        System.out.println(checkingAccount);

    }
}
