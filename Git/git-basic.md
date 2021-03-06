# Git의 기본  

## 변경을 기록하는 커밋  
- 파일 및 폴더의 추가/변경 사항을 저장소에 기록하려면 '커밋'을 이용  
- 커밋에는 변경 이력이 기록된다.  
- 각 커밋에는 영문/숫자로 이루어진 40자리의 고유 이름이 붙는다. 저장소에서는 이 40자리 이름을 보고 각 커밋을 구분하고 선택  
- 버그 수정, 기능 추가 등 특별한 의미가 있는 업데이트를 작업 별로 구분해 각각 커밋하면 나중에 이력을 보고 특정 변경 내용을 찾기 쉽다.  
- 커밋은 이력을 남기는 중요한 작업이기 때문에 커밋 메시지를 필수로 입력  
- Git에서 권장하는 메시지 형식  
  ```
  1번째 줄 : 커밋 내의 변경 내용을 요약  
  
  2번째 줄 : 빈 칸   
  
  3번째 줄 : 변경한 이유     
  ```  
  
- Git 에서는 흔히 말하는 폴더를 '작업 트리(Work Tree)'라고 부른다.  
- 커밋을 실행하기 전의 저장소와 작업 트리 사이에 존재하는 공간을 '인덱스'라고 한다.  
- Git의 '커밋'작업은 '작업 트리'에 있는 변경 내용을 저장소에 바로 기록하는 것이 아니라 그 사이 공간인 '인덱스'에 파일 상태를 기록(stage- 스테이징 한다고 표현하기도 함)하게 되어 있다.  
- 따라서 저장소에 변경 사항을 기록하기 위해서는 기록하고자 하는 모든 변경 사항들이 '인덱스'에 존재해야 한다.  


## 새 저장소 만들기   
- 해당 폴더를 Git의 저장소로 등록하려면 해당 폴더로 이동해 init 명령어를 사용  
`$ git init`   

## 파일 커밋(Commit)하기  
- Git 관리 하에 있는 폴더의 작업 트리와 인덱스 상태를 확인하려면 `status`명령어를 사용  
`$ git status`  
- 파일을 인덱스에 등록하는 명령어는 `add`. 뒤에 파일 이름을 붙여 인덱스에 등록할 파일을 지정  
`$ git add <file>..`  
- 파라미터에 '.'를 지정하면 모든 파일을 인덱스에 등록  
`$ git add .`  
- commit 명령어 포맷  
`$ git commit -m "<댓글>"`  
- 저장소 변경 이력을 확인하기 위해 `log` 명령어를 사용  
`$ git log`  
