/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.dev2.memory;

import static java.lang.String.valueOf;

/**
 * This class concerns everything that is relates to a map.
 *
 * @author Talhaoui Yassin.
 */
public class Cards {

    private boolean hidden;
    private int value;

    /**
     * Constructor of Card.
     *
     * @param value an integer that represents the value of the given card.
     */
    public Cards(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Valeur invalide : " + value);
        }
        this.value = value;
        this.hidden = true;
    }

    /**
     * Simple getter of hidden.
     *
     * @return a boolean value.
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Simple getter of value.
     *
     * @return the value of the card (an integer).
     */
    public int getValue() {
        return value;
    }

    /**
     * Reveals one of the cards
     */
    public void reveal() {
        this.hidden = false;
    }

    /**
     * Return ? if the card is hidden, the value the card otherwise
     *
     * @return ? if the card is hidden, the value the card otherwise
     */
    @Override
    public String toString() {
        if (isHidden()) {
            return "?";
        } else {
            return valueOf(this.value);
        }
    }

    /**
     * Compare the hashCodes
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    /**
     * determines if two objects are equal
     *
     * @param obj an object
     * @return true if two objects are equal, false otherwise
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
        final Cards other = (Cards) obj;
        return this.value == other.value;
    }
}
