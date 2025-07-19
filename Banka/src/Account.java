import java.util.ArrayList;
import java.util.List;


abstract class Account {
    private static int nextID = 1;
    private List<String> transactions;
    

    public int ID;
    private int balance;
    

    public  Account(int balance) {
        this.ID = nextID++;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public int getBalance() {
        return balance;
    }

   public void deposit(int amount) {
        balance += amount;
        String transaction = amount + " TL deposited to Account ID " + ID;
        transactions.add(transaction);
        System.out.println(transaction);
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            String transaction = amount + " TL withdrawn from Account ID " + ID;
            transactions.add(transaction);
            System.out.println(transaction);
            return true;
        } else {
            System.out.println("Insufficient balance in Account ID " + ID);
            return false;
        }
    }
    
      
      

    public abstract double getBenefit();{

   
}
      public void showLastTransactions() {
        int numTransactionsToShow = Math.min(5, transactions.size());
        System.out.println("Last " + numTransactionsToShow + " transactions for Account ID " + ID + ":");

        for (int i = transactions.size() - 1; i >= transactions.size() - numTransactionsToShow; i--) {
            System.out.println(transactions.get(i));
        }
    }

    int getPoints() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


class ShortTermAccount extends Account {
    private static final int MIN_BALANCE = 1000;
    private static final double INTEREST_RATE = 0.17;

    public ShortTermAccount(int balance) {
        super(balance);
    }

    @Override
    public double getBenefit() {
        return getBalance() * INTEREST_RATE / 365;
    }
}
}