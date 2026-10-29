/*
| From >| A | B | C | D | E | H | J | 1 | 2 | 3 |
|-------|---|---|---|---|---|---|---|---|---|---|
| **A** | 0 | 0 | 0 | 6 | 1 | 0 | 0 | 0 | 0 | 0 |
| **B** | 5 | 0 | 2 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| **C** | 9 | 3 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| **D** | 0 | 0 | 1 | 0 | 2 | 0 | 0 | 0 | 0 | 0 |
| **E** | 6 | 0 | 0 | 0 | 0 | 2 | 0 | 0 | 0 | 0 |
| **H** | 0 | 0 | 0 | 7 | 0 | 0 | 0 | 0 | 0 | 0 |
| **J** | 0 | 0 | 0 | 0 | 2 | 0 | 0 | 0 | 0 | 0 |
| **G1* | 0 | 9 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| **G2* | 0 | 0 | 0 | 5 | 0 | 0 | 0 | 0 | 0 | 0 |
| **G3* | 0 | 0 | 0 | 0 | 0 | 8 | 7 | 0 | 0 | 0 |


*/

import java.util.*;

public class aStarSearch {

    public static class TreeNode {
        int val;
        TreeNode parent;

        TreeNode(int val, TreeNode parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    static int[][] cost_matrix = {
            { 0, 0, 0, 6, 1, 0, 0, 0, 0, 0 },
            { 5, 0, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 9, 3, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 0, 2, 0, 0, 0, 0, 0 },
            { 6, 0, 0, 0, 0, 2, 0, 0, 0, 0 },
            { 0, 0, 0, 7, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 2, 0, 0, 0, 0, 0 },
            { 0, 9, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 5, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 8, 7, 0, 0, 0 }
    };

    static int[] heuristic_vector = { 5, 7, 3, 4, 6, 8, 5, 0, 0, 0 };

    static String[] names = { "A", "B", "C", "D", "E", "H", "J", "G1", "G2", "G3" };

    static void printNeighbours(int node) {
        for (int i = 0; i < cost_matrix.length; i++) {
            if (cost_matrix[i][node] > 0) {
                System.out.println("Neighbour: " + names[i] + ". Cost: " + cost_matrix[i][node] + " Heuristic: "
                        + heuristic_vector[i]);
            }
        }
    }

    static int pathCost(int[] path) {
        // Have a count variable and add the cost of each traverse
        // At position i, we are leaving path[i]
        // int[] path example -> {0,4,6,9} {A, E, J, G3}
        int count = 0;

        for (int i = 0; i < path.length - 1; i++) {
            // col is from
            int col = path[i];
            // row is to
            int row = path[i + 1];
            int cost = cost_matrix[row][col];

            if (cost == 0) {
                return -1;
            }

            count += cost;
        }

        return count;

    }

    static ArrayList<Integer> getNeighbours(TreeNode current) {
        ArrayList<Integer> neighbours = new ArrayList<>();

        for (int i = 0; i < cost_matrix.length; i++) {
            if (cost_matrix[i][current.val] > 0) {
                neighbours.add(i);
            }
        }
        return neighbours;
    }

    static void search(int start) {
        TreeNode root = new TreeNode(start, null);

        LinkedList<TreeNode> frontier = new LinkedList<>();
        frontier.add(root);

        while (!frontier.isEmpty()) {
            TreeNode current = frontier.poll();
            ArrayList<Integer> neighbours = getNeighbours(current);
            for (int i = 0; i < neighbours.size(); i++) {
                TreeNode next = new TreeNode(neighbours.get(i), current);
                frontier.add(next);
            }
        }

    }

    // static void bfs()

    public static void main(String[] args) {
        // Print Neighbours
        // for (int i = 0; i < names.length; i++) {
        // System.out.println("From " + names[i]);
        // printNeighbours(i);

        // }

        // get Path Cost for a path from start to goal
        int[] path = { 0, 4, 6, 9 };
        System.out.println(pathCost(path));
    }

}
