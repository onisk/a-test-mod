package com.onisk.Industry.com.common.init;

import com.onisk.Industry.Utils;
import com.onisk.Industry.com.common.block.Biological_Bait_Attractor;
import com.onisk.Industry.com.common.block.SteelBlock;
import com.onisk.Industry.com.common.block.tile.Biological_Bait_AttractorTileEntity;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
      public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils.MOD_ID);
      public static final RegistryObject<Block> steel_block = BLOCKS.register("steel_block", SteelBlock::new);
      public static final RegistryObject<Block> biological_bait_attractor = BLOCKS.register("biological_bait_attractor" , Biological_Bait_Attractor::new);
}
