package fair.tfcengineer.common.Containers.slots;

import com.bioxx.tfc.Food.ItemFoodTFC;
import com.bioxx.tfc.Items.ItemOre;
import com.bioxx.tfc.api.HeatRegistry;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotForge extends Slot {

    public SlotForge(IInventory inventory, int slotIndex, int xDisplayPos, int yDisplayPos) {
        super(inventory, slotIndex, xDisplayPos, yDisplayPos);
    }

    @Override
    public boolean isItemValid(ItemStack itemstack) {
        HeatRegistry manager = HeatRegistry.getInstance();
        return !(manager.findMatchingIndex(itemstack) == null
                || itemstack.getItem() instanceof ItemOre
                || itemstack.getItem() instanceof ItemFoodTFC);
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }
}
