package com.github.normallib.inventory;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryUtil {

    public static void forEachItem(Inventory inventory, Consumer<ItemStack> action) {
        for (ItemStack item : inventory.getContents()) {
            if (item != null) {
                action.accept(item);
            }
        }
    }

    public static void forEachItem(Inventory inventory, Predicate<ItemStack> condition, Consumer<ItemStack> action) {
        for (ItemStack item : inventory.getContents()) {
            if (item != null && condition.test(item)) {
                action.accept(item);
            }
        }
    }

    public static Inventory distinctInventory(Inventory inventory,boolean generate){
        return new InventorySorter().distinct(generate).sort(inventory);
    }
}
