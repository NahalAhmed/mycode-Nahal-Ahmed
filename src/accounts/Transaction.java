package accounts;

import java.util.Comparator;
import java.util.Objects;

public class Transaction implements Comparable<Transaction>{
    String  senderAccount;
    String  receiverAccount;
    double  transactionAmount;
    Date    transactionDate;
    Time    transactionTime;


    public Transaction() {
        this.senderAccount      = "";
        this.receiverAccount    = "";
        this.transactionAmount  = 0.0;
        this.transactionDate    = new Date();
        this.transactionTime    = new Time();
    }

    public Transaction(String transaction) {
        String[] splitTransaction = transaction.split(",");
        this.senderAccount = splitTransaction[0];
        this.receiverAccount = splitTransaction[1];
        this.transactionAmount = Double.parseDouble(splitTransaction[2]);
        this.transactionDate = new Date(splitTransaction[3]);
        this.transactionTime = new Time(splitTransaction[4]);
    }

    public Transaction(String sender, String receiver, double amount, Date date, Time time) {
        this.senderAccount = sender;
        this.receiverAccount = receiver;
        this.transactionAmount = amount;
        this.transactionDate = date;
        this.transactionTime = time;
    }

    @Override
    public int compareTo(Transaction other) {
        return Comparator.comparing(Transaction::getTransactionDate)
                         .thenComparing(Transaction::getTransactionTime)
                         .compare(this, other);
    }

    //TODO: "method references" used to compare data
    public Date getTransactionDate() {
        return transactionDate; // Ensure this field exists in the Transaction class
    }

    public Time getTransactionTime() {
        return transactionTime; // Ensure this field exists in the Transaction class
    }

    //TODO: from writeTransactions in Controller Class description
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Transaction other) {
            return     Objects.equals(senderAccount     , other.senderAccount)
                    && Objects.equals(receiverAccount   , other.receiverAccount)
                    && Objects.equals(transactionAmount , other.transactionAmount)
                    && Objects.equals(transactionDate   , other.transactionDate)
                    && Objects.equals(transactionTime   , other.transactionTime);
        }
        return false;
    }

    public String toFile() {
        return String.join(","  , senderAccount
                                        , receiverAccount
                                        , String.format("%.2f", transactionAmount)
                                        , transactionDate.toString()
                                        , transactionTime.toString());
    }

    //TODO: This overrides the definition of the Object class
    @Override
    public String toString() {
        return String.format("Sender: %s, Receiver: %s, Amount: %.2f, Date: %s, Time: %s"   , senderAccount
                                                                                            , receiverAccount
                                                                                            , transactionAmount
                                                                                            , transactionDate
                                                                                            , transactionTime
        );
    }

}
