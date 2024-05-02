package calculator;

public abstract class Calculator {

    /* 변수 선언 */
    static int num1, num2, r;
    static char op;

    /* 생성자 */
    public Calculator (){

    }
    public Calculator(int num1, int num2, char op) {
        Calculator.num1 = num1;
        Calculator.num2 = num2;
        Calculator.op = op;
    }
    public Calculator(int r) {
        Calculator.r = r;
    }

    /* 연산 메서드 */
    public double arithmeticCalculate(int num1, int num2, char op) throws CalculateException {
        return 0;
    }

    public double circleCalculate(int r) throws CalculateException {
        return 0;
    }

    /* 첫번째 결과 삭제 */
    public abstract void removeResult();

    /* 결과 조회 */
    public abstract void inquiryResults();

}
