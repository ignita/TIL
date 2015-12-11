# 유닉스 시스템 보안 설정  

## 서비스 관리  
### Inetd 데몬 
- 수퍼 데몬이라고도 불림.  
- 다른 데몬을 관리하는 데몬이라 하여 붙은 이름  
- 클라이언트로부터 inetd가 관리하고 있는 Telnet이나 SSH, FTP 등에 대한 연결 요청을 받은 후 해당 데몬을 활성화시켜 실제 서비스를 하는, 데몬과 클라이언트의 요청을 연결시켜주는 역할  
![2-10](https://cloud.githubusercontent.com/assets/6129764/11738342/4c9da06e-a025-11e5-9a7f-620cff9495fa.png)  

#### 솔라리스 9의 inetd 데몬  
- inetd.conf 파일  
`telnet   stream    tcp6      nowait    root    /usr/sbin/in.telnetd    in.telnetd`    
  
- 서비스: 서비스 이름을 정의하는 것, /etc/services에 정의되어 있어야 한다.  
- 소켓 타입(Socket Type): TCP일 경우에는 stream, UDP일 경우에는 dgram이라고 표기한다.  
- 프로토콜: /etc/protocols에 정의된 프로토콜 종류와 번호다. 이 프로토콜 번호는 임의로 정해진 것이 아닌 표준이다. TCP는 /etc/protocols 파일에서 확인할 수 있듯이 프로토콜 번호가 6번이다.  
- 대기 설정: inetd가 클라이언트에 서비스를 요청받은 경우, 이후에 즉시 또 다른 요청을 처리할 것인지 여부에 따라 nowait, wait로 구분한다. TCP는 반드시 nowait여야 한다.  
- 로그인 이름: 데몬을 어떤 사용자의 권한으로 수행할 것인지 명시한다. 이 데몬의 실행 권한 설정은 보안에서도 매우 중요한데, 버퍼 오버플로우 같이 해킹 공격에 취약한 데몬이라면 절대로 root 권한을 주면 안 된다. 예를 들어 httpd는 반드시 nobody 권한으로 실행해야 한다.  
- 서버: 해당 서비스를 수행하기 위해 어떤 프로그램을 실행할지를 절대 경로로 적는다.  
- 인자(Argument): 데몬을 실행하는 데 필요한 인자 값을 적는다.  
  
