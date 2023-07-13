package coding.treenode;

public class LowestCommonAncestor_20 {
    /*
        思路：从下往上查找最近公共祖先，处理二叉树使用后序遍历
        判断公共祖先：
                如果找到一个节点，发现左子树出现结点 p，右子树出现节点 q，
                或者左子树出现结点 q，右子树出现节点 p，那么该节点就是节点 p 和 q 的最近公共祖先
        判断逻辑：
                如果递归遍历遇到 q，就将 q 返回，遇到 p 就将 p 返回，
                那么如果左右子树的返回值都不为空，说明此时的中节点，一定是 q 和 p 的最近祖先

     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 中，左右结果已经拿到后，需要对左右是否为空的情况分类讨论
        if (left != null && right != null)
            return root;
        else if (left != null && right == null)
            return left;
        else if (left == null && right != null)
            return right;
        else
            return null;
    }
}
