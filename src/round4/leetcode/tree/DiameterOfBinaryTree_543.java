package round4.leetcode.tree;

public class DiameterOfBinaryTree_543 {
    /*
        二叉树的直径
        类似求最大深度，但是需要全局变量记录当前的最长路径（左子树深度 + 右子树深度），
        因为最长路径不一定经过根节点，所以每次要单独比较更新最长路径，再计算最大深度
    */
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        getDepth(root);
        return maxDiameter;
    }

    // 求深度，同时统计直径(左子树深度 + 右子树深度)
    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;

        // 分别获取左子树和右子树深度
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        // 因为最长路径不一定经过根节点，所以每次要单独比较更新最长路径
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        // 返回最大深度
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
