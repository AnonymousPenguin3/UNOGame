package shuklaRohanUNOFinalGame;

/**
 * Represents a Reverse Card. This acts as a skip card in 2 player UNO.
 */
public class UNOReverseCard extends UNOCard{
    public UNOReverseCard(int v, String c) {
        super(v, c);
    }

    @Override
    protected String toCardName() {
        return "Reverse";
    }

    @Override
    public TurnResult playCard(Player cardPlayer, Player opponent) {
        return new TurnResult(true, this, false);
    }
}
