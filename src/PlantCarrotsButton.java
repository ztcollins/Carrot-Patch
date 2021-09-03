//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Carrot Patch
// Course: CS 300 Spring 2021
//
// Author: Zachary Collins
// Email: ztcollins@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: -
// Online Sources: -
//
///////////////////////////////////////////////////////////////////////////////
/**
 * This class creates a button and simply plants the carrots on screen when pressed on screen
 * 
 * @author Zach C
 *
 */
public class PlantCarrotsButton extends Button {

  public PlantCarrotsButton(float x, float y) {
    super("Plant Carrots", x, y);
  }

  public void mousePressed() {
    if (isMouseOver()) {
      // System.out.println("Plant Carrots Button Pressed");
      Carrots.plant();
    }
  }

}
