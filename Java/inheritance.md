# 상속  

- 상속: 어떤 객체가 있을 때 그 객체의 필드(변수)와 메소드를 다른 객체가 물려받을 수 있는 기능  
- 객체에 메소드를 추가하는 것이 어렵다.  
 - 객체를 자신이 만들지 않아서 소스를 변경할 수 없다.  
 - 객체가 다양한 곳에서 활용되고 있는데 메소드를 추가하면 다른 곳에서는 불필요한 기능이 포함될 수 있다.  
- 기존의 객체를 그대로 유지하면서 어떤 기능을 추가하는 방법이 없을까? → **상속**
- 기존의 객체는 기능을 물려준다는 의미에서 부모 객체가 되고 새로운 객체는 기존 객체의 기능을 물려받는다는 의미에서 자식 객체가 된다.  
 - 부모 클래스를 상위(super) 클래스, 자식 클래스를 하위(sub) 클래스라고 표현하기도 한다.   

```java
/**
 * Created by ox on 2016. 12. 27..
 */
class Calculator {
    static double PI = 3.14;
    int left, right;

    public void setOperands(int left, int right) {
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

class SubstractionableCalculator extends Calculator {
    public void substruct() {
        System.out.println(this.left - this.right);
    }
}
public class CalculatorDemo4 {
    public static void main(String[] args) {

        SubstractionableCalculator c1 = new SubstractionableCalculator();
        c1.setOperands(10, 20);
        c1.sum();
        c1.avg();
        c1.substruct();

        Calculator c2 = new Calculator();
        c2.setOperands(20,40);
        c2.sum();
        c2.avg();
    }
}
```
- 새로운 클래스인 SubstractionableCalculator의 인스턴스 c1은 정의되지 않은 메소드들을 호출하고 있다. Calculator를 상속받고 있기 때문이다.  
 - 따라서 Calculator에서 정의한 메소드 setOperands, sum, avg 모두 사용 가능하다.  
- 상속을 통해 **코드의 중복을 제거**할 수 있고, 유지보수가 편리해진다.  
- **상속한 클래스도 상속이 가능**하다.    

## 상속과 생성자  

- 아래 예제는 에러를 발생시킴  
```java
public class ConstructorDemo {
    public ConstructorDemo(int param1) {}
    public static void main(String[] args) {
        ConstructorDemo c = new ConstructorDemo();
    }
}
```
- 매개변수가 있는 생성자가 있을 때에는 자바가 자동으로 기본 생성자를 만들어주지 않는다.  
- 그래서 위 예제는 존재하지 않는 생성자를 호출하는 것  
- 다음과 같이 기본 생성자를 추가해줘야 한다.  
```java
public class ConstructorDemo {
    public ConstructorDemo() {}
    public ConstructorDemo(int param1) {}
    public static void main(String[] args) {
        ConstructorDemo c = new ConstructorDemo();
    }
}
```

- `super` 키워드는 부모 클래스를 의미. 여기에 ()를 붙이면 부모 클래스의 생성자를 의미해 부모 클래스의 기본 생성자가 없어져도 오류가 발생하지 않는다.  
- 하위 클래스의 생성자에서 super를 사용할 때 주의할 점은 super가 가장 먼저 나타나야 한다는 점  
 - 부모가 초기화되기 전에 자식이 초기화되는 일을 방지하기 위한 정책   

```java
class Calculator {
    int left, right;
    public Calculator(int left, int right) {
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

class SubstractionableCalculator extends Calculator {
    public SubstractionableCalculator(int left, int right) {
        super(left, right);
    }
    public void substruct() {
        System.out.println(this.left - this.right);
    }
}
public class CalculatorDemo4 {
    public static void main(String[] args) {

        SubstractionableCalculator c1 = new SubstractionableCalculator(10, 20);
        c1.sum();
        c1.avg();
        c1.substruct();
    }
}
```