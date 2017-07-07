# SQL

- SQL(Structured Query Language)  
 사용자가 데이터베이스 관리 시스템(DBMS)과 의사소통을 할 때 사용하는 프로그래밍 언어. 대소문자 구별 x 
 - SQL구문을 간단히 **쿼리(query)**라고도 한다.
 - 데이터를 
   - INSERT(입력)
   - SELECT(조회)
   - UPDATE(수정)
   - DELETE(삭제)  

## INSERT 문 

- 예시 
```sql
--INSERT INTO 테이블(열1, 열2, ..., 열n)  
--VALUES(값1, 값2, ..., 값n)

INSERT INTO Member(UserID, Password, Name, Phone)
VALUES('aaaa', '1111', '홍길동', '010-111-1111')
```  

- 기본 키로 설정되어있는 값은 중복 입력될 수 없다. 

## SELECT 문  

- 예시 
```sql
--SELECT 열1, 열2, ..., 열n
--FROM 테이블 
--[WHERE 조건]  
--[ORDER BY 정렬기준_열 [ASC|DESC]]

SELECT * FROM Member
ORDER BY UserID DESC 

SELECT * FROM Member
WHERE UserID = 'aaaa'
```
- 대괄호 부분은 선택 사항. 생략이 가능하다. 
- WHERE는 조회할 데이터의 조건을 지정.  
- `SELECT * FROM Member`: Member 테이블에 있는 모든 데이터를 조회.


## UPDATE 문 

- 예시
```sql
--UPDATE 테이블 
--SET 열1 = '값1', 열2 = '값2', ..., 열n = '값n'
--[WHERE 조건]

UPDATE Member
SET Phone = '010-222-2222'
WHERE UserID = 'aaaa'
```
- 위 예시에서 WHERE 조건을 빠트리면 모든 회원 연락처가 변경된다. 

## DELETE 문 

- 예시
```
--DELETE FROM 테이블 [WHERE 조건]

DELETE FROM Member WHERE UserID = 'aaaa'
```
- DELETE도 WHERE을 실수로 빠트리지 않도록 조심해야 한다. 

## 관계

- DBMS는 여러 테이블을 포함할 수 있고 서로간의 다양한 관계를 맺을 수 있다.  
- 그때 사용하는 것이 JOIN 문
 - 일대일(1:1)
 - 일대다(1:N)
 - 다대다(N:N) 관계가 존재. 

- 외래 키: 부모 테이블의 기본 키와 연결되는 자식 테이블의 열을 **외래 키**라고 한다. 
- 개체 관계도(Entity Relationship Diagram, ERD): 테이블(개체) 간의 관계를 나타낸 다이어그램  

- 예시  
```sql
-- Member 테이블 
INSERT INTO Member(UserID, Password, Name, Phone)
VALUES('aaaa', '1111', '홍길동', '010-111-1111')

INSERT INTO Member(UserID, Password, Name, Phone)
VALUES('bbbb', '2222', '김김김', '010-222-22222')

INSERT INTO Member(UserID, Password, Name, Phone)
VALUES('cccc', '3333', '버블티', '010-333-3333')

-- Cart 테이블 
INSERT INTO Cart(UserID, ItemName, Qty, Price)
VALUES('aaaa', '우유', 2, 2200)

INSERT INTO Cart(UserID, ItemName, Qty, Price)
VALUES('aaaa', '라면', 3, 800)

INSERT INTO Cart(UserID, ItemName, Qty, Price)
VALUES('bbbb', '현미(3KG)', 1, 9000)
```
- 한 회원이 여러 개의 물품을 담을 수 있으므로 회원과 장바구니는 일대다(1:N) 관계.
- Member 테이블에 존재하지 않는 'zzzz'라는 UserID를 Cart 테이블에 입력하려고 하면?  
  - 오류로 입력되지 않는다. 부모 테이블에 존재하지 않는 기본 키는 자식 테이블의 외래 키 값으로 입력될 수 없다.  
  - → 데이터의 신뢰성 ↑  

> ※ 실무에서는 회원 아이디를 기본키로 하지 않는다. 회원이 탈퇴할 경우 회원의 데이터(히스토리)를 일정 기간 유지하기 위해 데이터를 바로 삭제 하지 않는데 그 기간 동안 다른 사용자가 동일한 아이디를 등록할 수 있어야 하기 때문이다. 1씩 증가하는 ID 열을 기본 키로 하거나 특정 로직으로 만든 값을 저장하는 임의의 열을 기본키로 설정하는 것이 보통이다. 

### JOIN 문  

- 관계를 맺고 있는 테이블들을 결합(연결)해 조회 가능하다.  
- INNER JOIN과 OUTER JOIN  

```sql
SELECT M.UserID, M.Name, M.Phone, C.ItemName, C.Qty, C.Price 
FROM Member M INNER JOIN Cart C 
ON M.UserID = C.UserID 
```
- FROM 절에서 Member 테이블의 별칭을 M으로 Cart는 C로 지정.  
- INNER JOIN 키워드로 연결. ON 키워드 다음에 연결 조건을 명시  
- cccc 회원은 연결되는 부분이 없기(cccc 회원은 장바구니에 담은 것이 없음) 때문에 조회되지 않는다.  
 - INNER JOIN은 관계를 맺고 있는 두 테이블의 연관된 교집합만 조회됨. 
- 교집합이 아니라 모든 회원의 장바구니를 확인하려면 `OUTER JOIN`을 사용  
```sql
SELECT M.UserID, M.Name, M.Phone, C.ItemName, C.Qty, C.Price 
FROM Member M LEFT OUTER JOIN Cart C 
ON M.UserID = C.UserID 
```
- OUTER JOIN 옆의 LEFT 키워드는 OUTER JOIN 왼쪽에 있는 Member 테이블을 기준으로 OUTER JOIN 하겠다는 의미.  
 - 기준이 되는 테이블의 모든 정보를 보여준다.   
 - 그러므로 Cart 테이블에 정보가 없는 회원(cccc)도 모두 조회가 된다. 이때 Cart 테이블의 열은 정보가 없으므로 NULL로 표시.  

## 저장 프로시저  
- 일련의 SQL 구문을 하나의 함수처럼 실행하기 위한 SQL 구문 집합 
 - 모듈식 프로그래밍이 가능해진다. 성능 향상도 있음. 

```sql
CREATE PROCEDURE usp_SelectMemberByUserID 
    @UserID varchar(30)
AS
BEGIN
    SELECT UserID, Password, Name, Phone
    FROM Member
    WHERE UserID = @UserID
END  
```
- BEGIN ~ END 사이에 실제 실행될 SQL 구문을 위치시킨다.  
- AS는 실제 실행될 SQL 구문과 매개변수를 구분해준다.  
- 저장 프로시저 실행: `EXEC usp_SelectMemberByUserID 'aaaa'`

## 트랜잭션  
- 더 이상 쪼갤 수 없는 하나로 묶여진 프로세스(조회, 입력, 수정, 삭제) 처리 단위  
- 묶여진 프로세스가 모두 성공 하거나 아니면 실패하는 경우로만 처리된다.  
- 예를 들어, 돈이 오가는 중요한 프로세스는 트랜잭션으로 다루어야 한다.  
 - A은행에서 B은행으로 송금  
    - A은행의 DB에서 100만원을 차감하는 UPDATE가 실행
    - B은행의 DB에서 100만원을 증액하는 UPDATE가 실행   
    - 둘 다 성공이면 프로세스는 그대로 적용. A은행 UPDATE 후 B은행의 UPDATE가 실패하면 A은행의 UPDATE도 취소하고 모든 프로세스를 이전 상태로 되돌려야 한다.  
- SQL에서의 트랜잭션을 시작할 때는 `BEGIN TRANSACTION` 키워드를 사용 
- 모든 프로세스가 성공적이어서 데이터베이스로 적용할 때는 `COMMIT` 키워드  
- 모든 프로세스를 다시 이전 상태로 되돌리는 트랜잭션의 취소는 `ROLLBACK` 키워드  

```sql
CREATE PROCEDURE usp_InsertMemberAndCart
AS
BEGIN TRY 
    BEGIN TRANSACTION -- 트랜잭션을 시작한다. 
    INSERT INTO Member(UserID, Password, Name, Phone)
    VALUES('xxxx', '0000', 'xxxx', '000-000-000')

    INSERT INTO Cart(UserID, ItemName, Toy, Price)   
    VALUES('yyyy', '생수', 6, 5000)

-- 만약 코드가 여기까지 진행되면 모든 코드가 성공적이라는 뜻  
    COMMIT -- 트랜잭션에 포함된 모든 프로세스를 그대로 DB에 적용  
END TRY  

BEGIN CATCH -- CATCH 블록은 TRY 블록에서 발생한 오류를 캐치.  
    IF (@@TRANCOUNT > 0 ) -- 트랜잭션이 존재한다면   
        ROLLBACK -- 트랜잭션을 취소하여 모든 프로세스를 이전 상태로 되돌린다.   

-- 아래 구문은 오류와 관련된 정보를 생성하고 등록  
    DECLARE @ErrorMsg nvarchar(4000), @ErrorSeverity int
    SELECT @ErrorMsg = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY()
    RAISERROR(@ErrorMsg, @ErrorSeverity, 1)
END CATCH  
```
- 존재하지 않는 yyyy라는 UserID를 Cart 테이블에 입력하기 때문에 오류가 발생한다. CATCH 블록이 실행되고, TRANCOUNT 발생한 트랜잭션의 수를 반환. 1번 발생했으므로 ROLLBACK이 실행된다. 
- ERROR_MESSAGE()는 에러 메시지 반환. ErrorSeverity()는 오류의 심각도를 반환. 
- RAISERROR()는 오류 정보를 등록   
- `VALUES('xxxx', '생수', 6, 3000)`과 같이 구문을 수정하면 오류가 발생하지 않고 COMMIT문이 실행되어 모두 정상적으로 데이터베이스에 적용된다.  