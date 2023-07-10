package coding.treenode;

import java.util.Stack;

public class IsValidBST_17 {
    /*
        思路：利用二叉搜索树的特性，中序遍历时为单调递增数列
     */
    private TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        // 结束条件：为空时满足搜索二叉树条件
        if (root == null)
            return true;
        // 左
        boolean left = isValidBST(root.left);
        // 中，第一次对比可能为空，每次对比完需要更新 pre
        if (pre != null && pre.val >= root.val)
            return false;
        pre = root;
        // 右
        boolean right = isValidBST(root.right);

        return left && right;
    }

    // 迭代
    public boolean isValidBST_2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        // 加入第一个根节点
        if (root != null)
            stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                // 因为栈，实现中序遍历 需要按右中左顺序压栈
                if (cur.right != null)
                    stack.add(cur.right);
                // 中
                stack.add(cur);
                // 中节点访问过，但是还没有处理，加入空节点做为标记
                stack.add(null);
                if (cur.left != null)
                    stack.add(cur.left);
            }
            // 当前节点为空，处理中节点
            else {
                // 弹出空节点标记的下一个节点
                TreeNode temp = stack.pop();
                if (pre != null && pre.val >= temp.val)
                    return false;
                pre = temp;
            }
        }
        return true;
    }
}
