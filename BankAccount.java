import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
 class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Thank you for using the ATM");
                System.exit(0);
            default:
                System.out.println("Invalid option");
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + account.getBalance());
    }

    public void deposit() {
        System.out.print("Enter deposit amount:");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful");
    }

    public void withdraw() {
        System.out.print("Enter withdrawal amount:");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); 
        ATM atm = new ATM(userAccount);
        while (true) {
            atm.displayMenu();
            System.out.print("Enter option: ");
            int option = atm.scanner.nextInt();
            atm.processOption(option);
        }
    }
}
