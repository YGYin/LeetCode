SELECT machine_id
FROM Activity a1
         INNER JOIN Activity a2
                    ON a1.machine_id = a2.machine_id AND a1.process_id = a2.process_id;