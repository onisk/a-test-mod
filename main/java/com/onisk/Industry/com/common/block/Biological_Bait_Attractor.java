package com.onisk.Industry.com.common.block;

import com.onisk.Industry.com.common.block.tile.Biological_Bait_AttractorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class Biological_Bait_Attractor extends Block {
    public Biological_Bait_Attractor(){
        super(Properties.create(Material.ROCK).hardnessAndResistance(5));
    }

//    @Override
//    public boolean hasTileEntity(BlockState state) {
//        return true;
//    }
//
//    @Nullable
//    @Override
//    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
//        return new Biological_Bait_AttractorTileEntity();
//    }
}
