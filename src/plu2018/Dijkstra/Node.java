package plu2018.Dijkstra;

public class Node {
    public int score;
    public boolean visited;
    //boolean is_start;
    //boolean is_end;
    public boolean is_blocked;

    public Node() {
        score = Integer.MAX_VALUE;
        visited = false;
        is_blocked = false;
    }

    public boolean tryNewScore(int new_score) {
        if (new_score < score && !is_blocked) {
            score = new_score;
            return true;
        }
        return false;
    }

    public boolean tryNewScore3D(int new_score) {
        int cost = 0;
        if (is_blocked) cost = 1;
        if (new_score + cost <= score) {
            score = new_score + cost;
            return true;
        }
        return false;
    }
}
