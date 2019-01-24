package plu2018;

import plu2018.Dijkstra.Dijkstra;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Checkpoint {
    public static void main(String args[]) throws IOException {
        String[] lines = Files.readAllLines(new File("C:\\Users\\user\\IdeaProjects\\AP CS AB\\src\\plu2018\\files\\checkpoint.dat").toPath()).toArray(new String[0]);
        int line_number = 1;
        for (int TC = Integer.parseInt(lines[0]); TC > 0; TC--) {
            String[] numbers = lines[line_number].split(" ");
            line_number++;
            int y_dim = Integer.parseInt(numbers[0]);
            int x_dim = Integer.parseInt(numbers[1]);
            int num_cp = Integer.parseInt(numbers[2]);
            String l_grid[] = new String[y_dim];
            for (int i = 0; i < y_dim; i++) {
                l_grid[i] = lines[line_number];
                line_number++;
            }
            int[] checkpoints_x = new int[num_cp + 2];
            int[] checkpoints_y = new int[num_cp + 2];
            boolean blocked[][] = new boolean[y_dim][x_dim];
            for (int i = 0; i < y_dim; i++) {
                for (int c = 0; c < x_dim; c++) {
                    char ch = l_grid[i].charAt(c);
                    if (ch == '#') {
                        blocked[i][c] = true;
                    }
                    if (ch == 'S') {
                        checkpoints_x[0] = c;
                        checkpoints_y[0] = i;
                    }
                    if (ch == 'E') {
                        checkpoints_x[num_cp + 1] = c;
                        checkpoints_y[num_cp + 1] = i;
                    }
                    if (ch >= 49 && ch <= 57) {
                        checkpoints_x[ch - 48] = c;
                        checkpoints_y[ch - 48] = i;
                    }
                }
            }
            Dijkstra dijkstra = new Dijkstra(x_dim, y_dim, checkpoints_x[0], checkpoints_y[0], checkpoints_x[1], checkpoints_y[1], blocked);
            int distance = dijkstra.shortest_distance();
            for (int i = 1; i + 1 < checkpoints_x.length; i++) {
                dijkstra = new Dijkstra(x_dim, y_dim, checkpoints_x[i], checkpoints_y[i], checkpoints_x[i + 1], checkpoints_y[i + 1], blocked);
                distance += dijkstra.shortest_distance();
            }
            System.out.println(distance);
        }
    }
}
