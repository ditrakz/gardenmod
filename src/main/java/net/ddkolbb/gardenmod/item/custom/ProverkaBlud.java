package net.ddkolbb.gardenmod.item.custom;
import net.ddkolbb.gardenmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ProverkaBlud extends Item {

    public ProverkaBlud(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            BlockState state = pContext.getLevel().getBlockState(positionClicked);
            ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND); // Получаем ItemStack из руки игрока

            player.sendSystemMessage(Component.literal("It's: " + state.getBlock().getDescriptionId()));
            if (state.getBlock().getDescriptionId() == Blocks.SWEET_BERRY_BUSH.getDescriptionId()) {
                player.sendSystemMessage(Component.literal("Bush!"));
                pContext.getLevel().levelEvent(1505, positionClicked, 0);

                // Apply bone meal functionality manually
                if (stack.getItem() == ModItems.PROVERKABLUD.get()) { // Проверяем, является ли предмет ProverkaBlud
                    // Check if the block is a sweet berry bush
                    if (state.getBlock() == Blocks.SWEET_BERRY_BUSH) {
                        // Get the block state with the maximum age property
                        BlockState bushState = state.getBlock().defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3);

                        // Set the block state to the updated state
                        pContext.getLevel().setBlock(positionClicked, bushState, 2);

                        // Consume the ProverkaBlud item
                        stack.shrink(1);
                    }
                }
            }
        }

        return InteractionResult.SUCCESS;
    }
}