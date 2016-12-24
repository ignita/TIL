# 조건문과 반복문  

## 조건문  

**if문, if-else문**  
- 중괄호 블록을 생략하지 않고 작성하는 것을 추천  
 - 가독성과 버그 발생의 원인을 없앨 수 있다.   

```java
public class IfExample {
    public static void main(String[] args) {
        int score = 93;

        if (score >= 90) {
            System.out.println("점수가 90보다 큽니다");
            System.out.println("등급은 A입니다");
        } else if (score < 90) {
            System.out.println("점수가 90보다 작습니다");
            System.out.println("등급은 B입니다");
        }
    }
}
```  

**Math.random() 메소드**   
 - 0.0과 1 사이에 속하는 double 타입 난수 하나를 리턴   

```
0.0 <= Math.random() < 1.0
0.0*10 <= Math.random()*10 < 1.0*10  
(int)0.0 <= (int)(Math.random()*10) < (int) 10.0  
0+1 <= (int)(Math.random()*10) + 1 < 10+1  
```  
```java
int num = (int)(Math.random() * n) + start;  
// start부터 시작하는 n개의 정수 중에서 임의의 정수 하나를 얻기 위한 연산식  
```  

**switch문**  

- char 타입 변수도 switch문에 사용될 수 있다.   
- 자바 7부터는 String 타입의 변수도 올 수 있다.  
```java
public class SwitchStringExample {
    public static void main(String[] args) {
        String position = "과장";

        switch(position) {
            case "부장":
                System.out.println("700만원");
                break;
            case "과장":
                System.out.println("500만원");
                break;
            default:
                System.out.println("300만원");
        }
    }
}
```   

## 반복문   

**for문**   

```java
public class ForSumFrom1To100Example {
    public static void main(String[] args) {
        int sum = 0;

        int i = 0;
        for(i=1; i<=100; i++) {
            sum += i;
        }

        System.out.println("1-" + (i-1) + "합: " + sum);
    }
}
```   

**while문**  

```java
int keyCode = System.in.read();
```
- 키보드로부터 입력된 키 코드를 리턴하는 코드    
- [키코드 알아보기](http://keycode.info)   

- 예제: 1, 2를 입력했을 때 속도를 증속, 감소시키고, 3을 입력하면 프로그램을 종료   
 - 1은 49, 2는 50, 3은 51, Enter키는 13번과 10번   
```java
/**
 * Created by ox on 2016. 12. 24..
 */
public class WhileKeyControlExample {
    public static void main(String[] args) throws Exception {
        boolean run = true;
        int speed = 0;
        int keyCode = 0;

        while(run) {
            if(keyCode!=13 && keyCode!=10) {
                System.out.println("----------------------------");
                System.out.println("1.증속 | 2.감속 | 3.중지");
                System.out.println("----------------------------");
                System.out.print("선택: ");
            }

            keyCode = System.in.read();

            if(keyCode == 49) {
                speed++;
                System.out.println("현재 속도=" + speed);
            } else if (keyCode == 50) {
                speed--;
                System.out.println("현재 속도=" + speed);
            } else if (keyCode == 51) {
                run = false;
            }
        }

        System.out.println("프로그램 종료");
    }
}
```   

**do-while문**   

- 콘솔에서 입력한 문자열을 읽는 방법   
```java
Scanner scanner = new Scanner(System.in);    // Scanner 객체 생성  
String inputString = scanner.nextLine();     // nextLine() 메소드 호출  
```

```java
import java.util.Scanner;

public class DoWhileExample {
    public static void main(String[] args) {
        System.out.println("메시지를 입력하세요");
        System.out.println("프로그램을 종료하려면 q를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        String inputString;

        do {
            System.out.print(">");
            inputString = scanner.nextLine();
            System.out.println(inputString);
        } while( ! inputString.equals("q") );

        System.out.println();
        System.out.println("프로그램 종료");
    }
}
```

**break문**  
- 반복문을 실행 중지할 때 사용(switch문 포함)   
- 반복문이 중첩되어 있을 경우에 break문은 가장 가까운 반복문만 종룧고 바깥쪽은 종료시키지 않는다.    
 - 종료시키려면 바깥쪽 반복문에 이름(라벨)을 붙이고, "break 이름;"을 사용하면 된다.   
```java
public class BreakOutterExample {
    public static void main(String[] args) throws Exception {
        Outter: for(char upper='A'; upper<='Z'; upper++) {
            for(char lower='a'; lower<='z'; lower++) {
                System.out.println(upper + "-" + lower);
                if(lower=='g') {
                    break Outter;
                }
            }
        }
        System.out.println("프로그램 실행 종료");
    }
}
```   

**continue문**   

- for문의 증감식, while문, do-while문의 조건식으로 이동     

## 확인문제   

1. 조건문: if, switch, 반복문: for, while, do-while  
2. 2
3. 

```java
public class Exercise03 {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        for(i=1; i<=100; i++){
            if(i%3 == 0){
                sum += i;
            }
        }
        System.out.println("3의 배수의 합: " + sum);
    }
}
```
4. 

```java
public class Exercise04 {
    public static void main(String[] args) {
        while(true)
        {
            int dice1 = (int)(Math.random()*6) + 1;
            int dice2 = (int)(Math.random()*6) + 1;
            int spotsSum = dice1 + dice2;
            if(spotsSum == 5)
                break;
            System.out.println("("+ dice1 + "," + dice2 + ")");
        }
    }
}
```  
5. 

```java
public class Exercise05 {
    public static void main(String[] args) {
        for(int i=1; i<=10; i++) {
            for(int j=1; j<=10; j++) {
                int equation = 4*i + 5*j;
                    if(equation == 60){
                        System.out.println("(" + i + "," + j + ")");
                    }
            }
        }
    }
}
```   
6.   

```java
public class Exercise06 {
    public static void main(String[] args) {
        for(int i=0; i<6; i++) {
            for(int j=0; j<i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
```  
7.   
```java
import java.util.Scanner;

public class Exercise07 {
    public static void main(String[] args) {
        boolean run = true;

        int balance = 0;

        Scanner scanner = new Scanner(System.in);

        while(run) {
            System.out.println("----------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("----------------------------");
            System.out.print("선택> ");

            int select = scanner.nextInt();

            switch(select) {
                case 1:
                    System.out.print("예금액>");
                    balance += scanner.nextInt();
                    break;
                case 2:
                    System.out.print("출금액>");
                    balance -= scanner.nextInt();
                    break;
                case 3:
                    System.out.print("잔고>");
                    System.out.println(balance);
                    break;
                case 4:
                    run = false;
            }
        }
        System.out.println("프로그램 종료");
    }
}
```