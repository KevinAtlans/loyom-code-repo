package com.luna.console.design.command.command;

import com.luna.console.design.command.object.Light;

public class LightOnCommand implements Command {

    private final Light light;

    public LightOnCommand(Light light) {

        this.light = light;
    }

    @Override
    public void execute() {

        light.on();
    }
}
