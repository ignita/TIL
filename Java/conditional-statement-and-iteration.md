# 조건문과 반복문  

## 조건문  

**if문, if-else문**  
- 중괄호 블록을 생략하지 않고 작성하는 것을 추천  
 - 가독성과 버그 발생의 원인을 없앨 수 있다.   

```java
public class IfExample {
    public static void main(String[] args) {
        int score = 93;

        if (score >= 90) {
            System.out.println("점수가 90보다 큽니다");
            System.out.println("등급은 A입니다");
        } else if (score < 90) {
            System.out.println("점수가 90보다 작습니다");
            System.out.println("등급은 B입니다");
        }
    }
}
```  

**Math.random() 메소드**   
 - 0.0과 1 사이에 속하는 double 타입 난수 하나를 리턴   

```
0.0 <= Math.random() < 1.0
0.0*10 <= Math.random()*10 < 1.0*10  
(int)0.0 <= (int)(Math.random()*10) < (int) 10.0  
0+1 <= (int)(Math.random()*10) + 1 < 10+1  
```  
```java
int num = (int)(Math.random() * n) + start;  
// start부터 시작하는 n개의 정수 중에서 임의의 정수 하나를 얻기 위한 연산식  
```  

**switch문**  

- char 타입 변수도 switch문에 사용될 수 있다.   
- 자바 7부터는 String 타입의 변수도 올 수 있다.  
```java
public class SwitchStringExample {
    public static void main(String[] args) {
        String position = "과장";

        switch(position) {
            case "부장":
                System.out.println("700만원");
                break;
            case "과장":
                System.out.println("500만원");
                break;
            default:
                System.out.println("300만원");
        }
    }
}
```   

## 반복문   

**for문**   

```java
public class ForSumFrom1To100Example {
    public static void main(String[] args) {
        int sum = 0;

        int i = 0;
        for(i=1; i<=100; i++) {
            sum += i;
        }

        System.out.println("1-" + (i-1) + "합: " + sum);
    }
}
```