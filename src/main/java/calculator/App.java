package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws CalculateException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> resultList = new ArrayList<Double>(); //배열 선언

        while (true) {

            /* 입력받기 */
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int a = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int b = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            //scanner로 char을 입력받기 위해서는 형변환 필요
            char op = sc.next().charAt(0); // 0 : 문자의 위치

            Calculator calculator = new Calculator();
            double result = 0;
            result = calculator.calculate(a, b, op);


            /* 결과 출력 */
            System.out.println("결과: " + result);
            resultList.add(result);

            /* 첫번째 결과 삭제 */
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = sc.next();
            if (remove.equals("remove")) {
                resultList.remove(0); //0번 결과 삭제
            }

            /* 결과 조회 */
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiry = sc.next();
            if (inquiry.equals("inquiry")) {
                for(double d:resultList) { //for-each문
                    System.out.println(d);
                }
            }

            /* 반복 유무 확인 */
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if (exit.equals("exit")) {
                break;
            }
        }

    }
}
