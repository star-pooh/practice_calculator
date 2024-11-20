package level3;

public class Parser {
  // 연산자 입력 정규 표현식
  private static final String OPERATION_REG = "[+\\-*/]";
  // 숫자 입력 정규 표현식
  private static final String NUMBER_REG = "^([\\-]?[0-9]+)([.]?[0-9]*)$";

  /**
   * 사용자 입력값을 숫자로 변환
   *
   * @param value 사용자 숫자 입력값
   * @return 정수값 또는 실수값
   * @throws WrongInputException 정규 표현식을 벗어난 입력에 대한 예외 처리
   */
  public static Number parseNumber(String value) throws WrongInputException {
    // 정규 표현식을 벗어난 입력에 대한 예외 처리
    if (!value.matches(NUMBER_REG)) {
      throw new WrongInputException("정수 또는 실수");
    } else {
      // 입력값에 "." 이 있는지 없는지에 따라 정수 또는 실수로 변환
      if (value.contains(".")) {
        return Double.parseDouble(value);
      } else {
        return Long.parseLong(value);
      }
    }
  }

  /**
   * 사용자 입력값에 맞는 연산자 Enum 객체 획득
   *
   * @param operator 사용자 연산자 입력값
   * @return 연산자
   * @throws WrongInputException 정규 표현식을 벗어난 입력에 대한 예외 처리
   */
  public static OperatorType parseOperator(String operator) throws WrongInputException {
    // 정규 표현식을 벗어난 입력에 대한 예외 처리
    if (!operator.matches(OPERATION_REG)) {
      throw new WrongInputException("연산자");
    } else {
      // 입력값에 대한 연산자 Enum 객체 획득
      return OperatorType.getOperatorType(operator.charAt(0));
    }
  }
}
