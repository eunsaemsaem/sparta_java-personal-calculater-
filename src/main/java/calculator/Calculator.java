package calculator;
//8. 사칙연산을 수행하는 계산기 ArithmeticCalculator 클래스와 원과 관련된 연산을 수행하는 계산기 CircleCalculator 클래스 2개를 구현합니다.
//     - 기존에 만들어둔 Calculator 클래스를 수정합니다
//     - 수정한 Calculator 클래스를 활용하여 ArithmeticCalculator, CircleCalculator 클래스를 구현 해봅니다. (상속)
//     - 위 요구사항을 구현하게되면 App 클래스의 main 메서드에 오류가 발생할 겁니다.
//        - 구현한 클래스들을 활용하여 오류가 발생하지 않고 활용될 수 있도록 수정 해보세요!
//        - 기존에 사칙연산을 저장하던 컬렉션 필드의 타입을 Double로 변경해도 괜찮습니다.
//        - 필드의 접근 제어자를 변경해도 괜찮습니다.


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
    public abstract double arithmeticCalculate(int num1, int num2, char op) throws CalculateException;
    public abstract double circleCalculate(int r) throws CalculateException;

    /* 첫번째 결과 삭제 */
    public abstract void removeResult();

    /* 결과 조회 */
    public abstract void inquiryResults();

}
