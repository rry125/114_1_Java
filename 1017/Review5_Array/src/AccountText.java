public class AccountTest {
    private static int cusmtomerCount;
    public  static void main(String[] args) {
        Account[] customers = new Account[10];
        Account acc1 = new Account("A123", "John Doe", 1000);
        Account acc2 = new Account("B456", "Jane Smith", 3000);
        Account acc3 = new Account("C789", "Alice", -100);

    }

    public static void addCustomer(Account[] customers, Account newAccount) {
        if (customerCount < customers.length) {
            customers[customerCount] = newAccount;
            customerCount++;
            System.out.println("成功新增客戶：" + newAccount.getAccountNumber());
            return;
        }
        System.out.println("無法新增客戶，客戶數量已達上限。");
    }
    public static void printCustomers(Account[] customers) {
        for (int i = 0; i < customerCount; i++) {
            printCustomersInfo(customers[i]);
        }
    }

    public static void printCustomersInfo(Account account){
        System.out.printf("帳戶號碼: %s, 持有人: %s, 餘額: %.2f%n",
                account.getAccountNumber(),
                account.getOwnerName(),
                account.getBalance());
    }

}