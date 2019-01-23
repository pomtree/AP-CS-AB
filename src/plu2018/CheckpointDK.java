package plu2018;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CheckpointDK {
    public static void main(String args[]) throws IOException {
        /*System.out.println(Dijkstra.dijkstra(new int[][]{
                {0, 0, -1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, -2}}));
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
        String[] lines = Files.readAllLines(new File("myfile.dat").toPath()).toArray(new String[0]);


    }
}
