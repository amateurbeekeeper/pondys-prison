package mapeditor;

/**
 * A class that holds the properties of the each wall.
 * 
 * @author youngdani6 300418477
 *
 */
public class Wall {

  private String contianer;
  private String[] items = new String[2];
  private String[] decorations = new String[2];
  private String[] holder;

  Wall(String description) {
    holder = description.split(" ");

    contianer = holder[0];
    int i = 0;
    int i2 = 0;

    i = 1;
    if (holder[i].equals("(")) {
      while (!holder[i + 1].equals(")")) {
        // System.out.println("Success");
        items[i2] = holder[i + 1];
        // System.out.println(holder[i+1]);
        i++;
        i2++;
      }
      i++;
    } else {
      i = 0;
    }

    decorations[0] = holder[i + 1];
    decorations[1] = holder[i + 2];

  }

  /**
   * Set the items.
   * 
   * @param items
   *          Array of items to set
   */
  public void setItems(String[] items) {
    this.items = items;
  }

  /**
   * adds a item to the item array.
   * 
   * @param item
   *          item to add
   */
  public void addItem(String item) {
    int i = 0;
    while (i < items.length) {
      if (this.items[i] == null) {
        this.items[i] = item;
        i = 10;
      }
      i++;
    }
  }

  /**
   * remove an item.
   * 
   * @param item
   *          item to remove
   */
  public void removeItem(String item) {
    int i = 0;

    while (i < items.length) {

      this.items[i] = null;
      i = 10;
    }
    i++;
  }

  /**
   * get the decoration Description.
   * 
   * @return first 2 letters of the decorations
   */
  public String getDecDe() {
    String holder = "";
    if (decorations[0] != null && decorations[1] != null) {
      holder = decorations[0].substring(0, 2) + "&" + decorations[1].substring(0, 2);
    } else if (decorations[0] != null) {
      holder = decorations[0].substring(0, 2);
    } else {
      holder = "Empty";
    }

    return holder;
  }

  /**
   * get the item description.
   *
   * @return the item on this wall first 2 letters
   */
  public String getItemDe() {
    String holder = "";
    if (items[0] != null && items[1] != null) {
      holder = items[0].substring(0, 2) + "&" + items[1].substring(0, 2);
    } else if (items[0] != null) {
      holder = items[0].substring(0, 2);
    } else {
      holder = "Empty";
    }

    return holder;
  }

  /**
   * Get the Decorations.
   * 
   * @return Array of Decorations
   */
  public String[] getDecorations() {
    return decorations;
  }

  /**
   * Set the decorations on this wall.
   *
   * @param dec
   *          the decoration to set
   */
  public void setDecorations(String dec) {

    int i = 0;
    while (i < decorations.length) {
      if (this.decorations[i].equals("Empty")) {
        this.decorations[i] = dec;
        i = 10;
      }
      i++;
    }
  }

  /**
   * Get the container on a wall.
   * 
   * @return string container
   */
  public String getContianer() {
    return contianer;
  }

  /**
   * Set the container.
   * 
   * @param contianer
   *          String to set as container
   */
  public void setContianer(String contianer) {
    this.contianer = contianer;
  }

  /**
   * Get items Array.
   * 
   * @return An Array of items
   */
  public String[] getItems() {
    return items;
  }

}