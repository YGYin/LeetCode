package round2.tree;

public class TrimBST_669 {
    /*
        修剪二叉搜索树
        主要思想：如果当前节点小于最小边界的话，将其右子节点返回作为根节点的左节点
                如果当前节点大于最大有边界的话，将其左子节点返回作为根节点的右节点
     */

    // 1. 返回在边界范围内的节点，方便根节点接住，传入根节点和左右边界
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 如果当前节点为空，返回空
        if (root == null)
            return root;
        // 如果根节点比左边界还小，将其右子树符合条件的节点返回
        if (root.val < low)
            return trimBST(root.right, low, high);
        // 当前节点值比右边界还大，返回其左边比它小符合条件的节点
        if (root.val > high)
            return trimBST(root.left, low, high);

        // 用根节点分别接住符合的左右节点
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
