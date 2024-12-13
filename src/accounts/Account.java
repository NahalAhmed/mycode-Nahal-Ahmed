package accounts;

//TODO: Please note that "TODO" will list hints you can use to finish project
public class Account implements Comparable<Account> {
    //TODO: encapsulated data
    private int         accountNumber;                  //01
    private int         routingNumber;                  //02
    private String      accountNickname;                //03
    private double      currentBalance;                 //04
    private Transaction currentTransaction;             //05
    private Date        dateOpened;                     //06
    private Date        nextStatementDate;              //07
    private String      accountType;                    //08
    private Owner       accountOwner;                   //09
    private String      earlyDirectDeposit;             //10
    private String      overdraftTransfer;              //11
    private String      overdraftProtection;            //12

    //TODO: Create a constructor that builds all of the data for you
    public Account(int accountNumber, int routingNumber, String accountNickname,
                   double currentBalance, Transaction currentTransaction, Date dateOpened,
                   Date nextStatementDate, String accountType,Owner accountOwner, String earlyDirectDeposit,
                   String overdraftTransfer, String overdraftProtection){
        this(new Builder()
                .setAccountNumber(accountNumber)
                .setRoutingNumber(routingNumber)
                .setAccountNickname(accountNickname)
                .setCurrentBalance(currentBalance)
                .setEarlyDirectDeposit(earlyDirectDeposit)
                .setOverdraftTransfer(overdraftTransfer)
                .setOverdraftProtection(overdraftProtection)
                .setAccountType(accountType)
                .setDateOpened(dateOpened)
                .setNextStatementDate(nextStatementDate)
                .setAccountOwner(accountOwner)
                .setCurrentTransaction(currentTransaction)
        );
    }






    public Account(Builder builder) {

        accountNumber       = builder.accountNumber;
        routingNumber       = builder.routingNumber;
        accountNickname     = builder.accountNickname;
        currentBalance      = builder.currentBalance;
        currentTransaction  = builder.currentTransaction;
        dateOpened          = builder.dateOpened;
        nextStatementDate   = builder.nextStatementDate;
        accountType         = builder.accountType;
        accountOwner        = builder.accountOwner;
        earlyDirectDeposit  = builder.earlyDirectDeposit;
        overdraftTransfer   = builder.overdraftTransfer;
        overdraftProtection = builder.overdraftProtection;

    }

    //TODO:Only create accessors and mutators that you will use in the program

    public void deposit(double amount) {
        //TODO: Update as in design document
        if ((amount - 1.00)> 0) {
            currentBalance += amount;
        }
    }

     public String toFile() {
        String accountInfo = "" + accountNumber + ",";
        accountInfo += routingNumber + ",";
        accountInfo += accountNickname + ",";
        accountInfo += currentBalance + ",";
        accountInfo += currentTransaction + ",";
        accountInfo += nextStatementDate + ",";
        accountInfo += dateOpened + ",";
        accountInfo += accountType + ",";
        accountInfo += accountOwner + ",";
        accountInfo += earlyDirectDeposit + ",";
        accountInfo += overdraftTransfer + ",";
        accountInfo += overdraftProtection;
        return accountInfo;

    }

    public void withdraw(double amount) {
        //TODO: Update as in design document
        if (currentBalance-(amount + 1.00)> 0) {
            currentBalance -= (amount + 1.00);
        }
    }
    @Override
    public int compareTo(Account other) {
        if (this.accountNumber < other.accountNumber) {
            return -1;
        } else if (this.accountNumber > other.accountNumber) {
            return 1;
        } else {
            return 0;
        }
    }
    @Override
    public boolean equals(Object obj){
       if (!(obj instanceof Account)){
           return false;
       }
       Account other = (Account) obj;
       return this.accountNumber == other.accountNumber && this.routingNumber == other.routingNumber
               && this.accountNickname.equals(other.accountNickname) && this.currentBalance == other.currentBalance
               && this.currentTransaction.equals(other.currentTransaction) && this.dateOpened.equals(other.dateOpened)
               && this.nextStatementDate.equals(other.nextStatementDate) && this.accountType.equals(other.accountType)
               && this.earlyDirectDeposit.equals(other.earlyDirectDeposit)
               && this.overdraftTransfer.equals(other.overdraftTransfer);
    }
    //TODO: Example of a Data Map
    @Override
    public String toString() {

        String 			dashLine 	= "---------------------------------------------";
        StringBuilder 	builder 	= new StringBuilder(dashLine + "\n");
        int 		  	size 		= 12;
        DataMap[]	  	column	    = new DataMap[size];
        column[0] 		= new DataMap("Account Number:       \t"  , String.format("%d", accountNumber));
        column[1] 		= new DataMap("Routing Number:       \t"  , String.format("%d", routingNumber));
        column[2] 		= new DataMap("Account Nickname:     \t"	, accountNickname);
        column[3] 		= new DataMap("Current Balance:      \t"  , String.format("%.2f", currentBalance));
        column[6] 		= new DataMap("\nTransaction:        \t"	, currentTransaction.toString());
        column[4] 		= new DataMap("Date Opened:          \t"	, dateOpened.toString());
        column[5] 		= new DataMap("Next Statement Date:  \t"  , nextStatementDate.toString());
        column[7] 		= new DataMap("Account Type:         \t"	, accountType);
        column[8] 		= new DataMap("Account Owner:        \t"	, accountOwner.toString());
        column[9] 		= new DataMap("Early Direct Deposit: \t"  , earlyDirectDeposit);
        column[10] 		= new DataMap("Over Draft Transfer:  \t"	, overdraftTransfer);
        column[11] 	    = new DataMap("Over Draft Protection:\t"  , overdraftProtection);

        for (int i = 0; i < size; i++) {
            builder.append(String.format("%-18s %-4s \n", column[i].name, column[i].value));
        }
        builder.append("\n").append(dashLine);
        return builder.toString();

    }

    //TODO:Used to create a patter to build out the outer class
    public static class Builder{
        private int         accountNumber;                  //01
        private int         routingNumber;                  //02
        private String      accountNickname;                //03
        private double      currentBalance;                 //04
        private Transaction currentTransaction;             //05
        private Date        dateOpened;                     //06
        private Date        nextStatementDate;              //07
        private String      accountType;                    //08
        private Owner       accountOwner;                   //09
        private String      earlyDirectDeposit;             //10
        private String      overdraftTransfer;              //11
        private String      overdraftProtection;            //12


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

        public Builder setNextStatementDate(Date nextStatementDate){
            this.nextStatementDate = nextStatementDate;
            return this;
        }

        public Builder setNextStatementDate(String nextStatementDate){
            this.nextStatementDate = new Date(nextStatementDate);
            return this;
        }

        public Builder setDateOpened(Date dateOpened){
            this.dateOpened = dateOpened;
            return this;
        }

        public Builder setDateOpened(String dateOpened){
            this.dateOpened = new Date(dateOpened);
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

        public Account build(){
            return new Account(this);
        }

    }

}
