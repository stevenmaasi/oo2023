public class Main {
    public static void main(String[] args) {
        String creditorName = "Kalle";
        String debtorName = "Malle";
        String creditorPhone = "55050505";
        String debtorPhone = "55050111";
        double creditorBalance = 200;
        double debtorBalance = 300;
        double paymentAmount = 100;
        Currency walletCurrency = Currency.EUR;

        Payment.Creditor creditor = new Payment.Creditor(creditorName, creditorPhone, creditorBalance);
        Payment.Debtor debtor = new Payment.Debtor(debtorName, debtorPhone, debtorBalance);
        Payment payment = new Payment(creditor, debtor, paymentAmount, walletCurrency);

        System.out.println(payment.creditor.getName() + " konto jääk: " + payment.creditor.getBalance() + walletCurrency);
        System.out.println(payment.debtor.getName() + " konto jääk: " + payment.debtor.getBalance() + walletCurrency);

        makePayment(payment);
        System.out.println();

        System.out.println(payment.creditor.getName() + " konto jääk peale makset: " + payment.creditor.getBalance() + walletCurrency);
        System.out.println(payment.debtor.getName() + " konto jääk peale makset: " + payment.debtor.getBalance() + walletCurrency);
    }

    private static void makePayment(Payment payment) {
        payment.creditor.balance = payment.creditor.balance - payment.amount;
        payment.debtor.balance = payment.debtor.balance + payment.amount;
    }
}