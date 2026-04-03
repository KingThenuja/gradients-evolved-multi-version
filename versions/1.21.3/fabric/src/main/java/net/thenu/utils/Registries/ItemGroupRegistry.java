package net.thenu.utils.Registries;

import net.minecraft.item.ItemConvertible;

import java.util.ArrayList;
import java.util.List;

public class ItemGroupRegistry {

    private static final List<ItemConvertible> AUTO_ITEMS = new ArrayList<>();

    public static void add(ItemConvertible item) {
        AUTO_ITEMS.add(item);
    }

    public static List<ItemConvertible> getItems() {
        return AUTO_ITEMS;
    }
}
