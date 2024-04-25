package calculator;
//3. App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정합니다. (캡슐화)
//        - 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현합니다. (Getter 메서드)
//        - 간접 접근을 통해 필드에 접근하여 수정할 수 있도록 구현합니다. (Setter 메서드)
//        - 위 요구사항을 모두 구현 했다면 App 클래스의 main 메서드에서 위에서 구현한 메서드를 활용 해봅니다.

import java.util.ArrayList;

public class Calculator {

    private ArrayList<Double> resultList = new ArrayList<>(); //외부에서 직접 접근하지 못하도록 수정

    public double calculate(int a, int b, char op) throws CalculateException {
        double result = 0;

        //연산자 조건을 switch로 나눔
        switch (op) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '/' -> {
                if (a == 0) {
                    throw new CalculateException("두번째 숫자는 0이 될 수 없습니다."); //왜 출력이 안되고 값이 infinity로 저장될까..?
                } else {
                    result = (double) a / b;
                }
            }
            case '*' -> result = a * b;
            case '%' -> result = a % b;
            default -> throw new CalculateException("알 수 없는 연산자입니다.");
        }
        resultList.add(result); ///////App으로 옮기기!
        return result;
    }

    /* Getter, Setter 메서드 */
    public ArrayList<Double> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<Double> resultList) {
        this.resultList = resultList;
    }

}
