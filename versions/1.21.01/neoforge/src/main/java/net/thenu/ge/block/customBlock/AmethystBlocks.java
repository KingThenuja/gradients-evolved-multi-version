package net.thenu.ge.block.customBlock;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.thenu.ge.GE;
import net.thenu.ge.block.GEBlocks;
import net.thenu.utils.BlockFamily.BlockFamily;
import net.thenu.utils.BlockFamily.BlockFamilyBuilder;
import net.thenu.utils.BlockFamily.BlockFamilyDefinition;
import net.thenu.utils.Registries.ItemGroupRegistry;

public class AmethystBlocks {

    public static void registerAmethystBlocks() {
    }

    private static BlockFamilyBuilder builder(String name, BlockBehaviour.Properties props) {
        return new BlockFamilyBuilder(GE.MOD_ID, new BlockFamilyDefinition(name, props), GEBlocks.BLOCKS, GEBlocks.ITEMS);
    }

    public static final BlockFamily AMETHYST_BRICKS        = builder("amethyst_bricks",        BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_BRICKS)).build();
    public static final BlockFamily SMOOTH_AMETHYST         = builder("smooth_amethyst",         BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)).build();
    public static final BlockFamily SMOOTH_AMETHYST_BRICKS  = builder("smooth_amethyst_bricks",  BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_BRICKS)).build();
    public static final BlockFamily AMETHYST_PILLARS        = builder("amethyst_pillars",        BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)).build();
    public static final BlockFamily CRACKED_AMETHYST_BRICKS = builder("cracked_amethyst_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF_BRICKS)).build();
    public static final BlockFamily AMETHYST_TILES          = builder("amethyst_tiles",          BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)).build();
    public static final BlockFamily CHISELED_AMETHYST_BLOCK = builder("chiseled_amethyst_block", BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)).build();

    public static final DeferredBlock<Block> CIRCULAR_AMETHYST_LAMP = registerLamp("circular_amethyst_lamp");
    public static final DeferredBlock<Block> CROSSED_AMETHYST_LAMP  = registerLamp("crossed_amethyst_lamp");

    private static DeferredBlock<Block> registerLamp(String name) {
        DeferredBlock<Block> block = GEBlocks.BLOCKS.register(name, () ->
                new RedstoneLampBlock(BlockBehaviour.Properties.of()
                        .mapColor(MapColor.COLOR_PURPLE)
                        .strength(1.5f)
                        .lightLevel(state -> state.getValue(RedstoneLampBlock.LIT) ? 12 : 0)
                        .sound(SoundType.AMETHYST)));
        GEBlocks.ITEMS.register(name, () -> {
            BlockItem item = new BlockItem(block.get(), new Item.Properties());
            ItemGroupRegistry.add(item);
            return item;
        });
        return block;
    }
}