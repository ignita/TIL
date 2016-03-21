# 파일 입출력 함수의 기본  

## 파일 입출력 함수들  

```c
int fputc(int c, FILE * stream);
int fgetc(FILE * stream);
int fputs(const char * s, FILE * stream);  
char * fgets(char * s, int n, FILE * stream);  
```

```c
#include <stdio.h>

int main(void)
{
    FILE * fp = fopen("simple.txt", "wt");
    if(fp == NULL) {
        puts("파일 오픈 실패! ");
        return -1;
    }

    fputc('A', fp);
    fputc('B', fp);
    fputs("My name is Hong \n", fp);
    fputs("Your name is Yoon \n", fp);
    fclose(fp);
    return 0;
}
```
```c
#include <stdio.h>

int main(void)
{
    char str[30];
    int ch;
    FILE * fp = fopen("simple.txt", "rt");
    if(fp == NULL) {
        puts("파일 오픈 실패! ");
        return -1;
    }

    ch = fgetc(fp);
    printf("%c \n", ch);
    ch = fgetc(fp);
    printf("%c \n", ch);

    fgets(str, sizeof(str), fp);
    printf("%s", str);
    fgets(str, sizeof(str), fp);
    printf("%s", str);

    fclose(fp);
    return 0;
}
```  
- 문자열이 파일에 저장될 때에는 문자열 끝을 의미하는 널 문자는 저장되지 않는다. 때문에 파일에서는 개행을 기준으로 문자열을 구분  
- `fgets` 함수를 호출해서 읽어들일 문자열의 끝에는 반드시 '\n'문자가 존재해야 한다.   


## feof 함수 기반의 파일 복사 프로그램  

- 파일의 마지막에 저장된 데이터까지 모두 읽어야하는 상황이 존재하면 다음과 같은 함수가 필요하다.  
- 파일의 끝을 확인하는 함수다.  
```c
#include <stdio.h>
int feof(FILE * stream);  
```
- 파일의 끝에 도달한 경우 0이 아닌 값 반환  

```c
#include <stdio.h>

int main(void)
{
    FILE * src = fopen("src.txt", "rt");
    FILE * des = fopen("dst.txt", "wt");
    int ch;;

    if(src == NULL || des == NULL)
    {
        puts("파일오픈 실패! ");
        return -1;
    }

    while((ch=fgetc(src)) != EOF)
        fputc(ch, des);

    if(feof(src) != 0)
        puts("파일복사 완료!");
    else
        puts("파일복사 실패!");

    fclose(src);
    fclose(des);
    return 0;
}
```
- `fgetc` 함수가 EOF를 반환했다고 해서 무조건 파일의 끝은 아니다. 오류가 발생하는 경우에도 EOF를 반환하기 때문에 `feof` 함수를 호출해서 원인을 확인할 필요가 있다.  

- 문자열 복사하기, `fgets` 함수는 더 이상 읽을 데이터가 없거나 오류가 발생했을 때 NULL 값을 반환한다.  
```c
#include <stdio.h>

int main(void)
{
    FILE * src = fopen("src.txt", "rt");
    FILE * des = fopen("dex.txt", "wt");
    char str[20];

    if(src == NULL || des == NULL) {
        puts("파일오픈 실패!");
        return -1;
    }

    while(fgets(str, sizeof(str), src) != NULL)
        fputs(str, des);

    if(feof(src) != 0)
        puts("파일복사 완료!");
    else
        puts("파일복사 실패!");

    fclose(src);
    fclose(des);
    return 0;
}
```  

## 바이너리 데이터의 입출력: fread, write  

- 바이너리 입력  
```c
#include <stdio.h>
size_t read(void * buffer, size_t size, size_t count, FILE * stream);
```
- 성공 시 전달인자 count, 실패 또는 파일의 끝 도달 시 count보다 작은 값 반환  

```c
int buf[12];
fread((void*)buf, sizeof(int), 12, fp);
```
- sizeof(int) 크기의 데이터 12개를 fp로부터 읽어 들여서 배열 buf에 저장하라.  
- 실제로 읽어 들인 데이터의 **갯수**를 반환  

- 바이너리 출력  
```c
#include <stdio.h>
size_t write(const void * buffer, size_t size, size_t count, FILE * stream);
```
- 성공 시 전달인자 count, 실패 시 count보다 작은 값 반환  

```c
int buf[7] = {1, 2, 3, 4, 5, 6, 7};
fwrite((void*)but, sizeof(int), 7, fp);  
```
- sizeof(int) 크기의 데이터 7개를 buf로부터 읽어서 fp에 저장하라.  

```c
#include <stdio.h>

int main(void)
{
    FILE * src = fopen("aout.png", "rb");
    FILE * des = fopen("test.png", "wb");
    char buf[20];
    int readCnt;

    if(src==NULL || des==NULL) {
        puts("파일오픈 실패!");
        return -1;
    }

    while(1)
    {
        readCnt = fread((void*)buf, 1, sizeof(buf), src);

        if(readCnt<sizeof(buf))
        {
            if(feof(src) != 0)
            {
                fwrite((void*)buf, 1, readCnt, des);
                puts("파일복사 완료");
                break;
            }
            else
                puts("파일복사 실패");

            break;
        }
        fwrite((void*)buf, 1, sizeof(buf), des);
    }

    fclose(src);
    fclose(des);
}
```
- 음원이나 이미지 파일도 가능하다.  
- `fread` 함수가 sizeof(buf)의 반환값 보다 작다는 것은 파일이 끝에 도달하거나 오류가 났을 경우이다.  
