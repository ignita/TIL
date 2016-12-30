# 유효범위  

- 변수와 메소드는 이름이 있기 때문에 사용할 수 있다.  
- 프로그램이 커지면 여러 가지 이유로 이름이 충돌하게 된다. 이를 해결하기 위해 고안된 것이 **유효범위**라는 개념.  
- 흔히 **스코프**(Scope)라고도 부른다.    
- 과거에는 메소드 내부의 변수가 외부의 변수에도 영향을 미쳐서 변수나 메소드의 이름을 사무실 칠판에 적어가며 코딩을 해야했던 시절도 있었다고 한다.  


- 문제  
```java
public class ScopeDemo {
    static void a() {
        int i = 0;    // 지역변수
    }

    public static void main(String[] args) {
        for(int i=0; i<5; i++) {
            a();
            System.out.print(i) ; // 01234
        }
    }
}
```
- `a()` 메소드 안에 선언된 i이기 때문에 바깥의 반복문에서는 영향을 미치지 못한다.  

## 다양한 유효범위들  

- 유효범위는 디렉터리에 비유할 수 있다.  

- 파일 두개를 선택해 compare할 수 있다.(IDE) 사용   

```java
public class ScopeDemo2 {
        static int i;    // 전역변수

        static void a() {
            i = 0;
        }

        public static void main(String[] args) {
            for(i=0; i<5; i++) {
                a();
                System.out.println(i) ;
            }
        }
}
```

```java
public class ScopeDemo4 {
    static void a() {
        String title = "coding everybody";
    }
    public static void main(String[] args) {
        a();
        System.out.println(title);
    }
}
```
- title은 a에 존재하는 변수이기 때문에 main에서 사용할 수 없다.  
- 정적 스코프(static scope) 혹은 렉시컬 스코프(lexical scope)라고도 부른다.  
- 동적 스코프라는 것도 있다.  

## 인스턴스의 유효범위  

```java
class C {
    int v = 10;

    void m() {
        int v = 20;
        System.out.println(v);      // 20
        System.out.println(this.v); // 10
    }
}
public class ScopeDemo7 {

    public static void main(String[] args) {
        C c1 = new C();
        c1.m();
    }
}
```

## 교훈  
- 유효범위란 변수를 전역변수, 지역변수로 나눠 좀 더 관리하기 편리하도록 한 것  
- 객체지향 프로그래밍에서도 가급적이면 전역변수 사용을 자제하는 것이 좋고, 동시에 단일 객체가 너무 비대해지지 않도록 적절하게 규모를 쪼개는 것도 중요하다.  

