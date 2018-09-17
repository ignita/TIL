## 각각의 id 값에 이벤트 걸기


```javascript
$("[id*='pauseButton']").each(function (i) {
    $(this).click(function () {
        var slide = '#carouselSlide' + i;
        var pauseButton = '#pauseButton' + i;
        var playButton = '#playButton' + i;

        $(slide).carousel('pause');
        $(pauseButton).hide();
        $(playButton).show();
    })
});
```