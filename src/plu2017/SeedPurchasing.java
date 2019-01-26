package plu2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SeedPurchasing {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\user\\IdeaProjects\\AP CS AB\\src\\plu2017\\files\\seeds.in"));
        int _c = scanner.nextInt();
        for (int __c = 0; __c < _c; __c++) {
            scanner.nextLine();
            int dif_seeds = scanner.nextInt();
            double budget = scanner.nextDouble(), list[][] = new double[dif_seeds][4], best_out = -1, best_spent = -1;
            for (int seed = 0; seed < dif_seeds; seed++) {
                scanner.nextLine();
                list[seed][0] = scanner.nextDouble();   //cost
                list[seed][1] = scanner.nextDouble();   //number of products
                list[seed][2] = scanner.nextDouble();   //cost per product
                list[seed][3] = list[seed][1] * list[seed][2];  //total ouutput per pag

            }
            //to hell with it
            for (int t = 0; t < 1000000; t++) {
                double spent = 0;
                double produced = 0;
                while (spent <= budget) {
                    if (produced > best_out) {
                        best_out = produced;
                        best_spent = spent;
                    }
                    int item = (int) (Math.random() * dif_seeds);
                    spent += list[item][0];
                    produced += list[item][3];
                }

            }
            System.out.println(best_out - best_spent);
        }

    }
}
