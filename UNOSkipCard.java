package shuklaRohanUNOFinalGame;

/**
 * Represents a Skip Card. This skips the turn of the opponent
 */
public class UNOSkipCard extends UNOCard{
    public UNOSkipCard(int v, String c) {
        super(v, c);
    }

    @Override
    public String toCardName() {
        return "Skip";
    }

    @Override
    public TurnResult playCard(Player cardPlayer, Player opponent) {
        return new TurnResult(true, this, false);
    }
}
