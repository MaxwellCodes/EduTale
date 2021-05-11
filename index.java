import mySound;
import gametheme;
import playerDeath;
import sleep;

PImage centeringTool;
PImage playerSoul;
PImage gameOver;
PImage background;
PImage soulBroken;
PImage artTeacher;

//Sound Settings//


///PFont uiFont;

String playerName = "playerName";
int playerY = 305;
int playerX = 239;
int healthBar = 120;
int hitboxWidth = 21;
int hitboxHeight= 18;
int immunStart = 0;
int immunEnd = 0;
boolean collisions = false;

float left = 0;
float right = 0;
float up = 0;
float down = 0;
float speed = 2.5;

int attkX = 260;
int attkY = 300;
int attkWidth = 15;
int attkHeight = 18;
int attkIndec = 0;


// add varaible for damage so that every attack can do a different amount of damage

// add code for changing box sizes with int for different attacks

// add code for selecting a player name at the very beginning of the game

// Subtract Healthbar by increments of 6 for each "Hit" taken

void setup() {
	size(500, 500);
  // Construct a player here
  playerSoul = loadImage("/gameSprites/soul.png");
  gameOver = loadImage("/gameSprites/gameOver.png");
  centeringTool = loadImage("/gameSprites/centeringTool.png");
  background = loadImage("/gameSprites/eduTaleBackground.jpg");
  soulBroken = loadImage("/gameSprites/soulBroken.png");
  artTeacher = loadImage("/gameSprites/ArtTeacher.png")
 

  // sound ///

 // uiFont = createFont("MonsterFriendFore.otf", 20)
 
}

void draw() {

  gameTheme.play();
  
  /*Ask for player username --> find a way to get a user's input --> set variable playerName to user input --> Make sure the playerName is <= 10 and >= 1
  /*
  
  /*Add initiating atk --> set attkIndec to next attack --> if statement to search for an attack --> pause --> apply new attack --> repeat */
  color black = color(0,0,0);
  image(background,0,0,500,500);
  fill(black);
  rect(61,246,383,142);
  
  image(playerSoul,playerX,playerY,width/22,height/29);

  
  

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
        damageTaken.play();
        immunStart = second();
        immunEnd = (immunStart + 2) % 60;

        textSize(15);
        text(immunStart+1,10,52);
        
        healthBar -= 6;
        

        

      if (healthBar <= 0) {
        healthBar = 0; 
      }
   }

  }
  if(immunEnd == second()) {
    //rect(playerX,playerY,50,50);
    //Initialize the diffrent sprites and have them travel together
      
    // tint player soul to transparent. So only the flikering damaged soul remains
      

    collisions = false; 
  }
  
  color white = (255,255,255);
  fill(white);
  rect(attkX,attkY,attkWidth,attkHeight);

  stroke(255);
  noFill();
  rect(playerX,playerY,hitboxWidth,hitboxHeight);

  textSize(15);
  text(playerX, 10, 20); 
  text(playerY, 10, 36); 
     
     /*Large box*/
  
  stroke(255);
  noFill();
  rect(65, 250, 375, 135);
  rect(64, 249, 377, 137);
  rect(63, 248, 379, 139);
  rect(62, 247, 381, 141);

     /*Player Name*/

  color white = (255,255,255);
  fill(white);
  text(playerName,90,425);

     /*Tiny Boxes*/

  noFill();
  
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

     /*Boss(Teacher)*/

  image(artTeacher,171,90);

 

  if(healthBar == 0){

    boolean deathEnd = false;
    
    // System.out.println("Health reaches 0");

    gameTheme.stop();
    color black = color(0,0,0);
    fill(black);
    rect(0,0,500,500);
    damageTaken.stop();
    //  System.out.println("Takes damage");

    image(soulBroken,playerX,playerY,20,18);
    soulBreaking.play();
  
  // System.out.println("testing sleep");
    beginTime = second();
    endTime = (beginTime+2) % 60;
   


    
      
    if(endTime == second()){
      deathEnd = true;
    }
    
    if(deathEnd == true){
    deathEnd = false;
    playerDeath.play();
    color white = color(255,255,255);
    fill(white);
    image(gameOver,100,215,295,47);
    textSize(25);
    text("Try Again",190,285);}
  }

// image(centeringTool,0,0,500,500);


playerX += (right - left) * speed;
playerY += (up - down) * speed;

if (playerX >= 419) {
    playerX = 419;
  }
if (playerX <= 66) {
    playerX = 66;
  }
if (playerY >= 366) {
    playerY = 366;
  }
if (playerY <= 251) {
    playerY = 251;
  } 



}

/*Movement and Collisions*/
/*Use Translate Method*/
void keyPressed() {
  if (key == CODED) {
    if (keyCode == LEFT) {
      left = 1;
    }
    if (keyCode == RIGHT) {
      right = 1;
    }
    if (keyCode == UP) {
      down = 1;
    }
    if (keyCode == DOWN) {
      up = 1;
    }
  }
}
void keyReleased() {
  if (key == CODED) {
    if (keyCode == LEFT) {
      left = 0;
    }
    if (keyCode == RIGHT) {
      right = 0;
    }
    if (keyCode == UP) {
      down = 0;
    }
    if (keyCode == DOWN) {
      up = 0;
    }
  }
}
