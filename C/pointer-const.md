# 포인터 대상의 const 선언  

변수를 상수화하는 const 선언은 포인터 변수를 대상으로도 선언이 가능하다.  

## 포인터 변수가 참조하는 대상의 변경을 허용하지 않는 const 선언  

```c
int main(void)
{
    int num = 20;
    const int * ptr = &num;
    *ptr = 30;  // 컴파일 에러  
    num = 40;   // 컴파일 성공
    ...
}
```
맨 앞에 const가 선언이 되면 포인터 변수 **ptr을 이용**해 가리키는 변수에 저장된 값을 변경하는 것을 허용하지 않지만 변수 num 자체가 상수화되는 것은 아니다.  
즉 변경하는 방법에 제한을 두는 것이지 무언가를 상수로 만드는 선언은 아닌 것이다.  

## 포인터 변수의 상수화  

다음과 같이 선언하면 포인터 변수 ptr은 상수가 된다. 그 뜻은 한번 주소값이 저장되면 그 주소값의 변경이 불가능하다는 뜻이다. 한번 가리키기 시작한 변수를 끝까지 가리켜야 한다는 뜻으로도 이해할 수 있다. 
```c
int * const ptr = &num;
```   

```c
int main(void)
{
    int num1 = 20;
    int num2 = 30;
    int * const ptr = &num1;
    ptr = &num2;    // 컴파일 에러
    *ptr = 40;      // 컴파일 성공
    ...
}
```
ptr은 상수이기 때문에 가리키는 대상은 바꿀 수 없지만 가리키는 대상에 저장된 값을 변경하는 연산은 가능하다.  

두 가지 형태 모두를 적용할 수도 있다.  
```c
const int * const ptr = &num;
```
`*ptr=20;`과 `ptr=&age` 둘 다 불가능해진다.  


## const 선언이 갖는 의미  
코드의 안전성이 높아진다.  
예를 들어,
```c
int main(void)
{
    double PI = 3.1415;
    double rad;
    PI = 3.07;  // 실수로 삽입되었지만, 컴파일 시 발견 안 됨.
    scanf("%lf", &rad);
    printf("circle area %f \n", rad*rad*PI);
    return 0;
}
```  
위의 main 함수는 원의 넓이를 계산해 출력하는데 원주율에 해당하는 값이 저장된 변수 PI의 값을 변경하는 실수가 있다. 하지만 컴파일은 문제점을 발견하지 못한다. 프로그램 코드의 양이 방대하다면 찾기 힘들 것이다. 이런 문제점을 해결하기 위해 다음과 같이 변경해준다.  
```c
const double PI = 3.1415;
```
이렇게 해주게 되면 const가 선언된 변수에 값을 변경하려 한다면 컴파일 에러가 발생할 것이다.   

## 문제  

아래의 함수에서 매개변수 arr을 대상으로 const 선언을 한 이유?
```c
void ShowAllData(const int * arr, int len)
{
    int i;
    for(i=0; i<len; i++)
        printf("%d ", arr[i]);
}
```  
배열 요소를 전부 출력하는 함수인데 만약 arr에 const 선언이 없다면 다음과 같이 배열 요소를 변경할 수도 있기 때문이다.  
```c
#include <stdio.h>

void ShowAllData(int * arr, int len)
{
    arr[0] = 3;
    int i;
    for(i=0; i<len; i++)
        printf("%d ", arr[i]);

}
int main(void)
{
    int arr[5] = {1, 2, 3, 4, 5, 6};

    ShowAllData(arr, 4);
    return 0;
}
```  

아래 예제에서 지적할만한 사항은 무엇인가? 이와 관련해 ShowData 함수를 유심히 관찰하자.  
```c
void ShowData(const int * ptr)
{
    int * rptr = ptr;
    printf("%d \n", *rptr);
    *rptr = 20;
}

int main(void)
{
    int num = 10;
    int * ptr = &num;
    ShowData(ptr);
    return 0;
}
```  
const선언으로 ShowData 함수 내의 ptr이 가리키는 변수의 값의 변경을 허용하고 있지 않고 있다. 하지만 다음 문장과 같이 ptr에 저장된 값을 const로 선언되지 않는 포인터 변수에 대입하고 있다. 그렇게 되면 결국엔 ptr이 가리키는 변수에 저장된 값을 변경할 수 있게 된다.  

