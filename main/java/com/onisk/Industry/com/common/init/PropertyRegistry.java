package com.onisk.Industry.com.common.init;

import com.onisk.Industry.Utils;
import com.onisk.Industry.com.common.Item.injector.Injector;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PropertyRegistry {
    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemModelsProperties.registerProperty(ItemRegistry.injector.get(), new ResourceLocation(Utils.MOD_ID, "empty"), (itemStack, clientWorld, livingEntity) -> (itemStack.getOrCreateTag().getInt(Injector.ISFULL)));
        });
    }
}