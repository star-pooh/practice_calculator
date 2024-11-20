package level3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();
    String firstNumber, secondNumber, operator;

    while (true) {
      try {
        // 사용자 입력 및 변환
        System.out.print("첫 번째 숫자를 입력하세요 : ");
        firstNumber = sc.next();
        Number num1 = Parser.parseNumber(firstNumber);

        System.out.print("두 번째 숫자를 입력하세요 : ");
        secondNumber = sc.next();
        Number num2 = Parser.parseNumber(secondNumber);

        System.out.print("사칙 연산 기호를 입력하세요 : ");
        operator = sc.next();
        OperatorType op = Parser.parseOperator(operator);

        double result;
        // 사칙 연산 수행
        if (num1 instanceof Long && num2 instanceof Long) {
          // 두 개의 입력값이 모두 정수형이라면, 매개변수 타입을 long형으로 설정
          result = calculator.calculate(num1.longValue(), num2.longValue(), op);
        } else {
          // 두 개의 입력값 중 하나라도 실수형이라면, 매개변수 타입을 double형으로 설정
          result = calculator.calculate(num1.doubleValue(), num2.doubleValue(), op);
        }
        System.out.println("결과 : " + result);
      } catch (WrongInputException | ArithmeticException e) {
        System.out.println(e.getMessage());
        continue;
      }

      // 연산 결과 출력
      ArrayList<Double> resultList = calculator.getResultList();
      System.out.println("========== 현재 저장된 연산 결과 ==========");
      calculator.printResultList();

      // 입력값보다 큰 연산 결과 출력
      System.out.println("========== 입력값보다 큰 연산 결과 ==========");
      calculator.searchResultList(
          Math.max(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber)));

      // 연산 결과가 8개보다 많으면 연산 결과 랜덤 변경 및 삭제 수행
      if (resultList.size() > 8) {
        Random random = new Random();
        int ranNum = random.nextInt(resultList.size());
        double ranVal = random.nextDouble();
        System.out.println("========== 저장된 연산 랜덤 변경 ==========");
        calculator.setResultList(ranNum, ranVal);
        calculator.printResultList();

        System.out.println("========== 가장 오래된 연산 결과 삭제 ==========");
        calculator.removeFirstElement();
      }

      // 입력값이 exit인 경우, 프로그램 종료
      System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
      if (sc.next().equals("exit")) {
        System.exit(0);
      }
    }
  }
}
