package items;

import game_classes.Player;

import javax.swing.ImageIcon;

/**
 * Implementation of item for Hotdog.
 * 
 * @author fearyelli - 300406946 Hotdog consumable item
 */
public class Hotdog implements Item {

  private String name = "Hotdog";
  private String description = "A hotdog, it will regenerate 3 levels of hunger.";

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
    return "Hotdog [name=" + name + ", description=" + description + "]";
  }

  public ImageIcon getImage() {
    return new ImageIcon("resources/hotdog.png");
  }

}
