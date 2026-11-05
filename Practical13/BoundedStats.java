public class BoundedStats {
    static <N extends Number> double average(N[] arr) {
        double sum = 0;
        for (N n : arr) {
            sum += n.doubleValue();
        }
        return sum / arr.length;
    }

    public static void main(String[] args) {
        Integer[] nums1 = { 10, 20, 30 };
        Double[] nums2 = { 1.5, 2.5, 3.5 };

        System.out.println("Int avg: " + average(nums1));
        System.out.println("Double avg: " + average(nums2));
    }
}