package com.onisk.Industry.com.common.Item.resources;
import com.onisk.Industry.com.common.itemgroup.IndustryGroup;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class IronStick extends Item {
    public IronStick(){
        super(new Properties().group(IndustryGroup.industry_group));
    }
}

