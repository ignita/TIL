# 다차원 배열과 포인터의 관계  

## 2차원 배열이름의 포인터 형  

```c
#include <stdio.h>

int main(void)
{
    int arr2d[3][3];
    printf("%d \n", arr2d);
    printf("%d \n", arr2d[0]);
    printf("%d \n\n", &arr2d[0][0]);

    printf("%d \n", arr2d[1]);
    printf("%d \n\n", &arr2d[1][0]);

    printf("%d \n", arr2d[2]);
    printf("%d \n", &arr2d[2][0]);

    printf("sizeof(arr2d): %d \n", sizeof(arr2d));
    printf("sizeof(arr2d[0]): %d \n", sizeof(arr2d[0]));
    printf("sizeof(arr2d[1]): %d \n", sizeof(arr2d[1]));
    printf("sizeof(arr2d[2]): %d \n", sizeof(arr2d[2]));
    return 0;
}
```
```
1386507056 
1386507056 
1386507056 

1386507068 
1386507068 

1386507080 
1386507080 
sizeof(arr2d): 36 
sizeof(arr2d[0]): 12 
sizeof(arr2d[1]): 12 
sizeof(arr2d[2]): 12 
```
arr2d는 첫 번째 요소를 가리키면서 배열 전체를 의미하지만 arr2d[0]은 첫 번째 요소를 가리키되 1행만을 의미한다. 그래서 sizeof 연산의 결과가 다른 것이다. 즉, arr2d와 arr2d[0]은 서로 다른 것이다.  


가리키는 대상이 int형 변수이면서 포인터 연산 시 sizeof(int)x4의 크기 단위로 증가 및 감소하는 포인터 변수 ptr은 다음과 같이 선언  
```c
int (*ptr) [4];
```    

## 2차원 배열이름의 특성과 주의사항  

### '배열 포인터'와 '포인터 배열'  

```c
int * whoA [4];    // 포인터 배열
int (*whoB) [4];   // 배열 포인터  
```

```c
#include <stdio.h>

int main(void)
{
    int num1 = 10, num2 = 20, num3 = 30, num4 = 40;
    int arr2d[2][4] = {1, 2, 3, 4, 5, 6, 7, 8};
    int i, j;

    int * whoA[4] = {&num1, &num2, &num3, &num4};   // 포인터 배열
    int (*whoB)[4] = arr2d;     // 배열 포인터

    printf("%d %d %d %d \n", *whoA[0], *whoA[1], *whoA[2], *whoA[3]);
    for(i=0; i<2; i++)
    {
        for(j=0; j<4; j++)
            printf("%d ", whoB[i][j]);
        printf("\n");
    }
    return 0;
}
```

```
10 20 30 40 
1 2 3 4 
5 6 7 8 
```
whoA는 int형 포인터 변수로 이뤄진 int형 포인터 배열,  
whoB는 가로길이가 4인 int형 2차원 배열을 가리키는 용도의 포인터 변수  

```c
#include <stdio.h>

void ShowArr2DStyle(int (*arr)[4], int column)  // 배열요소 전체출력
{
    int i, j;
    for(i=0; i<column; i++)
    {
        for(j=0; j<4; j++)
            printf("%d ", arr[i][j]);
        printf("\n");
    }
    printf("\n");
}

int Sum2DArr(int arr[][4], int column)      // 배열요소의 합 반환
{
    int i, j, sum = 0;
    for(i=0; i<column; i++)
        for(j=0; j<4; j++)
            sum += arr[i][j];
    return sum;
}

int main(void)
{
    int arr1[2][4] = {1, 2, 3, 4, 5, 6, 7, 8};
    int arr2[3][4] = {1, 1, 1, 1, 3, 3, 3, 3, 5, 5, 5, 5};

    ShowArr2DStyle(arr1, sizeof(arr1)/sizeof(arr1[0]));
    ShowArr2DStyle(arr2, sizeof(arr2)/sizeof(arr2[0]));
    printf("arr1의 합: %d \n", Sum2DArr(arr1, sizeof(arr1)/sizeof(arr1[0])));
    printf("arr2의 합: %d \n", Sum2DArr(arr2, sizeof(arr2)/sizeof(arr2[0])));
    return 0;
}
```

```
1 2 3 4 
5 6 7 8 

1 1 1 1 
3 3 3 3 
5 5 5 5 

arr1의 합: 36 
arr2의 합: 36 
```

sizof(arr1)과 sizeof(arr2)의 반환 값은 배열의 전체 크기이고, sizof(arr1[0])와 sizeof(arr2[0])의 반환 값은 배열의 가로 크기 이므로 나누면 배열의 세로 길이가 나오게 된다.  
```c
sizeof(arr1) / sizeof(arr1[0])
sizeof(arr2) / sizeof(arr2[0])
```  

### 2차원 배열에서도 arr[i]와 *(arr+i)는 같다.  

배열과 포인터의 관계에서 다음식이 성립했는데 다차원 배열에서도 성립이 가능하다.  
```c
arr[i] == *(arr+i)   // arr[i]는 *(arr+i)와 같다.
```  

2차원 배열이 다음과 같이 있다. 그리고 인덱스 [2][1]에 있는 값을 4로 변경하기 위해선 2번째 줄의 문장을 실행해야 한다.  
```c
arr[3][2] = { {1, 2}, {3, 4}, {5, 6} };
arr[2][1] = 4;
```  
이는 다음 문장들로 대신할 수 있다.  
```c
(*(arr+2))[1] = 4; 
*(arr[2]+1) = 4;
*(*(arr+2)+1) = 4;
```
첫 번째 식은 arr[2]를 *(arr+2)로 바꿈으로써 구할 수 있다. 그리고 두 번째 식은 치환이 필요하다. arr[2][1]에서 arr[2]를 A로 치환하면 다음과 같아 변환이 된다.  
```c
A[1] = 4; → *(A+1) = 4;
```
여기서 A를 원래대로 되돌리면 *(arr[2]+1)=4가 된다. 마지막 식은 두 번째 식에서 arr[2]를 *(arr+2)로 바꾸면 가능하다.  

```c
#include <stdio.h>

int main(void)
{
    int a[3][2] = {{1, 2}, {3, 4}, {5, 6}};

    printf("a[0]: %p \n", a[0]);
    printf("*(a+0): %p \n", *(a+0));

    printf("a[1]: %p \n", a[1]);
    printf("*(a+1): %p \n", *(a+1));

    printf("a[2]: %p \n", a[2]);
    printf("*(a+2): %p \n", *(a+2));

    printf("%d, %d \n", a[2][1], (*(a+2))[1]);
    printf("%d, %d \n", a[2][1], *(a[2]+1));
    printf("%d, %d \n", a[2][1], *(*(a+2)+1));
}
```
```
a[0]: 0x7fff54952b40 
*(a+0): 0x7fff54952b40 
a[1]: 0x7fff54952b48 
*(a+1): 0x7fff54952b48 
a[2]: 0x7fff54952b50 
*(a+2): 0x7fff54952b50 
6, 6 
6, 6 
6, 6 
```
성립을 확인   

```c
#include <stdio.h>

int main(void)
{
    int * arr1[5];
    int * arr2[3][5];

    int ** ptr1 = arr1;
    int * (*ptr2)[5] = arr2;

}
```