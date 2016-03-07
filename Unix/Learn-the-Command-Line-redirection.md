# Learn the Command Line  - redirection

![redirection](https://s3.amazonaws.com/codecademy-content/courses/learn-the-command-line/img/LCL-fileTrees-03.png)  

## stdin, stdout, and stderr  
```
$ echo "Hello"
Hello
```

결과를 살펴보면 `echo` 명령은 표준 입력으로 문자열 "Hello"를 받고 터미널로 "Hello" 문자열을 메아리(?) 표준 출력으로 돌려보낸다.  

1. 표준 입력, 줄여서 `stdin`은 키보드나 입력 장치를 통해 터미널로 입력된 정보이다.
2. 표준 출력, 줄여서 `stdout`은 프로세스가 실행되고 나서 출력되는 정보이다. 
3. 표준 에러, 줄여서 `stderr`은 실패된 프로세스에 의해 출력되는 에러 메시지이다.  

"리다이렉션"은 표준 입력, 표준 출력, 표준 에러의 흐름을 변경하는 것이다.  
```
$ echo "Hello" > hello.txt
```

`>` 명령은 표준 출력을 파일로 방향 수정을 한다. 그래서 위 명령을 실행하면 "Hello"가 표준 입력으로 들어오고 표준 출력 "Hello"는 `>`에 의해 리다이렉트되어 파일 **hello.txt**로 들어가게 된다.   
```
$ cat hello.txt
```
`cat` 명령은 파일의 내용을 터미널로 출력한다. 위 명령을 수행하면 **hello.txt**에 있는 내용이 터미널로 출력되는 것이다.    

## >
```
$ cat oceans.txt > continents.txt                                                                
$ cat continents.txt                                                                             
Arctic Ocean                                                                                     
Atlantic Ocean                                                                                   
Indian Ocean                                                                                     
Pacific Ocean                                                                                    
Southern Ocean   
```  
위 명령을 살펴보면 **oceans.txt**의 내용을 **continents.txt**로 리다이렉트해서 `cat`을 이용해 **continents.txt**의 내용을 보면 `oceans.txt`의 내용이 나오는 것을 알 수 있다.   

`>`는 왼쪽 명령의 표준 출력을 가져와 오른쪽 파일로 리다이렉트한다.  
```
$ cat glaciers.txt >> rivers.txt                                                                  
$ cat rivers.txt                                                                                  
Nile River                                                                                        
Amazon River                                                                                      
Yangtze River                                                                                     
Mississippi River                                                                                 
Paraná River                                                                                      
Congo River                                                                                       
Mekong River                                                                                      
Mackenzie River                                                                                   
Niger River                                                                                       
Euphrates River                                                                                   
Yukon River                                                                                       
Indus River                                                                                       
                                                                                                  
Perito Moreno Glacier                                                                             
Margerie Glacier                                                                                  
Furtwängler Glacier                                                                               
Pasterze Glacier                                                                                  
Vatnajökull Glacier                                                                               
Fox Glacier                                                                                       
Biafo Glacier                                                                                     
Canada Glacier                                                                                    
Yulong Glacier                                                                                    
Jostedalsbreen Glacier  
``` 
`>>`는 왼쪽 명령의 표준 출력을 가져와 오른쪽 파일에 이어 붙인다.  

## < 

```
$ cat < lakes.txt                                                                                
Caspian Sea                                                                                      
Lake Superior                                                                                    
Lake Victoria                                                                                    
Lake Michigan                                                                                    
Lake Taganyika                                                                                   
Lake Baikal                                                                                      
Great Bear Lake                                                                                  
Lake Malawi                                                                                      
Lake Titicaca                                                                                    
Lake Nicaragua
```
`<`는 오른쪽에 있는 파일의 표준 입력을 가져와 왼쪽에 있는 프로그램으로 입력한다. 위 명령에서 lake.txt는 `cat` 명령의 표준 입력이 되는것이다. 표준 출력은 터미널에 출력된다.  

## |
```
$ cat volcanoes.txt | wc                                                                         
     17      26     204                                                                          
$ cat volcanoes.txt | wc | cat > islands.txt                                                     
$ cat islands.txt                                                                                
     17      26     204 
```
`|`은 "pipe"이다. `|`은 왼쪽 명령의 표준 출력을 가져와서 오른쪽 명령의 표준 입력으로 "pipe" 된다. "명령에서 명령"으로 리다이렉트한다고 할 수 있다. **cat volcanoes.txt**는 `wc`의 표준 입력이 된다. 결국, `wc` 명령은 **volcanoes.txt**의 라인, 단어, 문자 수를 출력한다.    

```
$ cat volcanoes.txt | wc | cat > islands.txt
```
`|`을 여러개 사용하면 묶어 사용할 수 있다. **cat volcanoes.txt**는 `wc` 명령으로 pipe되고, `wc`의 표준 출력은 `cat`에 pipe 되어 최종적으로 `cat`의 표준 출력은 **islands.txt**로 리다이렉트된다.  

## sort

```
$ sort lakes.txt
```
`sort`는 알파벳 순으로 정렬해서 가져온다.  
```
$ cat lakes.txt | sort > sorted-lakes.txt
```
**lakes.txt**를 알파벳순으로 정렬하고 `cat`의 표준 출력을 가져와 **sorted-lakes.txt**로 리다이렉트 시킨다.  

## uniq  

```
$ uniq deserts.txt                                                                               
Arctic Desert                                                                                    
Sahara Desert                                                                                    
Arabian Desert                                                                                   
Gobi Desert                                                                                      
Kalahari Desert                                                                                  
Great Basic Desert                                                                               
Syrian Desert                                                                                    
Kalahari Desert   
```
`uniq`는 "unique"를 의미하고, 인접하고, 중복된 파일들을 걸러낸다. 위 명령을 보면 "Sahara Desert"는 바로 이전 요소와 중복되기 때문에 걸러졌지만 "Kalahari Desert"는 중복되었으나 인접하지 않기 때문에 그대로 남아 있다.   

## grep
```
$ cat mountains.txt                                                                              
The Himalayas                                                                                    
Hindu Kush Mountains                                                                             
Henduan Mountains                                                                                
Tian Shan                                                                                        
Nyenchen Tanglha                                                                                 
Andes mountains                                                                                  
Atlas Mountains                                                                                  
Mount Kilimanjaro                                                                                
Scandinavian mountains                                                                           
Appalachian mountains                                                                            
Rocky mountains                                                                                  
Sierra Nevada de Santa Marta                                                                     
Transantarctic Mountains                                                                         
                                                                                                 
$ grep Mount mountains.txt                                                                       
Hindu Kush Mountains                                                                             
Henduan Mountains                                                                                
Atlas Mountains                                                                                  
Mount Kilimanjaro                                                                                
Transantarctic Mountains                                                                         
$ grep -i Mount mountains.txt                                                                    
Hindu Kush Mountains                                                                             
Henduan Mountains                                                                                
Andes mountains                                                                                  
Atlas Mountains                                                                                  
Mount Kilimanjaro                                                                                
Scandinavian mountains                                                                           
Appalachian mountains                                                                            
Rocky mountains                                                                                  
Transantarctic Mountains
```
`grep`은 "global regular expression print"을 의미한다. 패턴이 일치하는 라인을 검색해 결과를 반환한다. 대소문자 구별을 한다.  

`grep -i`는 대소문자 구별을 하지 않는다. 정규식에 익숙해지면 정규식을 이용해 패턴으로 파일을 찾기 수월해진다.   

```
$ grep -R Arctic /home/ccuser/workspace/geography                                                
/home/ccuser/workspace/geography/deserts.txt:Arctic Desert                                       
/home/ccuser/workspace/geography/oceans.txt:Arctic Ocean                                         
/home/ccuser/workspace/geography/uniq-deserts.txt:Arctic Desert                                  
/home/ccuser/workspace/geography/continents.txt:Arctic Ocean                                     
$ grep -Rl Arctic /home/ccuser/workspace/geography                                               
/home/ccuser/workspace/geography/deserts.txt                                                     
/home/ccuser/workspace/geography/oceans.txt                                                      
/home/ccuser/workspace/geography/uniq-deserts.txt                                                
/home/ccuser/workspace/geography/continents.txt 
```
```
$ grep -R Arctic /home/ccuser/workspace/geography
```
`grep -R`은 디렉토리에서 모든 파일을 검색해 일치된 결과의 파일이름과 라인을 출력한다. `-R`는 "recursive"를 의미한다.
```
$ grep -Rl Arctic /home/ccuser/workspace/geography
```
`grep -Rl`는 디렉토리에서 모든 파일을 검색해 일치된 결과의 파일 이름만을 출력한다. `-R`은 "recursive", `l`은 "files with matches"을 의미한다.  

## sed  

```
$ cat forests.txt                                                                                
The Amazon snowforest                                                                            
The Congo snowforest                                                                             
Valdivian Temperate snowforest                                                                   
Daintree snowforest                                                                              
Southeast Asian snowforest snowforest                                                            
Tongrass National forest                                                                         
Sinharaja Forest Reserve                                                                         
Pacific Temperate snowforest snowforest                                                          
                                                                                                 
$ sed 's/snow/rain/' forests.txt                                                                 
The Amazon rainforest                                                                            
The Congo rainforest                                                                             
Valdivian Temperate rainforest                                                                   
Daintree rainforest                                                                              
Southeast Asian rainforest snowforest                                                            
Tongrass National forest                                                                         
Sinharaja Forest Reserve                                                                         
Pacific Temperate rainforest snowforest                                                          
                                                                                                 
$ sed 's/snow/rain/g' forests.txt                                                                
The Amazon rainforest                                                                            
The Congo rainforest                                                                             
Valdivian Temperate rainforest                                                                   
Daintree rainforest                                                                              
Southeast Asian rainforest rainforest                                                            
Tongrass National forest                                                                         
Sinharaja Forest Reserve                                                                         
Pacific Temperate rainforest rainforest  
```

```
$ sed 's/snow/rain/' forests.txt
```
`sed`는 "stream editor"를 의미한다. 문자 패턴을 찾고 수정한다.    
`s/snow/rain/`:
- s: "substitution"을 의미한다.  it is always used when using sed for substitution.
- snow: 찾아야하는 문자
- rain: 바꿀 문자  

위 명령은 한 라인에서 찾은 첫 번째 문자만 변경한다.   

```
$ sed 's/snow/rain/g' forests.txt
```

`g`는 "global"을 의미한다. 라인에 있는 모든 "snow"를 "rain"으로 변경한다.  



