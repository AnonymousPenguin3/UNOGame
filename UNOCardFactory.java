package shuklaRohanUNOFinalGame;

import java.util.Random;

/**
 * Factory class to create all the cards. When cards need to be created this class is called
 */
public class UNOCardFactory {
    // Creates a random card
    public static UNOCard createRandomUNOCard() {
        Random rand = new Random();
        int value = rand.nextInt(27); // 108 cards in a standard Uno deck. Can be reduced to 27 per color
        // Assigning value
        if (value > 14) { // there are 2 sets of 13 cards per color plus the 0's.
            value -= 13;
        }

        // Assigning color
        rand = new Random();
        String color = "";
        switch(rand.nextInt(4)) {
            case 0: color = "Red";
                break;
            case 1: color = "Green";
                break;
            case 2: color = "Blue";
                break;
            case 3: color = "Yellow";
                break;
        }
        // If the card is a wild card there is no color
        if (value == 13 || value == 14) {
            color = "none";
        }

        if (value >= 0 && value <=9) { // This is a number card
            return new UNONumberCard(value, color);
        } else { // This is a special card
            switch(value) {
                case 10:
                    return new UNOSkipCard(value, color);

                case 11:
                    return new UNOReverseCard(value, color);

                case 12:
                    return new UNODraw2Card(value, color);

                case 13:
                    return new UNOWildCard(value, color);

                case 14:
                    return new UNOWildDraw4Card(value, color);
            }
        }
        System.out.println("Should never reach here."); // Needs to be one of the top cards or it should be
                                                        // classified as an invalid input by the user
        return null;
    }

    public static UNOCard createWildCardWithColor(String color) { // creates a Wild special card
        return new UNOWildCard(13, color);
    }

    public static UNOCard createWild4drawCardWithColor(String color) { // creates a Wild Draw 4 special card
        return new UNOWildDraw4Card(14, color);
    }

    public static UNOCard createNumberCard() { // creates a number card
        return new UNONumberCard((int)(Math.random()*10), originalTopCardColor());
    }

    protected static String originalTopCardColor() { // for cards to be assigned random colors such as the
                                                     // original topCard or a new drawn number card
        int randomValue = (int)(Math.random()*4);
        switch(randomValue) {
            case 0:
                return "Red";
            case 1:
                return "Green";
            case 2:
                return "Blue";
            default:
                return "Yellow";
        }
    }
}
