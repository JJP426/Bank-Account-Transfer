import java.util.Scanner;

public class BankAccount {
    private String name;
    private String password;
    private double balance;

    public BankAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
}

// getter for the balance instance variable
public double getBal(String enteredPassword) {
    if (password.equals(enteredPassword)) {
        return balance;
    } else {
        return -1;
    }
}

// setter for the password instance variable
public boolean setPass(String oldPassword, String newPassword) {
    if (password.equals(oldPassword)) {
        password = newPassword;
        return true;
    } else {
        return false;
    }
}

    // Method to withdraw from a BankAccount
    public void withdraw(String enteredPassword, double amount) {
        // Only withdraw if the password is correct and there are sufficient funds
        if (password.equals(enteredPassword) && balance >= amount) {
            balance = balance - amount;
        }
    }

    // Method to deposit into a BankAccount
    public void deposit(String enteredPassword, double amount) {
        // Must have the correct password
        if (password.equals(enteredPassword)) {
            balance = balance + amount;
        }
    }

    public void transfer(BankAccount other, String enteredPassword, double amount) {
        // 1. Check that enteredPassword matches
        if (this.password.equals(enteredPassword) && this.balance >= amount) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter your other account's password: ");
            String otherPasswordinput = s.nextLine();
            
            //Confirm if other password is correct and initiate transfer
            if(other.password.equals(otherPasswordinput)) {
                this.withdraw(enteredPassword, amount);
                other.deposit(otherPasswordinput, amount);
                System.out.println("Transfer made.");

            }
            else {
                System.out.println("Incorrect password. Transfer failed.");

            }

        }
      }

    public static void main(String[] args) {
        // Demonstrate string comparison with the '==' operator
        BankAccount myAcc = new BankAccount("Java", "java1234!", 238.57);
        BankAccount otherAcc = new BankAccount("Python", "Python4321!", 61.43);

        // 1. Instantiate Scanner
        Scanner s = new Scanner(System.in);

        // Print a prompt to the user
        System.out.println("Enter your password:");

        // 2. Read user input
        String input = s.nextLine();
        
        myAcc.transfer(otherAcc, input, 38.57);     // Other code works when this is commented out...

        System.out.println("Java balance: " + myAcc.getBal(input));
        System.out.println("Python balance: " + otherAcc.getBal("Python4321!"));

    
}

}



