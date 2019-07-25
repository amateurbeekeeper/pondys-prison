package items;

import game_classes.Player;

import javax.swing.ImageIcon;

/**
 * Implementation of Item for Torch.
 * 
 * @author fearyelli - 300406946 Lights up the room
 */
public class Torch implements Item {

  private String name = "Torch";
  private String description = "A flaming torch.";
  private int fuelRemaining = 100;
  private boolean isOn = false;

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
    isOn = !isOn;
  }

  @Override
  public String toString() {
    return "Torch [name=" + name + ", description=" + description + ", fue" + "lRemaining=" + fuelRemaining + ", isOn="
        + isOn + "]";
  }

  /**
   * Is a Torch on.
   * 
   * @return status of the torch
   */
  public boolean getOn() {
    return this.isOn;
  }

  public ImageIcon getImage() {
    return new ImageIcon("resources/torch.png");
  }

}
