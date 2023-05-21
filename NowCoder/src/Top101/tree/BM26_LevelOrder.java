package Top101.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class BM26_LevelOrder {
    /*
        1. 首先判断二叉树是否为空，空树没有遍历结果
        2. 建立辅助队列，根节点首先进入队列。不管层次怎么访问，
           根节点一定是第一个，那它肯定排在队伍的最前面
        3. 每次进入一层，统计队列中元素的个数。
           因为每当访问完一层，下一层作为这一层的子节点，一定都加入队列，
           而再下一层还没有加入，因此此时队列中的元素个数就是这一层的元素个数
        4. 每次遍历这一层这么多的节点数，将其依次从队列中弹出，
           然后加入这一行的一维数组中，如果它们有子节点，依次加入队列排队等待访问
        5. 访问完这一层的元素后，将这个一维数组加入二维数组中，再访问下一层

        时间复杂度: O(n)，其中 n 为二叉树的节点数，每个节点访问一次
        空间复杂度: O(n)，队列的空间为二叉树的一层的节点数，最坏情况二叉树的一层为 O(n)

     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        // 新建普通队列，用于层次遍历，并将根节点加入队列
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<>();
            int qSize = queue.size();
            // 因为一开始进入队列的是根节点，所以每层节点数是多少，队列大小就是多少
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = queue.poll();
                row.add(curNode.val);
                // 若根节点存在左右子节点，存入左右直接点作为下一层
                if (curNode.left != null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);
            }
            // 将该层的 row list 添加到 res 当中
            res.add(row);
        }
        return res;
    }
}
