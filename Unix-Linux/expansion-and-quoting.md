# 확장과 인용  

- `echo` - 텍스트 라인 표시하기  

## 확장  
- * 기호처럼 쉘에 여러 의미를 주는 경우에 단순히 연속된 문자열로 처리되는 것과 같은 몇 가지 경우를 **확장**이라 한다.  
 - 확장으로 인해 쉘은 무엇이 입력되든 그것이 처리되기 전에 무언가로 확장된다.  

```
[me@linuxbox ~]$ echo this is a test  
this is a test  
```  
```
[me@linuxbox ~]$ echo *  
Desktop Documents ls-output.txt Music Pictures Public Templates Videos  
```
- echo 명령이 실행되기 전에 * 기호를 다른 무언가로 확장시킨 것. 여기서는 디렉토리에 있는 모든 디렉토리의 이름으로 확장   
- 엔터키를 눌렀을 때, 쉘은 자동적으로 명령어가 실행되기 직전에 모든 한정 문자들을 확장. 위는 * 기호 그자체가 아닌 확장된 결과만 보여줌.   

### 경로명 확장  
- 와일드카드로 동작하는 방식을 **경로명 확장**이라고 함  
- 다음과 같은 홈 디렉토리가 있다면, 
```
dev@ubuntu-machine:~$ ls
Desktop    example           ls-error.txt   Music     Templates
Documents  examples.desktop  ls-output.txt  Pictures  Videos
Downloads  lazy_dog.txt      ls.txt         Public
```
- 다음과 같이 확장을 실행할 수 있다.  
```
dev@ubuntu-machine:~$ echo D*
Desktop Documents Downloads
```
```
dev@ubuntu-machine:~$ echo *s
Documents Downloads Pictures Templates Videos
```
```
dev@ubuntu-machine:~$ echo [[:upper:]]*
Desktop Documents Downloads Music Pictures Public Templates Videos
```

> 숨김 파일의 경로명 확장   
`echo *`로 숨김 파일을 가져올 수 없다. `echo .*`도 마찬가지이다. 파일에 .과 ..이 포함된 파일. 즉 현재 작업 디렉토리와 상위 디렉토리이기 때문에 정확한 결과가 나오지 않는다. `ls -d .[!.]?*`는 마침표로 시작하는 모든 파일명으로 확장시키고, 두 번째 마침표는 포함하지 않고 추가로 하나 이상의 문자가 있고 그 뒤로 어느 문자든 올 수 있다는 의미이다.  

### 틸드(~) 확장  
- ~(물결표) 기호가 맨 앞에 있으면 지정된 사용자의 홈 디렉토리명을 나타내고, 이름을 정하지 않으면 현재 사용자의 홈 디렉토리명을 나타낸다.  
```
[me@linuxbox ~]$ echo ~
/home/me
```

### 산술 확장  
- 쉘에서는 산술식 확장도 가능, 쉘 프롬프트를 계산기처럼 사용이 가능   
```
[me@linuxbox ~]$ echo $((2 + 2))
4
```
- 다음과 같은 형태로 산술 확장을 표현  
```
$((expression))
```
- 공백은 중요하지 않고 중첩이 가능하다.  
```
[me@linuxbox ~]$ echo $(($((5**2)) * 3))
75
```    
- 위 예를 하나의 확장만을 사용해 똑같은 결과를 얻을 수도 있다.  
```
[me@linuxbox ~]$ echo $((5**2)) * 3))
75
```

### 중괄호 확장  
- 중괄호 안에 표현된 패턴과 일치하는 다양한 텍스트 문자열을 만들 수 있다.  
```
[me@linuxbox ~]$ echo Front-{A,B,C}-Back
Front-A-Back Front-B-Back Front-C-Back
```
- **프리앰블(preamble)**이라고 부르는 앞부분과 **포스트스크립트(postscript)**라는 끝부분을 가진다. 빈칸은 허용 x  
- 정수 범위 표현도 가능  
```
[me@linuxbox ~]$ echo Number_{1..5}
Number_1 Number_2 Number_3 Number_4 Number_5
```  
- 알파벳 역순  
```
[me@linuxbox ~]$ echo {Z..A}
Z Y X W V U T S R Q P O N M L K J I H G F E D C B A
```
- 중첩도 가능하다.  
- 어디에 사용할까?  
 - 예를 들어 사진을 정리하려고 연도별 혹은 월별로 정리 디렉토리를 만들고 시간 순서로 정하려면 양도 방대하고, 시간도 걸린다. 그래서 다음과 같이 할  수 있다.  
 ```
MACBOOKPRO-D499:~ ox$ mkdir Pics
MACBOOKPRO-D499:~ ox$ cd Pics/
MACBOOKPRO-D499:Pics ox$ mkdir {2013..2016}-0{1..9} {2013..2016}-1{0..2}
MACBOOKPRO-D499:Pics ox$ ls
2013-01	2013-06	2013-11	2014-04	2014-09	2015-02	2015-07	2015-12	2016-05	2016-10
2013-02	2013-07	2013-12	2014-05	2014-10	2015-03	2015-08	2016-01	2016-06	2016-11
2013-03	2013-08	2014-01	2014-06	2014-11	2015-04	2015-09	2016-02	2016-07	2016-12
2013-04	2013-09	2014-02	2014-07	2014-12	2015-05	2015-10	2016-03	2016-08
2013-05	2013-10	2014-03	2014-08	2015-01	2015-06	2015-11	2016-04	2016-09
 ```  

### 매개변수 확장  

- USER라는 변수는 사용자명을 가지고 있는데 매개변수 확장으로 USER의 내용을 볼 수 있다.  
```
[me@linuxbox ~]$ echo $USER
me
```
- 사용 가능한 변수 목록을 보려면 다음과 같이 입력  
```
[me@linuxbox ~]$ printenv | less
```  

- 다른 형식의 확장과 함께 사용할 경우 패턴을 잘못 입력하면 그 확장은 작동하지 않고 echo 명령은 단순히 잘못된 패턴을 출력한다. 매개변수 확장으로는 변수를 잘못 입력하면 확장은 수행되지만 빈 문자열을 반환한다.   

### 명령어 치환  
- 명령어의 출력 결과를 확장으로 사용할 수 있다.  
```
[me@linuxbox ~]$ echo $(ls)
```   
- 다음과 같이 입력하면 ls 명령어의 인자로 which cp의 결과를 사용했음을 알 수 있다.  
```
[me@linuxbox ~]$ ls -l $(which cp)
```  

## 따옴표 활용(Quoting)

- 쉘은 echo명령어의 인자에서 불필요한 공백을 삭제하여 단어 분할을 한다. 
```
[me@linuxbox ~]$ echo this is a    test
this is a test
```  
- 또 매개변수 확장으로 정의되지 않은 변수로 처리된 $1이 빈 문자열로 치환된다. 그래서 따옴표 기호를 활용하는 기능(Quoting)을 제공한다.  
```
[me@linuxbox ~]$ echo The total is $100.00
The total is 00.00
```

### 쌍 따옴표 기호  
- 쌍 따옴표 기호를 사용하면 쉘에서 사용하는 모든 특수한 기호들이 가진 의미가 없어지고 대신 일반적인 문자로 인식  
- 단, $, \, ' 기호는 예외  
- 즉 단어 분할, 경로명 확장, 틸드 확장, 괄호 확장은 숨겨도 매개변수 확장, 산술 확장, 명령어 치환은 그대로 실행  
- 쌍 따옴표로 파일명에 있는 공백 문제를 해결  
```
[me@linuxbox ~]$ ls -l two words.txt
ls: two: No such file or directory
ls: words.txt: No such file or directory
```  
```
[me@linuxbox ~]$ ls -l "two words.txt"
```
- `two_words.txt`를 이용하면 귀찮게 쌍 따옴표를 입력할 필요가 없다.  
- 매개변수 확장, 산술 확장, 명령어 치환 시에는 쌍 따옴표 안에서도 그 작업을 그대로 수행   

### 따옴표 기호  
- 확장을 숨기기. 따옴표 없이, 따옴표, 쌍 따옴표 사용 결과는 다음과 같다.  
```
[me@linuxbox ~]$ MACBOOKPRO-D499:~ ox$ echo text ~/*.txt {a,b} $(echo foo) $((2+2)) $USER
text /home/me/ls-output.txt a b foo 4 me
[me@linuxbox ~]$ echo "text ~/*.txt {a,b} $(echo foo) $((2+2)) $USER"
text ~/*.txt {a,b} foo 4 me
[me@linuxbox ~]$ echo 'text ~/*.txt {a,b} $(echo foo) $((2+2)) $USER'
text ~/*.txt {a,b} $(echo foo) $((2+2)) $USER
```
- 따옴표 기호가 늘어나면서 확장이 점점 없어진다.  

### 이스케이프 문자  

- 하나의 문자를 인용하고 싶을 때, 이를 위해 해당 문자 앞에 백슬래시를 추가하는 것을 **이스케이프 문자(escape character)**라고 부른다.  
```
[me@linuxbox ~]$ echo "The balance for user $USER is: \$5.00"
The balance for user me is: $5.00
```  
- 파일명에 어떤 문자가 가지고 있는 특별한 의미를 없애고 싶을 때 흔히 사용. 문자 중에는 $, !, &, (공백) 등 여러 가지가 있음  
- 백슬래시 기호를 표시하고 싶다면 `\\`을 입력  

**백슬래시 확장 문자열** 

| 확장 문자열 | 뜻 |
| --- | --- |
| `\a` | 벨("알림" - 컴퓨터에서 알림소리 발생) |
| `\b` | 백스페이스 |
| `\n` | 새 줄(유닉스와 같은 시스템에서는 리인피드를 생성) |
| `\r` | 캐리지 리턴 |
| `\t` | 탭 |   
- 백슬래시 개념은 원래 C언어에서 유래  
- echo에 -e 옵션을 붙여 사용하면 이스케이프 문자를 해석  
```
sleep 10; echo -e "Time's up\a"  
sleep 10; echo "Time's up" $'\a'
```