package fr.starweizz.BreakBuddingAmethyst;

import fr.starweizz.BreakBuddingAmethyst.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static Main instance;


    public void onEnable() {
        instance = this;

        getConfig().options().copyHeader(true);
        getConfig().options().copyDefaults(true);
        getConfig().options().header("__________                        __       __________          .___  .___.__                      _____                  __  .__                    __   \n" +
                "\\______   \\_______   ____ _____  |  | __   \\______   \\__ __  __| _/__| _/|__| ____    ____       /  _  \\   _____   _____/  |_|  |__ ___.__. _______/  |_ \n" +
                " |    |  _/\\_  __ \\_/ __ \\\\__  \\ |  |/ /    |    |  _/  |  \\/ __ |/ __ | |  |/    \\  / ___\\     /  /_\\  \\ /     \\_/ __ \\   __\\  |  <   |  |/  ___/\\   __\\\n" +
                " |    |   \\ |  | \\/\\  ___/ / __ \\|    <     |    |   \\  |  / /_/ / /_/ | |  |   |  \\/ /_/  >   /    |    \\  Y Y  \\  ___/|  | |   Y  \\___  |\\___ \\  |  |  \n" +
                " |______  / |__|    \\___  >____  /__|_ \\    |______  /____/\\____ \\____ | |__|___|  /\\___  /    \\____|__  /__|_|  /\\___  >__| |___|  / ____/____  > |__|  \n" +
                "        \\/              \\/     \\/     \\/           \\/           \\/    \\/         \\//_____/             \\/      \\/     \\/          \\/\\/         \\/        ");
        saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(this, this);
        sendMessage("&f" + getName() + " " + getDescription().getVersion() + " &aEnabled!");
    }

    public void onDisable() {
        sendMessage("&f" + getName() + " " + getDescription().getVersion() + " &cDisabled!");
    }

    public void sendMessage(String message) {
        Bukkit.getConsoleSender().sendMessage(Message.chatFormatter("&6&l[&e" + getName() + "&6&l]&r " + message));
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() != Material.BUDDING_AMETHYST) return;

        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        Location location = event.getBlock().getLocation().add(0.5D, 0.5D, 0.5D);

        event.setDropItems(false);

        if (!itemStack.getType().toString().toLowerCase().contains("pickaxe")) return;

        if (player.hasPermission("bba.break")) {
            location.getWorld().dropItem(location, new ItemStack(Material.BUDDING_AMETHYST));
        } else if (player.hasPermission("bba.silk")) {
            if (!itemStack.containsEnchantment(Enchantment.SILK_TOUCH)) return;

            location.getWorld().dropItem(location, new ItemStack(Material.BUDDING_AMETHYST));
        }

    }
}
