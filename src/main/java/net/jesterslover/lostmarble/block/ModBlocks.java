package net.jesterslover.lostmarble.block;

import net.jesterslover.lostmarble.LostMarbleAdditions;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    public static final Block PLATINUM_BLOCK = registerBlock("platinum_block",
            properties -> new Block(properties.strength(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final Block RAW_PLATINUM_BLOCK = registerBlock("raw_platinum_block",
            properties -> new Block(properties.strength(5f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final Block PLATINUM_ORE = registerBlock("platinum_ore",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final Block DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",
            properties -> new Block(properties.strength(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(LostMarbleAdditions.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(LostMarbleAdditions.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(LostMarbleAdditions.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(LostMarbleAdditions.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        LostMarbleAdditions.LOGGER.info("Registering Mod Blocks for " + LostMarbleAdditions.MOD_ID);
    }
}
