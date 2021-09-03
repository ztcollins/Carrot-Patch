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
 * A class that creates a button and when it is pressed, all the object arrays are cleared.
 * 
 * @author Zach C
 *
 */
public class RestartButton extends Button {

  public RestartButton(float x, float y) {
    super("Restart", x, y);
    // TODO Auto-generated constructor stub
  }

  public void mousePressed() {
    if (isMouseOver()) {
      // System.out.println("Restart Button Pressed");
      processing.removeAll();
    }
  }

}
