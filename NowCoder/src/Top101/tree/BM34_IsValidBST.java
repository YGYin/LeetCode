package Top101.tree;

public class BM34_IsValidBST {
    int preVal = Integer.MIN_VALUE;

    /*
        二叉搜索树的特性就是中序遍历是递增序。既然是判断是否是二叉搜索树，那我们可以使用中序递归遍历。
        只要之前的节点是二叉树搜索树，那么如果当前的节点小于上一个节点值那么就可以向下判断。
     */
    public boolean isValidBST(TreeNode root) {
        // 中序遍历
        if (root == null)
            return true;
        // 进入左子树，递归到最左
        if (!isValidBST(root.left))
            return false;
        // 判断当前节点是不是小于前置节点
        if (root.val < preVal)
            return false;
        // 更新前置节点
        preVal = root.val;
        // 进入右子树
        return isValidBST(root.right);
    }
}
