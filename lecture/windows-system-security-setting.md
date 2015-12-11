# 윈도우 시스템 보안 설정  

## 계정 정책  

### 계정 관리  
1. 패스워드 관리: 주기적으로 관리하는 시스템의 패스워드를 크래킹하여 취약한 패스워드를 가진 계정을 체크함  
2. 불필요한 계정의 존재 여부 확인: 계정의 생성은 문서화하여 기록하고 주기적으로 불필요한 계정을 삭제함  
3. administrator 계정 변경: 윈도우 시스템의 경우 administrator을 쉽게 추측할 수 있으므로 다른 이름의 계정으로 변경  

### 암호 정책  
- '암호의 복잡성을 만족해야 함', '최소 암호 길이'와 '최근 암호 기억'등의 설정사항을 통해 시스템에 설정된 패스워드를 충분히 강한 상태로 유지해야 함.  

### 계정 잠금 정책  
- 잘못된 로그온 시도를 통핸 패스워드 노출 등의 위험을 줄이기 위해 '계정 잠금 임계값'은 보통 5회로 설정  

## 데몬 관리  

- 데몬: 주기적인 서비스 요청을 처리하기 위해 계속 실행되는 프로그램  

### 주요 서비스 보안 설정   
#### FTP(File Transfer Protocol, 21)  
- 세션 설정: 세션은 실제 사용하는 수만큼으로 제한  
- 로그 정책 설정: 적절한 로그 수준이 유지될 수 있도록 설정  
- 익명 연결 허용 여부 설정: 서비스의 종류에 따라 다를 수 있으나 가급적 허용하지 않음  
- FTP 배너 출력: 경고 문구 등을 출력  
- FTP 홈 디렉터리 권한 설정: 불필요한 쓰기 권한 부여 금지  
- FTP 서비스 접근 제어 설정: 필요한 경우 접근 제어 설정  
- SFTP 사용, 구간 암호화  

#### MS Terminal Service(3389)  
- MS_Term-Service 포트는 GUI 기반의 윈도우 터미널 서비스를 제공.  
- '원격 데스크톱'에 대한 설정은 다음 3가지 중 하나를 선택  
  1. 이 컴퓨터에 대한 연결 허용 안 함: 해당 시스템에 대한 터미널 서비스 자체를 허용하지 않는다.  
  2. 모든 버전의 원격 데스크톱을 실행 중인 컴퓨터에서 연결 허용(보안 수준 낮음): 윈도우 서버 2000 또는 윈도우 XP에서 사용하던 터미널 클라이언트에서의 접근을 허용한다.  
  3. 네트워크 수준 인증을 가진 원격 데스크톱을 실행 중인 컴퓨터에서만 연결 허용(보안 수준 높음)  

