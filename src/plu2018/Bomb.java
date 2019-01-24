package plu2018;

import plu2018.Dijkstra.Dijkstra3D;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Bomb {
    public static void main(String args[]) throws IOException {
        String[] lines = Files.readAllLines(new File("C:\\Users\\user\\IdeaProjects\\AP CS AB\\src\\plu2018\\files\\bomb.dat").toPath()).toArray(new String[0]);
        int line_number = 1;
        for (int TC = Integer.parseInt(lines[0]); TC > 0; TC--) {
            String[] numbers = lines[line_number].split(" ");
            line_number++;
            int z = Integer.parseInt(numbers[0]), y = Integer.parseInt(numbers[1]), x = Integer.parseInt(numbers[2]), start_x = -1, start_y = -1, start_z = -1, end_x = -1, end_y = -1, end_z = -1;
            boolean[][][] blocked = new boolean[z][y][x];
            for (int f = 0; f < z; f++) {
                for (int r = 0; r < y; r++) {
                    for (int c = 0; c < x; c++) {
                        char ch = lines[line_number].charAt(c);
                        blocked[f][r][c] = ch == '#';
                        if (ch == 'S') {
                            start_x = c;
                            start_y = r;
                            start_z = f;
                        }
                        if (ch == 'E') {
                            end_x = c;
                            end_y = r;
                            end_z = f;
                        }
                    }
                    line_number++;
                }
            }
            System.out.println((new Dijkstra3D(x, y, z, start_x, start_y, start_z, end_x, end_y, end_z, blocked)).shortest_distance());


        }
    }
}