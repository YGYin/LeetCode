package coding.treenode;

public class MergeTrees_15 {
    // 1. 返回构造好的树的根节点，传入两棵树的根节点
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 2. 终止条件
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        /*
            构造树一般前序遍历，如果需要构造新树可以
            TreeNode res = new TreeNode(0);
            res.val += t1.val + t2.val;
            单层逻辑：t1 和 t2 都不为空，不定义新的树，直接修改 t1
        */
        root1.val += root2.val;
        // 左右
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
