package shuklaRohanUNOFinalGame;

/**
 * Represents a Wild Draw 4 Card. On top of that it draws 4 cards to opponent.
 * Just like all draw cards this skips the opponents turn
 */
public class UNOWildDraw4Card extends UNOCard{
    public UNOWildDraw4Card(int v, String c) {
        super(v, c);
    }

    @Override
    protected String toCardName() {
        return "Wild Draw 4";
    }

    @Override
    public TurnResult playCard(Player cardPlayer, Player opponent) {
        System.out.println("Drawing 4 cards for opponent player...");
        opponent.draw(4);
        UNOCard plus4Wild = UNOCardFactory.createWild4drawCardWithColor(cardPlayer.askToChooseAColor());
        return new TurnResult(true, plus4Wild, false);
    }
}
