# CSS  

**C**ascading **S**tyle **S**heet  

- html에서 정보 전달을 위해 좀 더 보기 좋게 스타일을 입힘.  
- style 태그를 이용  
```html
<style>
    h1 {color:red; font-size: 10px}
</style>
```  
- `h1`: 선택자<sup>selector</sup>   
- `{color:red}`: 서술<sup>description</sup>
- `;`: 속성과 속성을 구분   

```html
header h1 {
    border: 1px solid red;
}
```  
- header 태그 밑에 있는 h1 태그에 적용  

## 박스모델  

``` html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style>
      #selected {
        border: 1px red solid;
        padding: 30px;
        margin: 50px;
      }
    </style>
  </head>
  <body>
    <ul>
      <li>html</li>
      <li id="selected">css</li>
      <li>javascript</li>
    </ul>
  </body>
</html>
```
- `#selected`: selected라는 id 값을 가진 태그에만 속성을 적용     
- **박스모델**  
![boxmodel](../img/css/basic-of-css/box-model.png)  

 - padding: border와 content 사이의 여백    
 - margin: 태그와 태그 사이의 여백  
 
- 웹 브라우저의 '요소검사'로 확인 가능!    
 ![boxmodel2](../img/css/basic-of-css/box-model2.png)  


## float  

- 나란히 배치 되게 하는 기능  

``` html
    <style>
      img {
        border: 1px solid red;
        float: left;
        margin-right: 10px;
      }
    </style>
  </head>
  <body>
    <img src="https://s3.ap-northeast-2.amazonaws.com/opentutorials-user-file/course/94.png">
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus lacus ligula, ultricies id mauris nec, lacinia condimentum mauris. Nam est purus, lobortis eget nibh vel, vestibulum gravida metus. In vehicula tincidunt nisi, ac pretium orci vestibulum quis. Integer fermentum turpis quis convallis blandit. Morbi gravida sollicitudin enim in sodales. Aenean ac consequat enim. Sed tincidunt felis libero, non dictum est molestie a.
</body>
```

