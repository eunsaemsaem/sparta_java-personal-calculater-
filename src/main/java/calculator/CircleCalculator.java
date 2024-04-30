package calculator;

import java.util.ArrayList;

public class CircleCalculator extends Calculator {

    /* 컬렉션 선언 */
    static ArrayList<Double> circleList = new ArrayList<>();

    /* Constructor */
    public CircleCalculator() {
    }

    /* 연산 메서드 */
    @Override
    public double circleCalculate(int r) throws CalculateException {

        // 결과값 및 파이 변수
        double result = 0;
        final double pi = 3.14159;

        result = pi * r * r;

        //결과
        circleList.add(result);
        return result;
    }

    /* 연산 결과 처리 메서드 */
    //첫번째 결과 삭제
    @Override
    public void removeResult() {
        circleList.remove(0);
    }

    //전체 결과 조회
    @Override
    public void inquiryResults() {
        for (double result : circleList) {
            System.out.println(result);
        }

    }


    ////
    @Override
    public double arithmeticCalculate(int num1, int num2, char op) throws CalculateException {
        return 0;
    }



}
