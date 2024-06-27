package cn.damao.catpixel.pixelafkserver;

import cn.damao.catpixel.pixelafkserver.plugin.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class PixelAFK_Server extends JavaPlugin {

    public static PixelAFK_Server instance;

    @Override
    public void onEnable() {
        instance = this;
        Listener.regPlugin();
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
    }

}

