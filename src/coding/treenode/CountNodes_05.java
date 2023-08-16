package coding.treenode;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodes_05 {
    // 1. BFS 层序遍历
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int result = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = que.poll();
                ++result;
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
        }
        return result;
    }

    // 2. 递归，后序遍历，普通二叉树都适用
    public int countNodes_rec(TreeNode root) {
        return getNodes(root);
    }

    private int getNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftNodes = getNodes(root.left);
        int rightNodes = getNodes(root.right);
        // 左子树所有节点 + 右子树所有节点 + 根节点本身
        return leftNodes + rightNodes + 1;
    }

    /*
        针对完全二叉树的解法
        满二叉树的结点数为：2^depth - 1
     */
    public int countNodes_rec2(TreeNode root) {
        if (root == null)
            return 0;
        // 记录当前节点的左右子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 为了方便求满二叉树的节点数要用到指数
        // 所以初始值设为 0
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {
            left = left.left;
            ++leftDepth;
        }
        while (right != null) {
            right = right.right;
            ++leftDepth;
        }
        // 注意(2 << 1) 相当于 2^2，所以 leftDepth 初始为 0
        if (leftDepth == rightDepth)
            return (2 << leftDepth) - 1;
        return countNodes_rec2(root.left) + countNodes_rec2(root.right) + 1;
    }

}
