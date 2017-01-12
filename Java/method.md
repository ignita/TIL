# 메소드  

## 매개 변수의 수를 모를 경우  
- 배열을 사용한다.  
```java
public class Computer {
    int sum1(int[] values) {
        int sum = 0;
        for(int i=0; i<values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    int sum2(int ... values) {
        int sum = 0;
        for(int i=0; i<values.length; i++) {
            sum += values[i];
        }
        return sum;
    }
}
```
```java
public class ComputerExample {
    public static void main(String[] args) {
        Computer myCom = new Computer();

        int[] values1 = {1, 2, 3};
        int result1 = myCom.sum1(values1);
        System.out.println("result1: " + result1);

        int result2 = myCom.sum1(new int[] {1, 2, 3, 4, 5});
        System.out.println("result2: " + result2);

        int result3 = myCom.sum2(1, 2, 3);
        System.out.println("result3: " + result3);

        int result4 = myCom.sum2(1, 2, 3, 4, 5);
        System.out.println("result4: " + result4);
    }
}
```
- 매개 변수를 배열 타입으로 선언하면, 메소드 호출 전에 배열을 생성해야 한다.  
 - 대신에 `...`을 사용해 선언하면, 값의 리스트만 넘겨주면 된다.  

## 리턴문  

- return 문 이후에 실행문이 오면 "Unreachable code"라는 컴파일 오류가 발생  

**리턴값이 없는 메소드(void)**  

- 리턴값이 없는 메소드(void로 선언된)에서도 `return`을 사용할 수 있다.   
 - `return`을 사용하면 메소드 실행을 강제 종료시킨다.  

## 메소드 호출  

**객체 내부에서 호출**  

- 내부에서 다른 메소드를 호출할 때에는 다음과 같이 작성  
```
메소드( 매개값, ... )  
```

**객체 외부에서 호출**  
- 클래스로부터 객체를 생성해야 한다.  
 - 메소드는 객체에 소속된 멤버이므로 객체가 존재하지 않으면 메소드도 존재 x  
- 객체 생성 후 도트(.) 연산자를 이용해 메소드를 호출할 수 있다.  
```java
Car myCar = new Car();  // 객체 생성
myCar.keyTurnOn();
myCar.run();
int speed = myCar.getSpeed();
```

## 메소드 오버로딩  

- 클래스 내에 같은 이름의 메소드를 여러 개 선언하는 것  
 - 하나의 메소드 이름으로 여러 기능을 담는다.  
 - 매개 변수의 타입, 개수, 순서 중 하나가 다르다.  

- 리턴 타입만 다른 것은 오버로딩이 아니다.  
```java
int divide(int x, int y) { ... }
double divide(int boonja, int bonobo) { ... } // 컴파일 에러
```
- 메소드 오버로딩의 대표적인 예는 `System.out.println()`메소드  
- 예시) 정사각형, 직사각형 넓이 구하기  
```java
public class Calculator {
    // 정사각형의 넓이
    double areaRectangle(double width) {
        return width * width;
    }

    // 직사각형의 넓이
    double areaRectangle(double width, double height) {
        return width * height;
    }
}
```
```java
public class CalculatorExample {
    public static void main(String[] args) {
        Calculator myCalc = new Calculator();

        // 정사각형
        double result1 = myCalc.areaRectangle(10);

        // 직사각형
        double result2 = myCalc.areaRectangle(10, 20);

        // 결과 출력
        System.out.println("정사각형 넓이: "+ result1);
        System.out.println("직사각형 넓이: "+ result2);
    }
}
```  

## 인스턴스 멤버와 this  

- 인스턴스 멤버: 객체(인스턴스)를 생성한 후 사용할 수 있는 필드와 메소드  
- 객체 내부에서 인스턴스 멤버에 접근하려면 `this` 키워드를 사용할 수 있다.  
```java
public class Car {
    String model;
    int speed;

    Car(String model) {
        this.model = model;  
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    void run() {
        for(int i=10; i<=50; i+=10) {
            this.setSpeed(i);
            System.out.println(this.model + "가 달립니다.(시속: " + this.speed + "km/h)");
        }
    }
}
```
```java
public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car("포르쉐");
        Car yourCar = new Car("벤츠");

        myCar.run();
        yourCar.run();
    }
}
```
 

## 정적 멤버와 static  

- 정적 멤버는 클래스에 고정된 멤버로서 객체를 생성하지 않고 사용할 수 있는 필드와 메소드를 의미  
 - 클래스 멤버라고도 한다.  

**정적 멤버 선언**  
- 선언 시 `static` 키워드를 추가적으로 붙이면 된다.  
```
public class 클래스 {
    // 정적 필드  
    static 타입 필드 [= 초기값];  

   // 정적 메소드  
   static 리턴 타입 메소드( 매개변수선언, ...) { ... }  
}
```

- 정적 멤버는 클래스에 고정된 멤버이므로 클래스 로더가 클래스(바이트 코드)를 로딩해 메소드 메모리 영역에 적재할 때 클래스별로 관리.  
 - 클래스 로딩이 끝나면 바로 사용 가능  

- 필드 선언시 인스턴스 필드? 정적 필드?  
 - 객체마다 가지고 있어야 할 데이터라면 인스턴스 필드로 선언하고, 객체마다 가지고 있을 필요성이 없는 공용적인 데이터라면 정적 필드로 선언  

- 메소드 선언시 인스턴스 메소드? 정적 메소드?  
 - 인스턴스 필드를 이용해 실행해야 한다면 인스턴스 메소드, 인스턴스 필드를 이용하지 않는다면 정적 메소드  

**정적 멤버 사용하기**  
- 클래스 이름과 함께 도트(.) 연산자로 접근  
```
클래스.필드;
클래스.메소드( 매개값, ... )  
```
- 원칙적으로는 클래스 이름으로 접근해야하지만, 객체 참조 변수로도 접근은 가능  
 - 하지만 경고 표시가 나타난다.  

**정적 초기화 블록**  
- 인스턴스 필드는 생성자에 초기화하지만 정적 필드는 객체 생성 없이도 사용해야 하기 때문에 생성자에서 초기화 작업을 할 수 없다.  
 - 정적 블록(static block)을 제공한다.  
```
static {  
   ...
}
```
- 정적 블록은 클래스가 메모리로 로딩될 때 자동적으로 실행된다.  
```java
public class Television {
    static String company = "Good";
    static String model = "LCD";
    static String info;

    static {
        info = company + "-" + model;
    }
}
```
```java
public class TelevisionExample {
    public static void main(String[] args) {
        System.out.println(Television.info);
    }
}
```  
 - info는 초기화하지 않고 정적 블록에서 company와 model 필드값을 서로 연결해 초기값으로 설정   


**정적 메소드와 블록 선언 시 주의할 점**  
- 객체가 없어도 실행된다는 특징 때문에, 내부에 인스턴스 필드나 인스턴스 메소드를 사용할 수 없다.
  - `this` 키워드도 사용 불가  
- 인스턴스 멤버들을 사용하고 싶다면 객체를 먼저 생성하고 참조 변수로 접근해야 한다.  
```java
static void Method3() {
    ClassName obj = new ClassName();
    obj.field1 = 10;
    obj.method1();
}
```

- **main() 메소드도 정적(static)메소드이므로 객체 생성 없이 인스턴스 필드와 인스턴스 메소드를 바로 사용할 수 없다.**    

## 싱글톤(Singleton)  

- 가끔 전체 프로그램에서 단 하나의 객체만 만들도록 보장해야 하는 경우가 있다. 그 객체를 싱글톤이라고 한다..  
- 싱글톤을 만들려면 클래스 외부에서 new 연산자로 생성자를 호출할 수 없도록 막아야 한다.  
 - 생성자를 호출한 만큼 객체가 생성되기 때문  
- 생성자를 외부에서 호출할 수 없도록 하려면 생성자 앞에 private 접근 제한자를 붙여주면 된다.  
- 자신의 타입인 정적 필드를 하나 선언하고 자신의 객체를 생성해 초기화한다.  
- 정적 필드도 private 접근 제한자를 붙여 외부에서 필드값을 변경하지 못하도록 막는다.  
- 대신 외부에서 호출할 수 있는 정적 메소드인 `getInstance()`를 선언하고 정ㅈ거 필드에서 참조하고 있는 자신의 객체를 리턴해준다.  
```
public class 클래스 {
    // 정적 필드
    private static 클래스 singleton = new 클래스();

    // 생성자  
    private 클래스() {}
   
    // 정적 메소드  
    static 클래스 getInstance() { 
        return singleton;
    }
}
```
- 외부에서 객체를 얻는 유일한 방법은 `getInstance()` 메소드를 호출하는 방법  
 - 하나의 객체만 리턴. 다음 코드에서 변수1과 변수2는 동일한 객체를 참조  
   ```
   클래스 변수1 = 클래스.getInstance();  
   클래스 변수2 = 클래스.getInstance();  
   ```
```java
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {}

    static Singleton getInstance() {
        return singleton;
    }
}
```
```java
public class SingletonExample {
    public static void main(String[] args){

//    Singleton obj1 = new Singleton();
//    Singleton obj2 = new Singleton();  // 컴파일 에러 (private)

        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if(obj1 == obj2) { // 같은 객체이다.
            System.out.println("같은 Singleton 객체 입니다."); 
        } else {
            System.out.println("다른 Singleton 객체 입니다.");
        }
    }
}
```

