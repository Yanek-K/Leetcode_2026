/*

*/

import java.util.*;

public class aStarSearch {

    public static class TreeNode {
        // val is position in matrix
        int val;
        // g is cost to get to this node from the starting point.
        int g;
        TreeNode parent;

        TreeNode(int val, int g, TreeNode parent) {
            this.val = val;
            this.g = g;
            this.parent = parent;
        }
    }

    // Helper function to get all neighbours of a node
    static ArrayList<Integer> getNeighbours(TreeNode current, int[][] cost_matrix) {
        ArrayList<Integer> neighbours = new ArrayList<>();

        for (int i = 0; i < cost_matrix.length; i++) {
            if (cost_matrix[i][current.val] > 0) {
                neighbours.add(i);
            }
        }
        return neighbours;
    }

    // The A* Search
    // Returns a TreeNode as the Goal State Found.
    static TreeNode search(int start, int[][] cost_matrix, int[] heuristic_vector, int[] goal_vector) {
        // Create a new Treenode with the starting point
        TreeNode root = new TreeNode(start, 0, null);

        // Create a Priority Queue (min heap) to store the frontier of nodes to visit
        // Take the next item off of the frontier list
        PriorityQueue<TreeNode> frontier = new PriorityQueue<>(
                Comparator.comparingInt(n -> n.g + heuristic_vector[n.val]));

        // Create a int array to keep track of best cost found to each node
        // Fill with MAX so that the first path is always allowed
        int[] reached = new int[heuristic_vector.length];
        Arrays.fill(reached, Integer.MAX_VALUE);

        // Add the root to the frontier of nodes to visit
        frontier.add(root);
        reached[start] = 0;

        while (!frontier.isEmpty()) {

            // Take the next item off of the frontier list
            TreeNode current = frontier.poll();

            // Check if current node is a goal
            if (goal_vector[current.val] == 1) {
                return current;
            }

            // If not a goal, get the current node's neighbours
            // and add them to the frontier to search
            ArrayList<Integer> neighbours = getNeighbours(current, cost_matrix);
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
                reached[next] = newCost;
            }
        }
        return null;

    }

    // Helper function to build the path from the Goal State
    // Uses a stack and pops to reverse the order of the Parent Node
    static int[] getPath(TreeNode current) {
        Deque<Integer> stack = new ArrayDeque<>();

        while (current != null) {
            stack.push(current.val);
            current = current.parent;
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] cost_matrix = {
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

        int[] heuristic_vector = { 5, 7, 3, 4, 6, 8, 5, 0, 0, 0 };
        String[] names = { "A", "B", "C", "D", "E", "H", "J", "G1", "G2", "G3" };

        // Create a goal vector
        int[] goal_vector = new int[heuristic_vector.length];

        for (int i = 0; i < goal_vector.length; i++) {
            goal_vector[i] = heuristic_vector[i] == 0 ? 1 : 0;
        }

        // Perform the A* Search
        TreeNode goalState = search(0, cost_matrix, heuristic_vector, goal_vector);

        // Print the cheapest path
        int[] resultPath = getPath(goalState);

        System.out.println("The cheapest path to " + names[goalState.val] + " is: ");

        for (int path : resultPath) {
            System.out.print(names[path] + " ");
        }
        System.out.println("");
        System.out.println("Total cost to get there is: " + goalState.g);

        // Print Goal State
        System.out.println("Goal State Found: " + names[goalState.val]);

        // Print the number of cycles

    }

}
