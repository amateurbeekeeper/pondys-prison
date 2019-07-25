package default_package;

import static org.junit.Assert.assertEquals;

import game_classes.Player;
import items.Apple;
import items.Burger;
import items.Combination;
import items.Cookie;
import items.Fries;
import items.Hotdog;
import items.Item;
import items.Key;
import items.PondysShoes;
import items.Torch;
import items.Water;
import javax.swing.ImageIcon;
import org.junit.jupiter.api.Test;

/**
 * Tests all Items within the game.
 * 
 * @author haresgeor - 300411891
 *
 */
public class ItemTests {

  /**
   * Ensures all items are initialised correctly and all methods are outputing the
   * correctly.
   */
  @Test
  public void checkAllItemDescriptions() {
    Item apple = new Apple();
    Item burger = new Burger();
    Item cookie = new Cookie();
    assertEquals("An apple, it will regenerate 1 level of hunger.", apple.getDescription());
    assertEquals("A burger, it will regenerate 3 levels of hunger.", burger.getDescription());
    assertEquals("A cookie, it will regenerate 1 level of hunger.", cookie.getDescription());
    Item fries = new Fries();
    Item hotdog = new Hotdog();
    assertEquals("Some fries, they will regenerate 2 levels of hunger.", fries.getDescription());
    assertEquals("A hotdog, it will regenerate 3 levels of hunger.", hotdog.getDescription());

    Item key = new Key("blue");
    Item pondysShoes = new PondysShoes();
    Item torch = new Torch();

    assertEquals("A colour coded Key.", key.getDescription());
    assertEquals(
        "Pondy's shoes can be used to scare Pondy away thereby " + "increasing the distance between you and him.",
        pondysShoes.getDescription());
    assertEquals("A flaming torch.", torch.getDescription());
    Item water = new Water();
    Item combination = new Combination();
    assertEquals("A bottle of water, it will regenerate 3 levels " + "of hydration.", water.getDescription());
    assertEquals("A combination for a safe.", combination.getDescription());
  }

  /**
   * Checks the method useItem within the Item classes to ensure they are working
   * correctly.
   */
  @Test
  public void checkAllItemUses() {
    Player p = new Player();
    p.getDirection();
    Item apple = new Apple();
    apple.getName();
    Item burger = new Burger();
    burger.getName();
    Item cookie = new Cookie();
    cookie.getName();
    Item fries = new Fries();
    fries.getName();
    Item hotdog = new Hotdog();
    hotdog.getName();
    Item key = new Key("blue");
    key.getName();
    Item pondysShoes = new PondysShoes();
    pondysShoes.getName();
    Item torch = new Torch();
    torch.getName();
    Item water = new Water();
    water.getName();
    Item combination = new Combination();
    combination.getName();
    apple.useItem(p);
    burger.useItem(p);
    cookie.useItem(p);
    fries.useItem(p);
    hotdog.useItem(p);
    pondysShoes.useItem(p);
    torch.useItem(p);
    assertEquals(true, ((items.Torch) torch).getOn());
    torch.useItem(p);
    assertEquals(false, ((items.Torch) torch).getOn());
    water.useItem(p);
    key.useItem(p);
    combination.useItem(p);
  }

  /**
   * Checks every items image and ensures it is setup correctly.
   */
  @Test
  public void checkAllItemImages() {
    Item apple = new Apple();
    apple.getName();
    Item burger = new Burger();
    burger.getName();
    Item cookie = new Cookie();
    cookie.getName();
    Item fries = new Fries();
    fries.getName();
    Item hotdog = new Hotdog();
    hotdog.getName();
    Item blueKey = new Key("blue");
    blueKey.getName();
    Item goldKey = new Key("gold");
    goldKey.getName();
    Item greenKey = new Key("green");
    greenKey.getName();
    Item orangeKey = new Key("orange");
    orangeKey.getName();
    Item redKey = new Key("red");
    redKey.getName();
    Item pondysShoes = new PondysShoes();
    pondysShoes.getName();
    Item torch = new Torch();
    torch.getName();
    Item water = new Water();
    water.getName();
    Item combination = new Combination();
    combination.getName();

    // Have to use toString().
    assertEquals(new ImageIcon("resources/apple.png").toString(), apple.getImage().toString());
    assertEquals(new ImageIcon("resources/burger.png").toString(), burger.getImage().toString());
    assertEquals(new ImageIcon("resources/cookie.png").toString(), cookie.getImage().toString());
    assertEquals(new ImageIcon("resources/fries.png").toString(), fries.getImage().toString());
    assertEquals(new ImageIcon("resources/hotdog.png").toString(), hotdog.getImage().toString());
    assertEquals(new ImageIcon("resources/blueKey.png").toString(), blueKey.getImage().toString());
    assertEquals(new ImageIcon("resources/goldKey.png").toString(), goldKey.getImage().toString());
    assertEquals(new ImageIcon("resources/greenKey.png").toString(), greenKey.getImage().toString());
    assertEquals(new ImageIcon("resources/orang" + "eKey.png").toString(), orangeKey.getImage().toString());
    assertEquals(new ImageIcon("resources/redKey.png").toString(), redKey.getImage().toString());
    assertEquals(new ImageIcon("resources/pondysShoes.png").toString(), pondysShoes.getImage().toString());
    assertEquals(new ImageIcon("resources/torch.png").toString(), torch.getImage().toString());
    assertEquals(new ImageIcon("resources/waterBottle.png").toString(), water.getImage().toString());
    assertEquals("blue", ((Key) blueKey).getColorCode());
    assertEquals(new ImageIcon("resources/combination.png").toString(), combination.getImage().toString());
  }

}
