package shuklaRohanUNOFinalGame;

/**
 * Represents a Computer Player - one that cannot give inputs.
 * All input related things have been randomized or made to be very simple AI
 */
public class ComputerPlayer extends Player {
    @Override
    protected String askToChooseAColor() {
        // does not ask but rather chooses a random color of the 4
        return UNOCardFactory.originalTopCardColor();
    }

    @Override
    public TurnResult playTurn(UNOCard topCard, Player opponent) {
        // Displaying computer hands size
        System.out.println("My turn! I have " + String.valueOf(playerHand.size() )
                + " cards left!" + ((playerHand.size() == 1) ? "...Uno!":"") );

        // pick the first card that can be played from the hand
        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i).checkValidCardToPlay(topCard)) {
                System.out.println("I played: " + playerHand.get(i).getFace());
                return playTheChosenCardFromTheHand(opponent, i);
            }
        }

        // can not play anything - just draw another card
        draw(1);
        return new TurnResult(false, topCard, false);
    }
}
