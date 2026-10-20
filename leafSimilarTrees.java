public class leafSimilarTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

    }

    public int countHeight(TreeNode root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(countHeight(root.left), countHeight(root.right));
    }

    public static void main(String[] args) {
        TreeNode root1 = [3,5,1,6,2,9,8,null,null,7,4]
    }

}
