package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* Calculator 인스턴스 생성 */
        Calculator calculator = new Calculator(new ArrayList<>());

        /* 반복문 시작 */
        while (true) {

            /* 입력받기 */
            System.out.print("첫 번째 숫자를 입력하세요: "); /////숫자가 아닌걸 입력받았을 때 예외처리 하는 방법?
            int a = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int b = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            //scanner로 char을 입력받기 위해서는 형변환 필요
            char op = sc.next().charAt(0); // 0 : 문자의 위치

            //try-catch문 안에서 실행
            try {
                double result = calculator.calculate(a, b, op);

                /* 결과 출력 */
                System.out.println("결과: " + result);

                /* 첫번째 결과 삭제 */
                calculator.removeResult();

                /* 결과 조회 */
                calculator.inquiryResults();

                /* 반복 유무 확인 */
                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
                String exit = sc.next();
                if (exit.equals("exit")) {
                    break;
                }

            } catch (CalculateException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
