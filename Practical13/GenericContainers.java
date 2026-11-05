class Box<T> {
    T val;
    void set(T val) { this.val = val; }
    T get() { return val; }
}

class Pair<A, B> {
    A first;
    B second;
    Pair(A a, B b) { this.first = a; this.second = b; }
}

public class GenericContainers {
    static <T> T getFirst(T[] arr) {
        return arr[0];
    }

    public static void main(String[] args) {
        Box<String> b1 = new Box<>();
        b1.set("Hello Java");
        System.out.println("Box value: " + b1.get());

        Pair<String, Integer> p = new Pair<>("Jay", 64);
        System.out.println("Pair: " + p.first + " " + p.second);

        String[] arr = { "Apple", "Banana", "Cherry" };
        System.out.println("First: " + getFirst(arr));
    }
}