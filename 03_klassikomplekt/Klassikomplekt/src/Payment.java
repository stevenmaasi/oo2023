public class Payment {
    Creditor creditor;
    Debtor debtor;
    double amount;
    Currency currency;

    public Payment(Creditor creditor, Debtor debtor, double amount, Currency currency) {
        this.creditor = creditor;
        this.debtor = debtor;
        this.amount = amount;
        this.currency = currency;
    }

    public static class Creditor {
        String name;
        String phone;
        double balance;

        public Creditor(String name, String phone, double balance) {
            this.name = name;
            this.phone = phone;
            this.balance = balance;
        }

        public String getName() {
            return this.name;
        }

        public String getPhone() {
            return this.phone;
        }

        public double getBalance() {
            return this.balance;
        }
    }

    public static class Debtor {
        String name;
        String phone;
        double balance;

        public Debtor(String name, String phone, double balance) {
            this.name = name;
            this.phone = phone;
            this.balance = balance;
        }

        public String getName() {
            return this.name;
        }

        public String getPhone() {
            return this.phone;
        }

        public double getBalance() {
            return this.balance;
        }
    }
}
