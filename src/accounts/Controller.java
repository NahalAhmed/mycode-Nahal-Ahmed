package accounts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    static String csvFileHeader = "Account Number," +
            "Routing Number," +
            "Account Nickname," +
            "Current Balance," +
            "Transaction Sender," +
            "Transaction Receiver," +
            "Transaction Amount," +
            "Transaction Date," +
            "Transaction Time," +
            "Date Opened," +
            "Next Satement Date,"+
            "Account Type," +
            "Owner Name," +
            "Owner Age," +
            "Early Direct Deposit?," +
            "OverDraft Transfer?," +
            "OverDraft Protection";

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("*****************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t  B   A  N  K  I  N  G     P   R   O   G   R  A   M");
        System.out.println();
        System.out.println(" \t    S    T    A    R    T    I    N    G");
        System.out.println();
        System.out.println("*****************************************************");
        System.out.println();
        System.out.println();
    }


    //TODO: Use the columns of your csv file to populate your "Accounts list"
    private static Account parse(String fileLine) throws IllegalArgumentException {
        String[]  fileColumns   = fileLine.split(",");
        String[]  column	    = new String[17];

        //TODO: copy data into larger array to fix issues with splitting
        for (int i = 0; i < fileColumns.length; i++) {
            column[i] = fileColumns[i];
        }

        //TODO: pad null values at the end if columns are empty
        if(fileColumns.length < column.length) {
            for (int i = fileColumns.length; i < column.length; i++) {
                column[i] = "";
            }
        }

        //TODO : Update the data with the values in the CSV file
        int         accountNumber       = Integer.parseInt(column[0]);
        int         routingNumber       = Integer.parseInt(column[1]);

        String      accountNickName     = column[2];
        double      currentBalance      = column[3].equals("") ? 0.0 : Double.parseDouble(column[3]);

        Transaction currentTransaction  = new Transaction();
        String      nextStatementDate   = column[10];

        String      dateOpened          = column[9];
        String      accountType         = column[11];

        Owner       accountOwner        = new Owner();
        String      earlyDirectDeposit  = column[14];

        String      overdraftTransfer   = column[15];
        String      overdraftProtection = column[16];


        //TODO: return Account object using the builder pattern
        return new Account.Builder()
                .setAccountNumber(accountNumber)
                .setRoutingNumber(routingNumber)
                .setAccountNickname(accountNickName)
                .setCurrentBalance(currentBalance)
                .setDateOpened(dateOpened)
                .setNextStatementDate(nextStatementDate)
                .setAccountType(accountType)
                .setEarlyDirectDeposit(earlyDirectDeposit)
                .setOverdraftTransfer(overdraftTransfer)
                .setOverdraftProtection(overdraftProtection)
                .setAccountOwner(accountOwner)
                .setCurrentTransaction(currentTransaction)
                .build();



    }


    public static void read(List<Account> list, String inputLocation) throws FileNotFoundException {
        File file	    = new File(inputLocation);
        Scanner input	= new Scanner(file);


        //TODO: read in Account data and table header
        input.nextLine();
        while(input.hasNextLine()) {
            //TODO: create a Account object

            Account newAccount = parse(input.nextLine());
            if (list.contains(newAccount)) {
                list.remove(newAccount);
            }
            list.add(newAccount);



            //TODO: check for duplicates and remove from list

        }

        input.close();
    }

    public static void writeInOrder(List<Account> list, String outputLocation) throws FileNotFoundException {
        String 		csvLocation	= outputLocation + File.separator + "_accounts.csv";
        String 		txtLocation	= outputLocation + File.separator + "_accounts.txt";
        File   		csvFile		= new File(csvLocation);
        File   		txtFile		= new File(txtLocation);
        PrintStream csvStream 	= new PrintStream(csvFile);
        PrintStream txtStream 	= new PrintStream(txtFile);

        //TODO: sort in order into a separate output file.
        if(csvFile.exists() && txtFile.exists()) {
            csvStream.println(csvFileHeader);
            for (int i = 0; i < list.size(); i++) {
                csvStream.println(list.get(i).toFile());
                txtStream.println(list.get(i));
            }
        }

        csvStream.close();
        txtStream.close();
    }

    public static void writeTransactionsInOrder(List<Account> list, String outputLocation) throws FileNotFoundException{

        String 		csvLocation	= outputLocation + File.separator + "_transactions.csv";
        String 		txtLocation	= outputLocation + File.separator + "_transactions.txt";
        File   		csvFile		= new File(csvLocation);
        File   		txtFile		= new File(txtLocation);
        PrintStream csvStream 	= new PrintStream(csvFile);
        PrintStream txtStream 	= new PrintStream(txtFile);

        Transaction  accountTransaction;
        Account	  account;

        //TODO: get Account data with Transaction name.
        if(csvFile.exists() && txtFile.exists()) {
            csvStream.println(csvFileHeader);

        }

        csvStream.close();
        txtStream.close();

    }


    public static void main(String[] args) throws FileNotFoundException {
        //TODO: set up input and output file locations
        String outputLocation  = "." + File.separator + "data";

        String inputLocation   = "." + File.separator + "data"
                                     + File.separator + "accounts.csv";


        //TODO: Create an arraylist of Accounts
        Month someMonth = Month.NOV;
        System.out.println(someMonth);

        //TODO: Test account builder Example
        Account someAccount = new Account.Builder()
                                         .setAccountNumber(1138013)
                                         .setRoutingNumber(2204559)
                                         .setAccountNickname("My Checking")
                                         .setCurrentBalance(1350.0)
                                         .setDateOpened("8-Jul-22")
                                         .setNextStatementDate("19-Dec-24")
                                         .setAccountType("Checking")
                                         .setEarlyDirectDeposit("Yes")
                                         .setOverdraftTransfer("Yes")
                                         .setOverdraftProtection("Yes")
                                         .build();

        System.out.println(someAccount);
        System.out.println();

        //TODO: print intro to console
        intro();

        //TODO: set up list for data entry
       List<Account> list     = new ArrayList<>();

        //TODO: set locations to read in the accounts file
        read(list,inputLocation);


        //TODO: set locations to write data
        writeInOrder(list, outputLocation);
//        writeTransactionsInOrder(list, outputLocation);

        System.out.println();

    }

}