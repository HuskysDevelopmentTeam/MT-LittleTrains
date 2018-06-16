package net.multiteam.mt_t_trains.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.multiteam.mt_t_trains.client.gui.GuiModellerTable;
import net.multiteam.mt_t_trains.container.ContainerModellerTable;
import net.multiteam.mt_t_trains.tileentity.TileModellerTable;

import javax.annotation.Nullable;

public class MTGuiHandler implements IGuiHandler {

    public static final int GUI_MODELLER_TABLE_ID = 0;

    /**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GUI_MODELLER_TABLE_ID) {
            return new ContainerModellerTable(player.inventory, (TileModellerTable) world.getTileEntity(new BlockPos(x, y, z)));
        }
        return null;
    }

    /**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GUI_MODELLER_TABLE_ID) {
            return new GuiModellerTable(player.inventory, (TileModellerTable) world.getTileEntity(new BlockPos(x, y, z)));
        }
        return null;
    }

}
