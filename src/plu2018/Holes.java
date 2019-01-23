package plu2018;

import java.util.Scanner;

public class Holes {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        System.out.println("t = " + t);
        for (int tn = 0; tn < t; tn++) {
            int h = s.nextInt();
            System.out.println("h = " + h);
            int w = s.nextInt();
            System.out.println("w = " + w);
            String[] lines = new String[h];
            s.nextLine();
            for (int i = 0; i < h; i++) {
                lines[i] = s.nextLine();
                System.out.println("line " + i + " = " + lines[i]);
            }
            System.out.println("line input complete.");
            int sec = 0, space = 0;
            while (contains(lines)) {
                for (int l = 0; l < h; l++) {
                    for (int c = 0; c < w; c++) {
                        if (lines[l].charAt(c) == '.') {


                        }
                    }
                }
            }


        }


    }

    public static int check(String[] lines, int line_number, int char_number) {
        //0 = X,# and & (no .) so, + space, no more sec (end of that section)
        //1 = just # (+ space and + sec) (new section)
        //2 = more in this section
        int sl = lines[0].length();
        boolean n = true;
        for (int ln = Math.max(0, line_number - 1); ln + 1 <= line_number && ln <= lines.length; ln++) {
            for (int cn = Math.max(char_number - 1, 0); cn + 1 <= char_number && cn < sl; cn++) {
                if (lines[ln].charAt(cn) == '.') {
                    return 2;
                } else if (lines[ln].charAt(cn) == 'X') {
                    n = false;
                }
            }
        }
        if (n) {
            return 1;
        }
        return 0;
    }


    public static boolean contains(String a[]) {
        for (String s : a) {
            if (s.contains(".")) {
                return true;
            }
        }
        return false;
    }
}
