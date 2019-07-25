package game_classes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import items.*;

/**
 * Implementation of puzzle.
 * 
 * @author fearyelli - 300406946 Puzzle for the player to complete, they must
 *         choose the correct multiple choice answer otherwise pondy gets closer
 */

public class Puzzle extends Wall implements Clickable {

  private String question;
  private String answerA;
  private String answerB;
  private String answerC;
  private String correctAnswer;
  private BufferedImage image;
  private BufferedImage sideOnImage;
  private BufferedImage rightSideOnImage;
  private boolean isDone = false;

  @SuppressWarnings("unused")
  private PondysPrison game;

  /**
   * Make a Puzzle.
   * 
   * @param question
   *          question for the player
   * @param answerA
   *          possible answer 1
   * @param answerB
   *          possible answer 2
   * @param answerC
   *          possible answer 3
   * @param correctAnswer
   *          correct answer
   */
  public Puzzle(String question, String answerA, String answerB, String answerC, String correctAnswer) {
    this.question = question;
    this.answerA = answerA;
    this.answerB = answerB;
    this.answerC = answerC;
    this.correctAnswer = correctAnswer;

    try {
      image = ImageIO.read(new File("resources/puzzle.png"));
      sideOnImage = ImageIO.read(new File("resources/sideOnPuzzle.png"));
      rightSideOnImage = ImageIO.read(new File("resources/rightSideOnPuzzle.png"));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Get Menu.
   * 
   * @return null
   */
  public List<String> getMenu() {
    return null; // to compile.

  }

  /**
   * Get Menu.
   * 
   * @param Player
   *          a player.
   */
  public HashMap<String, String> getMenu(Player player) {

    HashMap<String, String> d = new HashMap<>();
    d.put("Do Puzzle", "puzzle");

    return d;
  }

  /**
   * Is the answer corect.
   * 
   * @param userAnswer
   *          selected answer from user
   * 
   * @return true if correct, false if not allows the player to answer the
   *         question
   */
  public boolean answerQuestion(String userAnswer) {
    if (userAnswer.equals(correctAnswer)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * playing game gives the player a random consumable as they have answered the
   * question correctly.
   * 
   * @param player
   *          the player to get the item.
   * 
   */
  public void obtainPrize(Player player) {
    Random rand = new Random();
    int itemNum = Math.abs(rand.nextInt(5));
    if (itemNum == 0) {
      player.pickUpItem(new Apple());
    } else if (itemNum == 1) {
      player.pickUpItem(new Burger());
    } else if (itemNum == 2) {
      player.pickUpItem(new Cookie());
    } else if (itemNum == 3) {
      player.pickUpItem(new Fries());
    } else if (itemNum == 4) {
      player.pickUpItem(new Hotdog());
    } else {
      player.pickUpItem(new Water());
    }
  }

  /**
   * playing game makes pondy get closer as the player answered the question
   * incorrectly.
   * 
   * @param player
   *          the player
   * 
   */
  public void incorrectlyAnswered(Player player) {
    player.tickDistance();
  }

  /**
   * Get question.
   * 
   * @return question return question.
   */
  public String getQuestion() {
    return question;
  }

  /**
   * Get Answer1.
   * 
   * @return possible answer 1
   */
  public String getAnswerA() {
    return answerA;
  }

  /**
   * Get Answer2.
   * 
   * @return possible answer 2
   */
  public String getAnswerB() {
    return answerB;
  }

  /**
   * Get Answer3.
   * 
   * @return possible answer 3
   */
  public String getAnswerC() {
    return answerC;
  }

  @Override
  public String toString() {
    return "Puzzle [question=" + question + ", answe" + "rA=" + answerA + ", " + "answerB=" + answerB + ", answerC="
        + answerC + ", correctAnswer=" + correctAnswer + "]";
  }

  public BufferedImage getImage() {
    return image;
  }

  public BufferedImage getSideOnImage() {
    return sideOnImage;
  }

  public BufferedImage getRightSideOnImage() {
    return rightSideOnImage;
  }

  /**
   * Is puzzle completed.
   * 
   * @return is done boolean
   */
  public boolean isDone() {
    return isDone;
  }

  /**
   * Set done as true.
   */
  public void setDone() {
    isDone = true;
  }

}
