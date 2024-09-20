package round2.hot100.tree;

public class IsValidBST_98 {
    /*
        验证二叉搜索树
        二叉搜索树按中序遍历为升序数组，可以先保存到 list 中，再遍历看是否符合升序
        或者使用双指针，比较是否比前一个元素小
     */

    // 因为节点的值有可能存在 Integer 的最小值，所以定义初始值为 long 的最小值
    long prevVal = Long.MIN_VALUE;

    // 传入当前根节点，看是否满足二叉搜索树条件
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        // 中序遍历
        // 只要符合就一直向左遍历
        if (!isValidBST(root.left))
            return false;
        // 中，比较当前节点的值和前一个节点的值
        // 不符合递增则返回
        if (root.val <= prevVal)
            return false;
        // 更新 prev 指针的值为当前值
        prevVal = root.val;

        // 右
        return isValidBST(root.right);
    }
}
