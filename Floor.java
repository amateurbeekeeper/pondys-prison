package mapeditor;

import java.util.ArrayList;

/**
 * The Floor class holds rooms for maps and just a better way to organize stuff.
 * 
 * @author youngdani6 300418477
 *
 */
public class Floor {
  private ArrayList<Room> rooms = new ArrayList<Room>();

  /**
   * Creates a Floor.
   */
  public Floor() {

  }

  /**
   * Add a room.
   * 
   * @param roomToAdd
   *          the room to add
   */
  public void addARoom(Room roomToAdd) {
    rooms.add(roomToAdd);

  }

  /**
   * Get the number of rooms.
   * 
   * @return The number of rooms
   */
  public int getNumRooms() {
    return rooms.size();
  }

  /**
   * Get the rooms.
   * 
   * @return an array list of the rooms
   */
  public ArrayList<Room> getRooms() {
    return rooms;
  }
}
