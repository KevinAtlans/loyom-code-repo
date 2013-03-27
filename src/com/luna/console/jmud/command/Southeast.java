package com.luna.console.jmud.command;

import com.luna.console.jmud.PlayerChannel;
import com.luna.console.jmud.Room;

/*
 * Southeast.java
 *
 * Created on March 28 2003 12:26 PM
 *
 * History
 *
 * Programmer:     Change:                                           Date:
 * ----------------------------------------------------------------------------------
 * Chris M         Cleaned up comments                               Feb 14, 2007
 */

/**
 * Executable command Southeast: moves a player to the room southeast of their
 * current room, if such a room exists.
 * 
 * @author Chris Maguire
 * @version 0.1
 */

public class Southeast extends Direction {

    private static final String TARGET_DIRECTION = "southeast";

    private static final String SOURCE_DIRECTION = "northwest";

    private final Room room;

    private final PlayerChannel playerChannel;

    public Southeast(PlayerChannel pc, Room r, String target) {

        super(pc, r);
        this.room = r;
        this.playerChannel = pc;
    }

    @Override
    public Room getTargetRoom() {

        return room.southeast;
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