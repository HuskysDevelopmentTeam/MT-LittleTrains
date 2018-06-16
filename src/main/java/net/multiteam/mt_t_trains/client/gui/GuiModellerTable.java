package net.multiteam.mt_t_trains.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.multiteam.mt_t_trains.container.ContainerModellerTable;
import net.multiteam.mt_t_trains.tileentity.TileModellerTable;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

public class GuiModellerTable extends GuiContainer {

    private TileModellerTable te;

    public GuiModellerTable(IInventory playerInv, TileModellerTable te) {
        super(new ContainerModellerTable(playerInv, te));
        this.te = te;
    }

    /**
     * Draws the background layer of this container (behind the items).
     *
     * @param partialTicks
     * @param mouseX
     * @param mouseY
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.mc.getTextureManager().bindTexture(new ResourceLocation(MOD_ID, "textures/gui/modeller_table_gui.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

}
