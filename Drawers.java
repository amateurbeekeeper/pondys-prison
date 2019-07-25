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
import items.Item;

/**
 * a drawer container, holds multiple items.
 * 
 * @author fearyelli - 300406946
 */
public class Drawers implements Container {

  private boolean isOpen = false;
  private List<Item> items = new ArrayList<>();
  private BufferedImage closedImage;
  private BufferedImage openImage;
  private BufferedImage sideOnClosedImage;
  private BufferedImage sideOnOpenImage;
  private BufferedImage rightSideOnClosedImage;
  private BufferedImage rightSideOnOpenImage;
  private String name = "Drawers";

  /**
   * loads drawer images.
   */
  public Drawers() {
    try {
      closedImage = ImageIO.read(new File("resources/drawers.png"));
      openImage = ImageIO.read(new File("resources/openDrawers.png"));
      sideOnClosedImage = ImageIO.read(new File("resources/sideOnDrawers.png"));
      sideOnOpenImage = ImageIO.read(new File("resources/sideOnOpenDrawers.png"));
      rightSideOnClosedImage = ImageIO.read(new File("resources/rightSideOnDrawers.png"));
      rightSideOnOpenImage = ImageIO.read(new File("resources/rightSideOnOpenDrawers.png"));
    } catch (IOException e) {
      System.out.println("drawers" + e.getMessage());
    }
  }

  /**
   * returns a menu to be displayed when drawers are clicked on. return Hashmap
   * menuoptions
   */
  public HashMap<String, String> getMenu(Player player) {
    if (!isOpen) {
      HashMap<String, String> d = new HashMap<>();
      d.put("Open Drawers", "openDrawers");
      return d;
    } else {

      if (items.isEmpty()) {
        HashMap<String, String> d = new HashMap<>();
        d.put("Look Inside Drawers", "openDrawers");
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
    return "Drawers [isOpen=" + isOpen + ", items=" + items + "]";
  }

  /**
   * dependent on whether drawers are open.
   * 
   * @return image of bin
   */
  public BufferedImage getImage() {
    if (isOpen)
      return openImage;
    return closedImage;
  }

  /**
   * dependent on whether drawers are open.
   * 
   * @return side image of drawers
   */
  public BufferedImage getSideOnImage() {
    if (isOpen)
      return sideOnOpenImage;
    return sideOnClosedImage;
  }

  /**
   * dependent on whether drawers are open.
   * 
   * @return side image of drawers
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
   * getter for name of drawers.
   * 
   * @return name of container (Drawers)
   */
  public String getName() {
    return name;
  }

}
