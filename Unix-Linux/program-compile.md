# 프로그램 컴파일  

- 왜 소프트웨어를 컴파일해야 하나?  

 - 가용성: 배포판 저장소에 있는 다수의 사용가능한 프로그램에도 불구, 어떤 배포판은 사용자가 원하는 모든 프로그램을 가지고 있지 않을 수도 있음. 이런 경우에 필요한 프로그램을 얻는 방법은 소스로부터 그 프로그램을 컴파일해 만드는 것 뿐.  
 - 적시성: 어떤 배포판은 최신 버전의 프로그램들을 가지고 있는 반면에 아닌 경우도 많다. 가장 최신 버전을 갖기 위해서는 컴파일이 필수적.  

- 명령어  
 - `make` - 프로그램 관리 유틸리티  

## 컴파일링이란?  

- **소스 코드**(프로그래머에 의해 작성된, 사람이 읽을 수 있는 형태의 프로그램 서술)를 컴퓨터 프로세서의 언어로 번역하는 절차.  
- 컴퓨터 프로세서(또는 CPU)는 매우 기본적인 단계에서 동작 - **기계어**로 프로그램들을 실행  
 - 숫자 코드를 대신하기 위해 어셈블리어가 출현했다. 어셈블리어로 짜인 프로그램들은 **어셈블러**라는 프로그램에 의해 기계어로 처리된다.  
 - 그 다음으로 나타난 것은 **고급 프로그래밍 언어**.  
   - 고급 프로그래밍 언어로 작성된 프로그램은 **컴파일러**라고 하는 프로그램에 의해 처리되어 기계어로 변환됨.  
- 컴파일링과 함께 자주 사용되는 절차를 **링킹**이라 한다.    
 - 프로그램들은 파일 열기와 같은 공통적인 작업들을 많이 수행 -> 프로그램마다 깍각 파일 열기 루틴을 구현한다면 낭비가 된다. -> 파일을 여는 방법이 정의된 프로그램 코드를 모든 프로그램이 공유하게 하는 것이 현명. -> 이와 같은 공통 작업의 지원은 **라이브러리**를 통해 이뤄짐.  
 - **링커**는 컴파일러의 출력물과 컴파일된 프로그램이 필요한 라이브러리를 연결하는 데 사용  

- 위 프로세스의 최종 결과물은 **실행파일**  

### 모든 프로그램이 컴파일되는가?  

- 아니다.  
 - 쉘 스크립트와 같은 일부 프로그램들은 컴파일은 필요 없고 직접 실행됨.  
  - **스크립트** 또는 **인터프리트 언어**로 알려진 프로그래밍 언어로 작성됨.  
  - Perl, Python, PHP, Ruby...   
- 스크립트 언어는 **인터프리터**라고 불리는 특수한 프로그램에 의해 실행.  
 - 인터프리터는 프로그램 파일을 입력 받아 읽고 파일 내부의 각 명령어들을 실행  
 - 컴파일된 프로그램보다 느리다. 소스 코드 명령이 매번 번역되고 실행되기 때문.  
 - 하지만 컴파일된 프로그램보다 더 빠르고 쉽게 프로그램을 개발할 수 있음.  

- 프로그램은 항상 코드, 컴파일, 테스트의 반복 순환으로 개발됨.  
 - 프로그램의 크기가 커짐에 따라 컴파일 단계에 오랜 시간이 걸릴 수 있다.  


## C 프로그램 컴파일하기  

- 리눅스 환경에서 C 컴파일러는 리차드 스톨만에 의해 개발된 gcc(GNU C Compiler)가 보편적으로 사용됨.  
- 대부분의 배포판은 gcc를 기본적으로 설치하지 않는다. 다음 예제처럼 컴파일러가 존재 확인이 가능하다.  

 ```
 [me@linuxbox ~]$ which gcc  
 /usr/bin/gcc
 ```
- 이 예제의 결과에서 컴파일러가 설치되었음을 확인 가능 

### 소스 코드 구하기   

- 소스 코드용 디렉토리 src를 생성, ftp를 사용해 소스 코드를 디렉토리에 다운로드  

 ```
 [me@linuxbox ~]$ mkdir src  
 [me@linuxbox ~]$ cd src   
 [me@linuxbox src]$ ftp ftp.gnu.org    
 Connected to ftp.gnu.org.  
 220 GNU FTP server ready.     
 Name (ftp.gnu.org:me): anonymous    
 230 Login successful.    
 Remote system type is UNIX.  
 Using binary mode to transfer files.  
 ftp > cd gnu/diction   
 250 Directory successfully changed.  
 ftp > ls    
 229 Entering Extended Passive Mode (|||21916|).
 150 Here comes the directory listing.
 -rw-r--r--    1 3003     65534       68940 Aug 28  1998 diction-0.7.tar.gz
 -rw-r--r--    1 3003     65534       90957 Mar 04  2002 diction-1.02.tar.gz
 -rw-r--r--    1 3003     65534      141062 Sep 17  2007 diction-1.11.tar.gz
 -rw-r--r--    1 3003     65534         189 Sep 17  2007 diction-1.11.tar.gz.sig
 226 Directory send OK.
 ftp> get diction-1.11.tar.gz
 local: diction-1.11.tar.gz remote: diction-1.11.tar.gz
 229 Entering Extended Passive Mode (|||28528|).
 150 Opening BINARY mode data connection for diction-1.11.tar.gz (141062 bytes).
 100% |***********************************|   137 KiB   37.13 KiB/s    00:00 ETA
 226 Transfer complete.
 141062 bytes received in 00:05 (24.62 KiB/s)
 ftp> bye
 421 Timeout.
 [me@linuxboxsrc]$ ls
 diction-1.11.tar.gz
 [me@linuxbox src]$  
 ```  
- 소스 코드는 항상 압축된 tar파일 형태로 제공됨.  
 - 때때로 **타르볼**(tarball)이라고 부르며, **소스 트리** 혹은 소스 코드로 구성된 파일과 디렉토리의 계층을 포함  
- FTP 사이트에 연결 후, 가용한 tar 파일들의 목록을 확인하고 최신 버전의 파일을 선택해 다운로드한다.  
 - ftp에서 get 명령어를 사용해 FTP 서버에서 사용자 컴퓨터로 파일을 복사  

- tar 파일이 다운로드되면 압축 해제가 필요. 다음과 같이 사용  
 ```
 [me@linuxbox src]$ tar xzf diction-1.11.tar.gz  
 [me@linuxbox src]$ ls
 diction-1.11		diction-1.11.tar.gz  
 ```

- 소스 코드를 압축 해제하기 전에 트리의 구조를 확인하는 것은 좋은 생각.   

### 소스 트리 확인하기  

- tar 파일을 푼 결과로 diction-1.11 이라는 새 디렉토리가 생성. 이 디렉토리는 소스 트리를 포함  

 ```
 [me@linuxbox src]$ cd diction-1.11/
 [me@linuxbox src]$ ls
 COPYING		config.sub	diction.pot	getopt.c	nl
 INSTALL		configure	diction.spec	getopt.h	nl.po
 Makefile.in	configure.in	diction.spec.in	getopt1.c	sentence.c
 NEWS		de		diction.texi.in	getopt_int.h	sentence.h
 README		de.po		en		install-sh	style.1.in 
 config.guess	diction.1.in	en_GB		misc.c		style.c
 config.h.in	diction.c	en_GB.po	misc.h		test
 ```  

- 여기서 .c와 .h로 끝나는 파일을 확인  

 ```
 [me@linuxbox src]$ ls *.c
 diction.c	getopt1.c	sentence.c
 getopt.c	misc.c		style.c
 [me@linuxbox src]$ ls *.h
 getopt.h	getopt_int.h	misc.h		sentence.h  
 ```  
- 소스 코드 파일은 일반 텍스트이며, less 명령으로 확인이 가능  

 ```
 [me@linuxbox src]$ less diction.c  
 ```  

- **헤더 파일** 또한 평범한 텍스트 파일. 헤더 파일은 소스 코드나 라이브러리에 포함된 루틴에 대한 설명을 가지고 있음.  

### 프로그램 빌드하기  

- 대부분의 프로그램은 다음 두 명령어로 간단히 빌드  
 - ./configure
 - make  

- configure 프로그램은 소스 트리와 함께 제공된 쉘 스크립트. 빌드 환경을 분석하는 역할  
 - 대부분의 소스 코드는 이식 가능하게 설계됨(유닉스 형 시스템 중 하나 이상에 시스템에서 빌드 가능)  
  - configure가 필수적인 외부 툴과 컴포넌트가 설치되어있는지 확인  
 - configure는 쉘이 일반적으로 예상하는 프로그램들의 위치에 있지 않기 때문에 반드시 `./`와 함께 사용. 이것은 해당 프로그램이 현재 작업 디렉토리에 있다는 의미  
 
 ```
 checking build system type... i386-apple-darwin15.5.0
 checking host system type... i386-apple-darwin15.5.0
 checking for gcc... gcc
 checking for C compiler default output file name... a.out
 checking whether the C compiler works... yes
 checking whether we are cross compiling... no
 checking for suffix of executables... 
 checking for suffix of object files... o
 checking whether we are using the GNU C compiler... yes
 checking whether gcc accepts -g... yes
 checking for gcc option to accept ISO C89... none needed
 checking for a BSD-compatible install... /usr/bin/install -c
 checking for strerror... yes
 checking for library containing regcomp... none required
 checking for broken realloc... no
 checking for msgfmt... no
 configure: creating ./config.status
 config.status: creating Makefile
 config.status: creating diction.1
 config.status: creating diction.texi
 config.status: creating diction.spec
 config.status: creating style.1
 config.status: creating test/rundiction
 config.status: creating config.h
 ```  
 - 위 처럼 빌드에 관한 설정과 테스트로 많은 메시지를 출력. 중요한 것은 **아무런 에러 메시지가 없어야 한다**는 것.  
 - 프로그램은 에러가 수정될 때까지 빌드 불가  

- configure는 소스 디레고리에 몇 가지 새 파일들을 생성  
 - Makefile  
   make 프로그램이 정확히 어떻게 프로그램을 빌드하는지를 알려주는 설정 파일. 이 파일이 없다면 make는 실행되지 않는다. Makefile은 텍스트 파일  

   - make 프로그램은 최종 프로그램으로 구성되는 요소들 간의 관계와 의존성을 기술한 makefile(일반적으로 Makefile이란 이름으로)을 입력 받음.  
   - makefile의 첫 부분은 makefile의 뒷부분의 섹션에서 치환될 변수를 정의. 예를 들면 다음과 같음.  
    ```
    CC=             gcc
    ```   
    - C 컴파일러로 gcc가 정의됨. makefile 뒷부분에서 이 변수가 사용되는 부분을 보게됨.  
    ```
    diction:    diction.o sentence.o misc.o getopt.o getopt1.o
                $(CC) -o $@ $(LDFLAGS) diction.o sentence.o misc.o \
                getopt.o getopt1.o $(LIBS)
    ```  
    - 여기서 치환이 일어나 실행 시에 $(CC)의 값은 gcc로 대체    

  - makefile의 대부분은 **타겟**과 타겟 생성에 의존적인 파일들의 정의로 라인을 구성.  
  - 이 예제에서는 diction 실행파일이 타겟이 됨. 나머지 라인은 그 요소들로부터 타겟을 생성하는 데 필요한 명령들을 기술.   
    - 이 예제에서 실행파일 diction은 diction.o, sentence.o, misc.o, getopt.o 의 존재 여부에 의존적. makefile 뒷부분에서 이들 또한 각각 타겟으로 정의된 것을 볼 수 있음.   
    - 파일 초기에 모든 .c파일을 .o파일로 컴파일하는 데 사용하는 명령어가 기술됨.  
    ```
    .c.o:
                $(CC) -c $(CPPFLAGS) $(CFLAGS) $<
    ```   

- 프로그램 빌드하기  
 
 ``` 
 [me@linuxbox diction-1.11]$ make  
 ```  
 - make의 동작을 설명하기 위해 Makefile의 내용을 사용해 프로그램이 실행. 많은 메시지를 출력. 작업이 완료되면 모든 대상이 디렉토리에 나타남.  
 - make를 다시 실행하면 이상한 메시지가 출력된다. make는 모든 것을 간단히 다시 빌드하기보다 필요한 것만 빌드한다. 모든 타겟이 존재하기에 make는 아무것도 할 것이 없다고 결정한 것.   
    - 대형 프로젝트에는 의미 있는 기능   

### 프로그램 설치하기  

- 잘 패키징된 소스 코드는 종종 install이라 부르는 특별한 make 타겟을 가지고 있음.  
 - 이 타겟이 시스템 디렉토리에 최종 사용 제품을 설치  
 - 주로 이 디렉토리는 /usr/local/bin이고 전통적으로 빌드된 소프트웨어가 위치하는 곳. 이 디렉토리는 일반적으로 사용자에게 쓰기 권한이 없기 때문에 **슈퍼유저**로 설치를 진행해야함.   

  ```
  [me@linuxbox diction-1.11]$ sudo make install
  ```  

- 설치 후 실행 준비된 프로그램을 확인 가능  
 ``` 
 [me@linuxbox diction-1.11]$ which diction
 /usr/local/bin/diction  
 ```