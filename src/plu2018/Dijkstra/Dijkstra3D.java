package plu2018.Dijkstra;

public class Dijkstra3D {
    // grid[z][y][x]
    final int x, y, z;
    Node[][][] grid;
    int cx, cy, cz, end_x, end_y, end_z;

    public Dijkstra3D(int _x, int _y, int _z, int start_x, int start_y, int start_z, int _end_x, int _end_y, int _end_z, boolean[][][] blocked) {
        x = _x;
        y = _y;
        z = _z;
        end_x = _end_x;
        end_y = _end_y;
        end_z = _end_z;
        grid = new Node[z][y][x];
        for (int l = 0; l < z; l++) {
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    grid[l][i][j] = new Node();
                    if (blocked[l][i][j])
                        grid[l][i][j].is_blocked = true;
                }
            }
        }
        grid[start_z][start_y][start_x].score = 0;
        cx = start_x;
        cy = start_y;
    }

    public int shortest_distance() {
        do {
            update_neighbors();
            grid[cz][cy][cx].visited = true;
        } while (reassign_current());
        if (grid[end_z][end_y][end_x].score < Integer.MAX_VALUE)
            return grid[end_z][end_y][end_x].score;
        return -1;
    }

    void update_neighbors() {
        //given that traversal is free among layers
        if (cz - 1 >= 0) {
            grid[cz - 1][cy][cx].tryNewScore3D(grid[cz][cy][cx].score);
        }
        if (cz + 1 < z) {
            grid[cz + 1][cy][cx].tryNewScore3D(grid[cz][cy][cx].score);
        }
        if (cy - 1 >= 0) {
            grid[cz][cy - 1][cx].tryNewScore3D(grid[cz][cy][cx].score);
        }
        if (cy + 1 < y) {
            grid[cz][cy + 1][cx].tryNewScore3D(grid[cz][cy][cx].score);
        }
        if (cx - 1 >= 0) {
            grid[cz][cy][cx - 1].tryNewScore3D(grid[cz][cy][cx].score);
        }
        if (cx + 1 < x) {
            grid[cz][cy][cx + 1].tryNewScore3D(grid[cz][cy][cx].score);
        }
    }

    boolean reassign_current() {
        boolean found = false;
        int min = grid[cz][end_y][end_x].score;
        for (int l = 0; l < z; l++) {
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (grid[l][i][j].score <= min && !grid[l][i][j].visited) {
                        min = grid[l][i][j].score;
                        cx = j;
                        cy = i;
                        cz = l;
                        found = true;
                    }
                }
            }
        }
        return found;
    }
}
