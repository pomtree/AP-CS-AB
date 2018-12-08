package calculus;

public class NewtonsMethod {
    public static void main(String args[]) {
        System.out.println(newt(0, .000001));
    }

    public static double y(double x) {
        return 2 * x * x * x + 7 * x * x - x + 1;
    }

    public static double dy(double x) {
        return 6 * x * x + 14 * x - 1;
    }

    public static double newt(double x, double pre) {
        System.out.println(x);
        if (Math.abs(y(x)) < pre) {
            System.out.println("returning...");
            return x;
        }
        return newt(x - y(x) / dy(x), pre);
    }
}
