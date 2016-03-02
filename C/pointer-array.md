# 포인터 배열  

- 포인터 변수로 이뤄진, 주소 값의 저장이 가능한 배열을 **포인터 배열**이라고 한다.  
```c
int * arr1[20];
double * arr2[30];
```  

- 포인터 배열의 선언과 활용  
```c
#include <stdio.h>

int main(void)
{
    int num1 = 10, num2 = 20, num3 = 30;
    int * arr[3] = {&num1, &num2, &num3};

    printf("%d \n", *arr[0]);
    printf("%d \n", *arr[1]);
    printf("%d \n", *arr[2]);
    return 0;
}
```  
```
10
20
30
```   

## 문자열을 저장하는 포인터 배열  

- 문자열의 주소 값을 저장하는 'char형 포인터 배열'   
```c
#include <stdio.h>

int main(void)
{
    char * strArr[3] = {"Simple", "String", "Array"};
    printf("%s \n", strArr[0]);
    printf("%s \n", strArr[1]);
    printf("%s \n", strArr[2]);
    return 0;
}
```  
```
Simple 
String 
Array 
```

`printf()` 에서 `%d` 로 출력할때는 값을 넣는다. 그래서 `arr[0]` 의 값을 얻기위해 `*` 을 붙인다.  
`printf()` 에서 `%s` 로 출력할때는 주소를 넣는다. 그래서 `strArr[0]` 의 주소만 있으면 되니까 `*` 를 안붙인다.

