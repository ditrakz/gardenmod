package net.ddkolbb.gardenmod.datagen;

import net.ddkolbb.gardenmod.GardenMod;
import net.ddkolbb.gardenmod.block.ModBlocks;
import net.ddkolbb.gardenmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GardenMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAWCALISALT);
        simpleItem(ModItems.METALDETECTOR);
        simpleItem(ModItems.SALTPETER);
        simpleItem(ModItems.MICROCIRCUT_HL);
        simpleItem(ModItems.MICROCIRCUT_ML);
        simpleItem(ModItems.MICROCIRCUT_LL);
        simpleItem(ModItems.BROWNPOWEREDSALTPETER);
        simpleItem(ModItems.CAPASITY_HL);
        simpleItem(ModItems.CAPASITY_ML);
        simpleItem(ModItems.CAPASITY_LL);
        simpleItem(ModItems.DIRT_ROSIN);
        simpleItem(ModItems.UV_LIGHT);
        simpleItem(ModItems.NAIL);
        simpleItem(ModItems.ROSIN);
        simpleItem(ModItems.PROVERKABLUD);
        simpleItem(ModItems.PROPELLER_SVO);
        simpleItem(ModItems.RESIZTOR_ML);
        simpleItem(ModItems.RESIZTOR_HL);
        simpleItem(ModItems.RESIZTOR_LL);
        simpleItem(ModItems.POWEREDCALISALT);
        simpleItem(ModItems.POLISHADECALISALT);
        simpleItem(ModItems.INCOMPLETE_MICROCIRCUT_HL);
        simpleItem(ModItems.INCOMPLETE_MICROCIRCUT_ML);
        simpleItem(ModItems.INCOMPLETE_MICROCIRCUT_LL);
        simpleItem(ModItems.DIRT_ROSIN_PAPER);
        simpleItem(ModItems.SOLDERING_IRON);
        simpleItem(ModItems.QUARTZ_SAND);
        simpleItem(ModItems.QUARTZ_GLASS_LIGHT);
        simpleItem(ModItems.BASE_UV_LIGHT);
        simpleItem(ModItems.UV_SVETODIOD);
        simpleItem(ModItems.BASE_UV_SVETODIOD);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(GardenMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}