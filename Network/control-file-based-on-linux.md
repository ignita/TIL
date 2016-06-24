# 리눅스 기반 파일 조작하기   

- 리눅스에서의 소켓조작은 파일조작과 동일하게 간주됨.  
- 리눅스는 소켓을 파일의 일종으로 구분  
 - 따라서 파일 입출력 함수를 소켓 입출력에 즉, 네트워크상에서의 데이터 송수신에 사용 가능  
- 윈도우는 파일과 소켓을 구분  

## 저 수준 파일 입출력(Low-level File Access)과 파일 디스크립터(File Descriptor)  
- 저 수준: "표준에 상관없이 운영체제가 독립적으로 제공하는~"의 의미  
 - 리눅스에서 제공하는 함수라는 말!(ANSI 표준에서 정의한 함수가 아니라는 뜻)  
- 파일 디스크립터: 시스템으로부터 할당 받은 파일 또는 소켓에 부여된 정수  
- 표준 입출력과 표준 에러에 할당된 파일 디스크립터  

 | 파일 디스크립터 | 대 상 |
 | --- | --- |
 | 0 | 표준입력: Standard Input |
 | 1 | 표준출력: Standard Output |  
 | 2 | 표준에러: Standard Error |

- 파일과 소켓은 생성의 과정을 거쳐야 파일 디스크립터가 할당된다.  
- 반면, 위에 보이는 세 가지 입출력 대상은 별도의 생성과정 없이도 프로그램이 실행되면 자동으로 할당되는 파일 디스크립터이다.  

> File Descriptor(File Handle)  
운영체제가 만든 파일 또는 소켓의 지칭을 편히 하기 위해서 부여된 숫자에 지나지 않는다. 파일 핸들이라고도 한다. 핸들이라는 표현은 주로 윈도우에서 사용되는 용어..

## 파일 열기  

```c
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int open(const char *path, int flag);
```
- 성공 시 파일 디스크립터, 실패 시 -1 반환
 - path - 파일 이름을 나타내는 문자열의 주소 값 전달  
 - flag - 파일의 오픈 모드 정보(파일의 특성 정보) 전달  
 
 | 오픈 모드 | 의미 |
 | --- | --- |
 | O_CREAT | 필요하면 파일을 생성 |
 | O_TRUNC | 기존 데이터 전부 삭제 |  
 | O_APPEND | 기존 데이터 보존하고, 뒤에 이어서 저장 |
 | O_RONLY | 읽기 전용으로 파일 오픈 |
 | O_WRONLY| 쓰기 전용으로 파일 오픈 |
 | O_RDWR | 읽기, 쓰기 겸용으로 파일 오픈 |  

 - OR 연산자로 묶어서 전달 가능  

## 파일 닫기  
```c
#include <unistd.h>

int close(int fd);
```
- 성공 시 0, 실패 시 -1 반환  
- fd - 닫고자 하는 파일 또는 소켓의 파일 디스크립터 전달  

## 파일에 데이터 쓰기  

```c
#include <unistd.h>

ssize_t write(int fd, const void * but, size_t nbytes);
```
- 성공 시 전달한 바이트 수, 실패 시 -1 반환  
- fd - 데이터 전송대상을 나타내는 파일 디스크립터 전달
- buf - 전송할 데이터가 저장된 버퍼의 주소 값 전달  
- nbytes - 전송할 데이터의 바이트 수 전달  
- size_t는 typedef 선언을 통해 unsigned int로 정의됨  
- ssize_t는 s가 하나 더 붙은 형태로 signedf를 의미, 즉 ssize_t는 signed int로 정의  

> **_t로 끝나는 자료형**  
'고전적인(primitive) 자료형'이라고 한다. 일반적으로 sys/types.h 헤더파일에 typedef 선언을 통해 정의. 원래 알고 있는 기본 자료형에 또 다른 이름을 붙여 놓은 것. 그 이유는??  
지금은 int가 32비트라고 말하지만 과거 16비트 시절에는 int가 16비트였다. 이렇듯 시스템의 차이, 시간의 흐름에 따라 자료형의 표현 방식이 달라지기 때문에 프로그램상에서 선택된 자료형의 변경이 요구되기도 한다. size_t, ssize_t의 typedef 선언만 변경해서 컴파일하면 코드의 변경을 최소화할 수 있다.  그래서 일반적으로 프로젝트를 진행할 때 기본 자료형 이름에 별도의 이름을 부여하기 위해 많은 양의 typedef 선언이 추가되는데, 이 프로그래머에 의해 정의된 자료형 이름과의 구분을 위해 시스템(운영체제)에서 정의하는 자료형 이름에는 _t가 붙어있다.  


## 예제  
### 파일에 데이터 쓰기  
```c
// low_open.c  
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
void error_handling(char* message);

int main(void) {
    int fd;
    char buf[] = "Let's go!\n";

    fd = open("data.txt", O_CREAT | O_WRONLY | O_TRUNC);
    if (fd == -1)
        error_handling("open() error!");
    printf("file descriptor: %d \n", fd);

    if (write(fd, buf, sizeof(buf)) == -1)
        error_handling("write() error!");
    close(fd);
    return 0;
}

void error_handling(char* message)
{
    fputs(message, stderr);
    fputc('\n', stderr);
    exit(1);
}
```
```
MACBOOKPRO-D499:low_open ox$ gcc low_open.c -o lopen
MACBOOKPRO-D499:low_open ox$ ./lopen
file descriptor: 3 
MACBOOKPRO-D499:low_open ox$ cat data.txt
Let's go!
MACBOOKPRO-D499:low_open ox$ 
```  

### 파일에 저장된 데이터 읽기  
- read 함수  
```c
#include <unistd.h>

ssize_t read(int fd, void *buf, size_t nbytes);  
```
- 성공 시 수신한 바이트 수(단 파일일의 끝을 만나면 O), 실패 시 -1 반환  
- fd - 데이터 수신대상을 나타내는 파일 디스크립터 전달  
- buf - 수신한 데이터를 저장할 버퍼의 주소 값 전달  
- nbytes - 수신할 최대 바이트 수 전달  

```c
// low_read.c
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#define BUF_SIZE 100
void error_handling(char* message);

int main(void)
{
    int fd;
    char buf[BUF_SIZE];

    fd = open("data.txt", O_RDONLY);
    if(fd == -1)
        error_handling("open() error!");
    printf("file descriptor: %d \n", fd);

    if(read(fd, buf, sizeof(buf)) == -1)
        error_handling("read() error!");
    printf("file data: %s:", buf);
    close(fd);
    return 0;
}

void error_handling(char* message)
{
    fputs(message, stderr);
    fputc('\n', stderr);
    exit(1);
}
```
```
MACBOOKPRO-D499:low_open ox$ gcc low_read.c -o lread
MACBOOKPRO-D499:low_open ox$ ./lread
file descriptor: 3 
file data: Let's go!
:MACBOOKPRO-D499:low_open ox$ 
```

### 파일 디스크립터와 소켓  

- 파일과 소켓 생성 그리고 반환되는 파일 디스크립터의 값을 정수형태로 비교  
```c
// fd_seri.c
#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/socket.h>

int main(void)
{
    int fd1, fd2, fd3;
    fd1 = socket(PF_INET, SOCK_STREAM, 0);
    fd2 = open("test.dat", O_CREAT|O_WRONLY|O_TRUNC);
    fd3 = socket(PF_INET, SOCK_DGRAM, 0);

    printf("file descriptor 1: %d\n", fd1);
    printf("file descriptor 2: %d\n", fd2);
    printf("file descriptor 3: %d\n", fd3);

    close(fd1); close(fd2); close(fd3);
    return 0;
}  
```
```
MACBOOKPRO-D499:Network ox$ gcc fd_seri.c -o fds
MACBOOKPRO-D499:Network ox$ ./fds
file descriptor 1: 3
file descriptor 2: 4
file descriptor 3: 5
MACBOOKPRO-D499:Network ox$ 
```
- 일련의 순서대로 넘버링이 되는 것을 확인  
 - 3부터 시작하는 이유는 표준 입출력에 2까지 이미 할당했기 때문  