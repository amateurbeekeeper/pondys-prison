package items;

import game_classes.Player;

import javax.swing.ImageIcon;

/**
 * Item interface for items that can be held in the players inventory.
 * 
 * @author fearyelli - 300406946
 */
public interface Item {

  /**
   * Gets the name.
   * 
   * @return name of item
   */
  public String getName();

  /**
   * Gets The description of an item.
   * 
   * @return description of item
   */
  public String getDescription();

  /**
   * depending on the item uses the item. e.g. if it is a consumable the player
   * will consume it.
   * 
   * @param player
   *          current player
   * 
   */
  public void useItem(Player player);

  /**
   * Get a image icon.
   * 
   * @return items image
   */
  public ImageIcon getImage();
}
