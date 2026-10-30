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
        int g;
        TreeNode parent;

        TreeNode(int val, int g, TreeNode parent) {
            this.val = val;
            this.g = g;
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
            // col is From
            int col = path[i];
            // row is To
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

    static TreeNode search(int start) {
        // Create a new treenode with the starting point
        TreeNode root = new TreeNode(start, 0, null);

        // Create a Priority Queue (min heap) to store the frontier of nodes to visit
        // Take the next item off of the frontier list
        PriorityQueue<TreeNode> frontier = new PriorityQueue<>(
                Comparator.comparingInt(n -> n.g + heuristic_vector[n.val]));

        // Create a int array to keep track of visited nodes
        // Fill with MAX so that the first path is always allowed in
        int[] reached = new int[heuristic_vector.length];
        Arrays.fill(reached, Integer.MAX_VALUE);

        // Add the root to the frontier of nodes to visit
        frontier.add(root);
        reached[start] = 0;

        while (!frontier.isEmpty()) {

            // Take the next item off of the frontier list
            TreeNode current = frontier.poll();

            // Check if current node is a goal
            if (heuristic_vector[current.val] == 0) {
                return current;
            }

            // If not a goal, get the current node's neighbours
            // and add them to the frontier to search
            ArrayList<Integer> neighbours = getNeighbours(current);
            for (int i = 0; i < neighbours.size(); i++) {

                // skip if we already have an equal or cheaper path
                // to this node.
                int next = neighbours.get(i);
                int newCost = current.g + cost_matrix[next][current.val];
                if (reached[next] <= newCost) {
                    continue;
                }

                // Otherwise: Create a new TreeNode,
                // Add it to the frontier and mark it as the best cost
                TreeNode nextNode = new TreeNode(next, newCost, current);
                frontier.add(nextNode);
                System.out.println(frontier.peek().val);
                reached[next] = newCost;
            }
        }
        return null;

    }

    public static void main(String[] args) {

        TreeNode result = search(0);

        System.out.println(names[result.val] + " cost is: " + result.g);
    }

}
