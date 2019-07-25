package containers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import game_classes.Player;
import items.Combination;
import items.Item;
import items.Key;

/**
 * Safe holds items and can only be opened if the player has a combination.
 * 
 * @author fearyelli - 300406946
 */
public class Safe implements Container {

  private boolean isOpen = false;
  private List<Item> items = new ArrayList<>();
  private BufferedImage closedImage;
  private BufferedImage openImage;
  private BufferedImage sideOnClosedImage;
  private BufferedImage sideOnOpenImage;
  private BufferedImage rightSideOnClosedImage;
  private BufferedImage rightSideOnOpenImage;
  private String name = "Safe";

  /**
   * Constructor for safe.
   */
  public Safe() {

    try {
      closedImage = ImageIO.read(new File("resources/leftSafe.png")); // need to work out whether left or right
      openImage = ImageIO.read(new File("resources/leftOpenSafe.png"));
      sideOnClosedImage = ImageIO.read(new File("resources/sideOnSafe.png"));
      sideOnOpenImage = ImageIO.read(new File("resources/sideOnOpenSafe.png"));
      rightSideOnClosedImage = ImageIO.read(new File("resources/rightSideOnSafe.png"));
      rightSideOnOpenImage = ImageIO.read(new File("resources/rightSideOnOpenSafe.png"));
    } catch (IOException e) {
      System.out.println("safe " + e.getMessage());
    }
  }

  /**
   * returns a menu to be displayed when safe is clicked on. return Hashmap
   * menuoptions
   */
  public HashMap<String, String> getMenu(Player player) {
    if (!isOpen) {
      HashMap<String, String> d = new HashMap<>();
      d.put("Enter Combination", "leftSafe"); // FIX - OPEN SAFE?
      return d;
    } else {

      if (items.isEmpty()) {
        HashMap<String, String> d = new HashMap<>();
        d.put("Look Inside Safe", "leftSafe"); // FIX - OPEN SAFE?
        return d;
      } else {
        HashMap<String, String> d = new HashMap<>();
        for (Item i : items) {
          d.put("Pick up " + i.getName(),
              i.getName().substring(0, 1).toLowerCase() + i.getName().substring(1, i.getName().length()));
        }

        return d;
      }
    }
  }

  /**
   * if the player holds a combination in their inventory, returns true otherwise
   * returns false.
   * 
   * @param player
   *          current player
   * @return boolean depended on players inventory
   */
  public boolean checkCombination(Player player) {
    for (Item item : player.getInventory()) {
      if (item instanceof Combination) { // fixed this
        player.removeItem(item);
        return true;
      }
    }
    return false;
  }

  @Override
  public void open() {
    isOpen = true;
  }

  /**
   * checks if the player has a combination, then opens safe.
   * 
   * @param player
   *          current player
   */
  public void open(Player player) {
    for (Item item : player.getInventory()) {
      if (item instanceof Combination) {
        isOpen = true;
      }
    }
  }

  @Override
  public void close() {
    isOpen = false;
  }

  public void takeItem(Item item) {
    items.remove(item);
  }

  @Override
  public void placeItem(Item item) {
    items.add(item);
  }

  @Override
  public String toString() {
    return "Safe [isOpen=" + isOpen + ", items=" + items + ", name=" + name + "]";
  }

  /**
   * sets the appropriate image at the appropriate place.
   * 
   * @param x
   *          coord of image
   */
  public void setImage(int x) {
    try {
      if (x < 300) { // left
        closedImage = ImageIO.read(new File("resources/leftSafe.png"));
        openImage = ImageIO.read(new File("resources/leftOpenSafe.png"));
      } else if (x > 400 && x < 450) { // middle
        closedImage = ImageIO.read(new File("resources/safe.png"));
        openImage = ImageIO.read(new File("resources/openSafe.png"));
      } else { // right
        closedImage = ImageIO.read(new File("resources/rightSafe.png"));
        openImage = ImageIO.read(new File("resources/rightOpenSafe.png"));
      }
    } catch (IOException e) {
      System.out.println("safe " + e.getMessage());
    }

  }

  /**
   * dependent on whether safe is open.
   * 
   * @return image of safe
   */
  public BufferedImage getImage() {
    if (isOpen)
      return openImage;
    return closedImage;
  }

  /**
   * dependent on whether safe is open.
   * 
   * @return side image of safe
   */
  public BufferedImage getSideOnImage() {
    if (isOpen)
      return sideOnOpenImage;
    return sideOnClosedImage;
  }

  /**
   * dependent on whether safe is open.
   * 
   * @return side image of safe
   */
  public BufferedImage getRightSideOnImage() {
    if (isOpen)
      return rightSideOnOpenImage;
    return rightSideOnClosedImage;
  }

  @Override
  public List<Item> getItems() {
    return this.items;
  }

  @Override
  public void setItems(List<Item> items) {
    this.items = items;

  }

  /**
   * getter for name of bin.
   * 
   * @return returns the name (Safe)
   */
  public String getName() {
    return name;
  }

}
