package calculator.operator;

public class SubtractOperator implements Operators {
    @Override
    public double operate(int a, int b) {
        return a - b;
    }
}
