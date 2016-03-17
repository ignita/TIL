# 입출력 이외의 문자열 관련 함수  

헤더파일 **string.h**에 선언된 문자열 관련 함수들  

## 문자열의 길이를 반환하는 함수: strlen  
```c
#include <string.h>
size_t strlen(const char * s);
```
 → 전달된 문자열의 길이를 반환하되, 널 문자는 길이에 포함하지 않는다.  

```c
typedef unsigned int size_t;
```  
unsigned int의 선언을 size_t로 대신할 수 있다. 라는 뜻. 나중에 typedef를 공부한 후 다시 봐야겠다. 그래서 다음 두 선언은 동일하다.  
```c
size_t len;
unsigned int len;
```

```c
#include <stdio.h>
#include <string.h>

void RemoveBSN(char str[])
{
    int len = strlen(str);
    str[len-1] = 0;
}

int main(void)
{
    char str[100];
    printf("문자열 입력: ");
    fgets(str, sizeof(str), stdin);
    printf("길이: %d, 내용: %s \n", strlen(str), str);

    RemoveBSN(str);
    printf("길이: %d, 내용: %s \n", strlen(str), str);
    return 0;
}
```
`RemoveBSN`함수가 문자열의 길이를 계산한 후 \n값이 들어 있는 곳에 0값을 너허서 \n을 문자열에서 제거한다.   

## 문자열을 복사하는 함수들: strcpy, strncpy  

```c
#include <string.h>
char * strcpy(char * dest, const char * src);
char * strncpy(char * dest, const char * src, size_t n);  
```
 → 복사된 문자열의 주소 값 반환  

```c
int main(void)
{
    char str1[30] = "Simple String";
    char str2[30];
    strcpy(str2, str1); // str1의 문자를 str2에 복사
}
```
```c
int main(void)
{
    char str1[30] = "Simple String";
    char str2[30];
    strncpy(str2, str1, sizeof(str2));
}
```

## 문자열을 덧붙이는 함수들: strcat, strncat  
```c
#int main(void)
{
    char str1[30] = "First~";
    char str2[30] = "Second";
    strcat(str1, str2);     // str1의 문자열 뒤에 str2를 복사
}
```
널 문자가 저장된 위치에서부터 붙여넣어진다.  
다음 문장은 str2의 문자열 중 최대 8개를 str1에 덧붙여라는 뜻인데 자동으로 맨 끝에 널 문자를 삽입해 준다.  
```c
strncat(str1, str2, 8);
```  

## 문자열을 비교하는 함수들: strcmp, strncmp  

```c
#include <string.h>
int strcmp(const char * s1, const char * s2);
int strncmp(const char * s1, const char * s2, size_t n);
```
 → 두 문자열의 내용이 같으면 0, 같지 않으면 0이 아닌 값 반환  
- `strncmp`는 세 번째 인자로 전달된 수의 크기만큼만 문자를 비교한다.  
- s1이 더 크면 0보다 큰 값을 반환  
- s2가 더 크면 0보다 작은 값 반환  
- s1과 s2의 내용이 모두 같으면 0 반환  
- 문자열의 크고 작음은 아스키 코드 값을 기준으로 결정  

```c
#include <stdio.h>
#include <string.h>

int main(void)
{
    char str1[20];
    char str2[20];
    printf("문자열 입력 1: ");
    scanf("%s", str1);
    printf("문자열 입력 2: ");
    scanf("%s", str2);

    if(!strcmp(str1, str2))
    {
        puts("두 문자열은 완벽히 동일합니다. ");
    }
    else
    {
        puts("두 문자열은 동일하지 않습니다.");

        if(!strncmp(str1, str2, 3))
            puts("그러나 앞 세 글자는 동일합니다.");
    }
    return 0;
}
```

## 그 이외의 변환 함수들  
헤더 파일 **stdlib.h** 에 선언된 함수들  
```c
int atoi(const char * str);    // 문자열의 내용을 int형으로 변환  
long atop(const char * str);   // 문자열의 내용을 long형으로 변환   
double atof(const char * str); // 문자열의 내용을 double형으로 변환  
```  

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    char str[20];
    printf("정수 입력: ");
    scanf("%s", str);
    printf("%d \n", atoi(str));

    printf("실수 입력: ");
    scanf("%s", str);
    printf("%g \n", atof(str));
    return 0;
}
```