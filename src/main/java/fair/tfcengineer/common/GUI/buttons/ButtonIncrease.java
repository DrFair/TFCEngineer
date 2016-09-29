package fair.tfcengineer.common.GUI.buttons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

import static fair.tfcengineer.common.GUI.elements.ElementTFCE.ELEMENTS_TEXTURE;

public class ButtonIncrease extends GuiButton {

    public ButtonIncrease(int id, int xPos, int yPos) {
        super(id, xPos, yPos, "");
        width = 14;
        height = 14;
    }

    @Override
    public void drawButton(Minecraft mc, int x, int y) {
        if (visible) {
            mc.getTextureManager().bindTexture(ELEMENTS_TEXTURE);
            GL11.glColor4f(1f, 1f, 1f, 1f);
            boolean mouseOver = x >= xPosition && y >= yPosition && x < xPosition + width && y < yPosition + height;
            int state = getHoverState(mouseOver);
            mouseDragged(mc, x, y);
            drawTexturedModalRect(xPosition, yPosition, 14, 60 + state * 14, 14, 14);
        }
    }


}
