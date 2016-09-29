package fair.tfcengineer.common.TileEntities.machines;

import cofh.api.energy.EnergyStorage;
import fair.tfcengineer.TFCEConfigs;

public class FridgeTE extends FridgeBaseTE {

    public FridgeTE() {
        this(2);
    }

    public FridgeTE(int frontSide) {
        super(frontSide, new EnergyStorage((int) (4000 * TFCEConfigs.fridgePowerMod), (int) (40 * TFCEConfigs.fridgePowerMod)));
    }

    @Override
    public float getDecayRate() {
        return TFCEConfigs.fridgeDecayRate;
    }

    public int getRunCost(float workAmount) {
        return 5; // RF per tick
    }
}
