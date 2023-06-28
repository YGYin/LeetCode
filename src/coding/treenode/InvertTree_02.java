package coding.treenode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree_02 {
    /*
        DFS 不能直接用中序，可画图理解
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /*
        BFS 层序遍历
     */
    public TreeNode invertTree_2(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = que.poll();
                swap(cur);
                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);
            }
        }
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


}
