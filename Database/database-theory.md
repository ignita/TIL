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

- DB 사용하기  
```
mysql> use opentutorials;
Database changed
```  

- table 만들기  
```
mysql> CREATE TABLE `topic` (
    -> `id` int(11) NOT NULL AUTO_INCREMENT, 
    -> `title` varchar(100) NOT NULL, 
    -> `description` text NOT NULL,
    -> `author` varchar(30) NOT NULL,
    -> `created` datetime NOT NULL,
    -> PRIMARY KEY(id)  
    -> ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
Query OK, 0 rows affected (0.04 sec)
```
 - topic: table명  
 - id: 컬럼명  
 - int(11): id는 숫자가 와야한다.  
 - NOT NULL: 반드시 id값이 존재해야한다.  
 - AUTO_INCREMENT: 행이 추가될 때마다 숫자를 1씩 올림  
 - `title` varchar(100): title에 들어가는 정보가 100자 이내  
 - `description` text : description에 들어가는 정보는 긴 텍스트를 받을 수 있어야함  
 - `author` archer(30): 작성자  
 - `created` datetime: 시간과 날짜  

- table 확인  
```
mysql> show tables;
+-------------------------+
| Tables_in_opentutorials |
+-------------------------+
| topic                   |
+-------------------------+
1 row in set (0.00 sec)
```  

- 정보를 table에 추가하기  
```
mysql> INSERT INTO `topic` (title, description, author, created) VALUES('about javascript', 'javascript is ~~', 'egoing', '2016-9-30 11:57:5');
Query OK, 1 row affected (0.02 sec)
```  

- 정보 가져오기  
```
mysql> SELECT * FROM topic;
+----+------------------+------------------+--------+---------------------+
| id | title            | description      | author | created             |
+----+------------------+------------------+--------+---------------------+
|  1 | about javascript | javascript is ~~ | egoing | 2016-09-30 11:57:05 |
+----+------------------+------------------+--------+---------------------+
1 row in set (0.01 sec)
```  
 - SELECT: 선택  
 - *: 컬럼  
 - AUTO_INCREMENT는 정보를 직접 추가하지 않아도 자동으로 증가.  

- id로 찾기  
```
mysql> select id,title,author,created from topic WHERE id=3;
+----+----------+--------+---------------------+
| id | title    | author | created             |
+----+----------+--------+---------------------+
|  3 | Opeartor | egoing | 2015-06-18 05:00:00 |
+----+----------+--------+---------------------+
1 row in set (0.01 sec)
```  

- 정렬: id가 큰 순서대로    
```
mysql> select id,title,author,created FROM topic ORDER BY id DESC;
+----+-------------------------+---------+---------------------+
| id | title                   | author  | created             |
+----+-------------------------+---------+---------------------+
|  3 | Opeartor                | egoing  | 2015-06-18 05:00:00 |
|  2 | variable and constatntt | the1994 | 2016-09-30 12:03:05 |
|  1 | about javascript        | egoing  | 2016-09-30 11:57:05 |
+----+-------------------------+---------+---------------------+
3 rows in set (0.00 sec)
```   


