package round3.hot100.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_105 {
    /*
        从前序与中序遍历序列构造二叉树
        需要用 map 记录下中序数组的元素和对应出现下标，方便切分
        1. 先获取前序数组中的首元素构造根节点
        2. 获取到 map 中中序数组根节点位置，切分中序数组，进而得到 lenOfLeft
        3. 再用中节点位置和 lenOfLeft 来切分前序数组
        4. 分别向左右递归切分两个数组构造子树
     */
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // key: 元素  val: 下标
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    // 返回构造好的根节点，左闭右开
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // 不符合左闭右开时返回
        if (preStart >= preEnd || inStart >= inEnd)
            return null;

        // 根据前序数组构造根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 根据值从 map 找到中序数组中的下标，从而划分中序数组中左子树的长度
        int inMidIndex = map.get(rootVal);
        int lenOfLeft = inMidIndex - inStart;

        // 构造左右子树，范围左闭右开
        root.left = build(preorder, preStart + 1, preStart + 1 + lenOfLeft,
                inorder, inStart, inMidIndex);
        root.right = build(preorder, preStart + 1 + lenOfLeft,
                preEnd, inorder, inMidIndex + 1, inEnd);

        return root;
    }
}
