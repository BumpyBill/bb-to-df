package me.bumpybill.bbdf;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class Command {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("bbdf").executes(context -> {
            System.out.println(context.getCommand());
            return 1;
        }));
    }
}
