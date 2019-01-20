package stat;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*

http://www.codebytes.in/2015/02/a-shortest-path-finding-algorithm.html

 */

public class Checkpoint {
    public static final int DIAGONAL_COST = 14;
    public static final int V_H_COST = 10;
    //Blocked cells are just null Cell values in grid
    static Cell[][] grid = new Cell[5][5];
    static PriorityQueue<Cell> open;
    static boolean closed[][];
    static int startI, startJ;
    static int endI, endJ;

    public static void setBlocked(int i, int j) {
        grid[i][j] = null;
    }

    public static void setStartCell(int i, int j) {
        startI = i;
        startJ = j;
    }

    public static void setEndCell(int i, int j) {
        endI = i;
        endJ = j;
    }

    static void checkAndUpdateCost(Cell current, Cell t, int cost) {
        if (t == null || closed[t.i][t.j]) return;
        int t_final_cost = t.heuristicCost + cost;

        boolean inOpen = open.contains(t);
        if (!inOpen || t_final_cost < t.finalCost) {
            t.finalCost = t_final_cost;
            t.parent = current;
            if (!inOpen) open.add(t);
        }
    }

    public static void AStar() {

        //add the start location to open list.
        open.add(grid[startI][startJ]);

        Cell current;

        while (true) {
            current = open.poll();
            if (current == null) break;
            closed[current.i][current.j] = true;

            if (current.equals(grid[endI][endJ])) {
                return;
            }

            Cell t;
            if (current.i - 1 >= 0) {
                t = grid[current.i - 1][current.j];
                checkAndUpdateCost(current, t, current.finalCost + V_H_COST);

                if (current.j - 1 >= 0) {
                    t = grid[current.i - 1][current.j - 1];
                    checkAndUpdateCost(current, t, current.finalCost + DIAGONAL_COST);
                }

                if (current.j + 1 < grid[0].length) {
                    t = grid[current.i - 1][current.j + 1];
                    checkAndUpdateCost(current, t, current.finalCost + DIAGONAL_COST);
                }
            }

            if (current.j - 1 >= 0) {
                t = grid[current.i][current.j - 1];
                checkAndUpdateCost(current, t, current.finalCost + V_H_COST);
            }

            if (current.j + 1 < grid[0].length) {
                t = grid[current.i][current.j + 1];
                checkAndUpdateCost(current, t, current.finalCost + V_H_COST);
            }

            if (current.i + 1 < grid.length) {
                t = grid[current.i + 1][current.j];
                checkAndUpdateCost(current, t, current.finalCost + V_H_COST);

                if (current.j - 1 >= 0) {
                    t = grid[current.i + 1][current.j - 1];
                    checkAndUpdateCost(current, t, current.finalCost + DIAGONAL_COST);
                }

                if (current.j + 1 < grid[0].length) {
                    t = grid[current.i + 1][current.j + 1];
                    checkAndUpdateCost(current, t, current.finalCost + DIAGONAL_COST);
                }
            }
        }
    }

    /*
    Params :
    tCase = test case No.
    x, y = Board's dimensions
    si, sj = start location's x and y coordinates
    ei, ej = end location's x and y coordinates
    int[][] blocked = array containing inaccessible cell coordinates
    */
    public static void test(int tCase, int x, int y, int si, int sj, int ei, int ej, int[][] blocked) {
        System.out.println("\n\nTest Case #" + tCase);
        //Reset
        grid = new Cell[x][y];
        closed = new boolean[x][y];
        open = new PriorityQueue<>((Object o1, Object o2) -> {
            Cell c1 = (Cell) o1;
            Cell c2 = (Cell) o2;

            return Integer.compare(c1.finalCost, c2.finalCost);
        });
        //Set start position
        setStartCell(si, sj);  //Setting to 0,0 by default. Will be useful for the UI part

        //Set End Location
        setEndCell(ei, ej);

        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                grid[i][j] = new Cell(i, j);
                grid[i][j].heuristicCost = Math.abs(i - endI) + Math.abs(j - endJ);
//                  System.out.print(grid[i][j].heuristicCost+" ");
            }
//              System.out.println();
        }
        grid[si][sj].finalCost = 0;

           /*
             Set blocked cells. Simply set the cell values to null
             for blocked cells.
           */
        for (int[] aBlocked : blocked) {
            setBlocked(aBlocked[0], aBlocked[1]);
        }

        //Display initial map
        System.out.println("Grid: ");
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (i == si && j == sj) System.out.print("S "); //Source
                else if (i == ei && j == ej) System.out.print("E ");  //Destination
                else if (grid[i][j] != null) System.out.print(". ");
                else System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();

        AStar();
        System.out.println("\nScores for cells: ");
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < x; ++j) {
                if (grid[i][j] != null) System.out.printf("%-3d ", grid[i][j].finalCost);
                else System.out.print("BL  ");
            }
            System.out.println();
        }
        System.out.println();

        if (closed[endI][endJ]) {
            //Trace back the path
            System.out.println("Path: ");
            Cell current = grid[endI][endJ];
            System.out.print(current);
            while (current.parent != null) {
                System.out.print(" -> " + current.parent);
                current = current.parent;
            }
            System.out.println();
        } else System.out.println("No possible path");
    }

    public static void main(String[] args) {
        //  int[][] ex1_blocked = new int[][]{{1, 1}, {2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {4, 2}, {1, 3}, {2, 3}, {4, 3}, {5, 3}, {6, 3}};
        // int[][] ex1_blocked = new int[][]{{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {2, 4}, {3, 1}, {3, 2}, {3,3}, {3, 4}, {3, 5}, {3, 6}};
        // test(1, 5,8, 0, 0, 2,5, ex1_blocked);
        System.out.println((int) '1');
        System.out.println((int) '9');
        Scanner s = new Scanner(System.in);
        for (int CASES = s.nextInt(); CASES > 0; CASES--) {
            int h = s.nextInt();
            int l = s.nextInt();
            int cp = s.nextInt();
            String lines[] = new String[h];
            s.nextLine();
            for (int i = 0; i < h; i++) {
                lines[i] = s.nextLine();
                //System.out.println("line " + i + " = " + lines[i]);
            }
            //input so far:
            System.out.println("h = " + h);
            System.out.println("l = " + l);
            System.out.println("c = " + cp);
            for (String line : lines) {
                System.out.println(line);
            }
            ArrayList<int[]> bc = new ArrayList<>();
            int[] start = new int[2];
            int[] end = new int[2];
            int[][] cps = new int[cp][];
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i];
                for (int c = 0; c < line.length(); c++) {
                    char ch = line.charAt(c);
                    if (ch == '#') {
                        bc.add(new int[]{i, c});
                        System.out.println("blockage at " + i + ", " + c);
                    }
                    if (ch == 'E') {
                        end[0] = i;
                        end[1] = c;
                        System.out.println("end point at " + i + ", " + c);
                    }
                    if (ch == 'S') {
                        start[0] = i;
                        start[1] = c;
                        System.out.println("start point at " + i + ", " + c);
                    }
                    if (ch >= 49 && ch <= 57) {
                        int cpn = ch - 48;
                        cps[cpn - 1] = new int[]{i, c};
                        System.out.println("check point" + cpn + " at " + i + ", " + c);
                    }
                }
            }

            int[][] bc_a = new int[bc.size()][];
            for (int i = 0; i < bc.size(); i++) {
                bc_a[i] = bc.get(i);
            }


            if (cp == 1) {
                test(CASES, h, l, start[0], start[1], cps[0][0], cps[0][1], bc_a);
                test(CASES, h, l, cps[0][0], cps[0][1], end[0], end[1], bc_a);
            }
            if (cp == 0) {
                test(CASES, h, l, start[0], start[1], end[0], end[1], bc_a);
            }
            if (cp > 1) {
                test(CASES, h, l, start[0], start[1], cps[0][0], cps[0][1], bc_a);

                for (int cpn = 0; cpn < cps.length - 1; cpn++) {
                    test(CASES, h, l, cps[cpn][0], cps[cpn][1], cps[cpn + 1][0], cps[cpn + 1][1], bc_a);

                }

                test(CASES, h, l, cps[cps.length - 1][0], cps[cps.length - 1][1], end[0], end[1], bc_a);
            }





        }


    }

    static class Cell {
        int heuristicCost = 0; //Heuristic cost
        int finalCost = 0; //G+H
        int i, j;
        Cell parent;

        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "[" + this.i + ", " + this.j + "]";
        }
    }
}
/*
test code to paste into terminal:
*/

/*
1
5 8 2
S....1..
.######.
..2.#...
.######.
......E.

 */