package round2.tree;

public class LowestCommonAncestor_236 {
    /*
        二叉树的最近公共祖先
        后序遍历，将公共祖先往上返回，因为 p q 一定存在且没有重复值的节点，无需特殊处理
        中的处理逻辑就是分析左右子树是否存在 p q，有就晚上返回，没有就返回空
     */
    // 1. 返回 p q 的最近公共祖先，传入当前根节点和 p q
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 2. 结束条件：节点为空时返回为空，如果节点为 p 或 q 将其向上返回
        if (root == null || root == p || root == q)
            return root;
        // 左右
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 中
        // 分别看左右是否为空，都不为空说明当前节点就是最近公共祖先
        if (left != null && right != null)
            return root;
        // 其中一边为空，则说明另外一边有 p q 的最近公共祖先
        if (left == null && right != null)
            return right;
            // 左不为空或者都为空，直接返回左
        else
            return left;
    }
}
