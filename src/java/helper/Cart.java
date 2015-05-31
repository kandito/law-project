/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import java.util.HashMap;

/**
 *
 * @author Kandito Agung
 */
public class Cart {
    HashMap<Integer, Integer> cartItem;
    
    
    public Cart() {
        this.cartItem = new HashMap<Integer, Integer>();
    }

    public HashMap<Integer, Integer> getCartItem() {
        return cartItem;
    }
    
    public void addCart(int id, int amount) {
        this.cartItem.put(id, amount);
    }

    public void removeCart(int id) {
        this.cartItem.remove(id);
    }
}
