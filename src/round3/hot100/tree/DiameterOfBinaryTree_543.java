package round3.hot100.tree;

public class DiameterOfBinaryTree_543 {
    private int maxDiameter = 0;

    /*
            二叉树的直径
            类似求最大深度，但是需要变量记录当前的最长路径，
            因为最长路径不一定经过根节点，所以每次要单独比较更新最长路径，再计算最大深度
         */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        // 返回高度，但不接收
        getDepth(root);
        return maxDiameter;
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;

        // 求左右子树深度
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        // 先单独更新当前最大直径，再返回最大深度
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }
}
