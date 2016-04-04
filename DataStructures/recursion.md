# 재귀  

## 함수의 재귀적 호출의 이해  

### 재귀함수의 기본적인 이해  

- 함수 내에서 **자기 자신을 다시 호출**하는 함수  

```c
void Recursive(void)
{
    printf("Recursive call! \n");
    Recursive();  // 나 자신을 재 호출  
}
```   
- 완료되지 않은 함수를 다시 호출하는 것은 가능하다.  
 - `Recursive`가 호출되면, `Recursive`의 복사본이 만들어져서 복사본이 실행되는 것   
 - 실제로 함수를 구성하는 명령문은 CPU로 이동이 되어(복사가 되어) 실행이 된다. 이 명령문은 얼마든지 CPU로 이동(복사)가 된다.  
- 위 `Recursive` 함수는 한번 호출되면 계속해서 호출되는 문제가 있으니, '재귀의 탈출조건'을 추가해야 한다.  
```c
#include <stdio.h>
 
void Recursive(int num)
{
    if(num <= 0) // 재귀의 탈출조건  
        return;
    printf("Recursive call! %d \n", num);
    Recursive(num-1);
}

int main(void)
{
    Recursive(3);
    return 0;
}
```   
- [마지막이미지](http://noogle.tistory.com/entry/Chapter-94-재귀함수에-대한-이해①)    
 - 재귀의 탈출조건이 성립되 함수가 반환하기 시작한다.   

#### 재귀함수의 디자인 사례  

- 팩토리얼(factorial)  
  - [팩토리얼 함수](https://github.com/the1994/TIL/blob/master/C/function.md#재귀함수)    

## 재귀의 활용  

#### 피보나치 수열: Fibonacci Sequence  

```c
#include <stdio.h>

int Fibo(int n)
{
    if(n == 1)
        return 0;
    else if(n == 2)
        return 1;
    else
        return Fibo(n-1) + Fibo(n-2);
}

int main(void)
{
    int i;
    for(i=1; i<15; i++)
        printf("%d ", Fibo(i));

    return 0;
}
```
```
0 1 1 2 3 5 8 13 21 34 55 89 144 233 
```
- 두 개의 `Fibo` 함수가 다시 호출될 때, + 연산자의 왼편에 있는 `Fibo` 함수호출이 완료되어야 + 연산자 오른편에 있는 `Fibo` 함수호출이 진행된다.  

#### 이진 탐색 알고리즘의 재귀적 구현  

1. 탐색 범위의 중앙에 목표 값이 저장되었는지 확인  
2. 저장되지 않았다면 **탐색 범위를 반으로 줄여서 다시 탐색 시작**    

- 탈출 조건  
```c
int BSearchRecur(int ar[], int first, int last, int target)
{
    if(first > last)
        return -1;  // -1의 반환은 탐색의 실패를 의미  
    . . . . 
}
```

- 탐색 대상 확인  
```c
int BSearchRecur(int ar[], int first, int last, int target)
{
    int mid;
    if(first > last)
        return -1;

    mid = (first+last) / 2;  // 중앙 값 인덱스 계산   
    if(ar[mid] == target)    
        return mid;          // 탐색된 타겟의 인덱스 값 반환  
    . . . . 
} 
```

- 재호출  

```c
int BSearchRecur(int ar[], int first, int last, int target)
{
    int mid;
    if(first > last)
        return -1;

    mid = (first+last) / 2;  // 중앙 값 인덱스 계산   
    if(ar[mid] == target)    
        return mid;          // 탐색된 타겟의 인덱스 값 반환  
    else if(target < ar[mid])
        return BSearchRecur(ar, first, mid-1, target);   // 앞부분을 대상으로 재탐색  
    else
        return BSearchRecur(ar, mid+1, last, target);    // 뒷부분을 대상으로 재탐색  
}   
```

## 하노이 타워: The Tower of Hanoi  

- 원반 4개, 막대 A, B, C  
1. 작은 원반 3개를(맨 아래의 원반을 제외한 나머지 원반을) A에서 B로 이동  
2. 큰 원반(맨 아래의 원반) 1개를 A에서 C로 이동  
3. 작은 원반(B로 옮겨진 원반) 3개를 B에서 C로 이동  

```
1. 작은 원반 n-1개를 A에서 B로 이동  
2. 큰 원반 1개를 A에서 C로 이동  
3. 작은 원반 n-1개를 B에서 C로 이동  
```
- 원반 n개를 이동하는 문제는 원반 n-1개를 이동하는 문제로 세분화, 원반 n-1개는 n-2개로 세분화  
 - 결국 원반 n개를 이동하는 문제는 원반 1개를 이동하는 매우 쉬운 문제로 세분화   

#### 하노이 타워 문제의 해결  

```c
void HanoiTowerMove(int num, char from, char by, char to)  
{
    . . . . 
}
```
- num개의 원반을 by를 거쳐(by를 이용해) from에서 to로 이동한다.   
- 탈출조건: 이동해야 할 원반의 수가 1개일 경우!   

```c
#include <stdio.h>

void HanoiTowerMove(int num, char from, char by, char to)
{
    if(num == 1)
    {
        printf("원반1을 %c에서 %c로 이동 \n", from, to);
    }
    else
    {
        HanoiTowerMove(num-1, from, to, by);
        printf("원반%d을(를) %c에서 %c로 이동 \n", num, from, to);
        HanoiTowerMove(num-1, by, from, to);
    }
}

int main(void)
{
    // 막대A의 원반 3개를 막대B를 거쳐 막대C로 옮기기
    HanoiTowerMove(3, 'A', 'B', 'C');
    return 0;
}
```
```
원반1을 A에서 C로 이동 
원반2을(를) A에서 B로 이동 
원반1을 C에서 B로 이동 
원반3을(를) A에서 C로 이동 
원반1을 B에서 A로 이동 
원반2을(를) B에서 C로 이동 
원반1을 A에서 C로 이동 
```
