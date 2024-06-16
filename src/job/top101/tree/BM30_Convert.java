package job.top101.tree;

public class BM30_Convert {
    /*
        将二叉搜索树转换成双向链表
        主要思路：用双指针 pre 和 root
        使用中序遍历，用 pre 指针指向 root 的前继节点，cur 指向当前节点
        对于中序节点，当 root.left 指向前继节点 pre 时，当前节点的左孩子已经遍历完成，root.left 可以被修改
     */
    // 需要定义全局 pre
    TreeNode pre;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        // 因为要返回双向链表的第一个节点
        // 需要先遍历到二叉搜索树的最左边记录头
        TreeNode head = pRootOfTree;
        while (head.left != null)
            head = head.left;
        // 中序遍历
        inorderTraversal(pRootOfTree);
        return head;
    }

    // 1. 不需要返回节点，传入当前根节点 cur
    private void inorderTraversal(TreeNode cur) {
        // 2. 结束条件为遍历到空节点时返回
        if (cur == null)
            return;
        // 3. 左中右，中间处理逻辑为建立双向链表
        inorderTraversal(cur.left);
        // 对于当前节点，指向前继节点
        cur.left = pre;
        // 前继节点指向当前节点(前继节点有可能为空，需判空)
        if (pre != null)
            pre.right = cur;
        // 移动前继节点的指针
        pre = cur;
        inorderTraversal(cur.right);
    }
}
