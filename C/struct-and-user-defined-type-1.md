# 구조체와 사용자 정의 자료형1  

## 구조체란?

### 구조체의 정의  
- 구조체(structure): 하나 이상의 변수(포인터 변수와 배열 포함)를 묶어 새로운 자료형을 정의하는 도구  
- 사용자 정의 자료형: 기본 자료형 변수를 묶어 새로운 자료형을 만든 것   

예)
```c
struct person
{
    char name[20];
    char phoneNum[20];
    int age;
};
```
### 구조체 변수의 선언과 접근  
- 구조체 변수: 구조체를 정의했을 때 그 안의 자료형들을 대상으로 선언한 변수  
- 구조체 변수의 기본 형태  
```c
struct type_name val_name;
```  
 - 맨 앞에 `struct` 선언을 추가, 이어서 구조체명과 구조체 변수명 선언  

- 접근 방식  
 - 구조체 변수 이름.구조체 멤버의 이름   

- 두 점 사이의 거리 구하기  
```c
#include <stdio.h>
#include <math.h>

struct point        // 구조체 point의 정의
{
    int xpos;
    int ypos;
};

int main(void)
{
    struct point pos1, pos2;
    double distance;

    fputs("point1 pos: ", stdout);
    scanf("%d %d", &pos1.xpos, &pos1.ypos);

    fputs("point2 pos: ", stdout);
    scanf("%d %d", &pos2.xpos, &pos2.ypos);

    /* 두 점간의 걸 계산 고익 */
    distance = sqrt((double)((pos1.xpos-pos2.xpos) * (pos1.xpos - pos2.xpos) + (pos1.ypos-pos2.ypos) * (pos1.ypos - pos2.ypos)));

    printf("두 점의 거리는 %g 입니다 \n", distance);
    return 0;
}
```

- 배열, 포인터 접근  

```c
#include <stdio.h>
#include <string.h>

struct person
{
    char name[20];
    char phoneNum[20];
    int age;
};

int main(void)
{

    struct person man1, man2;
    strcpy(man1.name, "안성준");
    strcpy(man1.phoneNum, "010-8902-1234");
    man1.age = 23;

    printf("이름 입력: "); scanf("%s", man2.name);
    printf("번호 입력: "); scanf("%s", man2.phoneNum);
    printf("나이 입력: "); scanf("%d", &(man2.age));


    printf("이름: %s \n", man1.name);
    printf("번호: %s \n", man1.phoneNum);
    printf("나이: %d \n", man1.age);

    printf("이름: %s \n", man2.name);
    printf("번호: %s \n", man2.phoneNum);
    printf("나이: %d \n", man2.age);
    return 0;
}
```

- 구조체를 정의함과 동시에 변수 선언  

```c
struct point 
{
    int xpos;
    int ypos;
};
struct point pos1, pos2, pos3;   
```

### 구조체 변수의 초기화  

```c
#include <stdio.h>

struct point
{
    int xpos;
    int ypos;
};

struct person
{
    char name[20];
    char phoneNum[20];
    int age;
};

int main(void)
{
    struct point pos = {10, 20};
    struct person man = {"이승기", "010-2312-2323", 21};

    printf("%d %d \n", pos.xpos, pos.ypos);
    printf("%s %s %d \n", man.name, man.phoneNum, man.age);
    return 0;
    
}
```
- 초기화 과정에서는 문자열 저장을 위해 `strcpy`함수를 사용하지 않아도 된다!   

## 구조체와 배열, 포인터 

### 구조체 배열의 선언과 접근  
 
```c
#include <stdio.h>

struct point
{
    int xpos;
    int ypos;
};

int main(void)
{
    struct point arr[3];
    int i;

    for(i=0; i<3; i++)
    {
        printf("점의 좌표 입력: ");
        scanf("%d %d", &arr[i].xpos, &arr[i].ypos);
    }

    for(i=0; i<3; i++)
        printf("[%d, %d] ", arr[i].xpos, arr[i].ypos);

    return 0;
}
```

### 구조체 배열의 초기화  

- 구조체 변수를 선언과 동시에 초기화하기.
```c
struct person man={"이이이", "011-123-1434", 22};
```

- 구조체 배열을 동시에 초기화  
```c
struct person arr[3] = {
    {"치타", "010-1234-1234", 22};
    {"사자", "123-3232-2132", 24};
    {"얼룩말", "912-6767-4567", 25};
};
```

### 구조체 변수와 포인터  

- 구조체 포인터 변수의 선언과 초기화   
```c
struct point pos = {11, 12};
struct point * pptr = &pos;
```

- 접근  
```c
(*pptr).xpos = 10;
(*pptr).ypos = 20;
```
 - 다음 방법도 가능, *연산과 .연산을 -> 연산으로 대체  
```c
pptr -> xpos = 10;
pptr -> ypos = 20;
```

```c
#include <stdio.h>

struct point
{
    int xpos;
    int ypos;
};

int main(void)
{
    struct point pos1 = {1, 2};
    struct point pos2 = {100, 200};
    struct point * pptr = &pos1;

    (*pptr).xpos += 4;
    (*pptr).ypos += 5;
    printf("[%d, %d] \n", pptr->xpos, pptr->ypos);

    pptr = &pos2;
    pptr -> xpos += 1;
    pptr -> ypos += 2;
    printf("[%d, %d] \n", (*pptr).xpos, (*pptr).ypos);
    return 0;
}
```

### 포인터 변수를 구조체의 멤버로 선언하기   

- TYPE형 구조체 변수의 멤버로 TYPE형 포인터 변수를 둘 수 있다.  

```c
#include <stdio.h>

struct point
{
    int xpos;
    int ypos;
    struct point * ptr;
};

int main(void)
{
    struct point pos1 = {1, 1};
    struct point pos2 = {2, 2};
    struct point pos3 = {3, 3};

    pos1.ptr = &pos2;
    pos2.ptr = &pos3;
    pos3.ptr = &pos1;

    printf("점의 연결관계... \n");
    printf("[%d, %d]와(과) [%d, %d] 연결 \n",
        pos1.xpos, pos1.ypos, pos1.ptr->xpos, pos1.ptr->ypos);
    printf("[%d, %d]와(과) [%d, %d] 연결 \n",
        pos2.xpos, pos2.ypos, pos2.ptr->xpos, pos2.ptr->ypos);
    printf("[%d, %d]와(과) [%d, %d] 연결 \n",
           pos3.xpos, pos3.ypos, pos3.ptr->xpos, pos3.ptr->ypos);

}
```

### 구조체 변수의 주소 값과 첫 번째 멤버의 주소 값   

- 구조체 변수의 주소 값은 구조체 변수의 첫 번째 멤버의 주소 값과 동일하다.   
```c
#include <stdio.h>

struct point
{
    int xpos;
    int ypos;
};

struct person
{
    char name[20];
    char phoneNum[20];
    int age;

};

int main(void)
{
    struct point pos = {10, 20};
    struct person man = {"이승기", "01123123", 212222};

    printf("%p %p \n", &pos, &pos.xpos);
    printf("%p %p \n", &man, man.name);
    return 0;
}
```
- 결과를 보면 같은 걸 알 수 있다.   


