package round2.tree;

public class LowestCommonAncestor_235 {
    /*
        二叉搜索树的最近公共祖先
        利用二叉搜索树特性，当遇到第一个位于 [p, q] 或者 [q, p] 区间内的元素则为 p q 的最近公共祖先
     */
    // 传入根节点，p q，返回最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 要是当前节点都小于 p q，说明公共祖先在右子树
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        // 要是当前节点都大于 p q，说明公共祖先在左子树
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        // 否则当前节点就位于区间内，为最近公共祖先
        return root;
    }
}
