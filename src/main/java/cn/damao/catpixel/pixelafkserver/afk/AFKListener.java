package cn.damao.catpixel.pixelafkserver.afk;

import cn.damao.catpixel.pixelafkserver.PixelAFK_Server;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AFKListener implements Listener {
    private final Map<UUID, Long> lastMoveTime;
    private final PixelAFK_Server plugin;
    private final Map<UUID, BukkitRunnable> afkTasks;
    private final AFKListener this$0;

    public AFKListener(final PixelAFK_Server plugin) {
        this.lastMoveTime = new HashMap<>();
        this.afkTasks = new HashMap<>();
        this.plugin = plugin;
        this$0 = this;
        new BukkitRunnable() {

            public void run() {
                AFKListener.access$000(this$0);
            }
        }.runTaskTimer(plugin, 20L, 20L);
    }

    static void access$000(final AFKListener afkListener) {
        afkListener.checkAfkStatus();
    }

    static Map<UUID, BukkitRunnable> access$300(final AFKListener afkListener) {
        return afkListener.afkTasks;
    }

    static PixelAFK_Server access$200(final AFKListener afkListener) {
        return afkListener.plugin;
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent playerJoinEvent) {
        this.lastMoveTime.put(playerJoinEvent.getPlayer().getUniqueId(), System.currentTimeMillis());
    }

    static Map<UUID, Long> access$100(final AFKListener afkListener) {
        return afkListener.lastMoveTime;
    }

    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent playerMoveEvent) {
        final UUID uniqueId = playerMoveEvent.getPlayer().getUniqueId();
        this.lastMoveTime.put(uniqueId, System.currentTimeMillis());
        if (this.afkTasks.containsKey(uniqueId)) {
            (this.afkTasks.get(uniqueId)).cancel();
            this.afkTasks.remove(uniqueId);
        }
    }

    private void checkAfkStatus() {
        final long currentTimeMillis = System.currentTimeMillis();
        for (UUID uuid : this.lastMoveTime.keySet()) {
            final Player player = Bukkit.getPlayer(uuid);
            if (player != null && player.isOnline()) {
                if (player.hasPermission("pixelafk.bypass")) {
                    continue;
                }
                if (currentTimeMillis - this.lastMoveTime.get(uuid) < PixelAFK_Server.instance.getConfig().getInt("Settings.AFK-CoolDown") * 1000L) {
                    continue;
                }
                if (this.afkTasks.containsKey(uuid)) {
                    continue;
                }
                BukkitRunnable bukkitRunnable = new BukkitRunnable() {

                    public void run() {
                        if (System.currentTimeMillis() - AFKListener.access$100(this$0).getOrDefault(uuid, 0L) >= PixelAFK_Server.instance.getConfig().getInt("Settings.AFK-CoolDown") * 1000L) {
                            AFKSettings.AFKCoolDown(player);
                            new BukkitRunnable() {

                                public void run() {
                                    if (System.currentTimeMillis() - AFKListener.access$100(this$0).getOrDefault(uuid, 0L) >= PixelAFK_Server.instance.getConfig().getInt("Settings.AFK-ConnectLimboServer-CoolDown") * 1000L) {
                                        AFKSettings.sendAFKServer(player);
                                    }
                                }
                            }.runTaskLater(AFKListener.access$200(this$0), 100L);
                        }
                        else {
                            this.cancel();
                            AFKListener.access$300(this$0).remove(uuid);
                        }
                    }

                };
                bukkitRunnable.runTaskTimer(this.plugin, 0L, 20L);
                this.afkTasks.put(uuid, bukkitRunnable);
            }
        }
    }
}

