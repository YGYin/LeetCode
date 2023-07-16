package coding.treenode;

public class InsertIntoBST_22 {
    /*
        其实可以不考虑题目中提示所说的改变树的结构的插入方式。
        只要按照二叉搜索树的规则去遍历，遇到空节点就插入节点就可以了
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode cur = root;
        while (true) {
            if (val < cur.val && cur.left != null)
                cur = cur.left;
            else if (val > cur.val && cur.right != null)
                cur = cur.right;
            else
                break;
        }
        if (val < cur.val)
            cur.left = new TreeNode(val);
        else
            cur.right = new TreeNode(val);

        return root;
    }

    // 递归
    public TreeNode insertIntoBST_2(TreeNode root, int val) {
        // 终止条件为遍历到节点为 null 的时候即为要插入节点的位置
        if (root == null)
            return new TreeNode(val);

        if (val > root.val)
            root.right = insertIntoBST_2(root.right, val);
        if (val < root.val)
            root.left = insertIntoBST_2(root.left, val);
        return root;
    }
}
