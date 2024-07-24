package round2.tree;

public class InsertIntoBST_701 {
    /*
        二叉搜索树中的插入操作
        因为不要求对二叉搜索树进行重构，所以将 val 和当前值做比较，左小右大
        到最后当前节点为空的时候说明到达插入位置，构造新节点返回
     */
    // 1. 传入根节点和插入的值，返回最后构造好的根节点
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 2. 当前节点为空，到达构造节点位置
        if (root == null)
            return new TreeNode(val);

        // 如果 val 小于当前节点的值，说明在当前节点的左边
        // 实际就是用当前节点作为父节点接住构造的新节点
        if (val < root.val)
            root.left = insertIntoBST(root.left, val);
        if (val > root.val)
            root.right = insertIntoBST(root.right, val);
        // 根节点接收了构造好的节点后向上层返回
        return root;
    }
}
