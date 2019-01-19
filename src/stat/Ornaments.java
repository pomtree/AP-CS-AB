package stat;

public class Ornaments {
    public static void main(String args[]) {
        System.out.println(numb_balls_in_stack(1));
        System.out.println(numb_balls_in_stack(4));
        System.out.println(numb_balls_in_stack(10000000));
    }

    public static int numb_balls_in_stack(int layer) {
        if (layer > 1)
            return numb_balls_in_layer(layer) + numb_balls_in_stack(layer - 1);
        return 1;
    }

    public static int numb_balls_in_layer(int n) {
        if (n > 1)
            return n + numb_balls_in_layer(n - 1);
        return 1;
    }
}
