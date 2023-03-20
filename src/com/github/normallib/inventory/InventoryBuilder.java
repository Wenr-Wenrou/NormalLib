package com.github.normallib.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class InventoryBuilder implements Listener {
    private Map<String, Consumer<InventoryClickEvent>> clickHandlers = new HashMap<>();
    private Map<String, Consumer<InventoryOpenEvent>> openHandlers = new HashMap<>();
    public void register(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    public Inventory createInventory(String title, int rows, Consumer<Inventory> inventoryConsumer) {
        Inventory inventory = Bukkit.createInventory(null, rows * 9, title);
        inventoryConsumer.accept(inventory);
        return inventory;
    }
    public void addClickHandler(String inventoryTitle, Consumer<InventoryClickEvent> clickHandler) {
        clickHandlers.put(inventoryTitle, clickHandler);
    }
    public void addOpenHandler(String inventoryTitle, Consumer<InventoryOpenEvent> openHandler) {
        openHandlers.put(inventoryTitle, openHandler);
    }
    public void openInventory(Player player, Inventory inventory) {
        player.openInventory(inventory);
    }
    @EventHandler
    private void onInventoryClick(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (clickHandlers.containsKey(title)) {
            Consumer<InventoryClickEvent> clickHandler = clickHandlers.get(title);
            clickHandler.accept(event);
        }
    }
    @EventHandler
    private void onInventoryOpen(InventoryOpenEvent event) {
        String title = event.getView().getTitle();
        if (openHandlers.containsKey(title)) {
            Consumer<InventoryOpenEvent> openHandler = openHandlers.get(title);
            openHandler.accept(event);
        }
    }
    public Inventory getPlayerInventory(Player player) {
        return player.getOpenInventory().getTopInventory();
    }
    public ItemStack getPlayerItem(Player player, int slot) {
        return getPlayerInventory(player).getItem(slot);
    }
    public void setPlayerItem(Player player, int slot, ItemStack item) {
        getPlayerInventory(player).setItem(slot, item);
    }
}
