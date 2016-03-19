# 구조체와 사용자 정의 자료형2   


## 구조체의 정의와 typedef 선언   

int형 변수 num을 선언할 때 `int num`이라 하듯이, person형 구조체 변수 man을 선언할 때에도 struct 선언 없이 그저 `person man`이라고 하고 싶으면 구조체를 정의한 후에 **typedef 선언**을 추가해야 한다.   

### typedef 선언  

- 기존 자료형의 이름에 새 이름을 부여하는 것을 목적으로 하는 선언  
 - `typedef int INT;` - int의 또 다른 이름 INT를 부여!  
 - → 자료형의 이름 int에 INT라는 이름을 추가로 붙여준다.   
 - `INT num;` == `int num;`  
 - 포인터 변수 선언도 가능 → `INT * ptr;`   
- 가장 마지막에 등장하는 단어를 중심으로 이뤄진다.  
 - `typedef name1 name2 name3;` → name3가 'name1 name2'에 부여된 새로운 이름  
- typedef로 정의되는 자료형의 이름은 대문자로 시작하는 것이 관례  

### 구조체의 정의와 typedef 선언  
```c
#include <stdio.h>

struct point
{
    int xpos;
    int ypos;
};

typedef struct point Point;

typedef struct person
{
    char name[20];
    char phoneNum[20];
    int age;
} Person;

int main(void)
{
    Point pos = {10, 20};
    Person man = {"이승기", "010-1234-1234", 22};
    printf("%d %d \n", pos.xpos, pos.ypos);
    printf("%s %s %d \n", man.name, man.phoneNum, man.age);
    return 0;
}
```

### 구조체의 이름 생략  

```c
typedef struct person
{
    char name[20];
    char phoneNum[20];
    int age;
} Person;
```
- 위와 같이 선언되면, person은 사실상 별 의미를 갖지 않게 되어서 생략이 가능하다.  
- 단, `struct person man;`과 같이 선언하는 것은 불가능하게 된다.  


## 함수로의 구조체 변수 전달과 반환 

### 함수의 인자로 전달되고 return문에 의해 반환되는 구조체 변수   

- 함수의 인자로 구조체 변수가 전달될 수 있고, 이러한 인자를 전달받을 수 있도록 구조체 변수가 매개변수의 선언으로 올 수 있다.  
```c
#include <stdio.h>

typedef struct point
{
    int xpos;
    int ypos;
} Point;

void ShowPosition(Point pos)
{
    printf("[%d, %d] \n", pos.xpos, pos.ypos);
}

Point GetCurrentPosition(void)
{
    Point cen;
    printf("Input current pos: ");
    scanf("%d %d", &cen.xpos, &cen.ypos);
    return cen;
}

int main(void)
{
    Point curPos = GetCurrentPosition();
    ShowPosition(curPos);
    return 0;
}
```

- Call-by-refernce 형태의 함수 호출 구성 가능  
```c
#include <stdio.h>

typedef struct point
{
    int xpos;
    int ypos;
} Point;

void OrgSymTrans(Point * ptr)
{
    ptr -> xpos = (ptr->xpos) * -1;
    ptr -> ypos = (ptr->ypos) * -1;
}

void ShowPosition(Point pos)
{
    printf("[%d, %d] \n", pos.xpos, pos.ypos);
}

int main(void)
{
    Point pos = {7, -5};
    OrgSymTrans(&pos);
    ShowPosition(pos);
    OrgSymTrans(&pos);
    ShowPosition(pos);
    return 0;
}
```

### 구조체 변수를 대상으로 가능한 연산  

- 대입연산  
```c
#include <stdio.h>

typedef struct point
{
    int xpos;
    int ypos;
} Point;

int main(void)
{
    Point pos1 = {1, 2};
    Point pos2;
    pos2 = pos1;    // pos1의 멤버 대 pos2의 멤버간 복사가 진행됨

    printf("크기: %d \n", sizeof(pos1));  // pos1의 전체 크기 반환
    printf("[%d, %d] \n", pos1.xpos, pos1.ypos);
    printf("크기: %d \n", sizeof(pos2));  // pos2의 전체 크기 반환
    printf("[%d, %d] \n", pos2.xpos, pos2.ypos);
    return 0;
}
```

- 덧셈이나 뺄셈은 따로 함수를 만들어줘야 한다.  
```c
#include <stdio.h>

typedef struct point
{
    int xpos;
    int ypos;
} Point;

Point AddPoint(Point pos1, Point pos2)
{
    Point pos = {pos1.xpos + pos2.xpos, pos1.ypos + pos2.ypos};
    return pos;
}

Point MinPoint(Point pos1, Point pos2)
{
    Point pos = {pos1.xpos - pos2.xpos, pos1.ypos - pos2.ypos};
    return pos;
}

int main(void)
{
    Point pos1 = {5, 6};
    Point pos2 = {2, 9};
    Point result;

    result = AddPoint(pos1, pos2);
    printf("[%d, %d] \n", result.xpos, result.ypos);
    result = MinPoint(pos1, pos2);
    printf("[%d, %d] \n", result.xpos, result.ypos);
}
```

- 좌표 바꾸기  
```c
#include <stdio.h>

typedef struct point
{
    int xpos;
    int ypos;
} Point;

void SwapPoint(Point * ptr1, Point * ptr2)
{
    Point temp = *ptr1;
    *ptr1 = *ptr2;
    *ptr2 = temp;

}

int main(void)
{
    Point pos1 = {2, 4};
    Point pos2 = {5, 7};
    printf("Pos1: [%d, %d] \n", pos1.xpos, pos1.ypos);
    printf("Pos2: [%d, %d] \n", pos2.xpos, pos2.ypos);

    SwapPoint(&pos1, &pos2);

    printf("SwapPoint\n");
    printf("Pos1: [%d, %d] \n", pos1.xpos, pos1.ypos);
    printf("Pos2: [%d, %d] \n", pos2.xpos, pos2.ypos);
}
```

## 구조체의 유용함에 대한 논의와 중첩 구조체  

### 구조체를 정의하는 이유   
- 구조체를 통해서 연관 있는 데이터를 하나로 묶을 수 있는 자료형을 정의하면, 데이터의 표현 및 관리가 용이해지고, 그만큼 합리적인 코드를 작성할 수 있게 된다.    

### 중첩된 구조체의 정의와 변수의 선언  

- 구조체 변수도 구조체의 멤버로 선언될 수 있음 → '구조체의 중첩'  
```c
#include <stdio.h>

typedef struct point
{
    int xpos;
    int ypos;
} Point;

typedef struct circle
{
    Point cen;
    double rad;
} Circle;

void ShowCircleInfo(Circle * cptr)
{
    printf("[%d, %d] \n", (cptr->cen).xpos, (cptr->cen).ypos);
    printf("radius: %g \n\n", cptr->rad);
}

int main(void)
{
    Circle c1 = {{1,2}, 3.5};
    Circle c2 = {2, 4, 3.9};
    ShowCircleInfo(&c1);
    ShowCircleInfo(&c2);
    return 0;
}
```

## 공용체(Union Type)의 정의와 의미  

- 구조체: struct 키워드 사용  
- 공용체: union 키워드 사용  

### 구조체 vs. 공용체  

```c
// 구조체
typedef struct sbox
{   
    int mem1;
    int mem2;
    double mem3
} SBox;

// 공용체  
typedef union ubox
{
    int mem1;
    int m2m3;
    double mem3;
} UBox; 
```
```c
printf("%d \n", sizeof(SBox)); // 16
printf("%d \n", sizeof(UBox)); // 8
```
- 16은 모든 멤버의 크기를 합한 결과, 8은 멤버 중에서 가장 큰 double의 크기만 계산된 결과   

```c
#include <stdio.h>

typedef struct sbox     // 구조체 sbox의 정의
{
    int mem1;
    int mem2;
    double mem3;
} SBox;

typedef union ubox      // 공용체 ubox의 정의
{
    int mem1;
    int mem2;
    double mem3;
} UBox;

int main(void)
{
    SBox sbx;
    UBox ubx;
    printf("%p %p %p \n", &sbx.mem1, &sbx.mem2, &sbx.mem3);
    printf("%p %p %p \n", &ubx.mem1, &ubx.mem2, &ubx.mem3);
    printf("%d %d \n", sizeof(SBox), sizeof(UBox));
    return 0;
}
```
```
0x7fff574fbb48 0x7fff574fbb4c 0x7fff574fbb50 
0x7fff574fbb40 0x7fff574fbb40 0x7fff574fbb40 
16 8
```
- 구조체를 구성하는 멤버는 각각 할당  
- 공용체를 구성하는 멤버는 그 중 가장 크기가 큰 멤버의 변수만 하나 할당되어 이를 공유  

```c
#include <stdio.h>

typedef union ubox  // 공용체 ubox의 정의
{
    int mem1;
    int mem2;
    double mem3;
} UBox;

int main(void)
{
    UBox ubx;       // 8바이트 메모리 할당
    ubx.mem1 = 20;  // 상위 4바이트 메모리 공간에 20을 저장
    printf("%d \n", ubx.mem2);  // mem2는 int형 변수이므로 상위 4바이트 메모리 공간을 참조, 위 행에서 20을 저장했으므로 20 출력  

    ubx.mem3 = 7.15;        // 13행을 통해 저장된 값을 덮어써버림
    printf("%d \n", ubx.mem1);  // 위 행 때문에 상위 4바이트를 읽어출력하면 알 수 없는 값 출력 
    printf("%d \n", ubx.mem2);
    printf("%d \n", ubx.mem3);
    return 0;
}
```
```
20 
-1717986918 
-1717986918 
7.15 
``` 

### 공용체의 유용함 - 다양한 접근방식을 제공  
- 하나의 메모리 공간을 둘 이상의 방식으로 접근할 수 있다.  
```c
#include <stdio.h>

typedef struct dbshort
{
    unsigned short upper;
    unsigned short lower;
} DBShort;

typedef union rdbuf
{
    int iBuf;
    char bBuf[4];
    DBShort sBuf;
} RDBuf;

int main(void)
{
    RDBuf buf;
    printf("정수 입력: ");
    scanf("%d", &(buf.iBuf));

    printf("상위 2바이트: %u \n", buf.sBuf.upper);
    printf("하위 2바이트: %u \n", buf.sBuf.lower);
    printf("상위 1바이트 아스키 코드: %c \n", buf.bBuf[0]);
    printf("하위 1바이트 아스키 코드: %c \n", buf.bBuf[3]);
    return 0;
} 
```

## 열거형(Enumerated Type)의 정의와 의미   

### 열거형의 정의와 변수의 선언  

- 변수에 저장이 가능한 값들을 열거하여 정의한다고 해서 '열거형'  

```c
enum syllable
{
    Do = 1, Re = 2, Mi = 3, Fa = 4, So = 5, La = 6, Ti = 7
};
```
- 선언  
```c
enum syllable tone;
```

### 열거형 상수의 값이 결정되는 방식  
```c
enum color {RED, BLUE, WHITE, BLACK};
```
- 위 정의는 열거형 상수의 이름만 선언했고 상수의 값은 선언되지 않았지만 0부터 1씩 증가하는 형태로 결정된다.  
```c
enum color {RED=3, BLUE, WHITE=6, BLACK};
```
- 값이 선언되지 않으면 앞서 선언된 상수보다 1이 증가된 값이 할당된다.   

### 열거형의 유용함  
- 이름있는 상수의 정의를 통한 의미의 부여  
- 연관있는 이름을 동시에 상수로 선언  
- 둘 이상의 연관이 있는 이름을 상수로 선언함으로써 프로그램의 가독성을 높인다.  
- 자료형 이름도 생략 가능하다.   

