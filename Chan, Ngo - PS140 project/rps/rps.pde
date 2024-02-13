import processing.serial.*; 

Serial myPort; 
int val = 0; 
int hands = 3; 
PImage[] p1rps = new PImage[hands];
PImage[] p2rps = new PImage[hands]; 
int currFr = 0;
int ready = 0; 
int choice = 0; 
int pScore = 0; 
int cScore = 0; 
boolean hasScore; 
int start; 
int timer; 

void setup()
{
  size(610, 360); 
  String portNm = Serial.list()[1]; 
  myPort = new Serial(this, portNm, 9600); 

  //Image source: 
  //https://img.clipartfest.com/65a22ce202132a378342360d823757fd_rock-paper-scissors-black-horizontal-school-scissors-clipart_408-421.jpeg
  //PS: The images used were inverted and sometimes, flipped.
  frameRate(24); 
  p1rps[0] = loadImage("p1paper.png"); 
  p1rps[1] = loadImage("p1rock.png"); 
  p1rps[2] = loadImage("p1scissors.png"); 

  p2rps[0] = loadImage("p2paper.png");
  p2rps[1] = loadImage("p2rock.png"); 
  p2rps[2] = loadImage("p2scissors.png");

  textSize(40);
}

void draw()
{

  if (ready == 0)
  {
    background(0); 
    hasScore = false; 

    //This is where I learned how to reset the timer
    //https://forum.processing.org/one/topic/how-to-reset-count-time.html
    start = millis(); 

    text("" + pScore, 150, 30); 
    fill(255); 
    text("" + cScore, 440, 30);
    fill(255);
    //This is where I learned how to cycle through images
    //https://processing.org/examples/sequential.html
    currFr = (currFr + 1) % hands; 
    image(p2rps[currFr % hands], 320, 120); 
    //delay(100); 
    if ( myPort.available() > 0) 
    {
      val = myPort.read();
      if (val != 0) 
      {
        ready = 1;
      }
      myPort.clear();
      
    }
  } else if (ready == 1)
  {
    background(0); 

    timer = millis()-start;
    //text(timer / 1000, 20, 20);
    if (val == 17) 
    { 
      choice = 0; //paper
    } else if (val == 18) 
    {
      choice = 1; //rock
    } else if (val == 19) 
    {
      choice = 2; //scissors
    }
    image(p1rps[choice], 100, 120);
    image(p2rps[currFr], 320, 120);
    while (!hasScore)
    {
      if ((choice == 0 && currFr == 1) || (choice == 1 && currFr == 2) || (choice == 2 && currFr == 0))
      {
        pScore++;
      } 
      else if ((choice == 1 && currFr == 0) || (choice == 0 && currFr == 2) || (choice == 2 && currFr == 1))
      {
        cScore++;
      }
      hasScore = true;
    }
    if ((choice == 0 && currFr == 1) || (choice == 1 && currFr == 2) || (choice == 2 && currFr == 0))
    {
      text("Player wins!", 200, 330);
    } 
    else if ((choice == 1 && currFr == 0) || (choice == 0 && currFr == 2) || (choice == 2 && currFr == 1))
    {
      text("Computer wins!", 150, 330);
    } 
    else
    {
      text("Draw!", 245, 330);
    }
    text("" + pScore, 150, 30); 
    fill(255); 
    text("" + cScore, 440, 30);
    fill(255);
    if (timer >= 2000)
    {
      val = 0;
      ready = 0;
    }
  }
}