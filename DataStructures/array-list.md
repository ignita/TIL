# 배열을 이용한 리스트의 구현   

## 리스트 자료구조의 구현방법   
- 순차 리스트: 배열을 기반으로 구현된 리스트  
- 연결 리스트: 메모리의 동적 할당을 기반으로 구현된 리스트   
- **리스트 자료구조는 데이터를 나란히 저장, 중복된 데이터의 저장을 막지 않는다!**   

## 리스트의 ADT   

- Operations:   
 - `void ListInit(List * plist);`  
  - 초기화할 리스트의 주소 값을 인자로 전달   
  - 리스트 생성 후 제일 먼저 호출되어야 하는 함수   

 - `void LInsert(List * plist, Data data);`  
  - 리스트에 데이터를 저장, 매개변수 data에 전달된 값을 저장   
 
 - `int LFirst(List * plist, LData * pdata);`  
  - 첫 번째 데이터가 pdata가 가리키는 메모리에 저장  
  - 데이터 참조를 위한 초기화  
  - 참조 성공 시 TRUE(1), 실패 시 FALSE(0) 반환  

 - `LData LRemove(List * plist);`  
  - 참조된 데이터의 다음 데이터가 pdata가 가리키는 메모리에 저장  
  - 반복 호출 가능  
  - 참조를 새로 시작하려면 먼저 LFirst 함수를 호출해야 함.  
  - 참조 성공 시 TRUE(1), 실패 시 FALSE(0) 반환    

 - `LData LRemove(List * plist);`  
  - LFirst 또는 LNext 함수의 마지막 데이터를 삭제  
  - 삭제된 데이터를 반환  
  - 반복 호출 허용 x  

 - `int Count(List * plist);`  
  - 리스트에 저장되어 있는 데이터의 수를 반환   

- **'LData'는 리스트에 저장할 데이터의 자료형에 제한을 두지 않기 위한 typedef 선언의 결과**   
- LFirst 함수를 호출하도록 ADT를 디자인한 이유  
 - LNext 함수를 호출할 때마다 다음에 저장된 데이터를 얻을 수 있기 때문, 리스트 내에서 데이터의 참조위치를 기록한다. 따라서 처음부터 참조를 새롭게 시작하려면 LFirst 함수를 호출해야 하는 것이다.   


## 코드 구현   

- ArrayList.h   
```c
#ifndef __ARRAY_LIST_H__
#define __ARRAY_LIST_H__


#define TRUE        1       // 참
#define FALSE       0       // 거짓

#define LIST_LEN    100
typedef int LData;          // LData에 대한 typedef 선언

typedef struct __ArrayList      // 배열 기반 리스트를 정의한 구조체
{
    LData arr[LIST_LEN];        // 리스트의 저장소인 배열
    int numOfData;              // 저장된 데이터의 수
    int curPosition;            // 데이터 참조위치를 기록
} ArrayList;

typedef ArrayList List;

void ListInit(List * plist);                // 초기화
void LInsert(List * plist, LData data);     // 데이터 저장

int LFirst(List * plist, LData * pdata);    // 첫 데이터 참조
int LNext(List * plist, LData * pdata);     // 두 번째 이후 데이터 참조

LData LRemove(List * plist);                // 참조한 데이터 삭제
int LCount(List * plist);                   // 저장된 데이터의 수 반환

#endif
```   

## 배열 기반 리스트: 삽입과 조회   

- 초기화   
```c
void ListInit(List * plist)
{
    (plist->numOfData) = 0;     // 리스트에 저장된 데이터 수는 0  
    (plist->curPosition) = -1;  // 현재 아무 위치도 가리키지 않는다.   
}
```  

- 삽입  
```c
void LInsert(List * plist, LData data)
{
    if(plist->numOfData >= LIST_LEN)        // 더 이상 저장할 공간이 없다면 
    {
        puts("저장이 불가능합니다.");
        return;
    }
    
    plist->arr[plist->numOfData] = data;    // 데이터 저장 
    (plist->numOfData)++;       // 저장된 데이터의 수 증가  
}
```   

- 조회: LFirst, LNext  

```c
int LFirst(List * plist, LData * pdata)
{
    if(plist->numOfData == 0)       // 저장된 데이터가 하나도 없다면
        return FALSE;

    (plist->curPosition) = 0;       // 참조 위치 초기화! 첫 번째 데이터의 참조를 의미
    *pdata = plist->arr[0];         // pdata가 가리키는 공간에 데이터 저장
    return TRUE;
}

int LNext(List * plist, LData * pdata)
{
    if(plist->curPosition >= (plist->numOfData)-1)      // 더 이상 참조할 데이터가 없다면
        return FALSE;

    (plist->curPosition)++;
    *pdata = plist->arr[plist->curPosition];
    return TRUE;
}
```

- LFirst는 curPosition에 저장된 값을 0으로 재설정하면서 데이터 참조가 앞에서부터 다시 진행되도록 함.   
- LNext는 이 값을 증가시켜서 순서대로 참조할 수 있게 함.   

## 배열 기반 리스트: 삭제  

- 삭제 함수가 호출된 사례  

```c
if(First(&list, &data))
{
    if(data == 22)
        LRemove(&list);
    
    while(LNext(&list, &data))
    {
        if(data == 22)
            LRemove(&list);
    }
}
```
- LFirst 함수나 LNext 함수의 호출을 통해서 바로 직전에 참조가 이뤄진 데이터를 삭제  

```c
LData LRemove(List * plist)
{
    int rpos = plist->curPosition;      // 삭제할 데이터의 인덱스 값 참조
    int num = plist->numOfData;
    int i;
    LData rdata = plist->arr[rpos];     // 삭제할 데이터를 임시로 저장

    // 삭제를 위한 데이터의 이동을 진행하는 반복문
    for(i=rpos; i<num-1; i++)
        plist->arr[i] = plist->arr[i+1];

    (plist->numOfData)--;       // 데이터의 수 감소
    (plist->curPosition)--;     // 참조위치를 하나 되돌린다
    return rdata;               // 삭제된 데이터의 반환
}
```

- [typedef선언](/http://cafe.naver.com/cstudyjava/46864)    

## 리스트에 구조체 변수 저장하기1: 구조체 Point와 관련 함수들의 정의  

- 구조체 정의   
```c
typedef struct _point
{
    int xpos;    // x좌표 정보  
    int ypos;    // y좌표 정보
} Point;
```  
- 함수 정의  
```c
void SetPointPos(Point * pops, int xpos, int ypos);  // 값을 저장  
void ShowPointPos(Point * pops);                     // 정보 출력
int PointComp(Point * pos1, Point * pos2);           // 비교  

```
- 비교 함수 반환 값  
 - 두 Point 변수의 멤버 xpos만 같으면 1 반환  
 - 두 Point 변수의 멤버 ypos만 같으면 2 반환   
 - 두 Point 변수의 멤버가 모두 같으면 0 반환  
 - 두 Point 변수의 멤버가 모두 다르면 -1 반환    

- Point.h
```c
#ifndef __POINT_H__
#define __POINT_H__

typedef struct _point
{
    int xpos;
    int ypos;
} Point;

// Point 변수의 xpos, ypos 값 설정
void SetPointPos(Point * ppos, int xpos, int ypos);

// Point 변수의 xpos, ypos 정보 출력
void ShowPointPos(Point * ppos);

// 두 Point 변수의 비교
int PointComp(Point * pos1, Point * pos2);

#endif
```

- Point.c  
```c
#include <stdio.h>
#include "Point.h"

void SetPointPos(Point * ppos, int xpos, int ypos)
{
    ppos->xpos = xpos;
    ppos->ypos - ypos;
}

void ShowPointPos(Point * ppos)
{
    printf("[%d, %d] \n", ppos->xpos, ppos->ypos);
}

int PointComp(Point * pos1, Point * pos2)
{
    if(pos1->xpos == pos2->xpos && pos1->ypos == pos2->ypos)
        return 0;
    else if(pos1->xpos == pos2->xpos)
        return 1;
    else if(pos1->ypos == pos2->ypos)
        return 2;
    else
        return -1;
}
```

- ArrayList.h 헤더파일의 다음 코드를 변경한다.  
 - `typedef int LData;` → `typedef Point * LData;`   
 - `#include "Point.h"`     

- main.c  
```c
#include <stdio.h>
#include <stdlib.h>
#include "ArrayList.h"
#include "Point.h"

int main(void)
{
    List list;
    Point compPos;
    Point * ppos;

    ListInit(&list);

    // 4개의 데이터 저장
    ppos = (Point*)malloc(sizeof(Point));
    SetPointPos(ppos, 2, 1);
    LInsert(&list, ppos);

    ppos = (Point*)malloc(sizeof(Point));
    SetPointPos(ppos, 2, 2);
    LInsert(&list, ppos);

    ppos = (Point*)malloc(sizeof(Point));
    SetPointPos(ppos, 3, 2);
    LInsert(&list, ppos);

    // 저장된 데이터 출력
    printf("현재 데이터의 수: %d \n", LCount(&list));

    if(LFirst(&list, &ppos))
    {
        ShowPointPos(ppos);

        while(LNext(&list, &ppos))
            ShowPointPos(ppos);
    }

    printf("\n");

    // xpos가 2인 모든 데이터 삭제
    compPos.xpos = 2;
    compPos.ypos = 0;

    if(LFirst(&list, &ppos))
    {
        if(PointComp(ppos, &compPos) == 1)
        {
            ppos = LRemove(&list);
            free(ppos);
        }

        while(LNext(&list, &ppos))
        {
            if(PointComp(ppos, &compPos) ==1)
            {
                ppos = LRemove(&list);
                free(ppos);
            }
        }
    }

    // 삭제 후 남은 전체 데이터 출력
    printf("현재 데이터의 수: %d \n", LCount(&list));

    if(LFirst(&list, &ppos))
    {
        ShowPointPos(ppos);

        while(LNext(&list, &ppos))
            ShowPointPos(ppos);
    }
    printf("\n");

    return 0;
}
```
```
현재 데이터의 수: 3 
[2, 1] 
[2, 2] 
[3, 2] 

현재 데이터의 수: 1 
[3, 2] 
```   

- 위 예에서 리스트에 저장한 데이터는 Point 구조체 변수의 주소값이기 때문에 Point 구조체를 동적으로 할당한 결과이다. 그래서 반드시 free 함수를 통해 메모리의 해제과정을 거쳐야 한다.     

## 배열의 장점과 단점과 연결 기반 리스트   

- 단점  
 - 배열의 길이가 촉에 결정되어야 하고, 변경이 불가능  
 - 삭제의 과정에서 데이터의 이동(복사)가 매우 빈번히 일어남   
- 장점  
 - 데이터의 참조가 쉽다. 인덱스 값을 기준으로 어디든 한 번에 참조가 가능   

## 문제   
- NameCard.c 작성하기   

 - NameCard.h의 내용   
 ```c
  
