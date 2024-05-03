package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCheck {

    /* 정수 입력 예외처리를 위한 클래스 */
    public static int getNum() throws CalculateException {

            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("숫자를 입력하세요: ");
                int n = sc.nextInt();
                return n;
            } catch (InputMismatchException e) {
                throw new CalculateException("올바른 정수를 입력하세요");
            }

    }

    public static int getNumC() throws CalculateException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("반지름을 입력하세요: ");
            int r = sc.nextInt();
            return r;
        } catch (InputMismatchException e) {
            throw new CalculateException("올바른 정수를 입력하세요");
        }
    }


}
