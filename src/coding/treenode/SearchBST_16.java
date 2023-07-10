package coding.treenode;

public class SearchBST_16 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val)
            return root;

        TreeNode res = null;
        if (val < root.val)
            res = searchBST(root.left, val);
        else
            res = searchBST(root.right, val);

        return res;
    }
}
