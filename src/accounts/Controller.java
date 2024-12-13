package accounts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Controller {

    static String csvFileHeader;

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
    private static Account parse(String lineOfFile) throws IllegalArgumentException {
        String[]    lineItems	= lineOfFile.split(",");
        String[]	column	    = new String[17];

        //TODO: copy data into larger array to fix issues with splitting
        for (int i = 0; i < lineItems.length; i++) {
            column[i] = lineItems[i];
        }

        //TODO: pad null values at the end if columns are empty
        if(lineItems.length < column.length) {
            for (int i = lineItems.length; i < column.length; i++) {
                column[i] = "";
            }
        }

        //TODO : Update the data with the values in the CSV file
        int         accountNumber       = Integer.parseInt(column[0]);
        int         routingNumber       = Integer.parseInt(column[1]);
        String      accountNickName     = column[2];
        double      currentBalance      = column[3].isEmpty() ? 0.0 : Double.parseDouble(column[3]);

        String      tranSender          = column[4];
        String      tranReceiver        = column[5];
        double      tranAmount          = column[6].isEmpty() ? 0.0 : Double.parseDouble(column[6]);
        Date        tranDate            = new Date(column[7]);
        Time        tranTime            = new Time(column[8]);
        Transaction currentTransaction  = new Transaction(tranSender, tranReceiver, tranAmount, tranDate, tranTime);

        Date        dateOpened          = new Date(column[9]);
        Date        nextStatementDate   = new Date(column[10]);
        String      accountType         = column[11];

        String      ownerName           = column[12];
        int         ownerAge            = column[13].isEmpty() ? 0 : Integer.parseInt(column[13]);
        Owner       accountOwner        = new Owner(ownerName, ownerAge);

        String      earlyDirectDeposit  = column[14];
        String      overdraftTransfer   = column[15];
        String      overdraftProtection = column[16];

        //TODO: return Account object using the builder pattern
        return new Account.Builder()
                            .setAccountNumber(accountNumber)
                            .setRoutingNumber(routingNumber)
                            .setAccountNickname(accountNickName)
                            .setCurrentBalance(currentBalance)
                            .setCurrentTransaction(currentTransaction)
                            .setAccountType(accountType)
                            .setAccountOwner(accountOwner)
                            .setEarlyDirectDeposit(earlyDirectDeposit)
                            .setOverdraftTransfer(overdraftTransfer)
                            .setDateOpened(dateOpened)
                            .setNextStatementDate(nextStatementDate)
                            .setOverdraftProtection(overdraftProtection)
                            .build();

    }


    public static void read(List<Account> list, String inputLocation) throws FileNotFoundException {
        File file	    = new File(inputLocation);
        Scanner input	= new Scanner(file);

        if (input.hasNextLine()) {
            csvFileHeader = input.nextLine();
        }
        //TODO: read in Account data and table header
        while(input.hasNextLine()) {
            //TODO: create a Account object
            Account account = parse(input.nextLine());

            //TODO: check for duplicates and remove from list
            if (!list.contains(account)) {
                list.add(account);
            }
        }

        input.close();
    }

    //TODO: Update this to test on screen
    public static void transfer(Account from, Account to, double amount) {
        from.withdraw(amount);
        //TODO: Formatted print out of transaction
        to.deposit(amount);
    }

    public static void writeInOrder(List<Account> list, String outputLocation) throws FileNotFoundException {
        String 		csvLocation	= outputLocation + File.separator + "ordered_accounts.csv";
        String 		txtLocation	= outputLocation + File.separator + "ordered_accounts.txt";
        File   		csvFile		= new File(csvLocation);
        File   		txtFile		= new File(txtLocation);
        PrintStream csvStream 	= new PrintStream(csvFile);
        PrintStream txtStream 	= new PrintStream(txtFile);

        //TODO: sort in order into a separate output file.
        Collections.sort(list);

        if (csvFile.exists() && txtFile.exists()) {
            csvStream.println(csvFileHeader);
            for (int i = 0; i < list.size(); i++) {
                csvStream.println(list.get(i).toFile());
                txtStream.println(list.get(i).toString());
            }
        }

        csvStream.close();
        txtStream.close();
    }

    public static void writeTransactionsInOrder(List<Account> list, String outputLocation) throws FileNotFoundException{

        String 		csvLocation	= outputLocation + File.separator + "ordered_transactions.csv";
        String 		txtLocation	= outputLocation + File.separator + "ordered_transactions.txt";
        File   		csvFile		= new File(csvLocation);
        File   		txtFile		= new File(txtLocation);
        PrintStream csvStream 	= new PrintStream(csvFile);
        PrintStream txtStream 	= new PrintStream(txtFile);

        // TODO: Get all the transactions


        // TODO: Sort the transactions


        // TODO: Write accounts based on sorted transactions
        if(csvFile.exists() && txtFile.exists()) {
            csvStream.println(csvFileHeader);

            //TODO: Write account transactions in order.

        }

        csvStream.close();
        txtStream.close();

    }


    public static void main(String[] args) throws FileNotFoundException {
        //TODO: set up input and output file locations
        String outputLocation  = "." + File.separator + "data";

        String inputLocation   = "." + File.separator + "data"
                + File.separator + "accounts.csv";


        System.out.println();
        //TODO: print intro to console
        intro();

        //TODO: Create an arraylist of Accounts
        //TODO: set up list for data entry
        List<Account> list     = new ArrayList<>();

        //TODO: set locations to read in the accounts file
        read(list,inputLocation);


        //TODO: set locations to write data
        writeInOrder(list, outputLocation);
        writeTransactionsInOrder(list, outputLocation);

        System.out.println("Processing complete!");


        Account account1 = new Account.Builder()
                .setAccountNumber(1138013)
                .setRoutingNumber(2204559)
                .setAccountNickname("My Checking")
                .setCurrentBalance(2000)
                .setCurrentTransaction("113701:15493626,112900:13352392,1316.72,2-Nov-24,15:43")
                .setDateOpened("8-Jul-22")
                .setNextStatementDate("19-Dec-24")
                .setAccountType("Checking")
                .setAccountOwner("Charles Stevens,35")
                .setEarlyDirectDeposit("Yes")
                .setOverdraftTransfer("Yes")
                .setOverdraftProtection("Yes")
                .build();

        Account account2 = new Account.Builder()
                .setAccountNumber(1138013)
                .setRoutingNumber(2204559)
                .setAccountNickname("My Checking")
                .setCurrentBalance(1000)
                .setCurrentTransaction("113701:15493626,112900:13352392,1316.72,2-Nov-24,15:43")
                .setDateOpened("8-Jul-22")
                .setNextStatementDate("19-Dec-24")
                .setAccountType("Checking")
                .setAccountOwner("Chuck Taylor,28")
                .setEarlyDirectDeposit("Yes")
                .setOverdraftTransfer("Yes")
                .setOverdraftProtection("Yes")
                .build();

        System.out.println(account1);
        System.out.println(account2);
        System.out.println();
        transfer(account1, account2,450);
        System.out.println(account1);
        System.out.println(account2);
        System.out.println();

    }

}