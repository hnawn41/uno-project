import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {

    /* attributes */
    private Deck deck;                     // draw pile
    private List<Card> discardPile;        // discard pile
    private List<Player> players;          // list of players
    private int currentPlayerIndex;        // whose turn
    private int direction;                 // 1 = clockwise, -1 = reversed
    private Color currentColor;            // active color
    private Scanner scanner;               // to scan user input

    /* ========================
       CONSTRUCTOR
       ======================== */
    public Game() {
        this.deck = new Deck();
        this.discardPile = new ArrayList<>();
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.direction = 1; // start clockwise
        this.scanner = new Scanner(System.in);
    }

    /* ========================
       SETUP
       ======================== */
    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        // shuffle deck
        deck.shuffle();
        
        // Give 7 cards to each player
        for (Player p : players) {
            for (int i = 0; i < 7; i++) {
                p.addToHand(drawFromDeck());
            }
        }

        // Flip first card
        Card firstCard = drawFromDeck();
        discardPile.add(firstCard);

        // Set initial color
        if (firstCard instanceof WildCard) {
            currentColor = Color.RED; // default choice
            System.out.println("First card is Wild → color set to RED");
        } else {
            currentColor = firstCard.getColor();
        }

        System.out.println("Game started!");
        System.out.println("First card: " + firstCard);
        System.out.println("Active color: " + currentColor);
    }

    /* ========================
       MAIN GAME LOOP
       ======================== */
    public void play() {
        boolean gameOver = false;

        while (!gameOver) {
            Player currentPlayer = getCurrentPlayer();
            displayGameState(currentPlayer);

            boolean played = false;

            while (!played) {
                System.out.println("Choose card index to play (-1 to draw): ");
                int choice = scanner.nextInt();

                if (choice == -1) {
                    // Draw one card
                    Card drawn = drawFromDeck();
                    currentPlayer.addToHand(drawn);
                    System.out.println(currentPlayer.getName() + " draws a card.");
                    break; // end turn after drawing
                }

                // Attempt to play card
                Card topCard = getCurrentCard();
                Card playedCard = currentPlayer.playCard(choice, topCard, currentColor);

                if (playedCard != null) {
                    placeOnDiscardPile(playedCard);

                    // Apply action if applicable
                    if (playedCard instanceof Actionable) {
                        ((Actionable) playedCard).apply(this);
                    }

                    // UNO announcement
                    if (currentPlayer.handSize() == 1) {
                        System.out.println(currentPlayer.getName() + " says UNO!");
                    }

                    // Win check
                    if (currentPlayer.hasWon()) {
                        System.out.println("🎉 WINNER: " + currentPlayer.getName());
                        gameOver = true;
                    }

                    played = true;
                } else {
                    System.out.println("Cannot play this card! Choose again.");
                }
            }

            if (!gameOver) {
                nextTurn();
            }
        }
    }

    /* ========================
       TURN MANAGEMENT
       ======================== */
    public void nextTurn() {
        int n = players.size();
        currentPlayerIndex = (currentPlayerIndex + direction + n) % n;
    }

    public void reverseDirection() {
        direction *= -1;
        System.out.println("Direction reversed!");
    }

    public void skipNextPlayer() {
        nextTurn();
        System.out.println("Next player skipped!");
    }

    public void drawCardsForNextPlayer(int amount) {
        int index = (currentPlayerIndex + direction + players.size()) % players.size();
        Player target = players.get(index);

        for (int i = 0; i < amount; i++) {
            target.addToHand(drawFromDeck());
        }

        System.out.println(target.getName() + " draws " + amount + " cards.");
        nextTurn();
    }

    /* ========================
       DECK MANAGEMENT
       ======================== */
    private Card drawFromDeck() {
        if (deck.isEmpty()) {
            refillDeckFromDiscard();
        }
        return deck.draw();
    }

    public void refillDeckFromDiscard() {

        // checking if enough cards to refill
        if (discardPile.size() <= 1) {
            System.out.println("Not enough cards to refill deck.");
            return;
        }

        // Keep top card, shuffle rest into deck
        Card top = discardPile.remove(discardPile.size() - 1);
        // we create a new list to avoid modifying discardPile while refilling
        List<Card> toShuffle = new ArrayList<>(discardPile);
        // clear discard pile except top card
        discardPile.clear();
        discardPile.add(top);

        deck.refill(toShuffle);

        System.out.println("Deck refilled from discard pile.");
    }

    /* ========================
       DISCARD PILE
       ======================== */
    public void placeOnDiscardPile(Card card) {
    discardPile.add(card);

    // Update color only for non-wild cards
    if (!(card instanceof WildCard)) {
        currentColor = card.getColor();
    }
}


    public Card getCurrentCard() {
        return discardPile.get(discardPile.size() - 1);
    }

    /* ========================
       COLOR HANDLING
       ======================== */
    public Color askColorChoice() {
    while (true) {
        System.out.println("Choose a color:");
        System.out.println("1- RED | 2- GREEN | 3- BLUE | 4- YELLOW");

        try {
            int choice = scanner.nextInt();

            return switch (choice) {
                case 1 -> Color.RED;
                case 2 -> Color.GREEN;
                case 3 -> Color.BLUE;
                case 4 -> Color.YELLOW;
                default -> {
                    System.out.println("Invalid number! Please choose between 1 and 4.");
                    yield null;
                }
            };

        } catch (InputMismatchException e) {
            System.out.println(" Invalid input! Please enter a number (1–4).");
            scanner.next(); 
        }
    }
}


    public void setCurrentColor(Color color) {
        this.currentColor = color;
        System.out.println("Color changed to " + color);
    }

    /* ========================
       GETTERS
       ======================== */
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    /* ========================
       DISPLAY
       ======================== */
    public void displayGameState(Player current) {
        System.out.println("\n----------------------------");
        System.out.println("Top card: " + getCurrentCard());
        System.out.println("Active color: " + getCurrentColor());
        System.out.println("Current player: " + current.getName());
        System.out.println("Your hand: " + current.getHand());
        System.out.println("----------------------------");
    }
}
