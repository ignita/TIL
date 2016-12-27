# 클래스와 인스턴스 그리고 객체  

## 클래스와 인스턴스  

- 클래스: 설계도  
- 인스턴스: 설계도에 의해 만들어진 구체적인 제품  
- 프로그래밍의 목표 → 중복을 제거하자 →→ 메소드를 사용하자! 
  - 리팩토링 

**객체화**  

```java
left = 10;
right = 20;

sum(left, right);
avg (left, right);


left = 20;
right = 40;

sum(left, right);
avg(left, right);
```
- 연관되어 있는 로직이 반복되어 있는 코드  
```java
/**
 * Created by ox on 2016. 12. 27..
 */
class Calculator {  // 클래스. 설계도 
    int left, right;

    public void setOprands(int left, int right) {
        this.left = left;    // this는 인스턴스 자신을 가리킨다. 
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

        Calculator c1 = new Calculator();   // 객체 만들기. c1이 인스턴스이다.  
        c1.setOprands(10,20);
        c1.sum();
        c1.avg();

        Calculator c2 = new Calculator();   // 새로운 인스턴스를 생성해 재활용(?) 가능하다 
        c2.setOprands(20, 40);     
        c2.sum();
        c2.avg();
    }
}
```  

**클래스**  
```java
class Calculator {
```
- 변수 left와 right, 메소드 sum과 avg는 연관되어 있는 로직. 이 로직들을 대표해 Calculator로 그룹핑  
- 이때 키워드 `class`를 사용한다.   
- 클래스는 연관되어 있는 변수와 메소드의 집합  

**인스턴스**  
- 클래스는 일종의 설계도. 설계도를 구체적인 제품으로 만들려면 `new` 키워드를 사용  
- 그렇게 만들어진 제품을 인스턴스(instance)라 부른다.  
 - 클래스: 설계도
 - 인스턴스: 제품  
- 위의 코드는 new를 이용해 만든 인스턴스를 변수 c1에 담는다.  
- [객체?인스턴스?클래스?](http://blog.naver.com/ktw5724/220201962488)   
 - [여기도 참고](https://wikidocs.net/214) - 인스턴스는 관계위주의 의미로 사용된다. c1은 Calculator의 인스턴스이다.   

- **하나의 클래스를 바탕으로 서로 다른 상태를 가진 인스턴스를 만들면 서로 다른 행동을 하게 된다는 것을 알 수 있다.**
- 클래스는 새로운 데이터 타입을 정의하는 것일 수도 있다...
