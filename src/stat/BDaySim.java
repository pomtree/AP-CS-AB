package stat;

import java.util.ArrayList;

public class BDaySim {
    public static void main(String args[]) {
        int good = 0, size = 100000, class_size = 23;
        for (int c = 1; c <= size; c++) {
            ArrayList<Integer> list = new ArrayList<>();
            boolean safeway = false;
            for (int i = 0; i < class_size; i++) {
                int n = (int) (Math.random() * 365);
                if (list.contains(n)) {
                    safeway = true;
                }
                list.add(n);
            }
            if (safeway) {
                good++;
            }
            System.out.println(safeway + " \t" + list);
        }
        System.out.println(((float) good / size) * 100 + "% of classes had at least 2 students with matching birthdays.");
    }
}
