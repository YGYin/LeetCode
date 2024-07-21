package round2.tree;

public class IsValidBST_98 {
    /*
        验证二叉搜索树
        需要利用二叉搜索树的特性，中序遍历时为一个升序数组，可以中序遍历保存到数组中，
        然后判断是否为升序数组

        也可以优化为，在中序遍历过程中就使用双指针，来比较当前节点是否大于前一个节点的值
     */
    // 记录前一个节点的值，默认为最小值，因为节点可能存在 Integer.MIN_VALUE，所以初始值应为 Long 的最小值
    long prev = Long.MIN_VALUE;

    // 1. 传入当前根节点，返回当前节点是否满足二叉搜索树条件
    public boolean isValidBST(TreeNode root) {
        // 中序遍历
        // 2. 结束条件: 节点为空时为二叉搜索树
        if (root == null)
            return true;

        // 左，只要符合就一直向左遍历，左子树不符合就 return false
        if (!isValidBST(root.left))
            return false;
        // 中，和前一个节点做比较，如果当前节点 <= 前一个节点为 false, 更新 prev 的值
        if (root.val <= prev)
            return false;
        prev = root.val;

        // 右
        return isValidBST(root.right);
    }
}
