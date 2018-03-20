# 사용자 입력 받기 

## 프로그래밍의 3단계 
- **사용자 입력**
- 자료 처리
- 결과 출력

## `input()`
- 사용자의 키보드 입력을 return 
```python
print('가위 바위 보 중 하나를 내세요> ', end = ' ')
mine = input()
print('mine: ', mine)
```
- `print()` 끝에 end를 넣으면 해당 문자열에 바로 이어서 입력을 받는다. 
- end를 넣는 대신에 input에서도 문자열 출력이 가능하다. 
```python
mine = input('가위 바위 보 중 하나를 내세요> ')
```

## <kbd>Ctrl</kbd> + <kbd>c</kbd>
- 프로그램 종료 