### practice_calculator

#### 사용법
각 패키지 내부의 Main.java 파일 실행

#### 파일 구조
##### level1
> Main.java : 사용자 입력값(숫자 / 연산자)에 따른 연산 수행

##### level2
> Main.java : 사용자 입력값(숫자 / 연산자) 받기, 연산 결과 출력
>
> Calculator : 입력값에 따른 연산 수행

##### level3
> Main.java : 사용자 입력값(숫자 / 연산자) 받기, 연산 결과 출력
> 
> Parser.java : 사용자 입력값에 대한 유효성 검사
> 
> InterfaceOperation.java : 연산식 인터페이스
> 
> OperatorType.java : 연산자 및 연산식 관리
> 
> ArithmeticCalculator.java : 연산 수행 및 연산 결과 관리(추가, 수정, 삭제, 출력)
>
> WrongInputException.java : 사용자 입력 및 연산에 대한 예외 처리

![image](https://github.com/user-attachments/assets/0ca499db-5e30-4269-b7d3-5cbeca06f568)

#### 만들면서 신경썼던 점
- 하나의 파일에서 여러가지 기능을 수행하지 않도록 분리하기
- 과도한 파일 분리로 인해 구조가 복잡해지지 않게 하기
- 기능 가이드에 있는 내용 최대한 구현하기
- 주석 빼먹지 않기
