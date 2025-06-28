--Scenario 1: Group all customer-related procedures and functions into a package.
CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
  PROCEDURE UpdateCustomer(p_id NUMBER, p_balance NUMBER);
  FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

-- Create the package body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
  END;

  PROCEDURE UpdateCustomer(p_id NUMBER, p_balance NUMBER) IS
  BEGIN
    UPDATE Customers
    SET Balance = p_balance, LastModified = SYSDATE
    WHERE CustomerID = p_id;
  END;

  FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER IS
    v_balance NUMBER;
  BEGIN
    SELECT Balance INTO v_balance
    FROM Customers
    WHERE CustomerID = p_id;
    RETURN v_balance;
  END;

END CustomerManagement;
/

--Scenario 2: Group all customer-related procedures and functions into a package.
CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(
    p_EmpID IN NUMBER,
    p_Name IN VARCHAR2,
    p_Position IN VARCHAR2,
    p_Salary IN NUMBER,
    p_Department IN VARCHAR2,
    p_HireDate IN DATE
  );

  PROCEDURE UpdateEmployee(
    p_EmpID IN NUMBER,
    p_Name IN VARCHAR2,
    p_Position IN VARCHAR2,
    p_Salary IN NUMBER,
    p_Department IN VARCHAR2
  );

  FUNCTION GetAnnualSalary(
    p_EmpID IN NUMBER
  ) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

  PROCEDURE HireEmployee(
    p_EmpID IN NUMBER,
    p_Name IN VARCHAR2,
    p_Position IN VARCHAR2,
    p_Salary IN NUMBER,
    p_Department IN VARCHAR2,
    p_HireDate IN DATE
  ) IS
  BEGIN
    INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
    VALUES (p_EmpID, p_Name, p_Position, p_Salary, p_Department, p_HireDate);
  END HireEmployee;

  PROCEDURE UpdateEmployee(
    p_EmpID IN NUMBER,
    p_Name IN VARCHAR2,
    p_Position IN VARCHAR2,
    p_Salary IN NUMBER,
    p_Department IN VARCHAR2
  ) IS
  BEGIN
    UPDATE Employees
    SET Name = p_Name,
        Position = p_Position,
        Salary = p_Salary,
        Department = p_Department
    WHERE EmployeeID = p_EmpID;
  END UpdateEmployee;

  FUNCTION GetAnnualSalary(
    p_EmpID IN NUMBER
  ) RETURN NUMBER IS
    v_Salary NUMBER;
  BEGIN
    SELECT Salary INTO v_Salary
    FROM Employees
    WHERE EmployeeID = p_EmpID;

    RETURN v_Salary * 12;
  END GetAnnualSalary;

END EmployeeManagement;
/

--Scenario 3: Group all customer-related procedures and functions into a package.
CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(
    p_AccountID IN NUMBER,
    p_CustomerID IN NUMBER,
    p_AccountType IN VARCHAR2,
    p_InitialBalance IN NUMBER
  );

  PROCEDURE CloseAccount(
    p_AccountID IN NUMBER
  );

  FUNCTION GetTotalBalance(
    p_CustomerID IN NUMBER
  ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

  PROCEDURE OpenAccount(
    p_AccountID IN NUMBER,
    p_CustomerID IN NUMBER,
    p_AccountType IN VARCHAR2,
    p_InitialBalance IN NUMBER
  ) IS
  BEGIN
    INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES (p_AccountID, p_CustomerID, p_AccountType, p_InitialBalance, SYSDATE);
  END OpenAccount;

  PROCEDURE CloseAccount(
    p_AccountID IN NUMBER
  ) IS
  BEGIN
    DELETE FROM Accounts
    WHERE AccountID = p_AccountID;
  END CloseAccount;

  FUNCTION GetTotalBalance(
    p_CustomerID IN NUMBER
  ) RETURN NUMBER IS
    v_TotalBalance NUMBER;
  BEGIN
    SELECT NVL(SUM(Balance), 0)
    INTO v_TotalBalance
    FROM Accounts
    WHERE CustomerID = p_CustomerID;

    RETURN v_TotalBalance;
  END GetTotalBalance;

END AccountOperations;
/