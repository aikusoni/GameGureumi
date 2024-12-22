# 메시지와 로깅

### 메시지
- 메시지는 기본적으로 i18n을 사용한 다국어를 지원해야한다.
- 메시지는 `MessageSource`를 사용하여 관리한다.
- 메시지는 resources/messages 폴더 내의 `<모듈명>-messages.properties` 파일에 작성한다.
- 기본 메시지는 messages.properties, 다국어 메시지는 messages_{언어코드}.properties 파일에 작성하고, 국가별 메시지는 messages_{언어코드}_{국가코드}.properties 파일에 작성한다.

예)
```
# 코어 모듈의 경우
resources/messages/core-messages.properties
resources/messages/core-messages_en.properties
resources/messages/core-messages_en_US.properties
resources/messages/core-messages_en_GB.properties
resources/messages/core-messages_ko.properties
resources/messages/core-messages_ko_KR.properties

# mvc 모듈의 경우
resources/messages/mvc-standard-messages.properties
resources/messages/mvc-standard-messages_en.properties
resources/messages/mvc-standard-messages_en_US.properties
resources/messages/mvc-standard-messages_en_GB.properties
resources/messages/mvc-standard-messages_ko.properties
resources/messages/mvc-standard-messages_ko_KR.properties
```

- 모듈간 충돌을 막기 위해 메시지키는 다음 에시와 같이 `모듈명.<메시지명>` 형식으로 작성한다.

```
# 예) spring-mvc-standard 모듈의 메시지
spring-mvc-standard.test-message=웹 MVC 모듈의 테스트 메시지입니다.
```

```
# 예) spring-core 모듈의 메시지
spring-core.test-message=코어 모듈의 테스트 메시지입니다.
```

### 로깅
- 로깅의 경우 i18n 처리시 부하 발생이 우려되므로 메시지를 사용치 않고 일반적인 문자열 리터럴을 사용한다. 