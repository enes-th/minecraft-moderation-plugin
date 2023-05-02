package enes.plugin.moderation.coommands;

import enes.plugin.moderation.storage.Database;
import enes.plugin.moderation.utils.Players;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCheck implements CommandExecutor {
    private final Players players;

    public PlayerCheck(Database database) {
        this.players = Players.getInstance(database);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            if (strings.length < 1) {
                commandSender.sendMessage("§cError! Usage: /player-check <player>");
                return true;
            }

            if (Bukkit.getPlayer(strings[0]) == null) {
                commandSender.sendMessage("§cError! Usage: /player-check <player>");
                return true;
            }

            String message = players.get(commandSender.getName());

            commandSender.sendMessage(message);

            return true;
        }
        return false;
    }
}
