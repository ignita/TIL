# 라이브러리 추가 하기    

- CocoaPods을 사용한 라이브러리 추가 방법 
 - 프로젝트 폴더에서 Podfile 이라는 파일을 만들고 아래 내용을 넣는다. 
   ```
   use_frameworks!

   target 'YourApp' do
       pod 'Socket.IO-Client-Swift', '~> 8.1.1' # Or latest version
   end  
   ```
- 파일 저장을 하고, 동일 위치에서 아래 명령어로 pod 설치
 ```
 $ pod install
 ```

- 설치를 하시면 [프로젝트명].xcworkspace 라는 확장자를 가진 파일이 생길텐데, 이 파일를 실행하면 파일 트리에 기존에 사용하시던 프로젝트 와 pod 프로젝트가 함께 뜬다. 그럼 추가 작업이 완료된 것.  
- pod 으로 라이브러리등을 추가하셔서 작업할 경우에는 xcworkspace 파일로 작업을 진행하면 된다.  

# 출처  
http://iphonedev.co.kr/iOSDevQnA/40371
