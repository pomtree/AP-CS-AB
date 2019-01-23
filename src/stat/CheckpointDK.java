package stat;

public class CheckpointDK {
    public static void main(String args[]) {
        System.out.println(Dijkstra.dijkstra(new int[][]{{0, 0, -1, 1, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, -2}}));
    }
}
