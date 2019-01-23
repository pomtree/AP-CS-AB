package plu2018.Old;

import java.math.BigInteger;

public class Ornaments2 {
    public static void main(String aSA[]) {

    }

    public static BigInteger layer(int layer) {
        BigInteger bigN = BigInteger.valueOf(layer);
        return bigN.multiply(bigN.add(BigInteger.ONE)).divide(BigInteger.TWO);
    }
}
