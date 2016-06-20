# 시스템 살펴보기  

- `ls` - 디렉토리 내용 나열하기  
- `file` - 파일 타입 확인하기  
- `less` - 파일 내용 표시하기   

## ls 명령어  

- 좀 더 자세한 속성까지 확인하려면 `-l` 옵션을 사용  

### 명령어 옵션과 명령 인자  

- 명령어는 주로 하나 이상의 **옵션**과 **명령인자**들과 함께 사용되는 데 보다 구체적으로 실행할 수 있도록 도와줌  
```  
명령어 -옵션 명령인자  
```  
- **long 옵션**도 제공 - --(대시 대시) 기호를 선행하여 쓴다.  
- 예) `--reverse` 옵션을 사용해 정렬 결과를 역순으로 볼 수 있다.  
```bash
[me@linuxbox ~]$ ls -lt --reverse
```  
- [ls 명령어 옵션](http://linuxcommand.org/man_pages/ls1.html)   

## file 명령어로 파일 타입 확인  

```
file filename
```  

```bash
[me@linuxbox ~]$ file dog.png 
dog.png: PNG image data, 64 x 64, 8-bit/color RGBA, non-interlaced
```   

## less 명령어로 파일 정보 보기  
- `less` 명령어는 텍스트 파일을 볼 때 사용하는 프로그램  
- 환경설정 파일, 스크립트 등은 텍스트 파일로 저장된다.  
```
less filename
```
- [less 명령키](http://www.pixelbeat.org/lkdb/less.html)   

> `less` 프로그램은 `more`라고 불리던 초기 유닉스 프로그램의 확장판으로 설계된 것이다. `less`라는 이름은 "less is more"(단순할수록 풍부해진다)라는 근대 건축 설계자의 모토에서 따온 것  


## 함께 탐험해보자!  

- 현재 디렉토리에서 `cd` 명령을 실행한 후,
- `ls -l` 명령어로 디렉토리 내용을 보자.  
- 흥미로워 보이는 파일이 있다면 `file` 명령어로 파일 정보를 확인하고,
- 텍스트 파일이라면 `less` 명령을 실행해 파일을 열어보자.  

무엇이든 열어서 확인하는 것을 두려워하지말자. 리눅스는 일반 사용자들은 시스템을 망치지 못하도록 강력히 제한되어 있다!  


