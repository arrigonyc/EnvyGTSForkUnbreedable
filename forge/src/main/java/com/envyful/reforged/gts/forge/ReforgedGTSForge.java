package com.envyful.reforged.gts.forge;

import com.envyful.api.forge.command.ForgeCommandFactory;
import com.envyful.api.forge.concurrency.ForgeUpdateBuilder;
import com.envyful.api.forge.gui.factory.ForgeGuiFactory;
import com.envyful.api.gui.factory.GuiFactory;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.bstats.forge.Metrics;

import java.nio.file.Paths;

@Mod(
        modid = "reforgedgts",
        name = "ReforgedGTS Forge",
        version = ReforgedGTSForge.VERSION,
        acceptableRemoteVersions = "*"
)
public class ReforgedGTSForge {

    public static final String VERSION = "0.3.0";

    private static ReforgedGTSForge instance;

    private ForgeCommandFactory commandFactory = new ForgeCommandFactory();

    @Mod.EventHandler
    public void onServerStarting(FMLPreInitializationEvent event) {
        GuiFactory.setPlatformFactory(new ForgeGuiFactory());
        instance = this;

        Metrics metrics = new Metrics(
                Loader.instance().activeModContainer(),
                event.getModLog(),
                Paths.get("config/"),
                12199 //TODO:
        );

        ForgeUpdateBuilder.instance()
                .name("ReforgedGTS")
                .requiredPermission("reforged.gts.update.notify")
                .owner("Pixelmon-Development")
                .repo("ReforgedGTS")
                .version(VERSION)
                .start();
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    public static ReforgedGTSForge getInstance() {
        return instance;
    }
}