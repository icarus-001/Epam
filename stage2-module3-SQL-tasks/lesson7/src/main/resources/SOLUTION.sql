SELECT * FROM MARK WHERE mark > 6 ORDER BY mark DESC;
SELECT * FROM PAYMENT WHERE amount < 300 ORDER BY amount ASC;
SELECT * FROM PAYMENTTYPE ORDER BY name ASC;
SELECT * FROM Student ORDER BY name DESC;
SELECT s2.* FROM Student s2 JOIN Payment P2 on s2.id = P2.student_id WHERE P2.amount > 1000 ORDER BY birthday asc;