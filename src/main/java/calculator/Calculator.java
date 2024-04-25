package calculator;
//1. 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후
//   결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
//    - 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우
//      적합한 Exception 클래스를 생성하여 throw 합니다. (매개변수로 해당 오류 내용을 전달합니다.)

import java.io.IOError;

public class Calculator {
    public double calculate (int a, int b, char op) throws CalculateException {
        double result = 0; // 정확한 값을 출력하기 위한 double

        //연산자 조건을 switch로 나눔
        switch (op) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '/' -> {
                if (a == 0) {
                    throw new CalculateException("두번째 숫자는 0이 될 수 없습니다. "); // 출력이 안됨..
                }
                else {
                    result = (double) a / b;
                }
            }
            case '*' -> result = a * b;
            case '%' -> result = a % b;
            default -> throw new CalculateException("Unknown operator");
        }

        return result;
    }

}
