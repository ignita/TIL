# 모듈 

- 미리 만들어진 코드를 가져와 쓰는 방법
- 사용 
    - `import 모듈이름` 
    - `모듈이름.모듈안 구성요소`
- 예시
    - `import math`: 수학 관련 기능
    - `import random`: 무작위 관련 기능
    - `import urllib.request`: 인터넷 내용 가져오는 기능 

## `urllib.request` 사용하기 
```python
def get_web(url):
    #URL을 넣으면 페이지 내용을 돌려주는 함수
    import urllib.request
    response = urllib.request.urlopen(url)
    data = response.read()
    decoded = data.decode('utf-8')
    return decoded

url = input('주소: ')
content = get_web(url)
print(content)
``` 

- 결과 
    ```
    주소: http://example.com
    <!doctype html>
    <html>
    <head>
        <title>Example Domain</title>

        <meta charset="utf-8" />
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <style type="text/css">
        body {
            background-color: #f0f0f2;
            margin: 0;
            padding: 0;
            font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
        
        }   
        div {
            width: 600px;
            margin: 5em auto;
            padding: 50px;
            background-color: #fff;
            border-radius: 1em;
        }
        a:link, a:visited {
            color: #38488f;
            text-decoration: none;
        }
        @media (max-width: 700px) {
            body {
                background-color: #fff;
            }
            div {
                width: auto;
                margin: 0 auto;
                border-radius: 0;
                padding: 1em;
            }
        }
        </style>    
    </head>

    <body>
    <div>
        <h1>Example Domain</h1>
        <p>This domain is established to be used for illustrative examples in documents. You may use this
        domain in examples without prior coordination or asking for permission.</p>
        <p><a href="http://www.iana.org/domains/example">More information...</a></p>
    </div>
    </body>
</html>


## 모듈 만들기 
> Python에서 제공하는 모듈이 아닌 직접 만든 모듈은 사용하는 파일과 모듈 파일이 같은 폴더에 존재해야 한다. 
- 내가 만든 모듈
    ```python
    def random_rsp():
    # 가위 바위 보 무작위
    import random
    return random.choice(['가위', '바위', '보'])

    PAPER = '보'
    SCISSOR = '가위'
    ROCK = '바위'
    ```
- 사용 
    ```python
    import my_module

    selected = my_module.random_rsp()
    print(selected)
    print('가위 ?', my_module.SCISSOR == selected)
    ```
    ```
    가위
    가위 ? True
    ```
