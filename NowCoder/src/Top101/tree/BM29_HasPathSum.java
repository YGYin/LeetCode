package Top101.tree;

import java.util.Stack;

public class BM29_HasPathSum {
    /*
        1. DFS 双栈辅助遍历
        step 1：首先检查空节点，空树没有路径。
        step 2：使用两个栈同步遍历，一个栈记录节点，辅助深度优先搜索，另一个栈跟随记录到该节点为止的路径和。
                根节点及根节点值先进栈。
        step 3：遍历的时候每次弹出两个栈中的内容，判断是否是叶子节点且路径和是否等于目标值。
        step 4：没有到叶子节点就将左右子节点（如果有）加入栈中，并跟随加入路径和。
        step 5：如果遍历结束也没有找到路径和，则该二叉树中没有。

        时间复杂度: O(n)，其中 n 为二叉树的节点数，每个节点访问一次
        空间复杂度: O(n)，最坏情况二叉树化为链表，递归栈空间最大为 n
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        nodeStack.push(root);
        sumStack.push(root.val);

        while (!nodeStack.isEmpty()) {
            // 弹出相应节点到该点为止的当前路径和
            TreeNode curNode = nodeStack.pop();
            Integer curSum = sumStack.pop();
            if (curNode.left == null && curNode.right == null && curSum == sum)
                return true;
            // 左节点进栈
            if (curNode.left != null) {
                nodeStack.push(curNode.left);
                sumStack.push(curSum + curNode.left.val);
            }
            // 右节点进栈
            if (curNode.right != null) {
                nodeStack.push(curNode.right);
                sumStack.push(curSum + curNode.right.val);
            }
        }
        return false;
    }

    /*
        2. 二叉树递归
        终止条件：每当遇到节点为空，意味着过了叶子节点，返回。
                 每当检查到某个节点没有子节点，它就是叶子节点，此时sum减去叶子节点值刚好为0，说明找到了路径。
        返回值：将子问题中是否有符合新目标值的路径层层往上返回。
        本级任务：每一级需要检查是否到了叶子节点，如果没有则递归地进入子节点，同时更新 sum 值减掉本层的节点值。
     */
    public boolean hasPathSum_2(TreeNode root, int sum) {
        // 空节点找不到路径
        if (root == null)
            return false;
        // 判断是子节点，且路径和刚好为 sum
        if (root.left == null && root.right == null && sum - root.val == 0)
            return true;
        // 递归进入子节点
        return hasPathSum_2(root.left, sum - root.val) || hasPathSum_2(root.right, sum - root.val);
    }
}
