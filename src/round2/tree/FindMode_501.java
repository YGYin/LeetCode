package round2.tree;

import java.util.ArrayList;
import java.util.List;

public class FindMode_501 {
    /*
        二叉搜索树中的众数
        1. 暴力：中序遍历二叉搜索树记录到数组，然后再遍历两次数组
                第一次取得 maxCount，第二次取得所有出现次数为 maxCount 的元素
        2. 同样利用双指针来中序遍历二叉搜索树，可以在遍历过程中更新 maxCount
            中节点处理: - 统计次数: 如果当前节点和上一节点相同，count++，否则 count 设为 1
                      - 然后根据 count 和 maxCount 大小更新众数
                            如果当前 count 已经比 maxCount 大，需要清空众数 list，加入当前值，并更新 maxCount
                            如果当前 count == maxCount，将当前元素加入到众数 list
                      - 更新指针
     */

    TreeNode prev = null;
    // 记录众数的 list
    List<Integer> resList;
    // 统计当前次数
    int count = 0;

    int maxCount = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[]{};

        resList = new ArrayList<>();
        getMode(root);

        // 遍历 list 转为数组
        int[] res = new int[resList.size()];

        for (int i = 0; i < resList.size(); i++)
            res[i] = resList.get(i);

        return res;
    }

    // 1. 不需要返回值，传入当前根节点
    private void getMode(TreeNode root) {
        // 2. 当遍历到空节点返回
        if (root == null)
            return;

        // 中序遍历
        getMode(root.left);
        // 中，先统计当前出现次数
        // 当前一节点不为空且和当前节点值相等，count++
        if (prev != null && root.val == prev.val)
            ++count;
            // pre 为空或者和前一节点不相同，count 为 1
        else
            count = 1;

        // 更新 maxCount
        // 如果 count > maxCount，清除众数 list，更新 maxCount 和加入当前节点
        if (count > maxCount) {
            resList.clear();
            resList.add(root.val);
            maxCount = count;
        } else if (count == maxCount)
            resList.add(root.val);
        // 更新指针
        prev = root;

        // 右
        getMode(root.right);
    }
}
