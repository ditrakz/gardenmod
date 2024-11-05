package net.ddkolbb.gardenmod.datagen;

import com.simibubi.create.Create;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.content.equipment.wrench.WrenchEventHandler;
import com.simibubi.create.content.equipment.wrench.WrenchItem;
import net.ddkolbb.gardenmod.GardenMod;
import net.ddkolbb.gardenmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GardenMod.MOD_ID, existingFileHelper);
    }



    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CALISALT_ORE.get(),
                        ModBlocks.DEEPSLATE_CALISALTORE.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CALISALT_ORE.get(),
                        ModBlocks.DEEPSLATE_CALISALTORE.get()
                );
    }
}
