package accounts;

public class Transaction {
    String  senderAccount;
    String  receiverAccount;
    double  transactionAmount;
    Date    transactionDate;
    Time    transactionTime;

    public Transaction(){
        //TODO: Update with a default plan
    }

    //TODO: Note this has been updated to help find account easier
    public Transaction(String sender, String receiver, double amount, Date date, Time time){
        senderAccount       = sender;
        receiverAccount     = receiver;
        transactionAmount   = amount;
        transactionDate     = date;
        transactionTime     = time;
    }

    //TODO: This overrides the definition of the Object class
    @Override
    public String toString() {
        return "";
    }
}
