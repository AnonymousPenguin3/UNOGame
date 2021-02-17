package shuklaRohanUNOFinalGame;

/**
 * Represents an UNO Card - every card has certain color, value, and rules on its action
 */
public abstract class UNOCard {
    private final String color;
    private final int value;

    public UNOCard(int v, String c) {
        value = v;
        color = c;
    }

    /**
     * Returns the face of the card (what the player will see)
     * Ex. [Red 5]
     */
    public String getFace() {
        String face = "[";
        if (!color.equals("none") && value < 13) {
            face += this.color;
        }
        face += toCardName();
        face += "]";
        return face;
    }

    // Returns a printable card String for special cards
    protected abstract String toCardName();

    protected int getValue() {
        return value;
    }

    // Determines if you can place this card on top of a given card
    // The color needs to be specified because if a wild card was chosen in the previous round, the color would have changed, but the card staying the same
    public boolean checkValidCardToPlay(UNOCard currentTopCardInMiddlePile) {
        // color is same so it is a valid card
        if (this.color == currentTopCardInMiddlePile.color) {
            return true;
        }

        // value is same so it is a valid card
        if (this.value == currentTopCardInMiddlePile.value) {
            // 13 and 14 are wild so they will match
            return true;
        }

        // Wild cards - can be thrown irrespective of top card
        if (this.color == "none") {
            return true;
        }

        // no matching color, value, or wild card so it is not playable.
        return false;
    }

    // Producing action and playing card
    public abstract TurnResult playCard(Player cardPlayer, Player opponent);
}
