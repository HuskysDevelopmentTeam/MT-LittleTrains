package net.multiteam.mt_t_trains.items;

import net.hdt.huskylib2.items.ItemMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.multiteam.mt_t_trains.MTTTrains;
import net.multiteam.mt_t_trains.entity.EntityTrain;
import net.multiteam.mt_t_trains.enums.TrackVariants;
import net.multiteam.mt_t_trains.init.MTBlocks;

import java.util.function.Function;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

public class ItemModelTrain<E extends EntityTrain> extends ItemMod {

    private Function<World, E> entityCreator;

    public ItemModelTrain(String name, Function<World, E> something) {
        super(name, MOD_ID);
        entityCreator = something;
        setCreativeTab(MTTTrains.TRAINS_CREATIVE_TAB);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        EntityTrain entity = entityCreator.apply(worldIn);
        for(TrackVariants trackVariants : TrackVariants.values()) {
            if(!worldIn.isRemote && worldIn.getBlockState(pos).getBlock() == MTBlocks.TRACKS[trackVariants.getId()]) {
                entity.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ());
                worldIn.spawnEntity(entity);
                player.sendStatusMessage(new TextComponentString(TextFormatting.GREEN + String.format("Spawned a train at [X = %d, Y = %d, Z = %d]", pos.getX(), pos.getY(), pos.getZ())), true);
                return EnumActionResult.SUCCESS;
            }
        }
        player.sendStatusMessage(new TextComponentString(TextFormatting.RED + String.format("Could not spawn a train at [X = %d, Y = %d, Z = %d] because it's not a track", pos.getX(), pos.getY(), pos.getZ())), true);
        return EnumActionResult.PASS;
    }
}
