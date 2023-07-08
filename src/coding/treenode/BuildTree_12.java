package coding.treenode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_12 {
    /*
        中后序数组构建二叉树
        思路：
        1. 看后序数组是否为空，为空则是空节点
        2. 不为空的话，取后序数组的最后一个元素作为中节点元素
        3. 根据后序数组的最后一个节点作为切割点，找到其在中序数组中的位置
        4. 切割中序数组，切成中序左数组和中序有数组
        5. 再切割后序数组，按照左中序数组的大小来切割成后序左数组和后序右数组
        6. 递归处理左区间和右区间
     */
    // 保存中序序列中数值的对应位置
    Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inMap = new HashMap<>();
        // k: 数值 v: 数值对应下标
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        // 注意为前闭后开
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // 参数范围为左闭右开
        if (inBegin >= inEnd || postBegin >= postEnd)
            return null;
        // 找到后序数组中最后一个元素在中序数组中的位置，并构造节点
        int rootIndex = inMap.get(postorder[postEnd - 1]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 因为左闭右开，保存的为中序左子树的个数，并用来确定后序数列的个数
        int lenOfInLeft = rootIndex - inBegin;
        root.left = findNode(inorder, inBegin, rootIndex,
                postorder, postBegin, postBegin + lenOfInLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                postorder, postBegin + lenOfInLeft, postEnd - 1);

        return root;
    }
}
