package net.thenu.utils;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.thenu.ge.block.GEBlocks;
import net.thenu.ge.block.customBlock.AmethystBlocks;
import net.thenu.utils.BlockFamily.BlockFamily;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HelperLists {

    public static List<BlockFamily> getAllMossyCobblestoneBlocks() {return List.of(GEBlocks.SLIGHTLY_MOSSY_COBBLESTONE, GEBlocks.OVERLY_MOSSY_COBBLESTONE, GEBlocks.MOSSEND_COBBLESTONE, GEBlocks.MOSSING_COBBLESTONE, GEBlocks.FULLY_COVERED_MOSSY_COBBLESTONE);}
    public static List<BlockFamily> getAllMossyDeepslateBlocks() {return List.of(GEBlocks.SLIGHTLY_MOSSY_DEEPSLATE, GEBlocks.OVERLY_MOSSY_DEEPSLATE, GEBlocks.MOSSEND_DEEPSLATE, GEBlocks.MOSSING_DEEPSLATE, GEBlocks.FULLY_COVERED_MOSSY_DEEPSLATE, GEBlocks.MOSSY_DEEPSLATE);}
    public static List<BlockFamily> getAllDiamondNetheriteEmeraldGlowstoneIronGoldRedstoneLapisBlocks() {return List.of(GEBlocks.DIAMOND, GEBlocks.NETHERITE, GEBlocks.IRON, GEBlocks.GOLD, GEBlocks.GLOWSTONE, GEBlocks.EMERALD, GEBlocks.REDSTONE, GEBlocks.LAPIS);}
    public static Map<BlockFamily, ItemConvertible> getMaterialFamilyIngredients() {Map<BlockFamily, ItemConvertible> map = new LinkedHashMap<>();map.put(GEBlocks.DIAMOND,   Items.DIAMOND);map.put(GEBlocks.IRON,      Items.IRON_INGOT);map.put(GEBlocks.GOLD,      Items.GOLD_INGOT);map.put(GEBlocks.EMERALD,   Items.EMERALD);map.put(GEBlocks.REDSTONE,  Items.REDSTONE);map.put(GEBlocks.LAPIS,     Items.LAPIS_LAZULI);map.put(GEBlocks.NETHERITE, Items.NETHERITE_INGOT);map.put(GEBlocks.GLOWSTONE, Items.GLOWSTONE_DUST);return map;}
    public static List<BlockFamily> getAllAmethystBlocks() {return List.of(AmethystBlocks.AMETHYST_BRICKS, AmethystBlocks.SMOOTH_AMETHYST, AmethystBlocks.SMOOTH_AMETHYST_BRICKS, AmethystBlocks.AMETHYST_PILLARS, AmethystBlocks.CRACKED_AMETHYST_BRICKS, AmethystBlocks.AMETHYST_TILES, AmethystBlocks.CHISELED_AMETHYST_BLOCK);}


}
