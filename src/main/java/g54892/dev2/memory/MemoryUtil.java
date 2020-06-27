/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.dev2.memory;

import java.util.Scanner;

/**
 * This class is an utility class that contains only static methods
 *
 * @author Talhaoui Yassin.
 */
public class MemoryUtil {

    /**
     * Displays the current status of the maps. A picked-up map is indicated by
     * its value. A "?" indicates a card not yet picked up.
     *
     * @param cards the cards.
     */
    public static void displayCards(Cards[] cards) {
        System.out.print("Les cartes: ");
        for (int i = 0; i < cards.length; i++) {
            System.out.print((cards[i].isHidden() ? cards[i] : "?") + " ");
        }
        System.out.println();
    }

    /**
     * Asks for an other integer while the given value doesn't match.
     *
     * @param cards an array of integers.
     * @return the position.
     */
    public static int lectureRobuste(Cards[] cards) {
        int pos = lectureClavier(cards);
        while (pos >= cards.length || pos < 0) {
            System.out.println("Mauvaise entrée !!!");
            pos = lectureClavier(cards);
        }
        return pos;
    }

    /**
     * Reads an integer from the keyboard and returns it.
     *
     * @param cards an array of integers.
     * @return the readen integer.
     */
    public static int lectureClavier(Cards[] cards) {
        System.out.println("Entrez une position de carte entre " + 0 + " et "
                + (cards.length - 1));
        Scanner kbd = new Scanner(System.in);
        int nb = kbd.nextInt();
        return nb;
    }
}