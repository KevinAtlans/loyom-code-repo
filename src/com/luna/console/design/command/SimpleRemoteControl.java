package com.luna.console.design.command;

import com.luna.console.design.command.command.Command;

public class SimpleRemoteControl {

    private Command slot;

    public void setCommand(Command command) {

        this.slot = command;
    }

    public void buttonWasPressed() {

        slot.execute();
    }
}
