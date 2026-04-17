

public class User {
    int id;
    String name;
    Long balance;

    User(int id, String name, Long balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    
    public Long getBalance() {
        return this.balance;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setNewBalance(Long newBalance) {
        this.balance = newBalance;
    }
}