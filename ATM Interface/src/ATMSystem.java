import java.util.Scanner;
import java.io.*;

//for data collection
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew ₹" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public double checkBalance() {
        return balance;
    }
}
//interface
class ATM {
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("\nEnter your name : ");
        String username = scan.nextLine();

        while (true) {
            System.out.println("\nDear " + username + ", please select a transaction:");
            System.out.println("\n--- Automated Teller Machine ---");
            System.out.println("1. Deposit Cash");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. View Account Balance");
            System.out.println("4. Exit");
            
            System.out.print("Enter your choice:");
            
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scan.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scan.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: ₹" + account.checkBalance());
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you "+username);
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
//main
public class ATMSystem {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000); // Initial balance ₹5000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}