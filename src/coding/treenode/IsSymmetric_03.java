package coding.treenode;

public class IsSymmetric_03 {
    /*
        1. 确定递归函数的参数和返回值
        比较的是根节点的两个子树是否是相互翻转的，进而判断这个树是不是对称树，
        所以要比较的是两个树，参数自然也是左子树节点和右子树节点。

        2. 确认终止条件
        要比较两个节点数值相不相同，首先要把两个节点为空的情况弄清楚，
        否则后面比较数值的时候就会操作空指针了。

        3. 确认单层递归的逻辑
        此时才进入单层递归的逻辑，
        单层递归的逻辑就是处理 左右节点都不为空，且数值相同的情况。
        - 比较二叉树外侧是否对称：传入的是左节点的左孩子，右节点的右孩子
        - 比较内侧是否对称，传入左节点的右孩子，右节点的左孩子
        - 如果左右都对称就返回 true，有一侧不对称就返回 false
     */
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null)
            return false;
        if (left != null && right == null)
            return false;
        if (left == null && right == null)
            return true;
        if (left.val != right.val)
            return false;
        // 比较两棵树的外侧
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);

        return outside && inside;
    }

}
