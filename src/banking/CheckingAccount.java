package banking;

public class CheckingAccount {
    //TODO: Double check that this one is updated

    int age;
    String name;
    double balance;

    //TODO: Lab 03 default constructor
    public CheckingAccount(){
   //     this(" ", 18, 0.0);
        this(" ",0);
    }

    //TODO: Lab 02 Constructor
    public CheckingAccount(String input){
        String[] parts = input.split(" ");
        String firstName = parts[0];
        String lastName = parts[1];


  //      this.age = Integer.parseInt(parts[2]);
        this.name = firstName + " " + lastName;
        this.balance = Double.parseDouble(parts[2]);
    }

    //TODO: Lab 01
    public CheckingAccount(String name, double balance) {
   //     this.age = 19;
        this.name = name;
        this.balance = balance;
    }

    public CheckingAccount(String name, int age, double balance) {
        this.age = age;
        this.name = name;
        this.balance = balance;

    }

    //methods - functions
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit " + amount + "to" + name);
        }
    }

    public void withdraw (double amount) {
        double totalAmount = amount + 1.0;
        if (totalAmount <= balance) {
            balance -= totalAmount;
            System.out.println("Withdraw " + amount + "from" + name + "(Fee: 1.00");
        }else{
            System.out.println("Insufficient funds");

        }
    }

    public void transfer (CheckingAccount recipient, double amount){
        if (amount +1.00 <= balance) {
            this.withdraw(amount);
            System.out.println("Transferred: " + amount + "to" + recipient.name + "(Fee: 1.00");
        recipient.deposit(amount); }
    }

    public void displayCheckingAccountInfo(){
        System.out.println(name + "Balance:" + String.format("%.2f", balance));
    }

    //accessors == "getters"
    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    //mutators == "setters"
    public void setBalance(double amount) {
        balance = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    //create a toString method to display the information for the update
    @Override
    public String toString() {
        return String.format("Name: %s\nBalance: %.2f\nAge:%d\n", name, balance,age);

    }

}
