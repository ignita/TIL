# JSON 데이터 파싱  

- JSON: 웹 애플리케이션 사이에서 무언가를 주고받을 때 사용하는 데이터 형식  
- NSJSONSerialization을 사용해 JSON 데이터를 배열 또는 딕셔너리 데이터로 변환 가능!  


## JSON 데이터란?  
- 웹 애플리케이션 사이에서 무언가를 주고받을 때 사용하는 데이터 형식
 - JavaScript Object Notation의 줄임말. 자바스크립트에서 데이터를 다룰 때 사용.  
 - 형식이 단순하고 편리해서 많은 웹 애플리케이션에서 데이터를 주고받을 때 많이 사용  
 - 파싱(해석)하기도 쉽다.  

**JSON의 형식**  

- 배열 형식  
 - []로 감싸고, 쉼표로 구분  
 - 문자는 큰 따옴표로 감싸기, 숫자는 그냥 입력, true/false 또한 그냥 입력  
 ```
 ["다즐링", "얼그레이", "오렌지페코"]  
 [0, 1, 2, 3, 4, 5] 
 [true, false, true, false]  
 ```

- 딕셔너리 데이터(객체) 형식  
 - 데이터는 {}로 감싸고, 각 데이터를 키: 값의 세트로 쉼표로 구분해서 나열  
 ```
 { "키": 값, "키": 값, "키": 값 ... } 
 ```
 - 문자열은 큰 따옴표로 감싸고, 숫자와 true/false는 그냥 입력, 키는 문자열로 입력  
 ```
 {"name":"다즐링", "price":6000, "재고":true } 
 ``` 

- 딕셔너리 배열 형식  
 - 딕셔너리 데이터 여러 개를 배열에 나열 가능  
 - []로 감싼 부분에 딕셔너리 데이터를 쉼표로 구분해 나열하기  
 ``` 
 [
   {"name":"다즐링", "price":6000},
   {"name":"얼그레이", "price":5500},
   {"name":"실론", "price":5000}
 ]
 ```

- 중첩 딕셔너리 형식  
 - 딕셔너리 데이터 내부에 딕셔너리 데이터를 넣어서 중첩이 가능하다.  
 ```
 { 
   "치킨마요": {"재료":"치킨", "간장":true, "마요네즈":true},   
   "돈까스마요": {"재료":"돈까스", "간장":true, "마요네즈":true}
 }
 ```

## [사용 방법] JSON 데이터를 파싱(해석)하는 방법: NSJSONSerialization  

- JSON 데이터를 스위프트에서 사용할 수 있는 배열 또는 딕셔너리로 변환할 때에는 `NSJSONSerialization`을 사용  
 - `NSJSONSerialization.JSONObjectWithData()`를 실행하는 것만으로 JSON 데이터가 파싱(해석)된다.  
 - 배열인지 딕셔너리인지는 마지막에 어떤 자료형을 지정할지의 차이.  
   - JSON 데이터 내부에는 객체, 배열, 문자열, 숫자, 불 등 모두 들어갈 수 있지만 가장 외곽은 배열 또는 객체여야 한다.  

- 배열 파싱(해석)  
 - JSON 데이터를 **배열 데이터**로 파싱할 때는 자료형을 **NSArray**로 지정. 따라서 마지막에 as! NSArray를 붙여준다.  
 ```swift
 let <배열 이름> = NSJSONSerialization.JSONObjectWithData(<JSON 데이터>, options: nil, error: nil) as! NSArray 
 ```

- 딕셔너리 파싱(해석)  
 - JSON 데이터를 딕셔너리 데이터로 파싱할 때는 자료형을 NSDictionary로 지정해야 한다. 마지막에 as! NSDicctionary를 붙여준다.  
 ```swift
 let <딕셔너리 이름> = NSJSONSerialization.JSONObjectWithData(<JSON 데이터>, options: nil, error: nil) as! NSDictionary 
 ```

- JSON 데이터 파싱(해석)을 위한 오류 처리  
 - JSON 데이터가 배열 또는 딕셔너리로 제대로 변환되지 않으면 오류가 발생. 오류 발생 시에는 do try catch 구문을 사용  
 ```swift
 do {
    try <오류가 발생할지도 모르는 처리>  
    <오류가 발생하지 않았을 때의 처리>   
 } catch {
   <오류가 발생했을 때의 처리> 
 } 
 ``` 
 ```swift
 do {
    var <딕셔너리 이름> = try NSJSONSerialization.JSONObjectWithData(<JSON 데이터>, options: nil, error: nil) as! NSDictionary 
    <오류가 발생하지 않았을 때의 처리>   
 } catch {
   <오류가 발생했을 때의 처리>  
 } 
 ``` 

- 배열 자료형의 JSON 데이터를 배열로 파싱(플레이 그라운드) 
```swift
// 테스트 전용 JSON 데이터 준비
var jsonString1 = "[100, 200]"
var jsonData1 = jsonString1.data(using: String.Encoding.utf8)
// JSON 데이터 파싱 
do {
    // 오류가 발생할지도 모르는 JSON 데이터 파싱 부분 
    var array = try JSONSerialization.jsonObject(with: jsonData1!, options: JSONSerialization.ReadingOptions.mutableContainers) as! NSArray
    // 파싱되면 출력
    print(array)
} catch {
    print("error")
}
```

- 딕셔너리 자료형의 JSON 데이터를 딕셔너리 데이터로 파싱(플레이 그라운드) 
```swift 
// 테스트 전용 JSON 데이터 준비 
var jsonString2 = "{\"A\":100, \"B\":200}"
var jsonData2 = jsonString2.data(using: String.Encoding.utf8)
// JSON 데이터 파싱
do {
    // 오류가 발생할지도 모르는 JSON 데이터 파싱 부분
    var dictionary = try JSONSerialization.jsonObject(with: jsonData2!, options: JSONSerialization.ReadingOptions.mutableContainers) as! NSDictionary
    // 파싱되면 출력
    print(dictionary)
} catch {
    print("error")
}
```


