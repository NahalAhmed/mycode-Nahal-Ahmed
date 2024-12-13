package accounts;

import java.util.Comparator;
import java.util.Objects;

//TODO: Please note that "TODO" will list hints you can use to finish project
public class Account implements Comparable<Account>{
    //TODO: encapsulated data
    private final int         accountNumber;                  //01
    private final int         routingNumber;                  //02
    private final String      accountNickname;                //03
    private double            currentBalance;                 //04
    private final Transaction currentTransaction;             //05
    private final Date        dateOpened;                     //06
    private final Date        nextStatementDate;              //07
    private final String      accountType;                    //08
    private final Owner       accountOwner;                   //09
    private final String      earlyDirectDeposit;             //10
    private final String      overdraftTransfer;              //11
    private final String      overdraftProtection;            //12

    //TODO: Create a constructor that builders all of the data for you

    public Account(Builder builder) {
        this.accountNumber       = builder.accountNumber;
        this.routingNumber       = builder.routingNumber;
        this.accountNickname     = builder.accountNickname;
        this.currentBalance      = builder.currentBalance;
        this.currentTransaction  = builder.currentTransaction;
        this.dateOpened          = builder.dateOpened;
        this.nextStatementDate   = builder.nextStatementDate;
        this.accountType         = builder.accountType;
        this.accountOwner        = builder.accountOwner;
        this.earlyDirectDeposit  = builder.earlyDirectDeposit;
        this.overdraftTransfer   = builder.overdraftTransfer;
        this.overdraftProtection = builder.overdraftProtection;
    }

    //TODO: This is "delegating" comparing two Account objects to a Comparator
    @Override
    public int compareTo(Account other) {
        return Comparator.comparing(Account::getName)
                         .thenComparing(Account::getAge)
                         .thenComparing(Account::getCurrentBalance)
                         .compare(this, other);
    }

    //TODO:Only create accessors and mutators that you will use in the program
    public int getAge(){
        return accountOwner.getAge();
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public String getName(){
        return accountOwner.getName();
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.currentBalance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.currentBalance - amount >= 0) {
            this.currentBalance -= amount + 1.0; // $1 transaction fee
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account other) {

            return  Objects.equals(accountNumber        , other.accountNumber)         &&
                    Objects.equals(routingNumber        , other.routingNumber)         &&
                    Objects.equals(currentBalance       , other.currentBalance)        &&
                    Objects.equals(accountNickname      , other.accountNickname)       &&
                    Objects.equals(earlyDirectDeposit   , other.earlyDirectDeposit)    &&
                    Objects.equals(overdraftTransfer    , other.overdraftTransfer)     &&
                    Objects.equals(overdraftProtection  , other.overdraftProtection)   &&
                    Objects.equals(accountType          , other.accountType)           &&
                    Objects.equals(accountOwner         , other.accountOwner)          &&
                    Objects.equals(currentTransaction   , other.currentTransaction);
        }
        return false;

    }

    //TODO:Create the data to write to the CSC File
    public String toFile(){
        return String.join(","  , String.valueOf(accountNumber)
                                        , String.valueOf(routingNumber)
                                        , accountNickname
                                        , String.valueOf(currentBalance)
                                        , currentTransaction.toFile()
                                        , dateOpened.toString()
                                        , nextStatementDate.toString()
                                        , accountType
                                        , accountOwner.toFile()
                                        , earlyDirectDeposit
                                        , overdraftTransfer
                                        , overdraftProtection

        );
    }

    //TODO: Example of a Data Map
    @Override
    public String toString() {

        String 			dashLine 	= "---------------------------------------------";
        StringBuilder 	builder 	= new StringBuilder(dashLine + "\n");
        DataMap[]	  	column	    = new DataMap[12];
        column[0] 		= new DataMap("Account Number:       \t"  , String.format("%d", accountNumber));
        column[1] 		= new DataMap("Routing Number:       \t"  , String.format("%d", routingNumber));
        column[2] 		= new DataMap("Account Nickname:     \t"	, accountNickname);
        column[3] 		= new DataMap("Current Balance:      \t"  , String.format("%.2f", currentBalance));
        column[4] 		= new DataMap("\nTransaction:        \t"	, currentTransaction.toString());
        column[5] 		= new DataMap("Date Opened:          \t"	, dateOpened.toString());
        column[6] 		= new DataMap("Next Statement Date:  \t"  , nextStatementDate.toString());
        column[7] 		= new DataMap("Account Type:         \t"	, accountType);
        column[8] 		= new DataMap("Account Owner:        \t"	, accountOwner.toString());
        column[9] 		= new DataMap("Early Direct Deposit: \t"  , earlyDirectDeposit);
        column[10] 		= new DataMap("Over Draft Transfer:  \t"	, overdraftTransfer);
        column[11] 	    = new DataMap("Over Draft Protection:\t"  , overdraftProtection);

        for (DataMap map : column) {
            builder.append(String.format("%-18s %-4s \n", map.name, map.value));
        }
        builder.append("\n").append(dashLine);
        return builder.toString();

    }

    //TODO:Used to create a patter to build out the outer class
    public static class Builder{
        int         accountNumber;
        int         routingNumber;
        String      accountNickname;
        double      currentBalance;
        Transaction currentTransaction;
        Date        nextStatementDate;
        Date        dateOpened;
        String      accountType;
        Owner       accountOwner;
        String      earlyDirectDeposit;
        String      overdraftTransfer;
        String      overdraftProtection;

        //TODO: Create default /"zero equivalent" values for your data fields
        Builder(){
            accountNumber       = 11300000;
            routingNumber       = 101000;
            accountNickname     = "My Checking";
            currentBalance      = 0.0;
            currentTransaction  = new Transaction();
            nextStatementDate   = new Date();
            dateOpened          = new Date();
            accountType         = "Checking";
            accountOwner        = new Owner("No Name", 21);
            earlyDirectDeposit  = "No";
            overdraftTransfer   = "No";
            overdraftProtection = "No";
        }


        //TODO: Create mutators that allow for modifying data
        public Builder setAccountNumber(int accountNumber){
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setRoutingNumber(int routingNumber){
            this.routingNumber = routingNumber;
            return this;
        }

        public Builder setAccountNickname(String accountNickname){
            this.accountNickname = accountNickname;
            return this;
        }

        public Builder setCurrentBalance(double currentBalance){
            this.currentBalance = currentBalance;
            return this;
        }

        public Builder setCurrentTransaction(Transaction currentTransaction){
            this.currentTransaction = currentTransaction;
            return this;
        }

        public Builder setCurrentTransaction(String currentTransaction){
            this.currentTransaction = new Transaction(currentTransaction);
            return this;
        }

        public Builder setDateOpened(Date dateOpened){
            this.dateOpened = dateOpened;
            return this;
        }

        public Builder setDateOpened(String  dateOpened){
            this.dateOpened = new Date(dateOpened);
            return this;
        }

        public Builder setNextStatementDate(Date nextStatementDate){
            this.nextStatementDate = nextStatementDate;
            return this;
        }

        public Builder setNextStatementDate(String nextStatementDate){
            this.nextStatementDate = new Date(nextStatementDate);
            return this;
        }

        public Builder setAccountType(String accountType){
            this.accountType = accountType;
            return this;
        }

        public Builder setAccountOwner(Owner accountOwner){
            this.accountOwner = accountOwner;
            return this;
        }

        public Builder setAccountOwner(String accountOwner){
            this.accountOwner = new Owner(accountOwner);
            return this;
        }

        public Builder setEarlyDirectDeposit(String earlyDirectDeposit){
            this.earlyDirectDeposit = earlyDirectDeposit;
            return this;
        }

        public Builder setOverdraftTransfer(String overdraftTransfer){
            this.overdraftTransfer = overdraftTransfer;
            return this;
        }

        public Builder setOverdraftProtection(String overdraftProtection){
            this.overdraftProtection = overdraftProtection;
            return this;
        }

        public Account build(){
            return new Account(this);
        }
    }
    
}
