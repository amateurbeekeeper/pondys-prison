package items;

import game_classes.Door;
import game_classes.Player;

import javax.swing.ImageIcon;

/**
 * Key implementation of item.
 * 
 * @author fearyelli - 300406946 Key item to unlock doors
 */
public class Key implements Item {

  private String name = "Key";
  private String description = "A colour coded Key.";
  private String colorCode;

  /**
   * set the color Code for a key.
   * 
   * @param colorCode
   *          key color
   * 
   */
  public Key(String colorCode) {
    this.colorCode = colorCode;
  }

  @Override
  public String getName() {
    return colorCode + name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  /**
   * Unlock a Door.
   * 
   * @param door
   *          to be unlocked
   * 
   * @return true if the key is the same color as the door
   */
  public boolean unlockDoor(Door door) {
    if (door.getColorCode().equals(colorCode)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Get the color of a key.
   * 
   * @return color code of key
   */
  public String getColorCode() {
    return colorCode;
  }

  @Override
  public String toString() {
    return "Key [name=" + name + ", description=" + description + ", colorCode=" + colorCode + "]";
  }

  /**
   * Get the image.
   */
  public ImageIcon getImage() {
    if (colorCode.equals("blue")) {
      return new ImageIcon("resources/blueKey.png");
    } else if (colorCode.equals("gold")) {
      return new ImageIcon("resources/goldKey.png");
    } else if (colorCode.equals("green")) {
      return new ImageIcon("resources/greenKey.png");
    } else if (colorCode.equals("orange")) {
      return new ImageIcon("resources/orangeKey.png");
    }
    return new ImageIcon("resources/redKey.png");

  }

  @Override
  public void useItem(Player player) {
    // TODO Auto-generated method stub
  }

}
