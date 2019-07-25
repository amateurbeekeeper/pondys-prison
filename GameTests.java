package default_package;

import static org.junit.Assert.assertEquals;

import application_window.ApplicationWindow;

import containers.Chest;
import containers.Container;
import game_classes.Decoration;
import game_classes.Door;
import game_classes.PondysPrison;
import game_classes.Puzzle;
import game_classes.Wall;
import org.junit.jupiter.api.Test;

/**
 * Tests components within the game.
 * 
 * @author haresgeor - 300411891
 * 
 * 
 *
 */
public class GameTests {
  /**
   * Checks to see if wall is working correctly, (Holds Containers, Decorations
   * Puzzles and Doors correctly).
   */
  @Test
  public void pondysPrisonTest() {
    PondysPrison gameTest = new PondysPrison();
    Wall testWall = new Wall();
    Container c = new Chest();
    Decoration d1 = new Decoration("bookcase");
    Decoration d2 = new Decoration("bookcase");
    Puzzle p = gameTest.pollPuzzle();
    Door d = new Door("blue", false);

    testWall.setContainer(c);
    testWall.setDecoration1(d1);
    testWall.setDecoration2(d2);
    testWall.setPuzzle(p);
    testWall.setDoor(d);

    assertEquals("Wall [container=" + new Chest() + ", " + "decoration1=" + d1 + ", decoration2=" + d2 + ", "
        + "puzzle=" + p + ", door=" + d + "]", testWall.toString());

    assertEquals(d1, testWall.getDecoration1());
    assertEquals(d2, testWall.getDecoration2());
    assertEquals(c, testWall.getContainer());
    assertEquals(d, testWall.getDoor());
    assertEquals(p, testWall.getPuzzle());

  }

  /**
   * Checks puzzles are returned from pollPuzzle and do not run out.
   */
  @Test
  public void puzzleTest() {
    PondysPrison gametest = new PondysPrison();
    for (int i = 0; i < 50; i++) {
      gametest.pollPuzzle();
    }

  }

  /**
   * Checks methods toString, getImage, setImage and getType within the Decoration
   * class.
   */
  @Test
  public void decorationTest() {
    Decoration d = new Decoration("bookcase");
    d.toString();
    d.getImage();
    d.setImage(d.getImage());
    assertEquals("bookcase", d.getType());
  }

  /**
   * Checks for errors within ApplicationWindow.
   */
  @Test
  public void applicationWindowTests() {
    ApplicationWindow appWin = new ApplicationWindow();
    appWin.updateInventory();
    PondysPrison gametest = new PondysPrison();

  }
}
