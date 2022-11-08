package me.infinity.testo;

import me.infinity.groupstats.api.GroupStatsAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Testo extends JavaPlugin implements Listener {

    private GroupStatsAPI groupStatsAPI;

    @Override
    public void onEnable() {
        // Plugin startup logic
        groupStatsAPI = this.getServer().getServicesManager().getRegistration(GroupStatsAPI.class).getProvider();
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(String.valueOf(groupStatsAPI.getGroupProfile("Solo", event.getPlayer().getUniqueId()).get().getWins()));
    }

}
