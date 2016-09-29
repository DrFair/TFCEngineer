package fair.tfcengineer.common.Items;

import cpw.mods.fml.common.registry.GameRegistry;
import fair.tfcengineer.TFCEngineer;
import net.minecraft.item.Item;

public class TFCEItems {

    public static Item lunchbox;
    public static Item insulationCloth;

    public static void registerItems() {
        lunchbox = new ItemLunchbox();
        insulationCloth = new TFCEMatItem().setUnlocalizedName("InsulationCloth").setTextureName(TFCEngineer.ModID + ":" + "insulationcloth");

        GameRegistry.registerItem(lunchbox, lunchbox.getUnlocalizedName());
        GameRegistry.registerItem(insulationCloth, insulationCloth.getUnlocalizedName());
    }
}
