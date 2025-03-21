package round4.leetcode.tree;

public class IsValidBST_98 {
    /*
        验证二叉搜索树
        二叉搜索树按中序遍历为升序数组，可以先保存到 list 中，再遍历看是否符合升序
        或者使用双指针进行比较
        中操作：比较当前元素是否满足大于前一个元素
     */

    // 定义指针，用于记录前一个节点，取值范围为 long
    long preVal = Long.MIN_VALUE;

    // 返回是否符合二叉搜索树
    public boolean isValidBST(TreeNode root) {
        // 为空，满足二叉搜索树
        if (root == null)
            return true;

        // 向左遍历，看左子树是否满足二叉搜索树
        if (!isValidBST(root.left))
            return false;
        // 中，当前节点和前一个节点值进行比较，更新指针
        if (root.val <= preVal)
            return false;
        preVal = root.val;

        // 向右遍历，看右子树是否满足二叉搜索树
        return isValidBST(root.right);
    }
}
