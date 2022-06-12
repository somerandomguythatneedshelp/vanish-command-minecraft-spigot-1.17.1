package vanish.vanish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VanishCOmmand implements CommandExecutor {
    private List<UUID> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }
        Player player = (Player) sender;
        if (player.hasPermission("stuff.vanish")) {

            if (vanished.contains(player.getUniqueId())) { // their are vanished
                vanished.remove(player.getUniqueId());
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.showPlayer(player);
                }
                player.sendMessage(ChatColor.GREEN + "You are now unvanished and everyone one the server can see you.");
            } else { // not vanished
                vanished.add(player.getUniqueId());

                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.hidePlayer(player);
                }

                player.sendMessage(ChatColor.RED + "You are now Vanished, You will see yourself in tab for reasons you shouldn't need to know. Be careful as players may be able to hear you");

            }
        } else {
            player.sendMessage(ChatColor.RED + "You doo not have permission to use that command");
        }
        return true;
    }
}
