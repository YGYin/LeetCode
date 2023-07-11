package coding.treenode;

import java.util.Stack;

public class GetMinimumDifference_18 {
    private int res = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;
        traversal(root);
        return res;
    }

    /*
        思路：因为是二叉搜索树，采用中序双指针遍历，可以记录 pre 和 cur 差值的最小值
     */
    private void traversal(TreeNode root) {
        if (root == null)
            return;
        // 左
        traversal(root.left);
        // 中，因为 pre 默认为空，操作前需要判断
        // 且因为是二叉搜索树，中序为递增数列所以不用套绝对值
        if (pre != null)
            res = Math.min(res, root.val - pre.val);
        pre = root;
        traversal(root.right);
    }

    // 迭代中序遍历
    public int getMinimumDifference_2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        int result = Integer.MAX_VALUE;
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                if (cur.right != null)
                    stack.push(cur.right);
                stack.push(cur);
                stack.push(null);
                if (cur.left != null)
                    stack.push(cur.left);
            }
            // 遇到空，下一个则为待处理的中序节点
            else {
                TreeNode temp = stack.pop();
                if (pre != null)
                    result = Math.min(result, temp.val - pre.val);
                pre = temp;
            }
        }
        return result;
    }

}
