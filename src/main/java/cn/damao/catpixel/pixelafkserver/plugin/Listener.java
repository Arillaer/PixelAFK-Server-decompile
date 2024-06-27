package cn.damao.catpixel.pixelafkserver.plugin;

import cn.damao.catpixel.pixelafkserver.PixelAFK_Server;
import cn.damao.catpixel.pixelafkserver.afk.AFKListener;
import cn.damao.catpixel.pixelafkserver.command.MainCommand;
import org.bukkit.Bukkit;

public class Listener {
    static PixelAFK_Server plugin = PixelAFK_Server.getPlugin(PixelAFK_Server.class);

    public static void regPlugin() {
        Bukkit.getConsoleSender().sendMessage("§6=============================================");
        Bukkit.getConsoleSender().sendMessage("§f[§6§lPixelAFK §8- §b§lServer§f] §f插件制作： §6像素社区 (猫像素工作室旗下产品)");
        Bukkit.getConsoleSender().sendMessage("§f[§6§lPixelAFK §8- §b§lServer§f] §a插件已成功启动！");
        Bukkit.getConsoleSender().sendMessage("§6=============================================");
        Bukkit.getPluginManager().registerEvents(new AFKListener(plugin), plugin);
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        plugin.getCommand("PixelAFK").setExecutor(new MainCommand(plugin));
    }

}

