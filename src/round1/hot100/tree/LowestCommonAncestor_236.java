package round1.hot100.tree;

public class LowestCommonAncestor_236 {
    // 235. 返回最近公共祖先，传入根节点以及 p q
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 二叉树的最近公共祖先
        // 本质就是判断左右子树是否出现过 p q

        // 根节点为空时返回
        if (root == null)
            return null;
        // 以及根节点为 p q 时返回
        if (root == p || root == q)
            return root;

        // 使用后序遍历将左右子树的是否存在 p 的情况返回给根节点
        // 左
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 中处理逻辑，看左右子树是否存在 p q
        if (left != null && right != null)
            return root;
        if (left == null && right != null)
            return right;
        // 剩下情况左不为空右为空，返回左；或者左右为空返回其中任意节点
        return left;
    }

    // 236. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        // 需要利用二叉搜索树的性质
        // 当遇到第一个位于 [p, q] 或者 [q, p] 范围内的节点就是最近公共节点
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor_2(root.right, p, q);
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor_2(root.left, p, q);
        // 刚好位于区间 [p, q]
        return root;
    }
}
