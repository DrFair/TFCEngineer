package fair.tfcengineer.common.GUI;

import cofh.lib.gui.GuiBase;
import fair.tfcengineer.TFCEngineer;
import fair.tfcengineer.common.Containers.ContainerFridge;
import fair.tfcengineer.common.GUI.elements.ElementTFCEEnergyFridge;
import fair.tfcengineer.common.TileEntities.machines.FridgeBaseTE;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GuiFridge extends GuiBase {

    protected ResourceLocation resourceLocation;

    protected IInventory playerInv;
    protected FridgeBaseTE te;
    protected int curMeta;

    protected ElementTFCEEnergyFridge energyStored;

    public GuiFridge(IInventory playerInv, FridgeBaseTE te) {
        super(new ContainerFridge(playerInv, te));
        this.playerInv = playerInv;
        this.te = te;
        curMeta = te.getBlockMetadata();

        resourceLocation = new ResourceLocation(TFCEngineer.ModID + ":" + "textures/gui/fridge.png");
    }

    @Override
    public void initGui() {
        super.initGui();
        addElement(energyStored = new ElementTFCEEnergyFridge(this, te, 15, 12));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(resourceLocation);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        drawElements(partialTicks, false);
        drawTexturedModalRect(guiLeft + 84, guiTop + 66, 176, te.isActive() ? 8 : 0, 8, 8); // Active indicator
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        drawElements(0f, true);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        // For some reason, when meta data changes, the tile entity of this is not valid anymore, so find a new.
        if (te.getWorldObj().getBlockMetadata(te.xCoord, te.yCoord, te.zCoord) != curMeta) {
            TileEntity newTE = te.getWorldObj().getTileEntity(te.xCoord, te.yCoord, te.zCoord);
            if (newTE instanceof FridgeBaseTE) {
                updateTileEntity((FridgeBaseTE) newTE);
            } else {
                mc.thePlayer.closeScreen();
            }
            curMeta = te.getBlockMetadata();
        }

    }

    public void updateTileEntity(FridgeBaseTE te) {
        this.te = te;
        energyStored.updateTilEntity(te);
    }

}
