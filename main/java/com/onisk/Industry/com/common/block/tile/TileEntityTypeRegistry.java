package com.onisk.Industry.com.common.block.tile;
import com.onisk.Industry.Utils;
import com.onisk.Industry.com.common.init.BlockRegistry;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
        public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Utils.MOD_ID);
        public static RegistryObject<TileEntityType<Biological_Bait_AttractorTileEntity>> biological_bait_acctactortileentity = TILE_ENTITIES.register("biological_bait_acctactortileentity", () -> TileEntityType.Builder.create(Biological_Bait_AttractorTileEntity::new, BlockRegistry.biological_bait_attractor.get()).build(null));
}
