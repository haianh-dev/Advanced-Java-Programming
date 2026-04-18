package Bai6.code;

class Transaction {
    private final String transactionId;
    private final String amount;
    private final String timestamp;

    public Transaction(String transactionId, String amount, String timestamp) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
    }
}

public class Account {
    private String accountId;
    private double balance;
    private Transaction[] history;
    private int transactionCount;

    public Account(String accountId, double balance, int maxTransactions) {
        this.accountId = accountId;
        this.balance = balance;
        this.history = new Transaction[maxTransactions];
        this.transactionCount = 0;
    }

    public void addTransaction(Transaction t) {
        if (this.history.length > this.transactionCount ) {
            this.history[transactionCount] = t;
            this.transactionCount ++;
        } else {
            System.out.println("[Loi] Giao dich da day, khong the cap nhat them!");
        }
    }

    public Transaction[] getHistory() {
        Transaction[] CopyHistory = new Transaction[this.transactionCount];
        for (int i = 0; i < this.transactionCount; i++) {
            CopyHistory[i] = this.history[i];
        }
        return CopyHistory;
    }

    public static void main(String[] args) {
        Transaction t1 = new Transaction("1000", "34000", "2026-03-10T22:12:50Z");
        Transaction t2 = new Transaction("1001", "35000", "2026-03-10T22:13:50Z");
        Transaction t3 = new Transaction("1002", "36000", "2026-03-10T22:14:50Z");

        Account MyAccount = new Account("25020020", 5000000, 1000);
        MyAccount.addTransaction(t1);
        MyAccount.addTransaction(t2);
        MyAccount.addTransaction(t3);

        Transaction[] LichSuGiaoDich = MyAccount.getHistory();
        LichSuGiaoDich[0] = null;
        System.out.println("Hacker da xoa 01 giao dich o ban sao chep!");

        Transaction[] LichSuGoc = MyAccount.getHistory();
        if (LichSuGoc[0] != null) {
            System.out.println("Bao mat he thong thanh cong!");
        } else {
            System.out.println("Hacker da hack he thong thanh cong!");
        }
    }
}