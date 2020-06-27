/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.dev2.memory;

import java.util.Arrays;

/**
 * this class concerns everything related to to the game, its rules and its
 * components (the cards).
 *
 * @author Talhaoui Yassin.
 */
public class Game {

    private Cards[] cards;

    /**
     * Constructor of Game.
     *
     * @param nbPairs an integer that represents the number of pairs of cards.
     */
    public Game(int nbPairs) {
        if (nbPairs < 3 || nbPairs > 20) {
            throw new IllegalArgumentException("Le nombre de pairs doit être "
                    + "compris entre 3 et 20");
        }
        cards = new Cards[2 * nbPairs];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Cards(i / 2 + 1);
        }
    }

    /**
     * Provides the array that contains the cards.
     *
     * @return the array of cards.
     */
    public Cards[] getCards() {
        return cards;
    }

    /**
     * Mélange le tableau.
     */
    public void shuffle() {
        ArrayUtil.shuffle(cards);
    }

    /**
     * Returns the size of the array of cards.
     *
     * @return the size (an integer).
     */
    public int getSize() {
        return cards.length;
    }

    /**
     * @param pos an integer that represents a given position of the array of
     * cards.
     * @return true if the card is hidden, false otherwise.
     */
    public boolean isHidden(int pos) {
        return cards[pos].isHidden();
    }

    /**
     * Returns the value of the card at the position pos.
     *
     * @param pos an integer that represents the position of a card in the array
     * of cards.
     * @return an integer that represents the value of the card at the given
     * position.
     */
    public int getCardValue(int pos) {
        return cards[pos].getValue();
    }

    /**
     * Cheks that the values of the cards at the two given position are the
     * same.
     *
     * @param pos1 a given position represented by an integer.
     * @param pos2 another position represented by another integer.
     * @return true if the two cards have the same value.
     */
    public boolean checkPositions(int pos1, int pos2) {
        if (pos1 == pos2) {
            throw new IllegalArgumentException("Les positions doivent être "
                    + "différentes.");
        }
        if (cards[pos1].getValue() == cards[pos2].getValue()) {
            System.out.println("Elles correspondent");
            cards[pos1].reveal();
            cards[pos2].reveal();
            return true;
        } else {
            System.out.println("Elles ne correspondent pas");
        }
        return false;
    }

    /**
     * Cheks that the game isn't over.
     *
     * @return true if all the cards are revealed, false otherwise.
     */
    public boolean isGameOver() {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].isHidden()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the corresponing hachCode for each object.
     *
     * @return the hachCode (an integer).
     */
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * Cheks that two object are equal.
     *
     * @param obj an object to compare.
     * @return true if the two objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        return Arrays.deepEquals(this.cards, other.cards);
    }

    /**
     * Returns a textual representation of the deck of cards.
     */
    public void displayDeck() {
        StringBuilder formatted = new StringBuilder().append("Voici les cartes:  ");
        for (Cards card : this.cards) {
            formatted.append(String.format("%s ", card));
        }
        System.out.println(formatted.insert(19, "[")
                .insert(19 + cards.length * 2, "]"));
    }
}
