import java.util.*;

public class trees {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Blank Constructor
        // Val becomes 0 , left and right are null
        TreeNode() {
        }

        // Constructor 2
        // Value only
        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        else {
            return 1 + Math.max(maxDepth(root.left),
                    maxDepth(root.right));
        }

    }

    static void dfsWithStack(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root); // starts here. add the root to the to-do list [3]

        while (!stack.isEmpty()) { // loops until the to-do list is empty
            TreeNode node = stack.pop(); // Take the top of the stack off
            System.out.println(node.val); // Do something...

            if (node.left != null) { // Add left children if they exist
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right); // Add rigth children if they exist
            }
        }

    }

    // Build a tree from an array
    static Map<Integer, List<Integer>> buildTree(Integer[] arr) {

        Map<Integer, List<Integer>> tree = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null)
                continue; // empty spot, skip it

            List<Integer> kids = new ArrayList<>();
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length && arr[left] != null)
                kids.add(arr[left]);
            if (right < arr.length && arr[right] != null)
                kids.add(arr[right]);

            if (!kids.isEmpty())
                tree.put(arr[i], kids);
        }
        return tree;
    }

    public static void main(String[] args) {

        // 3
        // / \
        // 9 20
        // / \
        // 15 7

        // Test DFS
        TreeNode root = new TreeNode(3,
                new TreeNode(9), new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));

        System.out.println(maxDepth(root));
        dfsWithStack(root);

        // Convert an array to a tree
        Integer[] arr = { 3, 5, 1, 6, 2, 9, 8, null, null, 7, 4 };
        Map<Integer, List<Integer>> tree = buildTree(arr);
        System.out.println("BFS: " +

                bfs(3, tree));
        System.out.println("DFS: " + dfs(3, tree));

    }
}
