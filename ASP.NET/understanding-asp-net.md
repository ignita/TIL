# ASP.NET 이해하기

## ASP.NET ?
- 웹 사이트 개발 [[프레임워크]]
- 웹사이트의 구조와 동작 방식 
![](understanding-asp-net/Untitled%20Diagram.png)
	- 웹 사이트: 하나의 도메인 이름(인터넷 주소)으로 서비스되는 웹 페이지들의 묶음으로 웹 서버에서 관리됨 
	- 웹 서버: 웹 사이트를 사용자에게 서비스해주는 서버 프로그램(소프트웨어) 
	- 웹 페이지: 웹 사이트에 포함되어 있는 개개의 웹 문서로 사용자는 이 웹 페이지를 보면서 정보를 확인 
- 웹 페이지의 종류
	- 정적 웹 페이지(static web page)
	- 동적 웹 페이지(dynamic web page)
![](understanding-asp-net/Untitled%20Diagram%20(1).png)

- ASP.NET으로 만드는 것은 정확히 웹 응용 프로그램 
	- ASP.NET은 웹 응용 프로그램 개발 프레임워크 
		- 최종적으로 구축하려고 하는 것이 웹 사이트이므로 웹 사이트 개발 프레임워크도 맞는 말 

## ASP.NET의 발전 과정 
- MS 사에서 출시한 웹 응요프로그램 개발 프레임워크
> ASP → **ASP.NET Web Forms** → **ASP.NET MVC** → **ASP.NET Web Pages** → ASP.NET Web API → ASP.NET SignalR   

 - 굵은 표시가 웹 사이트 구축 프레임워크 
 - 사용하는 개발방식만 다르다.
 - 웹 폼은 이벤트 기반 모델과 미리 만들어진 다양한 컴포넌트를 통해 좀 더 빠른 개발을 지향하는 방식
 - MVC는 웹 응용 프로그램을 Model - View - Controller 라는 세 영역으로 나누어 개발하는 방식으로 HTML을 완전히 제어할 수 있고 단위 테스트가 용이 
 - 웹 페이지 방식은 ASP.NET 의 세 가지 핵심 개발 방식 중 가장 단순한 개발 방식으로 동적 웹 페이지를 만들 때 HTML과 서버 코드를 함께 작성하는 방식 

## .NET과 .NET Framework 이해하기 
- ASP.NET의 상위 개념 

### .NET
> .NET > .NET Framework > ASP.NET   
- [[XML]] 웹 서비스 플랫폼 - 이기종 간의 시스템을 통합하기 위한 플랫폼(환경).
- .NET에는 여러 개발 도구가 포함되어 있지만 특히 .NET Framework라는 개발 도구는 .NET 플랫폼을 구축하는 데 있어 핵심이 되는 요소 

### .NET Framework
> **.NET Framework**는 XML 웹 서비스와 다양한 종류의 응용 프로그램을 개발, 구축 및 실행할 수 있도록 해주는 프레임워크이다.   
- 다양한 종류의 응용 프로그램
	- 웹 응용 프로그램 ⇒ .NET Framework
	- 데스크톱 응용 프로그램
	- 모바일 응용 프로그램 
- .NET Framework가 소프트웨어인 만큼 .NET Framework를 사용하려면 이것을 컴퓨터에 설치해야 한다. 
	- 그래야 .NET Framework에 포함된 ASP.NET도 사용할 수 있다. 

#공부/닷넷