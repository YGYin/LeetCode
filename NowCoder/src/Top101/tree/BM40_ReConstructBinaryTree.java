package Top101.tree;

import java.util.Arrays;
import java.util.Stack;

public class BM40_ReConstructBinaryTree {
    /*
        1. 递归
        对于二叉树的前序遍历，我们知道序列的第一个元素必定是根节点的值，
        因为序列没有重复的元素，因此中序遍历中可以找到相同的这个元素，
        而我们又知道中序遍历中根节点将二叉树分成了左右子树两个部分
        时间复杂度：O(n)，其中 n 为数组长度，即二叉树的节点数，构建每个节点进一次递归，递归中所有的循环加起来一共 n 次
        空间复杂度：O(n)，递归栈最大深度不超过 n，辅助数组长度也不超过 n，重建的二叉树空间属于必要空间，不属于辅助空间
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        int preLen = pre.length;
        int vinLen = vin.length;
        // 判空
        if (preLen == 0 || vinLen == 0)
            return null;
        // 先根据前序遍历的第一个点建立根节点
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < vinLen; i++) {
            // 找到中序遍历数组中的根节点元素
            // i 刚好为中序数组中根节点的下标，即为左子树长度
            if (pre[0] == vin[i]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1),
                        Arrays.copyOfRange(vin, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, preLen),
                        Arrays.copyOfRange(vin, i + 1, vinLen));
                break;
            }
        }
        return root;
    }

    /*
        2. 栈辅助
        step 1：首先前序遍历第一个数字依然是根节点，并建立栈辅助遍历。
        step 2：然后我们就开始判断，在前序遍历中相邻的两个数字必定是只有两种情况：
                - 要么前序后一个是前一个的左节点；
                - 要么前序后一个是前一个的右节点或者其祖先的右节点。
        step 3：我们可以同时顺序遍历 pre 和 vin 两个序列，判断是否是左节点，
                - 如果是左节点则不断向左深入，用栈记录祖先，
                - 如果不是需要弹出栈回到相应的祖先，然后进入右子树，整个过程类似非递归前序遍历。

        时间复杂度：O(n)，n 为数组长度，即二叉树的节点数，遍历一次数组，弹出栈的循环最多进行 n 次
        空间复杂度：O(n)，栈空间最大深度为 n
     */
    public TreeNode reConstructBinaryTree_2(int[] pre, int[] vin) {
        int preLen = pre.length;
        int vinLen = vin.length;
        // 判空
        if (preLen == 0 || vinLen == 0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        // 先根据前序遍历的第一个点建立根节点
        TreeNode root = new TreeNode(pre[0]);
        TreeNode cur = root;
        for (int i = 1, j = 0; i < preLen; i++) {
            // 这个节点为上一节点的左节点
            if (cur.val != vin[j]) {
                cur.left = new TreeNode(pre[i]);
                stack.push(cur);
                cur = cur.left;
            }
            //要么旁边这个是它的右节点，或者祖先的右节点
            else {
                ++j;
                // 弹出到符合的祖先
                while (!stack.isEmpty() && stack.peek().val == vin[j]) {
                    cur = stack.pop();
                    ++j;
                }
                // 添加到右节点
                cur.right = new TreeNode(pre[i]);
                cur = cur.right;
            }
        }
        return root;
    }
}
