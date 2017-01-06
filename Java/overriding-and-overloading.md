# 오버라이딩과 오버로딩

## 오버라이딩 

- 상위 클래스의 메소드를 하위 클래스가 주어진 그대로 사용한다면 제약이 상당할 것이다 → 메소드 오버라이딩을 사용한다. 
- 메소드 오버라이딩  
 - 부모 클래스의 메소드를 자식 클래스에서 재정의하면 자식 클래스의 메소드가 실행된다.  

- 오버라이딩을 하기 위해서는 **아래의 조건을 충족**해야 한다.  
 - 메소드의 이름  
 - 메소드 매개변수의 숫자와 데이터 타입 그리고 순서  
 - 메소드의 리턴 타입  

- 부모 클래스의 메소드와 자식 클래스의 메소드가 중복이 된다면, `super` 키워드를 사용  
```java
public int avg() {
    return super.avg();
}
```

## 오버로딩  

- 같은 메소드의 이름에 매개변수의 숫자나 데이터 타입을 다르게 만든 것  
```java
public void setOperands(int left, int right) {
    Systme.out.println("setOperands(int left, int right)");
    this.left = left;
    this.right = right;
}
public void setOperands(int left, int right, int third) {
    Systme.out.println("setOperands(int left, int right, int third)");
    this.left = left;
    this.right = right;
    this.third = third;
}
```
```
c1.setOperands(10, 20);
c1.sum();
c1.avg();
c1.setOperands(10, 20, 30);
c1.sum();
c1.avg();
```  

- **이름은 같지만 시그니처는 다른 메소드를 중복으로 선언할 수 있는 방법을 메소드 오버로딩(overloading)이라고 한다.**  

### 오버로딩의 규칙  

- 결론적응로 매개변수가 다르면 이름이 같아도 서로 다른 메소드가 되는 것.  
- 반면에 매개변수는 같지만 리턴타입이 다르면 오류가 발생  
```java
public class OverloadingDemo {
    void A () {
        System.out.println("void A()");
    }
    void A (int arg1) {
        System.out.println("void A (int arg1)");
    }
    void A (String arg1) {
        System.out.println("void A (String arg1)");
    }
    // int A () {System.out.println("void A()");}
    public static void main(String[] args) {
        OverloadingDemo od = new OverloadingDemo();
        od.A();
        od.A(1);
        od.A("Overloading Demo");
    }
}
```
- `int A()`는 리턴 타입이 다르기 때문에 오버로딩을 할 수 없다.  
- 매개변수의 이름만 다르다고해서 오버로딩이 되는 것은 아니다.  

### 상속과 오버로딩  

- 상속관계에서도 오버로딩을 사용할 수 있다.  
```java
public class OverloadingDemo2 extends OverloadingDemo {
    void A (String arg1, String arg2) { // 메소드 오버로딩
        System.out.println("sub class: void A (String arg1, String arg2)");
    }
    void A () { // 메소드 오버라이딩. 매개변수가 없는 것이 부모 클래스에 이미 존재 
        System.out.println("sub class: void A ()");
    }
    public static void main(String[] args) {
        OverloadingDemo2 od = new OverloadingDemo2();
        od.A();
        od.A(1);
        od.A("coding everybody");
        od.A("coding everybody", "coding everybody");
    }
}
```   
```
sub class: void A ()
void A (int arg1)
void A (String arg1)
sub class: void A (String arg1, String arg2)
```

### overriding VS overloading  

- riding(올라탄다)을 이용해 부모 클래스의 메소드의 동작방법을 변경하고, loading을 이용해 같은 이름, 다른 매개변수의 메소드들을 여러개 만들 수 있다는 사실을 아는 것이 중요  
