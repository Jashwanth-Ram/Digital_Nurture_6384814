--Scenario 1
BEGIN
  FOR rec IN (SELECT * FROM Loans l JOIN Customers c ON l.CustomerID = c.CustomerID) LOOP
    IF MONTHS_BETWEEN(SYSDATE, rec.DOB)/12 > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE LoanID = rec.LoanID;
    END IF;
  END LOOP;
END;

--Scenario 2
ALTER TABLE Customers ADD IsVIP VARCHAR2(5);
BEGIN
  FOR rec IN (SELECT * FROM Customers) LOOP
    IF rec.Balance > 10000 THEN
      UPDATE Customers SET IsVIP = 'TRUE' WHERE CustomerID = rec.CustomerID;
    END IF;
  END LOOP;
END;

--Scenario 3
BEGIN
  FOR rec IN (
    SELECT * FROM Loans WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID || ' is due soon.');
  END LOOP;
END;