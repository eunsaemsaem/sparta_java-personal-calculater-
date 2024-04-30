package calculator.operator;

public class DivideOperator implements Operators {
    @Override
    public double operate(int a, int b) {
        return (double) a / b;
    }
}
