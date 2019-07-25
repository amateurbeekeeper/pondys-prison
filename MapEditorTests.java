package default_package;

import static org.junit.Assert.assertEquals;

import mapeditor.Gui;
import mapeditor.Map;

import mapeditor.Saver;
import org.junit.Test;

/**
 * Tests for the map editor.
 * 
 * @author youngdani6 300418477
 *
 */
public class MapEditorTests {

  /**
   * Test load function.
   */
  @Test
  public void testsloader() {
    Map map = new Map();
    map = mapeditor.Loader.load("White 0 0 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 1 0 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]"
        + " [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 2 0 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 3 0 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 0 1 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]"
        + " [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 1 1 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 2 1 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 3 1 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 0 2 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]"
        + " [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 1 2 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 2 2 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 3 2 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 0 3 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 1 3 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 2 3 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 3 3 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]"
        + " [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 0 4 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 1 4 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 2 4 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "White 3 4 [ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ] "
        + "[ Empty Lamp Puzzle ] [ Empty Lamp Puzzle ]\r\n" + "");
    assertEquals(16, map.getFloors().get(0).getNumRooms());
    assertEquals(2, map.getFloors().size());

  }

  /**
   * Tests the save function.
   */
  @Test
  public void testsSaver() {
    Map map = new Map();
    map = mapeditor.Loader.load("White 0 0 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 0 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 0 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 0 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 1 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 1 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 1 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 1 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 2 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 2 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 2 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 2 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 3 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 3 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 3 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 3 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 4 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 4 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 4 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 4 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 5 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 5 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 5 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 5 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 6 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 6 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 6 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 6 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 7 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 7 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 7 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 7 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 8 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 8 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 8 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 8 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 9 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 9 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 9 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 9 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 10 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 10 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 10 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 10 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 11 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 11 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 11 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 11 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "");
    String save = "";
    save = Saver.makeSave(map);

    assertEquals(save, "White 0 0 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 0 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 0 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + "" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 3 0 [ Empty Empty Empty ] [ Empty Empty Empty ]" + ""
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 1 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + "" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 1 1 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 2 1 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 3 1 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 0 2 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 1 2 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 2 2 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 3 2 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 0 3 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 1 3 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 2 3 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 3 3 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 0 4 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 1 4 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 2 4 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 3 4 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 0 5 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 1 5 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 2 5 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 3 5 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 0 6 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 1 6 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 2 6 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 3 6 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 0 7 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 1 7 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 2 7 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 3 7 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 0 8 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 1 8 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 2 8 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 3 8 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 0 9 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 1 9 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 2 9 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 3 9 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 0 10 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 1 10 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 2 10 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 3 10 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 0 11 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 1 11 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 2 11 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
        + "White 3 11 [ Empty Empty Empty ] [ Empty Empty Empty ]" + " [ Empty Empty Empty ] [ Empty Empty Empty ]");
  }

  /**
   * Test the draw panel.
   */
  @Test
  public void testDrawPanel() {
    Map map = new Map();
    map = mapeditor.Loader.load("White 0 0 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 0 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 0 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 0 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 1 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 1 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 1 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 1 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 2 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 2 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 2 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 2 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 3 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 3 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 3 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 3 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 4 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 4 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 4 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 4 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 5 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 5 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 5 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 5 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 6 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 6 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 6 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 6 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 7 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 7 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 7 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 7 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 8 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 8 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 8 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 8 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 9 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 9 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 9 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 9 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 10 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 10 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 10 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 10 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 0 11 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 11 [ Empty Empty Empty ] [ Empty Empty Empty ]"
        + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 2 11 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 3 11 [ Empty Empty Empty ] [ Empty Empty Empty ] "
        + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "");

    Gui.setSelectedView(0);

    mapeditor.Gui.display(map);
    mapeditor.Gui.upAFloorToVeiw();
    Gui.setSelectedView(1);
    mapeditor.Gui.display(map);
    mapeditor.Gui.upAFloorToVeiw();
    Gui.setSelectedView(2);
    mapeditor.Gui.display(map);

    assertEquals(1, 1);// test it doesnt crash and looks normal
  }

  /**
   * Testing Draw panel by calling it another way.
   */
  @Test
  public void testDrawPanelanotherway() {
    Map map = new Map();
    map = mapeditor.Loader.load("White 0 0 [ Chest ( Apple Hotdog ) Painting Empty ] [ Sa"
        + "fe ( PondysShoes ) Empty Empty ] [ Door ( Blue ) Empty Em" + "pty ] [ Empty Bookcase Puzzle ]\r\n"
        + "White 1 0 [ Chest ( Hotdog ) Painting Empty ] [ Che"
        + "st ( Hotdog ) Painting Decoration ] [ Empty Bookcase " + "Puzzle ] [ Empty Bookcase Puzzle ]\r\n"
        + "White 0 1 [ Door ( Blue ) Empty Empty ] [ Door ( R"
        + "ed ) Empty Empty ] [ Safe ( PondysShoes ) Empty Empty ] [ C" + "hest ( Apple Cookie ) Painting Empty ]\r\n"
        + "White 1 1 [ Bin ( Burger ) Painting Empty ] [ Saf" + "e ( PondysShoes ) Empty Empty ] [ Empty Bookcas"
        + "e Puzzle ] [ Door ( Red ) Empty Empty ]\r\n" + "");
    mapeditor.Controler.drawit(map);

    assertEquals(1, 1);// test it dosnt crash also testable by if it looks right
  }

  /**
   * Test adding a item.
   */
  @Test
  public void testAddingAitem() {
    Map map = new Map();
    map = mapeditor.Loader
        .load("White 0 0 [ Chest ( ) Painting Empty ] [ S" + "afe ( PondysShoes ) Empty Empty ] [ Door ( Blue ) Emp"
            + "ty Empty ] [ Empty Bookcase Puzzle ]\r\n" + "White 1 0 [ Chest ( Hotdog ) Painting Empty "
            + "] [ Chest ( Hotdog ) Painting Decoration ] [ Empty Bo" + "okcase Puzzle ] [ Empty Bookcase Puzzle ]\r\n"
            + "White 0 1 [ Door ( Blue ) Empty Empty ] [ Do" + "or ( Red ) Empty Empty ] [ Safe ( PondysShoes ) Emp"
            + "ty Empty ] [ Chest ( Apple Cookie ) Painting Empty ]\r\n"
            + "White 1 1 [ Bin ( Burger ) Painting Empty ] [ Sa"
            + "fe ( PondysShoes ) Empty Empty ] [ Empty Bookcase Puz" + "zle ] [ Door ( Red ) Empty Empty ]\r\n" + "");
    map.getFloors().get(0).getRooms().get(0).setNorth("Hotdog");
    assertEquals("Ho", map.getFloors().get(0).getRooms().get(0).getnorthWall().getItemDe());

  }

  /**
   * Test For Removing a item.
   */
  @Test
  public void testRemovingAitem() {
    Map map = new Map();
    map = mapeditor.Loader.load("White 0 0 [ Chest ( Apple ) Painting Empty ] [ Safe ( PondysSho"
        + "es ) Empty Empty ] [ Door ( Blue ) Empty Empty ] [ Empty Bookcase Puzzle ]\r\n"
        + "White 1 0 [ Chest ( Hotdog ) Painting Empty ] [ Chest ( Ho"
        + "tdog ) Painting Decoration ] [ Empty Bookcase Puzzle ] [ Empty Bookcase Puzzle ]\r\n"
        + "White 0 1 [ Door ( Blue ) Empty Empty ] [ Door ( Red ) Empt"
        + "y Empty ] [ Safe ( PondysShoes ) Empty Empty ] " + "[ Chest ( Apple Cookie ) Painting Empty ]\r\n"
        + "White 1 1 [ Bin ( Burger ) Painting Empty ] [ Safe ( Pondys"
        + "Shoes ) Empty Empty ] [ Empty Bookcase Puzzle ] [ Door ( Red ) Empty Empty ]\r\n" + "");
    map.getFloors().get(0).getRooms().get(0).getnorthWall().removeItem("Apple");
    assertEquals("Empty", map.getFloors().get(0).getRooms().get(0).getnorthWall().getItemDe());

  }

  /**
   * Test Adding a Door.
   */
  @Test
  public void testAddingADoor() {
    Map map = new Map();
    map = mapeditor.Loader.load("White 0 0 [ Chest ( Apple ) Painting Empty ] [ Safe ( PondysShoes ) Empty Empt"
        + "y ] [ Door ( Blue ) Empty Empty ] [ Empty Bookcase Puzzle ]\r\n"
        + "White 1 0 [ Chest ( Hotdog ) Painting Empty ] [ Chest ( Hotdog ) Pain"
        + "ting Decoration ] [ Empty Bookcase Puzzle ] [ Empty Bookcase Puzzle ]\r\n"
        + "White 0 1 [ Door ( Blue ) Empty Empty ] [ Door ( Red ) Empty Empty ] ["
        + " Safe ( PondysShoes ) Empty Empty ] [ Chest ( Apple Cookie ) Painting Empty ]\r\n"
        + "White 1 1 [ Bin ( Burger ) Painting Empty ] [ Safe ( PondysShoes ) E"
        + "mpty Empty ] [ Empty Bookcase Puzzle ] [ Door ( Red ) Empty Empty ]\r\n" + "");
    map.getFloors().get(0).getRooms().get(0).setNorthDoor("Red");
    assertEquals("Door", map.getFloors().get(0).getRooms().get(0).getnorthWall().getContianer());
    assertEquals("Re", map.getFloors().get(0).getRooms().get(0).getnorthWall().getItemDe());

  }

  /**
   * Test find length.
   */
  @Test
  public void testFindLength() {
    Map map = new Map();
    map = mapeditor.Loader.load("White 0 0 [ Chest ( Apple ) Painting Empty ] [ Safe ( Pond"
        + "ysShoes ) Empty Empty ] [ Door ( Blue ) Empty Empty ] [ Empty Bookcase Puzzle ]\r\n"
        + "White 1 0 [ Chest ( Hotdog ) Painting Empty ] [ Chest ( Hotdog ) P"
        + "ainting Decoration ] [ Empty Bookcase Puzzle ] [ Empty Bookcase Puzzle ]\r\n"
        + "White 0 1 [ Door ( Blue ) Empty Empty ] [ Door ( Red ) Empty Emp"
        + "ty ] [ Safe ( PondysShoes ) Empty Empty ] [ Chest ( Apple Cookie ) Pain" + "ting Empty ]\r\n"
        + "White 1 1 [ Bin ( Burger ) Painting Empty ] [ Safe ( PondysShoes ) Empty Em"
        + "pty ] [ Empty Bookcase Puzzle ] [ Door ( Red ) Empty Empty ]\r\n" + "");

    assertEquals(1, Gui.findLength(map)); // length starts at 0;

  }

  /**
   * Test Room functions.
   */
  @Test
  public void testRoom() {
    Map map = new Map();
    map = mapeditor.Loader.load("White 0 0 [ Chest ( Apple ) Empty Empty ] [ Safe ( ) Empty Empty"
        + " ] [ Chest ( ) Empty Empty ] [ Chest ( ) Empty Empty ]\r\n"
        + "White 1 0 [ Chest ( Hotdog ) Painting Empty ] [ Chest ( Hotdog ) Pa"
        + "inting Decoration ] [ Empty Bookcase Puzzle ] [ Empty Bookcase Puzzle ]\r\n"
        + "White 0 1 [ Door ( Blue ) Empty Empty ] [ Door ( Red ) Empty E"
        + "mpty ] [ Door ( Red ) Empty Empty ] [ Door ( Red ) Painting Empty ]\r\n"
        + "White 1 1 [ Bin ( Burger ) Painting Empty ] [ Safe ( Pond"
        + "ysShoes ) Empty Empty ] [ Empty Bookcase Puzzle ] [ Door ( Red ) Empty Empty ]\r\n" + "");
    map.getFloors().get(0).getRooms().get(0).seteastWall(map.getFloors().get(0).getRooms().get(0).getwestWall());
    assertEquals(map.getFloors().get(0).getRooms().get(0).getwestWall(),
        map.getFloors().get(0).getRooms().get(0).geteastWall()); // length starts at 0;

    map.getFloors().get(0).getRooms().get(0).setwestWall(map.getFloors().get(0).getRooms().get(0).getnorthWall());
    assertEquals(map.getFloors().get(0).getRooms().get(0).getwestWall(),
        map.getFloors().get(0).getRooms().get(0).getnorthWall());

    map.getFloors().get(0).getRooms().get(0).setColour("Red");
    assertEquals("Red", map.getFloors().get(0).getRooms().get(0).getColour());

    map.getFloors().get(0).getRooms().get(0).setEast("Apple");
    map.getFloors().get(0).getRooms().get(0).setSouth("Apple");
    map.getFloors().get(0).getRooms().get(0).setWest("Apple");

    assertEquals("Apple", map.getFloors().get(0).getRooms().get(0).getEast());
    assertEquals("Apple", map.getFloors().get(0).getRooms().get(0).getWest());
    assertEquals("Apple", map.getFloors().get(0).getRooms().get(0).getSouth());

    map.getFloors().get(0).getRooms().get(2).setNorthContainer("Bin");
    map.getFloors().get(0).getRooms().get(2).seteastContainer("Bin");
    map.getFloors().get(0).getRooms().get(2).setsouthContainer("Bin");
    map.getFloors().get(0).getRooms().get(2).setWestContainer("Bin");

    assertEquals("Bin", map.getFloors().get(0).getRooms().get(2).getNorthContainer());
    assertEquals("Bin", map.getFloors().get(0).getRooms().get(2).getSouthContainer());
    assertEquals("Bin", map.getFloors().get(0).getRooms().get(2).getEastContainer());
    assertEquals("Bin", map.getFloors().get(0).getRooms().get(2).getWestContainer());

    map.getFloors().get(0).getRooms().get(0).setNorthDec("Puzzle");
    map.getFloors().get(0).getRooms().get(0).setEastDec("Puzzle");
    map.getFloors().get(0).getRooms().get(0).setSouthDec("Puzzle");
    map.getFloors().get(0).getRooms().get(0).setWestDec("Puzzle");

    assertEquals("Pu&Pu", map.getFloors().get(0).getRooms().get(0).getnorthWall().getDecDe());
    assertEquals("Pu&Em", map.getFloors().get(0).getRooms().get(0).geteastWall().getDecDe());
    assertEquals("Pu&Em", map.getFloors().get(0).getRooms().get(0).getsouthWall().getDecDe());
    assertEquals("Pu&Pu", map.getFloors().get(0).getRooms().get(0).getwestWall().getDecDe());
  }

}
