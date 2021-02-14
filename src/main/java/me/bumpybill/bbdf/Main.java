package me.bumpybill.bbdf;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;


public class Main implements ModInitializer {

    public final static String MOD_ID = "bbdf";

    @Override
    public void onInitialize() {
        System.out.println("\"BB To DF\" Initialized");

        CommandRegistrationCallback.EVENT.register(Command::register);
    }


}
