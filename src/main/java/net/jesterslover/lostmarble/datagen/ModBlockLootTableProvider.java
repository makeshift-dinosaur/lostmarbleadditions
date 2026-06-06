package net.jesterslover.lostmarble.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.jesterslover.lostmarble.block.ModBlocks;
import net.jesterslover.lostmarble.item.ModItems;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.PLATINUM_BLOCK);
        dropSelf(ModBlocks.RAW_PLATINUM_BLOCK);

        add(ModBlocks.PLATINUM_ORE, createOreDrop(ModBlocks.PLATINUM_ORE, ModItems.RAW_PLATINUM));
        add(ModBlocks.DEEPSLATE_PLATINUM_ORE, createOreDrop(ModBlocks.PLATINUM_ORE, ModItems.RAW_PLATINUM));


    }
}
