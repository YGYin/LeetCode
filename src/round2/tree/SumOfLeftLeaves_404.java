package round2.tree;

public class SumOfLeftLeaves_404 {
    /*
        左叶子之和
        判断左叶子只能从当前节点出发进行判断，
        当该节点的左孩子不为空，且其左孩子的左右孩子都为空，此时该节点的左孩子节点为左叶子节点
     */
    // 记录左叶子节点的和
    int sum = 0;

    // 1. 传入当前节点，返回左孩子节点的和
    public int sumOfLeftLeaves(TreeNode root) {
        // 2. 当当前节点为空说明不是左叶子节点，和为 0
        if (root == null)
            return 0;
        // 后序遍历，左右
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        // 中，判断是否左叶子节点，是则更新和
        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;

        return sum;
    }
}
