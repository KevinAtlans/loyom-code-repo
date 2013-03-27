/*
 * Hand.java
 *
 * Created on December 9, 2007, 5:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.luna.console.jmud.slot;

import java.util.LinkedList;
import java.util.List;

import com.luna.console.jmud.item.Item;

/**
 * @author root
 */
public abstract class MultiSlot extends Slot {

    public static final int MAX_BULK = 10;

    public static final int MAX_ITEMS = 2;

    private final List<Item> items;

    private String name;

    /**
     * Creates a new instance of Finger
     * 
     * @param name
     *            name of the slot
     */
    public MultiSlot(String name) {

        super(name);
        items = new LinkedList<Item>();
    }

    @Override
    public final int itemCount() {

        return items.size();
    }

    @Override
    public boolean isFull() {

        return itemCount() == MAX_ITEMS;
    }

    @Override
    public boolean isEmpty() {

        return itemCount() == 0;
    }

    @Override
    public final boolean hasItem(Item item) {

        return items.contains(item);
    }

    @Override
    public final boolean addItem(Item item) {

        if (items.size() < MAX_ITEMS) {
            items.add(item);
            return true;
        }
        return false;
    }

    /**
     * Go through all the items and return the first one that matches the name
     */
    @Override
    public final Item removeItem(String name) {

        for (Item i : items) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public final List<Item> getItems() {

        return items;
    }

    @Override
    public boolean isGrabber() {

        return false;
    }

}
