package com.github.normallib.inventory;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.spigotmc.SupplierUtils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InventorySorter {
    private List<Function<Inventory,Inventory>> functions;
    public InventorySorter(){
        functions = new ArrayList<>();
    }

    /**
     * 去重ItemStack并叠加其物品数量
     *
     * @return 去重ItemStack后的背包
     */
    public InventorySorter distinct(){
        return distinct(true);
    }

    /**
     * 背包的ItemStack去重
     * @param generate 是否允许迭代 即叠加物品数量
     * @return 去重后的背包
     */
    public InventorySorter distinct(boolean generate){
        functions.add(inventory->{
                    Collection<List<ItemStack>> collection = Arrays.stream(inventory.getContents()).collect(Collectors.groupingBy(ItemStack::getItemMeta)).values();
                    Collection<ItemStack> newCollection = new ArrayList<>();
                        for (List<ItemStack> list : collection) {
                            ItemStack is = list.get(0);
                            if(generate) {
                                is.setAmount(list.stream().map(ItemStack::getAmount).reduce(Integer::sum).get());
                            }
                            newCollection.add(is);
                        }
                        inventory.setContents(null);
                        inventory.addItem(newCollection.toArray(new ItemStack[inventory.getSize()]));
                    return inventory;
                }
        );
        return this;
    }

    /**
     * 使用functions对inventory筛选等操作
     * @param inventory 被操作的背包
     * @return 被操作后的背包
     */
    public Inventory sort(Inventory inventory){
        Inventory newInventory = inventory;
        for(Function<Inventory,Inventory> function:functions){
            newInventory = function.apply(newInventory);
        }
        return newInventory;
    }

    /**
     * 暂未完成 筛选模式..
     */
    public enum SortModel{
    }
}
