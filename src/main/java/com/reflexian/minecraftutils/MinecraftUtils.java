package com.reflexian.minecraftutils;

import com.reflexian.minecraftutils.vanilla.ActionBarUtil;
import com.reflexian.minecraftutils.vanilla.BoardUtil;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftUtils extends JavaPlugin {

    @Getter
    private static MinecraftUtils instance;

    @Override
    public void onEnable() {
        instance=this;

        ActionBarUtil.initUtil(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
