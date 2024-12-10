package banking;

import java.util.Scanner;

public class BankingProgram {

    //TODO: LAB 01
    public static void main(String[] args) {
        //references are alan, barbara and carl
        CheckingAccount alan    = new CheckingAccount("Alan", 1300);
        CheckingAccount barbara = new CheckingAccount("Barbara", 850);
        CheckingAccount carl    = new CheckingAccount("Carl", 500);

        System.out.println("Account Balance.");
        alan.displayCheckingAccountInfo();
        barbara.displayCheckingAccountInfo();

        carl.displayCheckingAccountInfo();

        System.out.println();
        System.out.println();
        alan.transfer(barbara, 275.00);
        carl.transfer(barbara, 150.00);
        System.out.println();


        System.out.println(alan);
        System.out.println(barbara);
        System.out.println(carl);

        //TODO:LAB 02
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name and balance: ");
        String inputString = keyboard.nextLine();
        System.out.println(inputString);

        CheckingAccount checkingAccount = new CheckingAccount(inputString);
        System.out.println(checkingAccount);

       // LAB 03
        System.out.print("Enter the name, age and balance: ");
        String inputString2 = keyboard.nextLine();
        System.out.println(inputString2);

        String [] parts = inputString2.split(" ");

        String firstname = parts[0];
        String lastname = parts[1];
        int age = Integer.parseInt(parts[2]);
        double balance = Double.parseDouble(parts[3]);

        CheckingAccount checkingAcount = new CheckingAccount(firstname + " " + lastname, age , balance);
        System.out.println(checkingAcount);

    }
}
