package calculator;



import java.util.Scanner;

public class App {

    public static void main(String[] args) throws CalculateException {
        Scanner sc = new Scanner(System.in);

        /* Calculator 인스턴스 생성 */
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();


        /* 반복문 시작 */
        String exit;
        do {
            /* 사칙연산 or 원의 넓이 선택 */
            System.out.print("원의 넓이를 구하시겠습니까? ('y'입력 시 원의 넓이 계산, 'n'입력 시 사칙연산): ");
            String input = sc.nextLine(); //어떤 연산을 할 지 선택하는 변수

            switch (input) {
                case "y": //원의 넓이일 경우
                    System.out.print("반지름을 입력하세요: ");
                    int r = sc.nextInt();
                    double resultCir = circleCalculator.circleCalculate(r);

                    /* 결과 출력 */
                    System.out.println("결과: " + resultCir);

                    /* 첫번째 결과 삭제 */
                    System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제): ");
                    String removeC = sc.next();
                    if (removeC.equals("remove")) {
                        circleCalculator.removeResult();
                    }

                    /* 전체 결과 조회 */
                    System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회): ");
                    String inquiryC = sc.next();
                    if (inquiryC.equals("inquiry")) {
                        circleCalculator.inquiryResults();
                    }
                    break;

                case "n": //사칙연산일 경우

                    /* 사용자에게 입력받기 */
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    int a = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int b = sc.nextInt();
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    //scanner로 char을 입력받기 위해서는 형변환 필요
                    char op = sc.next().charAt(0); // 0 : 문자의 위치

                    /* 연산 */
                    //try-catch문 안에서 연산 실행 및 결과 처리
                    try {
                        double result = arithmeticCalculator.arithmeticCalculate(a, b, op);

                        /* 결과 출력 */
                        System.out.println("결과: " + result);

                        /* 첫번째 결과 삭제 */
                        System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제): ");
                        String remove = sc.next(); //App 클래스에 Scanner가 있기때문에 여기서 실행
                        if (remove.equals("remove")) {
                            arithmeticCalculator.removeResult();
                        }

                        /* 전체 결과 조회 */
                        System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회): ");
                        String inquiry = sc.next();
                        if (inquiry.equals("inquiry")) {
                            arithmeticCalculator.inquiryResults();
                        }

                    } catch (CalculateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("잘못된 입력입니다. 계속하려면 아무 키를, 그만하려면 exit를 입력해주세요");
                    String d = sc.next();
                    if (d.equals("exit")) {
                        return;
                    }
            }//switch 끝

            /* 반복 유무 확인 */
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            exit = sc.next();
            sc.nextLine();

        } while (!exit.equals("exit"));

    }
}
