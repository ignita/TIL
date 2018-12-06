## 특정 폴더의 하위 파일 가져오기

```csharp
string[] files = Direcotry.GetFiles(@"c:\test\", "*.css", SearchOption.TopDirectoryOnly);
```

## 파일 복사하기

```csharp
foreach(string file in files)
{
    string desDir = Server.MapPath("/") + "파일경로/";
    File.Copy(file, desDir + Path.GetFileName(file));
    // File.Copy(file, desDir + Path.GetFileName(file), true); true이면 overwrite
}
```
