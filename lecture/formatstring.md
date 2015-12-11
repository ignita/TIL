# 포맷 스트링  

## 포맷 스트링 공격  

- formatstring.c  
  ```
  #include <stdio.h>  
  
  main(){  
       char *buffer = "wishfree";  
       printf("%s\n", buffer);  
  }
  ```
- 일반적으로 위와 같이 buffer에 저장된 문자열을 printf 함수를 이용해 출력한다.  
- 사용자로부터 입력을 받아들이거나 결과를 출력하기 위해 사용하는 형식  
- 위 코드에서 사용된 `%s`와 같은 문자열을 가리켜 **포맷 스트링**이라고 한다.  
- 하지만 `printf("%x")`처럼 변수 없이 사용하게 되면 메모리의 값들을 순서대로 출력하게 되어 메모리 구조를 파악하는데 악용될 수 있음  
- %n 이나 %hn을 이용하면 특정 메모리 위치의 값을 다른 것으로 변경할 수도 있음  
- 포맷 스트링 사용시의 오류를 이용해 시스템의 권한을 획득하는 기법을 **포맷 스트링 공격**이라고 한다.  

## 포맷 스트링 공격에 대한 대응책  
- printf함수를 다음과 같이 정상적으로 사용하면 문제가 생기지 않는다.  
  `printf("%s\n", buffer);`  
- 포맷 스트링 공격 취약점을 가진 함수  
  - 포맷 스트링 공격에 대응하기 위해 사용하지 말아야 한다.  
  - fprintf(fp, 서식 문자열, 인자1, ..., 인자N) 함수  
    fprintf 함수는 결과를 표준 출력으로 출력하지 않고 해당 파일로 출력한다는 점이 printf함수와 다르다. fp는 파일에 대한 포인터 값  
    사용 예)  
    ```  
    fp = fopen("/dev/null", "w"); // 파일을 쓰기 모드로 오픈  
    fprintf(fp, "decimal=%d octal=%o", 123,123);  
    ```  
  - sprintf(char *str, const char *fmt,...) 함수  
    sprintf 함수도 결과를 표준 출력으로 출력하지 않고 문자열로 출력한다.  
    사용 예)  
    ```
    a = sprintf("decimal = %d octal = %o", 123,123);  
    printf("   ", a);  
    ```  
    출력  
    `decimal = 123 octal = 173`  
  - snprintf(char *str, size_t count, const char *fmt, ...) 함수  
    snprintf 함수가 springf 함수와 다른 점은 복사될 문자열의 크기를 지정할 수 있다는 점.  
- 시스템 패치를 꾸준히 해주는 것  
