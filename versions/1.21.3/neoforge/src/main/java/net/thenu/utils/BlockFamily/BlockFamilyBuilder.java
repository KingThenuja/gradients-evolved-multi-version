package net.thenu.utils.BlockFamily;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.thenu.utils.Registries.ItemGroupRegistry;

import java.util.function.Supplier;

public class BlockFamilyBuilder {

    private final String modId;
    private final BlockFamilyDefinition definition;
    private final DeferredRegister.Blocks blockRegister;
    private final DeferredRegister.Items itemRegister;

    public BlockFamilyBuilder(String modId, BlockFamilyDefinition definition,
                              DeferredRegister.Blocks blockRegister,
                              DeferredRegister.Items itemRegister) {
        this.modId = modId;
        this.definition = definition;
        this.blockRegister = blockRegister;
        this.itemRegister = itemRegister;
    }

    public BlockFamily build() {
        String name = definition.name();
        BlockBehaviour.Properties baseProps = definition.properties();

        DeferredBlock<Block> base      = register(name,                () -> new Block(withKey(modId, name, baseProps)));
        DeferredBlock<Block> stairs    = register(name + "_stairs",    () -> new StairBlock(base.get().defaultBlockState(), withKeyCopy(modId, name + "_stairs", base.get())));
        DeferredBlock<Block> slab      = register(name + "_slab",      () -> new SlabBlock(withKeyCopy(modId, name + "_slab",      base.get())));
        DeferredBlock<Block> fence     = register(name + "_fence",     () -> new FenceBlock(withKeyCopy(modId, name + "_fence",     base.get())));
        DeferredBlock<Block> fenceGate = register(name + "_fence_gate",() -> new FenceGateBlock(WoodType.OAK, withKeyCopy(modId, name + "_fence_gate", base.get())));
        DeferredBlock<Block> wall      = register(name + "_wall",      () -> new WallBlock(withKeyCopy(modId, name + "_wall",      base.get())));

        return new BlockFamily(base, slab, stairs, wall, fence, fenceGate);
    }

    // 1.21.2+: block settings must carry the registry key
    private static BlockBehaviour.Properties withKey(String modId, String name, BlockBehaviour.Properties props) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(modId, name));
        return props.setId(key);
    }

    private static BlockBehaviour.Properties withKeyCopy(String modId, String name, Block base) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(modId, name));
        return BlockBehaviour.Properties.ofFullCopy(base).setId(key);
    }

    private DeferredBlock<Block> register(String name, Supplier<Block> supplier) {
        DeferredBlock<Block> block = blockRegister.register(name, supplier);
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(modId, name));
        itemRegister.register(name, () -> {
            // 1.21.2+: item settings must also carry the registry key
            BlockItem item = new BlockItem(block.get(), new Item.Properties()
                    .setId(itemKey)
                    .useBlockDescriptionPrefix());
            ItemGroupRegistry.add(item);
            return item;
        });
        return block;
    }
}
