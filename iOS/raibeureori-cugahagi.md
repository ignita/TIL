# 라이브러리 추가하기

- CocoaPods을 이용하는 방법    
 - 프로젝트 폴더에서 Podfile 이라는 파일을 만들고 아래 내용을 넣는다.  
 ```
 use_frameworks!

 target 'YourApp' do
     pod '추가할 라이브러리' # Or latest version
 end
 ```
 - 파일을 저장하고 동일 위치에서 아래의 명령어 사용  
 ```
 $ pod install   
 ```
 이렇게 설치를 하시면 [프로젝트명].xcworkspace 라는 확장자를 가진 파일이 생길텐데, 이 파일를 실행하면 파일 트리에 기존에 사용하던 프로젝트 와 pod 프로젝트가 함께 뜬다. 그럼 추가 작업이 완료된 것.
pod 으로 라이브러리등을 추가하셔서 작업을 할 경우에는 xcworkspace 파일로 작업을 진행  

# 출처  
http://iphonedev.co.kr/iOSDevQnA/40371  
