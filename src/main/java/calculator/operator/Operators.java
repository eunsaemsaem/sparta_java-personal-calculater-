package calculator.operator;

import calculator.CalculateException;

public interface Operators {
    double operate(int num1, int num2) throws CalculateException;
}
