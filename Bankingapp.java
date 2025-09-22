import java.util.Scanner;

class account {
    // declaring variables
    int accountNumber;
    String accountHolderName;
    double balance;
    String email;
    String phoneNumber;

    // static variable for auto increment of account number 
    static int nextAccountNumber = 45251;

    // declaring methods
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposit successful");
            System.out.println(" New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdrawal successful");
            System.out.println(" New Balance: " + balance);
        } else {
            System.out.println("insufficient balance in your account, please try again");
        }
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }

    void updateContactDetails(String newEmail, String newNumber) {
        email = newEmail;
        phoneNumber = newNumber;
        System.out.println("Contact details updated successsfully ");
    }
}

public class Bankingapp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    account[] accounts = new account[100];
        int count = 0;

        int choice = 0;
        while (choice != 6) {
            System.out.println(" Welcome to STANDARD CHARTERED Banking Application ");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                account acc = new account();

                acc.accountNumber = account.nextAccountNumber;
                account.nextAccountNumber++; // increment for next account

                System.out.print("Enter name: ");
                acc.accountHolderName = sc.nextLine();
                System.out.print("Enter initial deposit: ");
                acc.balance = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter email: ");
                  acc.email = sc.nextLine();
                System.out.print("Enter phone number: ");
                acc.phoneNumber = sc.nextLine();

                accounts[count] = acc;
                count++;
                System.out.println("Account created successfully with Account Number: " + acc.accountNumber);

            } else if (choice == 2) {
                System.out.print("Enter account number: ");
                int accNum = sc.nextInt();
                System.out.print("Enter amount to deposit: ");
                double amt = sc.nextDouble();

                for (int i = 0; i < count; i++) {
                    if (accounts[i].accountNumber == accNum) {
                        accounts[i].deposit(amt);
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter account number: ");
                int accNum = sc.nextInt();
                System.out.print("Enter amount to withdraw: ");
                double amt = sc.nextDouble();

                for (int i = 0; i < count; i++) {
                    if (accounts[i].accountNumber == accNum) {
                        accounts[i].withdraw(amt);
                    }
                }

            } else if (choice == 4) {
                System.out.print("Enter account number: ");
                int accNum = sc.nextInt();

                for (int i = 0; i < count; i++) {
                    if (accounts[i].accountNumber == accNum) {
                        accounts[i].displayAccountDetails();
                    }
                }

            } else if (choice == 5) {
                System.out.print("Enter account number: ");
                int accNum = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new email: ");
                String newEmail = sc.nextLine();
                System.out.print("Enter new phone number: ");
                String newPhone = sc.nextLine();

                for (int i = 0; i < count; i++) {
                    if (accounts[i].accountNumber == accNum) {
                        accounts[i].updateContactDetails(newEmail, newPhone);
                    }
                }

            } else if (choice == 6) {
                System.out.println("Exiting");

            } else {
                System.out.println("Invalid choice Try again.");
            }
        }
        sc.close();
    }
}
