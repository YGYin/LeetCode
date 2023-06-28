package coding.treenode;

import java.util.*;

public class PreorderTraversal_01 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 1. 确定遍历的返回值和参数
        preTraversal(root, list);
        return list;
    }

    private void preTraversal(TreeNode root, List<Integer> list) {
        // 2. 判断遍历的结束条件
        if (root == null)
            return;
        // 3. 处理节点的逻辑
        preTraversal(root.left, list);
        list.add(root.val);
        preTraversal(root.right, list);

    }

    /*
        用栈模拟前中后序遍历
     */
    public List<Integer> preorderTraversal_I(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            // 因为栈先进后出，压入右左，弹出时处理左右 -> 中左右
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
        return res;
    }

    public List<Integer> postorderTraversal_I(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            // 因为栈先进后出，压入左右，弹出时处理右左 -> 中右左
            if (cur.left != null)
                stack.push(cur.left);
            if (cur.right != null)
                stack.push(cur.right);
        }
        // 再反转 res，中右左 -> 左右中
        Collections.reverse(res);
        return res;
    }

    public List<Integer> midOrderTraversal_I(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 栈用于记录遍历过的节点，指针为空应开始弹出栈中的元素
            else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
