package fr.starweizz.BreakBuddingAmethyst.Config;

import fr.starweizz.BreakBuddingAmethyst.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {
    public static File mainFile = new File(Main.instance.getDataFolder(), "config.yml");

    public static FileConfiguration config = (FileConfiguration) YamlConfiguration.loadConfiguration(mainFile);

    public static void reload() {
        config = (FileConfiguration)YamlConfiguration.loadConfiguration(mainFile);
    }
}
