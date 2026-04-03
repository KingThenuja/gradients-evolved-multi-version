package net.thenu.utils.BlockFamily;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.thenu.utils.Registries.ItemGroupRegistry;

public class BlockFamilyBuilder {

    private final String modId;
    private final BlockFamilyDefinition definition;

    public BlockFamilyBuilder(String modId, BlockFamilyDefinition definition) {
        this.modId = modId;
        this.definition = definition;
    }

    public BlockFamily build() {
        String name = definition.name();
        AbstractBlock.Settings baseSettings = definition.settings();

        // 1.21.2+: registry key MUST be in settings before new Block(...) is called,
        // because AbstractBlock.<init> calls getLootTableKey() immediately.
        Block base      = reg(modId, name,                new Block(keyed(modId, name,                baseSettings)));
        Block stairs    = reg(modId, name + "_stairs",    new StairsBlock(base.getDefaultState(),     keyed(modId, name + "_stairs",    AbstractBlock.Settings.copy(base))));
        Block slab      = reg(modId, name + "_slab",      new SlabBlock(                              keyed(modId, name + "_slab",      AbstractBlock.Settings.copy(base))));
        Block fence     = reg(modId, name + "_fence",     new FenceBlock(                             keyed(modId, name + "_fence",     AbstractBlock.Settings.copy(base))));
        Block fenceGate = reg(modId, name + "_fence_gate",new FenceGateBlock(WoodType.OAK,            keyed(modId, name + "_fence_gate",AbstractBlock.Settings.copy(base))));
        Block wall      = reg(modId, name + "_wall",      new WallBlock(                              keyed(modId, name + "_wall",      AbstractBlock.Settings.copy(base))));

        return new BlockFamily(base, slab, stairs, wall, fence, fenceGate);
    }

    /** Returns settings with the block registry key baked in (required before Block construction). */
    private static AbstractBlock.Settings keyed(String modId, String name, AbstractBlock.Settings settings) {
        return settings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(modId, name)));
    }

    private Block reg(String modId, String name, Block block) {
        Identifier id      = Identifier.of(modId, name);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        RegistryKey<Item>  itemKey  = RegistryKey.of(RegistryKeys.ITEM,  id);

        Registry.register(Registries.BLOCK, blockKey, block);

        BlockItem item = Registry.register(
                Registries.ITEM,
                itemKey,
                new BlockItem(block, new Item.Settings()
                        .registryKey(itemKey)
                        .useBlockPrefixedTranslationKey())
        );
        ItemGroupRegistry.add(item);
        return block;
    }
}
