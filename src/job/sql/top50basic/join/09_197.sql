# 197. 上升的温度
# 找出与之前（昨天的）日期相比温度更高的所有日期的 id
# 可以用同一张张表分别用不同标识符号
SELECT w2.id
FROM Weather w1,
     Weather w2
WHERE DATEDIFF(w2.recordDate, w1.recordDate) = 1
  AND w2.temperature > w1.temperature;
