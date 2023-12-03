
//Libraries Imported
import java.lang.Math;

public class Board {
    // Variables
    private static int pieces;
    private static int maximumGuess;

    public static void populate() {
        pieces = (int) ((Math.random() * (41 - 10)) + 10);// Spawn the game with a random amount of pieces.
        System.out.println("Number of pieces: " + pieces);
    }

    // getter for pieces
    public static int getPieces() {
        return pieces;
    }

    // getter for maximumGuesses
    public static int getmaximumGuess() {
        return maximumGuess;
    }

    // When the user removes x amount of pieces, this gets called to remove the
    // pieces from the board.
    public static void removePieces(int n) {
        pieces -= n;
    }

    // sets the maximum amount of guesses.
    public static void setmaximumGuess() {
        maximumGuess = (int) (pieces / 2);
        if (pieces == 1) {
            maximumGuess = 1;
        }
    }
}