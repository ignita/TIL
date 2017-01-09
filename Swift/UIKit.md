# UIKit  

**UIKit은 화면을 구성하는 부품**  

- 버튼, 스위치, 슬라이더 모두 UIKit이다.  
- UIKit의 역할  
 1. 애플리케이션의 정보를 사용자에게 보여주는 것  
 2. 사용자의 조작을 애플리케이션에 전달하는 것  

## UILabel  
- 간단한 문자를 화면에 출력할 때 사용  

- 인터페이스 빌더로 사용  
- 프로그램으로 설정  
```swift 
myLabel.text = "안녕하세요!"
```  
- 문자의 색상 설정: var textColor: UIColor!  
```swift 
myLabel.textColor = UIColor.blue
```
- 배경 색상 설정: var backgroundColor: UIColor?
 - Optional 자료형이므로 읽어 들일 때 nil인지 확인  
```swift
myLabel.backgroundColor = UIColor.cyan 
```

- 배치 설정: var textAlignment: NSTextAlignment   

 | 배치 설정 | 의미 | 
 | --- | --- |
 | NSTextalignment.center | 가운데 정렬 |  
 | NSTextAlignment.left | 왼쪽 정렬 | 
 | NSTextAlignment.right | 오른쪽 정렬 |
```swift
myLabel.textAlignment = NSTextAlignment.center
```

- 폰트 또는 크기 설정: var font: UIFont!  
 - `<레이블 이름>.font = <폰트>`  
 - `UIFont(name: "<폰트 이름>", size: <크기>)`
 - `UIFont.systemFont(ofSize: <크기>): 시스템 폰트의 크기만 바꿔서 지정  
```swift 
myLabel.font = UIFont.systemFont(ofSize: 20)
```

- 최대 줄 수 설정: var numberOfLines: Int  
 - 기본값은 1이며, 0으로 설정하면 레이블의 내용에 맞게 알아서 출력  
 ```swift 
 myLabel.numberOfLines = 0 
 ```   

- text 속성을 읽어 들일 때  
 - 레이블의 text 속성은 Optional 자료형이므로 읽어 들일 때 주의해야 합니다.  
 - if let으로 언랩해서 사용해야 합니다.  
 ```swift
 print(myLabel.text)  
 if let text = myLabel.text {
     print(text)
 } 
 ```

## UIButton  
- 사용자가 누르면 무언가 하고 싶을 때 사용  
 - 사용자가 버튼을 탭하면 버튼에 연결된 메소드가 실행된다.  

**프로그램으로 설정하는 방법**  
- 문자 설정: fund setTitle(_title: String?. for: UIControlState)  
```
<버튼 이름>.setTitle("<문자열>", for: <버튼의 상태>) 
```
- 버튼 상태(UIControlState)의 종류  

 | 버튼 상태 | 의미 | 
 | --- | --- | 
 | UIControlState.normal | 일반적인 상태 | 
 | UIControlState.highlighted | 버튼을 터치 중일 때 |  
 | UIControlState.selected | 선택 중일 때 |  
 | UIControlState.disabled | 비활성화일 때 |  
```swift
myButton.setTitle("눌러주세요", for: UIControlState.normal) 
```

- 활성화 상태 설정: var isEnabled: Bool  
```
<버튼 이름>.isEnabled = < true / false >  
```
```swift 
myButton.isEnabled = true  
```

- 선택 상태 설정: var isSelected: Bool  
```
<버튼 이름>.isSelected = < true / false >  
```
```swift
myButton.isSelected = true 
```

**Action 설정 방법**  
- 버튼을 탭 했을 때 메소드 실행: Touch Up Inside  
 어시스턴트 에디터를 사용해 연결할 때 Action의 Event를 `Touch Up Inside`로 선택하면 버튼을 탭 했을 때 특정 메소드가 실행되게 할 수 있다.  

## UISwitch  
- 스위치는 활성화 또는 비활성화를 선택할 때 사용합니다.  
 
**프로그램으로 설정하는 방법**   
- 활성화 상태 설정: var isOn: Bool  
```
<스위치 이름>.isOn = < true / false >  
```
```swift  
mySwitch.isOn = true
```

- 활성화 상태의 버튼 색상 설정: var onTintColor: UIColor?  
```
<스위치 이름>.onTintColor = <배경 색상>  
```
```swift  
mySwitch.onTintcolor = UIColor.red
```

- 손잡이 색상 설정: var thumbTintColor: UIColor?  
```
<스위치 이름>.thumbTintColor = <손잡이 색상>  
```
```swift  
mySwitch.thumbTintColor = UIColor.yellow  
```

**Action 설정 방법**  

- 스위치를 조작할 때 메소드 실행: Value Changed  
 - 어시스턴트 에디터에서 연결할 때 Action의 Event를 `Value Changed`로 선택하면 스위치를 조작할 때 실행할 메소드를 지정할 수 있다.  

## UISlider: 슬라이드해서 값을 입력할 때  

**프로그램으로 설정하는 방법**  

- 최솟값, 최댓값, 값 설정: var minimumValue, maximumValue, value:Float  
 - Double 자료형이 아니라 Float 자료형  
```
<슬라이더>.minimumValue = <최댓값>  
<슬라이더>.maximumValue = <최솟값>  
<슬라이더>.value = <값>  
```
```swift 
mySlider.minimumValue = 0
mySlider.maximumValue = 100
mySlider.value = 20
```  

- 손잡이 왼쪽, 오른쪽 바의 색상 설정: var minimumTrackTintColor, maximumTrackTintColor: UIColor?  
```
<슬라이더>.minimumTrackTintColor = <손잡이 왼쪽 바의 색상>  
<슬라이더>.maximumTrackTintColor = <손잡이 오른쪽 바의 색상>  
```
```swift
mySlider.minimumTrackTintColor = UIColor.blue
mySlider.maximumTrackTintColor = UIColor.red
```

- 슬라이드하는 중에도 값을 반환할지 설정: var isContinuous: Bool  
```
<슬라이더>.isContinuous = < true / false > 
```
```swift
mySlider.isContinuous = true
```

**Action 설정 방법**  

- 어시스턴트 에디터에서 연결할 때 Action의 Event를 `Value Changed`로 선택


## UITextField  

- 텍스트 필드는 키보드로 글자 한 줄을 입력받을 때 사용  
- 탭하면 키보드가 자동으로 나온다.  

**프로그램으로 설정하는 방법**  
- 문자 설정: var text: String?  
```
<텍스트 필드 이름>.text = <문자열>  
```
```swift
myTextField.text = "안녕하세요!"
```

- 플레이스홀더 설정: var placeholder: String?  
```
<텍스트 필드 이름>.placeholder = <문자열>  
```
```swift  
myTextField.placeholder = "여기에 입력해주세요."  
```

- 문자 색상 설정: var textColor: UIColor?  
```
<텍스트 필드 이름>.textColor = <문자 색상>  
```
```swift 
myTextField.textColor = UIColor.blue
```

- 배경 색상 설정: var backgroundColor: UIColor?  
```
<텍스트 필드 이름>.backgroundColor = <배경 색상>  
```
```swift 
myTextField.backgroundColor = UIColor.cyan  
```

- 배치 설정: var textAlignment: NSTextAlignment  
```
<텍스트 필드 이름>.textAlignment = <배치 방법>  
```
```swift
myTextField.textAlignment = NSTextAlignment.center
```
  - center, left, right   

- 폰트와 크기 설정: var font: UIFont?  
```
<텍스트 필드 이름>.font = <폰트>  
```
```swift
myTextField.font = UIFont.systemFont(ofSize: 24)
```

- 키보드 종류 설정: var keyboardType: UIKeyboardType  
```
<텍스트 필드 이름>.keyboardType = <키보드 종류>  
```
 - 키보드 종류  

   | UIKeyboardType | 설명 |  
   | --- | --- |  
   | UIKeyboardType.default | 기본 |  
   | UIKeyboardType.asciiCapable | 영어 입력 전용 |  
   | UIKeyboardType.URL | URL 입력 전용 |  
   | UIKeyboardType.emailAddress | 이메일 주소 입력 전용 |  
   | UIKeyboardType.numberPad | 숫자 입력 전용 |  
   | UIKeyboardType.phonePad | 전화번호 입력 전용 |  

```swift
myTextField.keyboardType = UIKeyboardType.emailAddress
```

- 리턴 키 설정: var returnKeyType: UIReturnKeyType  
```
<텍스트 필드 이름>.returnKeyType = <리턴 키의 종류>  
```
```swift
myTextField.returnKeyType = UIReturnKeyType.send
```
 - 리턴 키의 종류  
 
  | UIReturnKeyType | 리턴 키 |  
  | --- | --- |  
  | UIReturnKeyType.defualt | return |  
  | UIReturnKeyType.go | Go |
  | UIReturnKeyType.join | Join |
  | UIReturnKeyType.next | Next |
  | UIReturnKeyType.search | Search |
  | UIReturnKeyType.send | Send |
  | UIReturnKeyType.done | Done |

**Action 설정 방법**  

- 리턴 키를 눌렀을 때 실행할 메소드 지정: Did End On Exit  
- 키보드 없애기  
 - Action의 Event를 Did End On Exit으로 선택하면 리턴 키를 눌렀을 때 자동으로 키보드가 사라진다.  
   - 따로 만든 버튼으로 닫으려면 `resignFirstResponder()`를 사용  
     ```swift
     myTextField.resignFirstResponder()
     ```

## UITextView  

- 긴 글자를 출력하거나 입력받을 때 사용  
 - 영역의 크기보다 긴 글자가 출력되어야 하면 자동으로 스크롤 바가 생긴다.  

**프로그램으로 설정하는 방법**  

- 문자 설정: var text: String!  
``` 
<텍스트 뷰>.text = <문자열>  
```
```swift 
myTextView.text = "안녕하세요!"
```

- 문자 색상 설정: var textColor: UIColor? 
```
<텍스트 뷰 이름>.textColor = <문자 색상>  
```
```swift
myTextView.textColor = UIColor.blue
```

- 배경 색상 설정: var backgroundColor: UIColor?  
```
<텍스트 뷰 이름>.backgroundColor = <배경 색상>  
```
```swift  
myTextView.backgroundColor = UIcolor.cyan  
```

- 배치 설정: var textAlignment: NSTextAlignment  
```
<텍스트 뷰 이름>.textAlignment = <배치 방법>  
```
```swift
myTextView.textAlignment = NSTextAlignment.right
```

- 폰트와 크기 설정: var font: UIFont?  
```
<텍스트 뷰 이름>.font = <폰트>  
```
```swift
myTextView.font = UIFont(name: "AmericanTypewriter", size: 20)
```

- 수정 가능 상태 설정: var isEditable: Bool 
```
<텍스트 뷰 이름>.isEditable = < true / false >
```
```swift
myTextView.isEditable = true
```

- 키보드 종류 설정: var keyboardType: UIKeyboardType  
```
<텍스트 뷰 이름>.keyboardType = <키보드 종류>  
```
```swift
myTextView.keyboardType = UIKeyboardType.URL
```

- 리턴 키 설정: var returnKeyType: UIReturnKeyType
```
<텍스트 뷰 이름>.returnKeyType = UIReturnKeyType.send
```
```swift
myTextView.returnKeyType = UIReturnKeyType.send
```  

**Action 설정 방법**  

- 키보드 강제로 닫기  
```
<텍스트 뷰 이름>.resignFirstResponder()
```
```swift
myTextView.resignFirstResponder()
```

## UIImageView  

- 이미지를 출력하고 싶을 때 사용  
 - Content Mode  
   - Scale To Fill: 이미지를 이미지 뷰에 딱 맞게 확대/축소  
   - Aspect Fit: 이미지의 가로세로 비율을 유지한 채로 이미지를 모두 출력할 수 있게 확대/축소  
   - Aspect Fill: 이미지의 가로세로 비율을 유지한 채로 이미지 뷰의 여백 없이 출력하게 확대/축소  

**프로그램으로 설정하는 방법**  

- 이미지 출력: var image: UIImage?  
  - 이미지 파일을 UIImage라는 이미지 데이터로 변환 
  ```
  let <UIImage 이름> = UIImage(named: "<이미지 파일 이름>")  
  ```
  - 이미지 뷰에 이미지 데이터를 설정해서 출력
  ```
  <이미지 뷰 이름>.image = <UIImage 이름>   
  ```
  - 위 코드들을 다음과 같이 한 줄로 작성 가능  
  ```
  <이미지 뷰 이름>.image = UIImage(named: "<이미지 파일 이름>")  
  ```
  ```swift  
  myImageView.image = UIImage(named: "berry.jpg") 
  ```

- 가로세로 비율 설정: var contentMode: UIviewContentMode  
```
<이미지 뷰 이름>.contentMode = <확대 축소 종류>  
```
```swift
myImageView.contentMode = UIViewContentMode.scaleAspectFit  
```  
   - scaleToFill, scaleAspectFit, scaleAspectFill  

**Action 설정 방법**  

- 이미지 뷰는 Action 설정을 할 수 없고 속성으로 값을 설정하거나 읽어 들이는 것만 할 수 있다.  

- 애셋 카탈로그(AssetCatalog): 각 해상도 전용 이미지를 따로 만들어놓고, 해상도에 맞는 이미지를 자동으로 사용하게 하는 기능  


