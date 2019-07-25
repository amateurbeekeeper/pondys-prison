package game_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A running game class.
 * 
 * @author fearyelli - 300406946
 * @author haresgeor - 300411891 Game instance of the game. This holds all the
 *         information about the currently loaded game's gamestate.
 */
public class PondysPrison {

  private Player player;
  private List<Room> rooms = new ArrayList<>();
  private Queue<Puzzle> puzzles = new LinkedList<>();

  /**
   * Get Player.
   * 
   * @return player returns player currently playing the game
   */
  public Player getPlayer() {
    return player;
  }

  /**
   * Set Player.
   * 
   * @param player
   *          sets player of the game.
   * 
   */
  public void setPlayer(Player player) {
    this.player = player;
  }

  /**
   * Get Rooms.
   * 
   * @return arraylist of rooms
   */
  public List<Room> getRooms() {
    return rooms;
  }

  /**
   * Add a room.
   * 
   * @param room
   *          adds a room to the array of rooms
   * 
   */
  public void addRoom(Room room) {
    rooms.add(room);
  }

  @Override
  public String toString() {
    return "PondysPrison [player=" + player + ", Rooms=" + rooms + "]";
  }

  private void generatePuzzles() {
    // Some questions and answers are from this website:
    // https://www.sanfoundry.com/java-questions-answers-freshers-experienced/

    List<Puzzle> puzzlesArray = new ArrayList<>();

    puzzlesArray.add(new Puzzle(
        "In object-oriented programming, new classes can be de"
            + "fined by extending existing classes. This is an example of:",
        "Encapsulation", "Interface", "Inheritance", "Inheritance"));
    puzzlesArray.add(new Puzzle(
        "Given a class named 'Person', which of the following is a va" + "lid constructor declaration for the class?",
        "Student (student s) { }", "Student student ( ) { }", "Static void stu" + "dent(){ }.", "Student student ( )"));
    puzzlesArray.add(new Puzzle("A package is a collection of", "Classes", "Inte" + "rfaces", "Classes and Interfaces",
        "Classes and Interfaces"));
    puzzlesArray.add(new Puzzle("What is the default value of an int var" + "iable", "null", "0", "1", "0"));

    puzzlesArray.add(new Puzzle("If you pop a stack, what element will it re" + "turn?", "The first element.",
        "The middle element.", "The last element.", "The last element."));

    puzzlesArray.add(new Puzzle("What is the first index of an array?", "Zer" + "o.", "Thirty Two.", "One.", "Zero."));

    puzzlesArray.add(new Puzzle("How can you create a random number in java?", "Using a for loop.",
        "Using Math.Random().", "Create a new int with no value.", "Using Math.Random()."));

    puzzlesArray
        .add(new Puzzle("How many floors does the victoria library have?", "F" + "our.", "Six.", "Eight.", "Eight."));

    puzzlesArray.add(new Puzzle("Is java an object oriented language?", "Y" + "es.", "Maybe.", "No.", "Yes."));

    puzzlesArray.add(new Puzzle("Can you use a for loop to count to 100?", "N" + "o.", "If you really want to, yes.",
        "Not sure.", "If you really want to, yes."));

    puzzlesArray.add(new Puzzle("Which of these values can a boolean variable c" + "ontain?", "True and False.",
        "0 and 1", "True", "True and False."));

    puzzlesArray.add(
        new Puzzle("Which of these keywords is used to make a class?", "in" + "t.", "struct.", "class.", "class."));

    puzzlesArray.add(new Puzzle("Which of these operators is used to allocate me" + "mory for an object?", "malloc.",
        "alloc.", "new.", "new."));

    puzzlesArray
        .add(new Puzzle("What does a constructor return?", "No return type.", "i" + "nt.", "void.", "No return type."));

    puzzlesArray.add(new Puzzle("What keyword is used to refer to the object tha" + "t invoked it?", "catch.", "this.",
        "abstract.", "this."));

    puzzlesArray.add(new Puzzle("Which of the following is a method having same" + " name as that of its class?",
        "constructor.", "finalize.", "class.", "constructor."));

    puzzlesArray.add(new Puzzle("Which of these can be overloaded?", "Method" + "s.", "Constructors.",
        "Both Mentioned.", "Both Mentioned."));

    puzzlesArray.add(new Puzzle(
        "What is the process of defining a method in terms of itse" + "lf, that is a method that calls itself?",
        "Recursion.", "Polymorphism.", "Abstraction.", "Recursion."));

    puzzlesArray.add(new Puzzle("Which of these class is superclass of every class" + " in Java?", "String class.",
        "ArrayList class.", "Object class.", "Object class."));

    puzzlesArray.add(new Puzzle("Which of these method of Object class can clone" + " an object?", "Object clone().",
        "clone().", "copy().", "Object clone()."));

    puzzlesArray.add(new Puzzle("Which of these keywords can be used to prevent inhe" + "ritance of a class?",
        "constant.", "final.", "super.", "final."));

    puzzlesArray
        .add(new Puzzle("Which of these keywords cannot be used for a class " + "which has been declared final?",
            "abstract.", "extends.", "implements.", "abstract."));

    puzzlesArray.add(new Puzzle("Which of these keywords is used to define interface" + "s in Java?", "interface.",
        "Interface.", "intf.", "interface."));

    puzzlesArray.add(new Puzzle("Which of these access specifiers can be used for a" + "n interface?", "private.",
        "Protected.", "Public.", "Public."));

    puzzlesArray.add(new Puzzle("What type of variable can be defined in an interfa" + "ce?", "private final.",
        "static final.", "public final.", "static final."));

    puzzlesArray.add(new Puzzle("What does an interface contain?", "Method definiti" + "on.", "Method name.",
        "Method declaration.", "Method declaration."));

    puzzlesArray.add(new Puzzle("What type of methods an interface contain by default?" + "", "abstract.", "static.",
        "private.", "abstract."));

    puzzlesArray.add(
        new Puzzle("Which of these type parameters is used for a generic class t" + "o return and accept a number?",
            "V.", "K.", "N.", "N."));

    puzzlesArray.add(new Puzzle("How many bits in a byte?", "8.", "4.", "2.", "8."));

    Collections.shuffle(puzzlesArray);

    for (Puzzle puzzle : puzzlesArray) {
      puzzles.add(puzzle);
    }

  }

  /**
   * Poll puzzle que.
   * 
   * @return puzzle polls the puzzle from the queue, so it wont be repeated
   *         throughout the game
   */
  public Puzzle pollPuzzle() {
    if (puzzles.size() <= 1) {
      this.generatePuzzles(); // Fills the queue.
    }
    return puzzles.poll();
  }
}