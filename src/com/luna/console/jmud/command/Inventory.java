/*
 * Inventory.java
 *
 * Created on December 13, 2007, 5:09 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.luna.console.jmud.command;

import com.luna.console.jmud.Player;
import com.luna.console.jmud.PlayerChannel;
import com.luna.console.jmud.Room;
import com.luna.console.jmud.item.Item;
import com.luna.console.jmud.slot.Slot;

/**
 * @author root
 */
public class Inventory extends Command {

    private final PlayerChannel playerChannel;

    private final Player player;

    // private SocketChannel sc;
    private final Room room;

    // private String strTarget;

    /**
     * Creates a new instance of Inventory
     * 
     * @param pc
     *            the player channel that is executing this command
     * @param r
     *            the room from which a player is executing this command
     * @param target
     *            any parameters included in the command
     */
    public Inventory(PlayerChannel pc, Room r, String target) {

        this.playerChannel = pc;
        this.player = pc.getPlayer();
        // this.sc = pc.getSocketChannel();
        this.room = r;
        // this.strTarget = target;
    }

    @Override
    public boolean exec() {

        boolean firstItem = true;
        StringBuilder msg = new StringBuilder("Items you have: ");

        // whip through each slot and add item descriptions
        for (Slot slot : player.getSlots()) {

            // DEBUG:
            // System.out.println("Number of items in slot: " +
            // slot.getItems().size());

            for (Item item : slot.getItems()) {
                // DEBUG:
                // System.out.println("Inventory.exec() - item is " + (item ==
                // null ? "null" : "not null"));

                if (item != null) {
                    if (firstItem) {
                        firstItem = false;
                    } else {
                        msg.append(", ");
                    }
                    msg.append(item.getName());
                }
            }
        }
        // tack on the newline
        msg.append(CRLF).append(room.getExits()).append(CRLF).append(player.getPrompt());

        // now send back what we found to the player
        try {
            playerChannel.sendMessage(msg.toString());
        } catch (Exception e) {
            System.out.println("Couldn't print inventory for " + player.getName());
        }

        return true;
    }

}
