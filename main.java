 import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("---------- WELCOME TO UNO GAME ------------\n\n");

        // Create game
        Game game = new Game();

        // Ask number of players (2-4)
        int numPlayers = 0;
        while (numPlayers < 2 || numPlayers > 4) {
            System.out.print("Enter number of players (2-4): ");
            numPlayers = scanner.nextInt();
            scanner.nextLine(); 
        }

        // Add players
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String name = scanner.nextLine();
            game.addPlayer(new Player(name));
        }

        // Start game
        game.startGame();

        // Main game loop
        game.play();

        System.out.println("\n-------------- GAME OVER --------------");


        scanner.close();
    }

   
}
 
