package game_classes;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * Interface for all objects that are able to be interacted with.
 * 
 * @author pritchsimo - 300412834
 *
 */
public interface Clickable {

  /**
   * Returns a list of actions when clicked on.
   * 
   * @param player
   *          Player used to interact with inventory
   * @return HashMap that maps action to an icon
   */
  public HashMap<String, String> getMenu(Player player);

  /**
   * Updates image to current state.
   * 
   * @return BufferedImage of object
   */
  public BufferedImage getImage();

  /**
   * Getter for leftSideOnImage.
   * 
   * @return BufferedImage leftSideOnImage
   */
  public BufferedImage getSideOnImage();

  /**
   * Getter for rightSideOnImage.
   * 
   * @return BufferedImage rightSideOnImage
   */
  public BufferedImage getRightSideOnImage();

}
