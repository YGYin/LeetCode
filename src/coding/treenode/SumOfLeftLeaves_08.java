package coding.treenode;

public class SumOfLeftLeaves_08 {
    /*
        那么判断当前节点是不是左叶子是无法判断的，必须要通过节点的父节点来判断其左孩子是不是左叶子
        如果该节点的左节点不为空，该节点的左节点的左节点为空，该节点的左节点的右节点为空，则找到了一个左叶子
        1. 确定递归函数的参数和返回值
            传入根节点，返回左节点值的和
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        // 只有当前遍历的是父节点才能判断其子节点是不是左叶子
        if (root.left == null && root.right == null)
            return 0;
        // 左
        int leftValue = sumOfLeftLeaves(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null)
            leftValue = root.left.val;
        // 右
        int rightValue = sumOfLeftLeaves(root.right);
        // 中
        return leftValue + rightValue;
    }
}
