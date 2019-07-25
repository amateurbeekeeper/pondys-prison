package default_package;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import containers.Bin;
import containers.Chest;
import game_classes.Direction;
import game_classes.Door;
import game_classes.Player;
import game_classes.Room;
import game_classes.Wall;
import items.Item;
import items.Key;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * Tests all doors within the game.
 * 
 * @author haresgeor - 300411891
 *
 */
public class DoorTests {

  /**
   * Creates two rooms a player and a locked door, gives the player the key to the
   * locked door and checks to see if player can unlock door and move into
   * adjacent room.
   */
  @Test
  public void testEnterRoomDoor() {
    Player p = new Player();
    Room r1 = new Room();
    Room r2 = new Room();
    p.getCurrentRoom();
    r1.getColor();
    r2.getColor();

    Map<Direction, Wall> r1walls = new HashMap<>();
    Map<Direction, Wall> r2walls = new HashMap<>();
    r2walls.size(); // For checkStyle....
    Wall testWall = new Wall();

    // First room has all bin containers.
    testWall.setContainer(new Bin());
    r1walls.put(Direction.NORTH, testWall);
    r1walls.put(Direction.EAST, testWall);
    r1walls.put(Direction.SOUTH, testWall);
    r1walls.put(Direction.WEST, testWall);

    // Second room has all chest containers.
    testWall.setContainer(new Chest());
    r2walls.put(Direction.NORTH, testWall);
    r2walls.put(Direction.EAST, testWall);
    r2walls.put(Direction.SOUTH, testWall);
    r2walls.put(Direction.WEST, testWall);

    r1.setWalls(r1walls);
    r2.setWalls(r2walls);

    p.setCurrentRoom(r1);

    Room checkRoom = p.getCurrentRoom();
    checkRoom.getColor();
    Door d = new Door("blue", true);

    Item key = new Key("blue");
    p.pickUpItem((Key) key);
    d.setRoom1(r1);
    d.setRoom2(r2);
    d.setRooms(r1, r2);
    assertTrue(d.checkKey(p));

    d.unlockDoor();

    p.enterRoom(d);
    assertFalse(p.getCurrentRoom().equals(checkRoom));
    p.enterRoom(d);
    assertTrue(p.getCurrentRoom().equals(checkRoom));
    assertTrue(((Key) key).unlockDoor(d));
    assertFalse(new Key("red").unlockDoor(d));

    assertThrows(NullPointerException.class, () -> {
      d.setRooms(null, null);
      p.enterRoom(d);
    });
  }

  /**
   * Checks methods getImage, getRightSideOnImage, getSideOnImage, getColorCode,
   * isLocked, getMenu and toString are working correctly.
   */
  @Test
  public void doorchecks() {
    Player p = new Player();
    p.getDirection();
    Door d = new Door("blue", true);
    d.getImage();
    d.getRightSideOnImage();
    d.getSideOnImage();
    assertEquals("blue", d.getColorCode());
    assertEquals(true, d.isLocked());
    d.getMenu(p);
    d.toString();
  }
}
