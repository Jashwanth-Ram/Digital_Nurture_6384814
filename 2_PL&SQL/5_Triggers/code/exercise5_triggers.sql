--Scenario 1: Automatically update the last modified date when a customer's record is updated.
CREATE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
END;

--Scenario 2: Maintain an audit log for all transactions.
CREATE SEQUENCE AuditLog_SEQ
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

CREATE TABLE AuditLog (
  LogID NUMBER PRIMARY KEY,
  TransactionID NUMBER,
  LogDate DATE,
  Message VARCHAR2(100)
);

CREATE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (
    LogID,
    TransactionID,
    LogDate,
    Message
  ) VALUES (
    AuditLog_SEQ.NEXTVAL,
    :NEW.TransactionID,
    SYSDATE,
    'Transaction successfully recorded in audit log.'
  );
END;

--Scenario 3: Enforce business rules on deposits and withdrawals.
CREATE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  bal NUMBER;
BEGIN
  SELECT Balance INTO bal FROM Accounts WHERE AccountID = :NEW.AccountID;
  
  IF :NEW.TransactionType = 'Withdrawal' AND :NEW.Amount > bal THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance');
  ELSIF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Deposit must be positive');
  END IF;
END;
