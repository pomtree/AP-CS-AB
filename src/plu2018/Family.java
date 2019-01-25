package plu2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Family {

    public static void main(String args[]) throws FileNotFoundException {
        File file = new File("C:\\Users\\user\\IdeaProjects\\AP CS AB\\src\\plu2018\\files\\family.dat");
        Scanner scanner = new Scanner(file);
        int num_relations = scanner.nextInt();
        scanner.nextLine();
        ArrayList<ArrayList<String>> trees = new ArrayList<>();
        for (int i = 0; i < num_relations; i++) {
            String people[] = scanner.nextLine().split(" ");
            ArrayList<String> to_tree = new ArrayList<>();
            to_tree.add(people[0]);
            to_tree.add(people[2]);
            trees.add(to_tree);
        }
        clean(trees);
        System.out.println(trees);
        int num_trys = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num_trys; i++) {
            String people[] = scanner.nextLine().split(" ");
            boolean pass = false;
            for (ArrayList<String> aTree : trees) {
                pass = pass || aTree.contains(people[0]) && aTree.contains(people[1]);
            }
            if (pass) {
                System.out.println("Related");
            } else {
                System.out.println("Not Related");
            }
        }
    }

    public static void clean(ArrayList<ArrayList<String>> tree) {
        for (int i = 0; i < tree.size(); i++) {
            for (int s = 0; s < 2; s++) {
                //go through all other lists in tree and merge ones with matches
                String str = tree.get(i).get(s);
                for (int ii = 0; ii < tree.size(); ii++) {
                    if (i != ii) {
                        for (int ss = 0; ss < 2; ss++) {
                            String str2 = tree.get(ii).get(ss);
                            if (str.equals(str2)) {
                                tree.get(i).addAll(tree.get(ii));
                            }
                        }
                    }
                }
            }
        }
    }
}
