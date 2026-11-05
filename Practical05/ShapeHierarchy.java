abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double r;
    Circle(double r) { this.r = r; }
    double area() { return 3.14 * r * r; }
}

class Rectangle extends Shape {
    double l, w;
    Rectangle(double l, double w) { this.l = l; this.w = w; }
    double area() { return l * w; }
}

class Triangle extends Shape {
    double b, h;
    Triangle(double b, double h) { this.b = b; this.h = h; }
    double area() { return 0.5 * b * h; }
}

public class ShapeHierarchy {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(3.0),
            new Rectangle(4.0, 5.0),
            new Triangle(4.0, 6.0)
        };

        double total = 0;
        double maxArea = 0;

        for (Shape s : shapes) {
            double a = s.area();
            total += a;
            if (a > maxArea) maxArea = a;
            System.out.println("Area: " + a + " | Running total: " + total);
        }

        System.out.println("Largest area: " + maxArea);
    }
}