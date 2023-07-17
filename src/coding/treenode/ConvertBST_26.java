package coding.treenode;

public class ConvertBST_26 {
    /*
        类似于双指针的思路，累加树相当于将二叉搜索树通过右中左的顺序倒序遍历
        所以需要一个 preSum 变量来记录前一个节点的累加和
        将更新当前节点的值为 当前值加上 preSum，再更新 preSum 的值
     */
    int preSum;

    public TreeNode convertBST(TreeNode root) {
        preSum = 0;
        traversal(root);
        return root;
    }

    private void traversal(TreeNode cur) {
        if (cur == null)
            return;
        // 右
        traversal(cur.right);
        // 中，更新值
        cur.val += preSum;
        preSum = cur.val;
        // 左
        traversal(cur.left);
    }
}
