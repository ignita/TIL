# 도전 프로그래밍3  

3는 어렵다고 해서 기록을 남겨본다.  

## 도전 1  

배열 90도 씩 회전하기  
```
  1   2   3   4 
  5   6   7   8 
  9  10  11  12 
 13  14  15  16 

 13   9   5   1 
 14  10   6   2 
 15  11   7   3 
 16  12   8   4 

 16  15  14  13 
 12  11  10   9 
  8   7   6   5 
  4   3   2   1 

  4   8  12  16 
  3   7  11  15 
  2   6  10  14 
  1   5   9  13 
```
```c
#include <stdio.h>

int RotateArray(int (*array)[4], int column);
int ShowArray(int (*array)[4], int column);

int main(void)
{
    int arr[4][4] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };

    ShowArray(arr, sizeof(arr)/sizeof(arr[0]));

    RotateArray(arr, sizeof(arr)/sizeof(arr[0]));
    ShowArray(arr, sizeof(arr)/sizeof(arr[0]));

    RotateArray(arr, sizeof(arr)/sizeof(arr[0]));
    ShowArray(arr, sizeof(arr)/sizeof(arr[0]));

    RotateArray(arr, sizeof(arr)/sizeof(arr[0]));
    ShowArray(arr, sizeof(arr)/sizeof(arr[0]));


    return 0;
}

int RotateArray(int (*array)[4], int column)
{
    int temp_array[4][4];

    int i, j;
    for(i=0; i<4; i++)
    {
        for(j=0; j<column; j++)
        {
            if(i == 0)
                temp_array[j][3] = array[i][j];
            else if(i == 1)
                temp_array[j][2] = array[i][j];
            else if(i == 2)
                temp_array[j][1] = array[i][j];
            else if(i == 3)
                temp_array[j][0] = array[i][j];
        }
    }

    for(i=0; i<4; i++)
    {
        for(j=0; j<column; j++)
        {
            array[i][j] = temp_array[i][j];
        }
    }

}

int ShowArray(int (*array)[4], int column)
{
    int i,j;
    for(i=0; i<4; i++)
    {
        for(j=0; j<column; j++)
        {
            printf("%3d ", array[i][j]);
        }
        printf("\n");
    }
    printf("\n");

}
```

```c
    ShowArray(arr, sizeof(arr)/sizeof(arr[0]));

    RotateArray(arr, sizeof(arr)/sizeof(arr[0]));
    ShowArray(arr, sizeof(arr)/sizeof(arr[0]));

    RotateArray(arr, sizeof(arr)/sizeof(arr[0]));
    ShowArray(arr, sizeof(arr)/sizeof(arr[0]));

    RotateArray(arr, sizeof(arr)/sizeof(arr[0]));
    ShowArray(arr, sizeof(arr)/sizeof(arr[0]));
```
이 부분은 다음과 같이 for를 이용해 줄일 수 있다.  
```c
for(int i=0; i<4; i++)
    {
        ShowArray(arr, sizeof(arr)/sizeof(arr[0]));
        RotateArray(arr, sizeof(arr)/sizeof(arr[0]));
    }
```
그리고 `sizeof(arr)/sizeof(arr[0]));` 이 부분은 굳이 넣지 않아도 되었다. 이 문제에서만 한정한다면...   
```c
if(i == 0)
    temp_array[j][i+3] = array[i][j];
else if(i == 1)
    temp_array[j][i+1] = array[i][j];
else if(i == 2)
    temp_array[j][i-1] = array[i][j];
else if(i == 3)
    temp_array[j][i-3] = array[i][j];
```
이 부분은 다음과 같이  
```c
if(i == 0)
    temp_array[j][3] = array[i][j];
else if(i == 1)
    temp_array[j][2] = array[i][j];
else if(i == 2)
    temp_array[j][1] = array[i][j];
else if(i == 3)
    temp_array[j][0] = array[i][j];
```
결국엔 다음과 같이 한 줄로 줄일 수 있었다. 나는 정말 머리가 안 돌아간다... 
```c
temp_array[j][3-i] = array[i][j];
```


## 도전 2  


## 도전 3  
난수(Random Number)란, 임의의, 정해지지 않은, 무엇이 될지 모르는 수. ANSI 표준에서 난수를 생성할 때 호출할 수 있는 다음 함수를 제공한다.  
```c
#include <stdlib.h>
int rand(void); 
```

### 사용법  

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int i;
    printf("난수의 범위 0부터 %d까지 \n", RAND_MAX);
    for(i=0; i<5; i++)
        printf("난수 출력: %d \n", rand());
    return 0;
}
```

`RAND_MAX` 생성될 수 있는 난수의 최댓값  

### 문제  
0이상 99이하의 난수 총 5개를 생성하는 프로그램 작성  
```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int i;
    printf("난수의 범위 0부터 99까지 난수 5개 출력\n");

    for(i=0; i<5; i++)
        printf("난수 출력: %d \n", rand() % 100);
    
    return 0;
}
```

## 도전 4  
 
`rand` 함수가 반환하는 난수는 몇 번을 실행해도 값이 그대로 출력된다. 그래서 **의사 난수(pseudo-random number)**라고 한다. 의사 난수는 가짜 난수를 의미한다. 그래서 ANSI표준에서는 이러한 문제를 어느정도 해결할 수 있도록 `srand`라는 함수를 정의하였다.  
```c
#include <stdlib.h>
void srand(unsigned int seed);
```
`srand`함수는 난수를 생성하는데 필요한 씨앗 값을 받는다. 이 값을 씨드(seed) 값이라고 한다. 씨드 값이 무엇이냐에 따라 `rand`함수가 반환하는 난수의 형태가 달라진다.  

```c
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int seed, i;
    printf("씨드 값 입력: ");
    scanf("%d", &seed);
    srand(seed);    // 씨앗을 심는다

    for(i=0; i<5; i++)
        printf("정수 출력 : %d \n", rand());    // 열매를 수확한다
    return 0;
}
```  
```
씨드 값 입력: 14
정수 출력 : 235298 
정수 출력 : 1807169839 
정수 출력 : 1242264552 
정수 출력 : 904309330 
정수 출력 : 985139491 
```   

하지만 프로그램 실행시 매번 씨드 값을 입력받을 수는 없을 것이다. 그리고 입력받는다고 해도 매번 다른 값을 입력받는 다는 가정을 세우는 것도 힘들다. 그래서 시스템 시간을 이용하는 방법이 있다. **time.h** 헤더 파일에 선언되어 있는 `time`이라는 함수로 컴퓨터 시스템의 현재시간과 1970년 1월 1일 이후의 시간적 차이를 초단위로 계산해서 반환해 준다.   

```c
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void)
{
    int i;
    srand((int)time(NULL));     // 현재시간을 이용해서 씨드 설정
    for(i=0; i<5; i++)
        printf("정수 출력: %d \n", rand());
    return 0;
}
```  
단순히 시간 정보를 반환 받는 것이 목적이라면 NULL을 전달하면 된다.  

### 문제  
주사위를 두 개 던졌을 때의 결과를 출력하는 프로그램 작성  

실행 예
```
주사위 1의 결과 2
주사위 2의 결과 6
```
```c
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void)
{
    srand((int)time(NULL));

    printf("주사위 1의 결과 %d \n", rand()%6 + 1);
    printf("주사위 2의 결과 %d", rand()%6 + 1);
    return 0;
}
```


