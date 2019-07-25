package containers;

import java.util.List;

import game_classes.Clickable;
import items.Item;

/**
 * container class, containers hold multiple items and can be opened and closed
 * by a player as well as allowing the player to remove the items.
 * 
 * @author fearyelli - 300406946
 */
public interface Container extends Clickable {

  /**
   * opens the container.
   */
  public void open();

  /**
   * closes the container.
   */
  public void close();

  /**
   * this takes the item from the container and places it in the players
   * inventory.
   * 
   * @param item
   *          to be removed from container
   */
  public void takeItem(Item item);

  /**
   * this takes the item from the players inventory and places it inside the
   * container.
   * 
   * @param item
   *          to be added to container
   */
  public void placeItem(Item item);

  /**
   * sets the items that the container should hold.
   * 
   * @param items
   *          to be in the container
   */
  public void setItems(List<Item> items);

  /**
   * returns items container holds.
   * 
   * @return the item list
   */
  public List<Item> getItems();

  /**
   * returns the name of the container.
   * 
   * @return the item name
   */
  public String getName();

}
