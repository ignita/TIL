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
