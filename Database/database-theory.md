# 데이터베이스 이론  

- 데이터베이스: 정보를 관리하는 전문 애플리케이션  

## 장점  
- 안전하다.  
- 빠르다(인덱스).  
- 프로그래밍적 제어가능  

## 관계형 데이터베이스  
- 제품  
 - MySQL 
 - MSSQL
 - Oracle    

## MySQL  
- 웹과 함께 발전  
- open source  
- Structured  
 - 표 == table(ex. Excel)  
- **S**tructured **Q**uery **L**anguage

- 웹브라우저 → 웹서버 → PHP → MySQL  
                  
### 사용법  

- MySQL Client(MySQL monitor) ↔ MySQL Server  

- MySQL monitor    
 - 실행하기   
  - mampstack 설치 폴더/mysql/bin으로 이동  
  - `./mysql -hlocalhost -uroot -p` 입력 후 엔터, 그리고 password 입력  
     - `mysql`: mysql monitor라는 프로그램을 실행  
     - `-h` : -h 뒤에 따라오는 것이 mysql 서버의 주소라는 의미(여기선 localhost: 컴퓨터 자신)    
     - `-u` : -u 뒤에 따라오는 것이 비밀번호  
     - `-p` : 비밀번호를 입력받아라는 의미(바로 적으면 해킹을 당할 수 있음)  

- 하나의 서버 안에는 여러 개의 데이터베이스가 있을 수 있고, 하나의 데이터베이스 안에는 여러 개의 테이블이 있을 수 있다!    
- 현재 접속한 서버의 존재하는 데이터베이스 알아보기  
```
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| test               |
+--------------------+
4 rows in set (0.02 sec)
```

- DB 만들기  
```
mysql> CREATE DATABASE opentutorials CHARACTER SET utf8 COLLATE utf8_general_ci; 
Query OK, 1 row affected (0.00 sec)
```
 - `show databases;`로 확인  
 ```
 mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| opentutorials      |
| performance_schema |
| test               |
+--------------------+
5 rows in set (0.00 sec)

```
