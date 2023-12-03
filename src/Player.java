import java.util.Scanner;

public class Player {
    private String name;
    private int score;

    public Player() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?"); // Prompted to print the promt asking user for their name
        name = sc.nextLine();
        System.out.println("Your name is " + name); // Prints their name
        score = 0;
    }

    // Created public class for storing name
    public Player(String name) {
        this.name = name;
        score = 0;
    }

    // Created class to receive the name and output
    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void incrScore() {
        this.score += 1;
    }
}