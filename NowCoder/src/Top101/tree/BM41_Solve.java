package Top101.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class BM41_Solve {
    public int[] solve(int[] xianxu, int[] zhongxu) {
        if (xianxu.length == 0)
            return new int[0];
        TreeNode root = reConstructBinaryTree(xianxu, zhongxu);
        ArrayList<Integer> view = rightSideView(root);
        // 转化为数组
        int[] res = new int[view.size()];
        for (int i = 0; i < view.size(); i++)
            res[i] = view.get(i);

        return res;
    }

    /*
        DFS
        1. dfs打印右视图时，使用哈希表存储每个深度对应的最右边节点，初始化两个栈辅助遍历，
           第一个栈记录dfs时的节点，第二个栈记录遍历到的深度，根节点先入栈
        2. 对于每个访问的节点，每次左子节点先进栈，右子节点再进栈，
           这样访问完一层后，因为栈的先进后出原理，每次都是右边被优先访问，
           因此我们在哈希表该层没有元素时，添加第一个该层遇到的元素就是最右边的节点
        3. 使用一个变量逐层维护深度最大值，最后遍历每个深度，从哈希表中读出每个深度的最右边节点加入数组中
     */

    private ArrayList<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 用于记录最大深度
        int maxDepth = -1;
        // 用两个栈分别记录 dfs 时的节点和遍历到的深度
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        // 根节点先入栈
        nodes.push(root);
        depths.push(0);
        while (!nodes.isEmpty()) {
            TreeNode curNode = nodes.pop();
            Integer curDepth = depths.pop();
            if (curNode != null) {
                // 更新当前二叉树最大深度
                maxDepth = Math.max(maxDepth, curDepth);
                // 检查是否存在对应深度的节点，不存在的话插入该节点
                if (map.get(curDepth) == null)
                    map.put(curDepth, curNode.val);
                nodes.push(curNode.left);
                nodes.push(curNode.right);
                depths.push(curDepth + 1);
                depths.push(curDepth + 1);
            }
        }
        // 将结果加入链表
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++)
            res.add(map.get(i));

        return res;
    }

    // Build a tree
    private TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
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
}
