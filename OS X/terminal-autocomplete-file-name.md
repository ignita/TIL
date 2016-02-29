# 터미널에서 파일이름 자동완성 기능  

<kbd>tab</kbd>이 안먹히길래 검색해보니  
홈 디렉터리에서 다음을 입력해 에디터 창을 열고 

```bash  
vim .inputrc
```

다음과 같이 입력한 후 `:w`로 저장, `:q`로 종료한다. 대소문자를 구분해주고 싶을 때에는 첫 줄을 삭제하거나 off 시키면 된다.  
```vim
set completion-ignore-case on
set show-all-if-ambiguous on
TAB: menu-complete
```  

<kbd>⌘</kbd>+<kbd>N</kbd>로 새 터미널 창을 열고 `login`을 입력한 후 로그인을 한다.  
그러고 나면 디렉토리나 파일 이름을 앞 두글자만 입력하고 <kbd>tab</kbd>을 누르면 자동완성이 된다.  

##참고 
http://osxdaily.com/2012/08/02/improve-tab-completion-in-mac-os-x-terminal/
