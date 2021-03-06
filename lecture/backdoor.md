# 백도어  

## 백도어에 대한 이해  

### 백도어와 트로이 목마  
- 트로이 목마: 의도하지 않은 코드를 정상적인 프로그램에 삽입한 프로그램  
  예) 웜 형식의 메일  
- 스파이웨어(Spyware): 설치된 시스템의 정보를 주기적으로 원격지의 특정한 서버에 보내는 프로그램  
- 백도어
  - 원래 의미: 운영체제나 프로그램을 생성할 때 정상적인 인증 과정을 거치지 않고, 운영체제나 프로그램 등에 접근할 수 있도록 만든 일종의 통로  
  - Administrative hook 이나 트랩 도어(Trap Door)라고도 부른다.  
  - 운영체제 개발 시 정상적인 인증을 거치지 않은 상태에서 관리자의 권한으로 어떤 작업을 수행해야 할 경우에 사용  
  
### 백도어의 종류  
- 로컬 백도어  
- 원격 백도어  
- 패스워드 크래킹 백도어  
- 시스템 설정 변경 백도어  
- 트로이 목마 형태의 프로그램  
- 거짓 업그레이드  

## 리눅스/유닉스 백도어  
- 커널(Kernel) 백도어  
  - 운영체제의 핵심 부분인 커널에 심어 넣는 백도어  
  - 무척 민감하고 다른 백도어와 비교해 난이도가 높다.  
  - 커널에서 동작하기 때문에 일반 백도어보다 좀 더 강력하며 제거하기 어렵고 설치 작업이 까다롭다.  

## 백도어 탐지와 대응책  

### 현재 동작 중인 프로세스 확인  
- 현재 프로세스를 확인해 백도어가 아닌 정상 프로세스를 아는 것도 매우 중요  
- 윈도우에서는 <kbd>Ctrl</kbd>+<kbd>Alt</kbd>+<kbd>Delete</kbd>를 눌러 작업 관리자에서 현재 실행 중인 프로세스 확인 가능  

### 열린 포트 확인  
- 백도어 상당수가 외부와 통신을 위해 서비스 포트를 생성  
- 시스템에서는 `netstat` 명령으로 열린 포트 확인이 가능  
- 일반 시스템에서 사용되는 포트는 그리 많지 않기 때문에 주의해 살펴보면 백도어가 사용하는 포트를 쉽게 확인 가능  

### SetUID 파일 검사  
- SetUID 파일은 리눅스나 유닉스 시스템에서 로컬 백도어로서 강력한 기능을 하는 경우가 많다.  
- 따라서 SetUID 파일 중에 추가되거나 변경된 것은 없는지 주기적으로 살펴보아야 한다.  

### 바이러스와 백도어 탐지 툴 이용  
- 잘 알려진 백도어는 대부분 바이러스의 일종으로 분류되 백신 툴이나 다양한 탐지 툴에서 발견된다.  

### 무결성 검사  
- 시스템에 어떤 변화가 일어나는지 알아보는 것  
- MD5 해시 기법을 많이 사용. 파일 내용이 조금만 바뀌어도 MD5 해시 결과 값이 다르다.  

### 로그 분석  
- 'Cyber Forensic'이라는 분야로 정착됨.  

### 백도어 탐지와 제거  
- 대부분의 백도어는 웜을 통해 PC에 설치.  
- DDoS 공격도 네트워크에 접근 가능한 임의의 PC에 백도어를 설치한 것  
  1. 백도어 프로세스의 중지  
  2. 백도어 파일의 삭제  
  3. 레지스트리 삭제  
