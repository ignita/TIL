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

