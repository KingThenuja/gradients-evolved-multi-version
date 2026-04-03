package net.thenu.utils.BlockFamily;

import net.minecraft.world.level.block.state.BlockBehaviour;

public record BlockFamilyDefinition(
        String name,
        BlockBehaviour.Properties properties
) {}