package round1.tree;

public class ConstructMaximumBinaryTree_654 {
    // 一般构造树为前序遍历
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return new TreeNode(nums[0]);
        // 左开右闭
        return build(nums, 0, len);
    }

    // 1. 参数为存放元素的数组以及开始和结束下标，返回构造二叉树的头节点
    private TreeNode build(int[] nums, int start, int end) {
        // 2. 确定终止条件：
        //      当传入数组大小为 1 时，说明遍历到了子节点
        //      应该用该值新定义一个节点，返回该节点
        if (end - start < 1)
            return null;
        // 数组只剩一个节点
        if (end - start == 1)
            return new TreeNode(nums[start]);

        // 3. 确定单层递归逻辑
        //      先找数组最大值构造根节点，记录下标分割数组
        //      构造左右子树
        int maxVal = nums[start];
        int maxIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 构造左右子树
        root.left = build(nums, start, maxIndex);
        root.right = build(nums, maxIndex + 1, end);
        return root;
    }


}
