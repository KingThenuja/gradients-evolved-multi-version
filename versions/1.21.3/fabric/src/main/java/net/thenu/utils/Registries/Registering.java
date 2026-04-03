package net.thenu.utils.Registries;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static net.thenu.ge.Constants.MOD_ID;

public class Registering {

    public static Block registerBlock(String name, Block block) {
        Identifier id       = Identifier.of(MOD_ID, name);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        RegistryKey<Item>  itemKey  = RegistryKey.of(RegistryKeys.ITEM,  id);

        // Re-create the block with the registry key in its settings (required in 1.21.2+)
        Block keyed;
        if (block instanceof RedstoneLampBlock) {
            keyed = new RedstoneLampBlock(
                AbstractBlock.Settings.copy(block).registryKey(blockKey)
            );
        } else {
            keyed = new Block(AbstractBlock.Settings.copy(block).registryKey(blockKey));
        }

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
}
