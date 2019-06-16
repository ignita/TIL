# 생활코딩 - Node.js

- 웹서버
    - Apache
    - IIS...
    - Node.js는 웹서버 기능을 내장

## 서버 실행하기

```
    // main.js 
    var http = require('http');
    var fs = require('fs');
    var app = http.createServer(function(request,response){
    		var url = request.url;
    		if(url  == '/'){
    			url = '/index.html';
    		}
    		if(url  == '/favicon.ico'){
    			response.writeHead(404);
    			response.end();
    			return;
    		}
    		response.writeHead(200);
    		console.log(__dirname + url);
    		response.end(fs.readFileSync(__dirname + url));
    });
    app.listen(3000);
``` 

- `node main.js` 로 실행
    - 종료하려면 `Ctrl` + `C`
- 접속은 `[localhost:3000](http://localhost:3000)`

## URL로 입력된 값 사용하기

- URL에 포함된 쿼리 스트링을 해석해 이용하는 방법
    - [`http://localhost:3000/?id=test`](http://localhost:3000/`?id=test`)
        - id 이후: 쿼리 스트링

    ```
    var url = require('url');
    var app = http.createServer(function(request,response){
        var _url = request.url;
        var queryData = url.parse(_url, true).query;
    ```
        

## 파일 읽기

- CRUD
    - Create, Read, Update, Delete

```
var fs = require('fs');
    
fs.readFile('sample.txt', 'utf8', function(err, data) {
    console.log(data);
});
```
