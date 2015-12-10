# 버퍼 오버플로우  

## 버퍼 오버플로우(Buffer Overflow) 공격의 개념 
- 버퍼: 데이터를 한 곳에서 다른 곳으로 전송하는 동안 일시에 보관하는 메모리의 영역  
- 항상 일정한 크기를 가지고, 이 '일정 크기'를 넘는 데이터가 입력되는 현상이 **버퍼 오버플로우**  
- **버퍼 오버플로우: 버퍼에 일정 크기 이상의 데이터를 입력하여 프로그램을 공격하는 행위**  
- 버퍼는 스택(Stack)과 힙(Heap)에 존재할 수 있다. 
- 따라서 스택에 존재하는 버퍼에 대한 공격인가 힙에 존재하는 버퍼에 대한 공격인가에 따라 스택 버퍼 오버플로우와 힙 버퍼 오버플로우로 구분  

## 스택 버퍼 오버플로우 공격  
- 난이도가 높은 해킹 공격  
- 모든 경우에 가능하지 않고 프로그래머가 취약한 특정 함수를 사용해야 가능  
- 입력 값을 확인하지 않는 입력 함수에 정상적인 크기보다 큰 입력 값을 입력해 ret 값을 덮어씌움으로써 임의의 코드를 실행하는 공격  
- bugfile.c  
  ```
  #include <stdio.h>
  
  int main(int argc, char *argv[]) {
        char buffer[10];
        strcpy(buffer, argv[1]);
        printf("%s\n", &buffer);
  }
  ```
  - 실제 스택 버퍼 오버플로우 공격은 `strcpy` 함수에서 일어남. 
  
## 힙 버퍼 오버플로우 공격  
- 힙(Heap): 프로그램을 실행할 때 동적으로 할당한 메모리 공간. malloc 계열의 heapalloc, aeapfree, malloc, free, new, delete 등의 함수로 제어, BBS(Block Started by Symbol)라고도 부른다.   
- 스택과 반대로 메모리의 하위 주소에서 상위 주소로 영역이 커진다.  
![80x86 시스템의 메모리 구조](https://ejrtmtm2.files.wordpress.com/2013/04/9.png?w=529)  
- 힙 영역에 대한 버퍼 오버플로우 공격의 기본은 관리자 권한을 이용한 데이터 변조  
- 힙 영역에 임의의 값을 입력할 수 있는 취약점이 있다.  
  
  
### 버퍼 오버플로우에 대한 대책과 발전된 공격  
  
#### 안전한 함수 사용  
- 버퍼 오버플로우 공격에 대한 대응 중 가장 쉽고 효과적이면서 확실한 방법은 버퍼 오버플로우에 취약한 함수를 사용하지 않는 것  
- 버퍼 오버플로우 공격에 취약한 함수  
  - `strcpy(char *dest, const char *src)`  
  - `strcat(char *dest, const char *src)`  
  - `getwd(char *buf)`  
  - `gets(char *s)`  
  - `fscanf(FILE *stream, const char *forma, ...)`
  - `scanf(const char *format, ...)`  
  - `realpath(char *path, char resolved_path[])`  
  - `sprintf(char *str, const char *format)`  

#### Non-Executable 스택  
- 스택 버퍼 오버플로우에서 eggshell이라는 셸을 스택에 올린 뒤, 해당 주소로 ret 주소를 위조해 이를 실행했다.  
- Non-Executable Stack은 이러한 공격 패턴을 보고 스택에서 프로그램 실행을 할 수 없게 한다.  

#### rtl 공격  
- Non-Executable Stack에 대한 해커의 대응책은 rtl(return to libc)이다.  
- rtl은 스택에 있는 ret 주소를 실행 가능한 임의의 주소(libc 영역의 주소)로 돌려 원하는 함수를 수행하게 만드는 기법  

#### 스택 가드  
- 버퍼 오버플로우 방어 기술   
- 프로그램 실행 시 버퍼 오버플로우 공격을 탐지하도록 gcc 컴파일러의 확장으로 만들어짐.  
- 컴파일러가 프로그램의 함수 호출 시에 ret 앞에 canary(밀고자) 값을 주입하고, 종료(return) 시에 canary 값이 변조되었는지의 여부를 확인해 버퍼 오버플로우 공격을 탐지  

#### 스택 쉴드  
- gcc 컴파일러 확장으로 개발, ret 보호가 주목적  
- 함수 호출 시 ret를 Global RET 스택이라는 특수 스택에 저장하고 함수의 종료 시 Global RET 스택에 저장된 ret 값과 스택의 ret 값을 비교하여 일치하지 않으면 프로그램 종료  

#### ASLR   
- 메모리 공격을 방어하기 위해 주소 공간 배치를 난수화하는 기법  
- 스택, 힙, 라이브러리 등의 데이터 영역 주소 등을 난수화해 프로세스의 주소 공간에 배치  

