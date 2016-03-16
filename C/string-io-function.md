# 문자와 문자열 관련 함수  

## 문자열 단위 입출력 함수  

문자열 입력 함수는 `scanf`함수와는 다르게 공백을 포함하는 문자열도 입력받을 수 있다.  

### 문자열 출력 함수: puts, puts  
모니터로 하나의 문자열을 출력할 때 일반적으로 사용하는 두 함수는 다음과 같다.  

```c
#include <stdio.h>
int puts(const char * s);
int fputs(const char * s, FILE * stream);
```  
→ 성공 시 음수가 아닌 값을, 실패 시 EOF 반환  

`puts` 함수는 출력의 대상이 stdout으로 결정되어 있지만 `fputs` 함수는 두 번째 인자를 통해 출력의 대상을 결정할 수 있다.  

```c
#include <stdio.h>

int main(void)
{
    char * str = "Simple String";

    printf("1. puts test ------ \n");
    puts(str);
    puts("So Simple String");

    printf("2. fputs test ----- \n");
    fputs(str, stdout); printf("\n");
    fputs("So Simple String", stdout); printf("\n");


    printf("3. end of main ----\n");
    return 0;
}
```
```
1. puts test ------ 
Simple String
So Simple String
2. fputs test ----- 
Simple String
So Simple String
3. end of main ----
```
`puts`함수가 호출되면 문자열 출력 후 자동으로 개행되지만, `fputs`함수가 호출되면 문자열 출력 후 자동으로 개행이 이루어지지 않는다.  

### 문자열 입력 함수: gets, gets  
```c
#include <stdio.h>
char * gets(char * s);
char * fgets(char * s, int n, FILE * stream);  
```
 → 파일의 끝에 도달하거나 함수호출 실패 시 NULL 포인터 반환  

`gets`함수는 다음의 유형으로 호출한다.  
```c
int main(void)
{
    char str[7];
    gets(str);
}
```  
미리 마련해 놓은 배열을 넘어서는 길이의 문자열이 입력되면 할당 받지 않은 메모리 공간을 침범해 오류가 발생한다는 단점이 있다. 그래서 가급적이면 `fgets`함수를 호출하는 것이 바람직하다.  
```c
int main(void)
{
    char str[7];
    fgets(str, sizeof(str), stdin);
}
```
stdin으로부터 문자열 입력을 받아서 배열 str에 저장하되, sizeof(str)의 길이만큼만 저장한다. **문자열을 입력 받으면 문자열의 끝에 자동으로 널 문자도 추가된다. ** 따라서 하나 작은 길이의 문자열이 저장되는 것이다.  

```c
#include <stdio.h>

int main(void)
{
    char str[7];
    int i;

    for(i=0; i<3; i++)
    {
        fgets(str, sizeof(str), stdin);
        printf("Read %d: %s \n", i+1, str);
    }
    return 0;
}
```
```
12345678901234567890
Read 1: 123456 
Read 2: 789012 
Read 3: 345678 
```  
다음 예제를 보면 공백도 가능하고, 문자열 자체의 '\n'를 버리거나 제외하지 않고 그대로 받아들여서 개행은 두 번 한 것처럼 보인다.  

```c
Y & I
Read 1: Y & I
 
ha ha ha
Read 2: ha ha  
Read 3: ha
```

