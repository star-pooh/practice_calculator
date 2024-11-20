package level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
  // 연산 결과 리스트
  private final List<Double> resultList = new ArrayList<>();

  /**
   * 사칙 연산 수행 후, 결과값 저장 및 반환
   *
   * @param firstNumber 첫 번째 숫자
   * @param secondNumber 두 번째 숫자
   * @param operator 사칙 연산 기호
   * @return 결과값
   */
  public double calculate(int firstNumber, int secondNumber, char operator) {
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
          return -1;
        }
        break;
      default:
        // 사칙 연산 기호 이외의 입력에 대한 예외 처리
        System.out.println("올바른 사칙 연산 기호를 입력해주세요. 재실행합니다.");
        return -1;
    }

    resultList.add(result);
    return result;
  }

  /** 연산 결과 리스트 전체 출력 */
  public void printResultList() {
    this.resultList.forEach(System.out::println);
  }

  /**
   * 수정된 연산 결과 리스트 저장
   *
   * @param resultList 수정된 연산 결과 리스트 저장
   */

  /**
   * 연산 결과 리스트 수정
   *
   * @param idx 수정 대상 인덱스
   * @param value 수정 할 값
   */
  public void setResultList(int idx, double value) {
    this.resultList.set(idx, value);
  }

  /** 가장 먼저 저장된 연산 결과 삭제 */
  public void removeResult() {
    this.resultList.remove(0);
  }
}
