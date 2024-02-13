void setup() {
  // put your setup code here, to run once:
  for (int i = 17; i <= 19; i++)
  {
    pinMode(i, INPUT_PULLUP); 
  }
  Serial.begin(9600); 
}

void loop() {
  // put your main code here, to run repeatedly:
  int p = digitalRead(17); 
  int r = digitalRead(18); 
  int s = digitalRead(19);
  if(!p)
  {
    Serial.write(17); 
  }
  else if(!r)
  {
    Serial.write(18); 
  }
  else if(!s)
  {
    Serial.write(19);
  }
  while ((!p) | (!r) | (!s)) {
    p = digitalRead(17); 
    r = digitalRead(18); 
    s = digitalRead(19);
  }
  delay(100); 
}
