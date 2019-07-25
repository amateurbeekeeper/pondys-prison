package items;

import game_classes.Player;

import javax.swing.ImageIcon;

/**
 * Implementation for Burger.
 * 
 * @author fearyelli - 300406946 Burger consumable item
 */
public class Burger implements Item {

  private String name = "Burger";
  private String description = "A burger, it will regenerate 3 levels of hunger.";

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
    player.regenHunger(3);
  }

  @Override
  public String toString() {
    return "Burger [name=" + name + ", description=" + description + "]";
  }

  public ImageIcon getImage() {
    return new ImageIcon("resources/burger.png");
  }

}
