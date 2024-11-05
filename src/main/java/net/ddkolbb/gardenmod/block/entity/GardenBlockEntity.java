package net.ddkolbb.gardenmod.block.entity;

import com.ibm.icu.impl.coll.CollationFastLatin;
import net.ddkolbb.gardenmod.Config;
import net.ddkolbb.gardenmod.item.ModItems;
import net.ddkolbb.gardenmod.screen.GardenHouseMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class GardenBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(7);


    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int ADVANCE_SLOT = 2;
    private static final int ADVANCE_DROP_SLOT = 3;
    private static final int OUPGRADE_SLOT = 4; // Новый слот для удобрений
    private static final int TUPGRADE_SLOT = 5; // Новый слот для улучшений
    private static final int UPGRADETH_SLOT = 6; // Новый слот для улучшений


    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    private final ContainerData data;
    private int progress = 0;
    private int maxProgress = 300;

    private static final Map<Item, Item> SEED_TO_CROP_MAP = new HashMap<>();

    static {
        SEED_TO_CROP_MAP.put(Items.WHEAT_SEEDS, Items.WHEAT);
        SEED_TO_CROP_MAP.put(Items.CARROT, Items.CARROT);
        SEED_TO_CROP_MAP.put(Items.POTATO, Items.POTATO);
        SEED_TO_CROP_MAP.put(Items.APPLE, Items.APPLE);
        SEED_TO_CROP_MAP.put(Items.SUGAR_CANE, Items.SUGAR_CANE);
        // Добавьте другие соответствия семян и урожая здесь
    }

    public GardenBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlocksEntities.GARDEN_HOUSE_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> GardenBlockEntity.this.progress;
                    case 1 -> GardenBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> GardenBlockEntity.this.progress = pValue;
                    case 1 -> GardenBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override public int getCount() {
                return 2;
            }
        };
    }

    @Override public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override public Component getDisplayName() {
        return Component.translatable("block.gardenmod.garden_house");
    }

    @Override public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new GardenHouseMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("garden_house.progress", progress);
        super.saveAdditional(pTag);
    }

    @Override public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("garden_house.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (hasSeedsInInputSlot() && canInsertItemOutputSlot(getGrownItem().getItem()) && canInsertAmountIntoOutputSlot(getGrownItem().getCount())) {
            increaseGrowthProgress();
            setChanged(pLevel, pPos, pState);

            if (hasGrowthFinished()) {
                moveGrownItemToOutput();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private boolean canInsertItemOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean hasGrowthFinished() {
        return progress >= maxProgress;
    }

    private void increaseGrowthProgress() {
        ItemStack advanceStack = this.itemHandler.getStackInSlot(ADVANCE_SLOT);
        ItemStack twupgslot = this.itemHandler.getStackInSlot(TUPGRADE_SLOT);
        if (!advanceStack.isEmpty() && advanceStack.getItem() == ModItems.POWEREDCALISALT.get()) {
            progress += Config.growspeedll; // Ускоряем рост на 3, если используется SALTPETER
        } else if (!twupgslot.isEmpty() && twupgslot.getItem() == ModItems.UV_LIGHT.get()) {
            progress += Config.growspeedml;
        } else if (!twupgslot.isEmpty() && twupgslot.getItem() == ModItems.PROPELLER_SVO.get()) {
            progress += 2;
        } else {
            progress += Config.basegrow;
        }
    }

    // Пример изменения метода moveGrownItemToOutput
    private void moveGrownItemToOutput() {
        int yieldMultiplier = 1;

        ItemStack advanceStack = this.itemHandler.getStackInSlot(ADVANCE_SLOT);
        ItemStack onupgslot = this.itemHandler.getStackInSlot(OUPGRADE_SLOT);
        ItemStack thupgslot = this.itemHandler.getStackInSlot(UPGRADETH_SLOT);

        if (!advanceStack.isEmpty() && advanceStack.getItem() == ModItems.SALTPETER.get()) {
            yieldMultiplier = 2; // Удваиваем урожайность при использовании SALTPETER
        }
        if (!onupgslot.isEmpty() && onupgslot.getItem() == ModItems.MICROCIRCUT_LL.get()) {
            yieldMultiplier += Config.speedValueLL;
        } else if (!onupgslot.isEmpty() && onupgslot.getItem() == ModItems.MICROCIRCUT_ML.get()) {
            yieldMultiplier += Config.speedValueML;
        } else if (!onupgslot.isEmpty() && onupgslot.getItem() == ModItems.MICROCIRCUT_HL.get()) {
            yieldMultiplier += Config.speedValueHL;
        }


        ItemStack grownItem = getGrownItem();
        grownItem.setCount(grownItem.getCount() * yieldMultiplier);

        ItemStack outputStack = this.itemHandler.getStackInSlot(OUTPUT_SLOT);
        int newCount = outputStack.getCount() + grownItem.getCount();

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(grownItem.getItem(), newCount));



        // Извлекаем семена и удобрение, если оно использовано
        if (!advanceStack.isEmpty()) {
            this.itemHandler.extractItem(ADVANCE_SLOT, 1, false);
        }
    }


    private ItemStack getGrownItem() {
        ItemStack inputStack = this.itemHandler.getStackInSlot(INPUT_SLOT);
        Item grownItem = SEED_TO_CROP_MAP.getOrDefault(inputStack.getItem(), Items.AIR);
        return new ItemStack(grownItem, 2); // Выращиваем 2 единиц урожая по умолчанию
    }

    private boolean hasSeedsInInputSlot() {
        ItemStack inputStack = this.itemHandler.getStackInSlot(INPUT_SLOT);
        return !inputStack.isEmpty() && SEED_TO_CROP_MAP.containsKey(inputStack.getItem());
    }
}