# Learn the Command Line - manipulation  

![Manipulation](https://s3.amazonaws.com/codecademy-content/courses/learn-the-command-line/img/LCL-fileTrees-02.png)  

## ls, revisited  
```
$ ls                                                                                             
action  comedy  drama  genres.txt                                                                
$ ls -a                                                                                          
.  ..  .preferences  action  comedy  drama  genres.txt     
```  
**`ls`와 `ls -a`의 차이**  

1. `ls` 명령어는 working 디렉토리의 모든 파일과 디렉토리들의 목록을 보여준다.
2. `-a`는 `ls` 명령어의 동작을 수정해 파일들과 디렉토리 중에 `.`로 시작하는 것 또한 보여준다. 파일 중에 `.`로 시작하는 것들은 숨겨져 있고 `ls` 명령어만 사용해서는 보여지지 않는다.  

여기서 `-a`는 옵션이라고 부른다. 옵션들은 명령어들의 동작을 바꾼다.  
`ls` 명령어는 옵션이 몇가지 더 있다.  
- `-a` - 모든 내용물의 목록을 보여준다. (숨겨진 파일과 디렉토리)
- `-l` - 디렉토리의 자세한 내용도 출력한다. 
- `-t` - 가장 최근에 변경된 디렉토리 순으로 보여준다.  

## ls -l  

```
$ ls -l                                                                                          
total 12                                                                                         
drwxr-xr-x 4 ccuser ccuser 4096 Jul  8  2015 action                                              
drwxr-xr-x 4 ccuser ccuser 4096 Jul  8  2015 comedy                                              
drwxr-xr-x 4 ccuser ccuser 4096 Jul  8  2015 drama                                               
-rw-r--r-- 1 ccuser ccuser    0 Jul  8  2015 genres.txt
```

`-l` 옵션은 파일과 디렉토리의 리스트를 표 형식으로 보여준다. 
- 1. 접근 권한. 
- 2. 하드 링크의 수. 자식 디렉토리들과 파일들의 수를 보여준다. 이 숫자는 부모 디렉토리 링크(`..`)와 현재 디렉토리 링크(`.`)을 포함한다.  
- 3. 파일을 소유한 사용자의 이름. 여기서는 `cc`
- 4. 파일을 소유한 그룹명. 여기서는 `eng`
- 5. 파일의 사이즈를 byte로 표현
- 6. 파일이 최종적으로 변경된 시각을 표시
- 7. 파일 또는 디렉토리의 이름  

## ls -alt  
```                                                                                    
$ ls -alt                                                                                        
total 20                                                                                         
drwxr-xr-x 5 ccuser ccuser 4096 Mar  7 00:03 ..                                                  
drwxr-xr-x 4 ccuser ccuser 4096 Jul  8  2015 .                                                   
-rw-r--r-- 1 ccuser ccuser    0 Jul  8  2015 .gitignore                                          
drwxr-xr-x 2 ccuser ccuser 4096 Jul  8  2015 satire                                              
drwxr-xr-x 2 ccuser ccuser 4096 Jul  8  2015 slapstick                                           
-rw-r--r-- 1 ccuser ccuser   14 Jul  8  2015 the-office.txt 
```  
`-t` 옵션은 파일과 디렉토리를 마지막으로 변경된 시간 순으로 정렬한다.  

게다가 각 옵션을 개별적으로 사용하는 것 뿐만아니라 `ls -alt`처럼 함께 사용할 수도 있다.  


## cp  
```
cp frida.txt lincoln.txt
```
`cp` 명령어는 파일들 혹은 디렉토리들을 복사한다. 위 명령은 `frida.txt`의 내용을 `lincoln.txt`로 복사하는 것이다.  
파일을 디렉토리로 복사하기 위해서는 `cp` 명령어에 소스 파일을 첫 번째 인수로 그리고 목적지 디렉토리를 두 번째 인수로 지정한다. 
```
cp biopic/cleopatra.txt historical/
```
위 명령은 **biopic/cleopatra.txt** 파일을 **historical/** 디렉토리에 위치시킨다.  

```
cp biopic/ray.txt biopic/notorious.txt historical/
```
여러개의 파일을 디렉토리로 복사하려면 `cp` 명령어에 소스 파일 목록을 첫 번째 인수로, 그리고 목적지 디렉토리를 마지막 인수에 입력한다. 위 명령은 **biopic/ray.txt**와 **biopic/notorious.txt**를 **historical/** 디렉토리에 복사한다.   


## Wildcards  
```
cp * satire/
```
파일 이름을 인수로 상용하는 것 뿐만 아니라, 디렉토리 선택을 위해 `*`같은 특수문자를 사용할 수 있다. 위 명령을 보면 **satire/** 디렉토리에 있는 모든 파일들을 복사하는 것이다.   

```
cp m*.txt scifi/
```
`m*.txt`는 working 디렉토리에서 "m"으로 시작하고 ".txt"로 끝나는 모든 파일들을 선택한다. 그리고 **scifi/**로 복사한다.   


## mv  

`mv` 명령어는 파일들을 이동시킨다. `cp`와 사용법이 유사하다.  
파일을 디렉토리로 이동시키려면 `mv` 명령어를 사용해 소스 파일 이름을 첫 번째 인자로, 목적지 디렉토리를 두 번째 인자로 입력받는다. 다음은 **superman.txt**를 **superhero/**로 이동시키는 명령이다.  
```
mv superman.txt superhero/
```

여러개의 파일과 디렉토리를 이동시키려면, `mv`명령의 첫번째 인자로 복사할 파일 이름을 넣고, 목적지 디렉토리를 마지막 인자로 입력받는다. 아래 명령은 **wonderwoman.txt**와 **batman.txt**를 **superhero/**로 이동시킨다.  
```
mv wonderwoman.txt batman.txt superhero/  
```  

파일 이름을 변경할 때도 `mv`를 사용한다. 원래 이름을 첫 번째 인자로, 새로운 이름을 두 번째 인자로 받는다. 
```
mv batman.txt spiderman.txt
```


## rm

`rm` 명령어는 파일과 디렉토리를 삭제한다.  command deletes files and directories. 아래 명령은 파일 시스템에서 **watery.txt**를 삭제하는 것이다. 
```
rm waterboy.txt
```  
`-r` 옵션은 "recursive"를 의미한다. 디렉토리를 삭제하고 그 밑의 모든 자식 디렉토리들 또한 삭제한다.  
```
rm -r comedy
```
`rm` 명령은 되돌릴 방법이 없기 때문에 사용할 때 신중해야 한다! 
