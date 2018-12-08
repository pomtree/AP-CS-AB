package apcs.a1;

public class Removealg {
    public static void main(String as[]) {
        int a[] = {1, 1, 1, 2, 3, 5, 5, 6, 7, 8, 8, 8, 8, 9, 10, 11, 11, 12, 13, 15, 15, 15, 17, 18, 19, 20, 20, 21, 23, 25, 25, 26, 29, 29, 29, 29, 29, 29, 30, 32, 35};
        a = part1(a);
        for (int i : a) {
            System.out.print(i + ", ");
        }
        a = part2(a);
        System.out.println();
        for (int i : a) {
            System.out.print(i + ", ");
        }
    }

    public static int[] part1(int a[]) {
        int bad = 0;
        for (int i = 0; i < a.length; i++) {
            int c = 1;
            while (i + c < a.length && a[i] == a[i + c]) {
                a[i + c] = -1;
                bad++;
                c++;
            }
            i += c - 1;
        }
        int newa[] = new int[a.length - bad];
        int newi = 0;
        for (int i : a) {
            if (i > 0) {
                newa[newi] = i;
                newi++;
            }
        }
        return newa;
    }

    public static int[] part2(int a[]) {
        int b[] = new int[a.length];
        for (int i : a) {
            int randIndex = (int) (Math.random() * a.length);
            while (b[randIndex] > 0) {
                randIndex = (int) (Math.random() * a.length);
            }
            b[randIndex] = i;
        }
        return b;
    }
}
