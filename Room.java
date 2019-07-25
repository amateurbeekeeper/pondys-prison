package mapeditor;

/**
 * Room is a class that manages walls and go on to floors.
 * 
 * @author youngdani6 300418477
 *
 */

public class Room {

  private Wall northWall;
  private Wall southWall;
  private Wall eastWall;
  private Wall westWall;
  private String xcord;
  private String ycord;
  private String colour;

  /**
   * A Container for walls to make the maps work.
   * 
   * @param description
   *          the String from a save file that contains 1 room
   */

  public Room(String description) {

    String[] holder = description.split(" ");
    // System.out.print(description);
    colour = holder[0];
    xcord = holder[1];
    ycord = holder[2];

    int i = 4;
    String buffer = "";

    while (!holder[i].equals("]")) {
      buffer = buffer + holder[i];
      buffer = buffer + " ";
      i++;

    }
    // System.out.println(Holder);
    northWall = new Wall(buffer);

    buffer = "";
    i++;
    i++;
    while (!holder[i].equals("]")) {
      buffer = buffer + holder[i];
      buffer = buffer + " ";
      i++;
    }
    eastWall = new Wall(buffer);

    buffer = "";
    i++;
    i++;
    while (!holder[i].equals("]")) {
      buffer = buffer + holder[i];
      buffer = buffer + " ";

      i++;

    }

    southWall = new Wall(buffer);

    buffer = "";
    i++;
    i++;
    while (!holder[i].equals("]")) {
      buffer = buffer + holder[i];
      buffer = buffer + " ";
      i++;
    }
    westWall = new Wall(buffer);

  }

  /**
   * Returns x coordinate.
   * 
   * @return X coordinate
   */
  public int getx() {
    return Integer.parseInt(xcord);
  }

  /**
   * Returns Y Coordinate.
   * 
   * @return Y coordinate
   */
  public int gety() {
    return Integer.parseInt(ycord);

  }

  /**
   * returns north wall.
   * 
   * @return north wall
   */
  public Wall getnorthWall() {
    return northWall;
  }

  /**
   * sets north wall.
   * 
   * @param northWall
   *          Wall to set as north wall
   */
  public void setnorthWall(Wall northWall) {
    this.northWall = northWall;
  }

  /**
   * returns south wall.
   * 
   * @return south wall
   */
  public Wall getsouthWall() {
    return southWall;
  }

  /**
   * sets south wall.
   * 
   * @param southWall
   *          wall to set as south wall
   *
   */
  public void setsouthWall(Wall southWall) {
    this.southWall = southWall;
  }

  /**
   * Get the east wall.
   * 
   * @return the east wall
   */
  public Wall geteastWall() {
    return eastWall;
  }

  /**
   * Set east wall.
   * 
   * @param eastWall
   *          wall to set as
   */
  public void seteastWall(Wall eastWall) {
    this.eastWall = eastWall;
  }

  /**
   * Get West wall.
   * 
   * @return west wall
   */
  public Wall getwestWall() {
    return westWall;
  }

  /**
   * Set west wall.
   * 
   * @param westWall
   *          wall to set as the west wall
   */
  public void setwestWall(Wall westWall) {
    this.westWall = westWall;
  }

  /**
   * Get the color of the room.
   * 
   * @return the color of the room
   */
  public String getColour() {
    return colour;
  }

  /**
   * Set the color of the room.
   * 
   * @param colour
   *          the color to set the room of
   */
  public void setColour(String colour) {
    this.colour = colour;
  }

  /**
   * Sets the items to the north.
   * 
   * @param item
   *          The item to place
   */
  public void setNorth(String item) {
    if (northWall.getContianer() != null) {
      if (!northWall.getContianer().equals("Door") && !northWall.getContianer().equals("Empty")) {
        northWall.addItem(item);// more of a add a item
      }
    }
  }

  /**
   * Sets the items to the east.
   * 
   * @param item
   *          The item to place
   */
  public void setEast(String item) {
    if (eastWall.getContianer() != null) {
      if (!eastWall.getContianer().equals("Door") && !eastWall.getContianer().equals("Empty")) {
        eastWall.addItem(item);
      }
    }
  }

  /**
   * Sets the items to the south.
   * 
   * @param item
   *          The item to place
   */
  public void setSouth(String item) {
    if (southWall.getContianer() != null) {
      if (!southWall.getContianer().equals("Door") && !southWall.getContianer().equals("Empty")) {
        southWall.addItem(item);
      }
    }
  }

  /**
   * Sets the items to the west.
   * 
   * @param item
   *          The item to place
   */
  public void setWest(String item) {
    if (westWall.getContianer() != null) {
      if (!westWall.getContianer().equals("Door") && !westWall.getContianer().equals("Empty")) {
        westWall.addItem(item);
      }
    }
  }

  /**
   * Get North items.
   * 
   * @return North item string at 0
   * 
   */
  public String getNorth() {
    return northWall.getItems()[0];
  }

  /**
   * Get East items.
   * 
   * @return East item string at 0
   * 
   */
  public String getEast() {
    return eastWall.getItems()[0];
  }

  /**
   * Get West Items.
   * 
   * @return West item strings at 0
   * 
   */
  public String getWest() {
    return westWall.getItems()[0];
  }

  /**
   * Get South Items.
   * 
   * @return South Item String at 0
   * 
   */
  public String getSouth() {
    return southWall.getItems()[0];
  }

  /**
   * Get the North Container.
   * 
   * @return North Container string
   */
  public String getNorthContainer() {
    return northWall.getContianer();
  }

  /**
   * Get the East container.
   * 
   * @return The East container string
   */
  public String getEastContainer() {
    return eastWall.getContianer();
  }

  /**
   * Get the South Container.
   * 
   * @return The South container String
   */
  public String getSouthContainer() {
    return southWall.getContianer();
  }

  /**
   * Get the west container.
   * 
   * @return The West container string
   */
  public String getWestContainer() {
    return westWall.getContianer();
  }

  /**
   * Sets the container or door on the north wall.
   * 
   * @param item
   *          the container or door
   */
  public void setNorthContainer(String item) {
    if (northWall.getContianer().equals("Door")) {
      String[] array = northWall.getItems();
      array[0] = null;
      array[1] = null;
    }
    northWall.setContianer(item);
  }

  /**
   * Sets the container or door on the east wall.
   * 
   * @param item
   *          the container or door
   */
  public void seteastContainer(String item) {
    if (eastWall.getContianer().equals("Door")) {
      String[] array = eastWall.getItems();
      array[0] = null;
      array[1] = null;
    }
    eastWall.setContianer(item);
  }

  /**
   * Sets the container or door on the south wall.
   * 
   * @param item
   *          the container or door
   */
  public void setsouthContainer(String item) {
    if (southWall.getContianer().equals("Door")) {
      String[] array = southWall.getItems();
      array[0] = null;
      array[1] = null;
    }
    southWall.setContianer(item);
  }

  /**
   * Sets the container or door on the west wall.
   * 
   * @param item
   *          the container or door
   */
  public void setWestContainer(String item) {
    if (westWall.getContianer().equals("Door")) {
      String[] array = westWall.getItems();
      array[0] = null;
      array[1] = null;
    }
    westWall.setContianer(item);
  }

  /**
   * Get the string to put in the text file for the north wall.
   * 
   * @return String to write in a text file that represents the north wall
   */
  public String getSaveNorth() {
    String holder = "[";
    holder = holder + " ";
    if (northWall.getContianer().equals("Empty")) {
      holder = holder + northWall.getContianer();
      holder = holder + " ";
    } else {
      holder = holder + northWall.getContianer();
      holder = holder + " ";

      holder = holder + "(";
      holder = holder + " ";
      String[] buffer = northWall.getItems();
      int i = 0;
      while (i < buffer.length) {
        if (buffer[i] != null) {
          holder = holder + buffer[i];
          holder = holder + " ";
        }
        i++;
      }
      holder = holder + ")";
      holder = holder + " ";

    }
    String[] buffer = northWall.getDecorations();
    int i = 0;
    while (i < buffer.length) {
      holder = holder + buffer[i];
      holder = holder + " ";
      i++;
    }
    holder = holder + "]";

    return holder;
  }

  /**
   * Get the string to put in the text file for the east wall.
   * 
   * @return String to write in a text file that represents the east wall
   */
  public String getSaveEast() {
    String holder = "[";
    holder = holder + " ";
    if (eastWall.getContianer().equals("Empty")) {
      holder = holder + eastWall.getContianer();
      holder = holder + " ";
    } else {
      holder = holder + eastWall.getContianer();
      holder = holder + " ";

      holder = holder + "(";
      holder = holder + " ";
      String[] buffer = eastWall.getItems();
      int i = 0;
      while (i < buffer.length) {
        if (buffer[i] != null) {
          holder = holder + buffer[i];
          holder = holder + " ";
        }
        i++;
      }
      holder = holder + ")";
      holder = holder + " ";

    }
    String[] buffer = eastWall.getDecorations();
    int i = 0;
    while (i < buffer.length) {
      holder = holder + buffer[i];
      holder = holder + " ";
      i++;
    }
    holder = holder + "]";

    return holder;
  }

  /**
   * Get the string to put in the text file for the south wall.
   * 
   * @return String to write in a text file that represents the south wall
   */
  public String getSaveSouth() {
    String holder = "[";
    holder = holder + " ";
    if (southWall.getContianer().equals("Empty")) {
      holder = holder + southWall.getContianer();
      holder = holder + " ";
    } else {
      holder = holder + southWall.getContianer();
      holder = holder + " ";

      holder = holder + "(";
      holder = holder + " ";
      String[] buffer = southWall.getItems();
      int i = 0;
      while (i < buffer.length) {
        if (buffer[i] != null) {
          holder = holder + buffer[i];
          holder = holder + " ";
        }
        i++;
      }
      holder = holder + ")";
      holder = holder + " ";

    }
    String[] buffer = southWall.getDecorations();
    int i = 0;
    while (i < buffer.length) {
      holder = holder + buffer[i];
      holder = holder + " ";
      i++;
    }
    holder = holder + "]";

    return holder;

  }

  /**
   * Get the string to put in the text file for the west wall.
   * 
   * @return String to write in a text file that represents the west wall
   */
  public String getSaveWest() {
    String holder = "[";
    holder = holder + " ";
    if (westWall.getContianer().equals("Empty")) {
      holder = holder + westWall.getContianer();
      holder = holder + " ";
    } else {
      holder = holder + westWall.getContianer();
      holder = holder + " ";
      holder = holder + "(";
      holder = holder + " ";
      String[] buffer = westWall.getItems();
      int i = 0;
      while (i < buffer.length) {
        if (buffer[i] != null) {
          holder = holder + buffer[i];
          holder = holder + " ";
        }
        i++;
      }
      holder = holder + ")";
      holder = holder + " ";
    }
    String[] buffer = westWall.getDecorations();
    int i = 0;
    while (i < buffer.length) {
      holder = holder + buffer[i];
      holder = holder + " ";
      i++;
    }
    holder = holder + "]";

    return holder;

  }

  /**
   * Adds a door to the north wall.
   * 
   * @param color
   *          the color of the door
   */
  public void setNorthDoor(String color) {
    northWall.setContianer("Door");
    String[] array = northWall.getItems();
    array[0] = color;
    array[1] = null;
    northWall.setItems(array);
  }

  /**
   * Adds a door to the east wall.
   * 
   * @param color
   *          the color of the door
   */
  public void setEastDoor(String color) {
    eastWall.setContianer("Door");
    String[] array = eastWall.getItems();
    array[0] = color;
    array[1] = null;
    eastWall.setItems(array);
  }

  /**
   * Adds a door to the south wall.
   * 
   * @param color
   *          the color of the door
   */
  public void setSouthDoor(String color) {
    southWall.setContianer("Door");
    String[] array = southWall.getItems();
    array[0] = color;
    array[1] = null;
    southWall.setItems(array);
  }

  /**
   * Adds a door to the west wall.
   * 
   * @param color
   *          the color of the door
   */
  public void setWestDoor(String color) {
    westWall.setContianer("Door");
    String[] array = westWall.getItems();
    array[0] = color;
    array[1] = null;
    westWall.setItems(array);
  }

  /**
   * Set North Decoration.
   * 
   * @param dec
   *          decoration to put on the wall
   */
  public void setNorthDec(String dec) {
    northWall.setDecorations(dec);
  }

  /**
   * Set East Decoration.
   * 
   * @param dec
   *          decoration to put on the wall
   */
  public void setEastDec(String dec) {
    eastWall.setDecorations(dec);
  }

  /**
   * Set South Decoration.
   * 
   * @param dec
   *          decoration to put on the wall
   */
  public void setSouthDec(String dec) {
    southWall.setDecorations(dec);

  }

  /**
   * Set West Decoration.
   * 
   * @param dec
   *          decoration to put on the wall
   */
  public void setWestDec(String dec) {
    westWall.setDecorations(dec);
  }
}
