import java.util.ArrayList;
import java.util.Scanner;
import processing.core.PApplet;
import processing.core.PShape;

public class MainDrawing extends PApplet {
	
	public static void main(String[] args) {
		PApplet.main("MainDrawing");
	}
	
	public int count;

	public int xPos = 720;
	public int yPos = 1280;
	int xDir = 1;

	public float rotationAmount = 0;
	public boolean rotateLeft = false;
	public boolean rotateRight = false;

	public float speed = 10;

	public float x = 1280;
	public float y = 720;

	public boolean moveForward = false;

	public boolean moveBackward = false;

	public boolean moveUp = false;

	public boolean moveDown = false;

	public boolean moving = false;

	public boolean enter = false; 
	
	public boolean con = false;
	
	public ArrayList<PShape> rectList = new ArrayList<PShape>();
	
	Scanner playerInput = new Scanner(System.in);
	
	String name1 = "";
	
	int state = 0;
	
	int whichNumb = 1;
	int num1;
	int num2;
	int num3;
	int num4;
	
	public void settings(){
		size(1280, 720);
	}
	
	char letter;
	String name = "";
	String numb = "";
	
	PShape rectangle;
	
	public void setup() {
		size(1280, 720);
		smooth();
		background(0);
		noStroke();
		rectangle = createShape(RECT, num1, num2, num3, num4);
		
		rectList.add(rectangle);
		

		
	}

	public void draw() {
		background(0, 0, 0);
		
		fill (50, 50, 50);
		rect(0, 450, 1280, 100);
		rect(300, 0, 100, 720);
		rect(num1, num2, num3, num4);
		textSize(14);
		fill (255, 255, 255);
		
		for(int i =0; i<rectList.size(); i++){
			PShape r = rectList.get(i);
		
		if (state == 0){
			text("What is your name?", 50, 50);
//			text("Would you like to create/n 1. A circle /n 2. A triangle/n 3. A rectangle?");
		}
		else if (state == 1){
			
			text("You can create shapes, you can type the 4 numbers.", 50, 50);
			text("Press <1> to continue.",50,100);

		}	
		else if (state == 2){
			text("Type the first number(s) (this will set where the object is placed on the x axis).", 50, 50);
			text(name1, 100, 100);
			text("Press <c> to continue", 50, 200);
			
		}
		if (state == 3){
			text("Type the second number(s) (this will set where the object is placed on the y axis).", 50, 50);
			text(name1, 100, 100); 
			text("Press <c> to continue", 50, 200);	
		}
		if (state == 4){
			text("Type the third number(s) (this will state the length of the object).", 50, 50);
			text(name1, 100, 100);
			text("Press <c> to continue", 50, 200);
		}
		if (state == 5){
			text("Type the last number(s) (this will state the height of the object).", 50, 50);
			text(name1, 100, 100);
			text("Press <c> to create your shape", 50, 200);
		}
		if (state == 6){
			text("<1> Create another object", 50, 50);
			text("<2> Work on current object", 50, 100);
			state = 2;
		}
		}

		
		textSize(36);
		text(name, 50, 600, 540, 300);
		move();
		translate(x, y);
		drawRocketShip();
		drawEnemy();
		update();

	}

	public int rocketX = 0;
	public int rocketY = 0;

	public int pX = 0;
	public int pY = 0;


	public void drawHouse() {

		rect(xPos, 100, 300, 1280);

	}

	public void drawEnemy() {

	}

	public void drawRocketShip() {
		stroke(0, 149, 185);
		fill(255, 255, 255);
		//Need to define the rocket ship as drawing at (0,0) because its x and y variables only matter relative to the initial position
		//What was happening is that is was setting (450,450) as its (0,0) and then drawing way down off the screen and thinking its top
		// left corner was at (450,450)
		rect(0, 0, 50, 50);

		stroke(0, 149, 185);
		strokeWeight(0);

		if (moving) {

			fill(255, 255, 255);
			noStroke();

		}
	}
	public void keyTyped() {
		if (state == 5){
			
			if (key >= '0' && key <= '9'){
				letter = key;
				name1 = name1 + key;
				println(key);
			}
			if (key == 'c'){
				state ++;
				Integer i = parseInt(name1);
				num4 = i.intValue();
				name1="";
			}
		}
		if (state == 4){
			
			if (key >= '0' && key <= '9'){
				letter = key;
				name1 = name1 + key;
				println(key);
			}
			if (key == 'c'){
				state ++;
				Integer i = parseInt(name1);
				num3 = i.intValue();
				name1="";
			}
		}
		if (state == 3){
			
			if (key >= '0' && key <= '9'){
				letter = key;
				name1 = name1 + key;
				text(key, 200, 200);
			}
			if (key == 'c'){
				state ++;
				Integer i = parseInt(name1);
				num2 = i.intValue();
				name1="";
			}
		}
		if (state == 2){
			
			if (key >= '0' && key <= '9'){
				letter = key;
				name1 = name1 + key;
				println(key);
			}
			if (key == 'c'){
				println(", ");
				state ++;
				Integer i = parseInt(name1);
				num1 = i.intValue();
				name1="";
			}	
		}
		if (key == ENTER ){
			if (state == 0) state = 1;
		}
		if (state == 0){
			
			
			if ((key >='A' && key <= 'z') || key == ' ') {
				letter = key;
				name = name + key;
				println(key);
			
			}

		}
		if (state == 1){
			if(key == '1'){
				state = 2;
			}
		}
		
	}
	
	public void keyPressed() {
		if (key == 'w' && this.y > 0) {
			moveUp = true;
			moving = true;
			moveDown = false;
		}
		if (key == 's' && this.y < 1280) {
			moveDown = true;
			moving = true;
			moveUp = false;
		}
		if (key == 'd' && this.x < 720) {
			moveBackward = false;
			moveForward = true;
			moving = true;
		}
		if (key == 'a' && this.x > 0) {
			moveForward = false;
			moveBackward = true;
			moving = true;
		}
	}

	public void keyReleased() {
		if (key == 'w') {
			moveUp = false;
			moving = false;
		}
		if (key == 's') {
			moveDown = false;
			moving = false;
		}
		if (key == 'd') {
			moveForward = false;
			moving = false;
		}
		if (key == 'a') {
			moveBackward = false;
			moving = false;
		}
	}

	public void checkBounds() {
		//also a little error here comparing the bounds for x to the height of the screen and y to the width (which is backwards)
		if (this.x < 0) {
			this.x = 0;
			moveBackward = false;
		}
		if (this.x > 1280) {
			this.x = 1280;
			moveForward = false;
		}
		if (this.y < 0) {
			this.y = 0;
			moveDown = false;
		}
		//for some reason the bottom of the window isn't quite down to 720
		if (this.y > 660)
		{
			this.y = 660;
			moveUp = false;
		}
	}

	public void update() {
		checkBounds();
		if(moving) move();
		drawRocketShip();
		System.out.println("x: " + this.x);
		System.out.println("y: " + this.y);
	}

	public void move() {
		
		if (moveForward) {
			this.x += speed;

		}
		if (moveBackward) {
			this.x -= speed;
		}
		if (moveUp) {
			this.y -= speed;
		}
		if (moveDown) {
			this.y += speed;

		}

	}
}
