package shuklaRohanUNOFinalGame;

/**
 * Handles all the actions that happen at the end of a turn such as switching player turns,
 * switching topCards, quitting, and continuing a players turn if required.
 */
public class TurnResult {
    private final boolean isPlayerContinuing;
    private final UNOCard newTopCard;
    private final boolean isGameOver;

    public TurnResult(boolean isPlayerContinuing, UNOCard newTopCard, boolean isGameOver) {
        this.isPlayerContinuing = isPlayerContinuing;
        this.newTopCard = newTopCard;
        this.isGameOver = isGameOver;
    }

    // checks if player keeps turn or finishes turn
    public boolean isPlayerContinuing() {
        return isPlayerContinuing;
    }

    // replaces olf topcard with the new topcard
    public UNOCard getNewTopCard() {
        return newTopCard;
    }

    // end the game immediately
    public boolean quit() {
        return isGameOver;
    }
}
