package fr.starweizz.BreakBuddingAmethyst.Command;

import fr.starweizz.BreakBuddingAmethyst.Command.Sub.Reload;
import fr.starweizz.BreakBuddingAmethyst.Utils.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BreakBuddingAmethyst implements CommandExecutor, TabCompleter {

    private final ArrayList<BreakBuddingAmethystSubCommand> BreakBuddingAmethystSubCommand = new ArrayList<>();

    public BreakBuddingAmethyst() {
        this.BreakBuddingAmethystSubCommand.add(new Reload());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length > 0) {
            for (BreakBuddingAmethystSubCommand commands : this.BreakBuddingAmethystSubCommand.toArray(new BreakBuddingAmethystSubCommand[0])) {
                if (strings[0].equals(commands.getName())) {
                    try {
                        commands.perform(commandSender, strings);
                    } catch (IOException | SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else {
            commandSender.sendMessage(Message.chatFormatter("&fUsage : /bba <arguments>"));
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> commands = new ArrayList<>();
        if (strings.length == 1) {
            commands.add("reload");
            return commands;
        }
        return commands;
    }
}
