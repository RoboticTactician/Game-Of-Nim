// This is the main runner of the game
// When it runs, it will create an instance of Game.java
public class GameRunner {
  public static void main(String[] args) {
    // Welcomes the player to the game.
    System.out.println("This is the Game Of Nim!");
    // Creates an instance of Game
    Game nim = new Game();
    // Starts the game.
    nim.play();
  }
}