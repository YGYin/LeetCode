package coding.treenode;

public class LowestCommonAncestor_21 {
    /*
        不用使用回溯，二叉搜索树自带方向性，
        可以方便的从上向下查找目标区间，遇到目标区间内的节点，直接返回
     */

    // 1. 参数为当前节点，以及 p q，返回最近公共祖先节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 2. 确定返回条件，遇到空返回
        //    但因为题目前提为 p q 为不同节点且均存在于给定的二叉搜索树中，可不写
        if (root == null)
            return null;
        /*
            3. 确定单层递归逻辑
            如果 cur.val > p.val 且 cur.val > q.val，说明应该往左(小)遍历
            反之同理，当 cur.val 处于 p q 中间时，这位最近公共祖先
         */
        // 左
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        // 右
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        // 刚好值位于中间
        return root;
    }

    // 迭代
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }
}
