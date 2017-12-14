# WHERE절에 NULL값 조건 

새 프로젝트는 MSSQL을 사용하게 되었다.   
WHERE절에 넘겨받는 파라미터에 NULL값이 들어가면 특정 컬럼이 NULL인 것만,  
NULL이 아니면 특정 컬럼이 그 해당 파라미터값이 되도록 하려고 했다.  
아주 간단하다고 생각했었다.  
그런데 파라미터가 총 3개여서 앞에다 컬럼 IS NULL 해버리면 다음조건을 거는게 문제가 생겼다.   
`CASE WEHN (@파라미터= NULL THEN 컬럼 IS NULL ELSE 컬럼 = @파라미터 END )` 
요런식도 해보았지만 될리가 없었는데
아주 간단한 방법이 있었다. 

```SQL
SET @파라미터 = CASE WHEN ISNULL(@파라미터, 0) = 0 THEN 0 ELSE @파라미터 END

WHERE (@파라미터 = 0 AND 컬럼 IS NULL)     -- NULL
   OR (@파라미터2 = 0 AND 컬럼 = @파라미터) -- NOT NULL
```
예전부터 배우고 써왔던 간단한 비트 연산자를 왜 생각을 못했을까? 
