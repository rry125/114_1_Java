// 帳戶類別，包含基本存提款功能
public class Account {
    private String ownerName; // 帳戶持有人姓名
    private static int accountCount = 0; // 帳戶總數
    private String accountNumber; // 帳戶號碼
    private double balance; // 帳戶餘額


    /**
     * 建構子，初始化帳戶號碼與餘額
     * @param accountNumber 帳戶號碼
     * @param initialBalance 初始餘額
     */
    public Account(String accountNumber,String owenerName,double initialBalance) {
        this.setAccountNumber(accountNumber);
        this.ownerName = owenerName;
        try{
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤：" + e.getMessage() +  "，餘額設為零。");
        }
        accountCount++;
    }

    public static int getAccountCount() {
        return accountCount;
    }


    /**
     * 取得帳戶號碼
     * @return 帳戶號碼
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 取得帳戶餘額
     * @return 帳戶餘額
     */
    public double getBalance() {
        return balance;
    }

    public  String getOwnerName() {
        return ownerName;
    }
    /**
     * 存款
     * @param amount 存款金額，必須大於零
     */
   public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("存款金額必須大於零。");
        }
    }

    /**
     * 提款
     * @param amount 提款金額，必須大於零且不超過餘額
     * @throws IllegalArgumentException 當金額無效或超過餘額時丟出
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("提款金額無效或超過餘額。");
       }
    }
}
