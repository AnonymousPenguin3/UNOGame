package shuklaRohanUNOFinalGame;

import java.util.ArrayList;

/**
 * Represents the common functionality between human and computer player.
 */
public abstract class Player {
    protected ArrayList<UNOCard> playerHand = new ArrayList<UNOCard>();

    public Player() {
        // every player starts with seven cards hand or deck
        draw(7);
    }

    // abstract method that plays the turn - human and computer plays turn differently
    public abstract TurnResult playTurn(UNOCard topCard, Player opponent);

    // Abstract method that ask to choose a color after a wild card played
    // Human and computer has different logic
    protected abstract String askToChooseAColor();

    // pick the chosen card from the hand and play it
    protected TurnResult playTheChosenCardFromTheHand(Player opponentDeck, int choiceIndex) {
        UNOCard topCard = playerHand.get(choiceIndex);
        playerHand.remove(choiceIndex);

        // Producing the action of a card
        return topCard.playCard(this, opponentDeck);
    }

    // For drawing cards
    protected void draw(int cards) {
        for (int i = 0; i < cards; i++) {
            playerHand.add(UNOCardFactory.createRandomUNOCard());
        }
    }

    // check if hand is empty
    public boolean isTheHandEmpty() {
        return playerHand.isEmpty();
    }
}
