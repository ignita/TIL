# 참조 타입  

## 데이터 타입 분류   

- 자바의 데이터 타입  
 - 기본 타입(원시 타입:primitive type): 정수, 실수, 문자, 논리 리터럴을 저장하는 타입  
 - 참조 타입(reference type): 객체의 번지를 참조. 배열, 열거, 클래스, 인터페이스 타입    

- **변수**는 **스택 영역**에 생성, **객체**는 **힙 영역**에 생성된다.  

## 메모리 사용 영역  

![JVM의 메모리 영역](http://blog.codecentric.de/wp-content/uploads/2009/12/java-memory-architecture-1.jpg)

**메소드(Method) 영역**  
- 메소드 영역은 JVM이 시작할 때 생성되고 모든 스레드가 공유하는 영역  
 
**힙(Heap) 영역**
- 객체와 배열이 생성되는 영역  
- 힙 영역에 생성된 객체와 배열은 JVM 스택 영역의 변수나 다른 객체의 필드에서 참조  
 - 참조하는 변수/필드가 없으면 의미 없는 객체이므로 쓰레기 수집기(Garbage Collector)를 실행시켜 힙에서 자동으로 제거   
 - 그래서 객체 제거를 위해 별도의 코드 작성 불필요!   

**JVM 스택(Stack) 영역**  
- 각 스레드마다 하나씩 존재. 스레드가 시작될 때 할당된다.  
 - 자바 프로그램에서 추가적으로 스레드를 생성하지 않는다면 main 스레드만 존재하므로 JVM 스택도 하나  
- JVM 스택은 메소드를 호출할 때마다 프레임(Frame)을 추가(push)하고 메소드가 종료되면 해당 프레임을 제거(pop)하는 동작을 수행   
- 프레임 내부에는 로컬 변수 스택이 존재. 기본 타입 변수와 참조 타입 변수가 추가(push)되거나 제거(pop)된다.   
- 기본 타입 변수는 스택 영역에 직접 값을 가지고 있지만, **참조 타입 변수는 값이 아니라 힙 영역이나 메소드 영역의 객체 주소를 가진다**.   

## 참조 변수의 ==, != 연산   

- 참조 타입 변수의 값은 힙 영역의 객체 주소이므로 값 비교는 결국 **주소 값을 비교**하는 것이다.   

## null과 NullPointerException  

**null**
- 참조 타입 변수는 힙 영역의 객체를 참조하지 않는다는 뜻으로 null(널) 값을 가질 수 있다.  
 - null 값도 초기값으로 사용가능하기 때문에 null로 초기화된 참조 변수는 스택 영역에 생성된다.   
- 참조 타입 변수가 null 값을 갖는지 확인하려면 ==, != 연산을 수행해보면 된다.   


**예외(exception)**  
- 자바는 프로그램 실행 도중에 발생하는 오류를 예외라 부른다.   
- NullPointerException  
 - 참조 타입 변수를 잘못 사용하면 발생  
 - 참조 타입 변수가 null을 가지고 있을 경우, 참조 타입 변수는 사용 불가   
   -→→ 참조 타입 변수를 사용하는 것은 객체를 사용하는 것을 의미하는데 null이면 참조할 객체가 없는 것   
 ```java
 int[] intArray = null;
 intArray[0] = 10;     // NullPointerException  
 ```  

## String 타입   

- 자바는 문자열을 String 변수에 저장  
 ```java
 String str;
 str = "문자열";
 ```   
 ```java
 String name;
 name = "oasis";
 String hobby = "rock";  
 ```  

- 좀 더 정확히 말하면, 문자열을 String 변수에 저장하는 것이 아니라, **문자열은 String 객체로 생성되고 변수는 String 객체를 참조**한다.  
  - 일반적으로는 저장한다는 표현을 사용한다.   
- 자바는 문자열 리터럴이 동일하다면 String 객체를 공유하도록 되어 있다.   
 ```java
 String name1 = "bart";  
 String name2 = "bart";
 ```
  - name1과 name2는 동일한 String 객체를 참조   
- new 연산자를 사용해서 직접 String 객체를 생성시킬 수도 있다.  
 ```java
 String name1 = new String("bart");
 String name2 = new String("bart");  
 ```  
 - 위 경우에는 name1과 name2는 서로 다른 String 객체를 참조한다.   

- 동일한 객체이건 다른 객체이건 상관없이 문자열만을 비교할 때에는 String 객체의 `equals()` 메소드를 사용   
 ```java  
 boolean result = str1.equals(str2);   
 ```
 - str1은 원본, str2는 비교 문자열   

## 배열 타입   

- **같은 타입**의 데이터를 연속된 공간에 나열시키고, 각 데이터에 인덱스를 부여해 놓은 자료구조   
- 생성된 배열의 길이는 늘리거나 줄일 수 없다. 새로 만들어서 복사해야한다.   

**배열 선언**   
- 두 가지 형태  
 ```
 타입[] 변수;
 타입 변수[];  
 ```   

- 배열도 null 값을 넣을 수 있다. null을 가진 상태에서 변수[인덱스]로 값을 읽거나 저장하면 NullPointerException이 발생한다.   

**값 목록으로 배열 생성**  

```java
public class ArrayCreateByValueListExample1 {
    public static void main(String[] args) {
        int[] scores = { 83, 90, 87};

        System.out.println("scores[0] : " + scores[0]);
        System.out.println("scores[1] : " + scores[1]);
        System.out.println("scores[2] : " + scores[2]);

        int sum = 0;
        for(int i=0; i<3; i++) {
            sum += scores[i];
        }
        System.out.println("총합 : " + sum);
        double avg = (double) sum / 3;
        System.out.println("평균 : " + avg);
    }
}
```

- 배열 변수를 이미 선언한 후에 다른 실행문에서 중괄호를 사용한 배열 생성은 허용되지 않는다.   
```
타입[] 변수;
변수 = { 값0, 값1, 값2, ... , 값10}; // 컴파일 에러  
```

- 배열 변수를 미리 선언한 후, 값 목록들이 나중에 결정된다면 다음과 같이 new 연산자를 사용해 값 목록을 지정   
```java
String[] names = null;
names = new String[] { "bart", "spring", "lisa" };
```  
```java
int sum2 = add( new int[] {83, 90, 87});
```  

**new 연산자로 배열 생성**  

- 값의 목록을 가지고 있지 않지만, 향후 값들을 저장할 배열을 미리 만들고 싶다면 new 연산자로 배열 객체 생성이 가능하다.   
```java
int[] intArray = new int[5];
```
- new 연산자로 배열을 처음 생성할 경우, 배열은 자동적으로 기본값으로 초기화된다.   
- 배열의 초기값  
 ![초기값](http://image.slidesharecdn.com/chapter-01-140930125206-phpapp02/95/chapter-01-introduction-to-java-by-tushar-b-kute-19-638.jpg?cb%5Cu003d1412081739)

**배열 길이**  
- 배열 길이 구하기  
```
배열변수.length;
```
- length 필드는 읽기 전용 필드   
- for문을 사용해 배열 전체를 루핑할 때 매우 유용   
```java
for(int i=0; i<scores.length; i++) {
            sum += scores[i];
}
```
- 배열의 인덱스 범위는 0~(길이-1)이다. 인덱스를 초과해서 접근하면 ArrayIndexOutOfBoundsException이 발생   

**커맨드 라인 입력**   

- 메인 메소드에서 매개값인 String[] args의 존재 이유   
 - "java 클래스"로 프로그램을 실행하면 JVM은 길이가 0인 String 배열을 먼저 생성하고 main() 메소드를 호출할 때 매개값으로 전달   

```
java 클래스 문자열0 문자열1 문자열2 --- 문자열n-1 
```
- "java 클래스" 뒤에 공백으로 구분된 문자열 목록을 주고 실행하면, 문자열 목록으로 구성된 String[] 배열이 생성되고 main() 메소드 호출 시 매개값으로 전달   

```java
/**
 * Created by ox on 2016. 12. 26..
 */
public class MainStringArrayArgument {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("프로그램의 사용법");
            System.out.println("java MainStringArrayArgument num1 num2");
            System.exit(0);
        }

        String strNum1 = args[0];
        String strNum2 = args[1];

        int num1 = Integer.parseInt(strNum1);
        int num2 = Integer.parseInt(strNum2);

        int result = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + result);
    }
}
```

- IntelliJ IDEA의 Run-Edit Configurations-Program Arguments에 두 개의 값 입력하고 실행   
- [내가 이해가 되지 않았던 것](http://kin.naver.com/qna/detail.nhn?d1id=1&dirId=1040201&docId=66520377&qb=c3RyaW5nW10gYXJncyAg66ek6rCc67OA7IiY6rCAIO2VhOyalCDsl4bsnLzrqbQ=&enc=utf8&section=kin&rank=2&search_sort=0&spq=0)
 
**다차원 배열**   

```java
int[][] scores = new int[2][3];  
```
- 2행 3열 행렬   
- scores는 길이 2인 배열 A를 참조하고 배열 A의 scores[0]은 다시 길이 3인 배열 B를 참조한다.    
- scores[1]도 길이 3인 배열 C를 참조한다.   
```
scores.length    // 2(배열 A의 길이)  
scores[0].length // 3(배열 B의 길이)  
scores[1].length // 3(배열 C의 길이)  
```

**객체를 참조하는 배열**  

- 기본 타입 배열은 각 항목에 직접 값을 가지고 있지만, 참조 타입(클래스, 인터페이스) 배열은 각 항목에 객체의 번지를 가진다.  
  - 예) String은 클래스 타입 →→ String[] 배열은 각 항목에 문자열이 아닌 String 객체의 주소를 가진다.   
- 따라서 String[] 배열 항목 간에 문자열 비교는 `equals()` 메소드를 사용해야 한다.    
```java
public class ArrayReferenceObjectExample {
    public static void main(String[] args) {
        String[] strArray = new String[3];
        strArray[0] = "Java";
        strArray[1] = "Java";
        strArray[2] = new String("Java");

        System.out.println( strArray[0] == strArray[1]);        // true
        System.out.println( strArray[0] == strArray[2]);        // false
        System.out.println( strArray[0].equals(strArray[2]));   // true
    }
}
```

**배열 복사**  

- for문 이용  
```java
public class ArrayCopyByForExample {
    public static void main(String[] args) {
        int[] oldIntArray = {1, 2, 3};
        int[] newIntArray = new int[5];

        for(int i=0; i<oldIntArray.length; i++) {
            newIntArray[i] = oldIntArray[i];
        }

        for(int i=0; i<newIntArray.length; i++) {
            if(i != (newIntArray.length-1)) {
                System.out.print(newIntArray[i] + ", ");
            }
            else {
                System.out.print(newIntArray[i]);
            }
        }
    }
}
```
- `Systemarraycopy()` 메소드 사용     
```java
System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
```  
  - src 매개값: 원본 배열  
  - srcPos: 원본 배열에서 복사할 항목의 시작 인덱스  
  - dest: 새 배열  
  - destPos: 새 배열에서 붙여넣을 시작 인덱스  
  - length: 복사할 개수  

 ```java  
 public class ArrayCopyExample {
     public static void main(String[] args) {
         String[] oldStrArray = { "java", "array", "copy" };
         String[] newStrArray = new String[5]; 
 
         System.arraycopy( oldStrArray, 0, newStrArray, 0, oldStrArray.length);
 
         for(int i=0; i< newStrArray.length; i++) {
             System.out.print(newStrArray[i] + ", "); // java, array, copy, null, null
         }
     }
 }
 ```

- 참조 타입 배열일 경우, 배열 복사가 되면 복사되는 값이 객체이 번지이므로 **새 배열의 항목은 이전 배열의 항목이 참조하는 객체와 동일**  
 - 얕은 복사(shallow copy)라 한다. 반대로 **깊은 복사(deep copy)는 참조하는 객체도 별도로 생성**하는 것.  

**향상된 for문**  

- 반복 실행을 위해 카운터 변수와 증감식을 사용하지 않는다.  
- 배열 및 컬렉션 항목의 개수만큼 복사하고, 자동적으로 for문을 빠져나간다.  
```java
public class AdvancedForExample {
    public static void main(String[] args) {
        int[] scores = { 95, 71, 84, 93, 87 };

        int sum = 0;
        for (int score : scores ) {
            sum += score;
        }
        System.out.println("점수 총합 = " + sum);

        double avg = (double) sum / scores.length;
        System.out.println("점수 평균 = " + avg);
    }
}
```  

## 열거 타입  

- 한정된 값만을 갖는 데이터 타입  
- 몇 개의 열거 상수(enumeration constant) 중에서 하나의 상수를 저장하는 데이터 타입  

**열거 타입 선언**  

- 열거 타입을 선언하기 위해서는 열거 타입의 이름을 정하고 열거 타입 이름으로 소스 파일(.java)을 생성해야 한다.  
- 열거 타입 이름은 관례적으로 첫 문자를 대문자로하고 나머지는 소문자로 구성  
```
public enum 열거타입이름 { .... }  
```
- 열거 상수는 관례적으로 열거 상수는 모두 대문자로 작성한다.  
- 열거 상수가 여러 단어로 구성될 경우에는 단어 사이를 밑줄(_)로 연결하는 것이 관례  
```java
public enum LoginResult { LOGIN_SUCCESS, LOGIN_FAILED }  
```
- IntelliJ IDEA에서 <kbd>⌘</kbd> + <kbd>N</kbd> - 탭에서 'enum' 선택  
```java
public enum Week {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
```

**열거 타입 변수**  

- 열거 타입도 데이터 타입이므로 변수를 선언하고 사용해야 한다.  
```java
Week today;
Week reservationDay;
```

- 열거 상수는 열거타입.열거상수로 사용된다.  
```java
Week today = Week.SUNDAY;
```
- null 값도 저장 가능하다.   
- 열거 상수도 객체이다.  
- 열거 타입 변수 today는 스택 영역에 생성되고, 저장되는 값은 Week.SUNDAY 열거 상수가 참조하는 객체의 번지이다.  
```java
today == Week.SUNDAY // true  
```

- 자바는 컴퓨터의 날짜 요일, 시간을 프로그램에서 사용할 수 있도록 `Date`, `Calendar`, `LocalDayeTime` 등의 클래스를 제공한다.   
```java
Calendar now = Calendar.getInstance();

int year = now.get(Calendar.YEAR);  
int month = now.get(Calendar.MONTH) + 1;
int day = now.get(Calendar.DAY_OF_MONTH);
int week = now.get(Calendar.DAY_OF_WEEK);  
int hour = now.get(Calendar.HOUR);
int minute = now.get(Calendar.MINUTE);
int second = now.get(Calendar.SECOND);  
```

```java
/**
 * Created by ox on 2016. 12. 27..
 */
import java.util.Calendar;

public class EnumWeekExample {
    public static void main(String[] args) {
        Week today = null;

        Calendar cal = Calendar.getInstance();
        int week = cal.get(Calendar.DAY_OF_WEEK);

        switch(week) {
            case 1:
                today = Week.SUNDAY; break;
            case 2:
                today = Week.MONDAY; break;
            case 3:
                today = Week.TUESDAY; break;
            case 4:
                today = Week.WEDNESDAY; break;
            case 5:
                today = Week.THURSDAY; break;
            case 6:
                today = Week.FRIDAY; break;
            case 7:
                today = Week.SATURDAY; break;
        }

        System.out.println("오늘 요일: " + today);

        if(today == Week.SUNDAY) {
            System.out.println("일요일에는 축구를 합니다.");
        } else {
            System.out.println("열심히 자바 공부합니다.");
        }
    }
}
```

**열거 객체의 메소드**  

| 리턴 타입 | 메소드(매개 변수) | 설명 |  
| --- | --- | --- |  
| String | name() | 열거 객체의 문자열을 리턴 |  
| int | ordinal() | 열거 객체의 순번(0부터 시작)을 리턴 |  
| int | compareTo() | 열거 객체를 비교해서 순번 차이를 리턴 |  
| 열거 타입 | valueOf(String name) | 주어진 문자열의 열거 객체를 리턴 |  
| 열거 배열 | values() | 모든 열거 객체들을 배열로 리턴 |  


**name() 메소드**  

- 열거 객체가 가지고 있는 문자열을 리턴  
```java
Week today = Week.SUNDAY;
String name = today.name(); // return SUNDAY
```

**ordinal() 메소드**  
- 전체 열거 객체 중 몇 번째 열거 객체인지 알려준다.  
```java
Week today = Week.SUNDAY;
int ordinal = today.ordinal(); // return 6
```

**compareTo() 메소드**  
- 매개값으로 주어진 열거 객체를 기준으로 전후로 몇 번째 위치하는지를 비교  
- 만약 열거 객체가 매개값의 열거 객체보다 순번이 빠르면 음수, 순번이 늦다면 양수가 리턴.  
```java
Week day1 = Week.MONDAY;
Week day2 = Week.WEDNESDAY;
int result1 = day1.compareTo(day2);  // -2  
int result2 = day2.compareTo(day1);  // 1
```

**valueOf() 메소드**  
- 매개값으로 주어지는 문자열과 동일한 문자열을 가지는 열거 객체를 리턴  
- 다음 코드에서 weekDay 변수는 Week.SATURDAY 열거 객체를 참조하게 된다.  
```java
Week weekDay = Week.valueOf("SATURDAY");  
```

**values() 메소드**  
- 열거 타입의 모든 열거 객체들을 배열로 만들어서 리턴한다.  
```java
Week[] days = Week.values();
for(Week day : days) {
    System.out.println(day);
```

## 확인문제  

1. 4 (null로 초기화할 수 있다.)
2. 3 (직접할 필요없이 자동으로 JVM이 자동으로 처리한다.)  
3. 2 (equals() 메소드를 사용한다.) 
4. 2 (new로 선언해야 한다.)  
5. 3 (false이다.)  
6. 3, 5
7. 

```java
public class Exercise07 {
    public static void main(String[] args) {
        int max = 0;
        int[] array = {1, 5, 3, 8, 2 };

        for(int i=0; i<array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("max: " + max);
    }
}
```  
8. 

```java
public class Exercise08 {
    public static void main(String[] args) {
        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };

        int sum = 0;
        double avg = 0.0;

        int count = 0;

        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array[i].length; j++) {
                sum += array[i][j];
                count++;
            }
        }
        avg = sum / count;
        System.out.println("sum: " + sum);
        System.out.println("avg: " + avg);
    }
}
```  
9. 


```java
import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        boolean run = true;
        int studentNum = 0;
        int[] scores = null;
        Scanner scanner = new Scanner(System.in);

        while(run) {
            System.out.println("--------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("--------------------------------------------");
            System.out.print("선택> ");

            int selectNo = scanner.nextInt();

            if(selectNo == 1) {
                System.out.print("학생수> ");
                studentNum = scanner.nextInt();
            } else if(selectNo == 2) {
                scores = new int[studentNum];
                for(int i=0; i<studentNum; i++) {
                    System.out.print("scores[" + i + "]> ");
                    scores[i] = scanner.nextInt();
                }
            } else if(selectNo == 3) {
                for(int i=0; i<studentNum; i++) {
                    System.out.println("scores[" + i + "]: " + scores[i]);
                }

            } else if(selectNo == 4) {
                int sum =0;
                double avg = 0;
                int max = 0;

                for(int i=0; i<studentNum; i++) {
                    sum += scores[i];
                    if(scores[i] > max) {
                        max = scores[i];
                    }
                }
                avg = sum / studentNum;

                System.out.println("최고 점수: " + max);
                System.out.println("평균 점수: " + avg);

            } else if(selectNo == 5) {
                run = false;
            }
        }

        System.out.println("프로그램 종료");
    }
}
```