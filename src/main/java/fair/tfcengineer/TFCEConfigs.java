package fair.tfcengineer;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class TFCEConfigs {

    // Power multipliers
    public static float electricForgePowerMod;
    public static float inductionForgePowerMod;
    public static float fridgePowerMod;
    public static float deepFreezerPowerMod;

    // Misc
    public static float fridgeDecayRate;
    public static float deepFreezerDecayRate;
    public static float lunchboxDecayRate;
    public static float electricForgeHeatRate;
    public static float inductionForgeHeatRate;

    private static File configFile;
    private static Configuration config;
    private static final String CATEGORY_POWER = "Power";
    private static final String CATEGORY_MISC = "Misc";

    public static void preInit(FMLPreInitializationEvent event) {
        configFile = event.getSuggestedConfigurationFile();
        syncConfig();
    }

    public static void syncConfig() {
        if (configFile == null) throw new NullPointerException("Config file not defined. Run preInit() first.");
        config = new Configuration(configFile);

        electricForgePowerMod = config.getFloat("electricForgePowerMod", CATEGORY_POWER, 1f, 0.1f, 100f, "Electric forge power multiplier");
        inductionForgePowerMod = config.getFloat("inductionForgePowerMod", CATEGORY_POWER, 1f, 0.1f, 100f, "Induction forge power multiplier");
        fridgePowerMod = config.getFloat("fridgePowerMod", CATEGORY_POWER, 1f, 0.1f, 100f, "Fridge power multiplier");
        deepFreezerPowerMod = config.getFloat("deepFreezerPowerMod", CATEGORY_POWER, 1f, 0.1f, 100f, "Deep freezer power multiplier");

        fridgeDecayRate = config.getFloat("fridgeDecayRate", CATEGORY_MISC, 0.25f, 0f, 1f, "Decay rate of items in fridge");
        deepFreezerDecayRate = config.getFloat("deepFreezerDecayRate", CATEGORY_MISC, 0f, 0f, 1f, "Decay rate of items in deep freezer");
        lunchboxDecayRate = config.getFloat("lunchboxDecayRate", CATEGORY_MISC, 0.5f, 0f, 1f, "Decay rate of items in the lunchbox");
        electricForgeHeatRate = config.getFloat("electricForgeHeatRate", CATEGORY_MISC, 3f, 0.01f, 100f, "Electric forge item heat rate multiplier");
        inductionForgeHeatRate = config.getFloat("inductionForgeHeatRate", CATEGORY_MISC, 6f, 0.01f, 100f, "Induction forge item heat rate multiplier");



        config.save();

    }

}
