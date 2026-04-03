package net.thenu.ge.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.thenu.ge.GE;
import net.thenu.ge.block.customBlock.AmethystBlocks;
import net.thenu.utils.BlockFamily.BlockFamily;
import net.thenu.utils.BlockFamily.BlockFamilyBuilder;
import net.thenu.utils.BlockFamily.BlockFamilyDefinition;

public class GEBlocks {

    private static final String MODID = GE.MOD_ID;

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items  ITEMS  = DeferredRegister.createItems(MODID);

    public static void registerModBlocks() {
        AmethystBlocks.registerAmethystBlocks();
    }

    private static BlockFamilyBuilder builder(String name, BlockBehaviour.Properties props) {
        return new BlockFamilyBuilder(MODID, new BlockFamilyDefinition(name, props), BLOCKS, ITEMS);
    }

    public static final BlockFamily SLIGHTLY_MOSSY_COBBLESTONE      = builder("slightly_mossy_cobblestone",      BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)).build();
    public static final BlockFamily OVERLY_MOSSY_COBBLESTONE        = builder("overly_mossy_cobblestone",        BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)).build();
    public static final BlockFamily MOSSEND_COBBLESTONE             = builder("mossend_cobblestone",             BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)).build();
    public static final BlockFamily MOSSING_COBBLESTONE             = builder("mossing_cobblestone",             BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)).build();
    public static final BlockFamily FULLY_COVERED_MOSSY_COBBLESTONE = builder("fully_covered_mossy_cobblestone", BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE)).build();

    public static final BlockFamily SLIGHTLY_MOSSY_DEEPSLATE        = builder("slightly_mossy_deepslate",        BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)).build();
    public static final BlockFamily MOSSY_DEEPSLATE                 = builder("mossy_deepslate",                 BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)).build();
    public static final BlockFamily OVERLY_MOSSY_DEEPSLATE          = builder("overly_mossy_deepslate",          BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)).build();
    public static final BlockFamily MOSSEND_DEEPSLATE               = builder("mossend_deepslate",               BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)).build();
    public static final BlockFamily MOSSING_DEEPSLATE               = builder("mossing_deepslate",               BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)).build();
    public static final BlockFamily FULLY_COVERED_MOSSY_DEEPSLATE   = builder("fully_covered_mossy_deepslate",   BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)).build();

    public static final BlockFamily DIAMOND   = builder("diamond",      BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)).build();
    public static final BlockFamily IRON      = builder("iron",         BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)).build();
    public static final BlockFamily GOLD      = builder("gold",         BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)).build();
    public static final BlockFamily EMERALD   = builder("emerald",      BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)).build();
    public static final BlockFamily REDSTONE  = builder("redstone",     BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)).build();
    public static final BlockFamily LAPIS     = builder("lapis_lazuli", BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)).build();
    public static final BlockFamily NETHERITE = builder("netherite",    BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)).build();
    public static final BlockFamily GLOWSTONE = builder("glowstone",    BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE).lightLevel(state -> 15)).build();
}