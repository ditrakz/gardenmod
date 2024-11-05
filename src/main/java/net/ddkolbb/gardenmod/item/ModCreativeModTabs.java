package net.ddkolbb.gardenmod.item;


import net.ddkolbb.gardenmod.GardenMod;
import net.ddkolbb.gardenmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GardenMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> Creata_Garden = CREATIVE_MODE_TABS.register("creategarden",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAWCALISALT.get()))
                    .title(Component.translatable("creativetab.creategarden"))
                    .displayItems((itemDisplayParameters, output) -> {

                        // Main



                        // Item
                        output.accept(ModItems.RAWCALISALT.get());
                        output.accept(ModItems.POLISHADECALISALT.get());
                        output.accept(ModItems.POWEREDCALISALT.get());
                        output.accept(ModItems.BROWNPOWEREDSALTPETER.get());
                        output.accept(ModItems.NAIL.get());
                        output.accept(ModItems.SALTPETER.get());
                        output.accept(ModItems.UV_LIGHT.get());
                        output.accept(ModItems.RESIZTOR_LL.get());
                        output.accept(ModItems.CAPASITY_LL.get());
                        output.accept(ModItems.CAPASITY_ML.get());
                        output.accept(ModItems.RESIZTOR_ML.get());
                        output.accept(ModItems.CAPASITY_HL.get());
                        output.accept(ModItems.RESIZTOR_HL.get());
                        output.accept(ModItems.PROPELLER_SVO.get());
                        output.accept(ModItems.MICROCIRCUT_HL.get());
                        output.accept(ModItems.MICROCIRCUT_ML.get());
                        output.accept(ModItems.MICROCIRCUT_LL.get());

                        output.accept(ModItems.ROSIN.get());
                        output.accept(ModItems.DIRT_ROSIN_PAPER.get());
                        output.accept(ModItems.DIRT_ROSIN.get());


                        output.accept(ModItems.QUARTZ_SAND.get());
                        output.accept(ModItems.QUARTZ_GLASS_LIGHT.get());
                        output.accept(ModItems.BASE_UV_LIGHT.get());
                        output.accept(ModItems.UV_SVETODIOD.get());
                        output.accept(ModItems.BASE_UV_SVETODIOD.get());

                        output.accept(ModItems.DIELECTRIC.get());
                        output.accept(ModItems.CONDESATOR_CORPUS.get());
                        output.accept(ModItems.RAW_CONDESATOR_CORPUS.get());
                        // Block

                        output.accept(ModBlocks.CALISALT_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_CALISALTORE.get());
                        output.accept(ModBlocks.GARDEN_BLOCK.get());
                        // TOOLS

                        output.accept(ModItems.METALDETECTOR.get());
                        output.accept(ModItems.PROVERKABLUD.get());
                        output.accept(ModItems.SOLDERING_IRON.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
