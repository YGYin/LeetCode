package round2.hot100.tree;

public class LowestCommonAncestor_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
            因为 p q 一定存在于树中，本质上就是搜哪棵子树存在 p 和 q
            结束条件：看是否为空或存在 p q
         */
        if (root == null || root == p || root == q)
            return root;
        // 分别向左和向右遍历，接住左右节点做后续处理
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 根据左右子树是否为空情况来返回
        if (left == null && right != null)
            return right;
            // 两个都不为空，说明当前根节点就是公共祖先
        else if (left != null && right != null)
            return root;
        else
            return left;
    }
}
