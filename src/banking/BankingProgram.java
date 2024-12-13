package banking;

import java.util.Scanner;

public class BankingProgram {

    //TODO: LAB 01
    public static void main(String[] args) {
        //references are alan, barbara and carl
        CheckingAccount alan = new CheckingAccount("Alan", 1300);
        CheckingAccount barbara = new CheckingAccount("Barbara", 850);
        CheckingAccount carl = new CheckingAccount("Carl", 500);

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
        String name = keyboard.next();
        System.out.println(name);
        double balance = keyboard.nextDouble();
        System.out.println(balance);

        CheckingAccount checkingAccount = new CheckingAccount(name, balance);
        System.out.println(checkingAccount);
        keyboard.nextLine();

        // LAB 03

        {

            // part a
            System.out.println("Lab 3 Part A");
            CheckingAccount defaultAccount = new CheckingAccount();
            System.out.println(defaultAccount);


            // part b
            System.out.println("Lab 3 Part B");
            System.out.println("Please Enter Your first name, last name, age and balance: ");
            System.out.println("Example: Duncan Mcleod 21 2000");
            String inputString2 = keyboard.nextLine();
            System.out.println(inputString2);
            CheckingAccount checkingAccount2 = new CheckingAccount(inputString2);
            System.out.println(checkingAccount2);




            // part c

            System.out.println("Lab 3 Part C");
            alan = new CheckingAccount("Alan Richfield", 19,  1300.00);
            CheckingAccount duncan = new CheckingAccount("Duncan Mcleod", 21, 200.00);

            duncan.transfer(alan, 400.00);
            duncan.displayInfo();
            alan.displayInfo();

            //part f
            System.out.println("Lab 3 part f");
            duncan.displayCheckingAccountInfo();


        }
    }
}