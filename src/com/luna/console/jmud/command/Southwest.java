package com.luna.console.jmud.command;

import com.luna.console.jmud.PlayerChannel;
import com.luna.console.jmud.Room;

/*
 * Southwest.java
 *
 * Created on March 28 2003 12:26 PM
 */

/**
 * Executable command Southwest
 * 
 * @author Chris maguire
 * @version 0.1
 */

public class Southwest extends Direction {

    private static final String TARGET_DIRECTION = "southwest";

    private static final String SOURCE_DIRECTION = "northeast";

    private final Room room;

    private final PlayerChannel playerChannel;

    public Southwest(PlayerChannel pc, Room r, String target) {

        super(pc, r);
        this.room = r;
        this.playerChannel = pc;
    }

    @Override
    public Room getTargetRoom() {

        return room.southwest;
    }

    @Override
    public String getTargetDirection() {

        return TARGET_DIRECTION;
    }

    @Override
    public String getSourceDirection() {

        return SOURCE_DIRECTION;
    }

}