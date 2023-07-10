package coding.treenode;

public class ConstructMaximumBinaryTree_14 {
    /*
        构造树一般采用的是前序遍历，因为先构造中间节点，然后递归构造左子树和右子树

     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildMaxTree(nums, 0, nums.length);
    }

    private TreeNode buildMaxTree(int[] nums, int left, int right) {
        if (right - left < 1)
            return null;
        // 只有一个元素
        if (right - left == 1)
            return new TreeNode(nums[left]);

        // 记录最大值和最大值在数组中所在位置
        int maxIndex = left;
        int maxVal = nums[maxIndex];
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        // 构造中节点，根据 maxIndex 划分左右子树，区间左开右闭
        TreeNode root = new TreeNode(maxVal);
        root.left = buildMaxTree(nums, left, maxIndex);
        root.right = buildMaxTree(nums, maxIndex + 1, right);
        return root;
    }
}
