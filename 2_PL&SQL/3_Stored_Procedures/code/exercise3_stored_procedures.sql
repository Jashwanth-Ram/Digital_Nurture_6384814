--Scenario 1: The bank needs to process monthly interest for all savings accounts.
CREATE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
    
    COMMIT;
END;
/

--Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
CREATE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE Department = p_department;
    
    COMMIT;
END;
/

--Scenario 3: Customers should be able to transfer funds between their accounts.
CREATE SEQUENCE TRANSACTIONS_SEQ START WITH 1001 INCREMENT BY 1;

CREATE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account
    FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (TRANSACTIONS_SEQ.NEXTVAL, p_from_account, SYSDATE, p_amount, 'Transfer Out');

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (TRANSACTIONS_SEQ.NEXTVAL, p_to_account, SYSDATE, p_amount, 'Transfer In');

    COMMIT;
END;
/