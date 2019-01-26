package plu2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bags {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\user\\IdeaProjects\\AP CS AB\\src\\plu2018\\files\\bags.dat"));
        int numb_cases = scanner.nextInt();
        scanner.nextLine();
        for (int c = 0; c < numb_cases; c++) {
            int numb_items = scanner.nextInt(), items[] = new int[numb_items];
            for (int i = 0; i < numb_items; i++)
                items[i] = scanner.nextInt();
            scanner.nextLine();
            int max_w = scanner.nextInt(), winner = Integer.MAX_VALUE, total_combos = (int) Math.pow(2, numb_items);
            boolean combos[][] = new boolean[total_combos][numb_items];
            scanner.nextLine();
            while (total_combos > 0) {
                for (int i = 0; i < numb_items; i++)
                    combos[total_combos - 1][i] = (total_combos % (int) Math.pow(2, i + 1) < (int) Math.pow(2, i));
                total_combos--;
            }
            for (total_combos = (int) Math.pow(2, numb_items); total_combos > 0; total_combos--) {
                int sum = 0, count = 0;
                for (int i = 0; i < numb_items; i++)
                    if (combos[total_combos - 1][i]) {
                        sum += items[i];
                        count++;
                    }
                if (sum == max_w) winner = Math.min(winner, count);
            }
            if (winner != Integer.MAX_VALUE) System.out.println(winner);
            else System.out.println("Not possible");
        }
    }
}
