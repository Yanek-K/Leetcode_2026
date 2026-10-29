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

    static TreeNode search(int start) {
        // Create a new treenode with the starting point
        TreeNode root = new TreeNode(start, null);

        // Create a linked list to store the frontier of nodes to visit
        // Take the next item off of the frontier list
        // Implemented as a First in, First Out Queue
        // ---> LinkedList<TreeNode> frontier = new LinkedList<>();

        // Implemented as a Priority Queue (With minHeap)
        PriorityQueue<TreeNode> frontier = new PriorityQueue<>(Comparator.comparingInt());

        // Create a boolean array to keep track of visited nodes
        boolean[] reached = new boolean[heuristic_vector.length];

        // Add the root to the frontier of nodes to visit
        frontier.add(root);
        reached[start] = true;

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
                // if we have seen this node before skip it
                int next = neighbours.get(i);
                if (reached[next]) {
                    continue;
                }
                // otherwise:
                // Create a new TreeNode,
                // Add it to the frontier and Mark it as visited
                TreeNode nextNode = new TreeNode(next, current);
                frontier.add(nextNode);
                reached[next] = true;
            }
        }
        return null;

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
        // System.out.println(pathCost(path));

        System.out.println(search(0).val);
    }

}
