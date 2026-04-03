package net.thenu.utils.BlockFamily;

import net.minecraft.block.AbstractBlock;

public record BlockFamilyDefinition(
        String name,
        AbstractBlock.Settings settings
) {}