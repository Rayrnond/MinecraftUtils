package com.reflexian.minecraftutils.other;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public abstract class CountDown {

    private int time;

    protected BukkitTask task;
    protected final Plugin plugin;


    public CountDown(int time, Plugin plugin) {
        this.time = time;
        this.plugin = plugin;
    }


    public abstract void count(int current);
    public abstract void finished();


    public final void start() {
        task = new BukkitRunnable() {

            @Override
            public void run() {
                count(time);
                if (time-- <= 0) {
                    finished();
                    cancel();
                }
            }

        }.runTaskTimer(plugin, 0L, 20L);
    }

}
