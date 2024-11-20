package level2;

import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    Scanner sc = new Scanner(System.in);
    // 첫 번째 숫자
    int firstNumber;
    // 두 번째 숫자
    int secondNumber;
    // 사칙 연산 기호
    char operator;

    while (true) {
      System.out.print("첫 번째 숫자를 입력하세요 : ");
      firstNumber = sc.nextInt();
      System.out.print("두 번째 숫자를 입력하세요 : ");
      secondNumber = sc.nextInt();
      System.out.print("사칙 연산 기호를 입력하세요 : ");
      operator = sc.next().charAt(0);

      double result = calculator.calculate(firstNumber, secondNumber, operator);
      if (result == -1) {
        continue;
      }
      System.out.println("결과 : " + result);

      // 연산 결과 출력하기
      calculator.printResultList();
      // 연산 결과 수정하기
      System.out.println("========== 연산 결과 수정 ==========");
      calculator.setResultList(0, 123.45);
      // 연산 결과 삭제
      calculator.removeResult();

      System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
      if (sc.next().equals("exit")) {
        System.exit(0);
      }
    }
  }
}
