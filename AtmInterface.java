import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("Welcome to the ATM!");
        System.out.println("Please select an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.print("Enter the withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                if (account.getBalance() >= withdrawalAmount) {
                    account.withdraw(withdrawalAmount);
                    System.out.println("Please collect your cash. Your new balance is: $" + account.getBalance());
                } else {
                    System.out.println("Insufficient funds. Your current balance is: $" + account.getBalance());
                }
                break;
            case 2:
                System.out.print("Enter the deposit amount: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Your deposit was successful. Your new balance is: $" + account.getBalance());
                break;
            case 3:
                System.out.println("Your current balance is: $" + account.getBalance());
                break;
            case 4:
                System.out.println("Thank you for using the ATM.Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        ATM atm = new ATM(account);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayOptions();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.processOption(choice);

            if (choice == 4) {
                break;
            }
        }
    }
}