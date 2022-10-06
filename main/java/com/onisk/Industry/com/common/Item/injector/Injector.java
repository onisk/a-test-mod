package com.onisk.Industry.com.common.Item.injector;
import com.onisk.Industry.com.common.itemgroup.IndustryGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.transform.Translate;
import net.java.games.input.Controller;
import net.java.games.input.Keyboard;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.LanguageMap;
import net.minecraft.util.text.NBTTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nullable;
import java.util.List;

import static sun.audio.AudioPlayer.player;

public class Injector extends Item {
        public static String INJECT_CONTAINS = "injector_contains";
        public static String ISFULL = "injector_isfull";
        public Injector() {
                super(new Properties().group(IndustryGroup.industry_group).maxStackSize(1));
        }

        @Override
        public ActionResult onItemRightClick(World worldIn, PlayerEntity playerIn, Hand hand) {
                ItemStack stack = playerIn.getHeldItem(hand);
                if (hand != Hand.MAIN_HAND ) return new ActionResult<ItemStack>(ActionResultType.PASS, stack);
                if (!playerIn.world.isRemote) return new ActionResult<ItemStack>(ActionResultType.FAIL, stack);
                if (!isNameExisit(stack)) return new ActionResult<ItemStack>(ActionResultType.FAIL, stack);
                EntityRayTraceResult result = ProjectileHelper.rayTraceEntities(playerIn , playerIn.getPositionVec().add(0,2,0),playerIn.getPositionVec().add(playerIn.getLookVec().mul(5,5,5)),  new AxisAlignedBB(playerIn.getPosX()-2, playerIn.getPosY()-2, playerIn.getPosZ()-2, playerIn.getPosX()+2, playerIn.getPosY()+2, playerIn.getPosZ()+2).grow(2), e -> e instanceof AnimalEntity , 5);
                if (result == null) return new ActionResult<ItemStack>(ActionResultType.FAIL,stack);
                Entity target = result.getEntity();
                if(!(target instanceof AnimalEntity)) return new ActionResult<ItemStack>(ActionResultType.FAIL, stack);
                final AnimalEntity animal = (AnimalEntity) target;
                if (animal.getHealth() <= 1.0F)
                        return new ActionResult<ItemStack>(ActionResultType.FAIL, stack);
                animal.attackEntityFrom(DamageSource.GENERIC, 1.0F);
                final CompoundNBT tag = stack.getOrCreateTag();
                tag.putString(INJECT_CONTAINS , target.getEntityString());
                tag.putInt(ISFULL, 1);
                return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
        }
        public static Boolean isNameExisit(ItemStack stack){
                return stack.getOrCreateTag().isEmpty();
        }
        public static String getName(ItemStack stack , PlayerEntity player){
                String name = stack.getTag().getString(INJECT_CONTAINS);
                return name;
        }
        @Override
        public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> list, ITooltipFlag flagIn) {
                super.addInformation(stack, worldIn, list, flagIn);
                list.add(new TranslationTextComponent("tooltip.injector_entity"));
                if(!isNameExisit(stack)) list.add(new TranslationTextComponent(stack.getTag().getString(INJECT_CONTAINS)));
                else list.add(new TranslationTextComponent("tooltip.injector_empty"));
        }



//        @Override
//        public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
//                if (!(entityIn instanceof PlayerEntity) || !isSelected) return;
//                final PlayerEntity player = (PlayerEntity) entityIn;
//                if (worldIn.isRemote) return;
//                if (player.getHeldItemMainhand() != stack)
//                        player.sendStatusMessage(new TranslationTextComponent("msg.industry.injector.hand"), true);
//                final CompoundNBT tag = stack.getOrCreateTag();
//                final int anim = tag.getInt(ISFULL);
//                System.out.println(tag);
//                if (anim == 0) return;
//                tag.putInt(ISFULL, tag.getInt(ISFULL) + 1);
//
//
//                if (anim == 200) {
//                        player.inventory.mainInventory.set(itemSlot, Items.APPLE.getDefaultInstance());
//                }
                //stack.damageItem(1, player, e -> e.sendBreakAnimation(Hand.MAIN_HAND));
}