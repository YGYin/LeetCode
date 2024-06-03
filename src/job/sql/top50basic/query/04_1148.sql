# 1148. 文章浏览 I
# 去重也可以用 GROUP BY id 代替 DISTINCT
# GROUP BY 在 MySQL 8.0 中不会触发 filesort
# 在有较大区分度的 WHERE 子句或者索引的情况下 GROUP BY 要好一些
SELECT DISTINCT author_id as id
FROM Views
WHERE author_id = viewer_id
ORDER BY id;
