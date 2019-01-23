package plu2018.Dijkstra;

public class Node {
    int score;
    boolean visited;
    boolean is_start;
    boolean is_end;
    boolean is_blocked;

    public Node() {
        score = Integer.MAX_VALUE;
        visited = false;
        is_end = false;
        is_start = false;
        is_blocked = false;
    }

    public boolean tryNewScore(int new_score) {
        if (new_score < score && !is_blocked) {
            score = new_score;
            return true;
        }
        return false;
    }
}
