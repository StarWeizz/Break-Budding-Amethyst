package fr.starweizz.BreakBuddingAmethyst.Command;

import org.bukkit.command.CommandSender;

import java.io.IOException;
import java.sql.SQLException;

public abstract class BreakBuddingAmethystSubCommand {

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();

    public abstract void perform(CommandSender commandSender, String[] paramArrayOfString) throws IOException, SQLException;
}
