# 아두이노

## 개발환경

- 아두이노 통합개발환경(IDE) 다운로드

  http://arduino.cc/

- 설치하고 실행하면 Sketch(코드) 화면이 나옴.

## Arduino Uno R3

- 아두이노 보드에 맞는 IDE 환경 설정

  툴 - 보드 - Arduino Uno R3

- 스케치 불러오기

  파일 - 예제 - 01.Basics - Blink  

- 스케치 컴파일 및 업로드

  스케치 - 확인&컴파일 또는 <kbd>Ctrl</kbd> + <kbd>R</kbd>

- Arduino 시리얼 포트 설정 

  툴 -  포트 - COM9

  파일 - 업로드 또는 <kbd>Ctrl</kbd> + <kbd>U</kbd>  

## Blink 프로그램 구조

```
/*
  Blink
  Turns on an LED on for one second, then off for one second, repeatedly.

  Most Arduinos have an on-board LED you can control. On the UNO, MEGA and ZERO 
  it is attached to digital pin 13, on MKR1000 on pin 6. LED_BUILTIN is set to
  the correct LED pin independent of which board is used.
  If you want to know what pin the on-board LED is connected to on your Arduino model, check
  the Technical Specs of your board  at https://www.arduino.cc/en/Main/Products
  
  This example code is in the public domain.

  modified 8 May 2014
  by Scott Fitzgerald
  
  modified 2 Sep 2016
  by Arturo Guadalupi
  
  modified 8 Sep 2016
  by Colby Newman
*/


// the setup function runs once when you press reset or power the board
void setup() {
  // initialize digital pin LED_BUILTIN as an output.
  pinMode(LED_BUILTIN, OUTPUT);
}

// the loop function runs over and over again forever
void loop() {
  digitalWrite(LED_BUILTIN, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1000);                       // wait for a second
  digitalWrite(LED_BUILTIN, LOW);    // turn the LED off by making the voltage LOW
  delay(1000);                       // wait for a second
}
```

- 일반적으로 C/C++ 프로그램에서 프로그램의 첫 번째 시작 지점은 main() 함수에서 시작되지만 아두이노 스케치 코드에서는 main() 함수가 존재하지 않는다.(IDE 환경 안에 존재)  
- setup()은 아두이노 스케치에서 한 번만 실행되고 loop()는 아두이노 스케치가 종료될 때까지 반복적으로 실행
  - loop()내의 **digitalWrite(led, HIGH)**가 LED를 켜는 코드  
  - **digitalWrite(led, LOW)**가 LED를 끄는 코드  
  - **delay(1000)**은 1초동안 아무것도 하는 일 없이 기다리는 코드  