package round1.hot100.tree;

public class DiameterOfBinaryTree_543 {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 类似与求最大深度
        getDepth(root);
        return maxDiameter;
    }

    private int getDepth(TreeNode root) {
        // 遍历到空的时候到尽头
        if (root == null)
            return 0;
        // 左右中，后续遍历获取左右子树的深度
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        // 当前节点的最大直径，为左子树加上其右子树的深度和当前最大值做比较
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }
}
