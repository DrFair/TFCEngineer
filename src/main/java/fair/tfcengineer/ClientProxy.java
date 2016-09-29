package fair.tfcengineer;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fair.tfcengineer.common.Blocks.TFCEBlocks;
import fair.tfcengineer.common.Render.FridgeRender;
import fair.tfcengineer.common.Render.PoweredForgeRender;
import fair.tfcengineer.common.Render.SidedBlockRender;

public class ClientProxy extends CommonProxy {

    public void registerRendering() {
        RenderingRegistry.registerBlockHandler(TFCEBlocks.sidedBlockRenderId = RenderingRegistry.getNextAvailableRenderId(), new SidedBlockRender());
        RenderingRegistry.registerBlockHandler(TFCEBlocks.poweredForgeRenderId = RenderingRegistry.getNextAvailableRenderId(), new PoweredForgeRender());
        RenderingRegistry.registerBlockHandler(TFCEBlocks.fridgeRenderId = RenderingRegistry.getNextAvailableRenderId(), new FridgeRender());
    }

}
