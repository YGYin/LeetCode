package round3.hot100.tree;

public class IsValidBST_98 {
    /*
        验证二叉搜索树
        二叉搜索树按中序遍历为升序数组，可以先保存到 list 中，再遍历看是否符合升序
        或者使用双指针，比较是否比前一个元素小
     */

    // 定义全局 prev 记录上一个变量
    private int prev = Integer.MIN_VALUE;

    // 返回是否符合二叉搜索树
    public boolean isValidBST(TreeNode root) {
        // 为空，是二叉搜索树
        if (root == null)
            return true;

        // 中序遍历，如果是二叉搜索树，就一直向当前方向遍历，不符合返回 false
        if (!isValidBST(root.left))
            return false;
        // 中，判断是否符合递增，不符合返回 false，符合更新 prev
        if (root.val <= prev)
            return false;
        prev = root.val;
        // 右
        return isValidBST(root.right);
    }
}
