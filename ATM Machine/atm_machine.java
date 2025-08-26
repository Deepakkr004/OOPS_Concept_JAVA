import java.util.Scanner;


class ATM{
    int PIN = 12345;
    float balance;

    public void checkpin(){
        System.out.print("Enter your PIN: ");
        Scanner sc = new Scanner (System.in);
        int pin = sc.nextInt();

        if (pin == PIN){
            Menu();
        }
        else{
            System.out.println("Enter a valid PIN");
            checkpin();
        }
        sc.close();

    }

    public void Menu(){
        System.out.println("Enter Your Choice : ");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposite Money");
        System.out.println("4. Exit");

        Scanner sc = new Scanner (System.in);
        int choice = sc.nextInt();

        if (choice == 1){
            CheckBalance();
        }
        else if (choice == 2){
            WithdrawMoney();
        }
        else if (choice == 3){
            DepositeMoney();
        }
        else if (choice == 4){
            return;
        }
        else{
            System.out.println("Enter a valid Choice.");
        }
    }

    public void CheckBalance(){
        System.out.println("Balance: "+ balance);
        Menu();
    }

    public void WithdrawMoney(){
        System.out.println("Enter amount to withdraw: ");
        Scanner sc = new Scanner (System.in);
        float amount = sc.nextFloat();
        if (amount > balance){
            System.out.println("Insufficient balance.");
        }
        else{
            balance = balance - amount;
            System.out.println("Money withdrawl Successful");
        }
        Menu();
        sc.close();
    }

    public void DepositeMoney(){
        System.out.println("Enter amount: ");
        Scanner sc = new Scanner (System.in);
        float amount = sc.nextFloat();
        balance = balance + amount;
        System.out.println("Money Deposited Successfully!");
        Menu();
        sc.close();
    }
}


public class atm_machine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkpin();
    }
}