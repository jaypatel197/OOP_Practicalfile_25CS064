abstract class Employee {
    String name, id;
    Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }
    abstract double monthlySalary();
}

class FullTime extends Employee {
    double salary;
    FullTime(String name, String id, double salary) {
        super(name, id);
        this.salary = salary;
    }
    double monthlySalary() { return salary; }
}

class PartTime extends Employee {
    double hours, rate;
    PartTime(String name, String id, double hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }
    double monthlySalary() { return hours * rate; }
}

class Intern extends Employee {
    double stipend;
    Intern(String name, String id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }
    double monthlySalary() { return stipend; }
}

public class PayrollDemo {
    public static void main(String[] args) {
        Employee[] emp = {
            new FullTime("Amit", "E101", 50000),
            new PartTime("Bhavik", "E102", 20, 500),
            new Intern("Chirag", "E103", 8000)
        };

        double total = 0;
        for (Employee e : emp) {
            double s = e.monthlySalary();
            total += s;
            System.out.print(e.name + " (" + e.id + ") Salary: " + s);
            if (e instanceof Intern) {
                System.out.print(" (Internship Stipend)");
            }
            System.out.println();
        }
        System.out.println("Total Salary: " + total);
    }
}