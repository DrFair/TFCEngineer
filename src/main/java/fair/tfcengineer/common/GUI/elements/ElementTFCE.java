package fair.tfcengineer.common.GUI.elements;

import cofh.lib.gui.GuiBase;
import cofh.lib.gui.element.ElementBase;
import fair.tfcengineer.TFCEngineer;
import net.minecraft.util.ResourceLocation;


public class ElementTFCE extends ElementBase {

    public static ResourceLocation ELEMENTS_TEXTURE = new ResourceLocation(TFCEngineer.ModID + ":" + "textures/gui/elements.png");

    public ElementTFCE(GuiBase guiBase, int x, int y) {
        super(guiBase, x, y);
    }

    public ElementTFCE(GuiBase guiBase, int x, int y, int sizeX, int sizeY) {
        super(guiBase, x, y, sizeX, sizeY);
    }

    @Override
    public void drawBackground(int mouseX, int mouseY, float partialTicks) {
    }

    @Override
    public void drawForeground(int mouseX, int mouseY) {
    }
}
