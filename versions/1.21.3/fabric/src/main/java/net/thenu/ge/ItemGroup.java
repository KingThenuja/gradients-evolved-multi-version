package net.thenu.ge;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.thenu.ge.block.GEBlocks;
import net.thenu.utils.Registries.ItemGroupRegistry;

public class ItemGroup {public static void registerItemGroup() {GE.LOGGER.info("Registering Item Group for " + GE.MOD_ID);}

    public static final net.minecraft.item.ItemGroup GRADIENTS_EVOLVED_BLOCKS_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(GE.MOD_ID, "ge_blocks_tab"),
            FabricItemGroup.builder().icon(() -> new ItemStack(GEBlocks.SLIGHTLY_MOSSY_COBBLESTONE.base()))
                    .displayName(Text.translatable("itemgroup.ge.ge_blocks_tab"))
                    .entries((context, entries) -> {
                        ItemGroupRegistry.getItems().forEach(entries::add);
                    })
                    .build()
    );
}
