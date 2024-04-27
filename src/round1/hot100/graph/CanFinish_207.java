package round1.hot100.graph;

import java.util.*;

public class CanFinish_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 课程表 -> 根据依赖关系将其转换为有向无环图，观察其出入度
        /*
           主要思想：
           1. 让入度为 0 的课程进入队列
           2. 队列元素逐个出列，代表该课程被选，出队列时需减小相关后续课的入读
           3. 再看时都有入度为 0 的课程，再入列，直到没有入度为 0 的元素

           需要记录：
           1. 每门课的入度 -> inDegree[]，下标课号
           2. 课程之间的依赖关系 -> Map: key: 课号  val: list，其后续课
         */
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 遍历 pre 数组以记录每门课的入读和课程依赖关系
        for (int i = 0; i < prerequisites.length; i++) {
            // 只要出现在 pre[i][0] 这代表其有先修课，入度 ++
            inDegree[prerequisites[i][0]]++;
            // 遍历每门课记录其后续课前，需要先初始化其 map
            map.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            // 再往 map 中添加其后续课程
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // 因为要将 入度为 0 的课程进入队列，初始化队列
        Queue<Integer> queue = new LinkedList<>();
        // 遍历入度数组，将入度为 0 的入列
        for (int i = 0; i < inDegree.length; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        // 将 入读为 0 的课程逐个出列，并减少其后续课的入读，
        // 再观察是否有入读为 0 的课程，有就入队列
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            --numCourses;
            // 获得其后续课
            List<Integer> nextCourse = map.getOrDefault(curCourse, new ArrayList<>());
            // 遍历后续课，将其入度 --
            for (int i = 0; i < nextCourse.size(); i++)
                if (--inDegree[nextCourse.get(i)] == 0)
                    queue.offer(nextCourse.get(i));
        }
        // 最后判断是否为 0
        return numCourses == 0;
    }
}
