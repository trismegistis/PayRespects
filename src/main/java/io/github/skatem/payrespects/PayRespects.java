package io.github.skatem.payrespects;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.spec.CommandSpec;

@Plugin(
        id = "payrespects",
        name = "PayRespects",
        description = "Type /f to pay respects when a player dies.",
        authors = {
                "skatem"
        }
)
public class PayRespects {

    @Inject
    private Logger logger;


    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        // Hey! The server has started!
        this.logger.info("Hello world!");
        // Try loading some configuration settings for a welcome message to players
        // when they join!
    }

    @Listener
    public void onPlayerJoin(ClientConnectionEvent.Join event, @Getter("getTargetEntity") Player player) {
        // The text message could be configurable, check the docs on how to do so!
        player.sendMessage(Text.of(TextColors.AQUA, TextStyles.BOLD, "Hi " + player.getName()));
    }

    @Listener
    public void  OnGameInit(GameInitializationEvent event) {
        CommandSpec PayRespectsCommand = CommandSpec.builder()
                .description(Text.of("Pay Respects Command"))
                .permission("myplugin.command.payrespects")
                .executor(new PayRespectsCommand())
                .build();
        Sponge.getCommandManager().register(this, PayRespectsCommand, "f", "PayRespects");
    }
}