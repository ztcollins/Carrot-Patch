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
 * This class creates a button which when pressed creates a wolf object that appears randomly
 * on the screen
 * 
 * @author Zach C
 *
 */
public class AddWolfButton extends Button {

  public AddWolfButton(float x, float y) {
    super("Add Wolf", x, y);
    // TODO Auto-generated constructor stub
  }

  public void mousePressed() {
    if (isMouseOver()) {
      // System.out.println("Add Wolf Button Pressed");
      Button.processing.objects.add(new Wolf());
    }
  }

}
