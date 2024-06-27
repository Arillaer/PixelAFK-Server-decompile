/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.io.ByteArrayDataOutput
 *  com.google.common.io.ByteStreams
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.java.JavaPlugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package cn.damao.catpixel.pixelafkserver.afk;

import cn.damao.catpixel.pixelafkserver.PixelAFK_Server;
import cn.damao.catpixel.pixelafkserver.afk.Sound;
import cn.damao.catpixel.pixelafkserver.utils.TitleUtils;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AFKSettings {
    public static void sendAFKServer(Player player) {
        ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        byteArrayDataOutput.writeUTF("Connect");
        byteArrayDataOutput.writeUTF(PixelAFK_Server.instance.getConfig().getString("Settings.AFK-Server"));
        player.sendPluginMessage(JavaPlugin.getPlugin(PixelAFK_Server.class), "BungeeCord", byteArrayDataOutput.toByteArray());
    }

    public static void reloadConfig() {
        new BukkitRunnable(){

            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage("§f[§6§lPixelAFK§f] §b§l>> §c现因插件配置更新，此房间将于10秒后重启！");
                }
            }

        }.runTaskTimer(PixelAFK_Server.instance, 10L, 20L);
        new BukkitRunnable(){


            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.sendMessage("§f[§6§lPixelAFK§f] §b§l>> §a房间正在重启中...");
                }
                Bukkit.shutdown();
            }
        }.runTaskLater(PixelAFK_Server.instance, 200L);
    }

    public static void AFKCoolDown(Player player) {
        Sound.AFK_Sound(player);
        TitleUtils.sendFullTitle(player, 0, 50, 0, PixelAFK_Server.instance.getConfig().getString("Language.Warning-Title"), PixelAFK_Server.instance.getConfig().getString("Language.Warning-Subtitle"));
        player.sendMessage(PixelAFK_Server.instance.getConfig().getString("Language.Warning-message"));
    }

}

