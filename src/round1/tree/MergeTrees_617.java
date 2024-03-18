package round1.tree;

public class MergeTrees_617 {
    // 构造树 -> 前序遍历
    // 1. 传入需要合并的两个节点，返回合并后的节点
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 2. 结束条件：左子节点为空，则返回
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        // 都不为空，则将节点的值相加，分别构造左右子树
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}
