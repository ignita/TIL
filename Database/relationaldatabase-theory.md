# 관계형 데이터베이스 이론  

- **topic 테이블**      

 | id | title | author |  
 | :----- | :----- | :----- |  
 | 1 | About Java.... | 1 |  
 | 2 | Variable a... | 2 |  
 | 3 | Operator | 1 |  
 | 4 | Conditional | 2 |  
 | 5 | function | 2 |  
 | 6 | Object | 3 |  

- DB에서 중복을 몰아내자!!! 
 - topic 테이블의 중복되는 author 컬럼 → 따로 user라는 테이블을 만든다. 이름마다 id값을 정해줌.    
 - **user 테이블**  
   
   | id | name |   
   | :---- | :---- |  
   | 1 | egoing |  
   | 2 | jin  | 
   | 3 | k8805 |  
   | 4 | sorialgi |  
   | 5 | lily |  
   | 6 | happydeveloper |   

 - 두 테이블을 더해 하나의 테이블을 만들면 어떨까?   
    - `SELECT title,name FROM topic LEFT JOIN user ON topic.author = user.id`    
    - `LEFT JOIN`: 왼쪽에 있는 테이블을 기준으로 해서  
    - `ON topic.autor = user.id` : topic.autor = user.id를 참고해서 합친다.  

      | id | title | author | id | name |  
      | :----- | :----- | :----- | :----- | :----- |   
      | 1 | About Java.... | 1 | 1 | egoing |  
      | 2 | Variable a... | 2 | 2 | jin | 
      | 3 | Operator | 1 | 1 | egoing |  
      | 4 | Conditional | 2 | 2 | jin |  
      | 5 | function | 2 | 2 | jin |  
      | 6 | Object | 3 | 3 | k8805 |   

    - `SELECT title, name` : title과 name 컬럼만 가져온다.   
  
       | title | name |  
       | :----- | :----- |   
       | About Java.... | egoing |  
       | Variable a... | jin | 
       | Operator | egoing |  
       | Conditional | jin |  
       | function | jin |  
       | Object | k8805 |    
      
      - 실제로 위와 같이 저장된 것이 아니라 SQL 대로 조합해서 만든 가상, 논리적인 테이블이다.   

- JOIN 같은 연산자를 통해 두 개의 테이블이 서로 긴밀하게 관계를 맺고 있는 것이 **관계형 데이터베이스**라고 한다.   


