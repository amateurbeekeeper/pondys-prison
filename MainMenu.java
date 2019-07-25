package game_classes;

import containers.Bin;
import containers.Chest;
import containers.Container;
import containers.Drawers;
import containers.Safe;

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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Loads the initial game from a map editor file (stored in plain text).
 * 
 * @author fearyelli - 300406946
 */
public class MainMenu {

  private File mapEditorFile;

  private PondysPrison game;

  /**
   * Sets up game loading from map file.
   * 
   * @param game
   *          instance sets up the file and loads the file
   */
  public MainMenu(PondysPrison game) {

    this.game = game;
    mapEditorFile = new File("resources/finalMap.txt"); // temp file
    loadGameMapEditor();
  }

  /**
   * loads game file using a scanner.
   */
  public void loadGameMapEditor() {

    try {
      Scanner sc = new Scanner(mapEditorFile);
      while (sc.hasNextLine()) {
        Room room = new Room();

        room.setColor(sc.next());

        int roomX = sc.nextInt();
        int roomY = sc.nextInt();

        if (roomX == 0 && roomY == 0) {
          Player player = new Player();
          player.setCurrentRoom(room);
          game.setPlayer(player);
        }

        room.setXCoord(roomX);
        room.setYCoord(roomY);

        for (int i = 0; i < 4; i++) {
          Wall wall = new Wall();
          sc.next();
          String next = sc.next();
          if (next.equals("Empty")) {
            // required
          } else if (next.equals("Door")) {
            sc.next();
            next = sc.next();
            wall.setDoor(getDoorFromString(next));
            sc.next();
          } else {
            sc.next();
            Container container = getContainerFromString(next);
            List<Item> itemList = new ArrayList<Item>();
            next = sc.next();
            while (!next.equals(")")) {
              if (next.contains("key")) {
                itemList.add(getKeyFromString(next));
                next = sc.next();
              } else {
                itemList.add(getItemFromString(next));
                next = sc.next();
              }
            }

            if (container != null) {
              container.setItems(itemList);
              wall.setContainer(container);
            }

          }

          next = sc.next();
          if (next.equals("Empty")) {
            // required
          } else if (next.equals("Puzzle")) {
            wall.setPuzzle(game.pollPuzzle());
          } else {
            wall.setDecoration1(getDecorationFromString(next));
          }

          next = sc.next();
          if (next.equals("Empty")) {
            // required
          } else if (next.equals("Puzzle")) {
            wall.setPuzzle(game.pollPuzzle());
          } else {
            wall.setDecoration2(getDecorationFromString(next));
          }

          sc.next();

          if (i == 0) {
            room.addWall(wall, Direction.NORTH);
          } else if (i == 1) {
            room.addWall(wall, Direction.EAST);
          } else if (i == 2) {
            room.addWall(wall, Direction.SOUTH);
          } else {
            room.addWall(wall, Direction.WEST);
          }

        }
        game.addRoom(room);
        // System.out.println(room.toString());
      }

      sc.close();
    } catch (

    FileNotFoundException e) {
      e.printStackTrace();
    }

    for (Room room : game.getRooms()) {
      for (Direction direction : Direction.values()) {
        Door door = room.getWalls().get(direction).getDoor();
        if (door != null) {
          door.setRooms(room, findRoom(room, direction, game));
        }
      }
    }
  }

  private static Room findRoom(Room room, Direction direction, PondysPrison game) {
    if (direction == Direction.NORTH) {
      for (Room adjRoom : game.getRooms()) {
        if (room.getYCoord() - 1 == adjRoom.getYCoord() && room.getXCoord() == adjRoom.getXCoord()) {
          return adjRoom;
        }
      }

    } else if (direction == Direction.EAST) {
      for (Room adjRoom : game.getRooms()) {
        if (room.getXCoord() + 1 == adjRoom.getXCoord() && room.getYCoord() == adjRoom.getYCoord()) {

          return adjRoom;
        }
      }
    } else if (direction == Direction.SOUTH) {
      for (Room adjRoom : game.getRooms()) {
        if (room.getYCoord() + 1 == adjRoom.getYCoord() && room.getXCoord() == adjRoom.getXCoord()) {
          return adjRoom;
        }
      }

    }

    for (Room adjRoom : game.getRooms()) {
      if (room.getXCoord() - 1 == adjRoom.getXCoord() && room.getYCoord() == adjRoom.getYCoord()) {
        return adjRoom;
      }
    }

    return null; // never reached
  }

  private static Door getDoorFromString(String door) {
    switch (door) {
    case "Blue":
      return new Door("blue", true);

    case "Gold":
      return new Door("gold", true);

    case "Green":
      return new Door("green", true);

    case "Orange":
      return new Door("orange", true);

    case "Red":
      return new Door("red", true);

    case "Unlocked":
      return new Door("grey", false);
    default:
      break;
    }

    return null; // never reached
  }

  private static Container getContainerFromString(String container) {
    switch (container) {
    case "Bin":
      return new Bin();

    case "Chest":
      return new Chest();

    case "Drawers":
      return new Drawers();

    case "Safe":
      return new Safe();
    default:
      break;
    }

    return null; // never reached
  }

  private static Item getItemFromString(String item) {
    switch (item) {
    case "Apple":
      return new Apple();

    case "Burger":
      return new Burger();

    case "Cookie":
      return new Cookie();

    case "Fries":
      return new Fries();

    case "Hotdog":
      return new Hotdog();

    case "PondysShoes":
      return new PondysShoes();

    case "Torch":
      return new Torch();

    case "Water":
      return new Water();
    case "Combination":

      return new Combination();
    default:
      break;
    }

    return null; // never reached
  }

  private static Key getKeyFromString(String key) {
    switch (key) {
    case "Bluekey":
      return new Key("blue");

    case "Goldkey":
      return new Key("gold");

    case "Greenkey":
      return new Key("green");

    case "Orangekey":
      return new Key("orange");

    case "Redkey":
      return new Key("red");
    default:
      break;
    }

    return null; // never reached
  }

  private static Decoration getDecorationFromString(String decoration) {
    switch (decoration) {
    case "Bookcase":
      return new Decoration("bookcase");

    case "Painting":
      return new Decoration("painting");

    case "Lamp":
      return new Decoration("lamp");
    default:
      break;
    }
    return null; // never reached
  }
}