import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;



class Bank {
    private List<Account> accounts;
    private int sortitionCount;
    public void setSystemDate(Date date) {
        Date currentDate = date;
    }
     public void setDefaultSystemDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.MAY, 5); // 05 May 2023
        Date currentDate = calendar.getTime();
    }

    public Bank() {
        accounts = new ArrayList<>();
        sortitionCount = 0;
        
    }

    public void createShortTermAccount(int balance) {
        if (balance >= ShortTermAccount.MIN_BALANCE) {
            Account account = new ShortTermAccount(balance);
            accounts.add(account);
            System.out.println("ShortTermAccount created. Account ID: " + account.getID());
        } else {
            System.out.println("Minimum balance requirement not met for ShortTermAccount.");
        }
    }

    public void createLongTermAccount(int balance) {
        if (balance >= LongTermAccount.MIN_BALANCE) {
            Account account = new LongTermAccount(balance);
            accounts.add(account);
            System.out.println("LongTermAccount created. Account ID: " + account.getID());
        } else {
            System.out.println("Minimum balance requirement not met for LongTermAccount.");
        }
    }

    public void createSpecialAccount(int balance) {
        Account account = new SpecialAccount(balance);
        accounts.add(account);
        System.out.println("SpecialAccount created. Account ID: " + account.getID());
    }

    public void createCurrentAccount(int balance) {
        Account account = new CurrentAccount(balance);
        accounts.add(account);
        System.out.println("CurrentAccount created. Account ID: " + account.getID());
    }

    public void deposit(int accountID, int amount) {
        Account account = findAccount(accountID);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found with ID " + accountID);
        }
    }

    public void withdraw(int accountID, int amount) {
        Account account = findAccount(accountID);
        if (account != null) {
            boolean success = account.withdraw(amount);
            if (success) {
                System.out.println(amount + " TL withdrawn from Account ID " + accountID);
            } else {
                System.out.println("Withdrawal failed for Account ID " + accountID);
            }
        } else {
            System.out.println("Account not found with ID " + accountID);
        }
    }

    public void showAccount(int accountID) {
        Account account = findAccount(accountID);
        if (account != null) {
            System.out.println("Account ID: " + account.getID());
            System.out.println("Balance: " + account.getBalance() + " TL");
            System.out.println("Benefit: " + account.getBenefit() + " TL per day");
            account.showLastTransactions();
        } else {
            System.out.println("Account not found with ID " + accountID);
        }
    }

    public void showAllAccounts() {
        if(!accounts.isEmpty())
        {
        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getID());
            System.out.println("Balance: " + account.getBalance() + " TL");
            System.out.println("Benefit: " + account.getBenefit() + " TL per day");
            account.showLastTransactions();
            System.out.println("--------------------");
        }
    }
    
    else
		{
			System.out.println("No accounts to view..");
		}
    
    
    }
 
    private Account findAccount(int accountID) {
        for (Account account : accounts) {
            if (account.getID() == accountID) {
                return account;
            }
        }
        return null;
    }
     public void performSortition() {
        ArrayList<SpecialAccount> eligibleAccounts = new ArrayList<>();
        
        // Find eligible accounts for sortition
        for (Account account : accounts) {
            if (account instanceof SpecialAccount) {
                SpecialAccount specialAccount = (SpecialAccount) account;
                int points = specialAccount.getBalance() / 2000;
                if (points > 0) {
                    for (int i = 0; i < points; i++) {
                        eligibleAccounts.add(specialAccount);
                    }
                }
            }
        }
        
        if (eligibleAccounts.isEmpty()) {
            System.out.println("No eligible accounts found for sortition.");
            return;
        }
         // Perform sortition
        Collections.shuffle(eligibleAccounts);
        Random random = new Random();
        int winningIndex = random.nextInt(eligibleAccounts.size());
        SpecialAccount winningAccount = eligibleAccounts.get(winningIndex);
        
        // Award prize
        int prizeAmount = 10000;
        winningAccount.deposit(prizeAmount);
        
        System.out.println("Sortition performed.");
        System.out.println("Winning Account: " + winningAccount.getID());
        System.out.println("Prize Amount: " + prizeAmount + " TL");
        
        sortitionCount++;
        System.out.println("Total Sortitions: " + sortitionCount);
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
