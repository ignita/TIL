# 스위프트 프로그래밍   

## 데이터 다루기  

### 변수와 상수   

**변수 만들기**  
- 이름을 지정하고 =로 값을 넣기  
```swift
var <변수 이름> = <값>
```  

**상수 만들기**  
- 상수는 선언 후에 값을 변경할 수 없다.  
```swift
let <변수 이름> = <값>  
```

**상수와 변수의 차이**  

- 상수는 값 자체가 중요할 때 사용  
- **중요한 값에 의미를 붙여 이해하기 쉽게 만들기 위한 것**   
  - 예) 부가가치세   
  ```swift  
  //let answer = 2000 * 0.1    // 무슨 계산인지 알기 어렵다.

  let taxRate = 0.1            // 부가가치세 0.1에 taxRate라는 이름을 지정
  let answer = 300 * taxRate   // 부가가치세를 구하는 계산임을 어느 정도 이해 가능  
  ```  
- 반대로 **변수는 값을 넣는다는 자체가 중요할 때** 사용  
- 예) 게임 점수: 게임을 하는 동안 계속해서 변화   

**이름을 붙이는 방법**    
- 예약어는 사용할 수 없음  
 - 예약어: 스위프트가 이미 내부적으로 사용하고 있는 명령 또는 이름으로 예약된 단어  
 - ex) var, let, class 등  
 - 예약어 목록  

   | 종류 | 예약어 |  
   | --- | --- |
   | 선언 | class, deist, enum, extension, func, import, init, internal, let, operator, private, protocol, public, static, struct, subscript, type alias, var  |  
   | 구문 | break, case, continue, default, do, else, fallthrough, for, if, in, return, switch, where while |  
   | 식 또는 자료형 | as, dynamicType, false, is, nil, self, Self, super, true, `__COLUMN__`, `__FILE__`, `__FUNCTION__`, `__LINE__` |  
   | 기타 | associativity, convenience, dynamic, didSet, final, get, infix, inout, lazy, left, mutating, none, non mutating, optional, override, postfix, precedence, prefix, Protocol, required, right, set, Type, unowned, weak, willSet |  

- 이름 규칙의 종류  

| 이름 | 방법 | 예 | 
| --- | --- | --- |  
| 캐멀 케이스 | 두 번째 이후의 단어 앞글자르 대문자로 입력 | myDaya, photoFrameName |  
| 파스칼 케이스 | 모든 단어의 앞글자를 대문자로 입력 | MyData, PhotoFrameName |  
| 스네이크 케이스 | 단어 사이에 언더 바를 붙임 | my_data, photo_frame_name |  

- 스위프트에서는 캐멀 케이스를 사용하는 명명규칙을 추천한다.  

## 자료형  

- 자료형: 변수 또는 상수에 저장할 수 있는 자료의 종류   
- 스위프트가 자동을 설정해주기는 하지만 코드를 작성할 때 자료형을 명시적으로 쓰면 이해하기 쉬우므로 수동으로 지정해주는 것이 일반적   
```swift  
var <변수 이름>:<자료형> = <값>  
```

**자료형의 종류**  

- 정수 자료형: Int  
- 부동 소수 자료형: Double, Float  
- 불 자료형: Bool  
- 문자열 자료형: String  
 - 글자의 앞과 뒤를 큰 따옴표로 감싸서 만든다.  
 ```swift  
 var <변수 이름> = "문자열"  
 ```  
 - 2개의 문자열을 +로 결합할 수 있다.  
 ```swift 
 <변수 이름> = <문자열> + <문자열>  
 ```
 - 문자열 내부에 변수의 값을 넣어 문자열로 만들 수 있다.  
 ```swift  
 var fruitName = "바나나"  
 var myStr = "저는 \(fruitName)가 좋아요!"  
 ``` 

**자료형 변환**  
- 자료형이 서로 다른 것들은 계산할 수 없다.  
 - 따라서 서로 다른 자료형의 자료를 계산할 때는 자료형을 변환해서 계산  
 ```swift
 let inputString = "100"
 let answer = Int(inputString)! * 5  // 사용자가 입력한 문자열로 계산

 let intValue = Int(123.45)          // 소수점 이하 부분은 제거    
 ```
 ```
 let appleCount = 5
 let myMessage:String = "바나나가 " + String(appleCount) + "개 있습니다."
 ```  

## 프로그램 제어  
- 분기 처리: 조건에 따라 문장의 실행 여부를 결정하는 제어  
- 반복 처리: 조건을 만족하는 동안 문장을 계속해서 실행하는 제어  

**if 조건문**  
```swift
var score = 100
if 88 < score {
        print("GOOD!")
}
```

**if else 조건문**  
```swift  
if <조건식> {
 <조건 만족 처리>  
} else {
 <조건 만족 x 처리>  
}
```

**switch 조건문[분기 처리]**  
```swift
var dice = 1
switch dice {
case 1:                             // 1이 나오면 다음 문장 실행
    print("시작점으로 돌아갑니다.")
case 2,5:                           // 2 또는 5가 나오면 다음 문장 실행
    print("다시 한 번 던집니다.")
default:                            // 그 외의 값이 나오면 다음 문장 실행
    print("주사위의 숫자만큼 전진합니다.")
}
```

**while 반복문[반복 처리]**  
```swift
var d = 0
while (d < 100) {
    d += 7;
}
print("답은 \(d)입니다.")
```
- 사이드 바에 있는 둥근 사각형 버튼을 누르면 그래프로 확인할 수 있다.  

**for 반복문[반복 처리]**
- 시작값부터 종료값까지 반복  
```swift 
for <반복 전용 변수 이름> in <시작값> ... <종료값> {
 <반복 처리> 
}
```
```swift  
for i in 0...3 {
    print(i)
}
```
- 종료값보다 하나 작은 값까지만 반복  
```swift
for i in 0..<3 {
    print(i)
}
```

**같은 처리를 반복만 하고 싶을 때**  
- for 반복문에서 사용하는 반복 전용 변수를 블록 내부에서 사용하지 않으면 경고가 발생한다.  
- 같은 처리를 반복만 하고 싶을 때는 따로 반복 전용 변수를 사용할 필요가 없기 때문에 변수에 _(언더바)를 사용하면 된다.  
```swift
for _ in 0..2 {
    
}
```

## 여러 개의 데이터 다루기  

### 배열

**배열 만들기**  
```
배열[인덱스] = 요소  
```

- 값을 넣어 배열 만들기
```swift
var intArray1 = [1,2,3]
var strArray1 = ["A", "B", "C"]
```

- 자료형을 지정해서 배열 만들기  
```swift
var intArray2:[Int] = [1,2,3]
var strArray2:[String] = ["A", "B", "C"]
```  

- 같은 초기값이 들어있는 배열 만들기  
 - 값과 갯수를 지정한다.  
 ```swift
 var intArray3 = Array(repeating: 0, count: 3)
 var strArray3 = Array(repeating: "A", count: 5)  
 ```

- 빈 배열 만들기  
 - 자료형을 자동으로 설정할 수 없기 때문에 직접 지정  
 ```
 var emptyArray1:[String] = []
 var emptyArray2 = [String]()
 ```

**배열 확인**  

- 요소 갯수 확인  
 - count를 사용  
 ```swift
 var intArray4 = [1,2,3,4,5]
 print(intArray4.count)  
 ```
- 요소 확인  
```swift
print(intArray5[0])
```

- 모든 요소 확인  
```swift
var strArray6 = ["A", "B", "C"]
for val in strArray6 {
    print("요소=\(val)")
}
```

**배열의 조작**  
- 가장 마지막 위치에 요소 추가  
 - `append()` 사용  
 ```swift
 var strArray7 = ["A", "B", "C"]
 strArray7.append("D")
 print(strArray7)
 ```  

- 지정한 위치에 요소 추가  
 - `insert()`를 사용  
 ```swift
 var strArray8 = ["A", "B", "C"]
 strArray8.insert("X", at:1)
 print(strArray8)
 ```  

- 지정한 위치의 요소 제거  
 - `remove()` 사용  
 ```swift
 var strArray9 = ["A", "B", "C"]
 strArray9.remove(at: 1)
 print(strArray9)
 ```   

- 요소 모두 제거  
 - `removeAll()` 사용 
 ```swift
 var strArray10 = ["A", "B", "C"]
 strArray10.removeAll()
 print(strArray10)
 ```

 

