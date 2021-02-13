package me.bumpybill.bbdf;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

import java.io.Console;

public class Main implements ModInitializer {
    @Override
    public void onInitialize() {
        System.out.println("\"BB To DF\" Loaded");

        CommandRegistrationCallback.EVENT.register(Command::register);
    }
}
