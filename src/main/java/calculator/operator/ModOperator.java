package calculator.operator;

public class ModOperator implements Operators {
    @Override
    public double operate(int num1, int num2) {
        return num1 % num2;
    }
}
