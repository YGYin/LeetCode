package Top101.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class BM27_Print {
    /*
        思路与 BM26 二叉树层次遍历相同，加入 flag 判断用于反转单行数组
        单行反转，双行不反转
        时间复杂度: O(n)，其中 n 为二叉树的节点数，每个节点访问一次
        空间复杂度: O(n)，队列的空间为二叉树的一层的节点数，最坏情况二叉树的一层为 O(n)
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        // 新建队列用于层次遍历，将根节点加入队列
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        boolean flag = true;
        while (!queue.isEmpty()) {
            // 新建数组储存每列节点的数值
            ArrayList<Integer> row = new ArrayList<>();
            // 奇数行反转，偶数行不反转
            flag = !flag;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = queue.poll();
                row.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            if (flag)
                Collections.reverse(row);
            res.add(row);
        }
        return res;
    }
}
