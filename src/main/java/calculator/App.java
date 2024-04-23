package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
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

            double result = 0; // 정확한 값을 출력하기 위한 double

            //연산자 조건을 switch로 나눔
            switch (op) {
                case '+' -> result = a + b;
                case '-' -> result = a - b;
                case '/' -> {
                    if (b == 0) {
                        System.out.println("두 번째 숫자로 0이 입력될 수 없습니다.");
                    } else {
                        result = (double) a / (double) b;
                    }
                }
                case '*' -> result = a * b;
                case '%' -> result = a % b;
            }

            /* 결과 출력 */
            System.out.println("결과: " + result);
            resultList.add(result);

            /* 첫번째 결과 삭제 */
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = sc.next();
            if (remove.equals("remove")) {
                resultList.remove(0); //0번 결과 삭제
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
