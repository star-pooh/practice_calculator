package level1;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
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

      double result = 0;
      switch (operator) {
        case '+':
          result = firstNumber + secondNumber;
          break;
        case '-':
          result = firstNumber - secondNumber;
          break;
        case '*':
          result = firstNumber * secondNumber;
          break;
        case '/':
          try {
            result = firstNumber / secondNumber;
          } catch (ArithmeticException e) {
            // 0으로 나눴을 때의 예외 처리
            System.out.println("나눗셈 연산에서 분모(두 번째 숫자)에 0이 입력될 수 없습니다. 재실행합니다.");
            continue;
          }
          break;
        default:
          // 사칙 연산 기호 이외의 입력에 대한 예외 처리
          System.out.println("올바른 사칙 연산 기호를 입력해주세요. 재실행합니다.");
          continue;
      }
      System.out.println("결과 : " + result);
      System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
      if (sc.next().equals("exit")) {
        System.exit(0);
      }
    }
  }
}
