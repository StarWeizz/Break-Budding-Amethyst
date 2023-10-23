package fr.starweizz.BreakBuddingAmethyst.Command.Sub;

import fr.starweizz.BreakBuddingAmethyst.Command.BreakBuddingAmethystSubCommand;
import fr.starweizz.BreakBuddingAmethyst.Config.Files;
import fr.starweizz.BreakBuddingAmethyst.Utils.Message;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static fr.starweizz.BreakBuddingAmethyst.Config.Config.config;

public class Reload extends BreakBuddingAmethystSubCommand {

    public String getName() {
        return "reload";
    }

    public String getDescription() {
        return "reload config";
    }

    public String getSyntax() {
        return "/bba reload";
    }

    public void perform(CommandSender commandSender, String[] args) {
        if (commandSender instanceof Player) {
            Player player = ((Player) commandSender).getPlayer();
            boolean hasPermissionAndArgsLengthOne = player.hasPermission("bba.admin") && args.length == 1;
            (hasPermissionAndArgsLengthOne ? player : commandSender)
                    .sendMessage(Message.chatFormatter(hasPermissionAndArgsLengthOne ? config.getString("reloaded") : config.getString("no-permission")));
        } else {
            if (args.length == 1) {
                Files.reload();
                commandSender.sendMessage(Message.chatFormatter(config.getString("reloaded")));
            }
        }


    }
}
