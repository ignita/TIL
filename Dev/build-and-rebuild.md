## 빌드와 다시빌드(rebuild)


/target:build 는 변경된 파일이 있는 경우에, 그 파일에 대해서만 컴파일을 하게 됩니다. incremental 하게 컴파일이 이루어지죠.
/target:rebuild 는, 우선 기존 빌드된 결과물들을 모두 삭제합니다. 그 다음에 다시 build 를 하게 되는 것입니다.

VS.NET IDE 에서도 프로젝트를 선택하고 나오는 메뉴에 보면 "build", "rebuild", "clean" 을 볼 수 있는데요.

"clean" 선택 후 "build" 를 하는 것은 곧, "rebuild" 한번과 동일한 효과를 냅니다.

좀더 깊이 들어가면 msbuild 에 대한 얘기가 나오긴 하지만. 이 정도까지만 설명을 드리겠습니다. 
```
간단한걸 만들때도... 리빌드 안하고 그냥 빌드 하면...
버그인지 예전작업물이 출력될때도 =_=
```
```
간혹 헤더파일만 변경하고
컴파일 해보면 헤더파일 변경한것이
실행파일에는 적용되지 않았던 경우가 있는데요
이런 경우에 rebuild를 해서 해결했던 경험이 있습니다.
```



- 출처
    - http://www.devpia.com/MAEUL/Contents/Detail.aspx?BoardID=17&MAEULNo=8&no=63438&ref=63438
