# 1581. 进店却未进行过交易的顾客
SELECT customer_id, COUNT(*) AS count_no_trans
FROM Visits vis
         LEFT JOIN Transactions tran
                   ON vis.visit_id = tran.visit_id
WHERE tran.transaction_id IS NULL;