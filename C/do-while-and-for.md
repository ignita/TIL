## do-while문  

반복영역을 최소한 한번은 실행하는 구조  

- 0 이상 100이하 짝수의 합
  ```
  #include <stdio.h>

  int main(void)
  {
  	int num = 0, total = 0;

  	do {
  		total += num;
  		num += 2;
  	} while (num <= 100);
  	printf("짝수의 합: %d\n", total);
  	return 0;
  }
  ```
  ```
  짝수의 합: 2550   
  ```  

## for문  

  ```
  for(초기식 ; 조건식 ; 증감식)
  {
    // 반복의 대상이 되는 문장들  
  }  
  ```  

조건식이 비워지면 무조건 '참'으로 인식되어 **무한루프**  

- 팩토리얼 계산   

  ```
  #include <stdio.h>

  int main(void)
  {
  	int n = 0, fact = 0;

  	printf("정수 입력: ");
  	scanf_s("%d", &n);

  	for (fact = 1; n > 0; n--)
  	{
  		fact *= n;
  	}
  	printf("n! = %d\n", fact);
  	return 0;
  }  
```
- for문의 중첩  
  - 구구단  

  ```
  #include <stdio.h>

  int main(void)
  {
  	int cur, is;

  	for (cur = 2; cur < 10; cur++)
  	{
  		for (is = 1; is < 10; is++)
  			printf("%dx%d=%d \n", cur, is, cur*is);
  		printf("\n");
  	}
  	return 0;
  }  
  ```
