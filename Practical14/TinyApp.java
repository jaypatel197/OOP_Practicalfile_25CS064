import java.util.ArrayList;

class Account {
    String id;
    double bal;
    Account(String id, double bal) { this.id = id; this.bal = bal; }
}

class BankService {
    ArrayList<Account> list = new ArrayList<>();
    void add(Account a) { list.add(a); }
    int count() { return list.size(); }
    Account find(String id) {
        for (Account a : list) {
            if (a.id.equals(id)) return a;
        }
        throw new RuntimeException("Account not found: " + id);
    }
}

public class TinyApp {
    public static void main(String[] args) {
        BankService service = new BankService();
        service.add(new Account("A101", 5000));
        System.out.println("Account count after add: " + service.count());

        try {
            service.find("A999");
        } catch (Exception e) {
            System.out.println("Caught error: " + e.getMessage());
        }
    }
}