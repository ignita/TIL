# 웹에서 데이터 내려받기   

## 이미지뷰  
- 프로젝트 내부의 이미지를 출력할 때 사용  
- 웹에 있는 이미지를 출력할 때도 사용  

## 웹에서 이미지를 내려받아 출력하는 방법  
- 지정한 URL에서 로우(Raw) 데이터를 내려받고, 로우 데이터를 애플리케이션에서 사용할 수 있는 이미지 데이터로 변환한 뒤 이미지 뷰에 출력  

**1) URL 객체 만들기: URL(string: String)?**  

- URL을 나타내는 문자열로 URL 객체를 생성  
- nil인지 확인하고 사용  
```swift
let url = URL(string: "URL이 아닌 문자열")  
```
- 플레이그라운드에서 nil을 반환함을 확인할 수 있다.  

**2) 데이터를 내려받아 로우 데이터 만들기: NSData(contentsOf: URL)?**  
- URL 객체에서 데이터를 내려받아 로우 데이터(NSData)를 만든다.  
- 이것도 nil인지 확인   
```
var <데이터 이름> = NSData(contentsOfURL: <URL 객체>)
```

**3) 로우 데이터를 이미지 데이터로 변환하고 이미지 뷰에 출력**  
```
<이미지뷰 이름>.image = UIImage(data: <데이터>) 
```

- 버튼을 누르면 지정한 URL의 웹 이미지를 이미지 뷰에 출력  
```swift
@IBOutlet weak var myImageView: UIImageView!
    @IBAction func tapLoadImage() {
        let stringURL = "url"
       
        if let url = URL(string: stringURL) {
            if let data = NSData(contentsOf: url) {
                myImageView.image = UIImage(data: data as Data)
            }
        }
    }
```


## 웹에서 텍스트 내려받기  

- `URLSession`을 사용  
 - 웹 서버와 통신하는 객체  
 - 지정한 URL의 데이터를 읽어주세요. 그리고 완료하면 그때 알려주세요  
 - 백그라운드에서 처리. 메인 프로그램은 명령만 내리고, 다른 작업을 하는 동안 실제 통신 처리는 뒤에서 한다.(비동기 통신)  

### 웹에서 텍스트를 내려받는 방법1: 메서드를 만들지 않는 방법  

**1) URL 객체 만들기: URL(string: String)?**  
- URL을 나타내는 문자열로 URL 객체(URL)를 만든다.  

**2) URLSession 객체 만들기**  
- URLSession.shared로 통신을 하는 객체를 만든다.  
```
let <URLSession 객체 이름> = UrlSession.shared
```

**3) 데이터를 내려받는 태스크 만들기**  

- URLSession의 dataTask() 메서드를 사용해서 태스크(데이터를 내려받기 위한 작업)를 만든다.  
- 내려받을 대상 URL을 지정하고, 통신이 완료도면 실행할 처리를 completionHandler 뒤에 작성  
- 통신이 끝나면 (data, response, error) 형식의 튜플을 사용 가능  
  - 각각 데이터, 상태 정보, 오류 코드를 나타낸다.  
```
let <태스크 이름> = <URLSession 객체 이름>.dataTask(with: url, completionHandler: {
    (data, response, error) in
     <통신 완료 때의 처리>
})
```

**4) 로우 데이터를 UTF8 문자열로 변환**  
- NSString을 사용  
```
if let <NSString 데이터> = NSString(data: <Raw 데이터>!, encoding: String.Encoding.utf8.rawValue)
{
}
```

**5) UTF8 문자열을 일반 문자열로 변환**  
```
let <문자열 데이터> = String(<NSString 데이터>)
```

**6) 태스크 실행**  
- 텍스트 데이터를 내려받는 태스크를 모두 만들었으면 태스크를 실행  
```
<태스크 이름>.resume()
```

- 버튼을 누르면 지정한 URL에 있는 텍스트를 출력  
```swift  
@IBAction func tapLoadText1() {
    // 버튼을 눌렀을 때  
    if let url = URL(string: "https://....") {
        // url이 nil이 아니라면 URLSession 객체 생성  
        let urlSession = URLSession.shared  
        // 데이터를 읽어들이는 태스크를 완료하면 completionHandler 처리가 수행  
        let task = urlSession.dataTask(with: url, completionHandler: {
            (data, response, error) in   
            // Raw 데이터를 UTF8 문자열로 변환  
            if let nsstr = NSString(data: data!, encoding: String.Encoding.utf8.rawValue) {
            // UTF8 문자열로 변환되면 일반적인 문자열로 변환  
            let str = String(nsstr)  
            // 문자열 출력  
            print("문자열=[\(str)]")
        }
    })
    task.resume()
 }
}
```

### 웹에서 텍스트를 내려받는 방법2: 메서드를 만드는 방법  

- 복잡한 처리를 메서들 옮겨 사용할 수 있는 방법  

**1) URL 객체 만들기: URL(string: String)?**
**2) URLSession 객체 만들기**
**3) 데이터를 내려받는 태스크 만들기**  

- URLSession의 dataTask(with: url) 메서드를 사용해 태스크(데이터를 내려받기 위한 작업)를 만든다.  
- 어떤 URL에서 내려받을지 지정. 통신을 완료했을 때 completionHandler 뒤에 입력한 이름의 메서드를 호출(그래서 해당 이름의 메서드를 생성해야 한다.)  
```swift 
let <태스크 이름> = <URLSession 객체 이름>.dataTask(with: <URL>, comletionHandler: <호출할 메서드 이름>)
```

**4) 태스크 실행**  
**5) 통신을 완료했을 때 호출할 메서드 만들기**  
```swift
func <호출할 메서드 이름>(<데이터 이름>: Data?, <응답 데이터 이름>: URLResponse?, <오류 데이터 이름>: NSError?) {
}
```

**6) 메서드 내부에서 로우 데이터를 UTF8 문자열로 변환**  
- NSString을 사용  
**7) 메서드 내부에서 UFT8 문자열을 일반 문자열로 변환**  

- 버튼을 누르면 지정한 URL 텍스트를 출력  
```swift
    @IBAction func tapLoadText() {
        if let url = URL(string: "https://wikibook.github.io/swift3-textbook/test.txt") {
            // url이 nil이 아니라면 URLSession 객체 생성 
            let urlSession = URLSession.shared
            // 데이터를 읽어들이는 태스크를 완료하면 competionHandler 처리가 수행
            let task = URLSession.dataTask(with: url, completionHandler: onFinish)
            task.resume()
        }
    }
    
    // 읽어들이기를 완료했을 때 호출할 메서드 생성(이름은 자유)  
    func onFinish(data: Data?, response: URLResponse?, error: NSError?) {
        // Raw 데이터를 UTF8 문자열로 변환
        if let nsstr = NSString(data: data!, encoding: String.Encoding.utf8.rawValue) {
            // UTF8 문자열로 변환되면 일반적인 문자열로 변환
            let str = String(nsstr)
            // 문자열 출력
            print("문자열=[\(str)]")
        }
    }
```
