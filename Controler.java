package mapeditor;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JFrame;

/**
 * This is the main class that controls everything.
 * 
 * @author youngdani6 300418477
 *
 */
public class Controler {

  /**
   * Call the GUI and draw the map.
   * 
   * @param map
   *          the map to display
   */
  public static void drawit(Map map) {
    Gui.display(map);
  }

  /**
   * This imports a map using a File dialog.
   * 
   * @return A map that has the chosen file content loaded in to it.
   * @throws IOException
   *           File not selected
   */

  public static Map importer() throws IOException {

    String filecontents = "";
    FileDialog fd = new FileDialog(new JFrame());
    fd.setVisible(true);
    File[] f = fd.getFiles();
    if (f.length > 0) {
      FileReader fr = new FileReader((fd.getFiles()[0].getAbsolutePath()));
      int i;
      while ((i = fr.read()) != -1) {
        filecontents = filecontents + (char) i;

      }
      fr.close();
    }

    return Loader.load(filecontents);

  }

  /**
   * This Exports the map. exports the map using a File Dialog.
   * 
   * @param maptoexport
   *          map that is to be exported
   * @throws FileNotFoundException
   *           file not selected
   */

  public static void exporter(Map maptoexport) throws FileNotFoundException {

    FileDialog fd = new FileDialog(new JFrame());
    fd.setVisible(true);
    File[] f = fd.getFiles();
    if (f.length > 0) {
      try (PrintStream out = new PrintStream(new FileOutputStream(fd.getFiles()[0].getPath()))) {
        out.print(Saver.makeSave(maptoexport));
      }
    }
  }

  /**
   * This is the main.
   * 
   * @param args
   *          string array
   * 
   */

  public static void main(String[] args) {

    Map map = new Map();

    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        drawit(map);
      }
    });

  }

  /**
   * added this method to call from other places.
   */
  public static void main() {

    Map map = new Map();

    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        drawit(map);
      }
    });

  }

}
