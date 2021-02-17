package shuklaRohanUNOFinalGame;

/**
 * Represents a Draw 2 Card. This also skips the turn of the opponent
 */
public class UNODraw2Card extends UNOCard{
    public UNODraw2Card(int v, String c) {
        super(v, c);
    }

    @Override
    protected String toCardName() {
        return "Draw 2";
    }

    @Override
    public TurnResult playCard(Player cardPlayer, Player opponent) {
        System.out.println("Drawing 2 cards for opponent player...");
        opponent.draw(2);
        return new TurnResult(true, this, false);
    }
}
