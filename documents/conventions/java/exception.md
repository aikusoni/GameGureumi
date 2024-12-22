## Exception 클래스 생성 규칙

1. 모든 커스텀 Exception 클래스는 다음 예시와 같이 GureumiException 인터페이스를 구현해야 한다.
```java
public interface GureumiException {
    BaseErrorCode getErrorCode();
    String getErrorAlias();
    String getMessage();
}
```
구현
```java
@Getter // lombok 사용으로 Getter 자동 생성
public class CustomGureumiException extends RuntimeException implements GureumiException {
    private final ErrorCode errorCode;
    private final String errorAlias;

    public CustomGureumiException(ErrorCode errorCode, String errorAlias, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorAlias = errorAlias;
    }
}
```