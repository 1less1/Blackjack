package blackjack;

import java.util.Scanner;

public class GameDriver {

    public static void main (String args[]) {

        Scanner shoeSizeQuestion = new Scanner(System.in);
        System.out.println("How many decks do you want in the shoe?");
        Integer shoeSize = Integer.valueOf(shoeSizeQuestion.nextLine());
        Game g = new Game(shoeSize);

        while (true) {

            Scanner newRoundQuestion = new Scanner(System.in);
            System.out.println("Do you want to play a round [y] or [n]?");
            String newRound  = newRoundQuestion.nextLine();

            if (newRound.equals("y")) {
                g.playRound(true);
            } else {
                g.playRound(false);
                g.displayRecords();
                break;
            }

        }



    }
}
