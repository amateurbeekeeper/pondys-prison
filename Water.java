package items;

import game_classes.Player;

import javax.swing.ImageIcon;

/**
 * Implements water bottle as an item.
 * 
 * @author fearyelli - 300406946 Water bottle consumable item
 */
public class Water implements Item {

  private String name = "WaterBottle";
  private String description = "A bottle of water, it will regenerate 3 levels of hydration.";

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
    player.regenHydration(3);
  }

  @Override
  public String toString() {
    return "Water [name=" + name + ", description=" + description + "]";
  }

  public ImageIcon getImage() {
    return new ImageIcon("resources/waterBottle.png");
  }

}
