#include <SoftwareSerial.h>

SoftwareSerial BTSerial(4,5);
bool pill = false;
bool temp = true;
  
void setup() {
  Serial.begin(9600);
  Serial.println("Hello!");\
  pinMode(6, OUTPUT); //D3 송신 아웃풋
  pinMode(9, INPUT); //D6 수신 인풋
  digitalWrite(9, HIGH);
  BTSerial.begin(9600);
}

void loop() {
//  while (BTSerial.available()) {
//    byte data = BTSerial.read();
//    Serial.write(data);
//  }
  
  if(digitalRead(6) == LOW) {
    pill = false;
  }
  else {
    pill = true;
  }

  if (pill != temp) {
    temp = pill;
    Serial.println(temp?"1":"0");
  }
  
  byte data = Serial.read();
  BTSerial.write(data);
}
