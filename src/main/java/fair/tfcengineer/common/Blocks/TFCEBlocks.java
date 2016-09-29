package fair.tfcengineer.common.Blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fair.tfcengineer.common.TileEntities.machines.DeepFreezerTE;
import fair.tfcengineer.common.TileEntities.machines.ElectricForgeTE;
import fair.tfcengineer.common.TileEntities.machines.FridgeTE;
import fair.tfcengineer.common.TileEntities.machines.InductionForgeTE;
import net.minecraft.block.Block;

public class TFCEBlocks {

    public static int sidedBlockRenderId;
    public static int poweredForgeRenderId;
    public static int fridgeRenderId;

    public static Block electricForge;
    public static Block inductionForge;
    public static Block fridge;
    public static Block deepFreezer;

    public static void registerBlocks() {
        electricForge = new BlockElectricForge();
        inductionForge = new BlockInductionForge();
        fridge = new BlockFridge();
        deepFreezer = new BlockDeepFreezer();

        GameRegistry.registerBlock(electricForge, electricForge.getUnlocalizedName());
        GameRegistry.registerBlock(inductionForge, inductionForge.getUnlocalizedName());
        GameRegistry.registerBlock(fridge, fridge.getUnlocalizedName());
        GameRegistry.registerBlock(deepFreezer, deepFreezer.getUnlocalizedName());
    }

    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(ElectricForgeTE.class, "electricforgete");
        GameRegistry.registerTileEntity(InductionForgeTE.class, "inductionovente");
        GameRegistry.registerTileEntity(FridgeTE.class, "fridgete");
        GameRegistry.registerTileEntity(DeepFreezerTE.class, "deepfreezerte");
    }

}
