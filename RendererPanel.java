package renderer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game_classes.Clickable;
import game_classes.Door;
import game_classes.Player;
import game_classes.PondysPrison;
import game_classes.Room;
import game_classes.Wall;

/* Need to implement:
 * Start and end of game
 * 
 */

/**
 * Class that extends JPanel for rendering the screen for the application
 * window. This is the main class for the renderer package.
 *
 * @author pritchsimo
 *
 */
public class RendererPanel extends JPanel {

  Player player;
  Room room;

  private HashMap<String, Color> wallpaper = new HashMap<>();
  private HashMap<String, List<BufferedImage>> paintingsForWallPaper = new HashMap<>();

  private List<String> imageStrings = Arrays.asList("painting1", "painting2", "painting3", "painting4", "painting5",
      "painting6", "painting7", "painting8", "painting9", "painting10", "painting11", "painting12", "northFloor",
      "eastFloor", "darkness", "danger1", "danger2", "danger3", "danger4", "danger0", "pondy", "white");
  private HashMap<String, BufferedImage> images = new HashMap<>();

  /**
   * Initializes all lists and hashmaps for BufferedImages and Colors. Generates
   * the images for the first room.
   * 
   * @param game
   *          PondysPrison that stores the current state of the game
   */
  public RendererPanel(PondysPrison game) {
    this.player = game.getPlayer();
    room = player.getCurrentRoom();

    // convert from save file String to Color
    wallpaper.put("Red", new Color(162, 49, 61));
    wallpaper.put("White", new Color(238, 233, 223));
    wallpaper.put("Blue", new Color(79, 201, 214));
    wallpaper.put("Purple", new Color(145, 125, 167));
    wallpaper.put("Orange", new Color(215, 115, 47));
    wallpaper.put("Grey", new Color(166, 175, 171));
    wallpaper.put("Green", new Color(60, 63, 25));

    try {
      for (String s : imageStrings) {
        images.put(s, ImageIO.read(new File("resources/" + s + ".png")));
      }
    } catch (IOException e) {
      System.out.println("RendererPanel ->" + e.getMessage());
    }

    // for paintings to not clash with wallpaperColor
    paintingsForWallPaper.put("Red",
        Arrays.asList(images.get("painting1"), images.get("painting2"), images.get("painting4"),
            images.get("painting5"), images.get("painting6"), images.get("painting7"), images.get("painting10"),
            images.get("painting11"), images.get("painting12")));
    paintingsForWallPaper.put("White", Arrays.asList(images.get("painting3"), images.get("painting5"),
        images.get("painting6"), images.get("painting8"), images.get("painting9")));
    paintingsForWallPaper.put("Blue",
        Arrays.asList(images.get("painting1"), images.get("painting4"), images.get("painting5"),
            images.get("painting6"), images.get("painting9"), images.get("painting10"), images.get("painting11"),
            images.get("painting12")));
    paintingsForWallPaper.put("Purple",
        Arrays.asList(images.get("painting1"), images.get("painting2"), images.get("painting3"),
            images.get("painting4"), images.get("painting6"), images.get("painting9"), images.get("painting10"),
            images.get("painting11"), images.get("painting12")));
    paintingsForWallPaper.put("Orange",
        Arrays.asList(images.get("painting1"), images.get("painting2"), images.get("painting4"),
            images.get("painting5"), images.get("painting6"), images.get("painting7"), images.get("painting8"),
            images.get("painting9"), images.get("painting10"), images.get("painting11"), images.get("painting12")));
    paintingsForWallPaper.put("Grey",
        Arrays.asList(images.get("painting1"), images.get("painting2"), images.get("painting4"),
            images.get("painting5"), images.get("painting6"), images.get("painting7"), images.get("painting8"),
            images.get("painting9"), images.get("painting10"), images.get("painting11"), images.get("painting12")));
    paintingsForWallPaper.put("Green", Arrays.asList(images.get("painting3"), images.get("painting5"),
        images.get("painting6"), images.get("painting8"), images.get("painting9")));

    // create first room
    parseRoom(room);
    createRoom(room);

  }

  /**
   * Paints the wallPaper, wall outline. Draws all of the objects on the room for
   * the current direction that the player is facing. Also paints overlay images
   * such as darkness or danger static.
   *
   * @param g
   *          Graphics used to draw on JPanel
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g.drawImage(images.get("white"), 0, 0, this);

    // sets wallPaper Color
    if (room != null) {
      if (room.getRoomRender() != null) {
        g2.setColor(wallpaper.get(room.getRoomRender().getWallpaperColor()));
      } else {
        System.out.println("RendererPanel -> room.roomRender is null");
      }
    } else {
      System.out.println("RendererPanel -> room is null");
    }
    g2.fillRect(0, 0, 1010, 700);

    // draws wall/floor outline
    g2.setStroke(new BasicStroke(4));
    g2.setColor(Color.BLACK);
    g2.drawLine(0, 680, 100, 580);
    g2.drawLine(100, 0, 100, 580);
    g2.drawLine(100, 578, 900, 578);
    g2.drawLine(900, 0, 900, 580);
    g2.drawLine(900, 580, 1010, 690);

    // draws all images for player.direction
    if (room != null) {
      if (room.getRoomRender() != null) {
        for (Image i : room.getRoomRender().getImages(player.getDirection())) {
          if (i.getCoords() == null) {
            System.out.println("RendererPanel -> Image has null coords");
          } else {
            g.drawImage(i.getImage(), i.getCoords().x, i.getCoords().y, this);
          }
        }
      }
    }

    // draws overlays such as darkness and static
    if (player != null) {
      if (player.getInvItemFromName("Torch") == null) {
        g.drawImage(images.get("darkness"), 0, 0, this);
      }
      if (player.getDistance() < 5) {
        if (player.getDistance() == 0) {
          g.drawImage(images.get("pondy"), 0, 0, this);
        }
        g.drawImage(images.get("danger" + player.getDistance()), 0, 0, this);
      }
    }
  }

  /**
   * Changes the room being rendered. Loads the room if the room has not been
   * loaded before.
   *
   * @param newRoom
   *          Room that the player is traveling to
   */
  public void moveRoom(Room newRoom) {
    // if room has not been rendered before
    if (newRoom.getRoomRender() == null) {
      parseRoom(newRoom);
      createRoom(newRoom);
    }

    room = newRoom;
    this.repaint();
  }

  /**
   * Creates a roomRender for the room, adding Images to the corresponding
   * directions.
   * 
   * @param room
   *          Room that the player is traveling to
   */
  private void parseRoom(Room room) {
    RoomRender roomRender = new RoomRender();

    roomRender.setWallpaperColor(room.getColor());

    // sets floor
    Image i1 = new Image(images.get("northFloor"), null, false);
    i1.setCoords(0, 580);
    roomRender.getNorthImages().add(i1);
    roomRender.getSouthImages().add(i1);
    Image i2 = new Image(images.get("eastFloor"), null, false);
    i2.setCoords(0, 580);
    roomRender.getEastImages().add(i2);
    roomRender.getWestImages().add(i2);

    // gets objects from walls of room
    for (game_classes.Direction d : game_classes.Direction.values()) {
      Wall wall = room.getWalls().get(d);

      // gets door/container
      if (wall.getContainer() != null) {
        roomRender.addImage(wall.getContainer().getImage(), wall.getContainer(), true, d);
      } else if (wall.getDoor() != null) {
        roomRender.addImage(wall.getDoor().getImage(), wall.getDoor(), true, d);
      }

      // gets first decoration
      if (wall.getDecoration1() != null) {
        if (wall.getDecoration1().getType().equals("bookcase") || wall.getDecoration1().getType().equals("lamp")) {
          roomRender.addImage(wall.getDecoration1().getImage(), null, true, d);
        } else {
          // gets random painting for wallPaper Color
          List<BufferedImage> p = paintingsForWallPaper.get(roomRender.getWallpaperColor());
          Collections.shuffle(p);
          roomRender.addImage(p.get(0), null, false, d);
        }
      }
      // gets second decoration
      if (wall.getDecoration2() != null) {
        if (wall.getDecoration2().getType().equals("bookcase") || wall.getDecoration2().getType().equals("lamp")) {
          roomRender.addImage(wall.getDecoration2().getImage(), null, true, d);
        } else {
          // gets random painting for wallPaper Color
          List<BufferedImage> p = paintingsForWallPaper.get(roomRender.getWallpaperColor());
          Collections.shuffle(p);
          roomRender.addImage(p.get(0), null, false, d);
        }
      }
      // gets puzzle
      if (wall.getPuzzle() != null) {
        roomRender.addImage(wall.getPuzzle().getImage(), wall.getPuzzle(), false, d);
      }
    }

    room.setRoomRender(roomRender);
  }

  /*
   * Rules for walls: Don't have bookcase or door on same wall as puzzle or
   * painting Don't have bookcase on same wall as drawer Don't have three things
   * on ground (all containers, bookcase, lamp)
   */

  /**
   * Gives coordinates to the images to be rendered at. Takes into account the
   * location of other objects.
   * 
   * @param room
   *          Room that needs its images to be placed
   */
  private void createRoom(Room room) {
    /*
     * calculate how many objects are on ground calculate how big they are put
     * objects on either left/right and calculate spacing calculate where to put
     * things hanging on wall
     *
     * calculate if there are objects on side walls
     */

    RoomRender roomRender = room.getRoomRender();
    if (roomRender == null) {
      System.out.println("RenderPanel.createRoom() -> roomRender has not been generated");
      return;
    }

    List<Image> currentDirection;
    // List<Image> leftWallDirection;
    // List<Image> rightWallDirection;

    for (game_classes.Direction d : game_classes.Direction.values()) {
      if (d == game_classes.Direction.NORTH) {
        currentDirection = roomRender.getNorthImages();
        // leftWallDirection = roomRender.getWestImages();
        // rightWallDirection = roomRender.getEastImages();
      } else if (d == game_classes.Direction.EAST) {
        currentDirection = roomRender.getEastImages();
        // leftWallDirection = roomRender.getNorthImages();
        // rightWallDirection = roomRender.getSouthImages();
      } else if (d == game_classes.Direction.SOUTH) {
        currentDirection = roomRender.getSouthImages();
        // leftWallDirection = roomRender.getEastImages();
        // rightWallDirection = roomRender.getWestImages();
      } else {
        currentDirection = roomRender.getWestImages();
        // leftWallDirection = roomRender.getSouthImages();
        // rightWallDirection = roomRender.getNorthImages();
      }

      List<Image> ground = new ArrayList<>();
      List<Image> hanging = new ArrayList<>();

      // start at 1 to exclude floor image
      // gets all objects that are on ground and objects that are hanging on the wall
      // gives coordinates to objects
      for (int i = 1; i < currentDirection.size(); i++) {
        Image image = currentDirection.get(i);
        if (image.isGround()) {
          ground.add(image);
        } else {
          hanging.add(image);
        }
      }

      int y = groundImages(ground);
      hangingImages(hanging, y);

      // TODO work out how to do side walls

      // need to fix image.getImage() reverting back to front on image

      // for (Image i : leftWallDirection) {
      // if (i.getCoords() != null) {
      // if (i.getObject() != null) {
      // if (i.getCoords().x - i.getObject().getSideOnImage().getWidth() < 200) {
      // roomRender.addImage(i.getObject().getSideOnImage(), i.getObject(), false, d);
      // roomRender.getImages(d).get(roomRender.getImages(d).size() - 1).setCoords(0,
      // 700 - i.getImage().getHeight());
      // }
      // }
      // }
      // }
      // for (Image i : rightWallDirection) {
      // if (i.getCoords() != null) {
      // if (i.getObject() != null) {
      // if (i.getCoords().x + i.getImage().getWidth() +
      // i.getObject().getRightSideOnImage().getWidth() > 800) {
      // roomRender.addImage(i.getObject().getRightSideOnImage(), i.getObject(),
      // false, d);
      // roomRender.getImages(d).get(roomRender.getImages(d).size() -
      // 1).setCoords(920,
      // 600 - i.getImage().getHeight());
      // }
      //
      // }
      // }
      // }
    }
  }

  /**
   * Calculates the coordinates of the objects on the ground.
   * 
   * @param ground
   *          List of Images of all the objects on the ground
   * @return Integer of height of tallest object
   */
  private int groundImages(List<Image> ground) {
    if (ground.size() == 0) {
      return 600;
    } else if (ground.size() == 1) {
      // put in center of room if only one ground object
      ground.get(0).setCoords(500 - (ground.get(0).getImage().getWidth() / 2), groundY(ground.get(0)));
      return 578 - (ground.get(0).getImage().getHeight());

    } else {
      // put objects side by side if there are two ground objects
      ground.get(0).setCoords(300 - ground.get(0).getImage().getWidth() / 2, groundY(ground.get(0)));
      ground.get(1).setCoords(700 - ground.get(1).getImage().getWidth() / 2, groundY(ground.get(1)));

      return Math.min(groundY(ground.get(0)), groundY(ground.get(1)));
    }
  }

  /**
   * Calculates the coordinates of the objects that are hanging on the wall.
   * 
   * @param hanging
   *          List of Images of all the objects that are hanging on the wall
   * @param y
   *          The height of the tallest object on the ground
   */
  private void hangingImages(List<Image> hanging, int y) {
    // hang in center of room if only one hanging object
    if (hanging.size() == 1) {
      hanging.get(0).setCoords(500 - (hanging.get(0).getImage().getWidth() / 2),
          (y / 2) - (hanging.get(0).getImage().getHeight() / 2));
      // hang objects side by side if there are two hanging objects
    } else if (hanging.size() == 2) {
      hanging.get(0).setCoords(300 - (hanging.get(0).getImage().getWidth() / 2),
          (y / 2) - (hanging.get(0).getImage().getHeight() / 2));
      hanging.get(1).setCoords(700 - (hanging.get(1).getImage().getWidth() / 2),
          (y / 2) - (hanging.get(1).getImage().getHeight() / 2));
    }
  }

  /**
   * Calculates the y coordinate for images for objects.
   * 
   * @param image
   *          Image that needs y coordinate
   * @return Y coordinate for image
   */
  private int groundY(Image image) {
    if (image.getObject() instanceof Door) {
      return 578 - (image.getImage().getHeight());
    }
    return 610 - (image.getImage().getHeight());
  }

  /**
   * Iterates over the Images for the current direction that the player is facing.
   * Returns the Clickable object if it has been clicked on by the mouse.
   *
   * @param point
   *          Mouse pressed coordinate
   * @param direction
   *          Direction that the player is facing
   * @return Clickable object to be interacted with
   */
  public Clickable onClick(Point point, game_classes.Direction direction) {
    if (direction == game_classes.Direction.NORTH) {
      for (Image i : room.getRoomRender().getNorthImages()) {
        if (i.isWithin(point)) {
          return i.getObject();
        }
      }
    } else if (direction == game_classes.Direction.EAST) {
      for (Image i : room.getRoomRender().getEastImages()) {
        if (i.isWithin(point)) {
          return i.getObject();
        }
      }
    } else if (direction == game_classes.Direction.SOUTH) {
      for (Image i : room.getRoomRender().getSouthImages()) {
        if (i.isWithin(point)) {
          return i.getObject();
        }
      }
    } else if (direction == game_classes.Direction.WEST) {
      for (Image i : room.getRoomRender().getWestImages()) {
        if (i.isWithin(point)) {
          return i.getObject();
        }
      }
    }

    return null;
  }
}
