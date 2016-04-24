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

## 문제: 노드를 머리에 추가하기   


