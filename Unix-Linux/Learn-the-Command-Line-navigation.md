# Learn the Command Line - navigation

[List of command line commands](https://www.codecademy.com/articles/command-line-commands)  

커맨드 라인은 컴퓨터를 위한 text interface이다. 컴퓨터의 operating system을 실행하는 명령어들을 포함하는 프로그램이다. 커맨드 라인을 통해서 Mac의 Finder와 Windows의 Windows Explorer 처럼 컴퓨터의 파일과 폴더를 돌아다닐 수 있다. 다른 점이 있다면 커맨드 라인은 모두 text로 되어있다는 점이다.  
커맨드 라인이 가지고 있는 이점은 그것의 능력이다. 프로그램을 실행하고, 공통된 작업을 자동화하기 위한 스크립트 작성, 그리고 어려운 작업을 처리하기 위한 간단한 명령어들을 조합한다.(-중요한 프로그래밍 툴을 만드는 것)  


## First Command  

커맨드 라인에 접근하기 위해서는 terminal emulator를 사용한다. '터미널'이라고 부른다. 명령어는 터미널에서 `$` 다음에 입력한다.  
`$`은 Shell prompt 라고 부르고, 터미널이 명령어를 입력받을 준비가 되었다는 것을 나타낸다.  

## ls  

`ls` 명령어를 입력하면 커맨드 라인은 현재 위치의 폴더를 알아보고, 그 속에 들어있는 폴더와 파일의 리스트를 알려준다. 커맨드 라인을 사용할 때 디렉토리(폴더)를 알기 위해 사용하는데, 컴퓨터에 있는 파일과 디렉토리는 파일 시스템으로 구성된다.    

## File System  
파일 시스템은 컴퓨터의 트리 구조로 파일과 디렉토리를 구성한다.  
1. 파일 시스템에서 첫 번째 디렉토리는 root 디렉토리이다. 파일 시스템에서 다른 모든 디렉토리들과 파일들의 부모이다.  
2. 각 부모 디렉토리는 자식 디렉토리들과 파일들을 포함할 수 있다.   
3. 부모-자식 관계는 계속해서 중첩된다.  


## pwd  

`pwd`명령어는 "print working directory"를 의미한다. 현재 속해 있는 디렉토리의 이름을 출력하는데 그것을 working 디렉토리라 한다.  

```bash
$ pwd
/Users/ox
$ ls
Applications	Documents	Movies		Public
```

## cd  
`cd`는 "change directory"를 의미한다. working 디렉토리를 바꾸는 것이라고 보면 된다.  `cd` 명령어는 디렉토리의 이름을 인수로 받는다. 그리고 그 디렉토리를 바꿔 들어가는 것이다.  

## cd ..
디렉토리를 다시 원래로 한 칸 돌아갈 때 `cd ..`을 사용한다.  

## mkdir  
`mkdir`은 "make directory"를 의미한다. 그리고 디렉토리의 이름을 인수로 받고 현재의 working 디렉토리에 새로운 디렉토리를 생성한다.  

## touch  
`touch` 명령은 working directory 안에 새로운 파일을 생성한다. filename 인수를 가지고, 현재 working 디렉토리안에 빈 파일을 생성한다.


## 참고  

https://www.codecademy.com/learn/learn-the-command-line


