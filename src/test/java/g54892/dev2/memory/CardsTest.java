/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.dev2.memory;

import static java.lang.String.valueOf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Yassin Talhaoui.
 */
public class CardsTest {
    
    public CardsTest() {
    }
    
    /**
     * Test of the constructor of class Cards.
     */
    @Test
    public void testConstructor(){
        System.out.println("Constructor");
         Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Cards card = new Cards(-1);
        });
    }

    /**
     * Test of reveal method, of class Cards.
     */
    @Test
    public void testReveal() {
        System.out.println("reveal.");
        Cards instance = new Cards(0);
        instance.reveal();
    }

    /**
     * Test of toString method, of class Cards.
     */
    @Test
    public void testToString() {
        System.out.println("toString with a hidden card.");
        Cards instance = new Cards(0);
        String expResult = "?";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
       /**
     * Test of toString method, of class Cards.
     */
    @Test
    public void testToString2() {
        System.out.println("toString with a revealed card.");
        Cards instance = new Cards(0);
        instance.reveal();
        String expResult = valueOf(instance);
        String result = instance.toString();
        assertEquals(expResult, result); 
    }

    /**
     * Test of hashCode method, of class Cards.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Cards instance = new Cards(0);
        Cards instance2 = new Cards(0);
        assertTrue(instance.equals(instance2) && instance2.equals(instance));
        assertTrue(instance.hashCode() == instance2.hashCode());
    }

    /**
     * Test of equals method, of class Cards.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Cards(0);
        Cards instance = new Cards(0);
        Cards instance2 = new Cards(1);
        assertTrue(instance.equals(instance));
        assertTrue(instance.equals(obj));
        assertFalse(instance2.equals(obj));
    }
}
