package round1.tree;

public class SearchBST_700 {
    // 1. 传入目标值和节点，返回根节点
    public TreeNode searchBST(TreeNode root, int val) {
        // 2. 结束条件：根节点为空返回空，等于 val 返回节点
        if (root == null || root.val == val)
            return root;
        // 3. 根据值来向左右遍历
        if (val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}
