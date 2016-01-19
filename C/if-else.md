## if문  

- **계산기**  

```c
#include <stdio.h>

int main(void)
{
	int opt;
	double num1, num2;
	double result;

	printf("1.덧셈 2.뺄셈 3.곱셈 4.나눗셈 \n");
	printf("선택? ");
	scanf_s("%d", &opt);
	printf("두개의 실수 입력: ");
	scanf_s("%lf %lf", &num1, &num2);

	if (opt == 1)
		result = num1 + num2;
	if (opt == 2)
		result = num1 - num2;
	if (opt == 3)
		result = num1 * num2;
	if (opt == 4)
		result = num1 / num2;

	printf("결과 %f \n", result);
	return 0;
}
```

## if~else문  
- 불필요한 연산 줄이기  

```c
#include <stdio.h>

int main(void)
{
	int num;
	printf("정수 입력: ");
	scanf_s("%d", &num);

	if (num < 0)
		printf("입력 값은 0보다 작다. \n");
	else
		printf("입력 값은 0보다 작지 않다. \n");

	return 0;
}
```

## if...else문  
- 조건의 만족여부 검사는 위에서 아래로 진행  
- 조건이 만족되어 해당 블록을 실행하고 나면 마지막 else까지도 건너뛴다.  
- **계산기2**  

```c
if (opt == 1)
  result = num1 + num2;
else if (opt == 2)
  result = num1 - num2;
else if (opt == 3)
  result = num1 * num2;
else
  result = num1 / num2;
```


## 조건 연산자  
- 피 연산자가 세 개인 '삼 항 연산자'   
- `(조건) ? (data1) : (data2);`  
    - 조건이 '참'이면 연산결과로 data1이 반환, '거짓'이면 data2가 반환된다.   
- 절댓값 구하기  

```c
#include <stdio.h>

int main(void)
{
	int num, abs;
	printf("정수 입력: ");
	scanf_s("%d", &num);

	abs = num > 0 ? num : num*(-1);
	printf("절댓값: %d \n", abs);
	return 0;
}

```

## 문제  
- 1이상 100미만의 정수 중 7의 배수와 9의 배수를 출력

```c
#include <stdio.h>

int main(void)
{
	int num = 0;

	for (num = 1; num < 100; num++)
	{
		if (num % 7 == 0 || num % 9 == 0)
			printf("7의 배수와 9의 배수: %d\n", num);
	}
	return 0;
}
```

- 두 수의 차, 큰 수에서 작은 수 빼기 (if~else)  

```c
#include <stdio.h>

int main(void)
{
	int num1 = 0, num2 = 0;

	printf("두 개의 정수 입력: ");
	scanf_s("%d %d", &num1, &num2);

	if (num1 > num2)
		printf("두 수의 차: %d\n", num1 - num2);
	else
		printf("두 수의 차: %d\n", num2 - num1);

	return 0;
}
```

- 두 수의 차, 큰 수에서 작은 수 빼기 (조건 연산자)   

```c
	int num1 = 0, num2 = 0;
	int diff = 0;

	printf("두 개의 정수 입력: ");
	scanf_s("%d %d", &num1, &num2);

	diff = (num1 > num2) ? num1 - num2 : num2 - num1;

	printf("두 수의 차: %d\n", diff);
}
```


- 평균점수에 대한 학점 출력. 국어, 영어, 수학 입력   

```c
#include <stdio.h>

int main(void)
{
	int kor = 0, eng = 0, mat = 0;
	int avg = 0;

	printf("국어, 영어, 수학 점수를 순서대로 입력하시오.");
	scanf_s("%d %d %d", &kor, &eng, &mat);

	avg = (kor + eng + mat) / 3;

	printf("학점: ");
	if (avg >= 90)
		printf("A \n");
	else if (avg >= 80)
		printf("B \n");
	else if (avg >= 70)
		printf("C \n");
	else if (avg >= 50)
		printf("D \n");
	else
		printf("F \n");
	return 0;
}
```
