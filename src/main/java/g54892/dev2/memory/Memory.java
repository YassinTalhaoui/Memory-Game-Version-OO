/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.dev2.memory;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * This class coordinates the actions of the game with the player actions.
 * @author Talhaoui Yassin
 */
public class Memory {
    
   private final Game game;

   /**
    * Constructor of Memory.
    * @param nbPairs an integer that represents the number of pairs 
    * of cards.
    */
    public Memory(int nbPairs) {
        this.game = new Game(nbPairs);
    }
   
    /**
     * Asks for a position and returns the value of the card at the given
     * position.
     *
     * @return the position of the card.
     */
   public int askPosition(){
       int pos = MemoryUtil.lectureRobuste(game.getCards());
        int i = 0;
        while (i != pos) {
            i++;
        }
        System.out.println("La carte en position " + pos + " est " + 
                game.getCards()[pos].getValue());
        return pos; 
   }
   
   /**
    * Starts the game, continue while all the cards aren't revealed and
    * returns the number of rounds. 
    * @return the number of rounds.
    */
   public int playMemory() {
       int tours = 0;
       game.shuffle();
       while(!game.isGameOver()){
       game.displayDeck();
       int pos1 = askPosition();
       int pos2 = askPosition();
       game.checkPositions(pos1, pos2);
       tours++;
       }
       return tours;
   }
   
   public static void main(String[] args) throws UnsupportedEncodingException {
       System.setOut(new PrintStream(System.out, true, "UTF8"));
       Scanner kbd = new Scanner(System.in);
       System.out.println("Avec combien de paires voulez-vous jouer ?");
       int nbPairs = kbd.nextInt();
       Memory m = new Memory(nbPairs);
       System.out.println("Vous avez términé la partie en "+m.playMemory()+" tours.");
   }
}
