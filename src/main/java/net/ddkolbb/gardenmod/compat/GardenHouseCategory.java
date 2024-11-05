package net.ddkolbb.gardenmod.compat;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.ddkolbb.gardenmod.GardenMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class GardenHouseCategory implements IRecipeCategory<GardenHouseCategory> {
    public static final ResourceLocation UID = new ResourceLocation(GardenMod.MOD_ID, "garden_house");
    public static final ResourceLocation TEXTURE = new ResourceLocation(GardenMod.MOD_ID,
            "texture/gui/garden_house_gui.png");


    @Override
    public RecipeType<GardenHouseCategory> getRecipeType() {
        return null;
    }

    @Override
    public Component getTitle() {
        return null;
    }

    @Override
    public IDrawable getBackground() {
        return null;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return null;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, GardenHouseCategory gardenHouseCategory, IFocusGroup iFocusGroup) {

    }
}
