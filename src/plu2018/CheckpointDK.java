package plu2018;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CheckpointDK {
    public static void main(String args[]) throws IOException {
        boolean print = true;
        String[] lines = Files.readAllLines(new File("C:\\Users\\user\\IdeaProjects\\AP CS AB\\src\\plu2018\\files\\checkpoint_test.dat").toPath()).toArray(new String[0]);
        int line_number = 1;
        for (int TC = Integer.parseInt(lines[0]); TC > 0; TC--) {
            if (print) System.out.println("test case " + TC);
            if (print) System.out.println(lines[line_number]);
            String[] numbers = lines[line_number].split(" ");
            line_number++;
            int y_dim = Integer.parseInt(numbers[0]);
            int x_dim = Integer.parseInt(numbers[1]);
            int num_cp = Integer.parseInt(numbers[2]);
            if (print) {
                System.out.println("x = " + x_dim);
                System.out.println("y = " + y_dim);
                System.out.println("cp = " + num_cp);
            }
            String l_grid[] = new String[y_dim];
            for (int i = 0; i < y_dim; i++) {
                l_grid[i] = lines[line_number];
                line_number++;
            }
            if (print)
                for (int i = 0; i < y_dim; i++)
                    System.out.println(l_grid[i]);


        }


    }
}
