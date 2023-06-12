package Top101.tree;

public class BM38_LowestCommonAncestor {
    /*
        1. DFS
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        TreeNode res = dfs(root, o1, o2);
        return res == null ? -1 : res.val;
    }

    private TreeNode dfs(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2)
            return root;
        TreeNode left = dfs(root.left, o1, o2);
        TreeNode right = dfs(root.right, o1, o2);

        if (left == null)
            return right;
        // 右子树没找到，则在左子树中
        if (right == null)
            return left;
        // 否则是当前节点
        return root;
    }

    /*
        2. 递归
        step 1：如果 o1 和 o2 中的任一个和 root 匹配，那么root就是最近公共祖先。
        step 2：如果都不匹配，则分别递归左、右子树。
        step 3：如果有一个节点出现在左子树，并且另一个节点出现在右子树，则root就是最近公共祖先.
        step 4：如果两个节点都出现在左子树，则说明最低公共祖先在左子树中，否则在右子树。
        step 5：继续递归左、右子树，直到遇到 step1 或者 step3 的情况。
     */
    public int lowestCommonAncestor_2(TreeNode root, int o1, int o2) {
        // 子树没找到该节点
        if (root == null)
            return -1;
        // 该节点是子树中的其中某一个节点
        if (root.val == o1 || root.val == o2)
            return root.val;
        // 分别递归左右子树寻找公共祖先
        int left = lowestCommonAncestor_2(root.left, o1, o2);
        int right = lowestCommonAncestor_2(root.right, o1, o2);
        // 左子树没找到，则在右子树中
        if (left == -1)
            return right;
        // 右子树没找到，则在左子树中
        if (right == -1)
            return left;
        // 否则是当前节点
        return root.val;
    }
}
