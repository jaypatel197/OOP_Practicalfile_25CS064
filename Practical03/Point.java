import java.util.Objects;

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class PointDriver {
    public static void main(String[] args) {
        Point[] points = {
            new Point(1, 2),
            new Point(3, 4),
            new Point(1, 2),
            new Point(5, 6),
            new Point(3, 4)
        };

        int count = 0;
        for (int i = 0; i < points.length; i++) {
            boolean duplicate = false;
            for (int j = 0; j < i; j++) {
                if (points[i].equals(points[j])) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                count++;
            }
        }

        System.out.println("Distinct: " + count);
    }
}