# 초기화와 생성자  

## 생성자  
- 어떤 메소드보다 먼저 실행되서 초기화 작업을 가능하게 한다.  

### 생성자의 특징

- **값을 반환하지 않는다.**  
 생성자는 인스턴스를 생성해주는 역할을 하는 특수한 메소드라고 할 수 있다. 반환 값이 있다면 엉뚱한 객체가 생성될 것이다. 따라서 반환 값을 필요로하는 작업에서는 생성자를 사용하지 않는다. 반환 값이 없기 때문에 return도 사용하지 않고, 반환 값을 메소드 정의에 포함시키지도 않는다.  

- **생성자의 이름은 클래스의 이름과 동일하다.**  
 자바에서 클래스의 이름과 동일한 메소드는 생성자로 사용하기로 약속되어 있다.  

```java
class Calculator {
    static double PI = 3.14;
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
public class CalculatorDemo4 {
    public static void main(String[] args) {

        Calculator c1 = new Calculator(10, 20);
        c1.sum();
        c1.avg();

        Calculator c2 = new Calculator(20, 40);
        c2.sum();
        c2.avg();

    }
}
```
- 생성자 덕분에 Calculator 객체를 사용하기 위해 사실상 반드시 필요한 작업이라 할 수 있는 left와 right의 값을 설정하는 과정을 객체 생성 과정에서 할 수 있게 되었다.  
- 객체를 사용하기 위해서는 객체를 생성해야 한다는 사실은 기본적으로 숙지하는 것이기 때문에 이 절차에 필수적인 작업(left와 right값 입력)도 포함시킬 수 있다! 