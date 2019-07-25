package mapeditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class Draws the main component and all the graphics.
 * 
 * @author youngdani6 300418477
 *
 */
public class DrawPanel extends JPanel implements ActionListener {

  private static final long serialVersionUID = 1L;
  Timer timer = new Timer(1000, this);

  /**
   * Draws the actual squares and letters on to the JPannel.
   */
  @Override
  public void paintComponent(Graphics g) {

    super.paintComponent(g);

    Map map = new Map();
    map = Gui.getMap();
    timer.start();// Start the timer here.

    int i = 0;
    int ftv = Gui.selectedFloor; // floor to view
    String currentVeiw = Gui.CurentVeiw;
    if (map.getNumFloors() != 0) {
      // int nof =map.getFloors().get(ftv).getNumRooms(); looking
      // for a better solution
      int nof = 4; // hardcoded bad (nof = number of rooms

      int xadd = 500 - nof * 50;
      int y = 0;
      int x = 0;

      while (i < map.getFloors().get(ftv).getNumRooms()) {
        x = map.getFloors().get(ftv).getRooms().get(i).getx();
        y = (map.getFloors().get(ftv).getRooms().get(i).gety() - Gui.selectedFloor * nof) * (700 * 1 / nof);

        // if(x==Gui.selectedRoom &&
        // map.getFloors().get(ftv).getRooms().get(i).gety()==Gui.selectedRoomy)
        // {

        g.setColor(Color.RED);
        g.drawString("Selected", 700 * Gui.selectedRoom / nof + xadd + (700 * 1 / nof / 2) - 15,
            Gui.selectedRoomy * (700 * 1 / nof) + 10 + 700 * 1 / nof / 2);
        g.drawString("Room", 700 * Gui.selectedRoom / nof + xadd + (700 * 1 / nof / 2) - 10,
            Gui.selectedRoomy * (700 * 1 / nof) + 20 + 700 * 1 / nof / 2);
        // }
        g.setColor(Color.BLACK);

        g.drawRect(700 * x / nof + xadd, y, 700 * 1 / nof, 700 * 1 / nof);
        if (Gui.selectedView == 0) {
          g.drawString(map.getFloors().get(ftv).getRooms().get(i).getnorthWall().getContianer(),
              700 * x / nof + xadd + (700 * 1 / nof / 2), y + 10);
          g.drawString(map.getFloors().get(ftv).getRooms().get(i).getwestWall().getContianer(), 700 * x / nof + xadd,
              y + 10 + 700 * 1 / nof / 2);
          g.drawString(map.getFloors().get(ftv).getRooms().get(i).geteastWall().getContianer(),
              700 * x / nof + xadd - 40 + 700 * 1 / nof, y + 10 + 700 * 1 / nof / 2);
          g.drawString(map.getFloors().get(ftv).getRooms().get(i).getsouthWall().getContianer(),
              700 * x / nof + xadd + (700 * 1 / nof / 2), y - 10 + 700 * 1 / nof);
          g.drawString("Floor : " + ftv, 50, 50);
          g.drawString("Current Veiw : " + currentVeiw, 50, 100);

          i++;
        } else if (Gui.selectedView == 1) {

          g.drawString(map.getFloors().get(ftv).getRooms().get(i).getnorthWall().getItemDe(),
              700 * x / nof + xadd + (700 * 1 / nof / 2), y + 10);
          g.drawString(map.getFloors().get(ftv).getRooms().get(i).getwestWall().getItemDe(), 700 * x / nof + xadd,
              y + 10 + 700 * 1 / nof / 2);
          g.drawString(map.getFloors().get(ftv).getRooms().get(i).geteastWall().getItemDe(),
              700 * x / nof + xadd - 40 + 700 * 1 / nof, y + 10 + 700 * 1 / nof / 2);
          g.drawString(map.getFloors().get(ftv).getRooms().get(i).getsouthWall().getItemDe(),
              700 * x / nof + xadd + (700 * 1 / nof / 2), y - 10 + 700 * 1 / nof);
          g.drawString("Floor : " + ftv, 50, 50);
          g.drawString("Current Veiw : " + currentVeiw, 50, 100);

          i++;
        } else if (Gui.selectedView == 2) {
          // DecDe == decoration description
          g.drawString(map.getFloors().get(ftv).getRooms().get(i).getnorthWall().getDecDe(),
              700 * x / nof + xadd + (700 * 1 / nof / 2), y + 10);
          g.drawString(map.getFloors().get(ftv).getRooms().get(i).getwestWall().getDecDe(), 700 * x / nof + xadd,
              y + 10 + 700 * 1 / nof / 2);
          g.drawString(map.getFloors().get(ftv).getRooms().get(i).geteastWall().getDecDe(),
              700 * x / nof + xadd - 40 + 700 * 1 / nof, y + 10 + 700 * 1 / nof / 2);
          g.drawString(map.getFloors().get(ftv).getRooms().get(i).getsouthWall().getDecDe(),
              700 * x / nof + xadd + (700 * 1 / nof / 2), y - 10 + 700 * 1 / nof);
          g.drawString("Floor : " + ftv, 50, 50);
          g.drawString("Current Veiw : " + currentVeiw, 50, 100);

          i++;
        }
      }
    } else {
      // g.drawRect(500, 100, 500, 500);
      g.drawString("File -> import a map", 750, 250);

    }

  }

  /**
   * This keeps the main panel refreshing.
   */

  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource() == timer) {
      repaint();// this will call at every 1 second
    }

  }
}