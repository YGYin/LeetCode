package coding.treenode;

public class SortedArrayToBST_25 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1)
            return new TreeNode(nums[0]);
        // 区间遵循左闭右开
        return buildBST(nums, 0, nums.length);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        // 结束条件：左右指针相交
        if (left >= right)
            return null;
        // 取中间节点分割数组，构建根节点
        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }
}
