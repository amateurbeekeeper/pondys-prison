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
import items.Apple;
import items.Burger;
import items.Fries;
import items.Item;
import items.*;

/**
 * a chest container, holds multiple items.
 * 
 * @author fearyelli - 300406946
 */
public class Chest implements Container {

  private boolean isOpen = false;
  private List<Item> items = new ArrayList<>();
  private BufferedImage closedImage;
  private BufferedImage openImage;
  private BufferedImage sideOnClosedImage;
  private BufferedImage sideOnOpenImage;
  private BufferedImage rightSideOnClosedImage;
  private BufferedImage rightSideOnOpenImage;
  private String name = "Chest";

  /**
   * loads images for chest.
   */
  public Chest() {
    try {
      closedImage = ImageIO.read(new File("resources/chest.png"));
      openImage = ImageIO.read(new File("resources/openChest.png"));
      sideOnClosedImage = ImageIO.read(new File("resources/sideOnChest.png"));
      sideOnOpenImage = ImageIO.read(new File("resources/sideOnOpenChest.png"));
      rightSideOnClosedImage = ImageIO.read(new File("resources/rightSideOnChest.png"));
      rightSideOnOpenImage = ImageIO.read(new File("resources/rightSideOnOpenChest.png"));
    } catch (IOException e) {
      System.out.println("chest " + e.getMessage());
    }
  }

  /**
   * returns a menu to be displayed when chest is clicked on. return Hashmap
   * menuoptions
   */
  public HashMap<String, String> getMenu(Player player) {
    if (!isOpen) {
      HashMap<String, String> d = new HashMap<>();
      d.put("Open Chest", "openChest");
      return d;
    } else {

      if (items.isEmpty()) {
        HashMap<String, String> d = new HashMap<>();
        d.put("Look Inside Chest", "openChest");
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

  @Override
  public void open() {
    isOpen = true;
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
    return "Chest [isOpen=" + isOpen + ", items=" + items + "]";
  }

  @Override
  public List<Item> getItems() {
    return this.items;
  }

  /**
   * dependent on whether chest is open.
   * 
   * @return image of chest
   */
  public BufferedImage getImage() {
    if (isOpen)
      return openImage;
    return closedImage;
  }

  /**
   * dependent on whether chest is open.
   * 
   * @return side image of chest
   */
  public BufferedImage getSideOnImage() {
    if (isOpen)
      return sideOnOpenImage;
    return sideOnClosedImage;
  }

  /**
   * dependent on whether chest is open.
   * 
   * @return side image of chest
   */
  public BufferedImage getRightSideOnImage() {
    if (isOpen)
      return rightSideOnOpenImage;
    return rightSideOnClosedImage;
  }

  @Override
  public void setItems(List<Item> items) {
    this.items = items;

  }

  /**
   * getter for name of chest.
   * 
   * @return name of container (Chest)
   */
  public String getName() {
    return name;
  }
}
