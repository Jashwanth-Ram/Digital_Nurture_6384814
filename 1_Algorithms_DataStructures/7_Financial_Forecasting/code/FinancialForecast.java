/*
    Recursion is a  technique where a method calls itself again to solve smaller subproblems.
    Optimization – Using DP Memoization(Store the results in DP table)
    Time Complexity = O(n) n=> No of years
    When to use? : When the problem can be broken down into similar subproblems

 */

public class FinancialForecast {

    public static double futureValueRecursive(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return (1 + rate) * futureValueRecursive(presentValue, rate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 12000.0;
        double annualRate = 2.05;
        int years = 8;

        double result = futureValueRecursive(presentValue, annualRate, years);
        System.out.printf("Future Value after %d years: %.2f%n", years, result);
    }
}

