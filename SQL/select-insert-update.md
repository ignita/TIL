# SELECT와 INSERT, UPDATE 

- `SELECT`한 값을 `INSERT`, `UPDATE` 하는 방법 

## UPDATE 
```SQL
UPDATE TA SET 
TA.NAME = TB.TITLE
FROM TABLE_A TA, TABLE_B TB
WHERE TA.ID = TB.ID
```
- TABLE_B의 TITLE 값을 TABLE_A의 NAME으로 `UPDATE`

## INSERT 

- TABLE_A와 TABLE_B의 값이 완전히 일치할 때 
    ```SQL
    INSERT INTO TABLE_B
    SELECT *
      FROM TABLE_A
    --WHERE 조건
    ```
    - TABLE_A의 전체 레코드를 TABLE_B로 `INSERT` 

- TABLE_A와 TABLE_C의 값이 일치하지 않을 때 
    ```SQL 
    INSERT INTO TABLE_C
    (
        COLUMN1
    ,   COLUMN2
    ...
    )
    SELECT COLUMN1
        ,  COLUMN2
        ...
      FROM TABLE_A 
    ``` 

- `SELECT INTO` 사용 
    - 새로운 테이블을 만들어 `INSERT` 
    ```SQL
    SELECT *
      INTO TABLE_D 
      FROM TABLE_A 
    --WHERE 
    ```
    - TABLE_D는 존재하지 않는 테이블이어야 함 