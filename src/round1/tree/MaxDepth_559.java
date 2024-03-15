package round1.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth_559 {
    // 层序遍历
    public int maxDepth(Node root) {
        int depth = 0;
        if (root == null)
            return depth;
        // 辅助队列
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每层遍历先加 depth
            int qSize = queue.size();
            ++depth;
            for (int i = 0; i < qSize; i++) {
                Node curNode = queue.poll();
                List<Node> children = curNode.children;
                if (!children.isEmpty())
                    for (int index = 0; index < children.size(); index++)
                        queue.offer(children.get(index));
            }
        }

        return depth;
    }

    // 递归
    // 返回深度 int，传入根节点
    // 核心思想都为取子节点的最高高度，返回 + 1
    public int maxDepth_2(Node root) {
        if (root == null)
            return 0;

        int depth = 0;
        // 检查 children 是否为空
        List<Node> children = root.children;
        // 左右遍历子节点，取得子节点中最大高度
        if (children != null)
            for (int i = 0; i < children.size(); i++)
                depth = Math.max(depth, maxDepth_2(children.get(i)));
        // 中：父节点 root 的高度为最高的子节点 + 1
        return depth + 1;
    }
}
