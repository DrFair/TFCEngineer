package fair.tfcengineer.common.Render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class FridgeRender extends SidedBlockRender {

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        float min = 1f / 16f;
        float max = 15f / 16f;

        renderer.setRenderBounds(min, 0f, min, max, max, max);
        renderer.renderStandardBlock(block, x, y, z);
        return true;
    }
}
