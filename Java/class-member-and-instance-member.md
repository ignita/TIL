# 클래스 멤버와 인스턴스 멤버   

## 멤버  

- 멤버(member): 구성원  
- 객체의 구성원  
 - 변수
 - 메소드  

## 클래스 변수 

- **클래스의 변수는 모든 인스턴스에서 똑같은 값**을 가진다.  

- 계산기에서 원주율을 알아내는 기능 추가하기  
```java
class Calculator {
    static double PI = 3.14;
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public void sum() {
        System.out.println(this.left + this.right);
    }

    public void avg() {
        System.out.println((this.left+this.right)/2);
    }
}
public class CalculatorDemo4 {
    public static void main(String[] args) {

        Calculator c1 = new Calculator();
        System.out.println(c1.PI);

        Calculator c2 = new Calculator();
        System.out.println(c2.PI);

        System.out.println(Calculator.PI);
    }
}
```
- 클래스 변수의 용도   
 - 인스턴스에 따라서 변하지 않는 값이 필요한 경우(위의 예에서는 PI. final을 이용해 상수로 선언하는 것이 바람직)  
 - 인스턴스를 생성할 필요가 없는 값을 클래스에 저장하고 싶은 경우  
 - 값의 변경 사항을 모든 인스턴스가 공유해야하는 경우  

## 클래스 메소드  

- 생각해보면 인스턴스가 항상 left값과 right값을 유지하고 있어야 할 필요가 없다.  
- 그래서 합계나 평균을 구할 때마다 좌항과 우항의 값을 주는 방식으로 계산이 가능하다.  
```java
class Calculator3 {
    public static void sum(int left, int right) {
        System.out.println(left+right);
    }
    public static void avg(int left, int right) {
        System.out.println((left+right)/2);
    }
}
public class CalculatorDemo3 {

    public static void main(String[] args) {
        Calculator3.sum(10, 20);
        Calculator3.avg(10, 20);

        Calculator3.sum(20, 40);
        Calculator3.avg(20, 40);
    }
}
```
- 메소드가 인스턴스 변수를 참조하지 않는다면 클래스 메소드를 사용해 불필요한 인스턴스의 생성을 막을 수 있다.  

1. **인스턴스 메소드는 클래스 멤버에 접근할 수 있다.**  
2. **클래스 메소드는 인스턴스 멤버에 접근할 수 없다.**  

## 용어  

- 인스턴스 변수와 클래스 변수는 아래와 같이 부르기도 한다.  
  - 인스턴스 변수 → Non-Static Field  
  - 클래스 변수 → Static Field  
- 필드(field)라는 것은 클래스 전역에서 접근할 수 있는 변수를 의미한다.   



