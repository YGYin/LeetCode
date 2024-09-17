package round2.hot100.tree;

public class DiameterOfBinaryTree_543 {
    /*
        二叉树的直径
        类似求最大深度，但是需要变量记录当前的最长路径，
        因为最长路径不一定经过根节点，所以每次要单独比较更新最长路径，再计算最大深度
     */
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root.left == null && root.right == null)
            return 0;
        getDepth(root);
        return maxDiameter;
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        // 当前节点的最大直径，为左子树加上其右子树的深度和当前最大值做比较
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }

}
