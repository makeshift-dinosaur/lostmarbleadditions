package net.jesterslover.lostmarble.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.jesterslover.lostmarble.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public  ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PLATINUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_PLATINUM_ORE)
                .add(ModBlocks.RAW_PLATINUM_BLOCK)
                .add(ModBlocks.PLATINUM_ORE);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.PLATINUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_PLATINUM_ORE)
                .add(ModBlocks.RAW_PLATINUM_BLOCK)
                .add(ModBlocks.PLATINUM_ORE);

    }
}
