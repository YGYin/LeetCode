package Top101.tree;

import java.util.ArrayList;

public class BM37_LowestCommonAncestor {
    /*
        二叉搜索树是一种特殊的二叉树，它的每个节点值大于它的左子节点，
        且大于全部左子树的节点值，小于它右子节点，且小于全部右子树的节点值。
        因此二叉搜索树一定程度上算是一种排序结构，可轻松找到 p, q

        step 1: 根据二叉搜索树的性质，从根节点开始查找目标节点，当前节点比目标小则进入右子树，
                当前节点比目标大则进入左子树，直到找到目标节点。这个过程成用数组记录遇到的元素。
        step 2: 分别在搜索二叉树中找到p和q两个点，并记录各自的路径为数组。
        step 3: 同时遍历两个数组，比较元素值，最后一个相等的元素就是最近的公共祖先。

        时间复杂度: O(n)，设二叉树共有 n 个节点，因此最坏情况二叉搜索树变成链表，搜索到目标节点需 O(n)
        空间复杂度: O(n)，记录路径的数组最长为 n
     */
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        // 存储根节点到这两个节点的路径
        ArrayList<Integer> path_p = getPath(root, p);
        ArrayList<Integer> path_q = getPath(root, q);
        int res = 0;
        // 先比较两个路径，找到第一个不同的点
        for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
            int pVal = path_p.get(i);
            int qVal = path_q.get(i);
            // 最后一个相同点就是最近的公共祖先
            if (pVal == qVal)
                res = pVal;
            else
                break;
        }
        return res;
    }

    private ArrayList<Integer> getPath(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        TreeNode cur = root;
        while (cur.val != target) {
            path.add(cur.val);
            // 根据大小选择二叉搜索树的左右
            if (target < cur.val)
                cur = cur.left;
            else
                cur = cur.right;
        }
        // 把目标值也添加到路径中
        path.add(cur.val);
        return path;
    }
}
