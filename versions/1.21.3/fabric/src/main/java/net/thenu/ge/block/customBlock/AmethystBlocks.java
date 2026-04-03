package net.thenu.ge.block.customBlock;

import net.minecraft.block.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.thenu.ge.GE;
import net.thenu.utils.BlockFamily.BlockFamily;
import net.thenu.utils.BlockFamily.BlockFamilyBuilder;
import net.thenu.utils.BlockFamily.BlockFamilyDefinition;

import static net.thenu.utils.Registries.Registering.registerBlock;

public class AmethystBlocks {

    public static void registerAmethystBlocks() {
        GE.LOGGER.info("Registering Amethyst blocks for " + GE.MOD_ID);
    }

    public static final BlockFamily AMETHYST_BRICKS = new BlockFamilyBuilder(GE.MOD_ID, new BlockFamilyDefinition(
            "amethyst_bricks", AbstractBlock.Settings.copy(Blocks.TUFF_BRICKS))).build();

    public static final BlockFamily SMOOTH_AMETHYST = new BlockFamilyBuilder(GE.MOD_ID, new BlockFamilyDefinition(
            "smooth_amethyst", AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK))).build();

    public static final BlockFamily SMOOTH_AMETHYST_BRICKS = new BlockFamilyBuilder(GE.MOD_ID, new BlockFamilyDefinition(
            "smooth_amethyst_bricks", AbstractBlock.Settings.copy(Blocks.TUFF_BRICKS))).build();

    public static final BlockFamily AMETHYST_PILLARS = new BlockFamilyBuilder(GE.MOD_ID, new BlockFamilyDefinition(
            "amethyst_pillars", AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK))).build();

    public static final BlockFamily CRACKED_AMETHYST_BRICKS = new BlockFamilyBuilder(GE.MOD_ID, new BlockFamilyDefinition(
            "cracked_amethyst_bricks", AbstractBlock.Settings.copy(Blocks.TUFF_BRICKS))).build();

    public static final BlockFamily AMETHYST_TILES = new BlockFamilyBuilder(GE.MOD_ID, new BlockFamilyDefinition(
            "amethyst_tiles", AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK))).build();

    public static final BlockFamily CHISELED_AMETHYST_BLOCK = new BlockFamilyBuilder(GE.MOD_ID, new BlockFamilyDefinition(
            "chiseled_amethyst_block", AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK))).build();

    // Registry keys are now required in block/item settings (1.21.2+)
    private static RegistryKey<Block> blockKey(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(GE.MOD_ID, name));
    }

    public static final Block CIRCULAR_AMETHYST_LAMP = registerBlock(
            "circular_amethyst_lamp",
            new RedstoneLampBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.PURPLE)
                    .strength(1.5f)
                    .luminance(state -> state.get(RedstoneLampBlock.LIT) ? 12 : 0)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .registryKey(blockKey("circular_amethyst_lamp"))));

    public static final Block CROSSED_AMETHYST_LAMP = registerBlock(
            "crossed_amethyst_lamp",
            new RedstoneLampBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.PURPLE)
                    .strength(1.5f)
                    .luminance(state -> state.get(RedstoneLampBlock.LIT) ? 12 : 0)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .registryKey(blockKey("crossed_amethyst_lamp"))));
}
