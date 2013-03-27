package com.luna.console.jmud.command;

import java.io.IOException;
import java.nio.channels.SocketChannel;

import com.luna.console.jmud.Player;
import com.luna.console.jmud.PlayerChannel;
import com.luna.console.jmud.Room;

/*
 * Quit.java
 *
 * Created on December 20, 2003
 */

/**
 * Executable command Quit
 * <p/>
 * Provides the functionality for quitting the game.
 * 
 * @author Chris maguire
 * @version 0.1
 */

public class Quit extends Command {

    private final PlayerChannel playerChannel;

    private final Player player;

    private final SocketChannel sc;

    private final Room room;

    /**
     * @param pc
     *            The player and socket channel of the player quitting
     * @param r
     *            The room where the player is
     * @param whatever
     *            Not used, but all command constructors must have all three
     *            parameters
     */
    public Quit(PlayerChannel pc, Room r, String whatever) {

        this.playerChannel = pc;
        this.player = pc.getPlayer();
        this.sc = pc.getSocketChannel();
        this.room = r;
    }

    /**
     * Kills the players connection
     * <p/>
     * Should also save players equip, position, stats, etc.
     * 
     * @return true to signify that this command is complete.
     */
    @Override
    public boolean exec() {

        // DEBUG
        // System.out.println("Running Quit command");
        synchronized (player) {
            // remove the player from the map
            room.remove(playerChannel);
        }

        // close the socket channel
        // Should cancel all of the socket channel's keys
        try {
            // this alone will not disconnect the client
            // sc.close();
            // maybe this will help
            sc.socket().shutdownInput();
            sc.socket().shutdownOutput();
            sc.socket().close();
            sc.close();
        } catch (IOException ioe) {
            // do nothing
            System.out.println("sc.close failed: " + ioe.getMessage());
        }

        // notify everyone in the player's last room that the player has left
        try {
            room.sendMessageToAll("\n\r" + player.getName() + " has disconnected\n\r");
        } catch (Exception e) {
            System.out.println("Send \"\\n\\r[player name] has disconnected\\n\\r\" failed:\n\r"
                    + e.getMessage());
        }
        return true;
    }
}
