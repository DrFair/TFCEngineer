package fair.tfcengineer.common.TileEntities;

import fair.tfcengineer.common.Network.MachineInteractPacket;
import fair.tfcengineer.common.TileEntities.interfaces.SidedBlockTE;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class MachineBaseTE extends TileEntity implements SidedBlockTE {

    // Sides: 0 = bottom, 1 = top, 2 = north, 3 = south, 4 = west, 5 = east
    protected int frontSide;
    private boolean isActive;

    public MachineBaseTE(int frontSide) {
        setFrontSide(frontSide);
        isActive = false;
    }

    // When received machine interact packet
    // This only happens on server side

    public void interact(MachineInteractPacket packet) {
    }

    protected boolean canActivate() {
        return true;
    }

    public void setActive(boolean var) {
        if (var == this.isActive) return;
        if (var && !canActivate()) return;
        this.isActive = var;
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, frontSide + (var ? 6 : 0), 2);
        markDirty();
    }

    public void setFrontSide(int side) {
        this.frontSide = Math.max(2, Math.abs(side) % 6);
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        isActive = nbt.getBoolean("isActive");
        frontSide = nbt.getInteger("frontSide");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setBoolean("isActive", isActive);
        nbt.setInteger("frontSide", frontSide);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagCompound nbt = pkt.func_148857_g();
        readFromNBT(nbt);
        readFromPacket(nbt);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound data = new NBTTagCompound();
        writeToNBT(data);
        writeToPacket(data);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, data);
    }

    // Override this instead of getDescriptionPacket()
    protected void writeToPacket(NBTTagCompound nbt) {
    }

    // Override this instead of onDataPacket()
    protected void readFromPacket(NBTTagCompound nbt) {
    }

}
