--Scenario 1: Generate monthly statements for all customers.
DECLARE
  CURSOR cur IS
    SELECT c.Name, t.Amount, t.TransactionType
    FROM Customers c
    JOIN Accounts a ON c.CustomerID = a.CustomerID
    JOIN Transactions t ON a.AccountID = t.AccountID
    WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');
BEGIN
  FOR rec IN cur LOOP
    DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ', Type: ' || rec.TransactionType || ', Amount: ' || rec.Amount);
  END LOOP;
END;

--Scenario 2: Apply annual fee to all accounts.
DECLARE
  CURSOR cur IS SELECT AccountID FROM Accounts;
BEGIN
  FOR rec IN cur LOOP
    UPDATE Accounts
    SET Balance = Balance - 100
    WHERE AccountID = rec.AccountID;
  END LOOP;
END;

--Scenario 3: Update the interest rate for all loans based on a new policy.
DECLARE
  CURSOR cur IS SELECT LoanID, InterestRate FROM Loans;
BEGIN
  FOR rec IN cur LOOP
    UPDATE Loans
    SET InterestRate = rec.InterestRate + 0.5
    WHERE LoanID = rec.LoanID;
  END LOOP;
END;