package items;

import game_classes.Player;

import javax.swing.ImageIcon;

/**
 * Implementation of item for Fries.
 * 
 * @author fearyelli - 300406946 Fries consumable item
 */
public class Fries implements Item {

  private String name = "Fries";
  private String description = "Some fries, they will regenerate 2 levels of hunger.";

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void useItem(Player player) {
    player.regenHunger(2);
  }

  @Override
  public String toString() {
    return "Fries [name=" + name + ", description=" + description + "]";
  }

  public ImageIcon getImage() {
    return new ImageIcon("resources/fries.png");
  }

}
