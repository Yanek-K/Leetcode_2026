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

    public static void main(String[] args) {

        // 3
        // / \
        // 9 20
        // / \
        // 15 7

        TreeNode root = new TreeNode(3,
                new TreeNode(9), new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));

        System.out.println(maxDepth(root));

    }
}
