package default_package;

import static org.junit.Assert.assertEquals;

import containers.Bin;
import containers.Chest;
import containers.Container;
import containers.Drawers;
import containers.Safe;
import game_classes.Player;
import items.Item;
import items.Torch;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Testing for every implimentation of container.
 * 
 * @author haresgeor - 300411891
 *
 */
public class ContainerTests {

  /**
   * Checks setItems, getMenu, getImage and getSideOnImage methods then opens the
   * bin and repeats method checks to ensure Bin is working correctly. Also checks
   * takItem, placeItem and toString methods.
   */
  @Test
  public void binTests() {
    Player p = new Player();
    List<Item> testList = new ArrayList<>();
    Container bin = new Bin();
    Torch torch = new Torch();
    testList.add(torch);
    bin.setItems(testList);
    bin.getMenu(p);
    bin.getImage();
    bin.getSideOnImage();
    bin.getRightSideOnImage();
    bin.open();
    bin.getImage();
    bin.getSideOnImage();
    bin.getRightSideOnImage();
    bin.getMenu(p);
    bin.close();
    bin.takeItem(torch);
    testList.remove(torch);
    assertEquals(testList.toString(), bin.getItems().toString());
    bin.placeItem(torch);
    testList.add(torch);
    assertEquals(testList.toString(), bin.getItems().toString());
    assertEquals("Bin [isOpen=" + false + ", items=" + testList + "]", bin.toString());
  }

  /**
   * Checks setItems, getMenu, getImage and getSideOnImage methods then opens the
   * chest and repeats method checks to ensure chest is working correctly. Also
   * checks takItem, placeItem and toString methods.
   */
  @Test
  public void chestTests() {
    Player p = new Player();
    List<Item> testList = new ArrayList<>();
    Container chest = new Chest();
    Torch torch = new Torch();
    testList.add(torch);
    chest.setItems(testList);
    chest.getMenu(p);
    chest.getImage();
    chest.getSideOnImage();
    chest.getRightSideOnImage();
    chest.open();
    chest.getImage();
    chest.getSideOnImage();
    chest.getRightSideOnImage();
    chest.getMenu(p);
    chest.close();
    chest.takeItem(torch);
    testList.remove(torch);
    assertEquals(testList.toString(), chest.getItems().toString());
    chest.placeItem(torch);
    testList.add(torch);
    assertEquals(testList.toString(), chest.getItems().toString());
    assertEquals("Chest [isOpen=" + false + ", items=" + testList + "]", chest.toString());
  }

  /**
   * Checks setItems, getMenu, getImage and getSideOnImage methods then opens the
   * safe and repeats method checks to ensure the safe is working correctly. Also
   * checks takItem and placeItem methods.
   */
  @Test
  public void safeTests() {
    Player p = new Player();
    List<Item> testList = new ArrayList<>();
    Container safe = new Safe();
    Torch torch = new Torch();
    testList.add(torch);
    safe.setItems(testList);
    safe.getMenu(p);
    safe.getImage();
    safe.getSideOnImage();
    safe.getRightSideOnImage();
    safe.open();
    safe.getImage();
    safe.getSideOnImage();
    safe.getRightSideOnImage();
    safe.getMenu(p);
    safe.close();
    safe.takeItem(torch);
    testList.remove(torch);
    assertEquals(testList.toString(), safe.getItems().toString());
    safe.placeItem(torch);
    testList.add(torch);
    assertEquals(testList.toString(), safe.getItems().toString());
  }

  /**
   * Checks setItems, getMenu, getImage and getSideOnImage methods then opens the
   * drawer and repeats method checks to ensure they are working correctly. Also
   * checks takItem, placeItem and toString methods.
   */
  @Test
  public void drawerTests() {
    Player p = new Player();
    List<Item> testList = new ArrayList<>();
    Container drawer = new Drawers();
    Torch torch = new Torch();
    testList.add(torch);
    drawer.setItems(testList);
    drawer.getMenu(p);
    drawer.getImage();
    drawer.getSideOnImage();
    drawer.getRightSideOnImage();
    drawer.open();
    drawer.getImage();
    drawer.getSideOnImage();
    drawer.getRightSideOnImage();
    drawer.getMenu(p);
    drawer.close();
    drawer.takeItem(torch);
    testList.remove(torch);
    assertEquals(testList.toString(), drawer.getItems().toString());
    drawer.placeItem(torch);
    testList.add(torch);
    assertEquals(testList.toString(), drawer.getItems().toString());
    assertEquals("Drawers [isOpen=" + false + ", items=" + testList + "]", drawer.toString());
  }
}
