package plu2018.Dijkstra;

public class Dijkstra {
    final int x;  //nodes per row
    final int y; //number of rows (nodes per column)
    int end_x;
    int end_y;
    Node[][] grid;
    int cx;         //current x
    int cy;         //current y

    public Dijkstra(int _x, int _y, int start_x, int start_y, int _end_x, int _end_y, boolean[][] blocked) {
        x = _x;
        y = _y;
        end_x = _end_x;
        end_y = _end_y;
        grid = new Node[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                grid[i][j] = new Node();
                if (blocked[i][j])
                    grid[i][j].is_blocked = true;
            }
        }
        grid[start_y][start_x].score = 0;
        cx = start_x;
        cy = start_y;
    }

    public int shortest_distance() {
        do {
            update_neighbors();
            grid[cy][cx].visited = true;
        } while (reassign_current());
        if (grid[end_y][end_x].score < Integer.MAX_VALUE)
            return grid[end_y][end_x].score;
        return -1;
    }

    void update_neighbors() {
        if (cy - 1 >= 0) {
            grid[cy - 1][cx].tryNewScore(grid[cy][cx].score + 1);
        }
        if (cy + 1 < y) {
            grid[cy + 1][cx].tryNewScore(grid[cy][cx].score + 1);
        }
        if (cx - 1 >= 0) {
            grid[cy][cx - 1].tryNewScore(grid[cy][cx].score + 1);
        }
        if (cx + 1 < x) {
            grid[cy][cx + 1].tryNewScore(grid[cy][cx].score + 1);
        }
    }

    boolean reassign_current() {
        boolean found = false;
        int min = grid[end_y][end_x].score;
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
