package rockpaperscissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Player {
    private String username;
    private int score;
    private final File file;
    private final String filePath = ".\\rating.txt";

    Player() {
        this.file = new File(this.filePath);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return this.score;
    }

    public void initializeScore() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                if (parts[0].equals(this.username)) {
                    this.score = Integer.parseInt(parts[1]);
                    break;
                } else {
                    this.score = 0;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + this.filePath);
        }
    }

    public void addScore(int score) {
        this.score += score;
    }
}
