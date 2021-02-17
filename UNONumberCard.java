package shuklaRohanUNOFinalGame;

/**
 * Represents all number cards from 1 - 9. No special action of value so they are all in one class
 */
public class UNONumberCard extends UNOCard{
    public UNONumberCard(int v, String c) {
        super(v, c);
    }

    @Override
    protected String toCardName() {
        return String.valueOf(getValue());
    }

    @Override
    public TurnResult playCard(Player cardPlayer, Player opponent) {
        return new TurnResult(false, this, false);
    }
}
