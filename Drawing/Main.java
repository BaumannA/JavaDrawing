// note: many imports aren't used yet
import java.util.ArrayList;
import java.util.Scanner;
import processing.core.PApplet;
import processing.core.PShape;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;



public class Main extends PApplet{

	PShape rectangle;
	
	String file = "";
	
	char letter;
	
	int paintSize = 50;
	int color1;
	int color2;
	int color3;
	boolean red = false;
	boolean menuRed = false;
	boolean blue = false;
	boolean green = false;
	boolean yellow = false;
	boolean eraser = false;
	boolean purple = false;
	boolean brown = false;
	boolean orange = false;
	
	boolean show_text = false;
	boolean welcome = true;
	boolean permText = false;
	
	boolean saving = false;
	
	int state = 0;
	
	public void menureset() {
		if (menuRed == true) {
			if (mousePressed) {
				
			}
		}
		else {
			println("Uh oh spaghetti O!");
		}
	}
	
	// needed to create this in order for Eclipse to work
	public static void main(String[] args) {
		PApplet.main("Main");
		
	}
	
	public void settings(){
		size(1280, 720);
	}

	public void setup() {
	//	smooth();
		background(255, 255, 255);
		noStroke();


	}
	
	public void draw() {
		if(state == 0) {
			text("Welcome to drawing", 500, 400, 150, 150);
		}
		
		if(state == 1) {
			background(255);
			state = 2;
		}
		
		if (mousePressed && show_text == true) {
			state = 1;
			fill(color1, color2, color3);
			text("Press 'c' to clear the screen", 50, 5, 200, 50);
			text("Press 's' to save", 250, 5, 200, 50);
			text("Press ']' to increase paint size and '[' to decrease paint size", 500, 5, 500, 50);
			text("Current paint size: " + paintSize, 1000, 5, 150, 50);
			text("easer", 10, 15, 200, 50 );
			show_text = false;
			permText = true;
		}
		
		if(permText) {
			fill(color1, color2, color3);
			text("Press 'c' to clear the screen", 50, 5, 200, 50);
			text("Press 's' to save", 250, 5, 200, 50);
			text("Press ']' to increase paint size and '[' to decrease paint size", 500, 5, 500, 50);
			text("Current paint size: " + paintSize, 1000, 5, 150, 50);
			text("easer", 10, 15, 200, 50 );
		}

		if (mousePressed && state == 0) {
			state = 1;
			show_text = true;
		}
		
		if (welcome == false) {
			
		}
		
		if (show_text == true) {
			fill(color1, color2, color3);
			text("Press 'c' to clear the screen", 50, 5, 200, 50);
			text("Press 's' to save", 250, 5, 200, 50);
			text("Press ']' to increase paint size and '[' to decrease paint size", 500, 5, 500, 50);
			text("Current paint size: " + paintSize, 1000, 5, 150, 50);
			text("easer", 10, 15, 200, 50 );
			
		}
		
		
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 50 && mouseY <= 100) {
			menuRed = true;

			
		}
		
		else {
			fill(255);
			menuRed = false;	
		}

		if (keyPressed) {
			
			if (paintSize >= 1 && paintSize <= 150) {
				
				if (key == ']') {
					paintSize += 1;
					fill(255);
//					rect(1000, 5, 300, 20);
				}
				
				if (key == '[') {
					paintSize -= 1;
					fill(255);
//					rect(1000, 5, 300, 20);
				}
			}
			
			if (paintSize < 2) {
				
				if (key == ']') {
					paintSize += 1;
					fill(255);
//					rect(1000, 5, 300, 20);
				}
			}
			
			if (paintSize > 150) {
				
				if (key == '[') {
					paintSize -= 1;
					fill(255);
//					rect(1000, 5, 300, 20);
				}
			}
			
			if (key == 'c') {
				permText = true;
				
				background(255, 255, 255);
			}
			
			if (key == 's') {
//				text("What do you want to call this file?", 400, 700, 200, 50);
				save("Drawing1.tif");
				
			}
//			huge work in progress:
//			if (saving == true) {
//				text("What do you want to call this file?", 400, 700, 200, 50);
//				text(file, 600, 700, 500, 50);
//				while ((key >='A' && key <= 'z') || key == ' ') {
//					letter = key;
//					file = file + key;
//					println(key);
//					if (key == ENTER) {
//						save(file + ".tif");
//						saving = false;
//					}
//				
//				}
//			}
		}
		else {
			color1 = 0;
		}
		
		if(menuRed) fill(255, 0, 0); rect(50, 50, 50, 50); 
		
		fill(0);
//		rect(0, 700, 1280, 50);
//		text("Press 'c' to clear the screen", 50, 5, 200, 50);
//		text("Press 's' to save", 250, 5, 200, 50);
//		text("Press ']' to increase paint size and '[' to decrease paint size", 500, 5, 500, 50);
//		text("Current paint size: " + paintSize, 1000, 5, 150, 50);
//		text("easer", 10, 15, 200, 50 );
		smooth();
		fill(255, 0, 0);
		// red square
		rect(0, 50, 50, 50);
		fill(0, 10, 255);
		// blue square
		rect(0, 100, 50, 50);
		fill(0, 255, 40);
		// green square
		rect(0, 150, 50, 50);
		fill(255, 255, 0);
		// yellow square
		rect(0, 200, 50, 50);
		fill(255, 0, 255);
		// purple square
		rect(0, 250, 50, 50);
		fill(165, 42, 42);
		// brown square
		rect(0, 300, 50, 50);
		fill(255, 128, 0);
		// oragne square
		rect(0, 350, 50, 50);
		fill(0);
		
		
	}
	
	public void mousePressed() {
		if(red) {
			color1 = 255;
			color2 = 0;
			color3 = 0;
		}
		if(eraser) {
			color1 = 255;
			color2 = 255;
			color3 = 255;
		}
		if(blue) {
			color1 = 0;
			color2 = 10;
			color3 = 255;
		}
		if(green){
			color1 = 0;
			color2 = 255;
			color3 = 40;
		}
		if(yellow) {
			color1 = 255;
			color2 = 255;
			color3 = 0;
		}
		if(purple){
			color1 = 255;
			color2 = 0;
			color3 = 255;
		}
		if(brown) {
			color1 = 165;
			color2 = 42;
			color3 = 42;
		}
		if(orange) {
			color1 = 255;
			color2 = 128;
			color3 = 0;
		}
		else{
			fill(0);
		}
		// check if mouse is in drawing area
		if (mouseX >= 50 && mouseX <= 1280 && mouseY >= 50 && mouseY <= 680) {
			// change the drawing color 
			fill(color1, color2, color3);
			rect(mouseX, mouseY, paintSize, paintSize);
		}
		// if red
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 50 && mouseY <= 100) {

			eraser = false;
			blue = false;
			green = false;
			yellow = false;
			purple = false;
			brown = false;
			orange = false;
			red = true;
		}
		// if eraser (note: in top left corner)
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 0 && mouseY <= 50) {
			red = false;
			blue = false;
			green = false;
			yellow = false;
			purple = false;
			brown = false;
			orange = false;
			eraser = true;
		}
		// if blue
		if (mouseX >= 0 && mouseX <=50 && mouseY >= 100 && mouseY <= 150) {
			eraser = false;
			red = false;
			green = false;
			yellow = false;
			purple = false;
			brown = false;
			orange = false;
			blue = true;
		}
		// if green
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 150 && mouseY <= 200) {
			eraser = false;
			red = false;
			blue = false;
			yellow = false;
			purple = false;
			brown = false;
			orange = false;
			green = true;
		}
		// if yellow
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 200 && mouseY <= 250) {
			eraser = false;
			red = false;
			blue = false;
			green = false;
			purple = false;
			brown = false;
			orange = false;
			yellow = true;
		}
		// if purple
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 250 && mouseY <= 300) {
			eraser = false;
			red = false;
			blue = false;
			green = false;
			yellow = false;
			brown = false;
			orange = false;
			purple = true;
		}
		// if brown
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 300 && mouseY <= 350) {
			eraser = false;
			red = false;
			blue = false;
			green = false;
			yellow = false;
			purple = false;
			orange = false;
			brown = true;
		}
		// if orange
		if(mouseX >= 0 && mouseX <= 50 && mouseY >= 350 && mouseY <= 400) {
			eraser = false;
			red = false;
			blue = false;
			green = false;
			yellow = false;
			purple = false;
			brown = false;
			orange = true;
		}
		
	}
	
	// basically the same code for mousePressed
	public void mouseDragged() {
		if(red) {
			color1 = 255;
			color2 = 0;
			color3 = 0;
		}
		if(eraser) {
			color1 = 255;
			color2 = 255;
			color3 = 255;
		}
		if(blue) {
			color1 = 0;
			color2 = 10;
			color3 = 255;
		}
		if(green){
			color1 = 0;
			color2 = 255;
			color3 = 40;
		}
		if(yellow) {
			color1 = 255;
			color2 = 255;
			color3 = 0;
		}
		if(purple){
			color1 = 255;
			color2 = 0;
			color3 = 255;
		}
		if(brown) {
			color1 = 165;
			color2 = 42;
			color3 = 42;
		}
		if(orange) {
			color1 = 255;
			color2 = 128;
			color3 = 0;
		}
		else{
			fill(0);
		}
		// check if mouse is in drawing area
		if (mouseX >= 50 && mouseX <= 1280 && mouseY >= 50 && mouseY <= 680) {
			// change the drawing color 
			fill(color1, color2, color3);
			rect(mouseX, mouseY, paintSize, paintSize);
		}
		// if red
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 50 && mouseY <= 100) {

			eraser = false;
			blue = false;
			green = false;
			yellow = false;
			purple = false;
			brown = false;
			orange = false;
			red = true;
		}
		// if eraser (note: in top left corner)
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 0 && mouseY <= 50) {
			red = false;
			blue = false;
			green = false;
			yellow = false;
			purple = false;
			brown = false;
			orange = false;
			eraser = true;
		}
		// if blue
		if (mouseX >= 0 && mouseX <=50 && mouseY >= 100 && mouseY <= 150) {
			eraser = false;
			red = false;
			green = false;
			yellow = false;
			purple = false;
			brown = false;
			orange = false;
			blue = true;
		}
		// if green
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 150 && mouseY <= 200) {
			eraser = false;
			red = false;
			blue = false;
			yellow = false;
			purple = false;
			brown = false;
			orange = false;
			green = true;
		}
		// if yellow
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 200 && mouseY <= 250) {
			eraser = false;
			red = false;
			blue = false;
			green = false;
			purple = false;
			brown = false;
			orange = false;
			yellow = true;
		}
		// if purple
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 250 && mouseY <= 300) {
			eraser = false;
			red = false;
			blue = false;
			green = false;
			yellow = false;
			brown = false;
			orange = false;
			purple = true;
		}
		// if brown
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 300 && mouseY <= 350) {
			eraser = false;
			red = false;
			blue = false;
			green = false;
			yellow = false;
			purple = false;
			orange = false;
			brown = true;
		}
		// if orange
		if(mouseX >= 0 && mouseX <= 50 && mouseY >= 350 && mouseY <= 400) {
			eraser = false;
			red = false;
			blue = false;
			green = false;
			yellow = false;
			purple = false;
			brown = false;
			orange = true;
		}
	}	
	
}
