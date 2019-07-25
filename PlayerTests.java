package default_package;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import game_classes.Direction;
import game_classes.Player;
import items.Apple;
import items.Burger;
import items.Cookie;
import items.Fries;
import items.Hotdog;
import items.Item;
import items.Key;
import items.PondysShoes;
import items.Torch;
import items.Water;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Tests all players actions within the game.
 * 
 * @author haresgeor - 300411891
 *
 */
public class PlayerTests {

  /**
   * Checks players direction updates with the turnLeft method within Player.
   */
  @Test
  public void lookLeftTest() {
    Player p = new Player();
    p.setDirection(Direction.NORTH);
    p.turnLeft();
    assertEquals(p.getDirection(), Direction.WEST);
    p.turnLeft();
    assertEquals(p.getDirection(), Direction.SOUTH);
    p.turnLeft();
    assertEquals(p.getDirection(), Direction.EAST);
    p.turnLeft();
    assertEquals(p.getDirection(), Direction.NORTH);
  }

  /**
   * Checks players direction updates with the lookRight method within Player.
   */
  @Test
  public void lookRightTest() {
    Player p = new Player();
    p.setDirection(Direction.NORTH);
    p.turnRight();
    assertEquals(p.getDirection(), Direction.EAST);
    p.turnRight();
    assertEquals(p.getDirection(), Direction.SOUTH);
    p.turnRight();
    assertEquals(p.getDirection(), Direction.WEST);
    p.turnRight();
    assertEquals(p.getDirection(), Direction.NORTH);
  }

  /**
   * Checks players Distance, Hunger and Hydration ticks correctly.
   */
  @Test
  public void checkTicks() {
    Player p = new Player();
    p.tickDistance();
    p.tickHunger();
    p.tickHydration();

    assertEquals(p.getDistance(), 4);
    assertEquals(p.getHunger(), 9);
    assertEquals(p.getHydration(), 9);

    for (int i = 0; i < 15; i++) { // loops 15 times to check minimum.
      p.tickDistance();
      p.tickHunger();
      p.tickHydration();
    }
    assertEquals(p.getDistance(), 0);
    assertEquals(p.getHunger(), 0);
    assertEquals(p.getHydration(), 0);
  }

  /**
   * Checks players Distance, Hunger and Hydration regens correctly.
   */
  @Test
  public void checkRegen() {
    Player p = new Player();
    p.regenDistance();
    p.regenDistance();
    p.regenDistance();
    p.regenDistance();
    p.regenDistance();
    p.regenDistance(); // to check maximum.
    p.regenHunger(20);
    p.regenHydration(20);
    assertEquals(p.getDistance(), 5);
    assertEquals(p.getHunger(), 10);
    assertEquals(p.getHydration(), 10);
    p.tickDistance();
    p.tickHunger();
    p.tickHydration();
    p.tickDistance();
    p.tickHunger();
    p.tickHydration();
    p.regenHunger(1);
    p.regenHydration(1);
    p.regenDistance();
    assertEquals(p.getDistance(), 4);
    assertEquals(p.getHunger(), 9);
    assertEquals(p.getHydration(), 9);

  }

  /**
   * Checks players Inventory works correctly with pickUp and remove Item.
   */
  @Test
  public void pickupAndRemove() {
    Player p = new Player();
    p.pickUpItem(new Torch());
    p.pickUpItem(new PondysShoes());
    p.pickUpItem(new Key("blue"));
    p.pickUpItem(new Hotdog());
    p.pickUpItem(new Fries());
    p.pickUpItem(new Cookie());
    p.pickUpItem(new Apple());
    p.pickUpItem(new Burger());
    p.pickUpItem(new Water());

    List<Item> testList = new ArrayList<>();
    testList.add(new Torch());
    testList.add(new PondysShoes());
    testList.add(new Key("blue"));
    testList.add(new Hotdog());
    testList.add(new Fries());
    testList.add(new Cookie());
    testList.add(new Apple());
    testList.add(new Burger());
    testList.add(new Water());

    assertEquals(testList.toString(), p.getInventory().toString());

    testList = new ArrayList<>();
    p.removeItem(p.getInvItemFromName("Torch"));
    p.removeItem(p.getInvItemFromName("Pondy's Shoes"));
    p.removeItem(p.getInvItemFromName("blueKey"));
    p.removeItem(p.getInvItemFromName("Hotdog"));
    p.removeItem(p.getInvItemFromName("Fries"));
    p.removeItem(p.getInvItemFromName("Cookie"));
    p.removeItem(p.getInvItemFromName("Apple"));
    p.removeItem(p.getInvItemFromName("Burger"));
    p.removeItem(p.getInvItemFromName("WaterBottle"));

    assertEquals(testList.toString(), p.getInventory().toString());

    assertThrows(NullPointerException.class, () -> {
      p.removeItem(p.getInvItemFromName(null));
    });

    assertEquals(null, p.getInvItemFromName("Notanitemname"));
  }

  /**
   * Checks player can pickup and remove items.
   */
  @Test
  public void pickup() {
    Player p = new Player();
    p.pickUpItem(new Torch());
    List<Item> testList = new ArrayList<>();
    testList.add(new Torch());

    assertEquals(testList.toString(), p.getInventory().toString());
    testList.remove(0);
    p.removeItem(p.getInventory().remove(0));

    assertEquals(testList.toString(), p.getInventory().toString());
  }

  /**
   * Checks the players toString method is working correctly.
   */
  @Test
  public void checkToString() {
    Player p = new Player();
    p.setDirection(Direction.EAST);
    assertEquals(p.toString(), "Player [hunger=" + 10 + ", hydration=" + "" + 100 + ", distanceFromPondy=" + 5
        + ", inventory=" + "[]" + ", currentRoom=" + null + ", direction=" + Direction.EAST + "]");
  }
}
