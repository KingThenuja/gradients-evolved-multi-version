package net.thenu.ge;

import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.thenu.ge.block.GEBlocks;

@Mod(Constants.MOD_ID)
public class GE {
    public static final String MOD_ID = "ge";

    public GE(IEventBus eventBus, ModContainer container) {
        GEBlocks.registerModBlocks();

        GEBlocks.BLOCKS.register(eventBus);
        GEBlocks.ITEMS.register(eventBus);
        ItemGroup.TABS.register(eventBus);
    }
}