package round2.tree;

public class MergeTrees_617 {
    /*
        合并二叉树
        1. 节点重叠则相加合并为新的值，否则不为空的节点为新二叉树的节点
     */
    // 1. 传两棵树的根节点，返回构造好的二叉树的根节点
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 2. 结束条件：先判断节点为空的情况
        if (root1 == null && root2 == null)
            return null;
        // 其中一个节点为空的情况
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        // 都不为空，构造根节点
        root1.val += root2.val;
        // 递归构造左右子树
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
