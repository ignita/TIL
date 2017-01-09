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

