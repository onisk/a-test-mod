package com.onisk.Industry.com.common.init;
import net.minecraft.util.text.NBTTextComponent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class MyForgeEventHandler {
    @SubscribeEvent
    public static void pickItem(EntityItemPickupEvent event){
        System.out.println("a");
    }
}
