package net.jesterslover.lostmarble.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jesterslover.lostmarble.block.ModBlocks;
import net.jesterslover.lostmarble.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> PLATINUM_SMELTABLES = List.of(ModItems.RAW_PLATINUM, ModBlocks.PLATINUM_ORE, ModBlocks.DEEPSLATE_PLATINUM_ORE);

                oreSmelting(PLATINUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.PLATINUM, 0.25f, 200, "platinum");
                oreBlasting(PLATINUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.PLATINUM, 0.25f, 100, "platinum");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.PLATINUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLATINUM_BLOCK);

                shaped(RecipeCategory.MISC, ModBlocks.RAW_PLATINUM_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.RAW_PLATINUM)
                        .unlockedBy(getHasName(ModItems.RAW_PLATINUM), has(ModItems.RAW_PLATINUM))
                        .group("platinum")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_PLATINUM, 9)
                        .requires(ModBlocks.RAW_PLATINUM_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.RAW_PLATINUM_BLOCK), has(ModBlocks.RAW_PLATINUM_BLOCK))
                        .group("platinum")
                        .save(output);

            }
        };
    }

    @Override
    public String getName() {
        return "LostMarbleAdditions Recipes";
    }
}
