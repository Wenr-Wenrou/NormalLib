package com.github.normallib.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
    private ItemStack item;

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
    }

    public ItemBuilder(Material material, int amount) {
        this.item = new ItemStack(material, amount);
    }

    public ItemBuilder selectItem(ItemStack item) {
        this.item = item;
        return this;
    }

    public ItemBuilder withName(String name) {
        modifyMeta(meta -> meta.setDisplayName(name));
        return this;
    }

    public ItemBuilder withLore(String... lore) {
        modifyMeta(meta -> meta.setLore(Arrays.asList(lore)));
        return this;
    }

    public ItemBuilder withData(int data) {
        item.setDurability((short) data);
        return this;
    }

    public ItemBuilder withDurability(short durability) {
        item.setDurability(durability);
        return this;
    }

    public ItemBuilder modifyMeta(Consumer<ItemMeta> metaConsumer) {
        ItemMeta meta = item.getItemMeta();
        metaConsumer.accept(meta);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder modifyItem(Consumer<ItemStack> itemConsumer) {
        itemConsumer.accept(item);
        return this;
    }

    public ItemStack build() {
        if (item == null) {
            throw new NullPointerException("Item cannot be null.");
        }
        return item;
    }

    public ItemBuilder changeName(String name) {
        modifyMeta(meta -> meta.setDisplayName(name));
        return this;
    }

    public ItemBuilder changeLore(List<String> lore) {
        modifyMeta(meta -> meta.setLore(lore));
        return this;
    }

    public ItemBuilder setLoreLine(int line, String lore) {
        modifyLore(lines -> {
            while (lines.size() < line + 1) {
                lines.add("");
            }
            lines.set(line, lore);
        });
        return this;
    }

    public ItemBuilder removeLoreLine(int line) {
        modifyLore(lines -> {
            if (lines.size() > line) {
                lines.remove(line);
            }
        });
        return this;
    }

    public ItemBuilder modifyLore(Consumer<List<String>> loreConsumer) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        if (lore == null) {
            lore = new ArrayList<>();
        }
        loreConsumer.accept(lore);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder modifyMatchingLore(String match, Consumer<String> loreConsumer) {
        modifyLore(lines -> {
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.contains(match)) {
                    loreConsumer.accept(line);
                    lines.set(i, line);
                }
            }
        });
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
        item.addEnchantment(enchantment, level);
        return this;
    }

    public ItemBuilder setItemFlags(ItemFlag... flags) {
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(flags);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setMaterial(Material material) {
        ItemStack newItem = new ItemStack(material);
        newItem.setItemMeta(item.getItemMeta());
        item = newItem;
        return this;
    }

    public ItemBuilder setUnbreakable(boolean unbreakable) {
        modifyMeta(meta -> meta.setUnbreakable(unbreakable));
        return this;
    }
}
