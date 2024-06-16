package job.top101.tree;

import java.util.ArrayList;
import java.util.List;

public class BM25_PostorderTraversal {
    List<Integer> list = new ArrayList<>();

    public int[] postorderTraversal(TreeNode root) {
        traversal(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);

        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        traversal(root.right);
        list.add(root.val);
    }
}
