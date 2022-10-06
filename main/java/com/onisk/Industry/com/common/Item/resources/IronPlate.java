package com.onisk.Industry.com.common.Item.resources;
import com.onisk.Industry.com.common.itemgroup.IndustryGroup;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.property.Properties;

public class IronPlate extends Item{
    public IronPlate() {
        super(new Properties().group(IndustryGroup.industry_group));
    }
}
