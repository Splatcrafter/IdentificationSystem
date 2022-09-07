package de.splatgames.identification.utils;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
    private ItemStack item;

    /**
     * Create an ItemBuilder instance
     *
     * @param mat Material of the item
     */
    public ItemBuilder(Material mat) {
        this.item = new ItemStack(mat);
    }

    /**
     * Create an ItemBuilder instance using an existing item stack
     */
    public ItemBuilder(ItemStack item) {
        this.item = item;
    }

    /**
     * Use ItemStack.setAmount() on item
     *
     * @param amount Item amount
     * @return ItemBuilder object
     */
    public ItemBuilder setAmount(Integer amount) {
        this.item.setAmount(amount);
        return this;
    }


    /**
     * Use ItemStack.setDurability() on item
     *
     * @param data Item durability
     * @return ItemBuilder object
     */
    public ItemBuilder setDurability(Byte data) {
        this.item.setDurability(data);
        return this;
    }

    /**
     * Use ItemMeta.setDisplayName() on item
     *
     * @param name Item name
     * @return ItemBuilder object
     */
    public ItemBuilder setName(String name) {
        ItemMeta meta = this.item.getItemMeta();
        meta.setDisplayName(name);
        this.item.setItemMeta(meta);
        return this;
    }

    /**
     * Use ItemMeta.setLore() on item
     *
     * @param lorestr Item lore
     * @return Item Builder object
     */
    public ItemBuilder setLore(String lorestr) {
        ItemMeta meta = this.item.getItemMeta();
        List<String> lore = new ArrayList<String>();
        lore.add(lorestr);
        meta.setLore(lore);
        this.item.setItemMeta(meta);
        return this;
    }

    /**
     * Use ItemMeta.setLore() on item
     *
     * @param lore Item lore
     * @return Item Builder object
     */
    public ItemBuilder setLore(List<String> lore) {
        ItemMeta meta = this.item.getItemMeta();
        meta.setLore(lore);
        this.item.setItemMeta(meta);
        return this;
    }


    /**
     * Use ItemMeta.setLore() on item with color codes in lore
     *
     * @param lorestr Item lore with color codes to be translated
     * @return Item Builder object
     */
    public ItemBuilder setLoreFormatted(String lorestr) {
        List<String> loreFormatted = new ArrayList<String>();
        loreFormatted.add(ChatColor.translateAlternateColorCodes('&', lorestr));
        ItemMeta meta = this.item.getItemMeta();
        meta.setLore(loreFormatted);
        this.item.setItemMeta(meta);
        return this;
    }


    /**
     * Use ItemMeta.setLore() on item with color codes in lore
     *
     * @param lore Item lore with color codes to be translated
     * @return Item Builder object
     */
    public ItemBuilder setLoreFormatted(List<String> lore) {
        List<String> loreFormatted = new ArrayList<String>();
        for (String loreLine : lore) {
            loreFormatted.add(ChatColor.translateAlternateColorCodes('&', loreLine));
        }
        ItemMeta meta = this.item.getItemMeta();
        meta.setLore(loreFormatted);
        this.item.setItemMeta(meta);
        return this;
    }

    /**
     * Use SkullMeta.setOwner() on a skull
     *
     * @param owner The owner of that skull
     * @return Builder object
     */
    public ItemBuilder setOwner(String owner) {
        if (this.item.getType() != Material.SKULL_ITEM || this.item.getDurability() != (byte) 3) {
            return this;
        }
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(owner);
        this.item.setItemMeta(meta);
        return this;
    }

    /**
     * Get the finished item
     *
     * @return ItemStack object
     */
    public ItemStack build() {
        return this.item;
    }
}
