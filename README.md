# Today I Learned

오늘 새로 배운 것들을 정리해 commit 한다. 

## 작성 규칙
* 문서 생성은 GFM (Github Flavored Markdown) 을 사용한다. (확장자 `.md`)
* 언어나 기술명으로 폴더를 만든다. (root에 문서를 만들지 않는다.)
* 파일명은 영어로.

## 로컬에 띄우기  

### gollum 설치  

#### Ruby와 RubyGems 설치  

- Mac의 10.5 Leopard 버전 이상에서는 ruby가 이미 포함되어 있다. Homebrew를 사용해 새로운 버전의 ruby를 얻는다.  
 [Homebrew 설치](brew.sh)   

- 새 버전의 ruby 받기   
  ```
  $ brew install ruby
  ```  

- gollum 설치  
 ```
 $ sudo gem install gollum
 ```  

- 해당 repo에 `config.ru` 파일을 만들고 아래의 내용을 넣는다.  

 ```
 require "gollum/app"
 
 Precious::App.set(:gollum_path, File.dirname(__FILE__))
 Precious::App.set(:wiki_options, {})
 run Precious::App
 ```

### pow 설치
 ```
 $ curl get.pow.cx | sh
 ```

### 사용법  
다음 설정을 하고 브라우저에서 http://til.wiki.dev/ 로 접속한다.
```
$ cd ~/.pow
$ ln -s ~/repo이름 til.wiki
```

![gollum](../img/gollum.png)  
이건 http://til.dev/

### Anvil 설치

GUI pow 관리툴 Anvil http://anvilformac.com/

## 참고

* [https://github.com/milooy/TIL](https://github.com/milooy/TIL)
* [https://github.com/thoughtbot/til](https://github.com/thoughtbot/til)