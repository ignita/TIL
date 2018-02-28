# UNION 과 UNION ALL의 차이 

- 둘 다 테이블 결합 
    - UNION 
        - 중복되지 않는 값 반환 
        - 중복을 제거하기 위해 불가피하게 SORT한다. 
        - 자료가 많거나 INDEX가 없는 컬럼을 대상으로 하면 쿼리 계산 시간이 길어질 수 있다. 

    - UNION ALL 
        - 중복 값 까지 반환 


## 참고 사이트 
- http://20140501.tistory.com/63