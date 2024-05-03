package calculator.operator;

import calculator.CalculateException;

//operator를 위한 interface
public interface Operators {
    double operate(int num1, int num2) throws CalculateException;
}
