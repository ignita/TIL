# $ is not defined 

정말 자주 나는 오류 중 하나다. 
[여기](https://stackoverflow.com/questions/2194992/jquery-is-not-defined)에서 오류가 나는 세 가지 이유를 설명해 주었다. 
- javacript 파일이 제대로 로드되지 않음 
- 잘못된 버전의 jQuery, 누가 core file을 수정했거나, 플러그인이 `$` 변수를 재선언한 경우 
- 페이지가 완전히 로드 되기 전에 javascript를 로드할 경우. 

다른 답변에서 jQuery말고 다른 js 파일이 먼저 적혀 있으면 순서를 jQuery를 앞에 둬보라는 것이 있었다. 난 마스터페이지에서 jQuery를 불러왔는데, jQuery 파일 먼저 불러오니 오류가 해결되었다. 