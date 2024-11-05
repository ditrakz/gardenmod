package net.ddkolbb.gardenmod.block.entity;

import net.ddkolbb.gardenmod.GardenMod;
import net.ddkolbb.gardenmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.*;

public class ModBlocksEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GardenMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<GardenBlockEntity>> GARDEN_HOUSE_BE =
            BLOCK_ENTITIES.register("garden_house_be", () ->
                    BlockEntityType.Builder.of(GardenBlockEntity::new,
                            ModBlocks.GARDEN_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
