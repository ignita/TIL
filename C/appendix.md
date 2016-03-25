# Appendix

## 수학 관련 함수들  
- math.h에 선언되어 있다.  
 - [math.h 함수](https://ko.wikipedia.org/wiki/Math.h)   

- stdlib.h  
 - `int abs(int x);`: x의 절대값 반환  
 - `long labs(long x);`: x의 절대값 반환  

## 가변인자 함수에 대한 이해  

### printf 함수와 scanf 함수의 사용 방법을 생각해 보면  

- 공통점  
 - 첫 번째 전달인자인 문자열에 존재하는 서식문자의 수만큼 전달인자의 수도 증가  

- `Sum`의 첫 번째 전달인자는 이후에 전달되는 인자의 갯수정보이다.  
 - `num = Sum(2, 1, 2);`   
 - `num = Sum(3, 1, 2, 3);`    
 - `num = Sum(4, 1, 2, 3, 4);`    

- `Sum`과 같은 함수를 가리켜 '가변인자 함수'라고 한다.  
 - stdarg.h에 선언되어 있다.   

### 가변인자 매개변수의 선언방법   

- 매개변수 선ㅇ너을 통해 함수호출 시 전달되어야 할 인자의 수와 자료형이 결정  
 - 가변인자 함수는 호출 될 때 비로소 인자의 수가 결정  
 - 예)  
 ```c
 int Sum(int n, ...);
 ```

### 전달된 인자들을 추출  

- 단계 1: 가변인자를 가리킬 수 있는 참조자를 선언  
- 단계 2: 참조자가 가변인자를 실제로 참조할 수 있도록 한다.  
- 단계 3: 참조자를 통해 전달된 정보를 추출  
- 단계 4: 참조자가 더 이상 가변인자를 가리키지 않도록 해제  

 - 단계 1: va_list
 - 단계 2: va_start
 - 단계 3: va_arg
 - 단계 4: va_end  

```c
#include <stdio.h>
#include <stdarg.h>
int Sum(int n, ...);

int main(void)
{
    printf("1+2=%d \n", Sum(2, 1, 2));
    printf("1+2+3=%d \n", Sum(3, 1, 2, 3));
    printf("1+2+3+4=%d \n", Sum(4, 1, 2, 3, 4));
    return 0;
}

int Sum(int n, ...)
{
    int sum = 0;
    int i;
    va_list vlist;      // 단계 1: 가변인자의 참조자 선언

    va_start(vlist, n); // 단계 2: 참조 대상과 범위 지정
    for(i=0; i<n; i++)
        sum += va_arg(vlist, int);      // 단계 3: 값의 추출

    va_end(vlist);      // 단계 4: 해제
    return sum;
}
```
```
1+2=3 
1+2+3=6 
1+2+3+4=10 
```
