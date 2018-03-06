# JS Tab (tab.js)

| Class | 설명 | 
| --- | --- |
|`.tab-content` | `.tab-pane`, `data-toggle="tab"`과 사용| 
|`.tab-pane` | `.tab-content`, `data-toggle="tab"`과 사용|

- 각 탭에 `data-toggle="tab"`과 `.tab-pane` 클래스, 고유 ID값을 넣고 `.tab-content`로 감싼다. 
```html
<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
  <li><a data-toggle="tab" href="#menu1">Menu 1</a></li>
</ul>

<div class="tab-content">
  <div id="home" class="tab-pane fade in active">
    <h3>HOME</h3>
    <p>Some content.</p>
  </div>
  <div id="menu1" class="tab-pane fade">
    <h3>Menu 1</h3>
    <p>Some content in menu 1.</p>
  </div>
</div>
```

## 참고자료 

- https://www.w3schools.com/bootstrap/bootstrap_ref_js_tab.asp
- https://getbootstrap.com/docs/4.0/components/list-group/#fade-effect


