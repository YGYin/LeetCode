# 1378. 使用唯一标识码替换员工ID
SELECT unique_id, name
FROM Employees emp
         LEFT JOIN EmployeeUNI empUNI
                   ON emp.id = empUNI.id;