package fair.tfcengineer.common.TileEntities.machines;

import cofh.api.energy.EnergyStorage;
import com.bioxx.tfc.api.HeatIndex;
import com.bioxx.tfc.api.TFC_ItemHeat;
import fair.tfcengineer.TFCEConfigs;
import fair.tfcengineer.common.Network.MachineInteractPacket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ElectricForgeTE extends PoweredForgeBaseTE {

    protected int targetTemp;

    public ElectricForgeTE() { // Every tile entity have to have an empty constructor for loading
        this(2);
    }

    public ElectricForgeTE(int frontSide) {
        super(frontSide, new EnergyStorage((int) (4000 * TFCEConfigs.electricForgePowerMod), (int) (40 * TFCEConfigs.electricForgePowerMod)));
        targetTemp = 1600;
    }

    public void interact(MachineInteractPacket packet) {
        if (packet.getFlag() == 0) { // Temperature up
            increaseTemperature();
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        } else if (packet.getFlag() == 1) { // Temperature down
            decreaseTemperature();
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }

    @Override
    protected boolean canActivate() {
        return super.canActivate() && targetTemp > 0;
    }

    public int getRunCost(float workAmount) {
        // The more it is heating, the more power it will take
        // Using a power function with fraction as power so the increase is lower the higher the number
        // With this function, heating 1 item takes 5 RF/t, heating 5 takes ~11 RF/t, heating 9 takes 15 RF/t
        return (int) (Math.pow(workAmount, 0.5) * 5 * TFCEConfigs.electricForgePowerMod);
    }

    public float getIncreasedTemp(ItemStack itemStack, HeatIndex index, float curTemp) {
        if (curTemp < targetTemp) {
            curTemp += TFC_ItemHeat.getTempIncrease(itemStack) * TFCEConfigs.electricForgeHeatRate;
            if (curTemp > targetTemp) curTemp = targetTemp;
        }
//        if (curTemp > index.meltTemp - 1f) curTemp = index.meltTemp - 1f;
        return curTemp;
    }

    public int getTargetTemperature() {
        return targetTemp;
    }

    public void setTargetTemperature(int targetTemp) {
        this.targetTemp = Math.min(Math.max(targetTemp, 0), 2000);
        markDirty();
    }

    public void increaseTemperature() {
        setTargetTemperature(getTargetTemperature() + 50);
    }

    public void decreaseTemperature() {
        setTargetTemperature(getTargetTemperature() - 50);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        targetTemp = nbt.getInteger("targetTemp");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("targetTemp", targetTemp);
    }

    @Override
    public String getInventoryName() {
        return "Electric Forge";
    }
}
