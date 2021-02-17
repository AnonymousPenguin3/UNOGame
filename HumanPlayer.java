package shuklaRohanUNOFinalGame;

/**
 * Represents a human player - asks for human inputs
 */
public class HumanPlayer extends Player {

    @Override
    protected String askToChooseAColor() {
        String userColor;
        do { // Repeats every time the user doesn't input a valid color
            System.out.print("\nEnter the color you want: ");
            userColor = TextIO.getlnString().toLowerCase();
        } while (!isValidColor(userColor));

        if (userColor.startsWith("r")) {
            return "Red";
        }

        if (userColor.startsWith("g")) {
            return  "Green";
        }

        if (userColor.startsWith("b") ) {
            return  "Blue";
        }
        return "Yellow";
    }

    @Override
    public TurnResult playTurn(UNOCard topCard, Player opponent) {
        int choiceIndex = askUserToPickCardToPlay(); // take user card to play
        if (choiceIndex == playerHand.size() + 1) { // user asked to quit the game
            return new TurnResult(false, null, true);
        }

        if (choiceIndex == playerHand.size()) { // user asking to draw
            draw(1);
            return new TurnResult(false, topCard, false);
        }

        if (playerHand.get(choiceIndex).checkValidCardToPlay(topCard)) {
            return playTheChosenCardFromTheHand(opponent, choiceIndex);
        } else {
            // still player's turn as wrong card chosen
            System.out.println("Invalid choice. Please choose a valid card or draw a card.");
            return new TurnResult(true, topCard, false);
        }
    }

    private int askUserToPickCardToPlay() {
        // Displaying user's deck
        System.out.println("Your turn! Your choices:");
        for (int i = 0; i < playerHand.size(); i++) {
            System.out.print(String.valueOf(i + 1) + ". " +
                    ((UNOCard) playerHand.get(i)).getFace() + "\n");
        }
        System.out.println(String.valueOf(playerHand.size() + 1 ) + ". " + "Draw card" + "\n" +
                String.valueOf(playerHand.size() + 2) + ". " + "Quit");

        // Repeats every time the user doesn't input a number
        int input;
        do {
            System.out.print("\nPlease input the number of your choice: ");
            input = TextIO.getlnInt();
        } while (input < 0 || input > (playerHand.size() + 2));

        // The choices were incremented to make them seem more natural (i.e not starting with 0)
        return input - 1;
    }

    // make sure user entered a valid color
    private static boolean isValidColor(String userColor) {
        return userColor.toLowerCase().contains("red") || userColor.toLowerCase().startsWith("green") ||
                userColor.toLowerCase().contains("blue") || userColor.toLowerCase().contains("orange");
    }


}
