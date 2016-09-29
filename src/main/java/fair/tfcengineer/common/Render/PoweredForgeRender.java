package fair.tfcengineer.common.Render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class PoweredForgeRender extends SidedBlockRender {

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        float min = 1f / 16f;
        float max = 15f / 16f;
//        renderer.setRenderBounds(minX, minY, minZ, maxX, maxY, maxZ);

        renderer.setRenderBounds(min, min, min, max, max, max);
        renderer.renderStandardBlock(block, x, y, z);

        float legStart1 = 2f / 16f;
        float legEnd1 = 4f / 16f;
        float legStart2 = 12f / 16f;
        float legEnd2 = 14f / 16f;
        float legHeight = 1f / 16f;

        renderer.setRenderBounds(legStart1, 0f, legStart1, legEnd1, legHeight, legEnd1);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBounds(legStart2, 0f, legStart1, legEnd2, legHeight, legEnd1);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBounds(legStart2, 0f, legStart2, legEnd2, legHeight, legEnd2);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBounds(legStart1, 0f, legStart2, legEnd1, legHeight, legEnd2);
        renderer.renderStandardBlock(block, x, y, z);

        return true;
    }
}
