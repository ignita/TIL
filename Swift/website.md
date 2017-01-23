# 웹 사이트 출력  

- 웹 사이트를 애플리케이션에 부품으로써 넣는 방법  
- 애플리케이션에서 사파리를 띄어서 사용하는 방법  

## 웹 사이트를 애플리케이션의 부품으로 넣는 방법: 웹뷰  
- 웹뷰(WebView): 버튼이나 이미지뷰처럼 화면에 배치할 수 있는 부품으로 배치한 웹뷰 내부에 웹 사이트 출력이 가능하다.  

**1) URL 객체 만들기: URL(string: String)?**  
- URL을 나타내는 문자열로 URL 객체를 만듭니다.  
```swift
let <URL 객체 이름> = URL(string: "<URL 문자열>") 
```
 - 만약 지정한 문자열이 URL형식과 맞지 않으면 URL 객체가 제대로 만들어지지 않기 때문에 nil이 들어간다.  
   - 그러므로 URL은 `if let`으로 nil인지 아닌지 확인하고 처리해 사용해야 한다.  

**2) URL 요청 만들기: URLRequest(url:URL)**  
- URL 객체를 사용하면 URL 요청(URLRequest)을 만들 수 있다.  
```swift
let <URL 요청 이름> = URLRequest(url: <URL 객체>)  
```

**3) 웹뷰로 읽어 들이기: fund loadRequest(_request: URLRequest!)**  
- 웹뷰에 있는 loadRequest() 메서드의 매개변수로 URL 요청을 전달하면 지정한 페이지가 출력  
```swift
<웹뷰 이름>.loadRequest(<URL 요청>)  
```
```swift
let stringURL = "http://www.google.co.kr"
if let url = URL(string: stringURL) {
    // url이 nil이 아니라면 출력합니다. 
    let urlreq = URLRequest(url: url)   
    myWebView.loadRequest(urlreq)  
}  
```

- 하지만 iOS9부터는 ATS라는 보안 정책 때문에 웹뷰를 사용하기가 어려워졌다.  

**ATS로 인한 HTTP 통신 제한**  
- ATS(App Transfer Security): 웹과 애플리케이션을 안전하게 연결하고자 HTTPS 통신을 사용하게 된 것. 따라서 HTTP 통신을 사용하면 오류가 발생   
- 게다가 페이지마다 HTTPS 통신인지 모두 확인.  
- info.plist를 사용하면 HTTP 통신 페이지도 출력이 가능. 이 도메인의 페이지는 안전합니다라고 info.plist에 등록하는 것  
 - info.plist - 책 205 페이지  

## 애플리케이션에서 사파리를 띄어서 사용하는 방법1: SFSafariViewController  
- 사파리 애플리케이션을 사용하므로 안전하고, HTTP 통신도 사용할 수 있다.  
- info.plist를 사용하지 않고 여러 사이트를 출력할 때 편리하다.  
  - iOS9 이상에서만 동작한다.  

**1) SFSafariViewController를 사용할 준비**  
- SafariServices를 임포트  
```swift
import SafariServices
```

**2) URL 객체 만들기: URL(string: String)?**  
- URL을 나타내는 문자열로 URL 객체를 만든다.  

**3) SFSafariViewcontroller 객체 만들기**  
- URL 객체로 지정한 페이지를 출력하는 SFSafariViewController 객체를 만든다.  
```swift
let <SafariViewController 이름> = SFSafariViewcontroller(url: <URL 객체 이름>)  
```

**4) SFSafariViewController 출력**  
- 생성한 SFSafariViewcontroller를 출력  
```swift
present(<SafariViewcontroller 이름>, animated: true, completion: nil)  
```

- 예) 버튼을 누르면 애플 사이트를 출력  
```swift
import UIKit  
// SFSafariViewController 사용 준비  
import SafariServices  

class ViewController: UIViewController { 

    @IBAction fund tapBtn() { 
        // 버튼을 눌렀을 때  
        if let url = URL(string: "http://www.apple.com/kr/") {
        // url이 nil이 아니라면 SFSafariViewController를 출력  
        let vc = SFSafariViewController(url: url)
        present(vc, animated: true, completion: nil)
        }
    }
}
```

## 애플리케이션에서 사파리를 띄어서 사용하는 방법2: SafariViewController

- 출력한 **SFSafariViewController** 화면은 왼쪽 위의 [Done] 버튼을 탭 해서 끌 수 있고, 화면이 꺼지면 원래 애플리케이션 화면으로 돌아오는데, 이때, SafariViewController가 종료될 때를 알아야 하는 경우가 있다.  
- SafariViewController가 끝날 때는 `safariViewControllerDidFinish()` 메서드가 호출된다. 이 메서드를 이용하면 SafariViewController가 종료될 때 특별한 처리를 할 수 있다.  

**1) SFSafariViewController를 사용할 준비**  
- SafariService를 임포트한다.  

**2) SFSafariViewController에서 통지 받을 준비**  
- ViewControler 클래스 앞부분에 SFSafariViewControllerDelegate를 추가  
```swift
class viewController: UIViewController, SFSafariViewControllerDelegate  
```

**3)URL 객체 만들기: URL(string: String)?**
- URL을 나타내는 문자열로 URL 객체를 만든다.  

**4) SFSafariViewController 객체 만들기**  
- URL 객체로 지정된 페이지를 출력할 SFSafariViewController 객체를 만든다.  

**5) SFSafariViewController에서 통지 받을 대상을 self로 설정**  
- URL 객체로 지정된 델리게이트를 self로 설정. 이렇게 하면 통지를 받을 대상을 자기자신인 self(ViewController)로 설정할 수 있다.  
```swift
<safariViewController 이름>.delegate = self
```

**6) SFSafariViewController 출력**  
- 생성한 SFSafariViewController를 출력  

**7) safariViewControllerDidFinish() 메서드 만들기**  
- SFSafariViewController를 닫을 때 자동으로 호출된다.  

- 버튼을 누르면 애플 사이트를 출력하고, 닫으면 close를 출력  
```swift
import UIKit
// SFSafariviewController 사용 준비  
import SafariServices

class ViewController: UIViewController, SFSafariViewControllerDelegate {
    
    @IBAction func tapBtn() {
        // 버튼을 눌렀을 때  
        if let url = URL(string: "http://www.apple.com/kr/") { 
        let vc = SFSafariViewController(url: url)  
        vc.delegate = self  
        present(vc, animated: true, completion: nil) 
        }
    } 

    func safariViewControllerDidFinish(_ controller: SFSafariViewController) {
        print("Close")
    }
```

