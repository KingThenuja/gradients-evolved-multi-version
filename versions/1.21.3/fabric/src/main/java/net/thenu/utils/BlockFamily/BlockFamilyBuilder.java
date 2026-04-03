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

        Block base      = registerBlock(modId, name,                new Block(baseSettings));
        Block stairs    = registerBlock(modId, name + "_stairs",    new StairsBlock(base.getDefaultState(), AbstractBlock.Settings.copy(base)));
        Block slab      = registerBlock(modId, name + "_slab",      new SlabBlock(AbstractBlock.Settings.copy(base)));
        Block fence     = registerBlock(modId, name + "_fence",     new FenceBlock(AbstractBlock.Settings.copy(base)));
        Block fenceGate = registerBlock(modId, name + "_fence_gate",new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(base)));
        Block wall      = registerBlock(modId, name + "_wall",      new WallBlock(AbstractBlock.Settings.copy(base)));

        return new BlockFamily(base, slab, stairs, wall, fence, fenceGate);
    }

    private Block registerBlock(String modId, String name, Block block) {
        Identifier id = Identifier.of(modId, name);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        RegistryKey<Item>  itemKey  = RegistryKey.of(RegistryKeys.ITEM,  id);

        // Re-create block with registry key baked into settings
        Block keyed = recreateWithKey(name, block, blockKey);

        Registry.register(Registries.BLOCK, blockKey, keyed);

        BlockItem item = Registry.register(
                Registries.ITEM,
                itemKey,
                new BlockItem(keyed, new Item.Settings()
                        .registryKey(itemKey)
                        .useBlockPrefixedTranslationKey())
        );
        ItemGroupRegistry.add(item);
        return keyed;
    }

    /**
     * 1.21.2+ requires the registry key baked into AbstractBlock.Settings.
     * We do this by copying the settings and appending .registryKey(key).
     */
    private static Block recreateWithKey(String name, Block original, RegistryKey<Block> key) {
        // The block was already constructed; we cannot retroactively inject the key into its
        // settings field. Instead we override the loot-table lookup by passing a fresh settings
        // object with the registry key set. We can't reach the original settings, so we copy
        // from the already-created block and re-instantiate the same type.
        //
        // For simple Block / StairsBlock / SlabBlock / WallBlock / FenceBlock / FenceGateBlock
        // there is no extra state, so re-instantiation is safe.
        AbstractBlock.Settings s = AbstractBlock.Settings.copy(original).registryKey(key);
        if (original instanceof StairsBlock sb) {
            return new StairsBlock(sb.getDefaultState(), s);
        } else if (original instanceof SlabBlock) {
            return new SlabBlock(s);
        } else if (original instanceof FenceBlock) {
            return new FenceBlock(s);
        } else if (original instanceof FenceGateBlock) {
            return new FenceGateBlock(WoodType.OAK, s);
        } else if (original instanceof WallBlock) {
            return new WallBlock(s);
        } else {
            return new Block(s);
        }
    }
}
