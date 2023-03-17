public class Debtor {
    String name;
    String address;
    String phone;
    double balance;

    public Debtor(String name, String address, String phone, double balance) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public double getBalance() {
        return this.balance;
    }
}
