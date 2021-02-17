package shuklaRohanUNOFinalGame;

/**
 * UNOGame plays well-known UNO game between a computer and human player.
 */
public class UNOGame {
    private final Player computerPlayer = new ComputerPlayer();
    private final Player humanPlayer = new HumanPlayer();

    private UNOCard topCard; // card on top of the "pile"
    private int win = 0; // 0 - no result (starting position too); 1 - win; -1 - loss.

    private UNOGame() {
        topCard = originalTopCard(); // card on top of the "pile"
    }

    public static void main(String[] argv) {
        // ask to run the game in a loop
        String input;
        do {
            UNOGame game = new UNOGame();
            game.play();

            System.out.print("\nDo you want to play again?: ");
            input = TextIO.getlnString();
        } while(!input.toLowerCase().contains("n"));

        System.out.println("You have finished playing UNO. Thanks for playing.");
    }

    public void play() {
        System.out.println("\nWelcome to Uno! Creating hands...");
        System.out.println("Here are the rules:");
        System.out.println("1. You and your opponent will start with a hand containing 7 cards");
        System.out.println("2. To place a card it must have the same color or the same number or " +
                "the same action as top card");
        System.out.println("3. To place a card enter the number that is ");
        System.out.println("4. You will have the chance to draw a card or to quit the game at all times ");

        Player currentPlayer = humanPlayer; // first turn is player's turn
        while (!isGameOver()) {
            System.out.println("\nThe top card is: " + topCard.getFace());

            // current player play's the turn and returns the result
            TurnResult turnResult = currentPlayer.playTurn(topCard, otherPlayer(currentPlayer));
            if (!turnResult.isPlayerContinuing()) {
                // current player turn ends - other player turn starts
                currentPlayer = otherPlayer(currentPlayer);
            }
            if (turnResult.quit()) {
                win = -1; // human player quit (computer never quits)
            }
            topCard = turnResult.getNewTopCard();
        }

        printGameWinLossMessage(win);
    }

    private Player otherPlayer(Player currentPlayer) {
        return currentPlayer == humanPlayer ? computerPlayer : humanPlayer;
    }

    private boolean isGameOver() {
        if (win != 0) {
            return false;
        }

        // If decks are empty
        if (humanPlayer.isTheHandEmpty()) {
            win = 1;
            return true;
        } else if (computerPlayer.isTheHandEmpty()) {
            win = -1;
            return true;
        }
        return false;
    }

    private void printGameWinLossMessage(int win) {
        // Results
        if (win == 1) {
            System.out.println("You won this round!! :) ");
        } else {
            System.out.println("You lost this round. :( ");
        }
    }

    private static UNOCard originalTopCard() {
        return UNOCardFactory.createNumberCard();
    }
}
