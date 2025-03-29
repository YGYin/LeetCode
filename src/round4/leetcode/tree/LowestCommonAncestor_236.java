package round4.leetcode.tree;

public class LowestCommonAncestor_236 {
    /*
        二叉树的最近公共祖先
        本质上就是通过后序遍历，自底向上看子节点或当前节点是否存在 p 和 q
        返回等于 p 或 q 的节点或者 空节点，传入根节点以及 p 和 q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
            因为 p q 一定存在于树中，本质上就是搜哪棵子树存在 p 和 q
            结束条件：看是否为空或存在 p q
         */
        if (root == null || root == p || root == q)
            return root;

        // 后序遍历，因为遍历整棵树不是遍历一条边，所以需要接住左右子节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 判断左右子树是否为空的情况，不为空说明存在 p q
        if (left != null && right != null)
            return root;
        else if (left == null)
            return right;
        else
            return left;
    }
}
