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

- 배열의 정렬: 오름차순  
 - `var <새로운 배열 이름> = <배열 이름>.sorted( by: < )`
```swift
var intArray11 = [4,3,1,5,2]                // 숫자가 섞인 배열

var sortArray11 = intArray11.sorted(by: <)  // 오름차순으로 정렬
print(sortArray11)                          // 결과 확인
```

- 배열의 정렬: 내림차순  
 - `var <새로운 배열 이름> = <배열 이름>.sorted( by: > )`  
```swift
var intArray12 = [4,3,1,5,2]                // 숫자가 섞인 배열  

var sortArray12 = intArray12.sorted(by: >)  // 내림차순으로 정렬  
print(sortArray12)                          // 결과 확인
```

### 딕셔너리  

- 여러 개의 데이터를 다룰 때 이름과 데이터를 함께 저장하고, 이름을 사용해 데이터를 읽고 쓰고 싶을 때 **딕셔너리**(Dictionary)를 사용  
- 배열과 비슷, 배열은 번호를 지정, 딕셔너리는 문자열을 지정  
 ```
 딕셔너리[키] = 요소  
 배열[인덱스] = 요소
 ```

**딕셔너리 만들기**  

- 값을 넣어 딕셔너리 만들기  
 - <키>:<값>의 형태를 쉼표로 연결하고 대괄호로 감싸서 만든다.  
 `var <딕셔너리 이름> = [<키>:<값>, <키>:<값>, <키>:<값>, ...]`   
```swift
var intDictionary1 = ["a":1, "b":2, "c":3]        // 정수 딕셔너리 데이터
var strDictionary1 = ["a":"가", "b":"나", "c":"다"] // 문자열 딕셔너리 데이터
```

- 빈 딕셔너리 만들기  
```
var <딕셔너리 이름>:[ <자료형>:<자료형> ] = [ : ]  
var <딕셔너리 이름> = [ <자료형>:<자료형> ]() 
```
```swift
var emptyDictionary1:[String:Int] = [:]
var emptydictionary2 = [String:Int]()
```  

**딕셔너리의 확인**  

- 요소 갯수 확인  
 - `<딕셔너리 이름>.count`  
```swift 
var strDictionary2 = ["a":"A", "b":"B", "c":"C"]    // 딕셔너리 데이터 만들기  
print(strDictionary2.count)
```

- 요소 확인  
 - 키에 대응하는 값이 없을 대에는 `nil`을 반환  
 - 따라서 if 조건문으로 값이 있는지 없는지를 확인  
 - `<딕셔너리 이름>[ <키> ]`   
```swift  
var strDictionary3 = ["a":"가", "b":"나", "c":"다"] // 딕셔너리 데이터 만들기  
print(strDictionary3["c"]) // 요소 출력

if let getValue = strDictionary3["c"] {     // 값이 있다면 상수로 만든다.
    print(getValue)                         // 해당 값을 출력
} else {
    print("not found.")                     // 값이 없을 때 출력
}
```  

- 모든 요소 확인  
```
for (<키를 넣을 변수>, <값을 넣을 변수>) in <딕셔너리 이름> { 

}
```
```swift
var strDictionary4 = ["a":"가", "b":"나", "c":"다"]    // 딕셔너리 데이터 만들기  
for (key, value) in strDictionary4 {
    print("strDict[\(key)]=\(value)")
}
```

**딕셔너리의 조작**  

- 딕셔너리에 요소 추가    
- `<딕셔너리 이름>[ <키> ] = <값>`
```swift
var strDictionary5 = ["a":"가", "b":"나"] // 딕셔너리 데이터 만들기
strDictionary5["x"] = "다"               // 요소를 추가
print(strDictionary5["x"]!)             // 추가된 요소 출력
```  

- 요소 제거  
 - `<딕셔너리 이름>.removeValue( forKey:<키 이름> )`  
```swift
var strDictionary6 = ["a":"가", "b":"나", "c":"다"]    // 딕셔너리 데이터를 만듭니다.  
strDictionary6.removeValue(forKey: "b")              // 요소를 제거
print(strDictionary6)
```

### 튜플  

- 여러 개의 데이터를 세트로 만들고, 순서를 사용해 요소를 다루는 자료형  
- 배열과 비슷, 다른 종류의 데이터를 함께 사용할 수 있다.

**튜플 사용 방법**  

- 튜플 만들기  
- `var <튜플 이름> = ( <값1>, <값2> ... )`   
```swift  
let tuple1 = ( 1, 2, 3 )                    // 정수 튜플
let tuple2 = ( 1000000, "서울특별시 강서구" )   // 정수와 문자열이 섞여있는 튜플
```

- 튜플의 확인  
- `<튜플 이름>.<인덱스>`  
```swift  
let tuple3 = ( 1000000, "서울특별시 강서구" )   // 튜플 만들기  
print(tuple3.0)        // 0번 인덱스 위치의 요소를 출력
print(tuple3.1)        // 1번 인덱스 위치의 요소를 출력  
```  

- 여러 개의 데이터를 한꺼번에 할당  
- `var ( <변수 이름1>, <변수 이름2>, ... ) = ( <값1>, <값2> ... )`   
```swift 
let tuple4 = ( 1000000, "서울특별시 강서구" )   // 튜플 만들기
var (postcode, address) = tuple4           // 튜플의 값을 여러 개의 변수에 각각 할당  
print(postcode) // 1000000
```

- 튜플에 이름 붙이기  
- `var <튜플 이름> = ( <요소 이름>:<값1>, <요소 이름>:<값2>, ... )`
```swift
let tuple5 = ( postcode:1000000, address:"서울특별시 강서구")
print(tuple5.postcode)
print(tuple5.address)
```
- 튜플은 함수의 반환 값으로도 사용할 수 있다.  


## 함수(메소드)  

### 함수  

- 어떠한 일을 수행하는 명령의 집합  

**함수와 메소드의 차이**
- 함수 중에서 클래스가 가지고 있는 함수는 메소드라 부른다.  
- 아이폰 애플리케이션을 만들 대는 대부분 클래스 내부에 함수를 작성  
 - 따라서 모두 메소드라고 생각해도 상관없다.  

**함수를 만들고 호출하는 방법**  
- 동사+명사의 조합으로 함수 이름을 정하는 것이 일반적  
- 함수 정의  
 ``` 
 fun <함수 이름>() { 
     <하고자 하는 처리>  
 } 
 ```
- 함수 호출  
 ``` 
 <함수 이름>()
 ```
```swift
func showHello1() {         // 함수 정의
    print("안녕하세요!")
}
showHello1() // 함수 호출
```

**매개변수**  
```swift
func showHello(name:String) {
    print("\(name)님 안녕하세요!")
}
showHello(name: "Apple")
```
```swift
func calcBMI(name:String, height:Double, weight:Double) { // 함수를 정의
    let heightM = height / 100.0
    let BMI:Double = weight / (heightM * heightM)
print("\(name)의 BMI는 \(BMI)입니다.")
}
calcBMI(name: "Inseong", height:176.0, weight:53.0)
```  

> 스위프트 3에서는 함수를 호출할 때 첫 번째 매개변수 앞에도 매개변수의 이름을 레이블로 지정해야 한다. 생략하고 싶다면 fund foo(_a:Int, b:Int)와 같은 형식으로 선언하면 foo(3, b:5)와 같이 첫 번째 매개변수의 레이블을 생략하고 호출할 수 있다.  


**반환 값**  

```swift
func returnHello(name:String) -> String {
    let message = "\(name)씨 안녕하세요!"
    return message
}
let hello = returnHello(name: "Apple")
```
- 튜플을 사용해 여러 개의 값을 반환하기  
```swift  
func calcTax(price:Double) -> (Double, Double) {
    let tax = price * 0.1
    let excludingtax = price * 0.9
    return (tax, excludingtax)
}

let (tax, excludingtax) = calcTax(price: 300)

print("부가가치세는 \(tax)원 입니다.")
print("부가가치세가 제외된 가격은 \(excludingtax)원 입니다.")
```

## Optional 자료형  

**변수에 nil을 넣으면 오류**  

- `Optional` 자료형이란 애플리케이션의 크래시를 막기 위한 안전 기능  
- 데이터에는 nil(닐)이라는 값이 없는 상태가 있다.   
 - nil은 0이 아닌 값이 결정되지 않은, 아무것도 들어있지 않은 상태이기 때문에 이것을 변수 또는 상수에 넣는 것은 굉장히 위험.  
 - nil이 들어있는 상태에서 계산하거나 처리를 하면 애플리케이션 크래시가 발생  

- Optional 자료형은 프로그래밍 시 이러한 상황을 미리 확인해서 애플리케이션 실행 중에 크래시 할 위험을 줄이기 위해 있다.  

**Optional 자료형의 필요성**  
- 사용자가 실수로 nil값을 입력하고, 서버가 죽어버려 데이터를 주지 않거나, 데이터가 깨져있는 등의 이상적이지 않은 상태가 발생할 수 있다.  

**Optional 자료형의 변수 만들기: 랩**  
- Optional 자료형의 변수를 만들 때는 자료형 이름 뒤에 ?를 붙인다. 이것을 Optional 자료형으로 랩(wrap:포장) 한다고 한다.  

- Optional 자료형의 변수 만들기  
 - `var <변수 이름>:<자료형>? = <nil이 들어 있을지도 모르는 값>`  
 - Optional 자료형의 변수라면 nil을 넣어도 오류가 발생하지 않는다.  

- Optional 자료형의 변수 사용  
 - Optional 자료형의 변수는 nil이 들어있을지도 모르는 값이기 대문에 사용할 때 주의가 필요  
 - 그대로 일반 변수에 넣어버리면 오류가 발생한다. nil이 들어갈 가능성이 있기 때문  
 - 그래서 다른 변수에 넣으려면 새로운 변수도 Optional 자료형이어야 한다.  
 ```swift
 var testInt5:Int? = 10
 var testInt6:Int? = testInt5
 ```

**Optional 자료형의 변수에서 값을 꺼내는 방법**  
- 포장을 뜯어야 한다.  

1. 언랩해서 값 꺼내기  
 - Optional 자료형의 변수 뒤에 `!`를 붙이면 포장을 뜯을 수 있다. 이러한 것을 언랩(unwrap)이라고 부른ㄹ다.  
 - 주의가 필요하다. nil이 들어있는데 언랩해버림녀 애플리케이션 크래시가 발생한다.    
 - nil이 아니라는 것이 완벽하게 보장될 때에만 사용  
```swift
var testInt8:Int? = 10
var answer8 = testInt8! + 20
```

2. 암묵적인 언랩 자료형의 변수에 넣어서 꺼내기  

- 암묵적인 언랩 자료형 변수란 이 변수에 들어있는 값이 절대 nil이 아니라고 보장되는 변수  
- 암묵적인 언랩 자료형 변수는 새로운 변수를 만들 때 변수 뒤에 `!`을 붙여 만든다.  
```swift
var testInt9:Int? = 10
var testInt10:Int! = testInt9
var answer10 = testInt10 + 20
```

3. if let을 사용해서 꺼내기  
- 정말로 nill이 아닌지 확인하고 사용한느 방법  
```swift
var testInt11:Int? = 10
if let temp = testInt11 {
    print(temp)
}
```  

4. 가드(guard)를 사용해서 값 꺼내기  

- if let에서 꺼낸 값은 if 조건문 블록 내부에서만 사용 가능. 이때의 변수를 조금 더 넓은 변수에서 사용할 수 있도록한 것  
- 메소드에서 사용하는 것을 전제로 해서 조건을 만족하지 않으면 처리를 입구에서 곧바로 돌려보내므로 문지기(guard man)와 같은 명령  


- 문자열을 정수로 변환하는 방법  
 - String 자료형을 Int 자료형으로 변환할 때 `Int()`를 사용   
 - 변환할 문자열에는 정수 이외에도 다양한 값이 들어있을 수 있다. 이러한 경우에는 nil이 되므로 Optional 자료형이 필요  
 - Optional 바인딩을 사용하는 방법  
```swift
let testString13 = "100"
let testInt13:Int? = Int(testString13)
if let temp = testInt13 {
    print(temp)
}
```

## 클래스  

- Xcode는 라이브러리 패널의 부품을 사용해서 화면을 만든다. 이때 하나하나의 부품이 바로 '객체'  
- **객체지향은 현실 세계를 모방한 이해하기 쉬운 생각, 방법** 

**클래스는 설계도**  
  
- 부품의 상태를 나타내는 데이터와 부품이 할 수 있는 일이라는 2가지를 만들면 된다.  
   - 속성(Property): 부품의 상태를 나타내는 데이터  
   - 메소드(Method): 부품이 할 수 있는 일   

**클래스를 만드는 방법**  
```
class <클래스 이름> {
  // 속성
  var <변수 이름> = <값>  

  // 메소드  
  fun <함수 이름>() {
     <처리>  
  }
}
```

**클래스의 사용 방법**  

- 클래스를 사용하려면 우선 객체를 만들어야 한다.  
```
var <객체 이름> = <클래스 이름>()
```
- 객체가 가진 속성에 접근할 때는 <객체 이름>.<속성 이름>을 사용  
```
<객체이름>.<속성 이름>  
```
- 객체의 메소드를 호출할 때는 
```
<객체 이름>.<메소드 이름>  
```

- 부가가치세를 계산하는 부품을 클래스로 만들기  
```swift
class CalcPrice {
    var price:Double = 0            // 속성 : 소비자 가격
    
    func getTax() -> Double {       // 메소드 : 부가가치세를 계산
        return price * 0.1
    }
    
    func getExcludingTax() -> Double {  // 메소드: 부가가치세를 제외한 가격을 계산  
        return price - getTax()
    }
}

let apple = CalcPrice()         // 객체 만들기
apple.price = 3000              // 사과의 소비자 가격은 3000원
print("부가가치세는 \(apple.getTax())원")
print("부가가치세를 제외한 가격은 \(apple.getExcludingTax())원")
```

- 아이폰 애플리케이션의 부품 사용  
 - 이미 있는 클래스를 사용할 수도 있다.  

```swift
import UIKit
let switch1 = UISwitch()      // 스위치 객체 만들기

switch1.isOn = true          // 스위치를 on해서 녹색으로 만든다.
```  

- `import UIKit`이 UIKit을 불러오는 코드  

**클래스 상속과 오버라이드**  
- 클래스는 특정한 클래스를 기반으로 만들 수 있다. 이러한 것을 **상속**이라 부른다.  
 - 기반이 되는 클래스를 부모 클래스라 부른다. 상속하면 부모 클래스가 가진 속성과 메소드를 그대로 사용할 수 있고, 일부를 수정할 수 있다.  
- 부모 클래스의 메소드를 수정하는 것을 오버라이드라고 한다. 앞에 `override`라는 글자를 붙여서 메소드를 만든다.  

- 예) 아이폰 애플리케이션의 스위치를 상속해 새로운 스위치 클래스 만들기  
```swift
import UIKit

// UISwitch 클래스를 상속해 새로운 스위치 클래스를 만들기  
class MySwitch : UISwitch {
    // UIKit을 상속할 때 필요한 처리를 한다.  
    required init?(coder aDecoder: NSCoder) {
        fatalError()
    }
    // 초기화 시 호출되는 init을 수정  
    override init(frame: CGRect) {
        // 스위치를 초기화하는 때에 부모가 관련된 처리를 하게 한다.
        super.init(frame: frame)
        // 부모의 초기화가 끝나면, 스위치를 푸른색으로 변경
        self.onTintColor = UIColor.blue
    }
}

let switch2 = MySwitch()    // 사용자 정의 스위치 만들기  
switch2.isOn = true         // 스위치를 on해서 푸른색으로 만들기
```
- UIKit은 조금 특수해서 상속할 때 `required Init?(coder aDecoder: NSCoder)`라는 메소드가 필요  
- 스위치를 초기화할 때 호출되는 메소드는 `init(frame: CGRect)`. 이 메소드를 오버라이드해서 스위치를 초기화할 때 푸른색으로 만든다.  
- 스위치의 초기화는 굉장히 중요한 명령이기 대문에 완전히 새로 덮어 써버리면 원래 스위치의 초기화가 사라져버린다.  
 - 그래서 init 메소드 내부에서 super.init() 메소드를 실행해 원래 스위치 초기화와 관련된 처리를 한다.  
   - super는 부모를 나타낸다.  
- `onTintColor`는 스위치가 활성화됐을 때의 부품색을 의미  

