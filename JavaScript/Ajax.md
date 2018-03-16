## Ajax  

- Asynchronous JavaScript and XML  
- 웹브라우저와 웹서버가 내부적으로 통신  
- 변경된 결과를 웹페이지에 프로그래밍적으로 반영함으로써 웹페이지의 로딩 없이 서비스를 사용할 수 있게 한다.
- 자바스크립트를 이용해 비동기적(Asynchronous)으로 서버와 브라우저가 데이터를 주고 받는 방식을 의미  
- 이 때 사용하는 API = XMLHttpRequest  
- XML보다 JSON을 더 많이 사용   

## 동기와 비동기 처리 
- 동기: 브라우저가 `<script>` 태그를 만나면 스크립트를 로드하고 처리하기 전까지 다른 작업을 중단하는 것 
- 비동기: 요청된 작업을 처리하면서 페이지의 나머지 또한 계속 로드하는 것. **넌블로킹(non-blocking)** 처리 모델이라고 함.  

 ## XMLHttpRequest  

 - Ajax 통신을 하기 위해 사용하는 객체  
 - 사용법  
  - **time.php**  
      현재 시간을 출력한다.  
    ```php
    <?php
    $d1 = new DateTime;
    $d1->setTimezone(new DateTimezone("asia/seoul"));
    echo $d1->format('H:i:s');
     ?>  
     
    ```  
  - **demo1.html**  
    time.php에 접속해 현재 시간을 페이지에 표시한다.   
    ```html  
    <p>time : <span id="time"></span></p>
    <input type="button" id="execute" value="execute" />
    <script>
    document.querySelector('input').addEventListener('click', function(event){
        var xhr = new XMLHttpRequest();
        xhr.open('GET', './time.php');
        xhr.onreadystatechange = function(){
            if(xhr.readyState === 4 && xhr.status === 200){
                document.querySelector('#time').innerHTML = xhr.responseText;
            }
        }
        xhr.send();
    });
    </script>  
    ```

     ```javascript  
     var xhr = new XMLHttpRequest();  
     ```
     XMLHttpRequest 객체를 생성  
     ```javascript  
     xhr.open('GET', './time.php');  
     ```
     접속하려는 대상을 지정한다. 첫번째 인자는 form 태그의 method에 대응하는 것으로 GET/POST 방식을 주로 사용한다. 두번째 인자는 접속하고자 하는 서버쪽 리소스의 주소로 form 태그의 action에 해당한다.  
     ```javascript  
     xhr.onreadystatechange = function(){
         if(xhr.readyState === 4 && xhr.status === 200){
             document.querySelector('#time').innerHTML = xhr.responseText;
         }
     }
     ```  
     onreadystatechange 이벤트는 서버와의 통신이 끝났을 때 호출되는 이벤트이다. readyState는 통신의 현재 상태를 알려준다. 4는 통신이 완료되었음을 의미하고 status는 HTTP 통신의 결과를 의미하는데 200은 통신이 성공했음을 의미한다. responseText 프로퍼티는 서버에서 전송한 데이터를 담고 있다. 이것을 id가 time인 엘리먼트의 하위로 삽입한다. 이를 통해서 현재 서버에서 가져온 현재시간을 페이지 리로딩 없이 가져올 수 있다.  


## POST 방식  

- **demo2.html**  
시간대와 시간의 출력 형식을 지정  
```html  
<p>time : <span id="time"></span></p>
<select id="timezone">
    <option value="Asia/Seoul">asia/seoul</option>
    <option value="America/New_York">America/New_York</option>
</select>
<select id="format">
    <option value="Y-m-d H:i:s">Y-m-d H:i:s</option>
    <option value="Y-m-d">Y-m-d</option>
</select>
<input type="button" id="execute" value="execute" />
<script>
document.querySelector('input').addEventListener('click', function(event){
    var xhr = new XMLHttpRequest();
    xhr.open('POST', './time2.php');
    xhr.onreadystatechange = function(){
        document.querySelector('#time').innerHTML = xhr.responseText;
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var data = '';
    data += 'timezone='+document.getElementById('timezone').value;
    data += '&format='+document.getElementById('format').value;
    xhr.send(data);
});
</script>   
```  

데이터 전송방법을 GET에서 POST로 변경
```javascript
xhr.open('POST', './time2.php');  
 ```  

서버로 전송할 데이터 타입의 형식(MIME)을 지정  
```javascript
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  
```

서버로 전송할 데이터를 형식에 맞게 만든다. 이름=값&이름=값... 의 형식을 지켜야 한다.   
```javascript
var data = '';
data += 'timezone='+document.getElementById('timezone').value;
data += '&format='+document.getElementById('format').value;
```  

`send` 메소드의 인자로 전송할 데이터를 전달  
```javascript
xhr.send(data);
```    
- **time2.php**  
Ajax를 이용해 전송한 데이터를 받아 현재 시간을 출력해주는 서버쪽 코드  

```php  
<?php
$d1 = new DateTime;
$d1->setTimezone(new DateTimezone($_POST['timezone']));
echo $d1->format($_POST['format']);
?>
```  

## 참고 자료  
- https://opentutorials.org/course/1375/6843  
