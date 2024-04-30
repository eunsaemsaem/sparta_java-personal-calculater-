package calculator;

import java.util.ArrayList;

public class ArithmeticCalculator extends Calculator {

    /* 컬렉션 선언 */
    static private ArrayList<Double> resultList = new ArrayList<>();

    /* Constructor */
    public ArithmeticCalculator() {}

    /* 연산 메서드 */
    @Override
    public double arithmeticCalculate(int num1, int num2, char op) throws CalculateException {

        // 결과값 저장 변수
        double result = 0;

        // 연산자 조건을 switch로 나눔
        switch (op) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '/' -> {
                if (num2 == 0) {
                    throw new CalculateException("두번째 숫자는 0이 될 수 없습니다.");
                } else {
                    result = (double) num1 / num2;
                }
            }
            case '*' -> result = num1 * num2;
            case '%' -> result = num1 % num2;
            default -> throw new CalculateException("알 수 없는 연산자입니다.");
        }

        // 결과
        resultList.add(result);
        return result;
    }

    /* 연산 결과 처리 메서드 */
    //첫번째 결과 삭제
    @Override
    public void removeResult() {
        resultList.remove(0);
    }

    //전체 결과 조회
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

    ////
    @Override
    public double circleCalculate(int r) throws CalculateException {
        return 0;
    }


}
