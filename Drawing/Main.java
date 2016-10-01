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
	
	int color1;
	int color2;
	int color3;
	boolean red = false;
	boolean blue = false;
	boolean green = false;
	boolean yellow = false;
	boolean eraser = false;
	boolean purple = false;
	boolean brown = false;
	
	boolean saving = false;
	
	// needed to create this in order for Eclipse to work
	public static void main(String[] args) {
		PApplet.main("Main");
	}
	
	public void settings(){
		size(1280, 720);
	}

	public void setup() {
		size(1280, 720);
		smooth();
		background(255, 255, 255);
		noStroke();
		
	}
	
	public void draw() {
		while (mouseX >= 0 && mouseX <= 50 && mouseY >= 50 && mouseY <= 100) {
			fill(255, 0, 0);
			rect(50, 100, 50, 50);
			break;
		}
		if (mouseX >= 50) {
			
		}

		if (keyPressed) {
			
			if (key == 'c') {
				background(255, 255, 255);
			}
			
			if (key == 's') {
//				text("What do you want to call this file?", 400, 700, 200, 50);
				save("Drawing.tif");
				
			}
//			huge work in progress:
//			if (saving == true) {
//				text("What do you want to call this file?", 400, 700, 200, 50);
//				text(file, 600, 700, 500, 50);
//				if ((key >='A' && key <= 'z') || key == ' ') {
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
		fill(0);
		text("Press 'c' to clear the screen", 50, 700, 200, 50);
		text("Press 's' to save", 250, 700, 200, 50);
		text("easer", 10, 15, 200, 50 );
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
		else{
			fill(0);
		}
		// check if mouse is in drawing area
		if (mouseX >= 50 && mouseX <= 1280 && mouseY >= 0 && mouseY <= 680) {
			// change the drawing color 
			fill(color1, color2, color3);
			rect(mouseX, mouseY, 50, 50);
		}
		// if red
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 50 && mouseY <= 100) {

			eraser = false;
			blue = false;
			green = false;
			yellow = false;
			purple = false;
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
			blue = true;
		}
		// if green
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 150 && mouseY <= 200) {
			eraser = false;
			red = false;
			blue = false;
			yellow = false;
			purple = false;
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
			brown = true;
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
		else{
			fill(0);
		}
		// check if mouse is in drawing area
		if (mouseX >= 50 && mouseX <= 1280 && mouseY >= 0 && mouseY <= 680) {
			// change the drawing color 
			fill(color1, color2, color3);
			rect(mouseX, mouseY, 50, 50);
		}
		// if red
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 50 && mouseY <= 100) {

			eraser = false;
			blue = false;
			green = false;
			yellow = false;
			purple = false;
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
			blue = true;
		}
		// if green
		if (mouseX >= 0 && mouseX <= 50 && mouseY >= 150 && mouseY <= 200) {
			eraser = false;
			red = false;
			blue = false;
			yellow = false;
			purple = false;
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
			brown = true;
		}
	}
	
}
