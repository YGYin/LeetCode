package round3.hot100.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest_230 {

    /*
        节省空间，递归思路
        1. 先统计左子树的节点个数
        2. 如果左节点个数刚好为 k - 1 个，当前根节点则刚好为第 k 小的元素直接返回
        3. 如果左节点个数 > k - 1，说明目标在左子树中，往左子树走；反之，往右子树走
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;

        int leftNodeNum = count(root.left);
        if (leftNodeNum == k - 1)
            return root.val;
        else if (leftNodeNum > k - 1)
            return kthSmallest(root.left, k);
            // 到右子树时，其实找的为第 k - leftNodeNum 小的值
        else
            return kthSmallest(root.right, k - leftNodeNum - 1);
    }

    private int count(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + count(root.left) + count(root.right);
    }


    /*
        二叉搜索树中第 K 小的元素
        中序遍历 BST 为有序数组，保存到 list 中，返回下标 k - 1 的元素
     */
    private List<Integer> list;

    public int kthSmallest_2(TreeNode root, int k) {
        list = new ArrayList<>();
        inorder(root);

        // 返回下标 k - 1 的元素，可能 k - 1 存在越界
        return k - 1 >= list.size() ? -1 : list.get(k - 1);
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        // 中序遍历
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
