package net.ddkolbb.gardenmod.datagen;

import net.ddkolbb.gardenmod.GardenMod;
import net.ddkolbb.gardenmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GardenMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.GARDEN_BLOCK.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/garden_house")));
        simpleBlock(ModBlocks.CALISALT_ORE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/calisaltore")));
        simpleBlock(ModBlocks.DEEPSLATE_CALISALTORE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/deepslate_calisaltore")));
    }



    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
