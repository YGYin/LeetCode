package Top101.tree;

public class BM30_Convert {
    // 返回的第一个指针，为最小值
    TreeNode head = null;
    // 中序遍历当前值的上一位，开始的初值也为最小值
    TreeNode pre = null;

    /*
        二叉搜索树最左端的元素一定最小，最右端的元素一定最大，符合“左中右”的特性
        因此二叉搜索树的中序遍历就是一个递增序列，我们只要对它中序遍历就可以组装称为递增双向链表。

        step 1：创建两个指针，一个指向题目中要求的链表头（head），一个指向当前遍历的前一节点（pre)。
        step 2：首先递归到最左，初始化head与pre。
        step 3：然后处理中间根节点，依次连接pre与当前节点，连接后更新pre为当前节点。
        step 4：最后递归进入右子树，继续处理。
        step 5：递归出口即是节点为空则返回。
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        // 中序递归，叶子节点为空则返回
        if (pRootOfTree == null)
            return null;
        // 递归到最左侧，即为最小值
        Convert(pRootOfTree.left);
        // 找到最小值后初始化 head 和 pre
        if (pre == null) {
            head = pRootOfTree;
            pre = pRootOfTree;
        }
        // 令当前节点与上一节点建立连接，再更新 pre 为当前值
        else {
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return head;
    }
}
