package round4.leetcode.tree;

public class KthSmallest_230 {
    /*
        节省空间，递归思路
        1. 先统计左子树的节点个数
        2. 如果左节点个数刚好为 k - 1 个，当前根节点则刚好为第 k 小的元素直接返回
        3. 如果左节点个数 > k - 1，说明目标在左子树中，往左子树走；反之，往右子树走
    */
    // 返回第 k 小的元素
    public int kthSmallest(TreeNode root, int k) {
        // 如果为空则不存在
        if (root == null)
            return -1;

        // 统计左子树节点个数
        int leftNum = countNode(root.left);
        if (leftNum == k - 1)
            return root.val;
        // 目标在左子树中，往左子树走
        if (leftNum > k - 1)
            return kthSmallest(root.left, k);
        // 反之，往右子树走，找 k - leftNodeNum - 1
        return kthSmallest(root.right, k - leftNum - 1);
    }

    // 统计节点个数
    private int countNode(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }
}
