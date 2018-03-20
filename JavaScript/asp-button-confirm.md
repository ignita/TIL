# button OnServerClick 실행 하기 전 confirm 메시지 보여주기 

```html
<button type="button" runat="server" id="btnSubmit"
  OnServerClick="btnSubmit_Click" onclick="if (!confirm('Sure?')) return ">
```
## 참고자료 
https://stackoverflow.com/questions/1245033/asp-net-onserverclick-event-handler-not-called-if-using-onclick