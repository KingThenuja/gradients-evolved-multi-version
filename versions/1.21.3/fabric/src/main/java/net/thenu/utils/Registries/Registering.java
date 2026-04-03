package net.thenu.utils.Registries;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static net.thenu.ge.Constants.MOD_ID;

public class Registering {

    /**
     * Register a block that was already constructed WITH its registry key in settings.
     * The caller is responsible for passing .registryKey(...) into the block's settings
     * BEFORE calling new Block(...), because AbstractBlock.<init> reads the key immediately.
     */
    public static Block registerBlock(String name, Block block) {
        Identifier id      = Identifier.of(MOD_ID, name);
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
