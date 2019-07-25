package renderer;

import java.awt.Point;
import java.awt.image.BufferedImage;

import containers.Safe;
import game_classes.Clickable;
import game_classes.Door;

/**
 * Class that holds the BufferedImage to be painted, its coordinates, what
 * object is assigned to the image and whether it is on the ground or hanging on
 * the wall
 *
 * @author pritchsimo
 */
public class Image {

  private BufferedImage image; // image
  private Point coords; // where to be drawn
  private Clickable object;
  private boolean ground;

  /**
   * Initializes the fields.
   *
   * @param image
   *          BufferedImage of object
   * @param object
   *          Clickable object
   * @param ground
   *          boolean of whether the object is one the ground or hanging
   *
   */
  public Image(BufferedImage image, Clickable object, boolean ground) {
    this.image = image;
    this.object = object;
    this.ground = ground;
  }

  /**
   * Returns whether or not the object was clicked on.
   * 
   * @param point
   *          Coordinate of mouse click
   * @return True if Point is on BufferedImage
   */
  public boolean isWithin(Point point) {
    // updates to correct state if it hasn't already done so
    getImage();
    if (coords == null) {
      return false;
    }
    if (point.x > coords.x && point.x < coords.x + image.getWidth() && point.y > coords.y
        && point.y < coords.y + image.getHeight()) {
      return true;
    }
    return false;
  }

  /**
   * Getter for whether the object is on the ground.
   * 
   * @return True if the object is on the ground
   */
  public boolean isGround() {
    return ground;
  }

  /**
   * Updates the image for the current state of the object and returns the image.
   * 
   * @return Current image for object
   */
  public BufferedImage getImage() {
    if (object != null) {
      if (coords != null) {
        if (ground) {
          image = object.getImage();
          coords = new Point(coords.x, groundY());
        }
      }
    }
    return image;
  }

  /**
   * Setter for coordinates, for safe objects it sets directional image.
   * 
   * @param x
   *          X-coordinate
   * @param y
   *          Y-coordinate
   */
  public void setCoords(int x, int y) {
    coords = new Point(x, y);
    if (object instanceof Safe) {
      Safe safe = (Safe) object;
      safe.setImage(x);
    }
  }

  /**
   * Used to find height at which object needs to be drawn at.
   * 
   * @return Integer of y-coordinate
   */
  private int groundY() {
    if (object instanceof Door) {
      return 578 - (image.getHeight());
    }
    return 610 - (image.getHeight());
  }

  /**
   * Getter for coordinates.
   * 
   * @return Point of coordinates
   */
  public Point getCoords() {
    return coords;
  }

  /**
   * Getter for object.
   * 
   * @return Clickable object
   */
  public Clickable getObject() {
    return object;
  }

}
