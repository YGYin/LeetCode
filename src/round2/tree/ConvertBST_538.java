package round2.tree;

public class ConvertBST_538 {
    /*
        把二叉搜索树转换为累加树
     */
    // 记录上一个节点的值，以方便进行累加
    int pre = 0;

    public TreeNode convertBST(TreeNode root) {
        sumTreeNode(root);
        return root;
    }

    // 传入根节点，不需要返回值
    private void sumTreeNode(TreeNode root) {
        if (root == null)
            return;
        // 右中左
        sumTreeNode(root.right);
        // 先累加，再记录当前值供下一个节点使用
        root.val += pre;
        pre = root.val;
        sumTreeNode(root.left);
    }
}
