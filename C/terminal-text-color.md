# 터미널에서 텍스트 색상 입히기   

```c
#include <stdio.h>

int main(void)
{
    for (int i = 0; i < 110; ++i) {
        // \033[스타일_번호m 스타일 시작
        printf("%3d --> \033[%dm%s\033[0m\n", i, i, "Text");
        // \033[0m 스타일 끝. 스타일을 끝내지 않으면 이후의 출력들도 앞서 지정한 스타일로 출력된다.
    }
}
```  

![example](https://dl.dropboxusercontent.com/s/1qhm7z143wktoxy/CF8B4CD6-7640-42C7-ACC1-49560DACF666-1702-00003FE289FD7D09.gif?dl=0)
