package calculator.operator;

public class AddOperator implements Operators {
    @Override
    public double operate(int a, int b) {
        return a + b;
    }
}