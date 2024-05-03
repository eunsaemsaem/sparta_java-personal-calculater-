package calculator;

import java.util.Objects;
import java.util.Scanner;

//전체 실행 클래스
public class App {

    public static void main(String[] args) throws CalculateException {
        Scanner sc = new Scanner(System.in);

        /* 인스턴스 생성 */
        // calculator
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();
        // 정수 입력 예외처리
        InputCheck inputCheck = new InputCheck();


        /* 반복문 시작 */
        do {
            /* 사칙연산 or 원의 넓이 선택 */
            System.out.print("원의 넓이를 구하시겠습니까? ('y'입력 시 원의 넓이 계산, 'n'입력 시 사칙연산): ");
            String input = sc.next(); //어떤 연산을 할 지 선택하는 변수

            switch (input) {

                //원의 넓이일 경우
                case "y":
                    double resultCir = 0; // 연산 결과를 저장할 변수

                    try {
                        /* 사용자에게 입력받기 */
                        int r = inputCheck.getNumC();
                        resultCir = circleCalculator.circleCalculate(r);

                        /* 결과 출력 */
                        System.out.println("결과: " + resultCir);

                        /* 첫번째 결과 삭제 */
                        System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제): ");
                        if (Objects.equals(sc.next(), "remove")) {
                            circleCalculator.removeResult();
                        }

                        /* 전체 결과 조회 */
                        System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회): ");
                        if (Objects.equals(sc.next(), "inquiry")) {
                            circleCalculator.inquiryResults();
                        }

                    } catch (CalculateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                //사칙연산일 경우
                case "n":
                    int a = 0, b = 0; // 사칙연산을 위해 입력받을 정수

                    try {
                        /* 사용자에게 입력받기 */
                        a = inputCheck.getNum(); //첫번째 숫자
                        b = inputCheck.getNum(); //두번째 숫자

                        System.out.print("사칙연산 기호를 입력하세요: ");
                        //scanner로 char을 입력받기 위해서는 형변환 필요
                        char op = sc.next().charAt(0); // 0 : 문자의 위치

                        /* 연산 */
                        double result = arithmeticCalculator.arithmeticCalculate(a, b, op);

                        /* 결과 출력 */
                        System.out.println("결과: " + result);

                        /* 첫번째 결과 삭제 */
                        System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제): ");
                        if (Objects.equals(sc.next(), "remove")) {
                            arithmeticCalculator.removeResult();
                        }

                        /* 전체 결과 조회 */
                        System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회): ");
                        if (Objects.equals(sc.next(), "inquiry")) {
                            arithmeticCalculator.inquiryResults();
                        }

                    } catch (CalculateException e) {
                        System.out.println(e.getMessage());
                        break; //올바른 정수 입력이 아닌 경우 다시 계산할지 질문하도록 함
                    }
                    break;

                default: // 'y' 'n' 입력이 아닐 경우
                    System.out.println("잘못된 입력입니다. 계속하려면 아무 키를, 그만하려면 exit를 입력해주세요");
                    if (Objects.equals(sc.next(), "exit")) {
                        return;
                    }
            }//switch 끝

            /* 반복 유무 확인 */
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");

        } while (!Objects.equals(sc.next(), "exit")); // 'exit'가 입력되지 않은 경우 반복문 실행

    }

}
