## 도전1  
10진수 정수를 입력받아 16진수로 출력  

```c
#include <stdio.h>

int main(void)
{
	int num;

	printf("10진수 정수 입력: ");
	scanf_s("%d", &num, 1);

	printf("10진수 %d는 16진수로 %x이다 \n", num, num);
	return 0;
}   
```

## 도전2  
사용자로부터 두 개의 정수를 입력 받아 구구단을 출력.  
사용자가 3과 5를 입력하면 3, 4, 5단이 출력, 2, 4를 입력하면 2, 3, 4단이 출력. 사용자는 입력 순서에 자유로워야 한다.  

```c
#include <stdio.h>
int gugu(int num1, int num2);

int main(void)
{
	int num1, num2;

	printf("두 개의 정수를 입력하시오. ");
	scanf_s("%d %d", &num1, &num2, 1);

	gugu(num1, num2);
}
int gugu(int num1, int num2)
{
	int n1, n2;

	if (num1 < num2)
	{
		n1 = num1;
		n2 = num2;
	}
	else
	{
		n1 = num2;
		n2 = num1;
	}

	for (int i = n1; i < n2 + 1; i++)
	{
		for (int j = 1; j < 10; j++)
		{
			printf("%dx%d=%d \n", i, j, i*j);
		}
		printf("\n");
	}
}
```
나는 gugu함수에 다 때려박았는데 답지에는 if 부분을 main함수에서 함수의 매개변수만 바꾸는 걸로 했다. 그게 더 깔끔했다. 그리고 for문 말고 while문을 사용했다.  

```c
if(num1<num2)
  NineNine(num1, num2);
else
  NineNine(num2, num1);
```

```c
void NineNine(int num1, int num2)
{
	int i;

	while(num1<=num2)
	{
		for(i=1; i<10; i++)
			printf("%d * %d = %d \n", num1, i, num1*i);
		printf("\n");
		num1++;
	}
}
```

## 도전3  

두 개의 정수를 입력 받아서 최대 공약수(GCD)를 구하는 프로그램  

```c
#include <stdio.h>
void gcd(int num1, int num2);

int main(void)
{
	int num1, num2;

	printf("두 개의 정수 입력: ");
	scanf_s("%d %d", &num1, &num2, 1);

	if (num1 > num2)
		gcd(num1, num2);
	else
		gcd(num2, num1);

	return 0;
}

void gcd(int num1, int num2)
{
	int gcd;
	int i = 1;

	for (int i = 1; i <= num2; i++)
	{
		if (num1 % i == 0 && num2 % i == 0)
		{
			gcd = i;
		}
	}
	printf("두 수의 최대공약수: %d \n", gcd);

}
```  
책에서는 수를 넣어놓고 값을 줄인다. 나는 왜 이런생각을 못했을까???  

### 유클리드 호제법  

> 두 정수 a, b의 최대공약수를 G(a, b)라고 하자.  
정수 a, b, q r (b ≠ 0)에 대하여 a = bq + r,이면 G(a, b) = G(b, r)가 성립한다.  
[네이버 지식백과] 유클리드 호제법 (통합논술 개념어 사전, 2007. 12. 15., 청서출판)

#### 유클리드 호제법의 사용  
유클리드 호제법은 큰 수들의 최대공약수를 구할 때 사용할 수 있다.

a = bq + r 에서 r = a - bq 이므로 G(a, b) = G(a, a - bq)이다. 이제 직접 적용을 해보자.  
(예) G(180, 200) = G(180, 200 - 180) = G(180, 20) = G(180 - 20 × 8, 20) = G(20, 20) = 20

일반적으로 두 정수의 최대공약수를 구할 때에는 소인수분해하여 공통인수를 찾아낸다. 하지만 소인수분해할 때, 합성수가 큰 소수를 인수로 갖는다면 소인수분해가 쉽지 않을 것이다. 유클리드 호제법은 소인수분해하지 않고 최대공약수를 구할 수 있는 방법이다.
[네이버 지식백과] 유클리드 호제법 (통합논술 개념어 사전, 2007. 12. 15., 청서출판)  

```c
#include <stdio.h>
int euclidean(int num1, int num2);

int main(void)
{
	int num1, num2;

	printf("두 개의 정수 입력: ");
	scanf_s("%d %d", &num1, &num2, 1);

	printf("두 수의 최대공약수: %d \n", euclidean(num1, num2));

}
int euclidean(int num1, int num2)
{

	if (num1 > num2)
		num1 -= num2;
	else
		num2 -= num1;

	if (num1 == num2)
	{
		return num1;
	}
	else
		euclidean(num1, num2);
}
```
어려운건 수학 알고리즘이 있으면 쉽게 풀 수 있다는 걸 느꼈다. 따로 또 공부해야겠다.   


## 도전6  

- 사용자로부터 초(second)를 입력 받은 후에, 이를 [시, 분, 초]의 형태로 출력하는 프로그램을 작성  

```c
#include <stdio.h>

int main(void)
{
	int sec = 0;
	int hour = 0;
	int minute = 0;

	printf("초(second) 입력: ");
	scanf_s("%d", &sec, 1);

	hour = sec / 3600;
	sec = sec - hour * 3600;

	minute = sec / 60;
	sec = sec - minute * 60;

	printf("[h:%d, m:%d, s:%d] \n", hour, minute, sec);
	return 0;
}  
```  
책에서는 함수를 만들어 사용했다. 나는 그냥 했다.  
