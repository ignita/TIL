## Json 체크

```javascript
function IsJsonString(str) {
  let json;
  try {
    json = JSON.parse(str);
  } catch (e) {
    return false;
  }
  return json;
}
```

## object 값 NULL 처리

```javascript
function setObjNull(obj) {
  Object.keys(obj).forEach(function(k) {
    obj[k] = null;
  });
}
```

## object 속성 복사

```javascript
Object.assign(object, { color: "value" });

// for IE
var object = { name: "John", surname: "Rowland" };
var newObject = $.extend({}, object);

newObject.age = "30";

console.log(object);
console.log(newObject);
```

## object key 소문자 변경

```javascript
function changeObjToLower(obj) {
  for (var i = 0; i < obj.length; i++) {
    var a = obj[i];
    for (var key in a) {
      var temp;
      if (a.hasOwnProperty(key)) {
        temp = a[key];
        delete a[key];
        a[key.charAt(0).toLowerCase() + key.substring(1)] = temp;
      }
    }
    obj[i] = a;
  }
  return obj;
}

function changeObjToLower2(obj) {
  return (obj = obj.map(function(item) {
    for (var key in item) {
      item[key.charAt(0).toLowerCase() + key.substring(1)] = item[key];
      delete item[key];
    }
    return item;
  }));
}
```
