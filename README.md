# Spring

## Spring의 특징

* EJB보다 가법고 배우기도 쉬우며 경량 컨테이너의 기능을 수행합니다.
* 제어 역행(IoC, Inversion of Control) 기술을 이용해 애플리케이션 간의 느슨한 결합을 제어합니다.
* 의존성 주입(DI, Dependency Injection) 기능을 지원합니다.
* 관점 지향(AOP, Aspect-Oriented Programming)기능을 이용해 자원 관리를 합니다.
* 영속성과 관련되 다양한 서비스를 지원합니다.
* 수많은 라이브러리와의 연동 기능을 지원합니다.

## DI

* 자바로 DI구현 해보기
  * [TV예제](./spring/src/main/java/tv)
* Spring을 이용하여 DI구현
  * [TV예제](./spring/src/main/java/tv/spring)

| xml                                                          | @                                                            |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| xml 파일 모든 설정 이해하기 쉽다<br />bean 생성 코드는 늘어간다<br />bean 수정 - 저장 | 자바소스 내부 설정<br />위치 정해져있다.<br />bean 태그는 늘어나지 않는다.<br />수정 자바 소스만 저장<br />한번에 모든 설정 이해하기 힘들다.<br />단순 간결한 표현<br /><br />xml 파일 내부<br /><context:component-scan base-pakage="패키지명" |



## MVC

* 자바로 spring의 [MVC](./nonspringmvc/src/main/java/test)를 구현해보자 [jsp파일](./nonspringmvc/src/main/webapp/hello.jsp)
* Spring MVC
  * [memberservice](./spring/src/main/java/memberservice)
  * Annotation을 이용 memberservice [변경](./spring/src/main/java/memberanno) 
  * 



## Mybatis

* mybatis는 jdbc가 처리하는 상당부분의 코드와 파라미터 설정 및 결과 매핑을 대신해준다.

* Mybatis 이용 hr계정에 DB연결하여 데이터 가져오기

  * 스프링 Annotation을 적용하지 않은 [mybatis](./spring/src/main/java/mybatis) 패키지

  * 스프링 Annotation을 적용한 [mybatis](./spring/src/main/java/spring_mybatis)

  * | xml파일             | 변경 및 추가사항                                             |
    | ------------------- | ------------------------------------------------------------ |
    | pom.xml             | <dependency><br/>    <groupId>org.mybatis</groupId><br/>    <artifactId>mybatis</artifactId><br/>    <version>3.4.6</version><br/></dependency><br/>		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring --><br/><dependency><br/>    <groupId>org.mybatis</groupId><br/>    <artifactId>mybatis-spring</artifactId><br/>    <version>1.3.2</version><br/></dependency><br/><br/><!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc --><br/><dependency><br/>    <groupId>org.springframework</groupId><br/>    <artifactId>spring-jdbc</artifactId><br/>    <version>4.3.18.RELEASE</version><br/></dependency><br/><br/><!-- JDK 8, 9 사용 중일 경우 --><br/><!-- https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc8 --><br/><dependency><br/>    <groupId>com.oracle.database.jdbc</groupId><br/>    <artifactId>ojdbc8</artifactId><br/>    <version>19.7.0.0</version><br/></dependency> |
    | servlet-context.xml | <context:component-scan base-package="spring_mybatis" />     |
    | web.xml             | <context-param><br/>		<param-name>contextConfigLocation</param-name><br/>		<param-value><br/>		classpath:spring_mybatis/mybatis_spring.xml<br/>		</param-value><br/>	</context-param> |


* 



## ajax

* ajax를 사용하기 위해선 다음과 같은 추가사항을 입력해주어야한다

* | xml     | 추가사항                                                     |
  | ------- | ------------------------------------------------------------ |
  | pom.xml | <dependency><br/>	<groupId>com.fasterxml.jackson.core</groupId><br/>	<artifactId>jackson-databind</artifactId><br/>	<version>2.9.3</version><br/></dependency> |

* ajax를 이용한 실습

  * [ajaxlogin](./spring/src/main/webapp/WEB-INF/views/ajax/loginajax.jsp) jsp 파일
  * [ajaxcontroller](./spring/src/main/java/ajax/LoginAjaxController.java) ajax controller
  * [ajax전용](./spring/src/main/java/ajax/AllAjaxController.java) 컨트롤러

