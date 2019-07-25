package items;

import game_classes.Player;

import javax.swing.ImageIcon;

/**
 * The Apple implementation.
 * 
 * @author fearyelli - 300406946 Apple consumable item
 */
public class Apple implements Item {

  private String name = "Apple";
  private String description = "An apple, it will regenerate 1 level of hunger.";

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
    player.regenHunger(1);
    System.out.println("worked");
  }

  @Override
  public String toString() {
    return "Apple [name=" + name + ", description=" + description + "]";
  }

  public ImageIcon getImage() {
    return new ImageIcon("resources/apple.png");
  }

}
