## 함수  

```c
int main(void)
{
  // 함수의 몸체
}

```  
- `int`: 반환형태  
- `main`: 함수이름  
- `void`: 입력형태    

- 함수는 호출하기 전에 미리 선언해야 한다.(정의는 뒤에서 해도 된다.)
  - 매개변수의 갯수 및 자료형 정보만 포함하면 된다. (매개변수 이름 생략 가능)  


### return이 지니는 의미  

- 키워드 `return`은 **값을 반환**하면서 **함수를 빠져나갈 때** 사용된다.  
- 반환형이 void로 선언된 함수에서도 return문을 삽입할 수 있다.  
  - 예) 반환없이 함수를 빠져나간다.  
  ```c
  void NoReturnType(int num)
{
	   if (num < 0)
		   return;
	....
}
```  

## 재귀함수  
- 같은 함수 내에서 자기 자신을 다시 호출하는 함수

```c
void Recursive(void)
{
	printf("Recursive call! \n");
	Recursive(); // 재 호출
}
```

- `Recursive` 함수를 실행하는 중간에 다시 `Recursive`함수가 호출되면, `Recursive` 함수의 복사본을 하나 더 만들어서 복사본을 실행하는 것이다.  
- **탈출조건**
을 잘 구성해야 한다.  
- n팩토리얼  
   - `n! = n x (n-1) x (n-2) x (n-3) x - - - x 2 x 1` 은
   - `n! = n * (n-1)` 로 바꿀 수 있다.  
   - f(n)은 n >= 1이면 n x f(n-1), n = 0 이면 1  

```c
 #include <stdio.h>

int Factorial(int n)
{
	if (n == 0)
		return 1;
	else if (n >= 1)
		return n * Factorial(n - 1);
}

int main(void)
{
	printf("1! = %d \n", Factorial(1));
	printf("2! = %d \n", Factorial(2));
	printf("3! = %d \n", Factorial(3));
	printf("4! = %d \n", Factorial(4));
	printf("5! = %d \n", Factorial(5));
	return 0;
}
```

## 문제  

- 세 수 입력, 가장 작은 수, 가장 큰 수 반환  

```c
#include <stdio.h>
int MaxNum(int num1, int num2, int num3);
int MinNum(int num1, int num2, int num3);

int main(void)
{
	int num1, num2, num3;

	printf("세 개의 정수 입력: ");
	scanf_s("%d %d %d", &num1, &num2, &num3, 1);

	printf("가장 큰 수: %d \n", MaxNum(num1, num2, num3));
	printf("가장 작은 수: %d \n", MinNum(num1, num2, num3));

	return 0;

}

int MaxNum(int num1, int num2, int num3)
{
	int max;

	max = num1;
	if (num1 < num2)
		max = num2;
	if (num1 < num3)
		max = num3;

	return max;
}

int MinNum(int num1, int num2, int num3)
{
	int min;

	min = num1;
	if (num1 > num2)
		min = num2;
	if (num1 > num3)
		min = num3;

	return min;
}
```  

- 섭씨 온도 -> 화씨 온도, 화씨온도 -> 섭씨 온도  
  - Fah=1.8*Cel+32  

```c
#include <stdio.h>
double CelToFah(double Cel);
double FahToCel(double Fah);

int main(void)
{
	int sel;
	double temp;

	printf("1.섭씨를 화씨로 2.화씨를 섭씨로 ");
	scanf_s("%d", &sel, 1);

	switch (sel)
	{
	case 1:
		printf("섭씨 입력: ");
		scanf_s("%lf", &temp);
		printf("화씨 온도: %f \n", CelToFah(temp));
		break;
	case 2:
		printf("화씨 입력: ");
		scanf_s("%lf", &temp);
		printf("섭씨 온도: %f \n", FahToCel(temp));
		break;
	default:
		printf("입력이 잘못되었습니다. \n");
	}
	return 0;
}

double CelToFah(double Cel)
{
	return 1.8*Cel + 32;
}

double FahToCel(double Fah)
{
	return (Fah - 32) / 1.8;
}
```  

- 인자로 전달된 수만큼의 피보나치 수열을 출력하는 함수  

```c
#include <stdio.h>

int Fibo(int num);

int main(void)
{
	int num;

	printf("몇개의 피보나치 수열을 출력하겠습니까? ");
	scanf_s("%d", &num, 1);

	if (num < 1)
	{
		printf("1이상의 값을 입력하세요. \n");
		return -1;
	}
	printf("피보나치 수열: ");
	Fibo(num);

	return 0;
}

int Fibo(int num)
{
	int f1 = 0, f2 = 1, f3, i;
	if (num == 1)
		printf("%d ", f1);
	else
		printf("%d %d ", f1, f2);

	for (i = 0; i < num - 2; i++)
	{
		f3 = f1 + f2;
		printf("%d ", f3);
		f1 = f2;
		f2 = f3;
	}

	printf("\n");
}
```
