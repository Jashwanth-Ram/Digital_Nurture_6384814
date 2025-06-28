--Scenario 1: Calculate the age of customers for eligibility checks.
CREATE FUNCTION CalculateAge(p_dob DATE) RETURN NUMBER IS
BEGIN
  RETURN FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob)/12);
END;

--Scenario 2: The bank needs to compute the monthly installment for a loan.
CREATE FUNCTION CalculateMonthlyInstallment(
  p_amount NUMBER,
  p_rate NUMBER,
  p_years NUMBER
) RETURN NUMBER IS
  r NUMBER := p_rate / (12 * 100);
  n NUMBER := p_years * 12;
BEGIN
  RETURN (p_amount * r * POWER(1 + r, n)) / (POWER(1 + r, n) - 1);
END;

--Scenario 3: Check if a customer has sufficient balance before making a transaction.
CREATE FUNCTION HasSufficientBalance(p_accountid NUMBER, p_amount NUMBER) RETURN BOOLEAN IS
  bal NUMBER;
BEGIN
  SELECT Balance INTO bal FROM Accounts WHERE AccountID = p_accountid;
  RETURN bal >= p_amount;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN FALSE;
END;