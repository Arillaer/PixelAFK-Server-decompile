package cn.damao.catpixel.pixelafkserver.afk;

import cn.damao.catpixel.pixelafkserver.PixelAFK_Server;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Sound {
    public static void AFK_Sound(Player player) {
        new BukkitRunnable(){
            public void run() {
                player.playSound(player.getLocation(), org.bukkit.Sound.NOTE_PLING, 1.0f, 2.0f);
            }
        }.runTaskLater(PixelAFK_Server.instance, 0L);
        new BukkitRunnable(){
            public void run() {
                player.playSound(player.getLocation(), org.bukkit.Sound.NOTE_PLING, 1.0f, 1.0f);
            }
        }.runTaskLater(PixelAFK_Server.instance, 2L);
        new BukkitRunnable(){
            public void run() {
                player.playSound(player.getLocation(), org.bukkit.Sound.NOTE_PLING, 1.0f, 2.0f);
            }
        }.runTaskLater(PixelAFK_Server.instance, 4L);
        new BukkitRunnable(){
            public void run() {
                player.playSound(player.getLocation(), org.bukkit.Sound.NOTE_PLING, 1.0f, 1.0f);
            }
        }.runTaskLater(PixelAFK_Server.instance, 6L);
        new BukkitRunnable(){
            public void run() {
                player.playSound(player.getLocation(), org.bukkit.Sound.NOTE_PLING, 1.0f, 2.0f);
            }
        }.runTaskLater(PixelAFK_Server.instance, 8L);
        new BukkitRunnable(){
            public void run() {
                player.playSound(player.getLocation(), org.bukkit.Sound.NOTE_PLING, 1.0f, 1.0f);
            }
        }.runTaskLater(PixelAFK_Server.instance, 10L);
        new BukkitRunnable(){
            public void run() {
                player.playSound(player.getLocation(), org.bukkit.Sound.NOTE_PLING, 1.0f, 2.0f);
            }
        }.runTaskLater(PixelAFK_Server.instance, 12L);
        new BukkitRunnable(){
            public void run() {
                player.playSound(player.getLocation(), org.bukkit.Sound.NOTE_PLING, 1.0f, 1.0f);
            }
        }.runTaskLater(PixelAFK_Server.instance, 14L);
        new BukkitRunnable(){
            public void run() {
                player.playSound(player.getLocation(), org.bukkit.Sound.NOTE_PLING, 1.0f, 2.0f);
            }
        }.runTaskLater(PixelAFK_Server.instance, 16L);
        new BukkitRunnable(){
            public void run() {
                player.playSound(player.getLocation(), org.bukkit.Sound.NOTE_PLING, 1.0f, 1.0f);
            }
        }.runTaskLater(PixelAFK_Server.instance, 18L);
        new BukkitRunnable(){
            public void run() {
                player.playSound(player.getLocation(), org.bukkit.Sound.NOTE_PLING, 1.0f, 2.0f);
            }
        }.runTaskLater(PixelAFK_Server.instance, 20L);
        new BukkitRunnable(){
            public void run() {
                player.playSound(player.getLocation(), org.bukkit.Sound.NOTE_PLING, 1.0f, 1.0f);
            }
        }.runTaskLater(PixelAFK_Server.instance, 22L);
    }
}

