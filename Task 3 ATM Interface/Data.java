public class Data {
    public static void main(String[] args) { 
 Bank Bank = new Bank();
        ATM atm = new ATM(Bank);
        atm.start();
    }
}