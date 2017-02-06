# UITableView: 리스트 출력  

- 테이블 뷰는 값이 여러 개 있는 리스트를 출력할 때 사용  
 - 데이터는 델리게이트를 사용해 출력  
- 테이블 뷰 내부에는 섹션(section)이라고 불리는 큰 부분과 섹션 내부에는 행(Row)이 들어간다.  
 - 각각의 행 내부에는 셀(Cell)이라 부르며, 여기에 문자, 아이콘, 스위치 등을 출력  
- 테이블 출력 형식에는 일반 형식(Plain)과 그룹 형식(Grouped)이 있다. 생성할 때 선택해야 하며, 변경이 불가능  
 - 어트리뷰트 인스펙터에서 설정: Style(Plain/Grouped)  

## 테이블 뷰 사용 방법  
- 델리게이트를 사용해 출력하거나 선택할 때의 처리를 한다.  
 - 두 가지의 프로토콜을 사용 
   - UITableViewDataSource: 테이블 뷰에 데이터 출력 시, 어떤 데이터인지 뷰 컨트롤러에게 질문할 때 사용 
   - UITableViewDelegate: 테이블 뷰를 조작할 때, 어떤 처리를 해야 하는지 뷰 컨트롤러에게 질문할 때 사용    

**프로토콜 사용법**  
1. 인터페이스 빌더의 테이블 뷰에서 뷰 컨트롤러에 연결하고 데이터 소스와 델리게이트를 설정  
2. 이어서 뷰 컨트롤러 클래스에 2개의 프로토콜(UITableViewDataSource, UITableViewDelegate)을 추가 
 ```swift 
 import UIKit  
 
 class ViewController: UIViewController, UITableViewDataSource, UITableViewDelegate { 
 ``` 

**반드시 사용해야 하는 메서드**  
- 반드시 행 수와 셀에 출력할 내용을 지정해야 한다.  

- 행 수  
 - 몇 행을 출력할지... 
 ```swift
 func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
     return 행 수  
 }
 ```
- 셀에 출력할 내용  
 - 특정한 행(indexPath.row)에 어떤 내용의 셀을 출력할지 지정  
 ```swift
 func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell { 
     let cell = UITableViewCell(style: .default, reuseIdentifier: "myCell")
     cell.textLabel?.text = "문자열"  
     return cell
 }
 ```

**필요에 따라 사용하는 메서드**  

- 섹션 수 
 - 테이블 뷰에 섹션을 몇 개 만들지 지정. 지정하지 않으면 1  
 ```swift
 func numberOfSections(in tableView: UITableView) -> Int {
     return 섹션 수 
 } 
 ```

