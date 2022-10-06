package com.onisk.Industry.com.common.Item.tools.iron_plate_tools;

import com.onisk.Industry.com.common.init.ModItemTier;
import com.onisk.Industry.com.common.itemgroup.IndustryGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;

public class IronPlateShovel extends ShovelItem {
    public IronPlateShovel() {
        super(ModItemTier.IRON_PLATE, 1, -3f, new Item.Properties().group(IndustryGroup.industry_group));
    }
}
