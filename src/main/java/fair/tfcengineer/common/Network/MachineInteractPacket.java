package fair.tfcengineer.common.Network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import fair.tfcengineer.common.TileEntities.MachineBaseTE;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class MachineInteractPacket implements IMessage {

    private int x, y, z;
    protected byte flag;

    public MachineInteractPacket() {
    }

    // Flag must be an unsigned byte

    public MachineInteractPacket(int x, int y, int z, int flag) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.flag = (byte) flag;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        flag = buf.readByte();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(flag);
    }

    public int getFlag() {
        return flag & 0xFF;
    }

    public static class Handler implements IMessageHandler<MachineInteractPacket, IMessage> {

        @Override
        public IMessage onMessage(MachineInteractPacket message, MessageContext ctx) {
//            System.out.println("Got message from " + ctx.getServerHandler().playerEntity.getDisplayName());
//            System.out.println("X=" + message.x + ", Y=" + message.y + ", Z=" + message.z);
            TileEntity te = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z);
            if (te instanceof MachineBaseTE) {
                ((MachineBaseTE) te).interact(message);
            }
            return null;
        }

    }
}
