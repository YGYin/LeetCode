package coding.treenode;

public class IsBalanced_06 {
    /*
        递归，后序遍历
        1. 判断返回值和参数，把根节点传进去，高度差大于 1 返回 -1，否则返回 0
        2. 终止条件：遇到空节点为终止，表示当前根节点的树高度为 0
        3. 明确单层逻辑：分别求出左右子树高度，差值小于 1 返回当前二叉树高度
                        否则返回 -1
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1)
            return -1;

        int res;
        if (Math.abs(rightHeight - leftHeight) > 1)
            res = -1;
        else
            res = Math.max(leftHeight, rightHeight) + 1;

        return res;
    }
}
