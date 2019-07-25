package mapeditor;

/**
 * This Class facilitates converting a string into a map.
 * 
 * @author youngdani6 300418477
 *
 */
public class Loader {
  /**
   * Load a map(string) in to Map.
   * 
   * @param save
   *          A string that is read from a file.
   * @return A map that is the string
   */
  public static Map load(String save) {
    Map map = new Map();
    // String[] floorholder = save.split(":");

    int i = 0;
    int i2 = 0;
    int rooms = 0;
    // while(i<floorholder.length) {
    map.addAFloor(new Floor());

    String[] roomholder = save.split("\\r?\\n");

    while (i2 < roomholder.length) {
      if (rooms == 16) { // the other place i hard coded {

        map.addAFloor(new Floor());

        rooms = 0;
        i++;
      }

      map.getFloors().get(i).addARoom(new Room(roomholder[i2]));
      i2++;
      rooms++;
    }
    i2 = 0;

    // }

    return map;

  }

}
