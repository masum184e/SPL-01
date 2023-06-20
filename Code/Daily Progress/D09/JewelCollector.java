import java.util.Random;
import java.util.Scanner;

public class JewelCollector {
    private int x; // for user position
    private int y;
    private int[] positionX; // Jewel X Position
    private int[] positionY; // Jewel Y Position
    private int gameOver;
    private int noOfMoves;
    private boolean gameQuit;

    public JewelCollector() {
        x = 0;
        y = 0;
        positionX = new int[4];
        positionY = new int[4];
        gameOver = 0;
        noOfMoves = 0;
        gameQuit = false;

        Random rand = new Random();
        // Storing the random X and Y Position For Jewels
        for (int i = 0; i < 4; i++) {
            positionX[i] = rand.nextInt(50);
            positionY[i] = rand.nextInt(10);
        }
    }

    public void drawBoundary() {
        // Here I will be drawing the boundary using # character.
        // I am not using graphics so I will not color the background.
        for (int i = -1; i <= 10; i++) {
            for (int j = -1; j <= 50; j++) {
                if (i == -1 || i == 10 || j == -1 || j == 50) {
                    System.out.print("#");
                } else {
                    if (i == y && j == x) {
                        System.out.print("P");
                        for (int k = 0; k < 4; k++) {
                            if (positionX[k] == x && positionY[k] == y) {
                                positionX[k] = -1;
                                positionY[k] = -1;
                                gameOver++; // if we are here means we are able to collect the jewels hence incrementing
                                            // gameOver.
                            }
                        }
                    } else {
                        boolean jewelFound = false;
                        for (int k = 0; k < 4; k++) {
                            if (positionX[k] == j && positionY[k] == i) {
                                System.out.print((char) ('a' + k));
                                jewelFound = true;
                                break;
                            }
                        }
                        if (!jewelFound) {
                            System.out.print(" ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public void changeUserLocationOnButtonClick(char keyPressed) {
        switch (keyPressed) {
            case 'w': // ASCII value of UP Arrow Key
                if (y != 0) {
                    noOfMoves++;
                    y--; // Changing y
                }
                break;
            case 'a': // ASCII value of LEFT Arrow Key
                if (x != 0) {
                    noOfMoves++;
                    x--; // Changing x
                }
                break;
            case 's': // ASCII value of RIGHT Arrow Key
                if (x != 49) {
                    noOfMoves++;
                    x++; // Changing x
                }
                break;
            case 'z': // ASCII value of DOWN Arrow Key
                if (y != 9) {
                    noOfMoves++;
                    y++; // Changing y
                }
                break;
            case 'q':
                gameQuit = true; // set gameQuit to true to indicate that user has quit the game
                break;
        }
    }

    public static void main(String[] args) {
        JewelCollector game = new JewelCollector();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.drawBoundary();
        if (game.gameOver == 4) {
            System.out.println("Congratulations! You have collected all the jewels!");
            break;
        }
        if (game.gameQuit) {
            System.out.println("Game Over!");
            break;
        }

       
        String input = scanner.nextLine().toLowerCase();
        if (input.length() == 1) {
            char keyPressed = input.charAt(0);
            if (keyPressed == 'w' || keyPressed == 'a' || keyPressed == 's' || keyPressed == 'z') {
                game.changeUserLocationOnButtonClick(keyPressed);
            } else if (keyPressed == 'q') {
                game.gameQuit = true;
            } else {
                System.out.println("Invalid input. Please enter w/a/s/z or q.");
            }
        } else {
            System.out.println("Invalid input. Please enter w/a/s/z or q.");
        }
        System.out.println();
    }
    scanner.close();
}
}
 
