# 연결 리스트 2  

## 연결 리스트의 개념적인 이해   

- 배열의 단점  
 - 배열은 메모리의 특성이 정적이어서(길이의 변경이 불가능해서) 메모리의 길이를 변경하는 것이 불가능   

- 예시   
```c
#include <stdio.h>
#include <stdlib.h>

typedef struct _node
{
    int data;
    struct _node * next;
} Node;

int main(void)
{
    Node * head = NULL;
    Node * tail = NULL;
    Node * cur = NULL;

    Node * newNode = NULL;
    int readData;

    // 데이터를 입력 받는 과정
    while(1)
    {
        printf("자연수 입력: ");
        scanf("%d", &readData);
        if(readData < 1)
            break;

        // 노드의 추가과정
        newNode = (Node*)malloc(sizeof(Node));
        newNode->data = readData;
        newNode->next = NULL;

        if(head == NULL)
            head = newNode;
        else
            tail->next = newNode;

        tail = newNode;
    }
    printf("\n");

    // 입력 받은 데이터의 출력과정
    printf("입력 받은 데이터의 전체출력! \n");
    if(head == NULL)
    {
        printf("저장된 자연수가 존재하지 않습니다. \n");
    }
    else
    {
        cur = head;
        printf("%d ", cur->data);       // 첫 번째 데이터 출력

        while(cur->next != NULL)        // 두 번째 이후의 데이터 출력
        {
            cur = cur->next;
            printf("%d ", cur->data);
        }
    }
    printf("\n\n");

    // 메모리의 해제과정
    if(head == NULL)
    {
        return 0;   // 해제할 노드가 존재하지 않는다
    }
    else
    {
        Node * delNode = head;
        Node * delNextNode = head->next;

        printf("%d을(를) 삭제합니다. \n", head->data);
        free(delNode);  // 첫 번째 노드 삭제

        while(delNextNode != NULL)      // 두 번째 이후 노드 삭제
        {
            delNode = delNextNode;
            delNextNode = delNextNode->next;

            printf("%d을(를) 삭제합니다. \n", delNode->data);
            free(delNode);
        }
    }

    return 0;
}
```
```c
typedef struct _node
{
    int data;                // 데이터를 담을 공간
    struct _node * next;     // 연결의 도구
} Node;  
```
- 멤버 next는 Node형 구조체 변수의 주소 값을 저장할 수 있는 포인터 변수이다.   
 - Node형 구조체가 다른 Node형 구조체 변수를 가리킬 수 있게 하는 것이 목적   
 - **필요할 때마다 바구니 역할을 하는 구조체 변수를 하나씩 동적 할당해서 이들을 연결!**   

### 데이터의 삽입  

```c
if(head == NULL)
    head = newNode;
else
    tail->next = newNode;

tail = newNode;
}
```  
- [tail=newNode](http://cafe.naver.com/cstudyjava/84907)     


### 데이터 조회   

```c
while(cur->next != NULL)        // 두 번째 이후의 데이터 출력
{
    cur = cur->next;
    printf("%d ", cur->data);
}
```
- `cur = cur->next`에 의해 cur이 모든 노드를 가리키며 이동   

### 데이터 삭제   

```c
Node * delNode = head;
Node * delNextNode = head->next;
```
- 두 개의 포인터 변수  
 - head가 가리키는 노드를 그냥 삭제하면 그 다음 노드에 접근이 불가능하기 때문.  

## 문제 1: 노드를 머리에 추가하기   

- head, tail이 NULL인 상황과 그렇지 않은 상황에서의 차이  

```c
if(head == NULL)
{
     head = newNode;
     tail = head;
}
else
{
     newNode->next = head;
     head = newNode;
}
```  

## 단순 연결 리스트: ADT와 구현  
- 연결의 형태가 한쪽 방향으로 전개되고 시작과 끝이 분명히 존재   

### 정렬 기능이 추가된 연결 리스트의 ADT 정의   

- [배열을 이용한 리스트의 ADT](https://github.com/the1994/TIL/blob/master/DataStructures/array-list.md#리스트의-adt)에 정렬 관련 함수 추가   
- `void SetSortRule(List * plist, int (*comp)(LData d1, LData d2));`
  - 리스트에 정렬의 기준이 되는 함수를 등록   

- 새 노드 추가 시 머리와 꼬리 중 어디에 추가를 할 것인가?  
 * 머리에 추가할 경우  
     * 장점: 포인터 변수 tail이 불필요  
     * 단점: 저장된 순서를 유지 x  

 - 꼬리에 추가할 경우  
     - 장점: 저장된 순서가 유지  
     - 단점: 포인터 변수 tail이 필요

- 포인터 변수 tail을 유지하기 위해 넣어야 할 부가적인 코드가 번거롭게 느껴질 수 있고 리스트 자료구조는 저장된 순서를 유지해야 하는 자료구조가 아니기 때문에 대부분 머리에 추가하는 것을 선호   

- **SetSortRule 함수**  
 - 두 번째 매개변수 선언: `int (*comp)(LData d1, LData d2)`  
     - 반환형이 int이고 LData형 인자를 두 개 전달받는 함수의 주소 값을 두 번째 인자로 전달하라.   
- 함수의 예  
```c
int WhoIsPrecede(LData d1, LData d2)  // typedef int LData;
{
    if(d1 < d2)  
        return 0;   // d1이 정렬 순서상 앞선다.
    else  
        return 1;   // d2가 정렬 순서상 앞서거나 같다.
}
```  

- 매개변수인 d1에 전달되는 인자가 정렬 순서상 앞서서 head에 더 가까워야 하는 경우에는 0을 반환, 매개변수인 d2에 전달되는 인자가 정렬 순서상 앞서거나 같은 경우에는 1을 반환   
  - 0이나 1이 아니더라도 다른 의미를 부여해도 된다.   
  - `int cr = WhoIsPrecede(D1, D2);`  
     - cr에 반환된 값이 0인 경우  
        - head . . . D1 . . . D2 . . . tail  
     - cr에 반환된 값이 1인 경우  
        - head . . . D2 . . . D1 . . . tail   

### 더미 노드(Dummy Node) 기반의 단순 연결 리스트   

- 지금까지 연결 리스트에서는 첫 번째 노드가 포인터 변수 head가 가리킨다는 점에서 노드를 추가 삭제 조회하는 방법이 두 번째 이후의 노드와 차이가 있다.  
 - 그래서 더미 노드(빈 노드)를 추가해 처음 추가되는 노드가 구조상 두 번째 노드가 되는 것으로 일관된 형태로 노드를 추가 및 삭제, 조회하는 구성이 가능하다.     

### 정렬 기능이 추가된 연결 리스트를 위한 헤더 파일과 구조체의 정의   

- 배열 처럼, 리스트 자료구조도 프로그램에 하나만 사용된다는 법이 없다. 따라서 다수의 리스트 자료구조가 필요하기 때문에 다음과 같이 연결 리스트를 의미하는 별도의 구조체를 정의해야 한다.   
```c
typedef struct _linkedList
{
    Node * head;       // 더미 노드를 가리키는 멤버
    Node * cur;        // 참조 및 삭제를 돕는 멤버
    Node * before;     // 삭제를 돕는 멤버
    int numOfData;     // 저장된 데이터의 수를 기록하기 위한 멤버  
    int (*comp)(LData d1, LData d2);   // 정렬의 기준을 등록하기 위한 멤버  
} LinkedList;
```  

#### 헤더 파일  

```c
//
// Created by ox on 2016. 5. 7..
//

#ifndef ARRAYLIST2_DLINKEDLIST_H
#define ARRAYLIST2_DLINKEDLIST_H

#define TRUE        1
#define FALSE       0

typedef int LData;

typedef struct _node
{
    LData data;
    struct _node * next;
} Node;

typedef struct _linkedList
{
    Node * head;
    Node * cur;
    Node * before;
    int numOfData;
    int (*comp)(LData d1, LData d2);
} LinkedList;

typedef LinkedList List;

void ListInit(List * plist);
void LInsert(List * plist, LData data);

int LFirst(List * plist, LData * pdata);
int LNext(List * plist, LData * pdata);

LData LRemove(List * plist);
int LCount(List * plist);

void SetSortRule(List * plist, int (*comp)(LData d1, LData d2));

#endif //ARRAYLIST2_DLINKEDLIST_H
```

- 구조체 초기화 함수  
```c
void ListInit(List * plist)
{
    plist->head = (Node*)malloc(sizeof(Node));      // 더미 노드의 생성
    plist->head->next = NULL;
    plist->comp = NULL;
    plist->numOfData = 0;
}
```
- 노드의 추가  
```c
void LInsert(List * plist, LData data)
{
    if(plist->comp == NULL)     // 정렬 기준이 없다면,
        FInsert(plist, data);   // 머리에 노드를 추가
    else                        // 정렬 기준이 존재한다면,
        SInsert(plist, data);   // 정렬 기준에 근거하여 노드를 추가  
}
```  
 - `FInsert`와 `SInsert`함수는 헤더파일에 선언된 함수가 아니기 때문에 리스트를 사용하는 프로그래머가 이 두 함수를 직접 호출할 수 없다.  

 - FInsert  
```c
void FInsert(List * plist, LData data)
{
    Node * newNode = (Node*)malloc(sizeof(Node));       // 새 노드 생성
    newNode->data = data;                               // 새 노드에 데이터 저장
    
    newNode->next = plist->head->next;                  // 새 노드가 다른 노드를 가리키게 함 
    plist->head->next = newNode;                        // 더미 노드가 새 노드를 가리키게 함
    
    (plist->numOfData)++;                               // 저장된 노드의 수를 하나 증가시킴
}
```  
   - 포인터 변수 head가 NULL이 아닌 더미 노드를 가리키고 있다는 사실을 잊지 말아야 함.   

- 데이터 조회   
```c
int LFirst(List * plist, LData * pdata)
{
    if(plist->head->next == NULL)       // 더미 노드가 NULL을 가리킨다면,
        return FALSE;                   // 반환할 데이터가 없다.

    plist->before = plist->head;        // before은 더미 노드를 가리키게 함
    plist->cur = plist->head->next;     // cur은 첫 번째 노드를 가리키게 함

    *pdata = plist->cur->data;          // 첫 번재 노드의 데이터를 전달
    return TRUE;
}
```
```c
int LNext(List * plist, LData * pdata)
{
    if(plist->cur->next == NULL)        // cur이 NULL을 가리킨다면,
        return FALSE;                   // 반환할 데이터가 없다.
    
    plist->before = plist->cur;         // cur이 가리키던 것을 before가 가리킴 
    plist->cur = plist->cur->next;      // cur은 그 다음 노드를 가리킴
    
    *pdata = plist->cur->data;          // cur이 가리키는 노드의 데이터 전달
    return TRUE;                        // 데이터 반환 성공 
}
```
 - before를 둬서 멤버 cur보다 하나 앞선 노드를 가리키게 하는 이유: 노드의 삭제와 관련이 있다.   


- 노드의 삭제  


