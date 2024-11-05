package net.ddkolbb.gardenmod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = GardenMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
            .comment("Whether to log the dirt block on common setup")
            .define("logDirtBlock", true);

    private static final ForgeConfigSpec.IntValue MAGIC_NUMBER = BUILDER
            .comment("A magic number")
            .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);


    private static final ForgeConfigSpec.IntValue BASE_GROW = BUILDER
            .comment("The basic growth rate of plants inside the greenhouse")
            .defineInRange("basegrow", 2, 2, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue GROW_SPEEDLL = BUILDER
            .comment("The rate of plant growth in a greenhouse with POWEREDCALISALT")
            .defineInRange("growspeedll", 2, 2, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue GROW_SPEEDML = BUILDER
            .comment("The rate of plant growth in a greenhouse with UV_LIGHT")
            .defineInRange("growspeedml", 3, 2, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue SPEED_VALUE = BUILDER
            .comment("Speed for grow a plant in garden house")
            .defineInRange("speedValue", 2, 2, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue SPEED_VALUELL = BUILDER
            .comment("Multiplying yields when MICROCIRCUT_LL is installed inside the greenhouse")
            .defineInRange("speedValueLL", 2, 1, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue SPEED_VALUEML = BUILDER
            .comment("Multiplying yields when MICROCIRCUT_ML is installed inside the greenhouse")
            .defineInRange("speedValueML", 3, 1, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue SPEED_VALUEHL = BUILDER
            .comment("Multiplying yields when MICROCIRCUT_HL is installed inside the greenhouse")
            .defineInRange("speedValueHL", 4, 1, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
            .comment("What you want the introduction message to be for the magic number")
            .define("magicNumberIntroduction", "The magic number is... ");

    // a list of strings that are treated as resource locations for items
    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
            .comment("A list of items to log on common setup.")
            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean logDirtBlock;
    public static int magicNumber;
    public static int basegrow;
    public static int growspeedll;
    public static int growspeedml;
    public static int speedValue;
    public static int speedValueLL;
    public static int speedValueML;
    public static int speedValueHL;
    public static String magicNumberIntroduction;
    public static Set<Item> items;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        logDirtBlock = LOG_DIRT_BLOCK.get();
        magicNumber = MAGIC_NUMBER.get();
        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();
        speedValue = SPEED_VALUE.get();
        speedValueLL = SPEED_VALUELL.get();
        speedValueML = SPEED_VALUEML.get();
        speedValueHL = SPEED_VALUEHL.get();
        basegrow = BASE_GROW.get();
        growspeedll = GROW_SPEEDLL.get();
        growspeedml = GROW_SPEEDML.get();

        // convert the list of strings into a set of items
        items = ITEM_STRINGS.get().stream()
                .map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName)))
                .collect(Collectors.toSet());
    }
}
