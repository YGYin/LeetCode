package job.top101.tree;

import java.util.ArrayList;
import java.util.List;

public class BM23_PreorderTraversal {
    List<Integer> list;

    public int[] preorderTraversal(TreeNode root) {
        if (root == null)
            return new int[]{};
        traversal(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null)
            return;
        list.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }
}
