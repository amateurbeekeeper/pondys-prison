package items;

import game_classes.Player;

import javax.swing.ImageIcon;

/**
 * Combination implementation of item.
 * 
 * @author fearyelli - 300406946 combination item needed to unlock a safe
 */
public class Combination implements Item {

  private String name = "Combination";
  private String description = "A combination for a safe.";

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
    // Cannot use Combination.
  }

  @Override
  public ImageIcon getImage() {
    return new ImageIcon("resources/combination.png");
  }

}
