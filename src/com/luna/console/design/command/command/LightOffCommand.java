package com.luna.console.design.command.command;

import com.luna.console.design.command.object.Light;

public class LightOffCommand implements Command {

    private final Light light;

    public LightOffCommand(Light light) {

        this.light = light;
    }

    @Override
    public void execute() {

        this.light.off();
    }
}
