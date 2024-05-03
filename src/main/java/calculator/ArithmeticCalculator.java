package calculator;

import calculator.operator.*;
import java.util.ArrayList;

// 사칙연산을 위한 클래스
public class ArithmeticCalculator extends Calculator {

    /* 컬렉션 선언 */
    static private ArrayList<Double> resultList = new ArrayList<>();

    /* Constructor */
    public ArithmeticCalculator() {}

    /* Operator 선언 */
    Operators operators;

    /* 연산 메서드 */
    @Override
    public double arithmeticCalculate(int num1, int num2, char op) throws CalculateException {

        // 결과값 저장 변수
        double result = 0;

        //연산자에 따라 operator 선언
        switch (op) {
            case '+' -> operators = new AddOperator();
            case '-' -> operators = new SubtractOperator();
            case '/' -> operators = new DivideOperator();
            case '*' -> operators = new MultiplyOperator();
            case '%' -> operators = new ModOperator();
            default -> throw new CalculateException("알 수 없는 연산자입니다."); // 올바르지 않은 연산자의 경우 에외처리
        }

        // 결과 계산
        result = operators.operate(num1, num2);

        // 결과 처리
        resultList.add(result);
        return result;
    }

    /* 연산 결과 처리 메서드 */
    // 첫번째 결과 삭제
    @Override
    public void removeResult() {
        resultList.remove(0);
    }

    // 전체 결과 조회
    @Override
    public void inquiryResults() {
        for (double result : resultList) {
            System.out.println(result);
        }
    }

    /* 컬렉션의 Getter, Setter */
    public static ArrayList<Double> getResultList() {
        return resultList;
    }

    public static void setResultList(ArrayList<Double> resultList) {
        ArithmeticCalculator.resultList = resultList;
    }

}
