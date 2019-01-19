package stat;

import java.math.BigInteger;

public class Ornaments_BIGINT {
    public static void main(String args[]) {
        System.out.println(numb_balls_in_stack(1));
        System.out.println(numb_balls_in_stack(1000000));
    }

    public static BigInteger numb_balls_in_stack(int layer) {
        if (layer == 0) return BigInteger.ZERO;
        if (layer > 1)
            //return numb_balls_in_layer(layer).add(numb_balls_in_stack(layer - 1));
            return BigInteger.ONE;
        return BigInteger.ONE;
    }

    public static int numb_balls_in_layer(int n) {
        //
        // Tn=n(n+1)/2
        return -1;
    }
}
