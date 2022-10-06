package com.onisk.Industry.com.common.itemgroup;
import com.onisk.Industry.com.common.init.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class IndustryGroup extends ItemGroup {
    public static final IndustryGroup industry_group = new IndustryGroup();
    public IndustryGroup() {
        super("industry.Industry_Group");
    }
    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.iron_stick.get());
    }
}