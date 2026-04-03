package net.thenu.utils.BlockFamily;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.List;

public class BlockFamily {

    public final DeferredBlock<Block> base;
    public final DeferredBlock<Block> slab;
    public final DeferredBlock<Block> stairs;
    public final DeferredBlock<Block> wall;
    public final DeferredBlock<Block> fence;
    public final DeferredBlock<Block> fenceGate;

    public BlockFamily(DeferredBlock<Block> base,
                       DeferredBlock<Block> slab,
                       DeferredBlock<Block> stairs,
                       DeferredBlock<Block> wall,
                       DeferredBlock<Block> fence,
                       DeferredBlock<Block> fenceGate) {
        this.base = base;
        this.slab = slab;
        this.stairs = stairs;
        this.wall = wall;
        this.fence = fence;
        this.fenceGate = fenceGate;
    }

    public List<Block> getAll() {
        return List.of(base.get(), slab.get(), stairs.get(), wall.get(), fence.get(), fenceGate.get());
    }

    public Block base()      { return base.get(); }
    public Block slab()      { return slab.get(); }
    public Block stairs()    { return stairs.get(); }
    public Block wall()      { return wall.get(); }
    public Block fence()     { return fence.get(); }
    public Block fenceGate() { return fenceGate.get(); }
}
