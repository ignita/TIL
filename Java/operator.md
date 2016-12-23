**chap03**   

# 연산자<sup>Operator</sup>  

- 연산: 프로그램에서 **데이터를 처리**해 결과를 산출하는 것    
 - 연산자: 연산에 사용되는 표시나 기호  
 - 피연산자(operand): 연산되는 데이터  
 - 연산식(expressions): 연산자와 피연산자를 이용해 연산의 과정을 기술한 것  

- 연산의 방향과 우선순위  
 1. 단항, 이항, 삼항 연산자 순으로 우선순위를 가진다.  
 2. 산술, 비교, 논리, 대입 연산자 순으로 우선순위를 가진다.  
 3. 단항과 대입 연산자를 제외한 모든 연산의 방향은 왼쪽에서 오른쪽이다(→).    
 4. 복잡한 연산식에는 괄호()를 사용해서 우선순위를 정해준다.  

## 단항 연산자  

**부호 연산자**  

- 부호 연산자의 산출 타입은 int 타입  
```java
short s = 100
short result = -s; // 컴파일 에러  
```
```java
/**
 * Created by ox on 2016. 12. 23..
 */
public class SignOperatorExample {
    public static void main(String[] args) {
        int x = -100;
        int result1 = +x;
        int result2 = -x;
        System.out.println("result1=" + result1);
        System.out.println("result2=" + result2);

        short s = 100;
        // short result3 = -s; // 컴파일 에러
        int result3 = -s;
        System.out.println("result3=" + result3);
    }
}
```

**증감 연산자**  

```java
int x = 1;
int y = 1;
int result1 = ++x + 10;
int result2 = y++ + 10;
```
 - result1에는 12가 저장된다. x의 값이 1 증가되어 2가 된 후 10과 합해진다.  
 - result2에는 11이 저장된다. y값인 1과 10이 더해져 11이 된 후 y가 1이 증가되어 2가 되기 때문이다.  

**논리 부정 연산자(!)**   

- 조건식에서 실행흐름 제어와 두 가지 상태(true/false)를 번갈아가며 변경하는 토글(toggle) 기능을 구현할 때 주로 사용    

**비트 반전 연산자(~)**  

- `Integer.toBinaryString` 메소드를 사용하면 정수값을 총32비트의 이진 문자열로 리턴   

## 이항 연산자  

- long 타입을 제외한 정수의 산술 연산은 무조건 int 타입으로 변환 후 연산을 수행한다. 산출 타입이 int이기 때문에.
  - JVM이 기본적으로 32비트 단위로 계산하기 때문이다.   

- 산술 연산에서는 올바른 계산을 위해 값을 미리 검정하고 실수 타입을 피하고, 특수값 처리에 신경써야 한다.  

**오버플로우 탐지**  

```java
/**
 * Created by ox on 2016. 12. 23..
 */
public class CheckOverflowExample {
    public static void main(String[] args) {
        try {
            int result = safeAdd(2000000000, 2000000000);
            System.out.println(result);
        } catch(ArithmeticException e) {
            System.out.println("오버플로우가 발생하여 정확하게 계산할 수 없음 ");
        }
    }
    public static int safeAdd(int left, int right) {
        if((right>0)) {
            if(left>(Integer.MAX_VALUE - right)) {
                throw new ArithmeticException("오버플로우 발생");
            }
        } else {
            if(left<(Integer.MIN_VALUE - right)) {
                throw new ArithmeticException("오버플로우 발생");
            }
        }
        return left+right;
    }
}

```

- 정확하게 계산할 때에는 부동소수점 타입을 사용하지 않는다.  
 - double, float   

**Nan과 Infinity 연산**  

- / 또는 % 연산자를 사용할 때에는 좌측 피연산자가 정수 타입인 경우 나누는 수인 우측 피연산자는 0을 사용할 수 없다.  
 - 실행 시 컴파일은 되지만 ArithmeticException(예외)이 발생한다.  
- 자바는 프로그램 실행 도중에 예외가 발생하면 실행을 즉시 멈추고 프로그램이 종료된다.   
- ArithmeticException이 발생했을 겨웅에 프로그램이 종료되지 않으려면 **예외 처리**를 해야 한다.  

- 실수 타입인 0.0 또는 0.0f로 나누면 ArithmeticException이 발생하지 않고 / 연산의 결과는 **Infinity**(무한대) 값을 가지며, % 연산의 결과는 **NaN**(Nat a Number)을 가진다.    
 - 이를 확인하기 위해서는 `Double.isInfinity()` 메소드와 `Double.isNan()` 메소드를 이용하면 된다.  
 - 값이 Infinity 또는 NaN이면 true를 리턴하고, 아니면 false를 리턴  
```java   
/**
 * Created by ox on 2016. 12. 23..
 */
public class InfinityAndNaNCheckExample {
    public static void main(String[] args) {
        int x = 5;
        double y = 0.0;

        //double z = x / y;
        double z = x % y;

        System.out.println(Double.isInfinite(z));
        System.out.println(Double.isNaN(z));

        System.out.println(z + 2);  // 문제가 있는 코드
    }
}
```

**문자열 연결 연산자(+)**
- 문자열고 숫자가 혼합된 + 연산식은 왼쪽에서부터 오른쪽으로 연산이 진행된다.   
```java
public class StringConcatExample {
    public static void main(String[] args) {
        String str1 = "JDK" + 6.0;
        String str2 = str1 + " 특징";
        System.out.println(str2);

        String str3 = "JDK" + 3 + 3.0;
        String str4 = 3 + 3.0 + "JDK";
        System.out.println(str3);
        System.out.println(str4);
    }
}
```  

**비교 연산자**  

- String 타입의 문자열을 비교할 때에는 대소 연산자를 사용할 수 없고, 동등(==, !=) 비교 연사자는 사용할 수 있지만 문자열이 같은지, 다른지를 비교하는 용도로 사용되지 않는다.   
```java
String strVar1 = "자바다";
String strVar2 = "자바다";
String strVar3 = new String("자바다");   
```
- 자바는 문자열 리터럴이 동일하면 동일한 String 객체를 참조하도록 되어 있다.  
- 그래서 변수 strVar1과 strVar2는 동일한 String 객체의 번지값을 가지고 있다.  
- 하지만 변수 strVar3은 객체 생성 연산자인 new로 생성한 새로운 String 객체의 번지값을 가진다.   
- String 객체의 문자열만 비교하고 싶다면 `equals()` 메소드를 사용하면 된다.  
  - 문자열이 동일한지 비교 후 true, false를 리턴한다.    
  ```java
  boolean result = str1.equals(str2)  
  ```  

   ```java
  /**
 * Created by ox on 2016. 12. 23..
 */
public class StringEqualsExample {
    public static void main(String[] args) {
        String strVar1 = "신민철";
        String strVar2 = "신민철";
        String strVar3 = new String("신민철");

        System.out.println(strVar1 == strVar2);
        System.out.println(strVar1 == strVar3);
        System.out.println();
        System.out.println(strVar1.equals(strVar2));
        System.out.println(strVar1.equals(strVar3));
    }
}

   ```

- 그 외에도 논리 연산자, 비트 연산자, 삼항 연산자 등이 있다...


## 확인문제   

1. 3  
2. 31  
3. 가  
4. #1(pencils / students), #2(pencils % students)  
5. #1(value - value%100)  
6. #1((lengthTop + lengthBottom) * height / 2.0)  
7. true, false  
8. #1(Double.isNaN(z))  


