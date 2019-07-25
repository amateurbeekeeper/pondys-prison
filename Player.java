package game_classes;

import java.util.ArrayList;
import java.util.List;

import items.Item;

/**
 * Player class, holds all information about the player including thier hunger
 * and hydration stats and their distance from pondy. Also holds the direction
 * they are facing, the room they are in and their inventory.
 * 
 * @author fearyelli - 300406946
 */
public class Player {

  private int hunger = 10;
  private int hydration = 10;
  private int distanceFromPondy = 5;
  private List<Item> inventory = new ArrayList<>();
  private Room currentRoom;
  private Direction direction = Direction.NORTH;

  /**
   * @return players inventory
   */
  public List<Item> getInventory() {
    return inventory;
  }

  /**
   * @param door
   *          to enter
   * @return the new room the player has entered after going through the door
   *         allows the player to enter the room
   */
  public Room enterRoom(Door door) {
    if (door.getRoom1() != null || door.getRoom2() != null) {
      currentRoom = door.getOtherRoom(currentRoom);
      tickHunger();
      tickHydration();
      System.out.println(direction);
      return currentRoom;
    } else {
      throw new NullPointerException();
    }
  }

  /**
   * @return current room player is in
   */
  public Room getCurrentRoom() {
    return this.currentRoom;
  }

  /**
   * @param currentRoom
   *          current room player should be in
   */
  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  /**
   * turns the player left, depending on their current facing direction
   */
  public void turnLeft() {
    if (direction == Direction.NORTH)
      direction = Direction.WEST;
    else if (direction == Direction.EAST)
      direction = Direction.NORTH;
    else if (direction == Direction.SOUTH)
      direction = Direction.EAST;
    else if (direction == Direction.WEST)
      direction = Direction.SOUTH;
  }

  /**
   * turns the player right, depending on their current facing direction
   */
  public void turnRight() {
    if (direction == Direction.NORTH)
      direction = Direction.EAST;
    else if (direction == Direction.EAST)
      direction = Direction.SOUTH;
    else if (direction == Direction.SOUTH)
      direction = Direction.WEST;
    else if (direction == Direction.WEST)
      direction = Direction.NORTH;
  }

  /**
   * @return direction player is facing
   */
  public Direction getDirection() {
    return this.direction;
  }

  /**
   * @param direction
   *          changed players facing direction
   */
  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  /**
   * @param s
   *          name of item to get
   * @return returns item recieved from the name;
   */
  public Item getInvItemFromName(String s) {
    if (s == null)
      throw new NullPointerException();
    for (Item i : this.getInventory()) {
      if (i.getName().equals(s))
        return i;
    }
    return null;
  }

  /**
   * @param item
   *          to be picked up by player adds an item to the players inventory
   */
  public void pickUpItem(Item item) {
    System.out.println("Added " + item.toString() + " to inventory");
    inventory.add(item);
  }

  /**
   * @param item
   *          to be removed by player removes an item from the players inventory
   */
  public void removeItem(Item item) {
    inventory.remove(item);
  }

  /**
   * removes a level of hunger from the player
   */
  public void tickHunger() {
    if (hunger - 1 <= 0) {
      hunger = 0;
      playerDeath("You have died of starvation!");
    } else {
      hunger -= 1;
    }
    System.out.println(hunger + "d");

  }

  /**
   * @param regenAmount
   *          the amount to regenerate adds an amount of hunger to the player
   */
  public void regenHunger(int regenAmount) {
    if (hunger + regenAmount > 10) {
      hunger = 10;
    } else {
      hunger += regenAmount;
    }
  }

  /**
   * removes a level of hydration from the player
   */
  public void tickHydration() {
    if (hydration - 1 <= 0) {
      hydration = 0;
      playerDeath("You have died of dehydration!");
    } else {
      hydration -= 1;
    }
  }

  /**
   * @param regenAmount
   *          the amount to regenerate adds an amount of hydration to the player
   */
  public void regenHydration(int regenAmount) {
    if (hydration + regenAmount > 10) {
      hydration = 10;
    } else {
      hydration += regenAmount;
    }
  }

  /**
   * removes a distance level from pondy
   */
  public void tickDistance() {
    if (distanceFromPondy - 1 <= 0) {
      distanceFromPondy = 0;
      playerDeath("Pondy has caught you! You have failed...");
    } else {
      distanceFromPondy -= 4;
    }
  }

  /**
   * adds a distance level from pondy
   */
  public void regenDistance() {
    distanceFromPondy++;
    if (distanceFromPondy > 5) {
      distanceFromPondy = 5;
    }
  }

  /**
   * @return distance from pondy
   */
  public int getDistance() {
    return this.distanceFromPondy;
  }

  /**
   * @return current hunger level
   */
  public int getHunger() {
    return this.hunger;
  }

  /**
   * @return current hydration level
   */
  public int getHydration() {
    return this.hydration;
  }

  /**
   * @param deathMessage
   *          message to show player when they die ends the players game with a
   *          message as to why they have lost
   */
  public void playerDeath(String deathMessage) {

  }

  @Override
  public String toString() {
    return "Player [hunger=" + hunger + ", hydration=" + hydration + ", distanceFromPondy=" + distanceFromPondy
        + ", inventory=" + inventory + ", currentRoom=" + currentRoom + ", direction=" + direction + "]";
  }

}
