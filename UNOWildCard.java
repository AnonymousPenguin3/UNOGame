package shuklaRohanUNOFinalGame;

/**
 * Represents a Wild Card. This allows user to change the color but does not skip the opponent's turn.
 */
public class UNOWildCard extends UNOCard{
    public UNOWildCard(int v, String c) {
        super(v, c);
    }

    @Override
    protected String toCardName() {
        return "Wild";
    }

    @Override
    public TurnResult playCard(Player cardPlayer, Player opponent) {
        UNOCard wild = UNOCardFactory.createWildCardWithColor(cardPlayer.askToChooseAColor());
        return new TurnResult(false, wild, false);
    }
}
