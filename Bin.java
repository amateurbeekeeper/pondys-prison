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
 * A bin container, holds multiple items.
 * 
 * @author fearyelli - 300406946
 */
public class Bin implements Container {

  private boolean isOpen = false;
  private List<Item> items = new ArrayList<>();
  private BufferedImage closedImage;
  private BufferedImage openImage;
  private String name = "Bin";

  /**
   * loads bin images.
   */
  public Bin() {
    try {
      closedImage = ImageIO.read(new File("resources/rubbishBin.png"));
      openImage = ImageIO.read(new File("resources/openRubbishBin.png"));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * returns a menu to be displayed when bin is clicked on. return Hashmap
   * menuoptions
   */
  public HashMap<String, String> getMenu(Player player) {
    if (!isOpen) {
      HashMap<String, String> d = new HashMap<>();
      d.put("Open Bin", "openRubbishBin");
      return d;
    } else {

      if (items.isEmpty()) {
        HashMap<String, String> d = new HashMap<>();
        d.put("Look Inside Bin", "openRubbishBin");
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
    return "Bin [isOpen=" + isOpen + ", items=" + items + "]";
  }

  /**
   * dependent on whether bin is open.
   * 
   * @return image of bin
   */
  public BufferedImage getImage() {
    if (isOpen)
      return openImage;
    return closedImage;
  }

  /**
   * dependent on whether bin is open.
   * 
   * @return side image of bin
   */
  public BufferedImage getSideOnImage() {
    if (isOpen)
      return openImage;
    return closedImage;
  }

  /**
   * dependent on whether bin is open.
   * 
   * @return side image of bin
   */
  public BufferedImage getRightSideOnImage() {
    if (isOpen)
      return openImage;
    return closedImage;
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
   * @return name of container (Bin)
   */
  public String getName() {
    return name;
  }

}
