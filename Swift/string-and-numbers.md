# String  

- 빈 문자열 만들고 문자열 추가  
```swift
let name:String = "yeonjeong"

var greeting = "Hello"

greeting += " " + name

```

- Character 타입의 배열로 변환하고 글자 수 카운트 하기  
```swift  
let characters = name.characters
let count = characters.count
```

- `"\()"` 이용해 문자열 구성하기  
```swift
print("\(name)")
```

- hasPrefix와 hasSuffix  
```swift
let url = "www.codershigh.com"
let hasProtocol = url.hasPrefix("http://")
```

# Numbers  

- Int는 정수(Int32, Int64), UInt는 양의 정수  
- Float는 32bit 소수, Double 64bit 소수, 그냥 만들면 Double  
- Int를 Float에 더하기  
```swift
var curSpeed:Int = 110
curSpeed += 10
curSpeed += Int(20.5)

let intMax = Int.max
let UintMax = UInt.max
let intMin = Int.min
let UIntMin = UInt.min

let pi = 3.14
let divider = 2
let halfPi = 3.14/Double(divider)
```

