// 帳戶類別，包含基本存提款功能
public class Account {
    private double balance; // 帳戶餘額
    private String accountNumber; // 帳戶號碼
    /**
     * 建構子，初始化帳戶號碼與餘額
     * @param accountNumber 帳戶號碼
     * @param initialBalance 初始餘額
     */
    public Account(String accountNumber, double initialBalance) {
//        this.accountNumber = accountNumber;
//        this.balance = initialBalance;
        this.setAccountNumber(accountNumber);
        try {
            this.setBalance(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("初始化餘額錯誤：" + e.getMessage());
            this.balance = 0; // 若初始餘額無效，設為零
        }
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

    /**
     * 設定帳戶號碼
     * @param accountNumber 帳戶號碼
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // 新增 setBalance 方法：驗證不得為負數
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("餘額不能為負數。");
        }
        this.balance = balance;
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

    public void deposit(double amoont, String currency) {
        double exchangeRate = 1.0; // 假設匯率為1.0，實際應根據貨幣類型設定
        switch (currency .toUpperCase()){
            case "USD":
                exchangeRate = 30.0; // 假設1 USD = 30 TWD
                break;
            case "EUR":
                exchangeRate = 35.0; // 假設1 EUR = 35 TWD
                break;
            case "JPY":
                exchangeRate = 0.25; // 假設1 JPY = 0
            // 可根據需要添加更多貨幣類型
            default:
                System.out.println("不支援的貨幣類型。");
        }
    }

    public void deposit(double ... amounts) {
        double total = 0;
        for (double amount : amounts) {
            if (amount >= 0){
                total += amount;
            }
            else
                throw new IllegalArgumentException("存款金額必須為正數");
        }
        this.deposit(total);
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
    public  Account()
    {
        this(accountNumber: "000000", initialBalance: 0.0);
    }
    public  Account(String accountNumber){
        this(accountNumber "000000", initialBalance: 0.0);
    }
}
