//import java.util.Scanner;
PImage centeringTool;
PImage playerSoul;
PImage gameOver;

String playerName = "playerName";
int playerY = 305;
int playerX = 239;
int playerSpeed = 0;
int healthBar = 120;
int attkX = 0;
int attkY = 0;
int attkWidth = 0;
int attkHeight = 0;
int hitboxWidth = 21;
int hitboxHeight= 18;
int immunStart = 0;
int immunEnd = 0;
int attkIndec = 0;
boolean collisions = false;
boolean upArrow = false;
boolean leftArrow = false;
boolean rightArrow = false;
boolean downArrow = false;

// add varaible for damage so that every attack can do a different amount of damage

// add code for changing box sizes with int for different attacks

// add code for selecting a player name at the very beginning of the game

/*Subtract Healthbar by increments of 6 for each "Hit" taken*/

void setup() {
	size(500, 500);
  playerSoul = loadImage("soul.png");
  gameOver = loadImage("gameOver.png");
  centeringTool = loadImage("centeringTool.png");
 
}

void draw() {
  background(0);

  /*Ask for player username --> find a way to get a user's input --> set variable playerName to user input --> Make sure the playerName is <= 10 and >= 1
  /*
  
  /*Add initiating atk --> set attkIndec to next attack --> if statement to search for an attack --> pause --> apply new attack --> repeat */

  if(attkIndec == 0){}
  
  if(collisions == false) {
    if((playerX + hitboxWidth >= attkX) &&
      (playerX <= attkX + attkWidth) &&
      (playerY + hitboxHeight >= attkY) &&
      (playerY <= attkY + attkHeight)) {
      
        collisions = true;

      /* Signal a 2 second immunity when hit by attack */
      /* boolean of immuntimer
         timer of 2 seconds
         when player.collide trigger timer
         when timer is triggered
         turn off Collisions
         when timer ends resume checking for collisions
      */
       
        immunStart = second();
        immunEnd = (immunStart + 1) % 60;

        textSize(15);
        text(immunStart+1,10,52);
        
        healthBar -= 6;

      if (healthBar <= 0) {
        healthBar = 0; 
      }
   }

  }
  if(immunEnd == second()) {
    collisions = false;
  }

  stroke(255);
  noFill();
  rect(playerX,playerY,hitboxWidth,hitboxHeight);

  textSize(15);
  text(playerX, 10, 20); 
  text(playerY, 10, 36); 
  
  image(playerSoul,playerX,playerY,width/22,height/29);
     
     /*Large box*/
  
  stroke(255);
  noFill();
  rect(65, 250, 375, 135);
  rect(64, 249, 377, 137);
  rect(63, 248, 379, 139);
  rect(62, 247, 381, 141);

     /*Player Name*/

  text(playerName,90,425);

     /*Tiny Boxes*/
  
  rect(70, 450, 100, 40);
  stroke(255);
  noFill();

  rect(200, 450, 100, 40);
  stroke(255);
  noFill();

  rect(330, 450, 100, 40);
  stroke(255);
  noFill();
  
     /*Health Bar*/
    
  stroke(0);
  fill(255,0,0);
  rect(247,410,120,20);

  stroke(0);
  fill(255,255,0);
  rect(247,410,healthBar,20);

  fill(255,255,255);
  text("HP",220,426);

  fill(255,255,255);
  text(healthBar/6+"/20",375,426);

  if(healthBar == 0){
    background(0);
    image(gameOver,100,215,295,47);
    textSize(25);
    text("Try Again",190,285);
  }

  /* if(playerName == ""){
    background(0);
    textFont("")
    text("What's the name of your soul?",140,200)
    text(playerName,160,250);
  }*/

// image(centeringTool,0,0,500,500);

}

/*Movement and Collisions*/
/*Use Translate Method*/
void keyPressed() {
  if (key == CODED) {
    if (keyCode == UP) {
      playerY -= 5
    }
    if (keyCode == DOWN) {
      playerY += 5
    }
    if (keyCode == LEFT) {
      playerX -= 5
    }
    if (keyCode == RIGHT) {
      playerX += 5
    }
}
  if (playerX >= 419) {
    playerX = 419;
  }
  if (playerX <= 64) {
    playerX = 64;
  }
  if (playerY >= 367) {
    playerY = 367;
  }
  if (playerY <= 250) {
    playerY = 250;
  } 
}
