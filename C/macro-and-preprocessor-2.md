# 매크로와 선행처리기 2  

## 조건부 컴파일(Conditional Compilation)을 위한 매크로   

### #if... #endif: 참이라면  

```c
#include <stdio.h>
#define ADD     1
#define MIN     0

int main(void)
{
    int num1, num2;
    printf("두 개의 정수 입력: ");
    scanf("%d %d", &num1, &num2);


#if ADD     // ADD가 '참'이라면
    printf("%d + %d = %d \n", num1, num2, num1+num2);
#endif

#if MIN     // MIN이 '참'이라면
    printf("%d - %d = %d \n", num1, num2, num1-num2);
#endif

    return 0;
}
```
- ADD는 매크로로 1이라 정해줬기 때문에 `printf` 함수가 실행이 된다.  


### #ifdef... #endif: 정의되었다면  
```c
#include <stdio.h>
// #define ADD  1
#define MIN 0

int main(void)
{
    int num1, num2;
    printf("두 개의 정수 입력: ");
    scanf("%d %d", &num1, &num2);


#ifdef ADD          // 매크로 ADD가 정의되었다면
    printf("%d + %d = %d \n", num1, num2, num1+num2);
#endif

#ifdef MIN          // 매크로 MIN이 정의되었다면
    printf("%d - %d = %d \n", num1, num2, num1-num2);
#endif

    return 0;
}
```
- MIN이 정의되었기 때문에 `#endif` 사이에 있는 문장이 삽입된다.(빼기 연산)  
- 매크로의 값은 중요하지 않기 때문에 생략 가능하다.  
```c
#define ADD
#define MIN
```
- 소스코드에 있는 ADD와 MIN은 선행처리 과정에서 공백으로 대체가 된다.  

### #ifndef... #endif: 정의되지 않았다면  
- n은 not을 의미한다.   
- 헤더파일의 중복포함을 막기 위해 주로 사용된다.   

### #else의 삽입: #if, #ifdef, #ifndef에 해당  

```c
#include <stdio.h>
#define HIT_NUM     5

int main(void)
{
#if HIT_NUM == 5
    puts("매크로 상수 HIT_NUM은 현재 5입니다.");
#else
    puts("매크로 상수 HIT_NUM은 현재 5가 아닙니다.");
#endif

    return 0;
}
```

### #elif의 삽입: #if에만 해당  
```c
#include <stdio.h>
#define HIT_NUM  7

int main(void)
{
#if HIT_NUM == 5
    puts("매크로 상수 HIT_NUM은 현재 5입니다.");
#elif HIT_NUM == 6
    puts("매크로 상수 HIT_NUM은 현재 6입니다.");
#elif HIT_NUM == 7
    puts("매크로 상수 HIT_NUM은 현재 7입니다.");
#else
    puts("매크로 상수 HIT_NUM은 5, 6, 7은 확실히 아닙니다.");
#endif

    return 0;
}
```  

## 매개변수의 결합과 문자열화   

### 문자열 내에서는 매크로의 매개변수 치환이 발생하지 않는다.  

```c
#define STRING_JOB(A, B)    "A의 직업은 B입니다."
```
- 위와 같이 정의해도 `STRING_JOB(이동춘, 나무꾼)`이 "이동춘의 직업은 나무꾼입니다."라는 결과가 나오지 않는다.  
- 문자열 안에서는 매크로의 매개변수 치환이 발생되지 않는다.  

### 문자열 내에서 매크로의 매개변수 치환이 발생하게 만들기: # 연산자  

```c
#define STR(ABC)    #ABC
```
- 매개변수 ABC에 전달되는 인자를 문자열 "ABC"로 치환하라.   
- 문자열을 나란히 선언하면, 하나의 문자열로 간주  
```c
char * str = "ABC" "DEF";
```
- 위 문장은 다음 선언과 동일하다.  
```c
char * str = "ABCDEF"
```
- 그래서 다음과 같은 구성도 가능하다.  
```c
char * str = STR(12) STR(34);
```
```c
char * str = "12" "34";
char * str = "1234";
```   
```c
#include <stdio.h>
#define STRING_JOB(A, B)        #A "의 직업은 " #B "입니다."

int main(void)
{
    printf("%s \n", STRING_JOB(이동춘, 나무꾼));
    printf("%s \n", STRING_JOB(한상순, 사냥꾼));
    return 0;
}
```
```
이동춘의 직업은 나무꾼입니다. 
한상순의 직업은 사냥꾼입니다. 
```
- `STRING_JOB(이동춘, 나무꾼)`은 선행처리기에 의해 다음과 같이 치환된다.  
```
"이동춘""의 직업은""나무꾼""입니다."   
```
- 위는 4개의 문자열이 나란히 선언된 형태이니 다음과 같다.   
```
이동춘의 직업은 나무꾼입니다.
```

### 특별한 매크로 연산자 없이 단순히 연결하는 것은 불가능하다.   
```c
#define STNUM(Y, S, P)    YSP
```
- 위 선언은 다음과 같이 치환되어 에러가 발생한다.   
```c
printf("학번: %d \n", YSP);
```
- 다음 선언도 에러가 발생한다.   
```c
#define STNUM(Y, S, P)   Y S P
```
```c
printf("학번: %d \n", 10 65 175);
```

### 필요한 형태대로 단순하게 결합하기: 매크로 ## 연산자  
- `##` 연산자는 매크로 함수의 전달인자를 다른 대상(전달인자, 숫자, 문자, 문자열등)과 이어줄 때 사용  
```c
#define CON(UPP, LOW)   UPP ## 00 ## LOW
```
```c
int num = CON(22, 77);
```
- 위 문장은 선행처리기에 의해 컴파일 이전에 다음과 같이 변환된다.   
```c
int num = 220077;
```


