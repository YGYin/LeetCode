package coding.treenode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_13 {
    /*
        前中序数组构建二叉树
        思路：
        1. 看前序数组是否为空，为空则是空节点
        2. 不为空的话，取前序数组的第一个元素作为中节点元素
        3. 根据前序数组的第一个元作为切割点，找到其在中序数组中的位置
        4. 切割中序数组，切成中序左数组和中序有数组
        5. 再切割前序数组，按照左中序数组的大小来切割成后序左数组和后序右数组
        6. 递归处理左区间和右区间
     */
    // 保存中序序列中数值的对应位置
    Map<Integer, Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        return findNode(inorder, 0, inorder.length, preorder, 0, preorder.length);
    }

    private TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] preorder, int preBegin, int preEnd) {
        if (inBegin >= inEnd || preBegin >= preEnd)
            return null;
        // 找到前序数组的第一个节点在中序数组的位置，并构造节点
        int rootIndex = inMap.get(preorder[preBegin]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 保存中序左子树的个数，用于切割前序数组的左右数组
        int lenOfInLeft = rootIndex - inBegin;
        // 构建左右子树
        root.left = findNode(inorder, inBegin, rootIndex,
                preorder, preBegin + 1, preBegin + 1 + lenOfInLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                preorder, preBegin + 1 + lenOfInLeft, preEnd);
        return root;
    }
}
