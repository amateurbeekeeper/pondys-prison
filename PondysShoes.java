package items;

import game_classes.Player;

import javax.swing.ImageIcon;

/**
 * Implementation of item for pondys shoes.
 * 
 * @author fearyelli - 300406946 PondysShoes increases the distance away pondy
 *         is from the player
 */
public class PondysShoes implements Item {

  private String name = "Pondy's Shoes";
  private String description = "Pondy's shoes can be used to scare P"
      + "ondy away thereby increasing the distance between you and him.";

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
    player.regenDistance();
  }

  @Override
  public String toString() {
    return "PondysShoes [name=" + name + ", description=" + description + "]";
  }

  public ImageIcon getImage() {
    return new ImageIcon("resources/pondysShoes.png");
  }

}
