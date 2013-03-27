package com.luna.console.design.command;

import com.luna.console.design.command.command.LightOffCommand;
import com.luna.console.design.command.command.LightOnCommand;
import com.luna.console.design.command.object.Light;

public class CommandLauncher {

    /**
     * @param args
     */
    public static void main(String[] args) {

        SimpleRemoteControl control = new SimpleRemoteControl();
        Light light = new Light("Light");
        LightOnCommand lightOn = new LightOnCommand(light);
        control.setCommand(lightOn);
        control.buttonWasPressed();

        LightOffCommand lightOff = new LightOffCommand(light);
        control.setCommand(lightOff);
        control.buttonWasPressed();
    }
}
