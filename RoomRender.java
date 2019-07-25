package renderer;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import game_classes.Clickable;

/**
 * Class that stores Images and their direction for a Room.
 * 
 * @author pritchsimo
 */
public class RoomRender {

  private String wallpaperColor;
  private List<Image> northImages = new ArrayList<>();
  private List<Image> eastImages = new ArrayList<>();
  private List<Image> southImages = new ArrayList<>();
  private List<Image> westImages = new ArrayList<>();

  /**
   * Creates new Image and adds it to the wall.
   *
   * @param image
   *          BufferedImage of object
   * @param object
   *          Clickable object
   * @param ground
   *          boolean of whether the object is on the ground or is hanging on the
   *          wall
   * @param direction
   *          Direction of wall the image is placed on
   */
  public void addImage(BufferedImage image, Clickable object, boolean ground, game_classes.Direction direction) {
    if (direction == game_classes.Direction.NORTH) {
      northImages.add(new Image(image, object, ground));
    } else if (direction == game_classes.Direction.EAST) {
      eastImages.add(new Image(image, object, ground));
    } else if (direction == game_classes.Direction.SOUTH) {
      southImages.add(new Image(image, object, ground));
    } else {
      westImages.add(new Image(image, object, ground));
    }
  }

  /**
   * Returns the List of Images for the given direction.
   * 
   * @param direction
   *          Direction of wall
   * @return List of Images
   */
  public List<Image> getImages(game_classes.Direction direction) {
    if (direction == game_classes.Direction.NORTH) {
      return northImages;
    } else if (direction == game_classes.Direction.EAST) {
      return eastImages;
    } else if (direction == game_classes.Direction.SOUTH) {
      return southImages;
    }
    return westImages;
  }

  /**
   * Setter for wallpaperColor.
   * 
   * @param color
   *          String of name of color
   */
  public void setWallpaperColor(String color) {
    wallpaperColor = color;
  }

  /**
   * Getter for wallpaperColor.
   * 
   * @return String for wallpaperColor
   */
  public String getWallpaperColor() {
    return wallpaperColor;
  }

  /**
   * Getter for Images of the north wall.
   * 
   * @return List of Images
   */
  public List<Image> getNorthImages() {
    return northImages;
  }

  /**
   * Getter for Images of the east wall.
   * 
   * @return List of Images
   */
  public List<Image> getEastImages() {
    return eastImages;
  }

  /**
   * Getter for Images of the south wall.
   * 
   * @return List of Images
   */
  public List<Image> getSouthImages() {
    return southImages;
  }

  /**
   * Getter for Images of the west wall.
   * 
   * @return List of Images
   */
  public List<Image> getWestImages() {
    return westImages;
  }

}
