package com.onisk.Industry.com.common.init;
import com.onisk.Industry.Utils;
import com.onisk.Industry.com.common.Item.injector.Injector;
import com.onisk.Industry.com.common.Item.resources.IronPlate;
import com.onisk.Industry.com.common.Item.resources.IronStick;
import com.onisk.Industry.com.common.Item.tools.iron_plate_tools.IronPlateShovel;
import com.onisk.Industry.com.common.itemgroup.IndustryGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);
        public static final RegistryObject<Item> iron_stick = ITEMS.register("iron_stick" , IronStick::new);
        public static final RegistryObject<Item> iron_plate = ITEMS.register("iron_plate" , IronPlate::new);
        public static final RegistryObject<Item> injector = ITEMS.register("injector" , Injector::new);
        //Items
        public static final RegistryObject<Item> steel_block = ITEMS.register("steel_block", () -> new BlockItem(BlockRegistry.steel_block.get(), new Item.Properties().group(IndustryGroup.industry_group)));
        public static final RegistryObject<Item> biological_bait_attractor = ITEMS.register("biological_bait_attractor", () -> new BlockItem(BlockRegistry.biological_bait_attractor.get(), new Item.Properties().group(IndustryGroup.industry_group)));
        //Blocks
        public static final RegistryObject<Item> iron_plate_sholve = ITEMS.register("iron_plate_shovel", IronPlateShovel::new);
        //Tools
}

