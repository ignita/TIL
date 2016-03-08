# 포인터의 포인터

포인터의 포인터는 포인터 변수를 가리키는 또 다른 포잉ㄴ터 변수를 뜻하는 것.  
흔히 '이중 포인터' 또는 '더블 포인터'라 부르며, 포인터 변수 선언은 다음과 같이 * 연산자를 두 개 이어서 선언한다.  
```c
int ** dptr;    // int형 이중 포인터
```

```c
#include <stdio.h>

int main(void)
{
    double num = 3.14;
    double *ptr = &num;
    double **dptr = &ptr;
    double *ptr2;

    printf("%9p %9p \n", ptr, *dptr);
    printf("%9g %9g \n", num, **dptr);
    ptr2 = *dptr;
    *ptr2 = 10.99;
    printf("%9g %9g \n", num, **dptr);
    return 0;
}
```

## 포인터 변수 대상의 Call-by-reference  

```c
#include <stdio.h>

void SwapIntPtr(int **dp1, int **dp2)
{
    int *temp = *dp1;
    *dp1 = *dp2;
    *dp2 = temp;
}

int main(void)
{
    int num1 = 10, num2 = 20;
    int *ptr1, *ptr2;
    ptr1 = &num1, ptr2 = &num2;
    printf("*ptr1, *ptr2: %d %d \n", *ptr1, *ptr2);

    SwapIntPtr(&ptr1, &ptr2);
    printf("*ptr1, *ptr2: %d %d \n", *ptr1, *ptr2);
    return 0;
}
```  

## 포인터 배열과 포인터 배열의 포인터 형  

```c
#include <stdio.h>

int main(void)
{
    int num1 = 10, num2 = 20, num3 = 30;
    int *ptr1 = &num1;
    int *ptr2 = &num2;
    int *ptr3 = &num3;

    int * ptrArr[] = {ptr1, ptr2, ptr3};
    int ** dptr = ptrArr;

    printf("%d %d %d \n", *(ptrArr[0]), *(ptrArr[1]), *(ptrArr[2]));
    printf("%d %d %d \n", *(dptr[0]), *(dptr[1]), *(dptr[2]));
    return 0;
}
```
```
10 20 30
10 20 30
```  

## 이중 포인터를 가리키는 삼중 포인터   

삼중 포인터는 이중 포인터 변수를 가리킨다. 이중 포인터 변수의 주소 값을 저장하는 용도로 사용  

```c
#include <stdio.h>

int main(void)
{
    int num = 100;
    int *ptr = &num;
    int **dptr = &ptr;
    int ***tptr = &dptr;

    printf("%d %d \n", **dptr, ***tptr);
    return 0;
}
```
```
100 100
```

삼중 포인터는 잘 사용하지 않는다. 삼중 포인터가 필요하게 된다면 포인터의 오용 및 남용은 아닌지, 잘못된 방식으로 접근하고 있는 것은 아닌지 확인해 볼 필요가 있다.  

## 포인터의 필요성?
자료구조를 공부하게 되면 포인터의 필요성을 알게 된다고 한다.  
자료구조 = 데이터의 효율적인 표현 및 저장방법을 공부한다. 데이터의 다양한 표현 및 저장의 중심에는 '포인터'가 있다고 한다.  
지금까지 배운 것에서는 함수 내에서 함수 외부에 선언된 변수에 접근하기 위해 사용했다. 
원래 자바 끝내고 자료구조를 공부하려고 했는데 C를 끝내기 전에 생각해봐야겠다.. 