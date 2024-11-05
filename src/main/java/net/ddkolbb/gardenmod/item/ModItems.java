package net.ddkolbb.gardenmod.item;

import net.ddkolbb.gardenmod.GardenMod;
import net.ddkolbb.gardenmod.item.custom.MetalDetectoritem;
import net.ddkolbb.gardenmod.item.custom.ProverkaBlud;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GardenMod.MOD_ID);

    public static final RegistryObject<Item> RAWCALISALT = ITEMS.register("rawcalisalt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POLISHADECALISALT = ITEMS.register("polishadecalisalt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POWEREDCALISALT = ITEMS.register("powered_calisalt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BROWNPOWEREDSALTPETER = ITEMS.register("brown_powered_saltpeter",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NAIL = ITEMS.register("nailgarden",
            () -> new Item(new Item.Properties().stacksTo(32)));
    public static final RegistryObject<Item> UV_LIGHT = ITEMS.register("uv_light",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SALTPETER = ITEMS.register("clear_saltpeter",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PROPELLER_SVO = ITEMS.register("propeller_garden",
            () -> new Item(new Item.Properties().stacksTo(32)));

    public static final RegistryObject<Item> RESIZTOR_ML = ITEMS.register("resistor_ml",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> RESIZTOR_LL = ITEMS.register("resistor_ll",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> RESIZTOR_HL = ITEMS.register("resistor_hl",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> CAPASITY_LL = ITEMS.register("condesator_ll",
            () -> new Item(new Item.Properties().stacksTo(32)));
    public static final RegistryObject<Item> CAPASITY_ML = ITEMS.register("condesator_ml",
            () -> new Item(new Item.Properties().stacksTo(32)));
    public static final RegistryObject<Item> CAPASITY_HL = ITEMS.register("condesator_hl",
            () -> new Item(new Item.Properties().stacksTo(32)));

    public static final RegistryObject<Item> MICROCIRCUT_LL = ITEMS.register("microcircuit_ll",
            () -> new Item(new Item.Properties().stacksTo(32)));
    public static final RegistryObject<Item> MICROCIRCUT_ML = ITEMS.register("microcircuit_ml",
            () -> new Item(new Item.Properties().stacksTo(32).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> MICROCIRCUT_HL = ITEMS.register("microcircuit_hl",
            () -> new Item(new Item.Properties().stacksTo(32).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> INCOMPLETE_MICROCIRCUT_ML = ITEMS.register("incomplete_microcircut_ml",
            () -> new Item(new Item.Properties().stacksTo(32)));
    public static final RegistryObject<Item> INCOMPLETE_MICROCIRCUT_LL = ITEMS.register("incomplete_microcircut_ll",
            () -> new Item(new Item.Properties().stacksTo(32)));
    public static final RegistryObject<Item> INCOMPLETE_MICROCIRCUT_HL = ITEMS.register("incomplete_microcircut_hl",
            () -> new Item(new Item.Properties().stacksTo(32)));

    public static final RegistryObject<Item> METALDETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectoritem(new Item.Properties()));
    public static final RegistryObject<Item> PROVERKABLUD = ITEMS.register("proverka_blud",
            () -> new ProverkaBlud(new Item.Properties()));

    public static final RegistryObject<Item> ROSIN = ITEMS.register("rosin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIRT_ROSIN = ITEMS.register("dirt_rosin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIRT_ROSIN_PAPER = ITEMS.register("dirt_rosin_paper",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> QUARTZ_SAND = ITEMS.register("quartz_sand",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_GLASS_LIGHT = ITEMS.register("quartz_glass_light",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BASE_UV_LIGHT = ITEMS.register("base_uv_light",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UV_SVETODIOD = ITEMS.register("uv_svetodiod",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BASE_UV_SVETODIOD = ITEMS.register("base_uv_svetodiod",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIELECTRIC = ITEMS.register("dielectric",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_CONDESATOR_CORPUS = ITEMS.register("raw_condesator_corpus",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CONDESATOR_CORPUS = ITEMS.register("condesator_corpus",
            () -> new Item(new Item.Properties()));

    // TOOLS
    public static final RegistryObject<Item> SOLDERING_IRON = ITEMS.register("soldering_iron",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
