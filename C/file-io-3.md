# 파일 입출력  

## 텍스트 데이터와 바이너리 데이터를 동시에 입출력 하기  

### 서식에 따른 데이터 입출력: fprintf, fscanf  

**fprintf** 
```c
char name[10] = "홍길동";  // 텍스트 데이터
char sex = 'M';  // 텍스트 데이터
int age = 25;    // 바이너리 데이터  
fprintf(fp, "%s %c %d", name, sex, age);   
```
- `fprintf` 함수는 첫 번째 전달인자가 FILE 구조체의 포인터이다.  
 
**fscanf**
```c
char name[10];
char sex;
int age;
fscanf(fp, "%s %c %d", name, &sex, &age);
```
- `fprintf` 함수의 호출을 통해 저장된 데이터는 동일하게 서식을 지정해 `fscanf` 함수의 호출을 통해 읽어들일 수 있다.  
- `scanf`와 다른 점  
 - 첫 번째 인자로 FILE 구조체의 포인터가 전달  
 - 파일 끝에 도달하거나 오류가 발생하면 EOF를 반환  

**예제**
```c
#include <stdio.h>

int main(void)
{
    char name[10];
    char sex;
    int age;

    FILE * fp = fopen("friend.txt", "wt");
    int i;

    for(i=0; i<3; i++)
    {
        printf("이름  성별  나이  순 입력: ");
        scanf("%s %c %d", name, &sex, &age);
        getchar();  // 버퍼에 남아있는 \n의 소멸을 위해
        fprintf(fp, "%s %c %d", name, sex, age);
    }
    fclose(fp);
    return 0;
}
```

```c
#include <stdio.h>

int main(void)
{
    char name[10];
    char sex;
    int age;

    FILE * fp = fopen("friend.txt", "rt");
    int ret;

    while(1)
    {
        ret = fscanf(fp, "%s %c %d", name, &sex, &age);
        if(ret==EOF)
            break;
        printf("%s %c %d \n", name, sex, age);
    }
    fclose(fp);
    return 0;
}
```  

### 텍스트와 바이너리 데이터의 집합체인 구조체 변수의 입출력   

```c
char name[10], char sex, int age
```
위 데이터들은 아래와 같이 구조체로 묶어서 정의하는 것이 일반적이다.  
```c
typedef struct fren
{
    char name[10];
    char sex;
    int age;
} Friend;
```
- 구조체 변수를 통째로 저장하고 통째로 읽어들이는 방법   
 - **구조체 변수를 하나의 바이너리 데이터로 인식하고 처리 **  
 - fread, fwrite 
- 예제  
```c
#include <stdio.h>
typedef struct fren
{
    char name[10];
    char sex;
    int age;
} Friend;

int main(void)
{
    FILE * fp;
    Friend myfren1;
    Friend myfren2;

    /*** file write ***/
    fp = fopen("friend.bin", "wb");
    printf("이름 성별 나이 순 입력: ");
    scanf("%s %c %c", myfren1.name, &(myfren1.sex), &(myfren1.age));
    fwrite((void*)&myfren1, sizeof(myfren1), 1, fp);
    fclose(fp);

    /*** file read ***/
    fp = fopen("friend.bin", "rb");
    fread((void*)&myfren2, sizeof(myfren2), 1, fp);
    printf("%s %c %d \n", myfren2.name, myfren2.sex, myfren2.age);
    fclose(fp);
    return 0;
}
```   

## 임의 접근을 위한 '파일 위치 지시자'의 이동  

- 경우에 따라 파일의 중간 또는 마지막 부분에 저장된 데이터의 일부를 읽어야 하는 경우  
 - 파일 위치 지시자라는 것을 이동 시켜야 함  

### 파일 위치 지시자란?  
- 파일 위치 지시자  
 - FILE 구조체의 멤버  
 - `fgets`, `fputs` 또는 `fread`, `fwrite`와 같은 함수가 호출될 때마다 참조 및 갱신  
 - 이것에 저장된 위치 정보의 갱신을 통해 데이터를 읽고 쓸 위치 정보가 유지  
 - 파일이 처음 개방되면 무조건 파일의 맨 앞부분을 가리킴.  
 - 파일의 중간이나 끝부터 데이터를 읽거나 쓰기를 원한다면 이것을 이동시켜야 한다.  

### 파일 위치 지시자의 이동: fseek  
```c
#include <stdio.h>
int fseek(FILE * stream, long offset, int wherefrom);  
```
- 성공 시 0, 실패 시 0이 아닌 값 반환  
- stream으로 전달된 파일 위치 지시자를 wherefrom에서 offset 바이트만큼 이동  
- wherefrom에 전달될 수 있는 상수와 의미  
 - SEEK_SET(0) - 파일 맨 앞에서부터 이동을 시작  
 - SEEK_CUR(1) - 현재 위치에서부터 이동을 시작  
 - SEEK_END(2) - 파일 맨 끝에서부터 이동을 시작 
- 매개변수 offset에는 양의 정수뿐만 아니라 음의 정수도 전달 가능  
 - 양의 정수: 파일의 마지막을 향해 파일 위치 지시자가 이동  
 - 음의 정수: 파일의 시작위치를 향해서 파일 위치 지시자가 이동  
- `fseek` 함수의 호출결과  
![파일위치지시자](http://cfile6.uf.tistory.com/image/23320B4152EF4AEC0C0A93)  
 - SEEK_SET 전달 시 첫 번째 바이트에서부터 이동을 시작  
 - SEEK_END 전달 시 EOF에서부터 이동을 시작  
 - `fseek` 함수의 두 번째 인자로 음수가 전달되면 왼쪽으로(앞 부분으로) 이동  
- 파일의 끝 = 파일의 마지막 데이터가 아닌 EOF  

```c
#include <stdio.h>

int main(void)
{
    /* 파일생성 */
    FILE * fp = fopen("text.txt", "wt");
    fputs("123456789", fp);
    fclose(fp);

    /* 파일개방 */
    fp = fopen("text.txt", "rt");

    /* SEEK_END test */
    fseek(fp, -2, SEEK_END);
    putchar(fgetc(fp));

    /* SEEK_SET test */
    fseek(fp, 2, SEEK_SET);
    putchar(fgetc(fp));

    /* SEEK_CUR test */
    fseek(fp, 2, SEEK_CUR);
    putchar(fgetc(fp));

    fclose(fp);
    return 0;
}
```
```
836
```
- 파일 끝(EOF)에서 앞으로 두 칸이므로 8을 가리킨다.(마지막 데이터가 아니라...)  

### 현재 파일 위치 지시자의 위치는?: ftell   
```c
#include <stdio.h>
long feel(FILE * stream)  
```
- 파일 위치 지시자의 위치 정보 반환  
- 파일 위치 지시자가 첫 번째 바이트를 가리킬 경우 0을 반환  
- 세번 번째 바이트는 2를 반환  
- 가장 앞부분을 0으로 간주  



