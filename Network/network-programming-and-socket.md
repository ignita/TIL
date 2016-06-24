# 네트워크 프로그래밍과 소켓  

## 소켓  
- 네트워크 프로그래밍: 네트워크로 연결되어 있는 서로 다른 두 컴퓨터가 데이터를 주고받을 수 있도록 하는 것.  
- 소켓(Socket): 물리적으로 연결된 네트워크상에서의 데이터 송수신에 사용할 수 잇는 소프트웨어적인 장치, 운영체제에서 제공  
- 가전기기는 소켓을 통해 전력을 공급받는 것과 유사하다.  
- 멀리 떨어져 있는 컴퓨터끼리 데이터 송수신을 하려면 인터넷이라는 네트워크 망에 연결해야하기 때문  

- 서버 소켓 - 전화기를 받는 것에 비유  
 - 소켓 생성 함수 - 전화기 장만  
  ```c
  #include <sys/socket.h>
  int socket(int domain, int type, int protocol);
  → 성공 시 파일 디스크립터, 실패 시 -1 반환
  ```  

 - 소켓에 IP와 포트번호(소켓의 주소정보) 할당 - 전화번호 부여  
 ```c
 #include <sys/socket.h>
 int bind(int sockfd, struct sockaddr *myaddr, socklen_t addrlen);  
 → 성공 시 0, 실패 시 -1 반환
 ```

 - 소켓을 연결요청이 가능한 상태로 변경 - 케이블 연결  
 ```c
 #include <sys/socket>
 int listen(int sockfd, int backlog);
 → 성공 시 0, 실패 시 -1 반환
 ```

 - 연결요청에 대한 수락 - 수화기를 드는 것  
 ```c
 #include <sys/socket.h>
 int accept(int sockfd, struct sockaddr * addr, socklen_t *addrlen);
 → 성공 시 파일 디스크립터, 실패 시 -1 반환
 ```

 - 정리  

 | 단계 | 함수 |
 | --- | --- |
 | 1. 소켓 생성 | `socket` 함수호출 |
 | 2. IP주소와  PORT번호 할당 | `bind` 함수호출 |
 | 3. 연결요청 가능상태로 변경 | `listen` 함수호출 |
 | 4. 연결요청에 대한 수락| `accept` 함수호출 |  


- 클라이언트 소켓 - 전화를 거는 것에 비유

  - 연결 요청 - 전화를 검  
  ```c
  #include <sys/sockt.h>
  int connect(int sockfd, struct sockaddr *serv_addr, socklen_t addrlen);
  → 성공 시 0, 실패 시 -1 반환
  ```

## "Hello world!" 서버 프로그램의 구현   
- 연결요청을 수락하는 기능의 프로그램을 가리켜 '서버(server)'  
- 요청 수락 시 "Hello world!"라고 응답해주는 서버 프로그램 작성  
- hello_server.c  
```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>
void error_handling(char *message);

int main(int argc, char *argv[])
{
    int serv_sock;
    int clnt_sock;

    struct sockaddr_in serv_addr;
    struct sockaddr_in clnt_addr;
    socklen_t clnt_addr_size;

    char message[] = "Hello World!";

    if(argc != 2)
    {
        printf("Usage : %s <port>\n", argv[0]);
        exit(1);
    }

    serv_sock = socket(PF_INET, SOCK_STREAM, 0);
    if(serv_sock == -1)
        error_handling("socket() error");

    memset(&serv_addr, 0, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr=htonl(INADDR_ANY);
    serv_addr.sin_port = htons(atoi(argv[1]));

    if(bind(serv_sock, (struct sockaddr*) &serv_addr, sizeof(serv_addr)) == -1)
        error_handling("bind() error");

    if(listen(serv_sock, 5) == -1)
        error_handling("listen() error");

    clnt_addr_size = sizeof(clnt_addr);
    clnt_sock = accept(serv_sock, (struct sockaddr*)&clnt_addr, &clnt_addr_size);
    if(clnt_sock == -1)
        error_handling("accept() error");

    write(clnt_sock, message, sizeof(message));
    close(clnt_sock);
    close(serv_sock);
    return 0;
}

void error_handling(char *message)
{
    fputs(message, stderr);
    fputc('\n', stderr);
    exit(1);
}
```
- 클라이언트 소켓을 생성하는 클라이언트 프로그램  
```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>
void error_handling(char *message);

int main(int argc, char* argv[])
{
    int sock;
    struct sockaddr_in serv_addr;
    char message[30];
    int str_len;

    if(argc != 3)
    {
        printf("Usage : %s <IP> <port> \n", argv[0]);
        exit(1);
    }

    sock = socket(PF_INET, SOCK_STREAM, 0);
    if(sock == -1)
        error_handling("socket() error");

    memset(&serv_addr, 0, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = inet_addr(argv[1]);
    serv_addr.sin_port = htons(atoi(argv[2]));

    if(connect(sock, (struct sockaddr*)&serv_addr, sizeof(serv_addr)) == -1)
        error_handling("connect() error!");

    str_len = read(sock, message, sizeof(message)-1);
    if(str_len == -1)
        error_handling("read() error!");

    printf("Message from server : %s \n", message);
    close(sock);
    return 0;
}

void error_handling(char *message)
{
    fputs(message, stderr);
    fputc('\n', stderr);
    exit(1);
}
```  

### 리눅스 기반에서 실행하기  
- GCC 컴파일러의 사용방법  
```
gcc hello_server.c -o hserver
```
- hello_server.c 파일을 컴파일해서 hserver라는 이름의 실행파일을 만드는 문장  
- -o는 실행파일의 이름을 지정하기 위한 옵션, 컴파일 후 hserver라는 이름의 파일이 생성  
```
./hserver
```
- 현재 디렉토리에 있는 hserver라는 이름의 파일을 실행시키라는 의미  
- 서버 프로그램 실행   
```
[me@linuxbox ~]$ gcc hello_server.c -o hserver
[me@linuxbox ~]$ ./hserver 9190
```  
- 제대로 실행되면 위의 상태로 멈춰있게 된다. 서버 프로그램에서 호출한 accept 함수가 반환하지 않았기 때문.  
- 클라이언트 프로그램 실행   
```
[me@linuxbox ~]$ gcc hello_client.c -o hclient
[me@linuxbox ~]$ ./hclient 127.0.0.1 9190
[me@linuxbox ~]$ Hello World! 
[me@linuxbox ~]$ 
```  
- 메시지 수신 후 서버 프로그램, 클라이언트 프로그램 모두가 종료됨.  
- 실행과정에서 입력한 127.0.0.1은 이 예제를 실행한 컴퓨터(로컬 컴퓨터)의 IP 주소를 의미. 서버와 클라이언트가 각각 다른 프로그램에서 실행된다면 127.0.0.1을 대신해 서버의 IP주소를 입력해야 한다.   


