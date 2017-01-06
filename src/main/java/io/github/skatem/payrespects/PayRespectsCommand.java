package io.github.skatem.payrespects;

/**
 * Created by mitch on 1/5/2017.
 */

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.command.source.CommandBlockSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;


public class PayRespectsCommand implements CommandExecutor{
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if(src instanceof Player) {
            Player player = (Player) src;
            Sponge.getServer().getBroadcastChannel().send(Text.of(player.getName() + "pays their respects."));
        }
        else if(src instanceof ConsoleSource) {
            Sponge.getServer().getBroadcastChannel().send(Text.of("The Server pays its respects."));
        }
        else if(src instanceof CommandBlockSource) {
            Sponge.getServer().getBroadcastChannel().send(Text.of("A humble command block pays its respects."));
        }

    return CommandResult.success();
    }
}
