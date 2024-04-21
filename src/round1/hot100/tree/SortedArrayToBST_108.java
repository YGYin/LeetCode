package round1.hot100.tree;

public class SortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        // 左闭右闭区间
        // 结束条件：左边界大于右边时树为空
        if (left > right)
            return null;

        // 总是选择中间的左边节点来构建
        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }
}
