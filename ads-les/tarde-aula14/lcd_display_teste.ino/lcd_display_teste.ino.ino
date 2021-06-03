#include <Wire.h> 
#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27, 16, 2);  // set the LCD address to 0x27 for a 16 chars and 2 line display

void setup()
{
  lcd.init();                      // initialize the lcd 
}

void loop() { 
  lcd.setBacklight(HIGH);
  lcd.setCursor(0, 0);
  lcd.print("Hello World");
  lcd.setCursor(0, 1);
  lcd.print("LAB Eng Tarde");
  delay(1000);
  lcd.setBacklight(LOW);
  delay(1000);
}
