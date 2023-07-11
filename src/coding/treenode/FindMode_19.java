package coding.treenode;

import java.util.ArrayList;

public class FindMode_19 {
    /*
        思路：利用中序双指针遍历获取二叉搜索树中的元素出现频率
                1. 前一节点为空，或当前节点不等于前节点，说明当前节点为第一次出现，将出现频率设为 1
                2. 当前节点和前节点相等，count++
                3. 根据 count 的大小更新 maxCount 和 res 数据
                    - count > maxCount -> 清空 res，写入新的 rootValue，更新 maxCount
                    - count = maxCount -> 加入新的 rootValue
                4. 更新 pre 指针
     */
    ArrayList<Integer> resList;
    TreeNode pre = null;
    int count;
    int maxCount;

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        count = 0;
        maxCount = 0;
        findMost(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++)
            res[i] = resList.get(i);
        return res;
    }

    private void findMost(TreeNode root) {
        if (root == null)
            return;
        // 左
        findMost(root.left);
        // 中
        // 计数
        if (pre == null || root.val != pre.val)
            count = 1;
        else
            ++count;
        // 更新结果以及 maxCount
        if (count > maxCount) {
            resList.clear();
            resList.add(root.val);
            maxCount = count;
        } else if (count == maxCount)
            resList.add(root.val);

        pre = root;
        // 右
        findMost(root.right);
    }
}
