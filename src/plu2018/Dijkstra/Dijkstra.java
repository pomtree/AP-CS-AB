package plu2018.Dijkstra;

public class Dijkstra {
    final int x;  //nodes per row
    final int y; //number of rows (nodes per column)
    Node[][] grid;
    int cx;         //current x
    int cy;         //current y
    //0,0 is upper left

    public Dijkstra(int _x, int _y, int start_x, int start_y, int end_x, int end_y, boolean[][] blocked) {
        x = _x;
        y = _y;
        grid = new Node[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                grid[i][j] = new Node();
                if (blocked[i][j])
                    grid[i][j].is_blocked = true;
            }
        }
        grid[start_y][start_x].is_start = true;
        grid[start_y][start_x].score = 0;
        grid[end_y][end_x].is_start = true;
        cx = start_x;
        cy = start_y;
    }


    public int shortest_distance() {


        return -1;
    }

    private void update_neighbors() {
        //up
        if (cy - 1 >= 0) {
            grid[cy - 1][cx].tryNewScore(grid[cy][cx].score + 1);
        }
        //down
        if (cy + 1 < y) {
            grid[cy + 1][cx].tryNewScore(grid[cy][cx].score + 1);

        }
        //left
        if (cx - 1 >= 0) {
            grid[cy][cx - 1].tryNewScore(grid[cy][cx].score + 1);
        }
        //right
        if (cx + 1 < x) {
            grid[cy][cx + 1].tryNewScore(grid[cy][cx].score + 1);
        }

    }

    private boolean reassign_current() {
        boolean found = false;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j].score < min && !grid[i][j].visited) {
                    min = grid[i][j].score;
                    cx = j;
                    cy = i;
                    found = true;
                }
            }
        }
        return found;
    }


}
