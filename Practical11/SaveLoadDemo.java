import java.io.*;

class User implements Serializable {
    String name;
    transient String pass; // not saved

    User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String toString() {
        return "User[name=" + name + ", pass=" + pass + "]";
    }
}

public class SaveLoadDemo {
    public static void main(String[] args) throws Exception {
        User[] users = { new User("Jay", "1234"), new User("Ansh", "5678") };

        // Save
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.dat"));
        out.writeObject(users);
        out.close();

        // Load
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("users.dat"));
        User[] loaded = (User[]) in.readObject();
        in.close();

        for (User u : loaded) {
            System.out.println(u);
        }
    }
}