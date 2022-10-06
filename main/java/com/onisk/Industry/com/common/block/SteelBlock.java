package com.onisk.Industry.com.common.block;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SteelBlock extends Block {
    public SteelBlock() {
        super(Properties.create(Material.SAND).hardnessAndResistance(5));
    }
}
