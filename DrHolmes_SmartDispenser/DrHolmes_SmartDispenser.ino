#include <SoftwareSerial.h>

SoftwareSerial BTSerial(4,5);
//
//String pilla = "a0"; //적외선 센서 수신값
//String pillb = "b0"; //적외선 센서 수신값
//String tempa = "a1"; //반복문 이전 값
//String tempb = "b1"; //반복문 이전 값

String pilla = "0"; //적외선 센서 수신값
String pillb = "0"; //적외선 센서 수신값
String tempa = "1"; //반복문 이전 값
String tempb = "1"; //반복문 이전 값

char datas[2][2] = {{'a','0'},{'b','0'}};
char temp[2][2] = {{'a','0'},{'b','0'}};

void setup() {
  Serial.begin(9600);
  Serial.println("Hello!");
  pinMode(2, OUTPUT); //D2 송신 아웃풋
  pinMode(3, OUTPUT); //D3 송신 아웃풋
  pinMode(6, INPUT); //D6 수신 인풋
  pinMode(7, INPUT); //D7 수신 인풋
  digitalWrite(2, HIGH); //적외선 송신 HIGH
  digitalWrite(3, HIGH); //적외선 송신 HIGH
  BTSerial.begin(9600);
}

void loop() {

  // 적외선 수신기
  if(digitalRead(6) == LOW) {
    // 적외선 감지 안 되면 1
    datas[0][1] = '1';
  }
  else {
    // 적외선 감지되면 0
    datas[0][1] = '0';
  }
  // 적외선 수신기
  if(digitalRead(7) == LOW) {
    // 적외선 감지 안 되면 1
    datas[1][1] = '1';
  }
  else {
    // 적외선 감지되면 0
    datas[1][1] = '0';
  }

  // 이전과 값이 다르면
  // == 상태 변화
  if (datas[0][1] != temp[0][1]) {
    temp[0][1] = datas[0][1]; // 이전 값 갱신
    Serial.print(temp[0][0]); // 시리얼 모니터 출력
    Serial.print(temp[0][1]); // 시리얼 모니터 출력
    Serial.println();
    BTSerial.write(temp[0][0]); // 블루투스 송신
    BTSerial.write(temp[0][1]); // 블루투스 송신
    }

  // 이전과 값이 다르면
  // == 상태 변화
  if (datas[1][1] != temp[1][1]) {
    temp[1][1] = datas[1][1]; // 이전 값 갱신
    Serial.print(temp[1][0]); // 시리얼 모니터 출력
    Serial.print(temp[1][1]); // 시리얼 모니터 출력
    Serial.println();
    BTSerial.write(temp[1][0]); // 블루투스 송신
    BTSerial.write(temp[1][1]); // 블루투스 송신
  }
  delay(100);
}
