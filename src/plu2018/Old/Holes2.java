package plu2018.Old;

import java.util.Scanner;

public class Holes2 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        //System.out.println("t = " + t);
        for (int tn = 0; tn < t; tn++) {
            int h = s.nextInt();
            //System.out.println("h = " + h);
            int w = s.nextInt();
            //System.out.println("w = " + w);
            s.nextLine();
            char a[][] = new char[h][w];
            for (int i = 0; i < h; i++) {
                String line = s.nextLine();
                for (int c = 0; c < w; c++) {
                    a[i][c] = line.charAt(c);
                }
            }
            //print(a);

            int sec = 0, space = 0;
            //while (acont(a)) {
            for (int row = 1; row < h; row++) {
                for (int c = 1; c < w; c++) {
                    if (a[row][c] == '.') {
                        space++;
                        if (a[row + 1][c] != '.' && a[row - 1][c] != '.' && a[row][c + 1] != '.' && a[row + 1][c - 1] != '.') { //up and down and left and right != '.'
                            sec++;
                        }
                        a[row][c] = 'X';
                        //System.out.println(" Spaces:  " + space);
                        // System.out.println("Sections: " + sec);
                        // print(a);
                    }


                }
            }

            //}
            if (sec != 1) {
                System.out.println(sec + " sections, ");
            } else {
                System.out.println("1 section, ");
            }
            if (space != 1) {
                System.out.println(space + " spaces");
            } else {
                System.out.println("1 space");
            }

        }
    }
    public static void print(char[][] a) {
        for (char[] r : a) {
            for (char c : r) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}