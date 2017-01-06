# 패키지  

- 여러 개의 클래스들이 존재할 때 여러 주체가 만든다면 동일한 이름을 가질 수 있다.  
 - 이름 충돌의 가능성  
 - 패키지를 통해 이름의 중복을 해결!  

- 도메인 이름을 패키지로 쓰면 중복될 확률이 현저히 낮아진다.  
- `import`를 이용해 다른 패키지에 있는 클래스를 가져올 수 있다.  
 ```java
 import org.opentutorials.javatutorials.pakages.example1.*;  
 ``` 

## 손 컴파일  

- 프로젝트 디렉터리의 구성  
 - src: 소스 코드가 들어있다.  
 - bin: 컴파일된 클래스 파일이 들어있다.  
 - out: IntelliJ IDEA는 여기에 클래스 파일이 들어있다.  

- 특정 디렉터리에 클래스 파일이 위치하도록 하는 방법  
```java
java src/org/opentutorials/javatutorials/packages/example3/*.java -d bin 
```
- 컴파일된 결과를 bin 디렉토리 하위에 위치시킨다.  
 - 컴파일러는 자동으로 클래스의 패키지에 해당하는 디렉터리를 생성해준다.  

## 중복의 회피  

- 인스턴스를 만들 때 패키지를 명시한다.  
```
package org.opentutorials.javatutorials.packages.example3;
import org.opentutorials.javatutorials.packages.example1.*;
import org.opentutorials.javatutorials.packages.example2.*;
 
public class D {
    public static void main(String[] args) {
        org.opentutorials.javatutorials.packages.example2.B b = new org.opentutorials.javatutorials.packages.example2.B();
    }
}
```
- example1과 example2 모두에 class B가 존재할 때 적어줘야 어떤걸 말하는지 알 수 있다.  
