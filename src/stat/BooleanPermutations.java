package stat;

public class BooleanPermutations {
    public static void main(String ahole[]) {
        final int base = 2;       //number of options on a switch: a thing to be (e.x. 2 = true or false)
        final int size = 10;       //number of switches
        int total_combos = (int) Math.pow(base, size);
        while (total_combos > 0) {
            System.out.print("\nTC = " + total_combos + "\t ");
            for (int i = 0; i < size; i++) {
                if (total_combos % (int) Math.pow(base, i + 1) < (int) Math.pow(base, i))
                    System.out.print(0);
                else
                    System.out.print(1);

            }

            total_combos--;
        }


    }


}
