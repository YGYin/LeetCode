package round1.tree;

public class SumOfLeftLeaves_404 {
    // 1. 返回值为左叶子节点的和，传入父节点
    //    (因为没有办法通过子节点本身判断是否为左叶子节点)
    public int sumOfLeftLeaves(TreeNode root) {
        // 求左子叶节点之和
        // 左叶子节点定义：左子节点不为空 且 左子节点的左右孩子为空
        // 后序遍历以返回子节点结果给父节点

        // 2. 确定终止条件：节点本身为空为 0
        if (root == null)
            return 0;
        // 遍历到子节点也必定为 0，没有办法通过子节点判断是否为左叶子节点(可以不写)
        if (root.left == null && root.right == null)
            return 0;

        // 左，
        int leftVal = sumOfLeftLeaves(root.left);
        // 右
        int rightVal = sumOfLeftLeaves(root.right);
        // 中，返回左右子树的左叶子节点的和
        // 3. 确定处理逻辑，遇到左叶子节点的时候记录数值
        int curVal = 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            curVal = root.left.val;
        return leftVal + rightVal + curVal;
    }

}
