package banking;

//TODO: Double check that this one is updated
public class CheckingAccount {
    //data fields
    String name;
    double balance;

    //constructor - this is the only way to make objects
    public CheckingAccount(String input){
        String[] parts = input.split(" ");
        name = parts[0];
        balance = Double.parseDouble(parts[1]);
    }

    public CheckingAccount(String name, double balance) {
        this.name    = name;
        this.balance = balance;
    }

    //methods - functions
    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }

    //accessors == "getters"
    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }


    //mutators == "setters"
    public void setBalance(double amount) {
        balance = amount;

    }

    public void setName(String newName) {
        name = newName;
    }

    //create a toString method to display the information for the update
    @Override
    public String toString() {
        return String.format("Name: %s\nBalance: %.2f\n", name, balance);
    }
}
