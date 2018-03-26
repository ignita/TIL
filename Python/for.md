# for 반복문

## for in list

```python
for pattern in patterns:
    print(pattern)
```
- 리스트 `patterns`의 값을 하나씩 꺼내 `pattern`으로 전달
- 리스트 길이만큼 `print(pattern)` 실행
- 순회할 **리스트**가 정해져 있을 때 사용하면 좋다. 

## for in range

- `range`
    - 필요한 만큼 숫자를 만들어낸다. 
    ```python
    for i in range(1000):
    print(i)
    ```
- `enumerate` 
    - 순서와 리스트의 값 전달 
    ```python
    names = ['영희', '철수']
    for i, name in enumerate(names):
        print('{}번: {}'.format(i + 1, name))
    ```
- 순회할 **횟수**가 정해져 있을 때 