## switch문  

```c
#include <stdio.h>

int main(void)
{
	char sel;
	printf("M 오전, A 오후, E 저녁 \n");
	printf("입력: ");
	scanf_s("%c", &sel, 1);

	switch (sel)
	{
	case 'M':
	case 'm':
		printf("Morning \n");
		break;
	case 'A':
	case 'a':
		printf("Afternoon \n");
		break;
	case 'E':
	case 'e':
		printf("Evening \n");
		break;
	}
	return 0;
}
```  

## 문제   
- 아래 코드를 switch 문으로  

```c
if (0 < n && n < 10)
  printf("0이상 10미만");
else if (10 <= n && n < 20)
  printf("10이상 20미만");
else if (20 <= n && n < 30)
  printf("20이상 30미만");
else
  printf("30이상");
```  

```c
#include <stdio.h>

int main(void)
{
	int n = 0;
	int ten_num = 0;

	printf("숫자 입력: ");
	scanf_s("%d", &n);
	ten_num = n / 10;

	switch (ten_num)
	{
	case 0:
		printf("0이상 10미만 \n");
		break;
	case 1:
		printf("10이상 20미만 \n");
		break;
	case 2:
		printf("20이상 30미만 \n");
		break;
	default:
		printf("30이상 \n");
	}
	return 0;
}
```   

## goto  
- 프로그램의 흐름을 원하는 위치로 이동시킬 때 사용하는 키워드  
- 사용하지 않는 것이 좋다.  
- 단점  
  - 프로그램의 자연스러운 흐름을 방해한다.  
  - 과도하게 사용하면 읽고 유지하기 힘든 스파게티 코드가 나오기 쉽다.  
  - [GOTO문의 해로움 - 에츠허르 다익스트라](http://www.u.arizona.edu/~rubinson/copyright_violations/Go_To_Considered_Harmful.html)  
    - 다익스트라 알고리즘의 그 다익스트라이다.  

```c
#include <stdio.h>

int main(void)
{
	...
rabbit:
	...
		goto rabbit;
}
```  
- 이동의 위치는 레이블로 표시. 레이블은 실행의 대상이 아닌 위치를 표시하는 역할이므로 편집기상에서 왼쪽 정렬을 시켜 프로그래머들이 레이블을 쉽게 구분할 수 있도록 돕는다.  
