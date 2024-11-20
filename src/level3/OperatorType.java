package level3;

import java.util.Arrays;

/** 연산자 Enum */
public enum OperatorType implements InterfaceOperation {
  ADD('+') {
    @Override
    public double operate(double firstNumber, double secondNumber) {
      return firstNumber + secondNumber;
    }
  },
  SUBTRACT('-') {
    @Override
    public double operate(double firstNumber, double secondNumber) {
      return firstNumber - secondNumber;
    }
  },
  MULTIPLY('*') {
    @Override
    public double operate(double firstNumber, double secondNumber) {
      return firstNumber * secondNumber;
    }
  },
  DIVIDE('/') {
    @Override
    public double operate(double firstNumber, double secondNumber) {
      // 0으로 나눴을 때의 예외 처리
      if (secondNumber == 0) {
        throw new ArithmeticException("나눗셈 연산에서 분모(두 번째 숫자)에 0이 입력될 수 없습니다. 재실행합니다.");
      }
      return firstNumber / secondNumber;
    }
  };

  private final char value;

  OperatorType(char value) {
    this.value = value;
  }

  /**
   * 사용자가 입력한 연산 기호와 일치하는 Enum 객체 획득
   *
   * @param operator 사용자가 입력한 연산 기호
   * @return 연산자 Enum 객체
   */
  public static OperatorType getOperatorType(char operator) {
    return Arrays.stream(values()).filter(op -> op.value == operator).findFirst().get();
  }
}
