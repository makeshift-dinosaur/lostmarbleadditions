package net.jesterslover.lostmarble.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.jesterslover.lostmarble.LostMarbleAdditions;
import net.jesterslover.lostmarble.block.ModBlocks;
import net.jesterslover.lostmarble.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab PLATINUM_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(LostMarbleAdditions.MOD_ID, "platinum_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PLATINUM))
                    .title(Component.translatable("creativemodetab.lostmarbleadditions.platinum_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.PLATINUM);
                        output.accept(ModItems.RAW_PLATINUM);


                    }).build());


    public static final CreativeModeTab PLATINUM_BLOCK_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(LostMarbleAdditions.MOD_ID, "platinum_blocks"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PLATINUM_BLOCK))
                    .title(Component.translatable("creativemodetab.lostmarbleadditions.platinum_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.PLATINUM_BLOCK);
                        output.accept(ModBlocks.PLATINUM_ORE);


                    }).build());

    public static void registerModCreativeModeTabs() {
        LostMarbleAdditions.LOGGER.info("Registering Creative Mode Tabs for " + LostMarbleAdditions.MOD_ID);
    }
}
