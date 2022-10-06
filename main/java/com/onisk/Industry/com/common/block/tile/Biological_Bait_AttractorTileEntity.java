package com.onisk.Industry.com.common.block.tile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;

import static java.lang.Math.random;

public class Biological_Bait_AttractorTileEntity extends TileEntity implements ITickableTileEntity {
    private static final int MAX_TIME = 5 * 20;
    private int timer = 0;

    public Biological_Bait_AttractorTileEntity() {
        super(TileEntityTypeRegistry.biological_bait_acctactortileentity.get());
    }

    @Override
    public void tick() {
        if (world != null && !world.isRemote) {
            if (timer == MAX_TIME) {
                PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
                TranslationTextComponent translationTextComponent = new TranslationTextComponent("message.hello_block.hello");
                if (player != null) {
                    player.sendStatusMessage(translationTextComponent, false);
                }
                timer = 0;
            }
            timer++;
        }
    }
//    int time = 40;
//    int count = 0;
//
//    public Biological_Bait_AttractorTileEntity() {
//        super(TileEntityTypeRegistry.biological_bait_acctactortileentity.get());
//    }
//
//    @Override
//    public void tick() {
//        System.out.println(count);
//        if (world != null && !world.isRemote) {
//            if (count >= time) {
//                PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);
//                TranslationTextComponent translationTextComponent = new TranslationTextComponent("message.hello");
//                if (player != null) {
//                    player.sendStatusMessage(translationTextComponent, false);
//                    count = 0;
//                }
//            }else count++;
//        }
}