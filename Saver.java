package mapeditor;

import java.util.ArrayList;

/**
 * This Class is a function that loads a map in to the string.
 * 
 * @author youngdani6 300418477
 *
 */
public class Saver {

  /**
   * Make a string from a map.
   * 
   * @param mapToSave
   *          The map
   * @return The String of the map
   */

  public static String makeSave(Map mapToSave) {
    String save = "";

    int i = 0;
    int roomcount = 0;
    int floori = 0;
    while (floori < mapToSave.getNumFloors()) {

      ArrayList<Room> rooms = new ArrayList<Room>();
      rooms = mapToSave.getFloors().get(floori).getRooms();
      while (i < mapToSave.getFloors().get(floori).getNumRooms()) {
        save = save + rooms.get(i).getColour();
        save = save + " ";
        save = save + rooms.get(i).getx();
        save = save + " ";
        save = save + rooms.get(i).gety();
        save = save + " ";

        save = save + rooms.get(i).getSaveNorth();
        save = save + " ";
        save = save + rooms.get(i).getSaveEast();
        save = save + " ";
        save = save + rooms.get(i).getSaveSouth();
        save = save + " ";
        save = save + rooms.get(i).getSaveWest();
        if (roomcount != 47) {
          save = save + System.lineSeparator();// aye??? IT WORKS YAYAYAYAYAY
        }
        i++;
        roomcount++;
      }

      i = 0;
      floori++;
    }
    return save;

  }

}
