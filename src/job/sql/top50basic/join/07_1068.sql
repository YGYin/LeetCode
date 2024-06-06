# 1068. 产品销售分析 I
SELECT product_name, year, price
FROM Product,
     Sales
WHERE Product.product_id = Sales.product_id;