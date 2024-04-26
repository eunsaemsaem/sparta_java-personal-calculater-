package calculator;
//7. Calculator 클래스에 반지름을 매개변수로 전달받아 원의 넓이를 계산하여 반환해주는 메서드를 구현합니다.
//   - APP 클래스의 main 메서드에 Scanner를 활용하여 사칙연산을 진행할지 원의 넓이를 구할지 명령어를 입력 받은 후
//     원의 넓이를 구하는 것을 선택했을 때 원의 반지름을 입력 받아 원의 넓이를 구한 후 출력되도록 구현합니다.
//      - 기존에 구현되어있던 사칙연산 기능은 수정 후에도 반드시 이전과 동일하게 동작해야합니다.
//   - 이때, static, final 키워드를 활용할 수 있는지 고민한 후 활용 해봅니다.
//      - 반드시 static, final 키워드에 대한 설명과 활용한 이유에 대해 주석으로 작성합니다.
//   - 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성
//      - 계산된 원의 넓이를 저장합니다.
//      - 생성자로 초기화됩니다.
//      - 외부에서 직접 접근할 수 없습니다.
//      - Getter, Setter 메서드를 구현합니다.
//      - 원의 넓이 결과값들을 조회하는 메서드를 구현합니다.


import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    Scanner sc = new Scanner(System.in); //결과 삭제 메서드를 위한 scanner 선언

    /* 결과를 저장하는 컬렉션 타입 필드 (외부에서 직접 접근하지 못하도록 private 선언) */
    //사칙연산
    private static ArrayList<Double> resultList = new ArrayList<>(); //하나만 존재하는 list이기 때문에 static으로 선언? => setter가 필요없는거 아닌지,,
    //원의넓이
    private static ArrayList<Double> circleList = new ArrayList<>();

    /* 생성자 */
    //컬렉션 필드 초기화
    public Calculator(ArrayList<Double> resultList, ArrayList<Double> circleList) {
        resultList.clear();
        circleList.clear();
    }

    /* 1. 사칙연산 메서드 */
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

    /* 2. 원의 넓이를 구하는 메서드 */
    public double calculateCircleArea(int r) {
        final double pi = 3.14159; //변하지 않는 상수로 선언
        double resultCir = 0;
        resultCir = pi * r * r; //계산

        // 결과
        circleList.add(resultCir);
        return resultCir;
    }

    /* 첫번째 결과 삭제 메서드 */
    public void removeResult(boolean w) { //사칙연산(T), 원의넓이(F) - 어떤 컬렉션을 호출할 지 선택하기 위한 매개변수
        System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제): ");
        String remove = sc.next();
        if (remove.equals("remove")) {
            if (w) {
                resultList.remove(0); //사칙연산
            } else {
                circleList.remove(0); //원의넓이
            }
        }
    }

    /* 결과 조회 */
    public void inquiryResults(boolean w) { //사칙연산(T), 원의넓이(F) - 어떤 컬렉션을 호출할 지 선택하기 위한 매개변수
        System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회): ");
        String inquiry = sc.next();
        if (inquiry.equals("inquiry")) {
            if (w) {
                for (double d : resultList) { //사칙연산
                    System.out.println(d);
                }
            } else {
                for (double c : circleList) { //원의넓이
                    System.out.println(c);
                }
            }
        }
    }


    /* 컬렉션의 Getter, Setter 메서드 */
    //사칙연산
    public static ArrayList<Double> getResultList() {
        return resultList;
    }

    public static void setResultList(ArrayList<Double> resultList) {
        Calculator.resultList = resultList;
    }

    //원의넓이
    public static ArrayList<Double> getCircleList() {
        return circleList;
    }

    public static void setCircleList(ArrayList<Double> circleList) {
        Calculator.circleList = circleList;
    }

}
