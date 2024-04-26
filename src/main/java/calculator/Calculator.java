package calculator;
//5. Calculator 클래스에 저장된 연산 결과들을 조회하는 기능을 가진 메서드를 구현한 후
//   App 클래스의 main 메서드에 조회 메서드가 활용될 수 있도록 수정합니다.

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    Scanner sc = new Scanner(System.in); //결과 삭제 메서드를 위한 scanner 선언
    private ArrayList<Double> resultList = new ArrayList<>(); //외부에서 직접 접근하지 못하도록 수정(private)

    public double calculate(int a, int b, char op) throws CalculateException {
        double result = 0;

        //연산자 조건을 switch로 나눔
        switch (op) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '/' -> {
                if (b == 0) {
                    throw new CalculateException("두번째 숫자는 0이 될 수 없습니다.");
                } else {
                    result = (double) a / b;
                }
            }
            case '*' -> result = a * b;
            case '%' -> result = a % b;
            default -> throw new CalculateException("알 수 없는 연산자입니다.");
        }
        // 결과
        resultList.add(result);
        return result;
    }

    /* 첫번째 결과 삭제 메서드 */
    public void removeResult() {
        System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제): ");
        String remove = sc.next();
        if (remove.equals("remove")) {
            resultList.remove(0); //0번 결과 삭제
        }
    }

    /* 결과 조회 */
    public void inquiryResults() {
        System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회): ");
        String inquiry = sc.next();
        if (inquiry.equals("inquiry")) {
            for (double d :resultList) {
                System.out.println(d);
            }
        }
    }

    /* 컬렉션의 Getter, Setter 메서드 */
    public ArrayList<Double> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<Double> resultList) {
        this.resultList = resultList;
    }

}
