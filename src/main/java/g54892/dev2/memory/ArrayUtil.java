/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.dev2.memory;

import java.util.Random;

/**
 * This class is an utility class that contains only static methods
 *
 * @author Talhaoui Yassin.
 */
public class ArrayUtil {

    /**
     * Shuffles the given array.
     *
     * @param array an array of cards.
     */
    public static void shuffle(Cards[] array) {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            swap(array, i, index);
        }
    }

    /**
     * Exchanges the contents of two table boxes. Exchanges in the array
     * <code>array</code> the contents of the cells in positions
     * <code>pos1</code> and <code>pos2</code>. These 2 positions are supposed
     * to be correct.
     *
     * @param array the board of which we swap 2 squares.
     * @param pos1 the position of the first box to be exchanged.
     * @param pos2 the position of the second box to be exchanged.
     * @throws IllegalArgumentException if at least one of the positions is
     * strictly negative.
     */
    public static void swap(Cards[] array, int pos1, int pos2) {
        if (pos1 < 0 || pos2 < 0) {
            throw new IllegalArgumentException("Les positions doivent être des "
                    + "entiers positifs " + pos1 + " " + pos2);
        }
        Cards savedValue = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = savedValue;
    }
}