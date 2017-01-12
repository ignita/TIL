# final 필드와 상수  

## final 필드  
- 초기값이 저장되면 최종적인 값이 되어서 프로그램 실행 도중에 수정이 불가능하다.  
```
final 타입 필드 [=초기값];
```
- final 필드에 초기값을 주는 법  
  - 필드 선언 시에 주는 방법  
  - 생성자에서 주는 방법  

- 예) 주민등록번호 입력  
```java
public class Person {
    final String nation = "Korea";  // 변경 불가  
    final String ssn;   // 주민등록번호  
    String name;

    public Person(String ssn, String name) {
        this.ssn = ssn;
        this.name = name;
    }
}
```
```java
public class PersonExample {
    public static void main(String[] args) {
        Person p1 = new Person("123456-1234567", "계백");

        System.out.println(p1.nation);
        System.out.println(p1.ssn);
        System.out.println(p1.name);

//        p1.nation = "USA";
//        p1.ssn = "123456-1111111";    // final 필드 값은 수정 불가
        p1.name="을지";
    }
}
```
 - 주민등록번호 필드는 한 번 값이 저장되면 변경할 수 없는 final 필드로 선언  
 - 하지만 주민등록번호는 Person 객체가 생성될 때 부여되므로 Person 클래스 설계 시 초기값을 미리 줄 수 없다.  
 - 그래서 생성자 매개값으로 번호를 받아 초기값으로 지정한다. 반면에 국가는 항상 고정된 값을 갖기 때문에 필드 선언 시 초기값으로 "Korea"를 주었다.  



## 상수(static final)  

- 일반적으로 불변의 값을 상수라 한다.  
  - 원주율 파이나 지구의 무게 및 둘레 등...
- 불변의 값을 저장하는 필드를 자바에서는 상수(constant)라고 한다.  
- final 필드를 상수라 부르진 않는다. 상수는 객체마다 저장할 필요가 없는 공용성을 띄고 있고 여러 가지 값으로 초기화될 수 없기 때문이다.  
  - final 필드는 객체마다 저장되고, 생성자의 매개값을 통해 여러 가지 값을 가질 수 있기 때문  

- 상수는 static이면서 final 이어야 한다.  
 - 객체마다 저장되지 않고 클래스에서만 포함된다.  
```
static final 타입 상수 [=초기값];  
```
```
static final 타입 상수;
static {
    상수 = 초기값;
}
```
- 초기값이 단순 값이면 선언 시에 주는 것이 일반적이지만 복잡하면 정적 블록에서도 할 수 있다.  
- 상수 이름은 대문자로 작성하는 것이 관례. 혼합된 단어면 언더바(_)로 단어들을 연결  

```java
public class Earth {
    static final double EARTH_RADIUS = 6400;
    static final double EARTH_SURFACE_AREA;

    static {
        EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
        // Math.PI는 자바에서 제공하는 상수
    }
}
```
```java
public class EarthExample {
    public static void main(String[] args) {
        System.out.println("지구의 반지름: "+ Earth.EARTH_RADIUS + "km");
        System.out.println("지구의 표면적: "+ Earth.EARTH_SURFACE_AREA + "km^2");
    }
}
```


