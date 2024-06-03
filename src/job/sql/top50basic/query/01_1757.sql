# 1757. 可回收且低脂的产品
SELECT product_id
FROM Products
WHERE low_fats = 'Y'
  AND recyclable = 'Y';