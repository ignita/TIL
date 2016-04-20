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


