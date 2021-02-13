package me.bumpybill.bbdf;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.MessageType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;

public class Command {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        MinecraftClient mc = MinecraftClient.getInstance();



        dispatcher.register(CommandManager.literal("bbdf")
            .then(CommandManager.literal("load")
                .executes(context -> {

                    return 1;
                })
            )
            .then(CommandManager.literal("system")
                .executes(context -> {
                    mc.inGameHud.addChatMessage(MessageType.SYSTEM,
                            new LiteralText("Loading system").setStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)),
                            mc.player.getUuid());
                    return 1;
                })
            )
           .executes(context -> {
                mc.inGameHud.addChatMessage(MessageType.SYSTEM,
                    new LiteralText("Please provide a subcommand.").setStyle(Style.EMPTY.withColor(Formatting.RED)),
                    mc.player.getUuid());

                return 0;
           })
        );
    }
}
