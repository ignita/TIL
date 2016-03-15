# 도전 프로그래밍3  

3는 어렵다고 해서 기록을 남겨본다.  

## 도전1  

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




