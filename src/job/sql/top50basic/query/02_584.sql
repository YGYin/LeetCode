# 584. 寻找用户推荐人
# sql里面的不等于，不包含null
SELECT name
FROM Customer
WHERE referee_id != 2
   OR referee_id IS NULL;