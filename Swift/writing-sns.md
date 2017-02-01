# SNS에 글 작성하기  

## 글쓰기 대화 상자 띄우기  

**1) Social 프레임워크 사용 준비**  
```
import Social
```

**2) 글쓰기 다이얼로그 만들기**  
- 트위터 글쓰기 대화 상자 만들기
```swift
let <글쓰기 대화 상자> = SLComposeViewController(forServiceType: SLServiceTypeTwitter)  
```
- 페이스북 글쓰기 대화 상자 만들기
```swift
let <글쓰기 대화 상자> = SLComposeViewController(forServiceType: SLServiceTypeFacebook)  
```

**3) 공유할 문자, 이미지, URL 준비**  
- 필요에 따라 사용 
 - 글쓰기 대화 상자에 미리 문자 넣기  
  ```swift
  <글쓰기 대화 상자>.setInitialText(<문자열>) 
  ```
 - 글쓰기 대화 상자에 미리 이미지 넣기 
  ```swift
  <글쓰기 대화 상자>.addImage(<UIImage>) 
  ```
 - 글쓰기 대화 상자에 미리 URL 넣기  
  ```swift
  <글쓰기 대화 상자>.addURL(<URL>)
  ```

**4) 글쓰기 대화상자 출력**  
```swift
self.present(<글쓰기 대화 상자>, animated: true, completion: nil) 
```

- 트위터에 트윗하는 다이얼로그 출력("글을 써봐요"라는 문자 추가) 
```swift
// Social 사용 준비
import Social

class ViewController: UIViewController {

    @IBAction func tapTwitterBtn() {
        // 트위터 글쓰기 대화 상자 생성 
        let cv = SLComposeViewController(forServiceType: SLServiceTypeTwitter)
        // 기본적으로 들어갈 글자 설정 
        cv?.setInitialText("글을 써봐요")
        // 글쓰기 대화상자 출력
        self.present(cv!, animated: true, completion: nil)
    }
```

## 공유 액션 시트를 사용해서 글쓰기 대화상자 띄우기  

**1) 공유할 문자, 이미지, URL을 배열로 준비**  
- 필요에 따라 사용  
```swift
let <공유 전용 배열> = [<String>,<URL>,<UIImage>]
```

**2) 공유 액션 시트 만들기**  
```swift
let <공유 액션 시트> = UIActivityViewController(activityItems: <공유 전용 배열>, applicationActivities: nil)
```

**3) 공유하지 않을 버튼 지정**  
- 모든 버튼을 출력할거라면 이 처리는 하지 않아도 상관 없다.
- 표시하지 않고자 하는 버튼을 배열로 만들기  
```swift
let <표시하지 않고자 하는 버튼 배열> = [ 
    UIActivityType.saveToCameraRoll,    // 사진 라이브러리에 저장 
    UIActivityType.print,               // 인쇄 
    UIActivityType.copyToPasteboard,    // 클립보드에 복사 
    UIActivityType.airDrop,             // AirDrop 
    UIActivityType.assignToContact,     // 주소록
    UIActivityType.addToReadingList,    // Safari 읽어보기 목록에 추가 
    UIActivityType.mail,                // Mail
    UIActivityType.message,             // Message  
]
```
- 표시하지 않고자 하는 버튼의 배열을 공유 액션 시트의 excludedActivityTypes 속성에 저장  
```swift
present(<공유 액션 시트>, animated: true, completion: nil) 
<공유 액션 시트 이름>.excludedActivityTypes = <표시하지 않고자 하는 버튼 배열 이름> 
```

- 글을 써봐요 라는 문자를 공유하는 공유 액션 시트 출력
```swift 
// Social 사용 준비
import Social

class ViewController: UIViewController {
    @IBAction func tapShareBtn() {
        // 공유할 문자를 배열에 넣는다. 
        let shareText = "글을 써봐요!"
        let shareItems = [shareText]
        // 공유 액션 시트를 생성하고 excludedActivityTypes 지정 
        let avc = UIActivityViewController(activityItems: shareItems, applicationActivities: nil)
        avc.excludedActivityTypes = [
        UIActivityType.saveToCameraRoll,
        UIActivityType.airDrop,
        UIActivityType.assignToContact,
        UIActivityType.addToReadingList
        ]
        // 공유 액션 시트 출력
        present(avc, animated: true, completion: nil)
    }
```
