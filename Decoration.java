package game_classes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Decoration, can be a lamp, a bookcase or a painting.
 * 
 * @author fearyelli - 300406946
 */
public class Decoration {

  private String type;
  private BufferedImage image;
  @SuppressWarnings("unused")
  private BufferedImage sideOnImage;
  @SuppressWarnings("unused")
  private BufferedImage rightSideOnImage;

  /**
   * loads images.
   * 
   * @param type
   *          of decoration (lamp, bookcase or painting)
   */
  public Decoration(String type) {
    this.type = type;
    try {
      if (type.equals("lamp")) {
        image = ImageIO.read(new File("resources/" + type + ".png"));
        sideOnImage = image;
        rightSideOnImage = image;
      } else if (type.equals("bookcase")) {
        image = ImageIO.read(new File("resources/" + type + ".png"));
        sideOnImage = ImageIO.read(new File("resources/sideOn" + type + ".png"));
        rightSideOnImage = ImageIO.read(new File("resources/rightSideOn" + type + ".png"));
      } else {
        // painting doesn't get image from Decoration
      }
    } catch (IOException e) {
      System.out.println(type + " " + e.getMessage());
    }
  }

  @Override
  public String toString() {
    return "Decoration [type=" + type + ", image=" + image + "]";
  }

  /**
   * returns decoration type.
   * 
   * @return type of decoration (lamp, bookcase or painting)
   */
  public String getType() {
    return type;
  }

  /**
   * setter for decoration image.
   * 
   * @param image
   *          decoration image
   */
  public void setImage(BufferedImage image) {
    this.image = image;
  }

  /**
   * getter for decoration image.
   * 
   * @return decoration image
   */
  public BufferedImage getImage() {
    return image;
  }

}
