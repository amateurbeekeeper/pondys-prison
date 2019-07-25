package application_window;

import containers.Container;
import containers.Safe;
import game_classes.Clickable;
import game_classes.Direction;
import game_classes.Door;
import game_classes.MainMenu;
import game_classes.Player;
import game_classes.PondysPrison;
import game_classes.Puzzle;
import game_classes.Room;
import items.Combination;
import items.Item;
import items.Key;
import items.PondysShoes;
import items.Torch;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.*;
import renderer.*;

/**
 * The Graphical User Interface for which the player can see 
 * the game world and control their actions. 
 * Responsible for presenting appropriate windows to the 
 * user and allowing them to interact with the program
 * 
 * @author jamesrowles
 */
@SuppressWarnings("serial")
public class ApplicationWindow extends JFrame {

  HashMap<JButton, Item> inventoryMap;
  HashMap<JMenuItem, Item> clickableOptionsMap;
  List<JButton> inventory;
  List<JMenuItem> clickableOptions;
  List<JMenuItem> clickableOptions2;
  Clickable clickable;
  Player player;
  Point point;
  PondysPrison game;

  // INVENTORY BUTTONS
  private JButton jb4;
  private JButton jb8;
  private JButton jb9;
  private JButton jb10;
  private JButton jb11;
  private JButton jb12;
  private JButton jb13;
  private JButton jb14;
  private JButton jb15;

  // LEFT, RIGHT BUTTON
  private JButton jButton3;
  private JButton jButton1;

  // PROGRESS BARS
  private JProgressBar jProgressBar1;
  private JProgressBar jProgressBar2;

  // ROOM DESCRIPTION
  private JLabel jLabel13;
  private JScrollPane jScrollPane1;
  private JTextArea jTextArea1;

  // MENU BAR OBJECTS
  private JMenuItem jmenuitemopeneditor = new JMenuItem();
  private JMenu jMenu1;
  private JMenu jMenu2;
  private JMenuBar jMenuBar1;
  private JMenuItem jMenuItem1;
  private JMenuItem jMenuItem2;

  // PANELS
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JPanel jPanel7;

  // CHEST
  JMenuItem menu;
  JMenuItem popMenuItem4;
  JMenuItem popMenuItem3;
  JMenuItem popMenuItem2;
  JMenuItem popMenuItem1;

  // MENUS
  private JPopupMenu jPopupMenu2;
  private JPopupMenu jPopupMenu3;

  /**
   * Constructor.
   * 
   */
  public ApplicationWindow() {

    initGame();
    initComponents();

    initInventoryObjects();
    initMenuObjects();
    updateRoomDescription();
  }

  /**
   * Gets the Game object. Used for testing.
   * 
   * @return The Game.
   */
  public PondysPrison getGame() {
    return this.game;
  }

  /**
   * Initalise Inventory objects.
   */
  public void initInventoryObjects() {

    clickableOptions = new ArrayList<JMenuItem>();
    clickableOptions.add(popMenuItem1);
    clickableOptions.add(popMenuItem2);

    clickableOptions2 = new ArrayList<JMenuItem>();
    clickableOptions2.add(popMenuItem3);
    clickableOptions2.add(popMenuItem4);

    clickableOptionsMap = new HashMap<JMenuItem, Item>();
    clickableOptionsMap.put(popMenuItem1, null);
    clickableOptionsMap.put(popMenuItem2, null);
  }

  /**
   * Initalise Menu variables.
   */
  public void initMenuObjects() {
    inventory = new ArrayList<JButton>();
    inventory.add(jb4);
    inventory.add(jb8);
    inventory.add(jb9);
    inventory.add(jb10);
    inventory.add(jb11);
    inventory.add(jb12);
    inventory.add(jb13);
    inventory.add(jb14);
    inventory.add(jb15);

    inventoryMap = new HashMap<JButton, Item>();
    inventoryMap.put(jb4, null);
    inventoryMap.put(jb8, null);
    inventoryMap.put(jb9, null);
    inventoryMap.put(jb10, null);
    inventoryMap.put(jb11, null);
    inventoryMap.put(jb12, null);
    inventoryMap.put(jb13, null);
    inventoryMap.put(jb14, null);
    inventoryMap.put(jb15, null);
  }

  /**
   * Initalise Game components.
   * 
   */
  private void initGame() {

    game = new PondysPrison();
    new MainMenu(game);
    player = game.getPlayer();
  }

  /**
   * Initalise Swing components.
   * 
   */
  private void initComponents() {
    jPanel7 = new JPanel();
    jb4 = new JButton();
    jb8 = new JButton();
    jb9 = new JButton();
    jb10 = new JButton();
    jb11 = new JButton();
    jb12 = new JButton();
    jb13 = new JButton();
    jb14 = new JButton();
    jb15 = new JButton();
    jPanel2 = new JPanel();
    jButton1 = new JButton();
    jButton3 = new JButton();
    jPanel3 = new RendererPanel(game);
    jPanel1 = new JPanel();
    jLabel13 = new JLabel();
    jScrollPane1 = new JScrollPane();
    jTextArea1 = new JTextArea();
    jProgressBar1 = new JProgressBar();
    jMenuBar1 = new JMenuBar();
    jMenu1 = new JMenu();
    jMenuItem1 = new JMenuItem();
    jMenuItem2 = new JMenuItem();
    jMenu2 = new JMenu();
    jMenuBar1 = new JMenuBar();
    jMenu1 = new JMenu();
    jMenuItem1 = new JMenuItem();
    jMenuItem2 = new JMenuItem();
    jProgressBar2 = new JProgressBar();

    jProgressBar1.setValue(player.getHunger() * 10); // hunger
    jProgressBar2.setValue((player.getHydration() * 10)); // health

    // FOR MENUS
    jPopupMenu2 = new JPopupMenu();
    jPopupMenu3 = new JPopupMenu();

    // POP UP MENU
    popMenuItem1 = new JMenuItem("1", null);
    jPopupMenu2.add(popMenuItem1);
    popMenuItem1.setHorizontalTextPosition(JMenuItem.RIGHT);
    popMenuItem1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        chestPopupMenu1ActionPerformed(evt);
      }
    });
    popMenuItem2 = new JMenuItem("2", null);
    jPopupMenu2.add(popMenuItem2);
    popMenuItem2.setHorizontalTextPosition(JMenuItem.RIGHT);
    popMenuItem2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        chestPopupMenu2ActionPerformed(evt);
      }
    });

    popMenuItem3 = new JMenuItem("3", null);
    jPopupMenu3.add(popMenuItem3);
    popMenuItem3.setHorizontalTextPosition(JMenuItem.RIGHT);
    popMenuItem3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        initPopupMenu3ActionPerformed(evt);
      }
    });
    popMenuItem4 = new JMenuItem("4", null);
    jPopupMenu3.add(popMenuItem4);
    popMenuItem4.setHorizontalTextPosition(JMenuItem.RIGHT);
    popMenuItem4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        // initPopupMenu4ActionPerformed(evt);
      }
    });

    // INVENTORY BUTTON ACTION LISTENERS
    jb4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        inventoryButton4ActionPerformed(evt);
      }
    });

    jb8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        inventoryButton8ActionPerformed(evt);
      }
    });

    jb9.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        inventoryButton9ActionPerformed(evt);
      }
    });

    jb10.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        inventoryButton10ActionPerformed(evt);
      }
    });

    jb11.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        inventoryButton11ActionPerformed(evt);
      }
    });

    jb12.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        inventoryButton12ActionPerformed(evt);
      }
    });

    jb13.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        inventoryButton13ActionPerformed(evt);
      }
    });

    jb14.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        inventoryButton14ActionPerformed(evt);
      }
    });

    jb15.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        inventoryButton15ActionPerformed(evt);
      }
    });

    // MOUSE LISTENER
    this.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        mouseClickedAction(evt);
      }
    });

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(new java.awt.Dimension(1500, 1500));
    jPanel7.setBorder(BorderFactory.createTitledBorder("Inventory"));
    jb4.setText("");
    jb8.setText("");
    jb9.setText("");
    jb10.setText("");
    jb11.setText("");
    jb12.setText("");
    jb13.setText("");
    jb14.setText("");
    jb15.setText("");
    GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup().addContainerGap()
            .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(jb13, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jb15, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jb14, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(jb4, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jb9, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jb8, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(jb10, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jb11, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jb12, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    jPanel7Layout
        .setVerticalGroup(
            jPanel7Layout
                .createParallelGroup(
                    GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING,
                    jPanel7Layout.createSequentialGroup().addContainerGap(32, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jb4, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb9, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb8, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jb10, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb11, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb12, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jb13, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb15, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb14, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));

    jPanel2.setBorder(BorderFactory.createEtchedBorder());

    jButton1.setText("RIGHT");
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonActionPerformed1(evt);
      }
    });

    jButton3.setText("LEFT");
    jButton3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonActionPerformed3(evt);
      }
    });

    GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
            jPanel2Layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE).addContainerGap()));
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
            jPanel2Layout.createSequentialGroup().addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap()));

    jPanel3.setBorder(BorderFactory.createEtchedBorder());

    GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1005, Short.MAX_VALUE));
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

    jPanel1.setBorder(BorderFactory.createEtchedBorder());

    jLabel13.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel13.setText("");
    jLabel13.setHorizontalTextPosition(SwingConstants.LEFT);

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jLabel13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addContainerGap()));
    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel13)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1).addContainerGap()));

    jProgressBar1.setBorder(BorderFactory.createTitledBorder("Hunger"));
    jProgressBar2.setBorder(BorderFactory.createTitledBorder("Hydration"));

    jMenu1.setText("File");

    jMenuItem1.setText("Load");
    jMenuItem1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jMenuItemActionPerformed1(evt);
      }
    });

    jMenu1.add(jMenuItem1);

    jMenuItem2.setText("Save");
    jMenuItem2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jMenuItemActionPerformed2(evt);
      }
    });
    jMenu1.add(jMenuItem2);

    jMenuBar1.add(jMenu1);

    jMenu2.setText("MapEditor");
    jmenuitemopeneditor.setText("Open Map Editor");
    jMenu2.add(jmenuitemopeneditor);

    jmenuitemopeneditor.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

        mapeditor.Controler.main();
      }
    });
    jMenuBar1.add(jMenu2);
    setJMenuBar(jMenuBar1);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addContainerGap()
            .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProgressBar1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProgressBar2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel3, GroupLayout.DEFAULT_SIZE,
                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jProgressBar2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3466, Short.MAX_VALUE)))
            .addContainerGap()));

    pack();

  }

  /**
   * Helper function to use an item from the players inventory.
   * 
   * @param Button mapped to Item
   */
  private void useItem(JButton button) {
    Item i = inventoryMap.get(button);

    if (i instanceof Key == false && i instanceof Torch == false && i instanceof Combination == false) {

      if (i instanceof PondysShoes) {
        JOptionPane.showMessageDialog(null, "Pondy was startled and moved further away!");
      }

      inventoryMap.get(button).useItem(player); // USE ON PLAYER
      player.removeItem(inventoryMap.get(button)); // REMOVE FROM PLAYER
      updateInventory();
      updateProgressBars();
      checkPlayer();
    } else {
      JOptionPane.showMessageDialog(null, "You cannot use this item here.");
    }
  }

  /**
   * To check if the Player has depleted their hunger or their hydration.
   * 
   */
  public void checkPlayer() {
    String message = "";

    if (player.getHunger() <= 0) {
      message = "You have died of Hunger!!\n\nWould you like to play again?";
    } else if (player.getHydration() <= 0) {
      message = "You have died of Dehydration!!\n\nWould you like to play again?";
    } else if (player.getDistance() <= 0) {
      message = "Pondy has caught you!!\n\nWould you like to play again?";
    }
      //} else if(player.hasExitedGame()) { message = "Game Over!! You Won!!"; // TODO
    //}
    
    if (message == "") {
      return;
    }

    JFrame frame = new JFrame();
    
    JOptionPane.showMessageDialog(frame, message);
    
  
    frame.setVisible(true);
   

    int response = JOptionPane.showConfirmDialog(null, message, "Game Over", JOptionPane.DEFAULT_OPTION );

    if (response == JOptionPane.NO_OPTION) {
      System.exit(0);
    } else if (response == JOptionPane.YES_OPTION) {
      System.exit(0);
    }
      

    
   
    }

  /**
   * To visually update the players inventory.
   * 
   */
  public void updateInventory() {

    // GET THE ITEMS FROM THE PLAYER
    List<Item> playerInventory = player.getInventory();

    if (playerInventory.size() >= 9) {
      JOptionPane.showMessageDialog(null, "Inventory Full!!");
    } else {

      // CLEAR THE INVENTORY SO THAT ITEMS AREN'T ADDED TWICE
      for (Entry<JButton, Item> entry : inventoryMap.entrySet()) {
        JButton k = entry.getKey();
        Item i = entry.getValue();

        k.setIcon(null);
        i = null;
      }

      // CREATE MENU OPTIONS
      for (int i = 0; i < playerInventory.size(); i++) {

        // GET THE IMAGE OF THE ITEM
        ImageIcon imageIcon = scaleIcon(playerInventory.get(i).getImage(), 30);

        // PLACE IT
        inventory.get(i).setIcon(imageIcon);
        inventoryMap.put(inventory.get(i), playerInventory.get(i));
      }
    }
  }

  /**
   * An action-performed method that calls useItem. Passing it the appropriate
   * button which is then mapped to the item it is displaying.
   * 
   * @param evt from Button press
   */
  protected void inventoryButton15ActionPerformed(ActionEvent evt) {
    useItem(jb15);
  }

  /**
   * An action-performed method that calls useItem. Passing it the appropriate
   * button which is then mapped to the item it is displaying.
   * 
   * @param evt from Button press
   */
  protected void inventoryButton14ActionPerformed(ActionEvent evt) {
    useItem(jb14);
  }

  /**
   * An action-performed method that calls useItem. Passing it the appropriate
   * button which is then mapped to the item it is displaying.
   * 
   * @param evt from Button press
   */
  protected void inventoryButton13ActionPerformed(ActionEvent evt) {
    useItem(jb13);
  }

  /**
   * An action-performed method that calls useItem. Passing it the appropriate
   * button which is then mapped to the item it is displaying.
   * 
   * @param evt from Button press
   */
  protected void inventoryButton12ActionPerformed(ActionEvent evt) {
    useItem(jb12);
  }

  /**
   * An action-performed method that calls useItem. Passing it the appropriate
   * button which is then mapped to the item it is displaying.
   * 
   * @param evt from Button press
   */
  protected void inventoryButton11ActionPerformed(ActionEvent evt) {
    useItem(jb11);
  }

  /**
   * An action-performed method that calls useItem. Passing it the appropriate
   * button which is then mapped to the item it is displaying.
   * 
   * @param evt from Button press
   */
  protected void inventoryButton10ActionPerformed(ActionEvent evt) {
    useItem(jb10);
  }

  /**
   * An action-performed method that calls useItem. Passing it the appropriate
   * button which is then mapped to the item it is displaying.
   * 
   * @param evt from Button press
   */
  protected void inventoryButton9ActionPerformed(ActionEvent evt) {
    useItem(jb9);
  }

  /**
   * An action-performed method that calls useItem. Passing it the appropriate
   * button which is then mapped to the item it is displaying.
   * 
   * @param evt from Button press
   */
  protected void inventoryButton8ActionPerformed(ActionEvent evt) {
    useItem(jb8);
  }

  /**
   * To update the Hunger and Hydration bars.
   * 
   */
  public void updateProgressBars() {
    jProgressBar1.setValue(player.getHunger() * 10); // hunger
    jProgressBar2.setValue(player.getHydration() * 10); // hydration
  }

  /**
   * An action-performed method that calls useItem. Passing it the appropriate
   * button which is then mapped to the item it is displaying.
   * 
   * @param evt from Button press
   */
  protected void inventoryButton4ActionPerformed(ActionEvent evt) {
    useItem(jb4);
  }

  /**
   * Deals with logic for different types of Clickable objects.
   * 
   */
  public void handleClickable() {
    RendererPanel render = (RendererPanel) jPanel3;

    if (clickable instanceof Door) { // UNLOCK / CHANGE ROOM
      Door door = (Door) clickable;

      if (door.isLocked()) {
        if (door.checkKey(player)) {
          JOptionPane.showMessageDialog(null, "Door Unlocked!");

          door.unlockDoor();
        } else {
          JOptionPane.showMessageDialog(null, "You don't have the correct key for this padlock!");
        }
      } else { // OPEN DOOR / GO INTO ROOM ON OTHER SIDE

        Room room = player.enterRoom(door);
        updateProgressBars();
        render.moveRoom(room); // NEW ROOM
        
        checkPlayer();
      }
    } else if (clickable instanceof Puzzle) { // DO PUZZLE - POP UP MEU
      Puzzle puzzle = (Puzzle) clickable;
      if (puzzle.isDone()) {
        JOptionPane.showMessageDialog(null, "Puzzle has been done!!");
        return;
      }

      puzzlePopUp(puzzle, player);

    } else if (clickable instanceof Container) { // CONTAINER - OPEN - DISPLAY MENU
      if (((Container) clickable).getItems().size() == 0) {
        JOptionPane.showMessageDialog(null, "This " + ((Container) clickable).getName() + " is Empty!");
      } else {
        if (clickable instanceof Safe) {
          if (((Safe) clickable).checkCombination(player)) {
            ((Safe) clickable).open();
          } else {
            JOptionPane.showMessageDialog(null, "You do not have the combination to the Safe!");
            return;
          }
        } else {
          ((Container) clickable).open();
        }

        // SHOW MENU
        createContainerMenu();
        jPopupMenu2.show(ApplicationWindow.this, (int) point.getX(), (int) point.getY());
        jPopupMenu2.pack();
        jPopupMenu2.validate();
        jPopupMenu2.show(this, 400, 400);
      }
    }

    updateProgressBars();
    updateInventory();
    checkPlayer();
    repaintGamePanel();
  }

  /**
   * Creates a pop-up for a Puzzle object.
   * 
   * @param puzzle for specific puzzle
   * @param p to update inventory
   */
  public void puzzlePopUp(Puzzle puzzle, Player p) {
    JRadioButton puzzleOption1;
    JRadioButton puzzleOption2;
    JRadioButton puzzleOption3;
    ButtonGroup puzzleButtonGroup;
    JButton button = new JButton("Enter");

    JOptionPane pane = new JOptionPane(puzzle.getQuestion(), JOptionPane.INFORMATION_MESSAGE,
        JOptionPane.DEFAULT_OPTION, null, new Object[] {}, null);

    JDialog diag = new JDialog();
    diag.setTitle("Puzzle");

    puzzleOption1 = new JRadioButton(puzzle.getAnswerA());
    puzzleOption2 = new JRadioButton(puzzle.getAnswerB());
    puzzleOption3 = new JRadioButton(puzzle.getAnswerC());
    puzzleButtonGroup = new ButtonGroup();

    puzzleButtonGroup.add(puzzleOption1);
    puzzleButtonGroup.add(puzzleOption2);
    puzzleButtonGroup.add(puzzleOption3);

    pane.add(puzzleOption1);
    pane.add(puzzleOption2);
    pane.add(puzzleOption3);
    pane.add(button);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        String answer = " ";

        if (puzzleOption1.isSelected()) {
          answer = puzzle.getAnswerA();
        } else if (puzzleOption2.isSelected()) {
          answer = puzzle.getAnswerB();
        } else if (puzzleOption3.isSelected()) {
          answer = puzzle.getAnswerC();
        }

        if (puzzle.answerQuestion(answer)) {
          JOptionPane.showMessageDialog(null, "Correct! Prize Added to Inventory");
          puzzle.obtainPrize(p);
        } else {
          JOptionPane.showMessageDialog(null, "Incorrect! Pondy Advances Closer!");
          puzzle.incorrectlyAnswered(p);
        }

        puzzle.setDone();
        repaintGamePanel();

        updateInventory();

        diag.setModal(false);
        diag.setVisible(false);
      }
    });
    diag.getContentPane().add(pane);
    diag.setDefaultCloseOperation(diag.DO_NOTHING_ON_CLOSE);

    diag.pack();
    diag.setModal(true);
    diag.setVisible(true);

    diag.setModal(false);
    diag.setVisible(false);

    diag.dispose();
  }

  /**
   * Creates a pop-up menu for a Container object.
   * 
   */
  public void createContainerMenu() {
    if (((Container) clickable).getItems().isEmpty()) {
      JOptionPane.showMessageDialog(null, "This Chest is Empty!");
    } else {

      // CREATE MENU OPTIONS
      int j = 0;
      for (HashMap.Entry<String, String> entry : clickable.getMenu(player).entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();

        ImageIcon imageIcon = scaleIcon(new ImageIcon("resources/" + value + ".png"), 30);

        clickableOptions.get(j).setIcon(imageIcon); // SET ICON FOR MENU
        clickableOptions.get(j).setText(key); // SET TEXT FOR MENU
        clickableOptionsMap.put(clickableOptions.get(j), ((Container) clickable).getItems().get(j));

        jPopupMenu2.add(clickableOptions.get(j));

        j++;
      }

      // REMOVE UNNEEDED MENU OPTIONS
      for (int i = 0; i < clickableOptions.size(); i++) {
        if (clickableOptions.get(i).getIcon() == null) {
          jPopupMenu2.remove(clickableOptions.get(i));
        }
      }
    }
  }

  /**
   * Creates a pop-up menu for a Clickable object.
   * 
   */
  public void createClickableMenu() {

    // CREATE MENU OPTIONS
    int j = 0;
    for (HashMap.Entry<String, String> entry : clickable.getMenu(player).entrySet()) {

      String key = entry.getKey();
      String value = entry.getValue();

      ImageIcon imageIcon = scaleIcon(new ImageIcon("resources/" + value + ".png"), 30);

      clickableOptions2.get(j).setIcon(imageIcon); // SET ICON FOR MENU
      clickableOptions2.get(j).setText(key); // SET TEXT FOR MENU

      jPopupMenu3.add(clickableOptions2.get(j));

      j++;
    }

    // REMOVE UNNEEDED MENU OPTIONS
    for (int i = 0; i < clickableOptions2.size(); i++) {
      if (clickableOptions2.get(i).getIcon() == null) {
        jPopupMenu3.remove(clickableOptions2.get(i));
      }
    }
  }

  /**
   * An action-performed method that calls pickUpItem. Passing it the appropriate
   * menuItem which is then mapped to the item it is displaying.
   * 
   * @param evt from Popup press
   */
  protected void chestPopupMenu2ActionPerformed(ActionEvent evt) {
    pickUpItem(popMenuItem2);
  }

  /**
   * Adds an item from a container to the players inventory.
   * 
   * @param item from Popup press which maps to the Item to be added
   */
  public void pickUpItem(JMenuItem item) {
    player.pickUpItem(clickableOptionsMap.get(item)); // PLAYER PICK UP
    ((Container) clickable).takeItem(clickableOptionsMap.get(item)); // REMOVE FROM CHEST
    clickableOptionsMap.put(item, null); // REMOVE FROM MAP
    jPopupMenu2.remove(item); // REMOVE BUTTON

    jPopupMenu2.show(ApplicationWindow.this, (int) point.getX(), (int) point.getY());
    jPopupMenu2.pack();
    jPopupMenu2.validate();
    jPopupMenu2.show(this, 400, 400);

    repaintGamePanel();
    updateInventory();
  }

  /**
   * An action-performed method that calls pickUpItem. Passing it the appropriate
   * menuItem which is then mapped to the item it is displaying.
   * 
   * @param evt from Popup press
   */
  protected void chestPopupMenu1ActionPerformed(ActionEvent evt) {
    pickUpItem(popMenuItem1);
  }

  /**
   * To redraw the Renderer Panel.
   * 
   */
  public void repaintGamePanel() {
    ((RendererPanel) jPanel3).repaint();
  }

  /**
   * Action performed method to deal with behaviour of Clickable pop-up options.
   * 
   * @param evt from Popup press
   */
  protected void initPopupMenu3ActionPerformed(ActionEvent evt) {
    handleClickable();
    updateInventory();
    repaintGamePanel();
  }

  /**
   * Clears the pop-up menus after each click.
   * 
   */
  public void clearMenus() {
    // CLEAR CONTAINER
    jPopupMenu2.remove(popMenuItem1);
    jPopupMenu2.remove(popMenuItem2);
    // CLEAR CLICKABLE
    jPopupMenu3.remove(popMenuItem3);
    jPopupMenu3.remove(popMenuItem4);
  }

  /**
   * Recognises when a player has clicked an (interactable) object and then
   * creates and shows a pop-up.
   * 
   * @param evt from mouse click
   */
  private void mouseClickedAction(MouseEvent evt) {
    clearMenus();

    // CHECK WHAT THEY HAVE CLICKED
    point = new Point(evt.getX(), evt.getY());
    Direction direction = player.getDirection();

    RendererPanel render = (RendererPanel) jPanel3;
    clickable = render.onClick(point, direction);

    // DISPLAY AN APPROP. POP UP MENU
    if (clickable != null) {
      if (clickable instanceof Puzzle) {
        if (((Puzzle) clickable).isDone()) {
          return;
        }
      }
      createClickableMenu();
      jPopupMenu3.show(ApplicationWindow.this, (int) point.getX(), (int) point.getY());
      jPopupMenu3.show(this, 400, 400);
    }
  }

  /**
   * To open a file chooser to load a new game.
   * 
   * @param evt from when load is clicked
   */
  private void jMenuItemActionPerformed1(ActionEvent evt) {

    JFileChooser fileChooser = new JFileChooser();
    if (fileChooser.showOpenDialog(ApplicationWindow.this) == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      // load from file

      // System.out.println(file.toString());

    }
  }

  /**
   * To open a file chooser to save a game.
   * 
   * @param evt from when save is clicked
   */
  private void jMenuItemActionPerformed2(ActionEvent evt) {
    JFileChooser fileChooser = new JFileChooser();
    if (fileChooser.showSaveDialog(ApplicationWindow.this) == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      // save to file

    }
  }

  /**
   * Helper function to change the size of images.
   * 
   */
  private ImageIcon scaleIcon(ImageIcon imageIcon, int size) {
    java.awt.Image image = imageIcon.getImage();
    java.awt.Image newimg = image.getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH);
    return new ImageIcon(newimg);
  }

  /**
   * Changes the players view to the left.
   * 
   */
  private void jButtonActionPerformed3(ActionEvent evt) {

    player.turnLeft();
    updateRoomDescription();
    updateInventory();
    repaintGamePanel();
  }

  /**
   * Changes the players view to the right.
   * 
   */
  private void jButtonActionPerformed1(ActionEvent evt) {
    player.turnRight();
    updateRoomDescription();
    updateInventory();
    repaintGamePanel();
  }

  /**
   * Updates the room and/ or wall display information.
   * 
   */
  public void updateRoomDescription() {
    String roomInfo = "x=" + player.getCurrentRoom().getXCoord();
    roomInfo += " y=" + player.getCurrentRoom().getYCoord();
    String wallInfo;

    jLabel13.setText("Room: " + roomInfo);

    game_classes.Wall wall = player.getCurrentRoom().getWalls().get(player.getDirection());
    wallInfo = wall.getInfo();

    jTextArea1.setText(wallInfo);
  }

  /**
   * Main to run Application Window.
   * 
   * @param args required to run
   */
  public static void main(String args[]) {

    new ApplicationWindow().setVisible(true);
  }
}
