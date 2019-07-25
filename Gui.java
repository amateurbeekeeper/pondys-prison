package mapeditor;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mapeditor.Map;

// coment
/**
 * This Class initialize and controls the GUI.
 * 
 * @author youngdani6 300418477
 *
 */
@SuppressWarnings("serial")

public class Gui extends JFrame {

  static Map map = new Map();
  JPanel container = new JPanel();
  JPanel pbase = new JPanel();
  JPanel p1 = new JPanel();
  static JMenuBar m = new JMenuBar();

  static JMenu file = new JMenu("File");
  static JMenu help = new JMenu("Help");// Top level menu options

  static JMenuItem EG = new JMenuItem("Exit");
  static JMenuItem NM = new JMenuItem("New Map");
  static JMenuItem IM = new JMenuItem("Import Map");
  static JMenuItem EM = new JMenuItem("Export Map");
  static JMenuItem H = new JMenuItem("Help");
  static JMenuItem B = new JMenuItem("Report a Bug");// options in sub menus
  static JMenuItem ICM = new JMenuItem("Import default map");
  static JMenuItem SCM = new JMenuItem("Save To Game Folder");

  JButton bcontainer = new JButton("Add A Container");
  JButton badditem = new JButton("Add Item");
  JButton b2 = new JButton("Remove Item");
  JButton bleft = new JButton("Move Left");
  JButton bright = new JButton("Move Right");
  JButton bup = new JButton("Move Up a floor");
  JButton bdown = new JButton("Move Down a floor");
  JButton bupmove = new JButton("Move Down");
  JButton bdownmove = new JButton("Move Up"); // these are inverted in name ONLY
  JButton bchangeveiw = new JButton("Change Veiw");
  JButton bdooradd = new JButton("Add A Door");
  JButton badddec = new JButton("Add A Decoration");

  static int selectedRoom = 0;
  static int selectedRoomy = 0;
  static int selectedFloor = 0;
  static int selectedView = 0; // 0 = containers, 1 = items

  static String[] directions = { "North", "South", "East", "West" };

  static String[] items = { "Apple", "Burger", "Cookie", "Fries", "Hotdog", "PondysShoes", "Torch", "Combination",
      "Water", "Redkey", "Bluekey", "Orangekey", "Goldkey", "Greenkey" };
  static String[] Containers = { "Bin", "Chest", "Drawers", "Safe" };
  static String[] colours = { "Red", "Green", "Orange", "Gold", "Blue", "Unlocked" };
  static String[] decorations = { "Painting", "Bookcase", "Lamp", "Puzzle" };

  static JComboBox<String> cb = new JComboBox<String>(directions);
  static JComboBox<String> cb1 = new JComboBox<String>(items);
  static JComboBox<String> cb2 = new JComboBox<String>(Containers);
  static JComboBox<String> cb3 = new JComboBox<String>(colours);
  static JComboBox<String> cb4 = new JComboBox<String>(decorations);

  static String CurentVeiw = "Containers";

  /**
   * This displays the whole GUI for the map editor.
   * 
   * @param map1
   *          the map to draw
   */
  public Gui(Map map1) {

    super("Map Editor");
    map = map1;
    setSize(1500, 1000);
    setResizable(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setJMenuBar(setUpTheMenu(container));

    DrawPanel panel = new DrawPanel();
    container.setLayout(new BorderLayout(5, 5));

    container.add(panel, BorderLayout.CENTER);
    container.add(pbase, BorderLayout.PAGE_END);
    setUpButtons(badditem, b2, bleft, bright, bup, bdown, bupmove, bdownmove, bcontainer, bchangeveiw, bdooradd,
        badddec);
    pbase.add(bdooradd);
    pbase.add(bcontainer);
    pbase.add(badddec);
    pbase.add(badditem);
    pbase.add(b2);
    pbase.add(bleft);
    pbase.add(bupmove);
    pbase.add(bdownmove);
    pbase.add(bright);
    pbase.add(bup);
    pbase.add(bdown);
    pbase.add(bchangeveiw);
    add(container);
    setVisible(true);

  }

  /**
   * Creates a new GUI.
   * 
   * @param map
   *          the map to put on the GUI
   */
  public static void display(Map map) {

    new Gui(map);

  }

  /**
   * change the floor you are viewing (up one).
   */
  public static void upAFloorToVeiw() {
    // this is just for testing
    if (map.getNumFloors() == 0) {
      selectedFloor++;
    } else if (map.getNumFloors() == 1) {
      selectedFloor++;
    } else if (map.getNumFloors() == 2) {
      selectedFloor = 0;
    }
  }

  /**
   * Sets all the buttons up.
   * 
   * @param b
   *          add item button
   * @param b2
   *          remove item button
   * @param bleft
   *          move left button
   * @param bright
   *          move right button
   * @param bup
   *          move up button
   * @param bdown
   *          move down button
   * @param bupmove
   *          move up button
   * @param bdownmove
   *          move down a floor button
   * @param bcontainer
   *          change the container button
   * @param changeVeiw
   *          change the view button
   * @param bdooradd
   *          add a door button
   * @param badddec
   *          add a decoration button
   */
  public static void setUpButtons(JButton b, JButton b2, JButton bleft, JButton bright, JButton bup, JButton bdown,
      JButton bupmove, JButton bdownmove, JButton bcontainer, JButton changeVeiw, JButton bdooradd, JButton badddec) {
    b.setBackground(Color.BLACK);
    b.setForeground(Color.WHITE);
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    bup.setBackground(Color.BLUE);
    bdown.setBackground(Color.BLUE);
    bcontainer.setBackground(Color.BLACK);
    bcontainer.setForeground(Color.WHITE);
    changeVeiw.setBackground(Color.YELLOW);
    bdooradd.setBackground(Color.BLACK);
    bdooradd.setForeground(Color.WHITE);
    badddec.setBackground(Color.BLACK);
    badddec.setForeground(Color.WHITE);

    badddec.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {

        createadddecFrame();

      }
    });
    bdooradd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {

        createAddDoorFrame();

      }
    });
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {

        createAddItemFrame();

      }
    });
    changeVeiw.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {

        if (Gui.selectedView == 0) {
          Gui.selectedView = 1;
          Gui.CurentVeiw = "Items";
        } else if (Gui.selectedView == 1) {
          Gui.selectedView = 2;
          Gui.CurentVeiw = "Decorations";

        } else if (Gui.selectedView == 2) {
          Gui.selectedView = 0;
          Gui.CurentVeiw = "Containers";
        }
      }
    });
    bcontainer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {

        createAddContainerFrame();

      }
    });
    b2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        // TODO call remove item
        createRemoveItemFrame();
      }
    });
    bleft.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        if (Gui.selectedRoom > 0) {
          Gui.selectedRoom = Gui.selectedRoom - 1;
        }
      }
    });
    bright.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        if (Gui.selectedRoom < 4) {
          Gui.selectedRoom = Gui.selectedRoom + 1;
        }
      }
    });
    bup.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        if (Gui.selectedFloor < Gui.map.getNumFloors() - 1) {
          Gui.selectedFloor = Gui.selectedFloor + 1;
        }
      }
    });
    bdown.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        if (Gui.selectedFloor > 0) {
          Gui.selectedFloor = Gui.selectedFloor - 1;
        }
      }
    });
    bupmove.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        if (Gui.selectedRoomy < 4) {
          Gui.selectedRoomy = Gui.selectedRoomy + 1;
        }
      }
    });
    bdownmove.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        if (Gui.selectedRoomy > 0) {
          Gui.selectedRoomy = Gui.selectedRoomy - 1;
        }
      }
    });

  }

  /**
   * Creates a pop up to find out what wall and decoration you want to add.
   */
  public static void createadddecFrame() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JButton button = new JButton("Enter");
        int xlenght = findLength(map) + 1;
        button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ev) {
            if (cb.getSelectedItem() == "North") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setNorthDec(cb4.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "East") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setEastDec(cb4.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "South") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setSouthDec(cb4.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "West") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setWestDec(cb4.getSelectedItem().toString());

            }

          }
        });
        Object[] options = new Object[] {};
        JOptionPane frame = new JOptionPane("Please Select", JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION,
            null, options, null);
        frame.add(cb);
        frame.add(cb4);
        frame.add(button);
        JDialog diag = new JDialog();
        diag.getContentPane().add(frame);
        diag.pack();
        diag.setVisible(true);
      }
    });
  }

  /**
   * Creates a pop up to find out what wall and container you want to add.
   */
  public static void createAddContainerFrame() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JButton button = new JButton("Enter");
        int xlenght = findLength(map) + 1;
        button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ev) {
            if (cb.getSelectedItem() == "North") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setNorthContainer(cb2.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "East") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .seteastContainer(cb2.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "South") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setsouthContainer(cb2.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "West") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setWestContainer(cb2.getSelectedItem().toString());

            }

          }
        });
        Object[] options = new Object[] {};
        JOptionPane frame = new JOptionPane("Please Select", JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION,
            null, options, null);
        frame.add(cb);
        frame.add(cb2);
        frame.add(button);
        JDialog diag = new JDialog();
        diag.getContentPane().add(frame);
        diag.pack();
        diag.setVisible(true);
      }
    });
  }

  /**
   * Creates a pop up to find out what wall and Color Door you want to add.
   */
  public static void createAddDoorFrame() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JButton button = new JButton("Enter");
        int xlenght = findLength(map) + 1;
        button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ev) {
            if (cb.getSelectedItem() == "North") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setNorthDoor(cb3.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "East") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setEastDoor(cb3.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "South") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setSouthDoor(cb3.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "West") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setWestDoor(cb3.getSelectedItem().toString());

            }

          }
        });
        Object[] options = new Object[] {};
        JOptionPane frame = new JOptionPane("Please Select", JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION,
            null, options, null);
        frame.add(cb);
        frame.add(cb3);
        frame.add(button);
        JDialog diag = new JDialog();
        diag.getContentPane().add(frame);
        diag.pack();
        diag.setVisible(true);
      }
    });
  }

  /**
   * Creates a pop up to find out what wall and Item you want to add.
   */
  public static void createAddItemFrame() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JButton button = new JButton("Enter");
        int xlenght = findLength(map) + 1;
        button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ev) {
            if (cb.getSelectedItem() == "North") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setNorth(cb1.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "East") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setEast(cb1.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "South") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .setSouth(cb1.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "West") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom)
                  .setWest(cb1.getSelectedItem().toString());

            }

          }
        });
        Object[] options = new Object[] {};
        JOptionPane frame = new JOptionPane("Please Select", JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION,
            null, options, null);
        frame.add(cb);
        frame.add(cb1);
        frame.add(button);
        JDialog diag = new JDialog();
        diag.getContentPane().add(frame);
        diag.pack();
        diag.setVisible(true);
      }
    });
  }

  /**
   * Creates a pop up to find out what wall and Item you want to remove.
   */
  public static void createRemoveItemFrame() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JButton button = new JButton("Enter");
        int xlenght = findLength(map) + 1;
        button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ev) {
            if (cb.getSelectedItem() == "North") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .getnorthWall().removeItem(cb1.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "East") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .geteastWall().removeItem(cb1.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "South") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom + Gui.selectedRoomy * xlenght)
                  .getsouthWall().removeItem(cb1.getSelectedItem().toString());

            } else if (cb.getSelectedItem() == "West") {
              map.getFloors().get(Gui.selectedFloor).getRooms().get(Gui.selectedRoom).getwestWall()
                  .removeItem(cb1.getSelectedItem().toString());

            }

          }
        });
        Object[] options = new Object[] {};
        JOptionPane frame = new JOptionPane("Please Select", JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION,
            null, options, null);
        frame.add(cb);
        frame.add(cb1);
        frame.add(button);
        JDialog diag = new JDialog();
        diag.getContentPane().add(frame);
        diag.pack();
        diag.setVisible(true);
      }
    });
  }

  /**
   * Gets the map.
   * 
   * @return The map
   */
  public static Map getMap() {
    return map;
  }

  /**
   * This sets up the menu bar.
   * 
   * @param cont
   *          The Jpannel you want to add a menu Bar too
   * @return the set up menu bar
   */
  public static JMenuBar setUpTheMenu(JPanel cont) {
    m.add(file);
    m.add(help);

    file.add(NM);
    NM.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {

        map = Loader.load("White 0 0 [ Empty Empty Empty ] [ Empty Empty Empty ] " + "[ "
            + "Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "White 1 0 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 2 0 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 3 0 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 0 1 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 1 1 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 2 1 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 3 1 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 0 2 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 1 2 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 2 2 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 3 2 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 0 3 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 1 3 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 2 3 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 3 3 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 0 4 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 1 4 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 2 4 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 3 4 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 0 5 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 1 5 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 2 5 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 3 5 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 0 6 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 1 6 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 2 6 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 3 6 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 0 7 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 1 7 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 2 7 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 3 7 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 0 8 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 1 8 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 2 8 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 3 8 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 0 9 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 1 9 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 2 9 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 3 9 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 0 10 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 1 10 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 2 10 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 3 10 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 0 11 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 1 11 [ Empty Empty Empty ] [ Empty Empty Empty ]"
            + " [ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 2 11 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n"
            + "White 3 11 [ Empty Empty Empty ] [ Empty Empty Empty ] "
            + "[ Empty Empty Empty ] [ Empty Empty Empty ]\r\n" + "");

      }
    });
    file.add(ICM);
    ICM.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        String filecontents = "";

        FileReader fr = null;
        try {
          fr = new FileReader(("resources/" + "WorkingSaveFile.txt"));
        } catch (FileNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        int i;

        if (fr != null) {

          try {
            while ((i = fr.read()) != -1) {
              filecontents = filecontents + (char) i;

            }
          } catch (IOException | NullPointerException n) {

            n.printStackTrace();
          }
          try {
            fr.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
          map = Loader.load(filecontents);
        }
      }
    });

    file.add(SCM);
    SCM.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        String str = Saver.makeSave(map);
        BufferedWriter writer = null;
        try {
          writer = new BufferedWriter(new FileWriter("resources/" + "WorkingSaveFile.txt"));
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        try {
          writer.write(str);
        } catch (IOException e) {

          e.printStackTrace();
        }

        try {
          writer.close();
        } catch (IOException | NullPointerException e) {

          e.printStackTrace();
        }

      }
    });
    file.add(IM);
    IM.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {

        try {
          map = Controler.importer();
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    });
    file.add(EM);
    EM.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {

        try {
          Controler.exporter(map);
        } catch (FileNotFoundException e) {

          e.printStackTrace();
        }
      }
    });
    file.add(EG);
    EG.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        System.exit(0);
      }
    });

    help.add(H);
    H.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        JOptionPane.showMessageDialog(cont,
            "move Around Using the buttons at the bottom and aply changes to the selected room");
      }
    });
    help.add(B);
    B.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        JOptionPane.showMessageDialog(cont,
            "There are so many im working through my list of bugs before i move on to new ones");
      }
    });

    return m;
  }

  /**
   * returns the length of the map.
   * 
   * @param map
   *          the map you want to find the length of.
   * @return the length of the map
   */
  public static int findLength(Map map) {
    int i = 0;
    int lenght = 0;
    while (i < map.getFloors().get(selectedFloor).getRooms().size()) {

      if (map.getFloors().get(selectedFloor).getRooms().get(i).getx() > lenght) {
        lenght = map.getFloors().get(selectedFloor).getRooms().get(i).getx();
      }
      i++;
    }

    return lenght;
  }

  /**
   * set selected view.
   * 
   * @param i
   *          number to set
   */
  public static void setSelectedView(int i) {
    Gui.selectedView = i;
  }

}
