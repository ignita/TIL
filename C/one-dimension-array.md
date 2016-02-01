## 배열의 이해와 배열의 선언 및 초기화  

- 1차원 배열의 선언에 필요한 것 세 가지  
  - 배열이름  
  - 자료형  
  - 길이정보  
- `int oneDimArr[4]`  
  - int: 배열을 이루는 요소(변수)의 자료형  
  - oneDimArr: 배열의 이름   
  - [4]: 배열의 길이  

- 반복문 기반의 순차적 접근이 가능하다.  

## scanf() 함수는 공백이 입력의 끝을 알린다.  

```c
#include <stdio.h>

int main(void)
{
	char str[50];
	int idx = 0;

	printf("문자열 입력: ");
	scanf_s("%s", str, 50);
	printf("입력 받은 문자열: %s \n", str);

	printf("문자 단위 출력: ");
	while (str[idx] != '\0')
	{
		printf("%c", str[idx]);
		idx++;
	}
	printf("\n");
	return 0;
}
```  
위 예제에서 계속 띄어쓰기 이후로는 값을 못 받길래 찾아봤더니 scanf() 함수는 공백 이후로는 값을 읽어내지 못한다는 것을 알게되었다.  
공백 너머 문자열까지 받으려면 scanf() 함수를 여러번 사용하거나 `gets` 또는 `fgets`를 이용하면 된다.   

## 배열을 이용한 문자열 변수의 표현  

- 문자열 끝에는 자동으로 삽입되는 `'\0'`이 있다.  
- 널(null)문자라고 한다.  
- scanf() 함수호출을 통해서 입력 받은 문자열 끝에도 널 문자가 삽입 된다.  
- 문자열의 끝을 알리기 위해 사용하는 것이다.  

- 아스키 코드가 가장 큰 문자 찾기  

```c
#include <stdio.h>

int main(void)
{
	char word[100];
	int len = 0, i = 0;
	char max;

	printf("영단어 입력: ");
	scanf_s("%s", word, 100);

	while (word[len] != 0)
		len++;

	max = word[0];
	for (i = 0; i < len; i++)
	{
		if(word[i] > max)
			max = word[i];
	}

	printf("아스키 코드의 값이 가장 큰 문자: %c \n", max);

	return 0;
}
```
