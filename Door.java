package game_classes;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import items.Item;
import items.Key;

/**
 * Doors enable the player to move from room to room. There are different
 * colored rooms which require the player to have the corresponding key to open
 * the door. The door can also be in an unlocked state.
 * 
 * @author fearyelli - 300406946
 */
public class Door implements Clickable {

  private boolean isLocked;
  private Room room1;
  private Room room2;
  private String colorCode;
  private BufferedImage image;
  private BufferedImage unlockedImage;
  private BufferedImage sideOnImage;
  private BufferedImage rightSideOnImage;

  /**
   * assigns fields + loads images.
   * 
   * @param colorCode
   *          color of the door
   * @param islocked
   *          whether the door is locked by defualt
   */
  public Door(String colorCode, boolean islocked) {
    this.colorCode = colorCode;
    this.isLocked = islocked;

    try {
      if (colorCode.equals("grey")) {
        image = ImageIO.read(new File("resources/door.png"));
        unlockedImage = ImageIO.read(new File("resources/door.png"));
      } else {
        image = ImageIO.read(new File("resources/" + colorCode + "Door.png"));
        unlockedImage = ImageIO.read(new File("resources/unlocked" + colorCode + "Door.png"));
      }
      sideOnImage = ImageIO.read(new File("resources/sideOnDoor.png"));
      rightSideOnImage = ImageIO.read(new File("resources/rightSideOnDoor.png"));

    } catch (IOException e) {
      System.out.println("door " + e.getMessage());
    }
  }

  /**
   * returns whether the door is locked.
   * 
   * @return if the door is locked
   */
  public boolean isLocked() {
    return isLocked;
  }

  /**
   * checks if the player has a key of the same color.
   * 
   * @param player
   *          current player
   * @return true if the player holds a key of the same color, false if they dont
   */
  public boolean checkKey(Player player) {
    for (Item item : player.getInventory()) {
      if (item instanceof Key) {
        Key key = (Key) item;

        if (key.getColorCode().equals(this.colorCode)) {
          player.removeItem(key); // not working?? james
          isLocked = false; // james
          return true;
        }
      }
    }
    return false;
  }

  /**
   * allows the rooms to be set simultaneously.
   * 
   * @param r1
   *          first room the door connects to
   * @param r2
   *          second room the door connects to
   */
  public void setRooms(Room r1, Room r2) {
    this.room1 = r1;
    this.room2 = r2;
  }

  /**
   * getter for first room.
   * 
   * @return first room the door connects to
   */
  public Room getRoom1() {
    return this.room1;
  }

  /**
   * getter for second room.
   * 
   * @return second room the door connects to
   */
  public Room getRoom2() {
    return this.room2;
  }

  /**
   * allows room1 to be set separately.
   * 
   * @param room
   *          first room the door connects to
   */
  public void setRoom1(Room room) {
    this.room1 = room;
  }

  /**
   * allows room2 to be set separately.
   * 
   * @param room
   *          second room the door connects to
   */
  public void setRoom2(Room room) {
    this.room2 = room;
  }

  /**
   * returns a hashmap of menuoptions the player has.
   * 
   * @return hashmap menuoptions
   */
  public HashMap<String, String> getMenu(Player player) {
    HashMap<String, String> d = new HashMap<>();
    if (isLocked) {
      d.put("Unlock door", colorCode + "Key");
      return d;
    }

    d.put("Open door", "openDoor");
    return d;
  }

  /**
   * unlocks the door, also unlocks the door in the other room so the player can
   * go back into the original room.
   */
  public void unlockDoor() {
    isLocked = false;
    for (Direction direction : Direction.values()) {
      Door temp = room2.getWalls().get(direction).getDoor();
      if (temp != null) {
        if (temp.getColorCode().equals(colorCode)) {
          temp.isLocked = false;
        }
      }
    }
  }

  /**
   * gets the room that is not passed as an argument.
   * 
   * @param originalRoom
   *          room that we dont want to return
   * @return room that is not passed in
   */
  public Room getOtherRoom(Room originalRoom) {
    if (originalRoom == this.room1) {
      return room2;
    } else {
      return room1;
    }
  }

  /**
   * door color getter.
   * 
   * @return color of door
   */
  public String getColorCode() {
    return colorCode;
  }

  @Override
  public String toString() {
    return "Door [isLocked=" + isLocked + ", room1=" + room1 + ", room2=" + room2 + "," + " colorCode=" + colorCode
        + "]";
  }

  /**
   * door image getter.
   */
  public BufferedImage getImage() {
    if (isLocked) {
      return image;
    }
    return unlockedImage;
  }

  public BufferedImage getSideOnImage() {
    return sideOnImage;
  }

  public BufferedImage getRightSideOnImage() {
    return rightSideOnImage;
  }

}
