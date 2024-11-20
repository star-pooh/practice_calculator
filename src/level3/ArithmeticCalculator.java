package level3;

import java.util.ArrayList;

public class ArithmeticCalculator<T extends Number> {
  // 연산 결과 리스트
  private final ArrayList<Double> resultList = new ArrayList<>();

  /**
   * 연산 결과 리스트 획득
   *
   * @return 연산 결과 리스트
   */
  public ArrayList<Double> getResultList() {
    return this.resultList;
  }

  /**
   * 연산 결과 리스트 수정
   *
   * @param idx 수정 대상 인덱스
   * @param value 수정값
   */
  public void setResultList(int idx, double value) {
    this.resultList.set(idx, value);
  }

  /** 가장 오래된 연산 결과 삭제 */
  public void removeFirstElement() {
    this.resultList.remove(0);
  }

  /**
   * 입력 값보다 큰 연산 결과 출력
   *
   * @param value 입력 값 중에서 큰 값
   */
  public void searchResultList(double value) {
    this.resultList.stream().filter(i -> i > value).toList().forEach(System.out::println);
  }

  /** 연산 결과 리스트 전체 출력 */
  public void printResultList() {
    this.resultList.forEach(System.out::println);
  }

  /**
   * 사칙 연산 수행
   *
   * @param firstNumber 첫 번째 입력값
   * @param secondNumber 두 번째 입력값
   * @param operator 연산자
   * @return 사칙 연산 결과
   */
  public double calculate(T firstNumber, T secondNumber, OperatorType operator) {
    // 입력값이 정수/실수인 경우에 따라 연산 결과도 정수/실수로 리턴할 수 있지만,
    // 정적 언어 타입인 자바에 무분별한 제네릭 사용은 좋지 않을 수 있다고 생각하여 double로만 연산 실행
    double result = operator.operate(firstNumber.doubleValue(), secondNumber.doubleValue());
    this.resultList.add(result);
    return result;
  }
}
