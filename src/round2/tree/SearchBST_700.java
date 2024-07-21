package round2.tree;

public class SearchBST_700 {
    /*
        二叉搜索树中的搜索
     */
    // 1. 传入当前根节点和目标值，返回该节点值与目标值相等的子树
    public TreeNode searchBST(TreeNode root, int val) {
        // 2. 遍历到为空时返回空，到节点值相等的节点返回该节点
        if (root == null || root.val == val)
            return root;

        // 3. 如果目标值大于当前节点值则向右遍历，否则向左遍历
        return val > root.val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
