package com.luna.console.jmud.command;

import java.nio.channels.SocketChannel;

import com.luna.console.jmud.Player;
import com.luna.console.jmud.PlayerChannel;
import com.luna.console.jmud.Room;

/*
 * ReadMap.java
 *
 * Created on Jun 29, 2005
 *
 * History
 *
 * Programmer:     Change:                                           Date:
 * ----------------------------------------------------------------------------------
 * Chris M         Cleaned up comments                               Feb 13, 2007
 *
 */

/**
 * @author chrism
 * @version 0.1
 *          <p/>
 *          TODO Maybe tell the room that the player is looking at their map
 */
public class ReadMap extends Command {

    private final PlayerChannel playerChannel;

    private final Player player;

    private SocketChannel sc;

    private final Room room;

    /**
     * Construct an east command
     * 
     * @param pc
     *            The PlayerChannel to move east
     * @param r
     *            The current room
     * @param target
     *            Not used, but all command constructors must have all three
     *            parameters
     */
    public ReadMap(PlayerChannel pc, Room r, String target) {

        this.playerChannel = pc;
        this.player = pc.getPlayer();
        this.room = r;
        // we don't need target
    }

    /**
     * Display a map of the rooms that a player has visited
     * 
     * @return True if the command is finished, false if it needs to be put back
     *         in the queue to be repeated
     */
    @Override
    public boolean exec() {

        Map map = new Map();
        map.loadRooms(player.getID());
        map.fillMap();

        try {
            // print out the map
            playerChannel.sendMessage(CRLF + map.toString() + CRLF + player.getPrompt());
        } catch (Exception e) {
            System.out.println("Send map and prompt failed:\n\r" + e.getMessage());
        }

        return true;
    }

}
