package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* Calculator 인스턴스 생성 */
        Calculator calculator = new Calculator(new ArrayList<>(), new ArrayList<>());

        /* 반복문 시작 */
        while (true) {
            /* 사칙연산 or 원의 넓이 선택 */
            System.out.print("원의 넓이를 구하시겠습니까? ('y'입력 시 원의 넓이 계산, 'n'입력 시 사칙연산): ");
            String input = sc.nextLine(); //어떤 연산을 할 지 선택하는 변수

            switch (input) {
                case "y": //원의 넓이일 경우
//                    which = true;
                    System.out.print("반지름을 입력하세요: ");
                    int r = sc.nextInt();
                    double resultCir = calculator.calculateCircleArea(r);

                    /* 결과 출력 */
                    System.out.println("결과: " + resultCir);

                    /* 첫번째 결과 삭제 */
                    calculator.removeResult(false);

                    /* 전체 결과 조회 */
                    calculator.inquiryResults(false);

                    /* 반복 유무 확인 */
                    System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
                    String exitC = sc.next();
                    if (exitC.equals("exit")) {
                        return;
                    }
                    break;

                case "n": //사칙연산일 경우
//                    which = false;
                    System.out.print("첫 번째 숫자를 입력하세요: "); /////숫자가 아닌걸 입력받았을 때 예외처리 하는 방법?.?
                    int a = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int b = sc.nextInt();
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    //scanner로 char을 입력받기 위해서는 형변환 필요
                    char op = sc.next().charAt(0); // 0 : 문자의 위치

                    //try-catch문 안에서 연산 실행 및 결과 처리
                    try {
                        double result = calculator.calculate(a, b, op);

                        /* 결과 출력 */
                        System.out.println("결과: " + result);

                        /* 첫번째 결과 삭제 */
                        calculator.removeResult(true);

                        /* 전체 결과 조회 */
                        calculator.inquiryResults(true);

                        /* 반복 유무 확인 */
                        System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
                        String exit = sc.next();
                        if (exit.equals("exit")) {
                            return;
                        }

                    } catch (CalculateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
            }//switch 끝
            sc.nextLine();



        }//while 끝

    }
}
