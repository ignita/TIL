# 메모리의 동적 할당  

- 전역변수와 지역변수뿐만 아니라 프로그램을 구현하다보면 다른 유형의 변수를 필요로 하게 된다.  

## 전역변수와 지역변수로 해결이 되지 않는 상황  

```c
#include <stdio.h>

char * ReadUserName(void)
{
    char name[30];
    printf("What's your name? ");
    gets(name);
    return name;    // 무엇을 반환하는가?
}

int main(void)
{
    char * name1;
    char * name2;
    name1 = ReadUserName();
    printf("name1: %s \n", name1);
    name2 = ReadUserName();
    printf("name2: %s \n", name2);
    return 0;
}
```
- `ReadUserName` 함수 내에 지역적으로 선언된 배열의 주소 값을 반환하면 함수를 빠져나오면서 변수가 소멸되기 때문에 정상적인 값이 안 나오게 된다.   

```c
#include <stdio.h>
char name[30];

char * ReadUserName(void)
{
    printf("What's your name? ");
    gets(name);
    return name;
}

int main(void)
{
    char * name1;
    char * name2;
    name1 = ReadUserName();
    printf("name1: %s \n", name1);
    name2 = ReadUserName();
    printf("name2: %s \n", name2);

    printf("name1: %s \n", name1);
    printf("name2: %s \n", name2);
    return 0;
}
```
- 위와 같이 하나의 전역변수를 이용하면 이 전역변수를 덮어쓰기 때문에 함수호출을 통해 얻게 된 정보가 유지되지 않는다.  
- "함수가 매번 호출될 때마다 새롭게 할당되고 함수를 빠져나가도 유지가 되는 유형의 변수"가 필요하다.   
 - malloc, free 라는 이름의 함수를 통해 힙 영역에 할당하고 소멸이 가능  

## 힙 영역의 메모리 공간 할당과 해제: `malloc`과 `free` 함수  
- malloc: 힙 영역으로의 메모리 공간 할당  
- free: 힙 영역에 할당된 메모리 공간 해제  

```c
#include <stdlib.h>
void * malloc(size_t size);
void free(void * ptr);
```
- malloc 함수는 성공 시 할당된 메모리의 주소 값, 실패 시 NULL 반환  
- 힙 영역을 흔히 '프로그래머가 관리하는 메모리 공간'이라고 한다.  
 - `malloc` 함수 호출로 할당된 메모리 공간은 프로그래머가 직접 `free` 함수의 호출을 통해 해제하지 않으면 계속 남아있기 때문  
- `malloc`함수는 주소 값을 반환하기 때문에 포인터를 이용해 메모리 공간에 접근하는 수밖에 없다.  

## malloc 함수의 반환형이 void형 포인터인 이유와 힙 영역으로의 접근  
- void형 포인터인 이유  
 - `void * ptr1 = malloc(sizeof(int));` 라고 전달하면 결국엔 `void * ptr1 = malloc(4);`처럼 숫자만 전달된다. 그렇게 되면 어떤 자료형의 변수인지 `malloc` 함수가 정할 수 없기 때문에 void형 포인터를 사용한다.  
 - 따라서 다음과 같이 void형으로 반환되는 주소 값을 적절히 형 변환해서 할당된 메모리 공간에 접근해야 한다.  
 ```c
 int * ptr1 = (int *)malloc(sizeof(int));
 ```

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int * ptr1 = (int *)malloc(sizeof(int));
    int * ptr2 = (int *)malloc(sizeof(int)*7);
    int i;

    *ptr1 = 20;
    for(i=0; i<7; i++)
        ptr2[i] = i+1;

    printf("%d \n", *ptr1);
    for(i=0; i<7; i++)
        printf("%d ", ptr2[i]);

    free(ptr1);
    free(ptr2);
    return 0;
}
```
```
20
1 2 3 4 5 6 7
```
- `malloc` 함수는 메모리 공간의 할당에 실패할 경우 NULL을 반환하기 때문에 할당 성공여부를 확인하고자 하면 다음과 같이 코드를 작성해야 한다.  
```c
int * ptr = (int *)malloc(sizeof(int));
if(ptr==NULL)
{
    // 메모리 할당 실패에 따른 오류의 처리   
}
```
- `malloc` 함수의 호출을 통한 멤뢰 공간의 할당을 가리켜 **'동적 할당(dynamic allocation)'**이라 한다. 할당되는 메모리의 크기를 컴파일러가 정하지 않고, 프로그램의 실행 중간에 호출되는 `malloc` 함수가 결정하기 때문이다.  


## free 함수를 호출하지 않으면 프로그램 종료 후에도 메모리가 남는가?   

그렇지 않다! 프로그램이 종료되면 운영체제에 의해 모든 메모리 공간이 전부 해제가 된다.  
→ 습관적으로라도 `malloc` 함수의 호출 횟수만큼 `free` 함수를 호출하는 것이 좋다.(예제처럼 간단한 프로그램만 작성하는 것이 아니기 때문이다.)   

## 문자열을 반환하는 함수를 정의하는 문제의 해결    
```c
#include <stdio.h>
#include <stdlib.h>

char * ReadUserName(void)
{
    char * name = (char *)malloc(sizeof(char)*30);
    printf("What's your name? ");
    gets(name);
    return name;
}

int main(void)
{
    char * name1;
    char * name2;
    name1 = ReadUserName();
    printf("name1: %s \n", name1);
    name2 = ReadUserName();
    printf("name2: %s \n", name2);

    printf("again name1: %s \n", name1);
    printf("again name2: %s \n", name2);
    free(name1);
    free(name2);
    return 0;
}
```
- 힙 영역에 메모리 공간을 할당한다. `free` 함수가 호출되지 않으면 계속해서 존재하게 된다.   


## malloc 함수의 사촌 뻘 되는 calloc 함수  

```c
#include <stdlib.h>
void * calloc(size_t et_count, size_t let_size);
```
- 성공 시 할당된 메모리의 주소 값, 실패 시 NULL 반환    
- 첫 번째 인자: 할당할 블록의 갯수 정보  
- 두 번째 인자: 블록 하나당 바이트 크기 정보  
- 예) 4바이트 크기의 블록(elt_size) 30개를(elt_count) 힙 영역에 할당해 주세요.     
- `malloc` 함수는 할당된 메모리 공간을 별도의 값으로 초기화 x - 쓰레기 값으로 채워짐  
- `calloc`은 할당된 메모리 공간의 모든 비트를 0으로 초기화  

## 힙에 할당된 메모리 공간 확장 시 호출하는 realloc 함수  

```c
#include <stdlib.h>
void * realloc(void * ptr, size_t size);
```
- 성공 시 새로 할당된 메모리의 주소 값, 실패 시 NULL 반환  
- 첫 번째 인자: 확장하고자 하는 힙 메모리의 시작 주소 값 전달  
- 두 번째 인자: 확장하고자 하는 메모리의 전체 크기를 전달  
- ptr이 가리키는 메모리의 크기를 size 크기로 조절해줘(늘려줘)   

```c
int main(void)
{
    int * arr = (int *)malloc(sizeof(int)*3);
    ....
    arr = (int *)realloc(arr, sizeof(int)*5);
}
```
- 길이가 3인 int형 배열 arr을 길이가 5인 int형 배열로 확장   
- 위 코드의 실행결과는 다음과 같이 두 가지로 구분  
 - `malloc` 함수가 반환한 주소 값과 `realloc` 함수가 반환한 주소 값이 같은 경우  
 - `malloc` 함수가 반환한 주소 값과 `realloc` 함수가 반환한 주소 값이 다른 경우    
 - 전자는 기존에 할당된 메모리 공간에 뒤를 이어서 확장할 영역이 넉넉할 경우, 넉넉하지 않은 경우는 힙의 다른 위치에 새로이 할당해서 이전 배열에 저장된 값을 복사하기도 한다.   






