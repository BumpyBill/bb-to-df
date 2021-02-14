package me.bumpybill.bbdf;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.MinecraftClient;

import net.minecraft.network.MessageType;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import net.minecraft.world.GameMode;


public class Command {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        MinecraftClient mc = MinecraftClient.getInstance();
        GameMode gamemode = mc.getInstance().getNetworkHandler().getPlayerListEntry(mc.player.getGameProfile().getId()).getGameMode();

        dispatcher.register(CommandManager.literal("bbdf")
            .then(CommandManager.literal("load")
                .executes(context -> {
                    if (gamemode == GameMode.CREATIVE) {
                        return 1;
                    } else {
                        return 0;
                    }
                })
            )
            .then(CommandManager.literal("system")
                .executes(context -> {
                    if (gamemode == GameMode.CREATIVE) {
                        mc.inGameHud.addChatMessage(MessageType.SYSTEM,
                             new LiteralText("Loading system")
                                  .setStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)),
                                  mc.player.getUuid());

                        return 1;
                    } else {
                        mc.inGameHud.addChatMessage(MessageType.SYSTEM,
                                new LiteralText("Required gamemode: Creative")
                                        .setStyle(Style.EMPTY.withColor(Formatting.RED)),
                                        mc.player.getUuid());
                        return 0;
                    }
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
