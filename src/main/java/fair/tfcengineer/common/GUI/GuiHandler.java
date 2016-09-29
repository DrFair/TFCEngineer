package fair.tfcengineer.common.GUI;

import cpw.mods.fml.common.network.IGuiHandler;
import fair.tfcengineer.common.Containers.ContainerFridge;
import fair.tfcengineer.common.Containers.ContainerLunchbox;
import fair.tfcengineer.common.Containers.ContainerPoweredForge;
import fair.tfcengineer.common.Items.InventoryItem;
import fair.tfcengineer.common.TileEntities.machines.ElectricForgeTE;
import fair.tfcengineer.common.TileEntities.machines.FridgeBaseTE;
import fair.tfcengineer.common.TileEntities.machines.InductionForgeTE;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    public static final int ElectricForgeGUI = 0;
    public static final int InductionForgeGUI = 1;
    public static final int FridgeGUI = 2;
    public static final int LunchboxGUI = 3;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(x, y, z);
        switch (ID) {
            case ElectricForgeGUI:
                return new ContainerPoweredForge(player.inventory, (ElectricForgeTE) te);
            case InductionForgeGUI:
                return new ContainerPoweredForge(player.inventory, (InductionForgeTE) te);
            case FridgeGUI:
                return new ContainerFridge(player.inventory, (FridgeBaseTE) te);
            case LunchboxGUI:
                return new ContainerLunchbox(player.inventory, new InventoryItem(player.getHeldItem()));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(x, y, z);
        switch (ID) {
            case ElectricForgeGUI:
                return new GuiElectricForge(player.inventory, (ElectricForgeTE) te);
            case InductionForgeGUI:
                return new GuiInductionForge(player.inventory, (InductionForgeTE) te);
            case FridgeGUI:
                return new GuiFridge(player.inventory, (FridgeBaseTE) te);
            case LunchboxGUI:
                return new GuiLunchbox(player.inventory, new InventoryItem(player.getHeldItem()));
            default:
                return null;
        }
    }
}
