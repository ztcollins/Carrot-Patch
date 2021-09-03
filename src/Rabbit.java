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
import java.io.File;

/**
 * This class constructs Rabbit objects and has methods for their behavior
 * 
 * @author Zach C
 *
 */
public class Rabbit extends Animal {
  private static final String RABBIT = "images" + File.separator + "rabbit.png";
  private static final String TYPE = "R"; // A String that represents the rabbit type
  private static int hopStep = 70; // one hop step
  private static int scanRange = 175; // scan range to watch out for threats
  private static int nextID = 1; // class variable that represents the identifier
  // of the next rabbit to be created
  private final int ID; // positive number that represents the order of this rabbit

  /**
   * Creates a new rabbit object located at a random position of the display window
   */
  public Rabbit() {
    // Set rabbit drawing parameters
    super(RABBIT);
    // Set rabbit identification fields
    ID = nextID;
    this.label = TYPE + ID; // String that identifies the current rabbit
    nextID++;
  }

  // getter of Rabbit.scanRange static field
  public static int getScanRange() {
    return scanRange;
  }

  // getter of Rabbit.hopStep static field
  public static int getHopStep() {
    return hopStep;
  }

  /**
   * Gets the first carrot in the patch. If the carrot is in the Rabbit hopStep range, the rabbit
   * eats it. It sets its position to the (x,y) position of the carrot and the carrot will be
   * removed from the Carrot Patch. Otherwise, the rabbit moves one hopStep towards that carrot. If
   * no carrot found (meaning Carrots.getFirstCarrot() returns false), the rabbit does nothing.
   */
  public void hopTowardsCarrot() {
    // get the first carrot
    int[] carrot = Carrots.getFirstCarrot();

    if (carrot != null) {
      // TODO complete the implementation of this method
      double newX = this.getX();
      double newY = this.getY();
      double distanceFromCarrot =
          Math.sqrt(Math.pow(this.getX() - carrot[1], 2) + Math.pow(this.getY() - carrot[2], 2));

      // while(distanceFromCarrot > hopStep) {
      newX = newX + (hopStep * (carrot[1] - newX)
          / Math.sqrt(Math.pow(newX - carrot[1], 2) + Math.pow(newY - carrot[2], 2)));

      newY = newY + (hopStep * (carrot[2] - newY)
          / Math.sqrt(Math.pow(newX - carrot[1], 2) + Math.pow(newY - carrot[2], 2)));

      distanceFromCarrot = Math.sqrt(Math.pow(newX - carrot[1], 2) + Math.pow(newY - carrot[2], 2));

      this.setX((int) newX);
      this.setY((int) newY);

      // }
      if (distanceFromCarrot <= hopStep) {
        this.setX(carrot[1]);
        this.setY(carrot[2]);
        Carrots.remove(carrot[0]);
      }


    }
  }

  @Override
  public void mousePressed() {
    // call the mousePressed defined in the Animal super class
    // mousePressed();
    // call the hopTowardsCarrot() method
    hopTowardsCarrot();

  }

  /**
   * This method watches out for wolves. Checks if there is a wolf in the Rabbit.scanRange of this
   * Rabbit.
   *
   * @return true if the current rabbit is close to at least one wolf
   */
  public boolean watchOutForWolf() {
    // Traverse the processing.objects arraylist checking
    // whether there is a wolf which is close by Rabbit.scanRange
    // of this rabbit.

    for (int i = 0; i < processing.objects.size(); i++) {
      if (processing.objects.get(i) instanceof Wolf) {
        if (isClose((Animal) processing.objects.get(i), scanRange)) {
          return true;
        }
      }

    }
    return false;
  }

  /**
   * Watches out for a wolf and display a Warning message "WOLF!" if there is any wolf in its
   * neighborhood.
   */
  @Override
  public void action() {
    if (watchOutForWolf()) {
      // this.setScaredImage();
      processing.fill(0); // specify font color: black
      processing.text("WOLF!", this.getX(), this.getY() - this.image.height / 2 - 6);
    }
  }

}
