package plu2017;

import plu2018.Dijkstra.Dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FieldNavigation {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner s = new Scanner(new File("C:\\Users\\user\\IdeaProjects\\AP CS AB\\src\\plu2017\\files\\navigation.in"));
        final int _c = s.nextInt();
        s.nextLine();
        for (int __c = 0; __c < _c; __c++) {
            int size = s.nextInt();
            s.nextLine();
            char[][] grid = new char[size][size];
            boolean block[][][] = new boolean[7][size][size];

            int sx = -1, sy = -1, ex = -1, ey = -1;
            for (int l = 0; l < size; l++) {
                String line = s.nextLine();
                for (int c = 0; c < size; c++) {
                    char ch = line.charAt(c);
                    grid[l][c] = ch;
                    block[0][l][c] = ch == 'R' || ch == 'G' || ch == 'B';
                    block[1][l][c] = ch == 'R' || ch == 'G';
                    block[2][l][c] = ch == 'G' || ch == 'B';
                    block[3][l][c] = ch == 'B' || ch == 'R';
                    block[4][l][c] = ch == 'R';
                    block[5][l][c] = ch == 'B';
                    block[6][l][c] = ch == 'G';
                    if (ch == 'S') {
                        sx = c;
                        sy = l;
                    }
                    if (ch == 'X') {
                        ex = c;
                        ey = l;
                    }
                }
            }
            if (new Dijkstra(size, size, sx, sy, ex, ey, block[0]).shortest_distance() != -1) {
                System.out.println(0);
            } else if (new Dijkstra(size, size, sx, sy, ex, ey, block[1]).shortest_distance() != -1 || new Dijkstra(size, size, sx, sy, ex, ey, block[2]).shortest_distance() != -1 || new Dijkstra(size, size, sx, sy, ex, ey, block[3]).shortest_distance() != -1) {
                System.out.println(1);
            } else if (new Dijkstra(size, size, sx, sy, ex, ey, block[4]).shortest_distance() != -1 || new Dijkstra(size, size, sx, sy, ex, ey, block[5]).shortest_distance() != -1 || new Dijkstra(size, size, sx, sy, ex, ey, block[6]).shortest_distance() != -1) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}
