#include <HCSR04.h>

HCSR04 hc(6, 5); // pino trigger e pino echo

void setup() {
  Serial.begin(9600);
}

void loop() {
  Serial.println(hc.dist());
  delay(10);
}
