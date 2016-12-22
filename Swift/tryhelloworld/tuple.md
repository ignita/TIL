**Tuple**
- 코마로 구분된 값의 리스트.
- 간단하게 만들어 쓰고 읽을 수 있다.
- element 번호로 접근하거나 만들 때 지정한 이름으로 접근 가능

**typealias**
- 간단한 타입 지정
- 예를 들어, Int 타입으로 시간 간격을 나타내고 싶다면, 사실은 Int인 TimeInterval 값을 만들 수 있다.  

```swift  
let time1 = (9,0,48)
let time2:(h:Int, m:Int, s:Int) = (11,51,5)
time2.h
time2.m
time2.s

let duration = (time1, time2)

let (start, end) = duration
let endHour = end.h

typealias Time = (h:Int, m:Int, s:Int)
typealias Duration = (start:Time, end:Time)

let today:Duration = ((9,10,23), (17,8,21))
print("We studied until \(today.end.h) today")
```