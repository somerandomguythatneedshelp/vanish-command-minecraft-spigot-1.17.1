package vanish.vanish;

import org.bukkit.plugin.java.JavaPlugin;

public final class Vanish extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("v").setExecutor(new VanishCOmmand());

    }
}
