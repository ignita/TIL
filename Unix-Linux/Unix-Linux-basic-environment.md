# 유닉스/리눅스 기본 환경  

## CLI 구문  

CLI란 Command-Line Interface의 약자로 시스템에서 특정 작업을 하기 위해 터미널에서 명령어를 내리는 명령어 라인 인터페이스를 의미. CLI에 입력하는 명령어는 옵션과 아규먼트가 있을 수도 있고 없을 수도 있다. 이런 명령어의 구조를 구문이라고 한다.  

명령어를 내릴 때 옵션과 아규먼트를 사용해 명령어의 동작을 달리할 수 있다.  

명령어(command)  
 - 시스템에서 특정 작업을 하기 위해 실행하는 실행 파일  

옵션(option)  
 - 명령어를 어떻게 실행할 것인지 지정  
 - 일반적으로 대시(-) 문자 뒤에 옵션을 지정함  
 - 옵션은 대소문자를 구별함  

아규먼트(argument)  
 - 명령어 실행에 영향을 받는 파일, 디렉토리, 텍스트와 같은 항목  

예제  
```
command option(s) argument(s)  
```  

### 명령어 사용  
명령어만 사용하는 방법  

- uname: 운영체제의 정보를 보여줌  
```shell
[Unix]
# uname
SunOS
```
```shell
[Linux]  
# uname
Linux 
```  

- date: 시스템의 현재 날짜와 시간을 보여줌  
```shell
# date  
Wed Jan  8 16:18:55 KST 2016  
```

- cal: 현재 년도와 달력을 표시  
```shell
# cal  
   January 2014 
.....
....
..
```

- clear: 터미널 화면을 지우는 명령어  
```shell
# clear
```
### 명령어와 옵션 사용  
명령어에 옵션을 사용하게 되면 명령어를 어떻게 실행 할 것인지 지정할 수 있고, 명령어만 사용했던 것과 다른 결과를 출력한다.  

- uname 명령어에 `-a` 옵션을 사용  
```shell
[Unix]  
# uname -a 
SunOS solaris 5.11 11.1 i86pc i386 i86pc  
```
```shell
[Linux]
# uname -a
......
.....
```
`-a` 옵션은 시스템의 모든 정보를 보여주는 옵션이다.  

- uname 명령어에 다른 옵션  
```shell
[Unix]
# uname -s  
SunOS
# uname -r
5.11
```
```shell
[Linux]
# uname -s
Linux
# uname -r
....
```
`-s` 옵션은 커널의 이름, `-r`옵션은 커널의 정보를 보여준다.  


- 여러 옵션을 한꺼번에 사용하려면 각 옵션 마다 대시(-)를 사용하면 된다.  
```shell
[Unix]
# uname -s -r
SunOS 5.11
```  

- 또는 대시(-)는 한 번만 사용하고 옵션을 그 뒤에 나열하면 된다.  
```shell
[Unix]
# uname -rs
SunOS 5.11
```

### 명령어와 아규먼트 사용  
```shell
# cal 2 2016  
   February 2016
.....
....
..
.
```
첫 번째 아규먼트인 2는 월을 나타내고 두 번째 아규먼트인 2014는 년도를 나타낸다.  

### 명령어 및 옵션과 아규먼트를 함께 사용  
- ls: 디렉토리의 파일 목록을 확인하는 명령어  
```shell
# ls -l /etc/hosts
```

### 여러 명령어 사용  
CLI에서 여러 명령어를 한 줄에서 실행하기 위해서는 각 명령어 마지막에 세미콜론(`;`)을 붙여서 명령어를 분리할 수 있다.  
```shell
command option argument; command option argument; command option argument
```
```shell
#date; uname
The Jan   9 12:13:35 UTC 2016
SunOS
```

- 옵션과 아규먼트를 함께 사용  
```shell
# cal 12 2016; date; uname -a 
    December 2016
.....
...
...
.

Thu Jan 9 12:15:00 UTC 2016
SunOS solaris 5.11 11.1 i86pc i386 i86oc  
```

### CLI 제어 문자
CLI에서 명령어를 입력하는 도중 키보드의 특수 제어 문자를 사용해 화면의 출력을 중지 시키거나 명령어를 삭제 하는 등 제어가 가능하다.  
- <kbd>Ctrl</kbd>+<kbd>C</kbd>: 현재 동작중인 명령어 종료  
- <kbd>Ctrl</kbd>+<kbd>D</kbd>: 파일의 끝(End-Of-File) 또는 종료를 나타냄  
- <kbd>Ctrl</kbd>+<kbd>U</kbd>: 현재 명령어 라인을 모두 지움  
- <kbd>Ctrl</kbd>+<kbd>W</kbd>: 커서가 있는 곳의 단어를 지움 
- <kbd>Ctrl</kbd>+<kbd>S</kbd>: 화면 출력 중지
- <kbd>Ctrl</kbd>+<kbd>Q</kbd>: 화면 출력 시작(<kbd>Ctrl</kbd>+<kbd>S</kbd>로 중지시킨 후)  

### 메뉴얼 페이지 검색  
메뉴얼 페이지에서 특정 정보를 검색하는 방법에는 섹션별로 정보를 검색하는 방법과 키워드별로 특정 정보를 검색하는 방법이 있다.  
https://ko.wikipedia.org/wiki/Man_page  

**섹션별 검색**  
메뉴얼 페이지에서 섹션이란, 명령어를 특정 항목 별로 분류를 해 놓은 단위이다.  

**키워드 검색**  
```
man -k keyword
```
`-k` 옵션을 사용  
