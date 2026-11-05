class OutOfStockException extends Exception {
    private final int shortfall;
    public OutOfStockException(int shortfall) {
        super("Out of stock by " + shortfall + " item(s)");
        this.shortfall = shortfall;
    }
    public int getShortfall() { return shortfall; }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String msg) { super(msg); }
}

class Warehouse {
    private int stock;
    public Warehouse(int stock) { this.stock = stock; }

    public void issue(int qty) throws OutOfStockException, InvalidQuantityException {
        if (qty <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than 0");
        }
        if (qty > stock) {
            throw new OutOfStockException(qty - stock);
        }
        stock -= qty;
    }
    public int getStock() { return stock; }
}

public class StockIssue {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(50);
        int[] requests = {20, -5, 25, 15, 5};

        System.out.println("Initial Stock: " + warehouse.getStock());
        for (int qty : requests) {
            System.out.println("\nRequesting quantity: " + qty);
            try {
                warehouse.issue(qty);
                System.out.println("Successfully issued " + qty + ". Remaining stock: " + warehouse.getStock());
            } catch (InvalidQuantityException e) {
                System.out.println("InvalidQuantityException caught: " + e.getMessage());
            } catch (OutOfStockException e) {
                System.out.println("OutOfStockException caught: " + e.getMessage() + " (Shortfall: " + e.getShortfall() + ")");
            }
        }
        System.out.println("\nFinal Stock: " + warehouse.getStock());
    }
}