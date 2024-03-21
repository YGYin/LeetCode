package round1.tree;

public class LowestCommonAncestor_236 {

    // 自底向上查找，后序
    // 1. 返回公共祖先节点，传入根节点和左右节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 2. 结束条件
        // 节点为空
        if (root == null)
            return null;
        // 遇到 p q 向上返回，包含了 p q 其中一个点为两者的公共祖先的情况
        if (root == p || root == q)
            return root;
        // 左
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 中
        // 3. 左和右子树都不为空的话，说明当前节点为最近公共祖先节点
        if (left != null && right != null)
            return root;
        //    单边为空，另外一边不为空，返回不为空找到 p q 的那边
        if (left == null & right != null)
            return right;
        //    左右为空，返回空 (左右任意)
        return left;
    }
}
