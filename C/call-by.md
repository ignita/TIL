# Call-by-value vs. Call-by-reference  
함수의 호출 방식을 의미  

## Call-by-value  
단순히 값을 전달하는 형태의 함수호출  

```c
#include <stdio.h>

void Swap(int n1, int n2)
{
    int temp = n1;
    n1 = n2;
    n2 = temp;
    printf("n1 n2: %d %d \n", n1, n2);
}

int main(void)
{
    int num1 = 10;
    int num2 = 20;
    printf("num1 num2: %d %d \n", num1, num2);

    Swap(num1, num2);
    printf("num1 num2: %d %d \n", num1, num2);
    return 0;
}
```  
```
num1 num2: 10 20
n1 n2: 20 10
num1 num2: 10 20
```  
num1과 num2에 저장된 값은 swap의 n1과 n2로 복사되어 값이 변경된다. 그래서 num1과 num2에 저장된 값의 변경으로는 이어지지 않는다. num1, num2는 n1,n2와 완전히 별개의 것이기 때문  


## Call-by-reference  

```c
#include <stdio.h>

void Swap(int * ptr1, int * ptr2)
{
    int temp = *ptr1;
    *ptr1 = *ptr2;
    *ptr2 = temp;
}

int main(void)
{
    int num1 = 10;
    int num2 = 20;
    printf("num1 num2: %d %d \n", num1, num2);

    Swap(&num1, &num2);
    printf("num1 num2: %d %d \n", num1, num2);
    return 0;
}
```
```
num1 num2: 10 20 
num1 num2: 20 10
```

## scanf 함수호출 시 &연산자를 붙이는 이유
  
```c
int main(void)
{
    int num;
    scanf("%d", &num);
    ...
}
```
위의 scanf 함수호출이 완료되면 변수 num에는 값이 채워진다. scanf 함수는 num의 주소값을 알아야 변수 num에 접근해 값을 채워넣을 수 있다.  
scanf 함수의 호출도 **Call-by-reference**형태의 함수호출에 해당한다.  
문자열을 입력받을 때에는 문자열 배열이 전달되어 그 자체로 주소 값을 전달하기 때문에 &연산자를 붙이지 않는다.  

