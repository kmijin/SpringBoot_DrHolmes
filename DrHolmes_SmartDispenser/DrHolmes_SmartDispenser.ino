#include <SoftwareSerial.h>

SoftwareSerial BTSerial(4,5);
char pill = '0'; //적외선 센서 수신값
char temp = '1'; //반복문 이전 값
  
void setup() {
  Serial.begin(9600);
  Serial.println("Hello!");
  pinMode(3, OUTPUT); //D3 송신 아웃풋
  pinMode(6, INPUT); //D6 수신 인풋
  digitalWrite(3, HIGH); //적외선 송신 HIGH
  BTSerial.begin(9600);
}

void loop() {

  // 적외선 수신기
  if(digitalRead(6) == LOW) {
    // 적외선 감지 안 되면 0
    pill = '0';
  }
  else {
    // 적외선 감지되면 1
    pill = '1';
  }

  // 이전과 값이 다르면
  // == 상태 변화
  if (pill != temp) {
    temp = pill; // 이전 값 갱신
    Serial.println(temp); // 시리얼 모니터 출력
    BTSerial.write(temp); // 블루투스 송신
    delay(1000); // 1초 딜레이
  }
}
