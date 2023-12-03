import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player currentPlayer1;
    private Player currentPlayer2;
    private Player activePlayer;
    private boolean finished;
    private int currentPlayer;
    private Scanner scanner;

    public Game() {
        currentPlayer1 = new Player();
        currentPlayer2 = new Player();
        scanner = new Scanner(System.in);
    }

    public void play() {
        Board.populate();
        Board.setmaximumGuess();
        Random random = new Random();
        currentPlayer = random.nextInt(2) + 1;

        setInitialPlayer(currentPlayer);

        while (!finished) {
            int pieces = Board.getPieces();
            int maximumGuess = Board.getmaximumGuess();

            displayTurnInfo(activePlayer, pieces, maximumGuess);

            int guess = getPlayerInput(maximumGuess);

            while (!isValid(guess)) {
                System.out.println("\nInvalid input. Please enter a valid number.");
                guess = getPlayerInput(maximumGuess);
            }

            Board.removePieces(guess);
            Board.setmaximumGuess();
            advanceTurn();

            if (Board.getPieces() <= 1) {
                handleEndOfGame();
                if (!isFinished()) {
                    Board.populate(); // Reset the board for a new game
                    Board.setmaximumGuess();
                    setInitialPlayer(currentPlayer);
                }
            }
        }
        scanner.close();
    }

    private void setInitialPlayer(int currentPlayer) {
        activePlayer = (currentPlayer == 1) ? currentPlayer1 : currentPlayer2;
        System.out.println("\n" + activePlayer.getName() + " was chosen to go first!");
    }

    private void displayTurnInfo(Player activePlayer, int pieces, int maximumGuess) {
        System.out.println("\nIt's " + activePlayer.getName() + "'s turn.!");
        System.out.println("\nThere are " + pieces + " pieces remaining.");
        System.out.println(
                "\nYou can remove" + (maximumGuess == 1 ? " only" : "") + " up to " + maximumGuess + " pieces.");
        System.out.println("\nHow many pieces would you like to remove?");
    }

    private int getPlayerInput(int maximumGuess) {
        System.out.print("> ");
        return scanner.nextInt();
    }

    private void advanceTurn() {
        currentPlayer++;
        activePlayer = (currentPlayer % 2 == 1) ? currentPlayer1 : currentPlayer2;
    }

    private boolean isValid(int num) {
        return num <= Board.getmaximumGuess();
    }

    private void handleEndOfGame() {
        if (currentPlayer % 2 == 0) {
            currentPlayer1.incrScore();
            System.out.println("\n" + currentPlayer1.getName() + " won the round!");
        } else {
            currentPlayer2.incrScore();
            System.out.println("\n" + currentPlayer2.getName() + " won the round!");
        }
    }

    private boolean isFinished() {
        System.out.println("\nWould you like to play again? (Y/N)");
        String userInput = scanner.next().trim().toUpperCase();

        while (!(userInput.equals("Y") || userInput.equals("N"))) {
            System.out.println("\nInvalid input. Would you like to play again? (Y/N)");
            userInput = scanner.next().trim().toUpperCase();
        }

        return userInput.equals("N");
    }
}