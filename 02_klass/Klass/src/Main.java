public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        double creditorBalance = 200;
        double debtorBalance = 300;
        double paymentAmount = 100;

        Creditor creditor = new Creditor("Mina", "Minu aadress", "55050505", creditorBalance);
        Debtor debtor = new Debtor("Tema", "Tema aadress", "55050111", debtorBalance);

        System.out.println("Algne maksja konto jääk: " + creditor.getBalance());
        System.out.println("Algne makse saaja konto jääk: " + debtor.getBalance());

        makePayment(creditor, debtor, paymentAmount);
        System.out.println();

        System.out.println("Maksja konto jääk peale makset: " + creditor.getBalance());
        System.out.println("Makse saaja konto jääk peale makset: " + debtor.getBalance());
    }

    private static void makePayment(Creditor creditor, Debtor debtor, double amount) {
        creditor.balance = creditor.balance - amount;
        debtor.balance = debtor.balance + amount;
    }
}