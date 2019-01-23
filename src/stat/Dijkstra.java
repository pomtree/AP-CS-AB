package stat;

public class Dijkstra {
    public static void main(String args[]) {
        final int[][] grid = new int[][]{{0, 0, -1, 1, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, -2}};
        //0 = open
        //1 = blocked
        //-1 = start
        //-2 = end
        print_grid(grid);
        int[] current = new int[2];
        int[][] score = new int[grid.length][grid[0].length];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int a = 0; a < grid.length; a++) {
            for (int i = 0; i < grid[a].length; i++) {
                score[a][i] = 500;
                if (grid[a][i] == -1) {
                    score[a][i] = 0;
                    current = new int[]{a, i};
                }
                if (grid[a][i] == 1) {
                    score[a][i] = 501;
                    visited[a][i] = true;
                }
            }
        }

        for (int itest = 1; itest < 150; itest++) {
            System.out.println("Iteration " + itest);
            //1 up
            int[] new_current = new int[2];
            new_current[0] = -1;
            if (current[1] + 1 < grid.length && grid[current[0]][current[1] + 1] != 1) {
                score[current[0]][current[1] + 1] = Math.min(score[current[0]][current[1] + 1], score[current[0]][current[1]] + 1);
                if (!visited[current[0]][current[1] + 1]) {
                    new_current[0] = current[0];
                    new_current[1] = current[1] + 1;
                }
            }
            //1 down
            if (current[1] - 1 >= 0 && grid[current[0]][current[1] - 1] != 1) {
                score[current[0]][current[1] - 1] = Math.min(score[current[0]][current[1] - 1], score[current[0]][current[1]] + 1);
                if (!visited[current[0]][current[1] - 1]) {
                    new_current[0] = current[0];
                    new_current[1] = current[1] - 1;
                }
            }
            //1 left
            if (current[0] - 1 >= 0 && grid[current[0] - 1][current[1]] != 1) {
                score[current[0] - 1][current[1]] = Math.min(score[current[0] - 1][current[1]], score[current[0]][current[1]] + 1);
                if (!visited[current[0] - 1][current[1]]) {
                    new_current[0] = current[0] - 1;
                    new_current[1] = current[1];
                }
            }
            //1 right
            if (current[0] + 1 < grid[0].length && grid[current[0] + 1][current[1]] != 1) {
                score[current[0] + 1][current[1]] = Math.min(score[current[0] + 1][current[1] + 1], score[current[0]][current[1]] + 1);
                if (!visited[current[0] + 1][current[1]]) {
                    new_current[0] = current[0] + 1;
                    new_current[1] = current[1];
                }
            }

            if (grid[current[0]][current[1]] == -2) {
                System.out.println("Path found. Distance = " + score[current[0]][current[1]]);
                return;
            }
            visited[current[0]][current[1]] = true;
            current[0] = new_current[0];
            current[1] = new_current[1];


            print_grid(grid);
            print_current(current);
            print_scores(score);
            print_visited(visited);
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public static void print_current(int[] current) {
        System.out.println();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (current[0] == i && current[1] == j)
                    System.out.print(" C ");
                else
                    System.out.print(" . ");
            }
            System.out.println();
        }
    }

    public static void print_grid(int[][] a) {
        for (int[] b : a) {
            for (int c : b) {
                if (c == 1) System.out.print(" X ");
                if (c == 0) System.out.print(" . ");
                if (c == -1) System.out.print(" S ");
                if (c == -2) System.out.print(" E ");
            }
            System.out.println();
        }
    }

    public static void print_visited(boolean[][] v) {
        System.out.println();
        for (boolean a[] : v) {
            for (boolean b : a) {
                if (b)
                    System.out.print(" V ");
                else
                    System.out.print(" U ");
            }
            System.out.println();
        }
    }

    public static void print_scores(int[][] a) {
        System.out.println();
        for (int[] b : a) {
            for (int c : b) {
                if (c == 500) System.out.print(" ? ");
                else if (c == 501) System.out.print(" X ");
                else System.out.print(" " + c + " ");
            }
            System.out.println();
        }
    }


}
