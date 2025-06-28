--Scenario 1
CREATE PROCEDURE SafeTransferFunds(
    p_from   NUMBER,
    p_to     NUMBER,
    p_amount NUMBER
) IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from
    FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to;

    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('One of the accounts does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;

--Scenario 2
CREATE PROCEDURE UpdateSalary(p_empid NUMBER, p_percent NUMBER) IS
BEGIN
  UPDATE Employees SET Salary = Salary + (Salary * p_percent / 100) WHERE EmployeeID = p_empid;
  IF SQL%ROWCOUNT = 0 THEN
    DBMS_OUTPUT.PUT_LINE('Error: Employee not found.');
  END IF;
END;

--Scenario 3
CREATE PROCEDURE AddNewCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
BEGIN
  INSERT INTO Customers(CustomerID, Name, DOB, Balance, LastModified)
  VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Error: Customer with this ID already exists.');
END;