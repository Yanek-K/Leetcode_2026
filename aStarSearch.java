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

    static void pathCost(int[] path) {

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("From " + names[i]);
            printNeighbours(i);

        }
    }

}
