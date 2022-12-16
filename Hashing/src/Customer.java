public class Customer {
    private double id;
    private String name;
    private double Balance;

    public Customer(double id, String name, double balance) {
        this.id = id;
        this.name = name;
        Balance = balance;
    }



    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
}
