# 파일의 분할과 헤더파일 디자인  

## 파일의 분할  
- 프로그램의 크기가 커지면 관리가 어려워지는 문제  
 - 여러 개의 파일을 만들어 서로 연관 있는 함수와 변수들을 구분해 담는다.   
- 파일을 여러 개로 나누었을 때 변수와 함수가 외부에 선언되었다는 extern 키워드를 사용해야 한다.  
 - `extern int num;`  

## 다른 파일에 접근하지 못하게 하기: static  

- 전역변수의 static 선언은 외부 파일에서 접근을 허용하지 않는다는 의미이다.   

## 헤더파일의 디자인고 활용  

### #include 지시자의 의미   

`#include "header1.h"`   
- 이 문장의 위치에다 header1.h에 저장된 내용을 가져다 놓으세요 라는 의미  

### 헤더파일을 include 하는 두 가지 방법  

- `#include <헤더파일 이름>`: C의 표준 헤더파일을 포함하는 경우(stdio.h, stdlib.h, string.h등)   
- `#include "헤더파일 이름"`: 프로그래머가 정의한 헤더파일 포함, 디렉터리 경로 입력 가능  
 - 절대경로보다 상대경로를 사용하는 것이 좋다.  

### 구조체의 정의는 어디에 둬야할까?   

```c
// intdiv.c
typedef struct div
{
    int quotient;       // 몫
    int remainder;      // 나머지
} Div;

Div IntDiv(int num1, int num2)
{
    Div dval;
    dval.quotient = num1 / num2;
    dval.remainder = num1 % num2;
    return dval;
}
```
```c
// main.c
#include <stdio.h>

typedef struct div
{
    int quotient;       // 몫
    int remainder;      // 나머지
} Div;

extern Div IntDiv(int num1, int num2);

int main(void)
{
    Div val = IntDiv(5, 2);
    printf("몫: %d \n", val.quotient);
    printf("나머지: %d \n", val.remainder);
    return 0;
}
```
- 구조체 Div의 선언 및 정의가 두 번씩이나 삽입됨.   
 - 컴파일러는 파일 단위로 컴파일하기 때문(다른 파일의 정보를 참조하여 컴파일 x)  
 - 헤더파일을 선언해서 Div의 선언 및 정의가 프로그램 내에서 하나만 존재하도록 개선 가능  
 ```c
 // stdiv.h
 typedef struct div
 {
     int quotient;       // 몫
     int remainder;      // 나머지
 } Div;
 ```  
 ```c
 // intdiv2.h
 #include "stdiv.h"

 Div IntDiv(int num1, int num2)
 {
     Div dval;
     dval.quotient = num1/num2;
     dval.remainder = num1 % num2;
     return dval;
 }
 ```
 ```c
 // main.c
 #include <stdio.h>
 #include "stdiv.h"

 extern Div IntDiv(int num1, int num2);

 int main(void)
 {
     Div val = IntDiv(5, 2);
     printf("몫: %d \n", val.quotient);
     printf("나머지: %d \n", val.remainder);
     return 0;
 }
 ```
- 구조체의 선언 및 정의는 헤더파일에 삽입하는 것이 좋다.  


### 헤더파일의 중복삽입 문제   
- `#ifndef ~ #endif`를 이용  

 

 