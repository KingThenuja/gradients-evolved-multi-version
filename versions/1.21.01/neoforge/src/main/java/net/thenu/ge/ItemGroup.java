package net.thenu.ge;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.thenu.ge.block.GEBlocks;
import net.thenu.utils.Registries.ItemGroupRegistry;

public class ItemGroup {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GE.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GRADIENTS_EVOLVED_BLOCKS_TAB = TABS.register(
            "ge_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(GEBlocks.SLIGHTLY_MOSSY_COBBLESTONE.base()))
                    .title(Component.translatable("itemgroup.ge.ge_blocks_tab"))
                    .displayItems((params, output) -> {
                        ItemGroupRegistry.getItems().forEach(output::accept);
                    })
                    .build()
    );

    public static void registerItemGroup() {
    }
}