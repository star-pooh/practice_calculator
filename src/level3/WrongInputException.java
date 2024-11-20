package level3;

public class WrongInputException extends RuntimeException {

  /**
   * 예외 발생 시 안내 메시지 출력
   *
   * @param type 올바른 데이터 타입
   */
  public WrongInputException(String type) {
    super("올바른 " + type + "를 입력해주세요. 재실행합니다.");
  }
}
