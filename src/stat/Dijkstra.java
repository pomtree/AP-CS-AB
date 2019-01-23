package stat;

public class Dijkstra {
    public static void main(String args[]) {
        final int[][] grid = new int[][]{{0, 0, -1, 1, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, -2}};
        //0 = open
        //1 = blocked
        //-1 = start
        //-2 = end
        print_grid(grid);
        //int[] current = new int[2];
        int cx = -1, cy = -1;
        int[][] score = new int[grid.length][grid[0].length];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int a = 0; a < grid.length; a++) {
            for (int i = 0; i < grid[a].length; i++) {
                score[a][i] = 500;
                if (grid[a][i] == -1) {
                    score[a][i] = 0;
                    cx = a;
                    cy = i;
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
            int new_cx = -1, new_cy = -1;
            if (cy + 1 < grid.length && grid[cx][cy + 1] != 1) {
                score[cx][cy + 1] = Math.min(score[cx][cy + 1], score[cx][cy] + 1);
                if (!visited[cx][cy + 1]) {
                    new_cx = cx;
                    new_cy = cy + 1;
                }
            }
            //1 down
            if (cy - 1 >= 0 && grid[cx][cy - 1] != 1) {
                score[cx][cy - 1] = Math.min(score[cx][cy - 1], score[cx][cy] + 1);
                if (!visited[cx][cy - 1]) {
                    new_cx = cx;
                    new_cy = cy - 1;
                }
            }
            //1 left
            if (cx - 1 >= 0 && grid[cx - 1][cy] != 1) {
                score[cx - 1][cy] = Math.min(score[cx - 1][cy], score[cx][cy] + 1);
                if (!visited[cx - 1][cy]) {
                    new_cx = cx - 1;
                    new_cy = cy;
                }
            }
            //1 right
            if (cx + 1 < grid[0].length && grid[cx + 1][cy] != 1) {
                score[cx + 1][cy] = Math.min(score[cx + 1][cy + 1], score[cx][cy] + 1);
                if (!visited[cx + 1][cy]) {
                    new_cx = cx + 1;
                    new_cy = cy;
                }
            }

            if (grid[cx][cy] == -2) {
                System.out.println("Path found. Distance = " + score[cx][cy]);
                return;
            }
            visited[cx][cy] = true;
            cx = new_cx;
            cy = new_cy;


            print_grid(grid);
            print_current(cx, cy);
            print_scores(score);
            print_visited(visited);
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public static void print_current(int cx, int cy) {
        System.out.println();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (cx == i && cy == j)
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

    public static int dijkstra(int[][] grid) {
        int cx = -1, cy = -1;
        int[][] score = new int[grid.length][grid[0].length];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int a = 0; a < grid.length; a++) {
            for (int i = 0; i < grid[a].length; i++) {
                score[a][i] = 500;
                if (grid[a][i] == -1) {
                    score[a][i] = 0;
                    cx = a;
                    cy = i;
                }
                if (grid[a][i] == 1) {
                    score[a][i] = 501;
                    visited[a][i] = true;
                }
            }
        }
        for (int itest = 1; itest < 150; itest++) {
            int new_cx = -1, new_cy = -1;
            if (cy + 1 < grid.length && grid[cx][cy + 1] != 1) {
                score[cx][cy + 1] = Math.min(score[cx][cy + 1], score[cx][cy] + 1);
                if (!visited[cx][cy + 1]) {
                    new_cx = cx;
                    new_cy = cy + 1;
                }
            }
            if (cy - 1 >= 0 && grid[cx][cy - 1] != 1) {
                score[cx][cy - 1] = Math.min(score[cx][cy - 1], score[cx][cy] + 1);
                if (!visited[cx][cy - 1]) {
                    new_cx = cx;
                    new_cy = cy - 1;
                }
            }
            if (cx - 1 >= 0 && grid[cx - 1][cy] != 1) {
                score[cx - 1][cy] = Math.min(score[cx - 1][cy], score[cx][cy] + 1);
                if (!visited[cx - 1][cy]) {
                    new_cx = cx - 1;
                    new_cy = cy;
                }
            }
            if (cx + 1 < grid[0].length && grid[cx + 1][cy] != 1) {
                score[cx + 1][cy] = Math.min(score[cx + 1][cy + 1], score[cx][cy] + 1);
                if (!visited[cx + 1][cy]) {
                    new_cx = cx + 1;
                    new_cy = cy;
                }
            }
            if (grid[cx][cy] == -2)
                return score[cx][cy];
            visited[cx][cy] = true;
            cx = new_cx;
            cy = new_cy;
        }
        return -1;


    }
}
