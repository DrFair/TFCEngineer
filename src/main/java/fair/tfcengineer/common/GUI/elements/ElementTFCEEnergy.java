package fair.tfcengineer.common.GUI.elements;

import cofh.api.energy.IEnergyStorage;
import cofh.lib.gui.GuiBase;

import java.util.List;

public class ElementTFCEEnergy extends ElementTFCE {

    protected IEnergyStorage energyStorage;

    public ElementTFCEEnergy(GuiBase guiBase, IEnergyStorage energyStorage, int x, int y) {
        super(guiBase, x, y, 18, 60);
        this.energyStorage = energyStorage;
        texW = 18;
        texH = 60;
        setSize(texW, texH);
    }

    public void updateEnergyStorage(IEnergyStorage energyStorage) {
        this.energyStorage = energyStorage;
    }

    @Override
    public void drawBackground(int mouseX, int mouseY, float partialTicks) {
    }

    @Override
    public void drawForeground(int mouseX, int mouseY) {
        gui.mc.getTextureManager().bindTexture(ELEMENTS_TEXTURE);
        float energyPercent = (float) energyStorage.getEnergyStored() / (float) energyStorage.getMaxEnergyStored();
        int energyPixels = (int) (texH * energyPercent);
        int energyPixelsInv = Math.abs(energyPixels - texH);
        gui.drawTexturedModalRect(posX, posY, 0, 0, texW, texH); // Empty energy texture
        if (energyPixels > 0) gui.drawTexturedModalRect(posX, posY + energyPixelsInv, 18, energyPixelsInv, texW, energyPixels);
    }

    public void addTooltip(List<String> var1) {
        if (energyStorage.getMaxEnergyStored() < 0) {
            var1.add("Infinite RF");
        } else {
            var1.add(energyStorage.getEnergyStored() + " / " + energyStorage.getMaxEnergyStored() + " RF");
        }
    }
}
