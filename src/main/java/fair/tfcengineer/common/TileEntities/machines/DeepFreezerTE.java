package fair.tfcengineer.common.TileEntities.machines;

import cofh.api.energy.EnergyStorage;
import fair.tfcengineer.TFCEConfigs;

public class DeepFreezerTE extends FridgeBaseTE {

    public DeepFreezerTE() {
        this(2);
    }

    public DeepFreezerTE(int frontSide) {
        super(frontSide, new EnergyStorage((int) (8000 * TFCEConfigs.deepFreezerPowerMod), (int) (80 * TFCEConfigs.deepFreezerPowerMod)));
    }

    @Override
    public float getDecayRate() {
        return TFCEConfigs.deepFreezerDecayRate;
    }

    public int getRunCost(float workAmount) {
        return (int) (15 * TFCEConfigs.deepFreezerPowerMod); // RF per tick
    }
}
