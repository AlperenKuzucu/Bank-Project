
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
         Calendar calendar = Calendar.getInstance();
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter initial balance: ");
                    int shortTermBalance = scanner.nextInt();
                    bank.createShortTermAccount(shortTermBalance);
                    break;
                case 2:
                    System.out.print("Enter initial balance: ");
                    int longTermBalance = scanner.nextInt();
                    bank.createLongTermAccount(longTermBalance);
                    break;
                case 3:
                    System.out.print("Enter initial balance: ");
                    int specialBalance = scanner.nextInt();
                    bank.createSpecialAccount(specialBalance);
                    break;
                case 4:
                    System.out.print("Enter initial balance: ");
                    int currentBalance = scanner.nextInt();
                    bank.createCurrentAccount(currentBalance);
                    break;
                case 5:
                    
                    System.out.print("Enter account ID: ");
                    int depositID = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    bank.deposit(depositID, depositAmount);
                    break;
                case 6:
                    System.out.print("Enter account ID: ");
                    int withdrawID = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    bank.withdraw(withdrawID, withdrawAmount);
                    break;
                case 7:
                    bank.setDefaultSystemDate();
                    System.out.println("System date set to 05 May 2023.");   
                    Date date = calendar.getTime();
                    System.out.println(date);
                    break;
                case 8:                   
                    System.out.print("Enter account ID: ");
                    int accountID = scanner.nextInt();
                    bank.showAccount(accountID);
                    break;
                case 9:
                    bank.showAllAccounts();
                    break;
                case 10 :
                    bank.performSortition();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }
        
        scanner.close();
    }

    public static void printMenu() {
        System.out.println("***Bank Menu***");
        System.out.println("1. Create Short-Term Account");
        System.out.println("2. Create Long-Term Account");
        System.out.println("3. Create Special Account");
        System.out.println("4. Create Current Account");
        System.out.println("5. Deposit to an Account");
        System.out.println("6. Withdraw from an Account");
        System.out.println("7. Set System Date");
        System.out.println("8. Show Account Details");
        System.out.println("9. Show All Accounts");
        System.out.println("10. Perform Sortition");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    
   
}
