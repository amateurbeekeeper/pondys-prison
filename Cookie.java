package items;

import game_classes.Player;

import javax.swing.ImageIcon;

/**
 * Implementation of item for cookie.
 * 
 * @author fearyelli - 300406946 Cookie consumable item
 */
public class Cookie implements Item {

  private String name = "Cookie";
  private String description = "A cookie, it will regenerate 1 level of hunger.";

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  // @Override
  public void useItem(Player player) {
    player.regenHunger(1);
  }

  @Override
  public String toString() {
    return "Cookie [name=" + name + ", description=" + description + "]";
  }

  public ImageIcon getImage() {
    return new ImageIcon("resources/cookie.png");
  }

}
