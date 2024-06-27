package cn.damao.catpixel.pixelafkserver.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityLightning;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityWeather;
import net.minecraft.server.v1_8_R3.World;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TitleUtils {

    public static void sendTitle(Player player, Integer n, Integer n2, Integer n3, String string, String string2) {
        try {
            Object t;
            Constructor constructor;
            Object object;
            Object object2;
            if (string != null) {
                string = ChatColor.translateAlternateColorCodes('&', string);
                string = string.replaceAll("%player%", player.getDisplayName());
                object2 = Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutTitle")).getDeclaredClasses()[0].getField("TIMES").get(null);
                object = Objects.requireNonNull(TitleUtils.getNMSClass("IChatBaseComponent")).getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, String.valueOf(new StringBuilder().append("{\"text\":\"").append(string).append("\"}")));
                constructor = Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutTitle")).getConstructor(Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutTitle")).getDeclaredClasses()[0], TitleUtils.getNMSClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE);
                t = constructor.newInstance(object2, object, n, n2, n3);
                TitleUtils.sendPacket(player, t);
                object2 = Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutTitle")).getDeclaredClasses()[0].getField("TITLE").get(null);
                object = Objects.requireNonNull(TitleUtils.getNMSClass("IChatBaseComponent")).getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, String.valueOf(new StringBuilder().append("{\"text\":\"").append(string).append("\"}")));
                constructor = Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutTitle")).getConstructor(Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutTitle")).getDeclaredClasses()[0], TitleUtils.getNMSClass("IChatBaseComponent"));
                t = constructor.newInstance(object2, object);
                TitleUtils.sendPacket(player, t);
            }
            if (string2 != null) {
                string2 = ChatColor.translateAlternateColorCodes('&', string2);
                string2 = string2.replaceAll("%player%", player.getDisplayName());
                object2 = Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutTitle")).getDeclaredClasses()[0].getField("TIMES").get(null);
                object = Objects.requireNonNull(TitleUtils.getNMSClass("IChatBaseComponent")).getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, String.valueOf(new StringBuilder().append("{\"text\":\"").append(string).append("\"}")));
                constructor = Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutTitle")).getConstructor(Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutTitle")).getDeclaredClasses()[0], TitleUtils.getNMSClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE);
                t = constructor.newInstance(object2, object, n, n2, n3);
                TitleUtils.sendPacket(player, t);
                object2 = Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutTitle")).getDeclaredClasses()[0].getField("SUBTITLE").get(null);
                object = Objects.requireNonNull(TitleUtils.getNMSClass("IChatBaseComponent")).getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, String.valueOf(new StringBuilder().append("{\"text\":\"").append(string2).append("\"}")));
                constructor = Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutTitle")).getConstructor(Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutTitle")).getDeclaredClasses()[0], TitleUtils.getNMSClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE);
                t = constructor.newInstance(object2, object, n, n2, n3);
                TitleUtils.sendPacket(player, t);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void playFakeLightning(Player player, boolean bl) {
        WorldServer worldServer = ((CraftWorld)player.getLocation().getWorld()).getHandle();
        PacketPlayOutSpawnEntityWeather packetPlayOutSpawnEntityWeather = new PacketPlayOutSpawnEntityWeather((Entity)new EntityLightning(worldServer, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ()));
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packetPlayOutSpawnEntityWeather);
        if (!bl) {
            player.getLocation().getWorld().playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 100.0f, 0.0f);
        }
    }

    public static Class getNMSClass(String string) {
        String string2 = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        try {
            return Class.forName(String.valueOf(new StringBuilder().append("net.minecraft.server.").append(string2).append(".").append(string)));
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
            return null;
        }
    }

    public static void sendTitle(Player player, Integer n, Integer n2, Integer n3, String string) {
        TitleUtils.sendTitle(player, n, n2, n3, string, null);
    }

    public static void playFakeLightning(Player player) {
        TitleUtils.playFakeLightning(player, true);
    }

    public static void sendPacket(Player player, Object object) {
        try {
            Object object2 = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
            Object object3 = object2.getClass().getField("playerConnection").get(object2);
            object3.getClass().getMethod("sendPacket", TitleUtils.getNMSClass("Packet")).invoke(object3, object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void sendTabTitle(Player player, String string, String string2) {
        if (string == null) {
            string = "";
        }
        string = ChatColor.translateAlternateColorCodes('&', string);
        if (string2 == null) {
            string2 = "";
        }
        string2 = ChatColor.translateAlternateColorCodes('&', string2);
        string = string.replaceAll("%player%", player.getDisplayName());
        string2 = string2.replaceAll("%player%", player.getDisplayName());
        try {
            Object object = Objects.requireNonNull(TitleUtils.getNMSClass("IChatBaseComponent")).getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, String.valueOf(new StringBuilder().append("{\"text\":\"").append(string).append("\"}")));
            Object object2 = Objects.requireNonNull(TitleUtils.getNMSClass("IChatBaseComponent")).getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, String.valueOf(new StringBuilder().append("{\"text\":\"").append(string2).append("\"}")));
            Constructor constructor = Objects.requireNonNull(TitleUtils.getNMSClass("PacketPlayOutPlayerListHeaderFooter")).getConstructor(new Class[0]);
            Object t = constructor.newInstance(new Object[0]);
            Field field = t.getClass().getDeclaredField("a");
            field.setAccessible(true);
            field.set(t, object);
            Field field2 = t.getClass().getDeclaredField("b");
            field2.setAccessible(true);
            field2.set(t, object2);
            TitleUtils.sendPacket(player, t);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void clearTitle(Player player) {
        TitleUtils.sendTitle(player, 0, 0, 0, "", "");
    }

    public static void sendFullTitle(Player player, Integer n, Integer n2, Integer n3, String string, String string2) {
        TitleUtils.sendTitle(player, n, n2, n3, string, string2);
    }

    public static void sendSubtitle(Player player, Integer n, Integer n2, Integer n3, String string) {
        TitleUtils.sendTitle(player, n, n2, n3, null, string);
    }
}

