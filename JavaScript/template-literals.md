# Template literals

지금까지 문자열과 변수를 이어 줄 때 그냥 `+`를 사용했었다.  
바닐라 자바스크립트 영상을 보고 난 뒤, C#의 `String.Format()`같은 것이 자바스크립트에도 있단 것을 알게되었다.

```javascript
var a = 5;
var b = 10;
console.log(`Fifteen is ${a + b} and\nnot ${2 * a + b}.`);
// "Fifteen is 15 and
// not 20."
```

그리고 변수 선언 때 `const`를 사용하고.. 꼭 바뀌어야 하는 경우가 생기면 그 때 `let`으로 바꿔라 했는데, `var`만 매번 사용했는데 더 공부하고 사용하는 상황을 익혀야겠다.
