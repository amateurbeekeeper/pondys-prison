package mapeditor;

import java.util.ArrayList;

/**
 * This class is the way we store our map that consists of floors.
 * 
 * @author youngdani6 300418477
 *
 */
public class Map {

  private ArrayList<Floor> floors = new ArrayList<Floor>();

  /**
   * Make a new empty map.
   */
  public Map() {

  }

  /**
   * Add a floor to a map.
   * 
   * @param floorToAdd
   *          the floor to add
   */
  public void addAFloor(Floor floorToAdd) {
    floors.add(floorToAdd);

  }

  /**
   * Get Number of floors.
   * 
   * @return Number of floors
   */
  public int getNumFloors() {
    return floors.size();
  }

  /**
   * Get an array list of the floors.
   * 
   * @return An array list of the floors
   */
  public ArrayList<Floor> getFloors() {
    return floors;
  }

  // public String toString() {
  // String out = "";
  // //for(this.Rooms)
  // }
}
