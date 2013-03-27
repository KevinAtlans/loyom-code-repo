/*
 * Hand.java
 *
 * Created on December 9, 2007, 5:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.luna.console.jmud.slot;

/**
 * @author root
 */
public class Hand extends SingleSlot {

    private static final boolean IS_GRABBER = true;

    /**
     * Creates a new instance of Hand
     * 
     * @param name
     *            the name of the hand (e.g. left hand)
     */
    public Hand(String name) {

        super(name);
    }

    @Override
    public int maxBulk() {

        return MAX_BULK;
    }

    @Override
    public boolean isGrabber() {

        return IS_GRABBER;
    }
}
