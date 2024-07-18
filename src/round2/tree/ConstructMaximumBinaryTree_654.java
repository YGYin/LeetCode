package round2.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructMaximumBinaryTree_654 {
    /*
        最大二叉树
        1. 先遍历数组找到最大值构造根节点
        2. 再根据根节点划分数组中的左子树(区间)和右子树(区间)
        3. 递归构造左子树和右子树
     */
    Map<Integer, Integer> map;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1)
            return new TreeNode(nums[0]);

        // 要划分区间，需要记录数组元素和下标的关系
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        // 左闭右开
        return buildMaxTree(nums, 0, nums.length);
    }

    // 1. 返回构造好的二叉树的根节点，传入数组以及对应构造树的起始和结束区间
    private TreeNode buildMaxTree(int[] nums, int begin, int end) {
        // 不符合左闭右开时说明没有节点，返回空
        if (begin >= end)
            return null;
        // 找到当前区间的最大值构造根节点
        int maxVal = Integer.MIN_VALUE;
        for (int i = begin; i < end; i++)
            maxVal = Math.max(maxVal, nums[i]);

        TreeNode root = new TreeNode(maxVal);
        int rootIndex = map.get(root.val);

        // 递归构造左子树和右子树，左闭右开
        root.left = buildMaxTree(nums, begin, rootIndex);
        root.right = buildMaxTree(nums, rootIndex + 1, end);

        return root;
    }
}
