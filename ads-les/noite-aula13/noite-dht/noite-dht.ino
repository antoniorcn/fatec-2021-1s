#include "dht.h"

const int pinoDHT11 = A2;

dht DHT;

int a = 0;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600); 
}

void loop() {
  DHT.read11(pinoDHT11);
  Serial.print("Humidade: ");
  Serial.print(DHT.humidity);
  Serial.print("    Temperatura");
  Serial.print(DHT.temperature);
  Serial.println("");
  delay(2000);
}
